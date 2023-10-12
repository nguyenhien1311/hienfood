package com.hien.food.service;

import com.hien.food.dto.IngredientDTO;
import com.hien.food.entities.Ingredient;
import com.hien.food.request.ingredient.CreateIngredientRequest;
import com.hien.food.request.ingredient.UpdateIngredientRequest;
import com.hien.food.response.ingredient.ListIngredientResponse;

public interface IngredientService {

  ListIngredientResponse getAll();

  void createIngredient(CreateIngredientRequest request);

  void updateIngredient(String id, UpdateIngredientRequest request);

  void deleteIngredient(String id);

  Ingredient getEntity(String id);

  IngredientDTO getDTO(String id);

}
