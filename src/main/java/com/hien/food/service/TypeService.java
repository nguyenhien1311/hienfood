package com.hien.food.service;

import com.hien.food.request.type.CreateTypeRequest;
import com.hien.food.request.type.UpdateTypeRequest;
import com.hien.food.response.type.ListTypeResponse;

public interface TypeService {

  ListTypeResponse getAll();

  void createType(CreateTypeRequest request);

  void updateType(String id , UpdateTypeRequest request);

  void deleteType(String id);

}
