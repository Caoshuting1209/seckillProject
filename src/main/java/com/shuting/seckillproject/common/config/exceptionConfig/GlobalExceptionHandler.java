package com.shuting.seckillproject.common.config.exceptionConfig;

import com.shuting.seckillproject.common.http.Constants;
import com.shuting.seckillproject.common.http.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ExcetionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ge = (GlobalException) e;
            return Result.error(ge.getConstants());
        } else if (e instanceof BindException) {
            BindException be = (BindException) e;
            Result result = Result.error(Constants.BINDING_ERROR);
            result.setMsg("Binding error: " + be.getBindingResult().getAllErrors());
            return result;
        }
        return Result.error(Constants.ERROR);
    }

    /**
     * JSR303参数校验全局异常捕捉
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return new Result(Constants.BINDING_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
    }
}
