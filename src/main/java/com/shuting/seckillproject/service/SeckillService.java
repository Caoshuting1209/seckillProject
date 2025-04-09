package com.shuting.seckillproject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuting.seckillproject.common.config.exceptionConfig.GlobalException;
import com.shuting.seckillproject.common.http.Constants;
import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.Seckill;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.mapper.SeckillMapper;
import com.shuting.seckillproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class SeckillService {
    @Autowired private SeckillMapper seckillMapper;
    @Autowired private UserMapper userMapper;
    @Autowired private RedisTemplate redisTemplate;

    public Result seckillPro(Integer goodId, String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        if (userMapper.selectOne(queryWrapper) == null) {
            throw new GlobalException(Constants.USER_NOT_REGISTER);
        }
        Seckill seckill = seckillMapper.selectByGoodId(goodId);
        if (seckill == null) {
            throw new GlobalException(Constants.SECKILL_NOT_EXIST);
        }
        if (seckill.getStatus() == 0) {
            throw new GlobalException(Constants.NOT_START_ERROR);
        } else if (seckill.getStatus() == 2) {
            throw new GlobalException(Constants.END_ERROR);
        }

        Integer checkGood = (Integer) redisTemplate.opsForList().leftPop("seckill: " + seckill.getId());
        if (checkGood != null) {
            //判断是否已经抢购过
            boolean checkUserName = redisTemplate.opsForSet().isMember("good: " + seckill.getGoodId() + " user: ", userName);
            if (!checkUserName) {
                redisTemplate.opsForSet().add("good: " + seckill.getGoodId() + " user: ", userName);
                return Result.success(Constants.SUCCESS_BUYING);
            } else {
                redisTemplate.opsForList().leftPush("seckill: " + seckill.getId(), "good: " + seckill.getGoodId());
                throw new GlobalException(Constants.REPEAT_BUYING_ERROR);
            }
        } else {
            throw new GlobalException(Constants.SOLD_OUT_ERROR);
        }
    }
}
