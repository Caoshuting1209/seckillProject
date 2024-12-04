package com.shuting.seckillproject.mapper;

import com.shuting.seckillproject.entity.Seckills;

import java.util.List;

public interface SeckillMapper {
    public List<Seckills> findUnstartSeckill();
    public void updateStatus(Seckills seckill);
}
