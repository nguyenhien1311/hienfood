package com.hien.food.repository;

import com.hien.food.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

  @Query(value = "SELECT * From ingredients  as i where i.id LIKE CONCAT('%', :id, '%' )",
      nativeQuery = true)
  Ingredient getIngredientById(@Param("id") String id);

}
