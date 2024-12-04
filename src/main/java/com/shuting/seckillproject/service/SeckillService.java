package com.shuting.seckillproject.service;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import com.shuting.seckillproject.mapper.SeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SeckillService {
    @Autowired(required = true)
    private SeckillMapper seckillMapper;
}
