package com.shuting.seckillproject.service.impl;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService {
    @Autowired(required = true)
    private GoodsMapper goodsMapper;

    public Goods getGoods(Long goodId) {
        return goodsMapper.findById(goodId);
    }

    public boolean insertGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    public boolean updateGoods() {
        Goods goods = getGoods(3L);
        goods.setGoodId(2L);
        return goodsMapper.updateById(goods) > 0;
    }

    public boolean deleteGoods(Long goodId) {
        return goodsMapper.deleteById(goodId) > 0;
    }
}
