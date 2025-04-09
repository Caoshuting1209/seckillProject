package com.shuting.seckillproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.seckillproject.entity.Seckill;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeckillMapper extends BaseMapper<Seckill> {
    @Select("SELECT * FROM seckill WHERE now() BETWEEN start_time AND end_time and status = 0")
    List<Seckill> findUnstartSeckill();

    @Select("SELECT * FROM seckill WHERE status = 1 and (now() > end_time or good_count = 0)")
    List<Seckill> findExpireSeckill();

    @Select("SELECT * FROM seckill WHERE good_id = #{goodId}")
    Seckill selectByGoodId(Integer goodId);

    @Update("UPDATE seckill SET good_id = #{goodId}, good_count = #{goodCount}, start_time = #{startTime}, end_time = #{endTime}, status = #{status}, current_price = #{currentPrice} WHERE id = #{id}")
    void updateStatus(Seckill seckill);
}
