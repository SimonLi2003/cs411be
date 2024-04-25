package com.apcbc.cs411backend.ingredient;

import com.apcbc.cs411backend.db.IngredientEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends ListCrudRepository<IngredientEntity, Long> {
    @Query("SELECT * FROM Ingredients")
    List<IngredientEntity> getAllIngredients();

    @Query("SELECT * FROM Ingredients WHERE ingredient_id = :ingredientID")
    Optional<IngredientEntity> getIngredientEntityWithIngredientID(Long ingredientID);

    @Query("INSERT INTO Ingredients(ingredient_id, ingredient_name, ingredient_type) VALUES (:ingredientID, :ingredientName, :ingredientType)")
    void insert(Long ingredientID, String ingredientName, String ingredientType);

    @Modifying
    @Query("UPDATE Ingredients SET ingredient_name = :ingredientName WHERE ingredient_id = :ingredientID")
    void updateIngredientNameWithID(Long ingredientID, String ingredientName);

    @Modifying
    @Query("UPDATE Ingredients SET ingredient_type = :ingredientType WHERE ingredient_id = :ingredientID")
    void updateIngredientTypeWithID(Long ingredientID, String ingredientType);

    @Modifying
    @Query("DELETE FROM Ingredients WHERE ingredient_id = :ingredientID")
    void deleteIngredientEntityWithID(Long ingredientID);
}
