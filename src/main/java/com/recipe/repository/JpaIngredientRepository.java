package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Ingredient;

@Repository
public class JpaIngredientRepository implements IngredientRepository {
	
	EntityManager em ;
	
	public JpaIngredientRepository (EntityManager em) {
		this.em = em ;
	}

	@Override
	public void save(Ingredient ing) {
		em.persist(ing);
	}

	@Override
	public Optional<Ingredient> findByMenu(String menu) {
		return Optional.ofNullable(em.find(Ingredient.class, menu));
	}

}
