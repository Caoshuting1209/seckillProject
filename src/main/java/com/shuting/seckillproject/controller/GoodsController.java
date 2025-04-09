package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.http.Constants;
import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/good")
    public String goodsName(Long goodId) {
        Goods goods = goodsService.getGoods(goodId);
        return goods.getName();
    }

    @GetMapping("/sell")
    public Result doSell(Long goodId) {
        return goodsService.sellProject(goodId);
    }

    @PostMapping("/insert")
    public Result insert(Goods goods) {
        boolean res = goodsService.insertGoods(goods);
        if (res) {
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
    }

    @PostMapping("/update")
    public Result update(Long goodId, Integer stock) {
        boolean res = goodsService.updateGoodsCount(goodId, stock);
        if (res) {
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
    }

    @DeleteMapping("/delete/{gid}")
    public Result delete(@PathVariable Long gid) {
        boolean res = goodsService.deleteGoods(gid);
        if (res) {
            return Result.success(Constants.SUCCESS);
        } else {
            return Result.success(Constants.ERROR);
        }
    }

}
