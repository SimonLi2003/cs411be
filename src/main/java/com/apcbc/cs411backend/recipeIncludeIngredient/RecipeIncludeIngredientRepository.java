package com.apcbc.cs411backend.recipeIncludeIngredient;

import com.apcbc.cs411backend.db.IngredientEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIncludeIngredientRepository extends ListCrudRepository<IngredientEntity, Long> {

    @Query("SELECT * " +
            "FROM RecipeIncludesIngredients NATURAL JOIN Ingredients " +
            "WHERE recipe_id = :recipeID")
    List<IngredientEntity> getIngredientsWithRecipeID(Long recipeID);
}
