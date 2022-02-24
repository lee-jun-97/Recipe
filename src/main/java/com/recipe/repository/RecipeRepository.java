package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.vo.RecipeVO;

public interface RecipeRepository extends JpaRepository<RecipeVO, Long>{

}
