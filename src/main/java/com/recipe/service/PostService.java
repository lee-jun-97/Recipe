package com.recipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.repository.IngredientRepository;
import com.recipe.repository.PostRepository;
import com.recipe.repository.RecipeRepository;
import com.recipe.vo.IngredientVO;
import com.recipe.vo.PostVO;
import com.recipe.vo.RecipeVO;

@Service
public class PostService {
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	public List<PostVO> getPostAll() {
		
		log.info("### Post Table Select Start ###");
		List<PostVO> postList = postRepository.findAll();
		log.info("### Post Table Select End   ###");
		
		return postList;
	}
	
	public String savePost(PostVO postVO) {
		
		postRepository.save(postVO);
		
		return "success";
	}
	
	public String saveIngredient(IngredientVO ingredientVO) {
		
		ingredientRepository.save(ingredientVO);
		
		return "success";
	}
	
	public String saveRecipe(RecipeVO recipeVO) {
		
		recipeRepository.save(recipeVO);
		
		return "success";
	}

}
