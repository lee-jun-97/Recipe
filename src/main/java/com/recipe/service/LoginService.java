package com.recipe.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.recipe.domain.User;
import com.recipe.repository.UserRepository;

@Service
public class LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	private UserRepository userRepo ;
	
	public LoginService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public void adduser(User userVO) {
		userRepo.save(userVO);
	}
	
	public boolean logincheck(String id, String pw) {
		
		Optional<User> user = userRepo.findById(id);
		
		
		
		boolean idCheck ;
		boolean pwCheck ;
		
		boolean check;
		
		if(id.equals(user.get().getId())) {
			idCheck = true;
		} else {
			idCheck = false;
		}
		
		System.out.println(idCheck);
		
//		pwCheck = pwEncoder.matches(pw, user.get(0).getPw());
		
		if(pw.equals(user.get().getPw())) {
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
