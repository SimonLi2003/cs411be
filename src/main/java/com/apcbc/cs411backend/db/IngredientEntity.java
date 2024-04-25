package com.apcbc.cs411backend.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Ingredients")
public record IngredientEntity(
        @Id Long ingredientID,
        @Column String ingredientName,
        @Column String ingredientType
) {
}
