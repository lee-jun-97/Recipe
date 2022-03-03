package com.recipe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.repository.UserRepository;
import com.recipe.vo.UserVO;

@Service
public class LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	UserRepository userRepo ;
	
	
	public void adduser(UserVO userVO) {
		
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder(); 
		
		userVO.setPw(pwEncoder.encode(userVO.getPw()));
		
		log.info(userVO.getPw());
		
		userRepo.save(userVO);
		
	}
	

}
