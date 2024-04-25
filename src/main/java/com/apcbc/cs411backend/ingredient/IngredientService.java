package com.apcbc.cs411backend.ingredient;

import com.apcbc.cs411backend.db.IngredientEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {this.ingredientRepository = ingredientRepository;}
    Long globalID = 1000L;

    // ==========================================================================================================
    // |                                                CREATE                                                  |
    // ==========================================================================================================
    @Transactional
    public void addNewIngredient(String ingredientName, String ingredientType) {
        if (ingredientName == null || ingredientName.isEmpty()) {
            throw new IllegalArgumentException("ingredient name cannot be null / empty");
        }

        if (ingredientType == null || ingredientType.isEmpty()) {
            throw new IllegalArgumentException("ingredient type cannot be null / empty");
        }

        ingredientRepository.insert(globalID++, ingredientName, ingredientType);
    }

    // ==========================================================================================================
    // |                                                  READ                                                  |
    // ==========================================================================================================
    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.getAllIngredients();
    }

    public IngredientEntity getIngredientWithID(Long ingredientID) {
        Optional<IngredientEntity> optionalIngredient = ingredientRepository.getIngredientEntityWithIngredientID(ingredientID);
        if (optionalIngredient.isEmpty()) {throw new IllegalArgumentException("ingredient id does not exist");}
        return optionalIngredient.get();
    }

    public String getIngredientNameWithID(Long ingredientID) {
        IngredientEntity ingredientEntity = getIngredientWithID(ingredientID);
        return ingredientEntity.ingredientName();
    }

    public String getIngredientTypeWithID(Long ingredientID) {
        IngredientEntity ingredientEntity = getIngredientWithID(ingredientID);
        return ingredientEntity.ingredientType();
    }

    // ==========================================================================================================
    // |                                                 UPDATE                                                 |
    // ==========================================================================================================
    @Transactional
    public void updateIngredientNameWithID(Long ingredientID, String ingredientName) {
        if (ingredientName == null || ingredientName.isEmpty()) {
            throw new IllegalArgumentException("ingredient name cannot be null / empty");
        }

        Optional<IngredientEntity> optionalIngredient = ingredientRepository.getIngredientEntityWithIngredientID(ingredientID);
        if (optionalIngredient.isEmpty()) {throw new IllegalArgumentException("ingredient id does not exist");}

        IngredientEntity ingredient = optionalIngredient.get();
        if (ingredient.ingredientName() != null && ingredient.ingredientName().equals(ingredientName)) {
            return;
        }

        ingredientRepository.updateIngredientNameWithID(ingredientID, ingredientName);
    }

    @Transactional
    public void updateIngredientTypeWithID(Long ingredientID, String ingredientType) {
        if (ingredientType == null || ingredientType.isEmpty()) {
            throw new IllegalArgumentException("ingredient type cannot be null / empty");
        }

        Optional<IngredientEntity> optionalIngredient = ingredientRepository.getIngredientEntityWithIngredientID(ingredientID);
        if (optionalIngredient.isEmpty()) {throw new IllegalArgumentException("ingredient id does not exist");}

        IngredientEntity ingredient = optionalIngredient.get();
        if (ingredient.ingredientType() != null && ingredient.ingredientType().equals(ingredientType)) {
            return;
        }

        ingredientRepository.updateIngredientTypeWithID(ingredientID, ingredientType);
    }

    // ==========================================================================================================
    // |                                                DELETE                                                  |
    // ==========================================================================================================
    @Transactional
    public void deleteIngredientWithID(Long ingredientID) {
        ingredientRepository.deleteIngredientEntityWithID(ingredientID);
    }
}
