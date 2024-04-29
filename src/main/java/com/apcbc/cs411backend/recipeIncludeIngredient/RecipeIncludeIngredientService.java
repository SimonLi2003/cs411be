package com.apcbc.cs411backend.recipeIncludeIngredient;

import com.apcbc.cs411backend.db.IngredientEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIncludeIngredientService {
    private final RecipeIncludeIngredientRepository recipeIncludeIngredientRepository;

    public RecipeIncludeIngredientService(RecipeIncludeIngredientRepository recipeIncludeIngredientRepository) {
        this.recipeIncludeIngredientRepository = recipeIncludeIngredientRepository;
    }

    public List<IngredientEntity> getIngredientsWithRecipeID(String stringRecipeID) {
        Long recipeID = Long.parseLong(stringRecipeID);
        if (recipeID < 0) throw new IllegalArgumentException("recipeID cannot be negative");

        return recipeIncludeIngredientRepository.getIngredientsWithRecipeID(recipeID);
    }
}
