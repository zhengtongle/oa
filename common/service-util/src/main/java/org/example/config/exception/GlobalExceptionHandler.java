package org.example.config.exception;

import org.example.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理
    @ExceptionHandler(Exception.class)
    public Result<Object> error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("全局异常处理");
    }

    @ExceptionHandler(ExampleException.class)
    public Result<Object> error(ExampleException e){
        e.printStackTrace();
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }

}
