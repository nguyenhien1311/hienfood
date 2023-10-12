package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.RecipeDTO;
import com.hien.food.entities.Recipe;
import com.hien.food.repository.RecipeRepository;
import com.hien.food.request.recipe.CreateRecipeRequest;
import com.hien.food.request.recipe.UpdateRecipeRequest;
import com.hien.food.response.recipe.ListRecipeResponse;
import com.hien.food.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  @Override
  public ListRecipeResponse getAll() {
    List<RecipeDTO> data = recipeRepository.findAll().stream().map(
        recipe -> RecipeDTO.builder().id(recipe.getId()).name(recipe.getName())
            .image(recipe.getImage()).description(recipe.getDescription()).build()).toList();
    return ListRecipeResponse.builder().data(data).build();
  }

  @Override
  public void createRecipe(CreateRecipeRequest request) {
    Recipe recipe = new Recipe();
    BeanUtils.copyProperties(request, recipe);
    recipeRepository.save(recipe);
  }

  @Override
  public void updateRecipe(String id, UpdateRecipeRequest request) {
    Recipe recipe = findOne(id);
    BeanUtils.copyProperties(request, recipe);
    recipeRepository.save(recipe);
  }

  @Override
  public void deleteRecipe(String id) {
    Recipe recipe = findOne(id);
    recipeRepository.delete(recipe);
  }

  private Recipe findOne(String id) {
    return recipeRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new RuntimeException(ResponseConstant.RECIPE_NOT_FOUND));
  }

}
