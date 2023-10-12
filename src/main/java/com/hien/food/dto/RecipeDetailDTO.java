package com.hien.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecipeDetailDTO implements Serializable {

  private UUID id;

  private String name;

  private String image;

  private String description;

  private CategoryDTO category;

  private List<IngredientDTO> ingredients;

}
