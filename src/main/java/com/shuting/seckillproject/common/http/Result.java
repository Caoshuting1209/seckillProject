package com.shuting.seckillproject.common.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;

    public static Result success(Constants constants) {
        return new Result(constants.getCode(), constants.getMsg());
    }

    public static Result error(Constants constants) {
        return new Result(constants.getCode(), constants.getMsg());
    }
}
