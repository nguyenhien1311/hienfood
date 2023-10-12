package com.hien.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecipeDetailDTO implements Serializable {

  private UUID id;

  private Integer amount;

  private RecipeDTO recipe;

  private IngredientDTO ingredient;

}
