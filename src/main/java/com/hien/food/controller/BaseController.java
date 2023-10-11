package com.hien.food.controller;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.response.ResponseBody;
import com.hien.food.response.RootResponse;

public class BaseController {

  public RootResponse success() {
    return new RootResponse();
  }

  public RootResponse success(ResponseBody responseBody) {
    return RootResponse.builder().code(ResponseConstant.SUCCESS).payload(responseBody).build();
  }

}
