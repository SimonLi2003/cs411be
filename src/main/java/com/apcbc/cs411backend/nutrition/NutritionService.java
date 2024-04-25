package com.apcbc.cs411backend.nutrition;

import com.apcbc.cs411backend.db.NutritionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NutritionService {
    private final NutritionRepository nutritionRepository;

    @Autowired
    public NutritionService(NutritionRepository nutritionRepository) {
        this.nutritionRepository = nutritionRepository;
    }

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @Transactional
    public void addNutritionGivenRecipeID(Long recipeID, double calorie, int carbonHydrate, double fat) {
        nutritionRepository.insert(recipeID, calorie, carbonHydrate, fat);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    public List<NutritionEntity> getAllNutrition() {
        return nutritionRepository.getAllNutrition();
    }

    public NutritionEntity getNutritionWithRecipeID(Long recipeID) {
        return nutritionRepository.getNutritionEntityWithRecipeID(recipeID);
    }

    public double getCalorieWithRecipeID(Long recipeID) {
        return nutritionRepository.getCalorieWithRecipeID(recipeID);
    }

    public int getCarbonHydrateWithRecipeID(Long recipeID) {
        return nutritionRepository.getCarbonHydrateWithRecipeID(recipeID);
    }

    public double getFatWithRecipeID(Long recipeID) {
        return nutritionRepository.getFatWithRecipeID(recipeID);
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @Transactional
    public void updateCalorieWithRecipeID(Long recipeID, double newCalorie) {
        nutritionRepository.updateCalorieWithRecipeID(recipeID, newCalorie);
    }

    @Transactional
    public void updateCarbonHydrateWithRecipeID(Long recipeID, int newCarbonHydrate) {
        nutritionRepository.updateCarbonHydrateWithRecipeID(recipeID, newCarbonHydrate);
    }

    @Transactional
    public void updateFatWithRecipeID(Long recipeID, double newFat) {
        nutritionRepository.updateFatWithRecipeID(recipeID, newFat);
    }
}
