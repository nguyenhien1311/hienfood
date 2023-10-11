package com.hien.food.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseConstant {

  //================================ CODE ================================

  /*
  * Request success
  */
  public static final int SUCCESS = 200;

  /*
   * Sever side error
   */
  public static final int SEVER_ERROR = 500;

  /*
   * Client side error
   */
  public static final int CLIENT_ERROR = 400;

  //================================ MESSAGE ================================

  private static final String TYPE_CREATE_OK = "Type create successfully";

  private static final String TYPE_CREATE_FAIL = "Type create failed";

  //================================ OTHER ================================

}
