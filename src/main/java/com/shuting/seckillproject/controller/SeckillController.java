package com.shuting.seckillproject.controller;

import com.shuting.seckillproject.exception.ServiceException;
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
    public void processSeckill(Long id, String userId){
        try{
            seckillService.seckillPro(id, userId);
        }catch (ServiceException e){
            System.out.println(e.getMessage());
        }
    }
}
