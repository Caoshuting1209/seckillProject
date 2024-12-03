package com.shuting.seckillproject;

import com.shuting.seckillproject.entity.Goods;
import com.shuting.seckillproject.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeckillProjectApplicationTests {
    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    void contextLoads() {
        List<Goods> goods = goodsMapper.selectList(null);
        goods.forEach(System.out::println);
    }
    @Test
    void insert(){
        Goods goods = new Goods();
        goods.setId(2L);
        goods.setName("phone");
        goods.setOriginalPrice(8700.00F);
        goods.setCurrentPrice(6666.00F);
        goods.setFreeDelivery(1);
        goods.setStock(10);
        goods.setDiscount();
        goodsMapper.insertGoods(goods);
        System.out.println(goods);
    }
}
