package com.shuting.seckillproject.service.impl;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired(required = true)
    private GoodsMapper goodsMapper;

    @Cacheable(value = "good", key = "#goodId")
    public Goods getGoods(Long goodId) {
        return goodsMapper.findById(goodId);
    }

    public boolean insertGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    public boolean updateGoods() {
        Goods goods = getGoods(1L);
        goods.setStock(10);
        return goodsMapper.updateById(goods) > 0;
    }

    public boolean updateGoodsCount(Long goodId, Integer count) {
        Goods goods = getGoods(goodId);
        goods.setStock(count);
        return goodsMapper.updateById(goods) > 0;
    }

    public boolean deleteGoods(Long goodId) {
        return goodsMapper.delById(goodId);
    }

    public void sellProject(Long goodId){
        Integer count = getGoods(goodId).getStock();
        if(count > 0){
            System.out.println("抢购成功");
            count = count - 1;
            updateGoodsCount(goodId,count);
        }else{
            System.out.println("抢购失败");
        }
    }
}
