package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.IngredientDTO;
import com.hien.food.dto.RecipeDTO;
import com.hien.food.dto.RecipeDetailDTO;
import com.hien.food.entities.Category;
import com.hien.food.entities.Ingredient;
import com.hien.food.entities.Recipe;
import com.hien.food.entities.RecipeDetail;
import com.hien.food.repository.IngredientRepository;
import com.hien.food.repository.RecipeDetailRepository;
import com.hien.food.repository.RecipeRepository;
import com.hien.food.request.recipe.CreateRecipeRequest;
import com.hien.food.request.recipe.RecipeDetailParam;
import com.hien.food.request.recipe.UpdateRecipeRequest;
import com.hien.food.response.recipe.ListRecipeResponse;
import com.hien.food.service.CategoryService;
import com.hien.food.service.RecipeService;
import com.hien.food.util.IngredientMapper;
import com.hien.food.util.RecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

  private final RecipeDetailRepository recipeDetailRepository;

  private final IngredientRepository ingredientRepository;

  private final RecipeRepository recipeRepository;

  private final CategoryService categoryService;

  @Override
  public ListRecipeResponse getAll() {
    List<RecipeDTO> data = recipeRepository.findAll().stream().map(RecipeMapper::toDto).toList();
    return ListRecipeResponse.builder().data(data).build();
  }

  @Override
  public void createRecipe(CreateRecipeRequest request) {
    Recipe recipe = new Recipe();
    BeanUtils.copyProperties(request, recipe);
    handleSaving(recipe, request.categoryId(), request.ingredients());
  }

  @Override
  public void updateRecipe(String id, UpdateRecipeRequest request) {
    Recipe recipe = getEntity(id);
    BeanUtils.copyProperties(request, recipe);
    handleSaving(recipe, request.categoryId(), request.ingredients());
  }

  @Override
  public void deleteRecipe(String id) {
    Recipe recipe = getEntity(id);
    recipeRepository.delete(recipe);
  }

  @Override
  public Recipe getEntity(String id) {
    return recipeRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new RuntimeException(ResponseConstant.RECIPE_NOT_FOUND));
  }

  @Override
  public RecipeDetailDTO getDto(String id) {
    Recipe entity = getEntity(id);

    RecipeDetailDTO detailDto = RecipeMapper.toDetailDto(entity);

    List<RecipeDetail> listIngredient =
        recipeDetailRepository.getAllByRecipeId(entity.getId().toString());
    List<IngredientDTO> listIngredientDto = listIngredient.stream().map(recipeDetail -> {
      Ingredient ingredient =
          ingredientRepository.getIngredientById(recipeDetail.getIngredient().getId().toString());
      IngredientDTO dto = IngredientMapper.toDTO(ingredient);
      dto.setAmount(recipeDetail.getAmount());
      return dto;
    }).toList();

    detailDto.setIngredients(listIngredientDto);
    return detailDto;
  }


  private void handleSaving(Recipe recipe, String categoryId, List<RecipeDetailParam> ingredients) {
    List<RecipeDetail> details = new ArrayList<>();
    Category category = categoryService.getEntity(categoryId);
    recipe.setCategory(category);
    Recipe savedRecipe = recipeRepository.save(recipe);
    if (!ingredients.isEmpty()) {
      ingredients.forEach(recipeDetail -> {
        Ingredient ingredient = ingredientRepository.getIngredientById(recipeDetail.ingredientId());
        RecipeDetail detail = new RecipeDetail();
        detail.setIngredient(ingredient);
        detail.setAmount(recipeDetail.amount());
        detail.setRecipe(savedRecipe);
        details.add(detail);
      });
      recipeDetailRepository.deleteAllByRecipe(savedRecipe);
      recipeDetailRepository.saveAll(details);
    }
  }

}
