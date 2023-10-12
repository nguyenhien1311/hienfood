package com.hien.food.util;

import com.hien.food.dto.TypeDTO;
import com.hien.food.entities.Type;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TypeMapper {

  public static TypeDTO toDTO(Type type) {
    return TypeDTO.builder().id(type.getId()).name(type.getName()).image(type.getImage())
        .build();
  }

}
