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
public class RecipeDTO implements Serializable {

  private UUID id;

  private String name;

  private String image;

  private String description;

  private CategoryDTO category;

}
