package com.shuting.seckillproject.service;

import com.shuting.seckillproject.common.http.Constants;
import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Cacheable(value = "good", key = "#goodId")
    public Goods getGoods(Long goodId) {
        return goodsMapper.findById(goodId);
    }

    public boolean insertGoods(Goods goods) {
        return goodsMapper.insert(goods) > 0;
    }

    public boolean updateGoodsCount(Long goodId, Integer count) {
        Goods goods = getGoods(goodId);
        goods.setStock(count);
        return goodsMapper.updateById(goods) > 0;
    }

    public boolean deleteGoods(Long goodId) {
        return goodsMapper.delById(goodId);
    }

    public Result sellProject(Long goodId) {
        Integer count = getGoods(goodId).getStock();
        if (count > 0) {
            count = count - 1;
            updateGoodsCount(goodId, count);
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.error(Constants.SOLD_OUT_ERROR);
        }
    }
}
