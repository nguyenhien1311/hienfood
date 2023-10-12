package com.hien.food.controller;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.request.type.CreateTypeRequest;
import com.hien.food.request.type.UpdateTypeRequest;
import com.hien.food.response.RootResponse;
import com.hien.food.response.type.ListTypeResponse;
import com.hien.food.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/types")
public class TypesController extends BaseController {

  private final TypeService service;

  @GetMapping
  public RootResponse getAll() {
    ListTypeResponse response = service.getAll();
    return success(response);
  }

  @PostMapping
  public RootResponse addType(@ModelAttribute CreateTypeRequest request) {
    service.createType(request);
    return success(ResponseConstant.TYPE_CREATE_OK);
  }

  @PutMapping("/{id}")
  public RootResponse editType(@PathVariable String id, @ModelAttribute UpdateTypeRequest request) {
    service.updateType(id, request);
    return success(ResponseConstant.TYPE_UPDATE_OK);
  }

  @DeleteMapping("/{id}")
  public RootResponse deleteType(@PathVariable String id) {
    service.deleteType(id);
    return success(ResponseConstant.TYPE_DELETE_OK);
  }

}
