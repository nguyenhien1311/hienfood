package com.hien.food.controller;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.RecipeDetailDTO;
import com.hien.food.request.recipe.CreateRecipeRequest;
import com.hien.food.request.recipe.UpdateRecipeRequest;
import com.hien.food.response.RootResponse;
import com.hien.food.response.recipe.DetailRecipeResponse;
import com.hien.food.response.recipe.ListRecipeResponse;
import com.hien.food.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController extends BaseController {

  private final RecipeService service;

  @GetMapping
  public RootResponse getAll() {
    ListRecipeResponse response = service.getAll();
    return success(response);
  }

  @GetMapping("/{id}")
  public RootResponse getDetail(@PathVariable String id) {
    RecipeDetailDTO data = service.getDto(id);
    DetailRecipeResponse response = DetailRecipeResponse.builder().data(data).build();
    return success(response);
  }

  @PostMapping
  public RootResponse addRecipe(@ModelAttribute CreateRecipeRequest request) {
    service.createRecipe(request);
    return success(ResponseConstant.RECIPE_CREATE_OK);
  }

  @PutMapping("/{id}")
  public RootResponse editRecipe(@PathVariable String id,
      @ModelAttribute UpdateRecipeRequest request) {
    service.updateRecipe(id, request);
    return success(ResponseConstant.RECIPE_UPDATE_OK);
  }

  @DeleteMapping("/{id}")
  public RootResponse deleteRecipe(@PathVariable String id) {
    service.deleteRecipe(id);
    return success(ResponseConstant.RECIPE_DELETE_OK);
  }

}
