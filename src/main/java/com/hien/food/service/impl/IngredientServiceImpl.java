package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.IngredientDTO;
import com.hien.food.entities.Ingredient;
import com.hien.food.entities.Type;
import com.hien.food.exception.variant.BusinessException;
import com.hien.food.repository.IngredientRepository;
import com.hien.food.request.ingredient.CreateIngredientRequest;
import com.hien.food.request.ingredient.UpdateIngredientRequest;
import com.hien.food.response.ingredient.ListIngredientResponse;
import com.hien.food.service.IngredientService;
import com.hien.food.service.TypeService;
import com.hien.food.util.IngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

  private final IngredientRepository ingredientRepository;

  private final TypeService typeService;

  @Override
  public ListIngredientResponse getAll() {
    List<IngredientDTO> data =
        ingredientRepository.findAll().stream().map(IngredientMapper::toDTO).toList();
    return ListIngredientResponse.builder().data(data).build();
  }

  @Override
  public void createIngredient(CreateIngredientRequest request) {
    Ingredient ingredient = new Ingredient();
    BeanUtils.copyProperties(request, ingredient);
    Type type = typeService.getEntity(request.typeId());
    ingredient.setIngredientType(type);
    ingredientRepository.save(ingredient);
  }

  @Override
  public void updateIngredient(String id, UpdateIngredientRequest request) {
    Ingredient ingredient = getEntity(id);
    BeanUtils.copyProperties(request, ingredient);
    Type type = typeService.getEntity(request.typeId());
    ingredient.setIngredientType(type);
    ingredientRepository.save(ingredient);
  }

  @Override
  public void deleteIngredient(String id) {
    Ingredient ingredient = getEntity(id);
    ingredientRepository.delete(ingredient);
  }

  @Override
  public Ingredient getEntity(String id) {
    return ingredientRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new BusinessException(ResponseConstant.INGREDIENT_NOT_FOUND));
  }

  @Override
  public IngredientDTO getDTO(String id) {
    return getEntity(id).transformToDTO();
  }

}
