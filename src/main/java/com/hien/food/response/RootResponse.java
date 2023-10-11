package com.hien.food.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RootResponse {

  private int code;

  private String message;

  private ResponseBody payload;

}
