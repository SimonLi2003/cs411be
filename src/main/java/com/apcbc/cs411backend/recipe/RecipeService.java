package com.apcbc.cs411backend.recipe;

import com.apcbc.cs411backend.db.RecipeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    long globalID = 1000L;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {this.recipeRepository = recipeRepository;}

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @Transactional
    public void addNewRecipe(String recipeName,
                             String recipeType,
                             String userEmail) throws IllegalArgumentException {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("recipe name cannot be null / empty!");
        }
        if (recipeType == null || recipeType.isEmpty()) {
            throw new IllegalArgumentException("recipe type cannot be null / empty!");
        }
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("userEmail cannot be null / empty!");
        }
        if (recipeRepository.doesRecipeAlreadyExist(recipeName, recipeType)) {
            return;
        }

        recipeRepository.insert(globalID++, recipeName, recipeType, userEmail);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    public List<RecipeEntity> getAllRecipes(String stringSkipRowsOffset) {
        int skipRowsOffset = Integer.parseInt(stringSkipRowsOffset);
        return recipeRepository.getRecipeEntitiesWithOffsetAndLimit(skipRowsOffset);
    }

    public List<RecipeEntity> getRecipeWithRecipeName(String recipeName) {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("recipe name cannot be null / empty!");
        }

        return recipeRepository.getRecipeWithRecipeName(recipeName);
    }

    public List<RecipeEntity> getRecipeWithType(String recipeType) {
        if (recipeType == null || recipeType.isEmpty()) {
            throw new IllegalArgumentException("recipe type cannot be null / empty");
        }

        return recipeRepository.getRecipeWithRecipeType(recipeType);
    }

    public List<RecipeEntity> getRecipeWithUserEmail(String userEmail) {
        if (userEmail == null || userEmail.isEmpty()) {
            throw new IllegalArgumentException("user email cannot be null / empty");
        }

        return recipeRepository.getRecipeWithUserEmail(userEmail);
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @Transactional
    public void updateRecipeName(Long recipeID, String recipeName) {
        if (recipeName == null || recipeName.isEmpty()) {
            throw new IllegalArgumentException("recipe name cannot be null / empty");
        }

        Optional<RecipeEntity> optionalRecipe = recipeRepository.getRecipeEntityWithID(recipeID);
        if (optionalRecipe.isEmpty()) {throw new IllegalStateException("recipe does not exist!");}

        RecipeEntity recipe = optionalRecipe.get();
        if (recipe.recipeName() != null && recipe.recipeName().equals(recipeName)) {
            return;
        }

        recipeRepository.updateRecipeNameWithID(recipeID, recipeName);
    }

    @Transactional
    public void updateRecipeType(Long recipeID, String recipeType) {
        if (recipeType == null || recipeType.isEmpty()) {
            throw new IllegalArgumentException("recipe type cannot be null / empty");
        }

        Optional<RecipeEntity> optionalRecipe = recipeRepository.getRecipeEntityWithID(recipeID);
        if (optionalRecipe.isEmpty()) {throw new IllegalStateException("recipe does not exist!");}

        RecipeEntity recipe = optionalRecipe.get();
        if (recipe.recipeType() != null && recipe.recipeType().equals(recipeType)) {
            return;
        }

        recipeRepository.updateRecipeTypeWithID(recipeID, recipeType);
    }

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @Transactional
    public void deleteRecipeByID(Long recipeID) {
        recipeRepository.deleteRecipeByID(recipeID);
    }
}
