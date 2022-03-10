package com.recipe.repository;

import java.util.Optional;

import com.recipe.domain.Recipe;


public interface RecipeRepository {
	
	Recipe save(Recipe recipe);
	Optional<Recipe> findByMenu(String menu);

}
