package com.recipe.repository;

import java.util.Optional;

import com.recipe.domain.Ingredient;


public interface IngredientRepository {
	
	void save(Ingredient ing);
	Optional<Ingredient> findByMenu(String menu);

}
