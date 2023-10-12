package com.hien.food.response.recipe;

import com.hien.food.dto.RecipeDetailDTO;
import com.hien.food.response.ResponseBody;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class DetailRecipeResponse extends ResponseBody {

  RecipeDetailDTO data;

}
