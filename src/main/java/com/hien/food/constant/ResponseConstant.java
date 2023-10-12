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

  /*
   * Type create successfully
   */
  public static final String TYPE_CREATE_OK = "Type create successfully";

  /*
   * Type create failed
   */
  public static final String TYPE_CREATE_FAIL = "Type create failed";

  /*
   * Type update successfully
   */
  public static final String TYPE_UPDATE_OK = "Type update successfully";

  /*
   * Type update failed
   */
  public static final String TYPE_UPDATE_FAIL = "Type update failed";

  /*
   * Type delete successfully
   */
  public static final String TYPE_DELETE_OK = "Type delete successfully";

  /*
   * Type delete failed
   */
  public static final String TYPE_DELETE_FAIL = "Type delete failed";

  /*
   * Category create successfully
   */
  public static final String CATEGORY_CREATE_OK = "Category create successfully";

  /*
   * Category create failed
   */
  public static final String CATEGORY_CREATE_FAIL = "Category create failed";

  /*
   * Category update successfully
   */
  public static final String CATEGORY_UPDATE_OK = "Category update successfully";

  /*
   * Category update failed
   */
  public static final String CATEGORY_UPDATE_FAIL = "Category update failed";

  /*
   * Category delete successfully
   */
  public static final String CATEGORY_DELETE_OK = "Category delete successfully";

  /*
   * Category delete failed
   */
  public static final String CATEGORY_DELETE_FAIL = "Category delete failed";

  /*
   * Recipe create successfully
   */
  public static final String RECIPE_CREATE_OK = "Recipe create successfully";

  /*
   * Recipe create failed
   */
  public static final String RECIPE_CREATE_FAIL = "Recipe create failed";

  /*
   * Recipe update successfully
   */
  public static final String RECIPE_UPDATE_OK = "Recipe update successfully";

  /*
   * Recipe update failed
   */
  public static final String RECIPE_UPDATE_FAIL = "Recipe update failed";

  /*
   * Recipe delete successfully
   */
  public static final String RECIPE_DELETE_OK = "Recipe delete successfully";

  /*
   * Recipe delete failed
   */
  public static final String RECIPE_DELETE_FAIL = "Recipe delete failed";

  /*
   * Recipe create successfully
   */
  public static final String INGREDIENT_CREATE_OK = "INGREDIENT create successfully";

  /*
   * INGREDIENT create failed
   */
  public static final String INGREDIENT_CREATE_FAIL = "INGREDIENT create failed";

  /*
   * INGREDIENT update successfully
   */
  public static final String INGREDIENT_UPDATE_OK = "INGREDIENT update successfully";

  /*
   * INGREDIENT update failed
   */
  public static final String INGREDIENT_UPDATE_FAIL = "INGREDIENT update failed";

  /*
   * INGREDIENT delete successfully
   */
  public static final String INGREDIENT_DELETE_OK = "INGREDIENT delete successfully";

  /*
   * INGREDIENT delete failed
   */
  public static final String INGREDIENT_DELETE_FAIL = "INGREDIENT delete failed";

  /*
   * Type not exist or been deleted!
   */
  public static final String TYPE_NOT_FOUND = "Type not exist or been deleted!";

  /*
   * Recipe not exist or been deleted!
   */
  public static final String RECIPE_NOT_FOUND = "Recipe not exist or been deleted!";

  /*
   * Ingredient not exist or been deleted!
   */
  public static final String INGREDIENT_NOT_FOUND = "Ingredient not exist or been deleted!";

  /*
   * Category not exist or been deleted!
   */
  public static final String CATEGORY_NOT_FOUND = "Category not exist or been deleted!";


  //================================ OTHER ================================

}
