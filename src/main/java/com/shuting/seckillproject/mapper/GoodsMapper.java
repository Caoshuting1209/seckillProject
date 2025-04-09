package com.shuting.seckillproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.seckillproject.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT * FROM goods WHERE good_id = #{goodId}")
    Goods findById(Long goodId);

    @Delete("DELETE FROM goods WHERE good_id = #{goodId}")
    boolean delById(Long goodId);
}
