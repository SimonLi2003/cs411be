package com.apcbc.cs411backend.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Nutrition")
public record NutritionEntity(
        @Id Long recipeID,
        @Column Double calorie,
        @Column Integer carbonHydrate,
        @Column Double fat
) {
}
