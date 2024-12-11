package com.shuting.seckillproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuting.seckillproject.entity.Seckill;
import com.shuting.seckillproject.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE user_name = #{userName}")
    public User selectByName(@Param("userName") String userName);
}
