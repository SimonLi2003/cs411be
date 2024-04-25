package com.apcbc.cs411backend;

import com.apcbc.cs411backend.ingredient.IngredientRepository;
import com.apcbc.cs411backend.market.MarketRepository;
import com.apcbc.cs411backend.nutrition.NutritionRepository;
import com.apcbc.cs411backend.recipe.RecipeRepository;
import com.apcbc.cs411backend.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DevTest implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(DevTest.class);

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final NutritionRepository nutritionRepository;
    private final MarketRepository marketRepository;
    private final IngredientRepository ingredientRepository;


    @Autowired
    public DevTest(UserRepository userRepository,
                   RecipeRepository recipeRepository,
                   NutritionRepository nutritionRepository,
                   MarketRepository marketRepository,
                   IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.nutritionRepository = nutritionRepository;
        this.marketRepository = marketRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
//        userRepository.insert(1L, "van@qq.com", "shit", "ohh");
//        userRepository.insert(2L, "simonli666@qq.com", "apcbc", "fuck");
//
//        recipeRepository.insert(1L, "applewood steak", "lunch", "simonli666@qq.com");
//        recipeRepository.insert(2L, "Curry", "lunch", "simonli666@qq.com");
    }
}
