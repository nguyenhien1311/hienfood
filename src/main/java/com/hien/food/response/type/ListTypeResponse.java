package com.hien.food.response.type;

import com.hien.food.dto.TypeDTO;
import com.hien.food.response.ResponseBody;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ListTypeResponse extends ResponseBody {

  List<TypeDTO> data;

}
