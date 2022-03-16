package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Recipe;

@Repository
@Transactional
public class JpaRecipeRepository implements RecipeRepository {
	
	EntityManager em ;
	
	public JpaRecipeRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Recipe recipe) {
		em.persist(recipe);
	}

	@Override
	public Optional<Recipe> findByMenu(String menu) {
		return Optional.ofNullable(em.find(Recipe.class, menu));
	}

}
