package com.recipe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;
import com.recipe.service.PostService;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PostController {
	
//	private static final Logger log = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	PostService postService ;

	@RequestMapping("/post")
	public String post(Model model) {
		
		model.addAttribute("postList", postService.getPostAll());
		
		return "post";
	}
	
	@RequestMapping("/addpost")
	public String addPost() {
		
		return "addpost";
	}
	
	@RequestMapping("/detailpost")
	public String detailPost(@RequestParam String title, Model model) {
		
		model.addAttribute("detailList", postService.getPostDetail(title));
		model.addAttribute("commentList",postService.getComment(title));
		
		return "detailpost";
	}
	
	@RequestMapping("/save")
	public String save(
			@RequestParam String title, @RequestParam String menu,
			@RequestParam String ingredient, @RequestParam String amount, @RequestParam String recipe) {
		
		Post postVO = new Post();
		Ingredient ingredientVO = new Ingredient();
		Recipe recipeVO = new Recipe();
		
		Date date = new Date();
		
		postVO.setId("test");
		postVO.setMenu(menu);
		postVO.setTitle(title);
		postVO.setReg_date(date);
		
		postService.savePost(postVO);
		
		ingredientVO.setId("test");
		ingredientVO.setMenu(menu);
		ingredientVO.setIngredient(ingredient);
		ingredientVO.setAmount(amount);
		
		postService.saveIngredient(ingredientVO);
		
		recipeVO.setId("test");
		recipeVO.setMenu(menu);
		recipeVO.setRecipe(recipe);
		
		postService.saveRecipe(recipeVO);
		
		return "redirect:/post";
	}

	@RequestMapping("/comment")
	public String saveComment(@RequestParam String title, @RequestParam String comment) {



		return "redirect:/detailpost?title="+title ;
	}
	

}
