package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.CategoryDTO;
import com.hien.food.entities.Category;
import com.hien.food.exception.variant.BusinessException;
import com.hien.food.repository.CategoryRepository;
import com.hien.food.request.category.CreateCategoryRequest;
import com.hien.food.request.category.UpdateCategoryRequest;
import com.hien.food.response.category.ListCategoryResponse;
import com.hien.food.service.CategoryService;
import com.hien.food.util.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public ListCategoryResponse getAll() {
    List<CategoryDTO> data =
        categoryRepository.findAll().stream().map(CategoryMapper::toDto).toList();
    return ListCategoryResponse.builder().data(data).build();
  }

  @Override
  public void createCategory(CreateCategoryRequest request) {
    Category category = new Category();
    BeanUtils.copyProperties(request, category);
    categoryRepository.save(category);
  }

  @Override
  public void updateCategory(String id, UpdateCategoryRequest request) {
    Category category = getEntity(id);
    BeanUtils.copyProperties(request, category);
    categoryRepository.save(category);
  }

  @Override
  public void deleteCategory(String id) {
    Category category = getEntity(id);
    categoryRepository.delete(category);
  }

  @Override
  public Category getEntity(String id) {
    return categoryRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new BusinessException(ResponseConstant.CATEGORY_NOT_FOUND));
  }

  @Override
  public CategoryDTO getDto(String id) {
    return getEntity(id).transformToDto();
  }

}
