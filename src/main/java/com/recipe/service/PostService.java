package com.recipe.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.repository.CustomRepository;
import com.recipe.repository.IngredientRepository;
import com.recipe.repository.PostRepository;
import com.recipe.repository.RecipeRepository;
import com.recipe.vo.DetailVO;
import com.recipe.vo.IngredientVO;
import com.recipe.vo.PostVO;
import com.recipe.vo.RecipeVO;

@Service
public class PostService {
	
	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	CustomRepository customRepo;
	
	public List<PostVO> getPostAll() {
		
		log.info("### Post Table Select Start ###");
		List<PostVO> postList = postRepo.findAll();
		log.info("### Post Table Select End   ###");
		
		return postList;
	}
	
	public List<DetailVO> getPostDetail(String title) {
		
		log.info(title);
		
		//여기서 안댐
		List<DetailVO> detailList = customRepo.findByTitle(title);  
		
		log.info(detailList.toString());
		
		return detailList;
	}
	
	public String changeFormat(Date reg_date) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		return df.format(reg_date);
	}
	
	public String savePost(PostVO postVO) {
		
		postRepo.save(postVO);
		
		return "success";
	}
	
	public String saveIngredient(IngredientVO ingredientVO) {
		
		ingredientRepo.save(ingredientVO);
		
		return "success";
	}
	
	public String saveRecipe(RecipeVO recipeVO) {
		
		recipeRepo.save(recipeVO);
		
		return "success";
	}

}
