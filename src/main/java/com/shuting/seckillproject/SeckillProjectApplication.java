package com.shuting.seckillproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuting.seckillproject.mapper")
public class SeckillProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProjectApplication.class, args);
    }

}
