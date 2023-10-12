package com.hien.food.exception;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.exception.variant.BusinessException;
import com.hien.food.response.RootResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = IllegalArgumentException.class)
  public RootResponse illegalArgumentExceptionHandler(IllegalArgumentException ex) {
    return RootResponse.builder().code(ResponseConstant.CLIENT_ERROR).message(ex.getMessage())
        .build();
  }

  @ExceptionHandler(value = BusinessException.class)
  public RootResponse businessExceptionHandler(BusinessException ex) {
    return RootResponse.builder().code(ResponseConstant.CLIENT_ERROR).message(ex.getMessage())
        .build();
  }

}
