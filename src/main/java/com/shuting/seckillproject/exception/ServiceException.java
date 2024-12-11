package com.shuting.seckillproject.exception;

import lombok.Getter;

@Getter
public class ServiceException extends Exception {
    private String code;
    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }
}
