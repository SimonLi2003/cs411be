package com.apcbc.cs411backend.recipe;

import com.apcbc.cs411backend.db.RecipeEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends ListCrudRepository<RecipeEntity, Long> {
    @Query("SELECT * FROM Recipes WHERE recipe_id = :recipeID")
    Optional<RecipeEntity> getRecipeEntityWithID(Long recipeID);

    @Query("SELECT EXISTS(SELECT * FROM Recipes WHERE recipe_name = :recipeName AND recipe_type = :recipeType)")
    boolean doesRecipeAlreadyExist(String recipeName, String recipeType);

    @Query("SELECT * FROM Recipes WHERE LOWER(recipe_name) LIKE CONCAT('%', LOWER(:recipeName), '%')")
    List<RecipeEntity> getRecipeWithRecipeName(String recipeName);

    @Query("SELECT * FROM Recipes WHERE LOWER(recipe_type) LIKE CONCAT('%', LOWER(:recipeType), '%')")
    List<RecipeEntity> getRecipeWithRecipeType(String recipeType);

    @Query("SELECT * FROM Recipes WHERE user_email = :userEmail")
    List<RecipeEntity> getRecipeWithUserEmail(String userEmail);

    @Modifying
    @Query("INSERT INTO Recipes(recipe_id, recipe_name, recipe_type, user_email) VALUES (:recipeID, :recipeName, :recipeType, :userEmail)")
    void insert(Long recipeID, String recipeName, String recipeType, String userEmail);

    @Modifying
    @Query("UPDATE Recipes SET recipe_name = :recipeName WHERE recipe_id = :recipeID")
    void updateRecipeNameWithID(Long recipeID, String recipeName);

    @Modifying
    @Query("UPDATE Recipes SET recipe_type = :recipeType WHERE recipe_id = :recipeID")
    void updateRecipeTypeWithID(Long recipeID, String recipeType);

    @Modifying
    @Query("DELETE FROM Recipes WHERE recipe_id = :recipeID")
    void deleteRecipeByID(Long recipeID);
}
