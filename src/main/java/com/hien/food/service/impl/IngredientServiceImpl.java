package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.IngredientDTO;
import com.hien.food.entities.Ingredient;
import com.hien.food.exception.variant.BusinessException;
import com.hien.food.repository.IngredientRepository;
import com.hien.food.request.ingredient.CreateIngredientRequest;
import com.hien.food.request.ingredient.UpdateIngredientRequest;
import com.hien.food.response.ingredient.ListIngredientResponse;
import com.hien.food.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

  private final IngredientRepository ingredientRepository;

  @Override
  public ListIngredientResponse getAll() {
    List<IngredientDTO> data = ingredientRepository.findAll().stream().map(
        ingredient -> IngredientDTO.builder().id(ingredient.getId()).name(ingredient.getName())
            .image(ingredient.getImage()).unit(ingredient.getUnit()).build()).toList();
    return ListIngredientResponse.builder().data(data).build();
  }

  @Override
  public void createIngredient(CreateIngredientRequest request) {
    Ingredient ingredient = new Ingredient();
    BeanUtils.copyProperties(request, ingredient);
    ingredientRepository.save(ingredient);
  }

  @Override
  public void updateIngredient(String id, UpdateIngredientRequest request) {
    Ingredient ingredient = findOne(id);
    BeanUtils.copyProperties(request, ingredient);
    ingredientRepository.save(ingredient);
  }

  @Override
  public void deleteIngredient(String id) {
    Ingredient ingredient = findOne(id);
    ingredientRepository.delete(ingredient);
  }

  private Ingredient findOne(String id) {
    return ingredientRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new BusinessException(ResponseConstant.INGREDIENT_NOT_FOUND));
  }

}
