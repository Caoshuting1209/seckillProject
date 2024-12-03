package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.service.impl.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @DeleteMapping("/delete/{gid}")
    public ResponseEntity<Boolean> Onedelete(@PathVariable Long gid){
        boolean res = goodsService.deleteGoods(gid);
        if(res){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
