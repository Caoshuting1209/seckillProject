package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.entity.User;
import com.shuting.seckillproject.exception.GlobalException;
import com.shuting.seckillproject.service.impl.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/seckill")
    public Constants processSeckill(Long id, String userName){
        return seckillService.seckillPro(id, userName);
    }
}
