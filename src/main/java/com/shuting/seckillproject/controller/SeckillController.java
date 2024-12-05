package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.exception.SeckillException;
import com.shuting.seckillproject.service.GoodsService;
import com.shuting.seckillproject.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/seckill")
    public Map processSeckill(Long id, String userId){
        Map res = new HashMap();
        try{
            seckillService.seckillPro(id, userId);
            res.put("code", 0);
            res.put("msg", "success");
        }catch(SeckillException e){
            res.put("code", -1);
            res.put("msg", e.getMessage());
        }
        return res;
    }
}
