package com.shuting.seckillproject.service;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.entity.Seckills;
import com.shuting.seckillproject.exception.SeckillException;
import com.shuting.seckillproject.mapper.GoodsMapper;
import com.shuting.seckillproject.mapper.SeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {
    @Autowired(required = true)
    private SeckillMapper seckillMapper;
    @Autowired(required = true)
    private RedisTemplate redisTemplate;

    public void seckillPro(Long id, String userId) throws SeckillException {
        Seckills seckill = seckillMapper.selectById(id);
        if(seckill == null){
            throw new SeckillException("seckill is null");
        }
        if(seckill.getStatus() == 0){
            throw new SeckillException("seckill not started");
        }else if (seckill.getStatus() == 2){
            throw new SeckillException("seckill already ended");
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
                throw new SeckillException("Please dont't repeat buying.");
            }
        }else{
            throw new SeckillException("All goods are sold out.");
        }
    }
}
