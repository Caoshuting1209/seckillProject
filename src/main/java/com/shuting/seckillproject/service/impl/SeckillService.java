package com.shuting.seckillproject.service.impl;

import com.shuting.seckillproject.entity.Seckill;
import com.shuting.seckillproject.exception.ServiceException;
import com.shuting.seckillproject.mapper.SeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {
    @Autowired(required = true)
    private SeckillMapper seckillMapper;
    @Autowired(required = true)
    private RedisTemplate redisTemplate;

    public void seckillPro(Long id, String userId) throws ServiceException {
        Seckill seckill = seckillMapper.selectById(id);
        if(seckill == null){
            throw new ServiceException("0", "seckill is null");
        }
        if(seckill.getStatus() == 0){
            throw new ServiceException("1", "seckill not started");
        }else if (seckill.getStatus() == 2){
            throw new ServiceException("2", "seckill already ended");
        }

        Integer checkGoodId = (Integer)redisTemplate.opsForList().leftPop("seckill:goods:" + seckill.getId());
        if(checkGoodId != null){
            //判断是否已经抢购过
            boolean checkUserId = redisTemplate.opsForSet().isMember("seckill:users:" + seckill.getId(), userId);
            if(!checkUserId){
                System.out. println("Your seckill is successful. Please pay as soon as possible.");
                redisTemplate.opsForSet().add("seckill:users:" + seckill.getId(), userId);
            }else{
                redisTemplate.opsForList().leftPush("seckill:goods:" + seckill.getId(), seckill.getGoodId());
                throw new ServiceException("3", "Please dont't repeat buying.");
            }
        }else{
            throw new ServiceException("4", "All goods are sold out.");
        }
    }
}
