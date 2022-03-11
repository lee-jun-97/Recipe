package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Recipe;

@Repository
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
