package com.hien.food.request.recipe;

import java.util.List;

public record UpdateRecipeRequest(String name, String image, String description, String categoryId,
                                  List<RecipeDetailParam> ingredients) {
}
