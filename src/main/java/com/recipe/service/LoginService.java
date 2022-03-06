package com.recipe.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.repository.CustomRepository;
import com.recipe.repository.UserRepository;
import com.recipe.vo.UserVO;

@Service
public class LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	UserRepository userRepo ;
	
	@Autowired
	CustomRepository customRepo ;
	
//	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder(); 
	
	public void adduser(UserVO userVO) {
		
		
//		userVO.setPw(pwEncoder.encode(userVO.getPw()));
		
		userRepo.save(userVO);
		
	}
	
	public boolean logincheck(String id, String pw) {
		
		List<UserVO> user = customRepo.findById(id);
		
		boolean idCheck ;
		boolean pwCheck ;
		
		boolean check;
		
		if(id.equals(user.get(0).getId())) {
			idCheck = true;
		} else {
			idCheck = false;
		}
		
		System.out.println(idCheck);
		
//		pwCheck = pwEncoder.matches(pw, user.get(0).getPw());
		
		if(pw.equals(user.get(0).getPw())) {
			pwCheck = true ;
		} else {
			pwCheck = false ;
		}
		
		System.out.println(pwCheck);
		
		if(idCheck == true && pwCheck == true) {
			check = true;
		} else {
			check = false;
		}
		
		log.info("### Check Finish ### " + check);
		
		return check;
	}
	

}
