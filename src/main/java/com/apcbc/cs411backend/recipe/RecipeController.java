package com.apcbc.cs411backend.recipe;

import com.apcbc.cs411backend.db.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {this.recipeService = recipeService;}

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @PostMapping("/add")
    public void addNewRecipe(@RequestParam String recipeName,
                             @RequestParam String recipeType,
                             @RequestParam String userEmail) {
        recipeService.addNewRecipe(recipeName, recipeType, userEmail);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    @GetMapping("/allRecipes")
    public List<RecipeEntity> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/getRecipeWithRecipeName")
    public List<RecipeEntity> getRecipeWithIngredientName(@RequestParam String recipeName) {
        return recipeService.getRecipeWithRecipeName(recipeName);
    }

    @GetMapping("/getRecipeWithType")
    public List<RecipeEntity> getRecipeWithType(@RequestParam String recipeType) {
        return recipeService.getRecipeWithType(recipeType);
    }

    @GetMapping("/getRecipeByUserEmail")
    public List<RecipeEntity> getRecipeWithUserEmail(@RequestParam String userEmail) {
        return recipeService.getRecipeWithUserEmail(userEmail);
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @PutMapping("/updateRecipeName")
    public void updateRecipeName(@RequestParam Long recipeID,
                                 @RequestParam String recipeName) {
        recipeService.updateRecipeName(recipeID, recipeName);
    }

    @PutMapping("/updateRecipeType")
    public void updateRecipeType(@RequestParam Long recipeID,
                                 @RequestParam String recipeType) {
        recipeService.updateRecipeType(recipeID, recipeType);
    }

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @DeleteMapping("/deleteRecipeByID")
    public void deleteRecipeByID(@RequestParam Long recipeID) {
        recipeService.deleteRecipeByID(recipeID);
    }
}
