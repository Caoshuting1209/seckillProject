package com.shuting.seckillproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Seckills {
    private Long id;
    private Long goodId;
    private Integer goodCount;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private float currentPrice;
}
