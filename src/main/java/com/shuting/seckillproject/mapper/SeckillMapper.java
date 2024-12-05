package com.shuting.seckillproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.seckillproject.entity.Seckills;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SeckillMapper extends BaseMapper<Seckills> {
    @Select("SELECT * FROM seckill WHERE now() BETWEEN start_time AND end_time and status = 0")
    public List<Seckills> findUnstartSeckill();

    @Select("SELECT * FROM seckill WHERE now() > end_time and status = 1")
    public List<Seckills> findExpireSeckill();

    @Update("UPDATE seckill SET good_id = #{goodId}, good_count = #{goodCount}, start_time = #{startTime}, end_time = #{endTime}, status = #{status}, current_price = #{currentPrice} WHERE id = #{id}")
    public void updateStatus(Seckills seckill);
}
