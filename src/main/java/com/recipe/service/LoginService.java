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
	
	public void adduser(User user) {
		Optional<User> user_1 = userRepo.findById(user.getId());
		if (this.validate(user_1.get().getId()) == true ) {
			userRepo.save(user);
		} else {
			log.warn("이미 존재하는 ID입니다.");
		}
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
		
		if(pw.equals(user.get().getPw())) {
			pwCheck = true ;
		} else {
			pwCheck = false ;
		}
		
		if(idCheck == true && pwCheck == true) {
			check = true;
		} else {
			check = false;
		}
		
		return check;
	}
	
	public boolean validate(String id) throws IllegalStateException {
		if (id == null ) {
			log.info("회원 가입 가능 한 아이디입니다.");
			return true;
		} else {
			return false;
		}
	}
	

}
