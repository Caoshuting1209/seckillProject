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

    @Transactional(rollbackFor = Exception.class)
    public Goods getGoods(Long id) {
        return goodsMapper.findById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Transactional(rollbackFor = Exception.class)
    public Goods updateGoodsName(Long id) {
        Goods goods = getGoods(id);
        goods.setName("newName");
        return goods;
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteGoods(Long id) {
        return goodsMapper.deleteGoods(id);
    }
}
