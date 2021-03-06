package com.recipe.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.domain.Comment;
import com.recipe.domain.Detail;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;
import com.recipe.domain.Session;
import com.recipe.service.PostService;


@Controller
public class PostController {
	
//	private static final Logger log = LoggerFactory.getLogger(PostController.class);
	
	@Autowired
	PostService postService ;
	
	@Autowired
	Session session ;
	
	@Autowired
	Detail detail ;

	private String title;

	@GetMapping("/post")
	public String post(Model model) {
		
		model.addAttribute("postList", postService.getPostAll());
		
		return "post";
	}
	
	@GetMapping("/addpost")
	public String addPost() {
		
		return "addpost";
	}
	
	@GetMapping("/detailpost")
	public String detailPost(@RequestParam String title, Model model) {

		this.title = title;
		
		List<Detail> deList = postService.getPostDetail(title) ;
		
		this.detail.setId(deList.get(0).getId());
		this.detail.setId(deList.get(0).getMenu());
		this.detail.setId(deList.get(0).getIngredient());
		this.detail.setId(deList.get(0).getRecipe());
		
		model.addAttribute("detailList", deList);
		model.addAttribute("commentList",postService.getComment(title));
		model.addAttribute("session", session);
		
		return "detailpost";
	}
	
	@PostMapping("/save")
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
	
	@PostMapping("/modPost")
	public String modPost(
			@RequestParam String title, @RequestParam String menu,
			@RequestParam String ingredient, @RequestParam String amount, @RequestParam String recipe, Model model) {

		model.addAttribute("title", title);
		model.addAttribute("menu", menu);
		model.addAttribute("ingredient", ingredient);
		model.addAttribute("amount", amount);
		model.addAttribute("recipe", recipe);
		
		return "modpost";
	}

	@PostMapping("/comment")
	public String saveComment(@RequestParam String comment) {

		Comment comment2 = new Comment();

		comment2.setId(session.getId());
		comment2.setTitle(this.title);
		comment2.setWrite_date(new Date());
		comment2.setComment(comment);

		postService.saveComment(comment2);

		return "redirect:/detailpost?title=" + this.title ;
	}
	

}
