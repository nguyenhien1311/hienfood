package com.hien.food.util;

import com.hien.food.dto.IngredientDTO;
import com.hien.food.entities.Ingredient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientMapper {

  public static IngredientDTO toDTO(Ingredient ingredient) {
    return IngredientDTO.builder().id(ingredient.getId()).name(ingredient.getName())
        .image(ingredient.getImage()).unit(ingredient.getUnit())
        .ingredientType(TypeMapper.toDTO(ingredient.getIngredientType())).build();
  }

}
