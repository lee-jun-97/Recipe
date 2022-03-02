package com.recipe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String home() {
		
		log.info("home");
		
		return "redirect:/login";		
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "success";
	}
	

}
