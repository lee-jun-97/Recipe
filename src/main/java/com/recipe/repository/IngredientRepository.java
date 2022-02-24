package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.vo.IngredientVO;

public interface IngredientRepository extends JpaRepository<IngredientVO, Long>{

}
