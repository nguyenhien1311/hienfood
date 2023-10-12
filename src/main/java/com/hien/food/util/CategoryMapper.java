package com.hien.food.util;

import com.hien.food.dto.CategoryDTO;
import com.hien.food.entities.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryMapper {

  public static CategoryDTO toDto(Category category) {
    return CategoryDTO.builder().id(category.getId()).name(category.getName())
        .image(category.getImage()).build();
  }

}
