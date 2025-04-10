package com.shuting.seckillproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("goods")
public class Goods implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Long goodId;
    private String name;
    private Float originalPrice;
    private Float currentPrice;
    private int freeDelivery;
    private Integer stock;
    private BigDecimal discount;

    public void setDiscount() {
        if (this.originalPrice != null && this.currentPrice != null) {
            BigDecimal bd = new BigDecimal((this.originalPrice - this.currentPrice) / this.originalPrice);
            this.discount = bd.setScale(3, RoundingMode.HALF_UP);
        }
    }
}
