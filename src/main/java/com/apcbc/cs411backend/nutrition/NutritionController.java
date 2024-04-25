package com.apcbc.cs411backend.nutrition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
}
