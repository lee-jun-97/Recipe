package com.recipe.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.domain.Comment;
import com.recipe.domain.Detail;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;
import com.recipe.repository.CommentRepository;
import com.recipe.repository.CustomRepository;
import com.recipe.repository.IngredientRepository;
import com.recipe.repository.PostRepository;
import com.recipe.repository.RecipeRepository;

@Service
public class PostService {
	
//	private static final Logger log = LoggerFactory.getLogger(PostService.class);
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	CustomRepository customRepo;

	@Autowired
	CommentRepository commentRepo;
	
	public List<Post> getPostAll() {
		return postRepo.findAll();
	}
	
	public List<Detail> getPostDetail(String title) {
		// 2022. 03. 02 ~ 2022. 03 .06
		// Detail 정보 Select 하는 기능 완성
		return customRepo.findDetail(title);
	}
	
	public List<Comment> getComment(String title) {
		return commentRepo.findByTitle(title);
	}
	
	public void savePost(Post postVO) {
		
		postRepo.save(postVO);
	}
	
	public void saveIngredient(Ingredient ingredientVO) {
		
		ingredientRepo.save(ingredientVO);
	}
	
	public void saveRecipe(Recipe recipeVO) {
		
		recipeRepo.save(recipeVO);
	}

	public void saveComment(Comment comment) {
		commentRepo.save(comment);
	}

	public String changeFormat(Date reg_date) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		return df.format(reg_date);
	}
}
