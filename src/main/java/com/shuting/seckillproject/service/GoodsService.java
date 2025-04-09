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
    @Autowired private GoodsMapper goodsMapper;

    @Cacheable(value = "good", key = "#goodId")
    public Goods getGoods(Long goodId) {
        return goodsMapper.findById(goodId);
    }

    public Result insertGoods(Goods goods) {
        goods.setDiscount();
        if(goodsMapper.insert(goods) > 0){
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
    }

    public Result updateGoodsCount(Long goodId, Integer count) {
        Goods goods = getGoods(goodId);
        goods.setStock(count);
        if(goodsMapper.updateById(goods) > 0){
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
    }

    public Result deleteGoods(Long goodId) {
        if(goodsMapper.delById(goodId)){
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
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
