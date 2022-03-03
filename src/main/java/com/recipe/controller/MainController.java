package com.recipe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.service.LoginService;
import com.recipe.vo.UserVO;

@Controller
public class MainController {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	LoginService loginService ;
	
	@RequestMapping("/")
	public String home() {
		
		log.info("login");

		return "login";
	}
	
	@RequestMapping("/login")
	public void login(UserVO userVO) {
		
		log.info(userVO.toString());
		
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
