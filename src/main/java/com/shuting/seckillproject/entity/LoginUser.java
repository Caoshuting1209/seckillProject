package com.shuting.seckillproject.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUser {
    @NotBlank(message = "Username can't be null")
    private String userName;

    @NotBlank(message = "Password can't be null")
    private String password;
}
