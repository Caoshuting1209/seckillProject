package com.shuting.seckillproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("seckill")
public class Seckills implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long goodId;
    private Integer goodCount;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private float currentPrice;
}
