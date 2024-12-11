package com.shuting.seckillproject.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.constant.Constable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object object;

    public static Result success(){
        return new Result(Constants.SUCCESS.getCode(), Result.success().getMsg(), null);
    }
    public static Result success(Object object){
        return new Result(Constants.SUCCESS.getCode(), Result.success().getMsg(), object);
    }
    public static Result error(Constants constants){
        return new Result(constants.getCode(), constants.getMsg(), null);
    }
    public static Result error(Constants constants, Object object){
        return new Result(constants.getCode(), constants.getMsg(), object);
    }

}
