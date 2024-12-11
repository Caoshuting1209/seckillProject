package com.shuting.seckillproject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.entity.Seckill;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.exception.GlobalException;
import com.shuting.seckillproject.mapper.SeckillMapper;
import com.shuting.seckillproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {
    @Autowired(required = true)
    private SeckillMapper seckillMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired(required = true)
    private RedisTemplate redisTemplate;

    public Constants seckillPro(Long id, String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        if(userMapper.selectOne(queryWrapper) == null){
            throw new GlobalException(Constants.USER_NOT_REGISTER);
        }
        Seckill seckill = seckillMapper.selectById(id);
        if(seckill == null){
            throw new GlobalException(Constants.SECKILL_NOT_EXIST);
        }
        if(seckill.getStatus() == 0){
            throw new GlobalException(Constants.NOT_START_ERROR);
        }else if (seckill.getStatus() == 2){
            throw new GlobalException(Constants.END_ERROR);
        }

        Integer checkGoodId = (Integer)redisTemplate.opsForList().leftPop("seckill:goods:" + seckill.getId());
        if(checkGoodId != null){
            //判断是否已经抢购过
            boolean checkUserName = redisTemplate.opsForSet().isMember("seckill:users:" + seckill.getId(), userName);
            if(!checkUserName){
                System.out. println("Your seckill is successful. Please pay as soon as possible.");
                redisTemplate.opsForSet().add("seckill:users:" + seckill.getId(), userName);
            }else{
                redisTemplate.opsForList().leftPush("seckill:goods:" + seckill.getId(), seckill.getGoodId());
                throw new GlobalException(Constants.REPEAT_BUYING_ERROR);
            }
        }else{
            throw new GlobalException(Constants.SOLD_OUT_ERROR);
        }
        return Constants.SUCCESS;
    }
}
