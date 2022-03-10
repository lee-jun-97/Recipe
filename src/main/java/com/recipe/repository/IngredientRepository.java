package com.recipe.repository;

import java.util.Optional;

import com.recipe.domain.Ingredient;


public interface IngredientRepository {
	
	Ingredient save(Ingredient ing);
	Optional<Ingredient> findByMenu(String menu);

}
