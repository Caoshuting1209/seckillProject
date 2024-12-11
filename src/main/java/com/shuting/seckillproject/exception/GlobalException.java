package com.shuting.seckillproject.exception;

import com.shuting.seckillproject.common.Constants;
import com.shuting.seckillproject.common.Result;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.Provider;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException e) {
        return new Result(e.getCode(), e.getMessage(), null);
    }

    /**
     * JSR303参数校验全局异常捕捉
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return new Result(Constants.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage(), null);
    }
}
