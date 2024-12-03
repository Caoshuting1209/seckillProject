package com.shuting.seckillproject.service.impl;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.logging.Logger;

@Service
@Slf4j
public class GoodsService {
    @Autowired(required = true)
    private GoodsMapper goodsMapper;

    private static final Logger logger = Logger.getLogger(GoodsService.class.getName());


    public Goods getGoods(Long goodId) {
        return goodsMapper.findById(goodId);
    }

    public boolean insertGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    public boolean updateGoods() {
        Goods goods = getGoods(2L);
        goods.setGoodId(3L);
        return goodsMapper.updateById(goods) > 0;
    }

    public boolean deleteGoods(Long goodId) {
        return goodsMapper.delById(goodId);
    }
}
