package com.shuting.seckillproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.seckillproject.entity.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    public Goods findById(Long goodId);
    public boolean delById(Long goodId);
}
