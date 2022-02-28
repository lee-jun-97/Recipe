package com.recipe.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.service.PostService;
import com.recipe.vo.DetailVO;
import com.recipe.vo.IngredientVO;
import com.recipe.vo.PostVO;
import com.recipe.vo.RecipeVO;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	PostService postService ;
	
	@RequestMapping("/post")
	public String post(Model model) {
		
		List<PostVO> postList = postService.getPostAll();
		
//		for(PostVO i  : postList) {
//			String reg_date_c = postService.changeFormat(i.getReg_date());
//			
//		}
		model.addAttribute("postList", postList);
		
		return "post";
	}
	
	@RequestMapping("/addpost")
	public String addpost() {
		
		return "addPost";
	}
	
	@RequestMapping("/detailpost")
	public String detailpost(@RequestParam String title, Model model) {
		
		log.info(title);
		
		List<DetailVO> detailList = postService.getPostDetail(title);
		
		model.addAttribute("detailList", detailList);
		
		log.info(detailList.toString());
		
		return "detailPost";
	}
	
	@RequestMapping("/save")
	public String save(
			@RequestParam String title, @RequestParam String menu,
			@RequestParam String ingredient, @RequestParam String amount, @RequestParam String recipe) {
		
		PostVO postVO = new PostVO();
		IngredientVO ingredientVO = new IngredientVO();
		RecipeVO recipeVO = new RecipeVO();
		
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
}
