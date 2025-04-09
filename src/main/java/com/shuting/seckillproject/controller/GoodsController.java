package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired private GoodsService goodsService;

    @GetMapping("/good")
    public Goods goodsName(Long goodId) {
        return goodsService.getGoods(goodId);
    }

    @GetMapping("/sell")
    public Result doSell(Long goodId) {
        return goodsService.sellProject(goodId);
    }

    @PostMapping("/insert")
    public Result insert(Goods goods) {
        return goodsService.insertGoods(goods);
    }

    @PostMapping("/update")
    public Result update(Long goodId, Integer stock) {
        return goodsService.updateGoodsCount(goodId, stock);
    }

    @DeleteMapping("/delete")
    public Result delete(Long goodId) {
        return goodsService.deleteGoods(goodId);
    }

}
