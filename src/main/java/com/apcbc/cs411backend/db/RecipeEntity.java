package com.apcbc.cs411backend.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Recipes")
public record RecipeEntity(
        @Id Long recipeID,
        @Column String recipeName,
        @Column String recipeType,
        @Column String userEmail
) {
}