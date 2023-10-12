package com.hien.food.response.recipe;

import com.hien.food.dto.RecipeDTO;
import com.hien.food.response.ResponseBody;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ListRecipeResponse extends ResponseBody {

  List<RecipeDTO> data;

}
