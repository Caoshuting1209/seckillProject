package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.service.impl.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class GoodsController {
//    Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public String goodsName(Long goodId){
//        logger.info("goodId: " + goodId);
        Goods goods = goodsService.getGoods(goodId);
        return goods.getName();
    }

    @GetMapping("/sell")
    public String doSell(Long goodId){
        goodsService.sellProject(goodId);
        return "ok";
    }

    @PostMapping("/insert1")
    public ResponseEntity<Boolean> insert1(){
        Goods goods1 = new Goods();
        goods1.setGoodId(1L);
        goods1.setName("phone");
        goods1.setOriginalPrice(8700.00F);
        goods1.setCurrentPrice(6666.00F);
        goods1.setDiscount();
        goods1.setFreeDelivery(1);
        goods1.setStock(10);
        boolean res = goodsService.insertGoods(goods1);
        if(res){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @PostMapping("/update1")
    public ResponseEntity<Boolean> update1(){
        boolean res = goodsService.updateGoods();
        if(res){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @DeleteMapping("/delete/{gid}")
    public ResponseEntity<Boolean> delete1(@PathVariable Long gid){
        boolean res = goodsService.deleteGoods(gid);
        if(res){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

}
