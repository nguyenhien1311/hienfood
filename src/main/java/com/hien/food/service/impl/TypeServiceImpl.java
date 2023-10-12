package com.hien.food.service.impl;

import com.hien.food.constant.ResponseConstant;
import com.hien.food.dto.TypeDTO;
import com.hien.food.entities.Type;
import com.hien.food.exception.variant.BusinessException;
import com.hien.food.repository.TypeRepository;
import com.hien.food.request.type.CreateTypeRequest;
import com.hien.food.request.type.UpdateTypeRequest;
import com.hien.food.response.type.ListTypeResponse;
import com.hien.food.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

  private final TypeRepository typeRepository;

  @Override
  public ListTypeResponse getAll() {
    List<TypeDTO> data = typeRepository.findAll().stream().map(
        type -> TypeDTO.builder().id(type.getId()).name(type.getName()).image(type.getImage())
            .build()).toList();
    return ListTypeResponse.builder().data(data).build();
  }

  @Override
  public void createType(CreateTypeRequest request) {
    Type type = new Type();
    BeanUtils.copyProperties(request, type);
    typeRepository.save(type);
  }

  @Override
  public void updateType(String id, UpdateTypeRequest request) {
    Type type = findOne(id);
    BeanUtils.copyProperties(request, type);
    typeRepository.save(type);
  }

  @Override
  public void deleteType(String id) {
    Type type = findOne(id);
    typeRepository.delete(type);
  }

  private Type findOne(String id) {
    return typeRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new BusinessException(ResponseConstant.TYPE_NOT_FOUND));
  }

}
