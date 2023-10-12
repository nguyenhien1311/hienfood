package com.hien.food.service;

import com.hien.food.request.category.CreateCategoryRequest;
import com.hien.food.request.category.UpdateCategoryRequest;
import com.hien.food.response.category.ListCategoryResponse;

public interface CategoryService {

  ListCategoryResponse getAll();

  void createCategory(CreateCategoryRequest request);

  void updateCategory(String id, UpdateCategoryRequest request);

  void deleteCategory(String id);

}
