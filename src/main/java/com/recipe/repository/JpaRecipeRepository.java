package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import com.recipe.domain.Recipe;

public class JpaRecipeRepository implements RecipeRepository {
	
	EntityManager em ;
	
	public JpaRecipeRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Recipe save(Recipe recipe) {
		em.persist(recipe);
		return recipe;
	}

	@Override
	public Optional<Recipe> findByMenu(String menu) {
		return Optional.ofNullable(em.find(Recipe.class, menu));
	}

}
