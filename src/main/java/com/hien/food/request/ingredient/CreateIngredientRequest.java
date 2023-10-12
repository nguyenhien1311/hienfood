package com.hien.food.request.ingredient;

import jakarta.validation.constraints.NotBlank;

public record CreateIngredientRequest(
    @NotBlank(message = "{food.ingredient.name.required}")
    String name,
    String image,
    @NotBlank(message = "{food.ingredient.name.required}")
    String unit,
    @NotBlank(message = "{food.ingredient.type.required}")
    String typeId) {
}
