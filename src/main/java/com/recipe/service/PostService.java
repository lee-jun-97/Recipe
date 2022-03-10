package com.recipe.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.domain.Detail;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;
import com.recipe.repository.IngredientRepository;
import com.recipe.repository.PostRepository;
import com.recipe.repository.RecipeRepository;

@Service
public class PostService {
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	@Autowired
	RecipeRepository recipeRepo;
	
	public List<Post> getPostAll() {
		
		log.info("### Post Table Select Start ###");
		List<Post> postList = postRepo.findAll();
		log.info("### Post Table Select End   ###");
		
		return postList;
	}
	
	public List<Detail> getPostDetail(String title, String menu) {
		
		log.info(title);
		
		// 2022. 03. 02 ~ 2022. 03 .06
		// Detail 정보 Select 하는 기능 완성
		List<Detail> detailList = postRepo.findDetail(title, menu);  
		
		return detailList;
	}
	
	public String changeFormat(Date reg_date) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		return df.format(reg_date);
	}
	
	public String savePost(Post postVO) {
		
		postRepo.save(postVO);
		
		return "success";
	}
	
	public String saveIngredient(Ingredient ingredientVO) {
		
		ingredientRepo.save(ingredientVO);
		
		return "success";
	}
	
	public String saveRecipe(Recipe recipeVO) {
		
		recipeRepo.save(recipeVO);
		
		return "success";
	}

}
