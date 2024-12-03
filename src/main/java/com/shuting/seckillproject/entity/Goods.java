package com.shuting.seckillproject.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
public class Goods {
    private Long id;
    private String name;
    private Float originalPrice;
    private Float currentPrice;
    private int freeDelivery;
    private Integer stock;
    private BigDecimal discount;
    public void setDiscount() {
        if (this.originalPrice != null && this.currentPrice != null) {
            BigDecimal bd = new BigDecimal((this.originalPrice - this.currentPrice)/ this.currentPrice);
            this.discount = bd.setScale( 3, RoundingMode.HALF_UP);
        }
    }
}
