package com.hien.food.service;

import com.hien.food.request.recipe.CreateRecipeRequest;
import com.hien.food.request.recipe.UpdateRecipeRequest;
import com.hien.food.response.recipe.ListRecipeResponse;

public interface RecipeService {

  ListRecipeResponse getAll();

  void createRecipe(CreateRecipeRequest request);

  void updateRecipe(String id, UpdateRecipeRequest request);

  void deleteRecipe(String id);

}
