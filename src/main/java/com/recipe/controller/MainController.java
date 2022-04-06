package com.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.domain.Session;
import com.recipe.domain.User;
import com.recipe.service.LoginService;

@Controller
public class MainController {
	
	private LoginService loginService ;
	
	@Autowired
	public Session session ;
	
	public MainController(LoginService loginService) {
		this.loginService = loginService ;
	}
	
	@GetMapping("/")
	public String home() {

		return "login";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String id, @RequestParam String pw) {
		
		String redirect = "";
		
		if (loginService.loginCheck(id, pw) == true ) {
			redirect = "redirect:/post";
			session = new Session(id,pw);
		} else {
			redirect = "redirect:/";
		}
		
		return redirect;
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		session = new Session();
		
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		
		return "signup";
	}
	
	@PostMapping("/adduser")
	public String addUser(User user) {
		
		return loginService.addUser(loginService.userSet(user));
	}

}
