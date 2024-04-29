package com.apcbc.cs411backend.nutrition;

import com.apcbc.cs411backend.db.NutritionEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nutrition")
public class NutritionController {
    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {this.nutritionService = nutritionService;}

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    @PostMapping("/getNutritionWithRecipeID")
    public NutritionEntity getNutritionWithRecipeID(@RequestParam String recipeID) {
        return nutritionService.getNutritionWithRecipeID(recipeID);
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
}
