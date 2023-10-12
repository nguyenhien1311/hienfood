package com.hien.food.repository;

import com.hien.food.entities.Recipe;
import com.hien.food.entities.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RecipeDetailRepository extends JpaRepository<RecipeDetail, UUID> {

  @Query(value = "SELECT * FROM recipe_detail as rd WHERE rd.recipe_id LIKE CONCAT('%',:recipe_id,'%')", nativeQuery = true)
  List<RecipeDetail> getAllByRecipeId(@Param("recipe_id") String recipeId);

  void deleteAllByRecipe(Recipe recipe);

}
