package com.recipe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.service.PostService;
import com.recipe.vo.PostVO;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	PostService postService ;
	
	@RequestMapping("/post")
	public String post(Model model) {
		
		List<PostVO> postList = postService.getPost();
		
		log.info(postList.toString());
		
		model.addAttribute("postList", postList);
		
		return "post.html";
	}
	
	@RequestMapping("/postadd")
	public String addpost() {
		
		
		return "addPost.html";
	}
}
