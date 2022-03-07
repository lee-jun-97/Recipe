package com.recipe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.recipe.service.LoginService;
import com.recipe.vo.SessionVO;
import com.recipe.vo.UserVO;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	LoginService loginService ;
	
	@Autowired
	SessionVO session ;
	
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
	public String adduser(UserVO userVO) {

		log.info(userVO.toString());
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.format(date);
		
		userVO.setAuth("USER");
		userVO.setJoin_date(date);
		
		log.info(userVO.toString());
		
		loginService.adduser(userVO);
		
		return "redirect:/";
	}
	
	

}
