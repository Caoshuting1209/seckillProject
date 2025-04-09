package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.http.Result;
import com.shuting.seckillproject.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/seckill")
    public Result processSeckill(Integer goodId, String userName) {
        return seckillService.seckillPro(goodId, userName);
    }
}
