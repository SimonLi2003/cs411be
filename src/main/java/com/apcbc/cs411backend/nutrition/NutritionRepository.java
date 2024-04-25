package com.apcbc.cs411backend.nutrition;

import com.apcbc.cs411backend.db.NutritionEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionRepository extends ListCrudRepository<NutritionEntity, Long> {
    @Query("SELECT * FROM Nutrition")
    List<NutritionEntity> getAllNutrition();

    @Query("SELECT * FROM Nutrition WHERE recipe_id = :recipeID")
    NutritionEntity getNutritionEntityWithRecipeID(Long recipeID);

    @Query("SELECT calorie FROM Nutrition WHERE recipe_id = :recipeID")
    double getCalorieWithRecipeID(Long recipeID);

    @Query("SELECT carbon_hydrate FROM Nutrition WHERE recipe_id = :recipeID")
    int getCarbonHydrateWithRecipeID(Long recipeID);

    @Query("SELECT fat FROM Nutrition WHERE recipe_id = :recipeID")
    double getFatWithRecipeID(Long recipeID);

    @Modifying
    @Query("UPDATE Nutrition SET calorie = :newCalorie WHERE recipe_id = :recipeID")
    void updateCalorieWithRecipeID(Long recipeID, double newCalorie);

    @Modifying
    @Query("UPDATE Nutrition SET carbon_hydrate = :newCarbonHydrate WHERE recipe_id = :recipeID")
    void updateCarbonHydrateWithRecipeID(Long recipeID, int newCarbonHydrate);

    @Modifying
    @Query("UPDATE Nutrition SET fat = :newFat WHERE recipe_id = :recipeID")
    void updateFatWithRecipeID(Long recipeID, double newFat);

    @Modifying
    @Query("INSERT INTO Nutrition(recipe_id, calorie, carbon_hydrate, fat) VALUES (:recipeId, :calorie, :carbonHydrate, :fat)")
    void insert(@Param("recipeId") Long recipeId, @Param("calorie") Double calorie, @Param("carbonHydrate") Integer carbonHydrate, @Param("fat") Double fat);
}
