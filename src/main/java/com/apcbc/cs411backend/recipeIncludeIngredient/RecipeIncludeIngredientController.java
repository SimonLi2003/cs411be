package com.apcbc.cs411backend.recipeIncludeIngredient;

import com.apcbc.cs411backend.db.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipeIncludeIngredient")
public class RecipeIncludeIngredientController {
    private final RecipeIncludeIngredientService recipeIncludeIngredientService;

    @Autowired
    public RecipeIncludeIngredientController(RecipeIncludeIngredientService recipeIncludeIngredientService) {
        this.recipeIncludeIngredientService = recipeIncludeIngredientService;
    }

    @PostMapping("/getIngredientsWithRecipeID")
    public List<IngredientEntity> getIngredientsWithRecipeID(@RequestParam String recipeID) {
        return recipeIncludeIngredientService.getIngredientsWithRecipeID(recipeID);
    }
}
