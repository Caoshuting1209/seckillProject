package com.shuting.seckillproject.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Constants {
    SUCCESS("200", "success"),
    ERROR("500", "error"),
    PARAM_ERROR("400", "param error"),

    //login error
    LOGIN_ERROR("300", "User name or password is empty"),
    USER_NOT_EXIST("301", "User name doesn't exist"),
    PASSWORD_ERROR("302", "Password is wrong"),

    //register error
    USER_ALREADY_EXIST("303", "User already exist"),
    ;

    private String code;
    private String msg;
}
