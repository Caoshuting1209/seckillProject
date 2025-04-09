package com.shuting.seckillproject.common.http;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Constants {
    SUCCESS("200", "success"),
    SUCCESS_BUYING("201", "successful buying"),
    ERROR("500", "error"),
    BINDING_ERROR("800", "binding error"),

    //login error
    LOGIN_ERROR("300", "User name or password is empty"),
    USER_NOT_EXIST("301", "User name doesn't exist"),
    PASSWORD_ERROR("302", "Password is wrong"),

    //register error
    USER_ALREADY_EXIST("303", "User already exist"),

    //seckill error
    SECKILL_NOT_EXIST("304", "Seckill not exist"),
    SOLD_OUT_ERROR("305", "All goods are sold out"),
    END_ERROR("306", "Seckill already ends"),
    NOT_START_ERROR("307", "Seckill does not start"),
    REPEAT_BUYING_ERROR("308", "Please don't repeat buying"),
    USER_NOT_REGISTER("309", "User does not register"),
    ;

    private String code;
    private String msg;
}
