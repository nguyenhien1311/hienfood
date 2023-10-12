package com.hien.food.response.ingredient;

import com.hien.food.dto.IngredientDTO;
import com.hien.food.response.ResponseBody;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ListIngredientResponse extends ResponseBody {

  List<IngredientDTO> data;

}
