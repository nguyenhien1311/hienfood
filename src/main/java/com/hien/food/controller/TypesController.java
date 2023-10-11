package com.hien.food.controller;

import com.hien.food.entities.Type;
import com.hien.food.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/type")
public class TypesController extends BaseController {

  private final TypeRepository typeRepository;

  @GetMapping
  public List<Type> getAll() {
    List<Type> all = typeRepository.findAll();
    return all;
  }


}
