package com.recipe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.domain.Session;
import com.recipe.domain.User;
import com.recipe.service.LoginService;

@Controller
public class MainController {
	
//	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	private static final Session session = new Session();
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
		
		boolean check = loginService.logincheck(id, pw);
		
		if (check == true ) {
			redirect = "redirect:/post";
			session.setId(id);
		} else {
			redirect = "redirect:/login";
		}
		
		return redirect;
	}
	
	@RequestMapping("/logout")
	public String logout() {
		
		session.setId("");
		
		return "redirect:/";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "signup";
	}
	
	@RequestMapping("/adduser")
	public String adduser(User user) {
		
		user = userSet(user) ;
		
		loginService.adduser(user);
		
		return "redirect:/";
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
