package com.hien.food.controller;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.request.category.CreateCategoryRequest;
import com.hien.food.request.category.UpdateCategoryRequest;
import com.hien.food.response.RootResponse;
import com.hien.food.response.category.ListCategoryResponse;
import com.hien.food.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {

  private final CategoryService service;

  @GetMapping
  public RootResponse getAll() {
    ListCategoryResponse response = service.getAll();
    return success(response);
  }

  @PostMapping
  public RootResponse addCategory(@ModelAttribute CreateCategoryRequest request) {
    service.createCategory(request);
    return success(ResponseConstant.CATEGORY_CREATE_OK);
  }

  @PutMapping("/{id}")
  public RootResponse editCategory(@PathVariable String id,
      @ModelAttribute UpdateCategoryRequest request) {
    service.updateCategory(id, request);
    return success(ResponseConstant.CATEGORY_UPDATE_OK);
  }

  @DeleteMapping("/{id}")
  public RootResponse deleteCategory(@PathVariable String id) {
    service.deleteCategory(id);
    return success(ResponseConstant.CATEGORY_DELETE_OK);
  }

}
