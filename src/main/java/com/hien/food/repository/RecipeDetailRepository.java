package com.hien.food.repository;

import com.hien.food.entities.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeDetailRepository extends JpaRepository<RecipeDetail, UUID> {
}
