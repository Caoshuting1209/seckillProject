package com.shuting.seckillproject.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String salt;
    private String head;

    @TableField(fill = FieldFill.INSERT)
    private Date registerTime;
}
