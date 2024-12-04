package com.shuting.seckillproject.scheduler;

import com.shuting.seckillproject.entity.Seckills;
import com.shuting.seckillproject.mapper.SeckillMapper;
import com.shuting.seckillproject.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeckillTask {
    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    public void startSeckill(){
        List<Seckills> list = seckillMapper.findUnstartSeckill();
        for (Seckills seckill : list) {
            System.out.println(seckill.getId() + "号商品秒杀已启动");
            for(int i =0; i < seckill.getGoodCount(); i++){
                redisTemplate.opsForList().rightPush("seckill:count:" + seckill.getId(), seckill.getGoodId());
            }
            seckill.setStatus(1);
            seckillMapper.updateStatus(seckill);
        }
    }
}
