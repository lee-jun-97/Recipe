package com.recipe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.domain.User;
import com.recipe.service.LoginService;

@Controller
public class MainController {
	
	private LoginService loginService ;
	
	public MainController(LoginService loginService) {
		this.loginService = loginService ;
	}
	
	@RequestMapping("/")
	public String home() {

		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String id, @RequestParam String pw) {
		
		String redirect = "";
		
		if (loginService.loginCheck(id, pw) == true ) {
			redirect = "redirect:/post";
		} else {
			redirect = "redirect:/";
		}
		
		return redirect;
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		
		return "signup";
	}
	
	@RequestMapping("/adduser")
	public String addUser(User user) {
		
		return loginService.addUser(userSet(user));
	}
	
	public User userSet(User user) {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.format(date);
		
		user.setAuth("USER");
		user.setJoin_date(date);
		
		return user;
	}
	
	

}
