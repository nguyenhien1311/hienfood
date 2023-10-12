package com.hien.food.controller;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.request.ingredient.CreateIngredientRequest;
import com.hien.food.request.ingredient.UpdateIngredientRequest;
import com.hien.food.response.RootResponse;
import com.hien.food.response.ingredient.ListIngredientResponse;
import com.hien.food.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController extends BaseController {

  private final IngredientService service;

  @GetMapping
  public RootResponse getAll() {
    ListIngredientResponse response = service.getAll();
    return success(response);
  }

  @PostMapping
  public RootResponse addIngredient(@ModelAttribute CreateIngredientRequest request) {
    service.createIngredient(request);
    return success(ResponseConstant.INGREDIENT_CREATE_OK);
  }

  @PutMapping("/{id}")
  public RootResponse editIngredient(@PathVariable String id,
      @ModelAttribute UpdateIngredientRequest request) {
    service.updateIngredient(id, request);
    return success(ResponseConstant.INGREDIENT_UPDATE_OK);
  }

  @DeleteMapping("/{id}")
  public RootResponse deleteIngredient(@PathVariable String id) {
    service.deleteIngredient(id);
    return success(ResponseConstant.INGREDIENT_DELETE_OK);
  }

}
