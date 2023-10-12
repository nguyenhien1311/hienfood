package com.hien.food.util;

import com.hien.food.dto.RecipeDTO;
import com.hien.food.dto.RecipeDetailDTO;
import com.hien.food.entities.Recipe;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RecipeMapper {

  public static RecipeDTO toDto(Recipe recipe) {
    return RecipeDTO.builder().id(recipe.getId()).name(recipe.getName()).image(recipe.getImage())
        .category(CategoryMapper.toDto(recipe.getCategory())).description(recipe.getDescription())
        .build();
  }

  public static RecipeDetailDTO toDetailDto(Recipe recipe) {
    return RecipeDetailDTO.builder().id(recipe.getId()).name(recipe.getName())
        .image(recipe.getImage()).category(CategoryMapper.toDto(recipe.getCategory()))
        .description(recipe.getDescription()).build();
  }

}
