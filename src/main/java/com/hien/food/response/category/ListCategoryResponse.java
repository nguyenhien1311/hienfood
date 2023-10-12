package com.hien.food.response.category;

import com.hien.food.dto.CategoryDTO;
import com.hien.food.response.ResponseBody;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ListCategoryResponse extends ResponseBody {

  List<CategoryDTO> data;

}
