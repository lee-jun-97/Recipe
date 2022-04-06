package com.recipe.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.recipe.domain.User;
import com.recipe.repository.UserRepository;

@Service
public class LoginService {
	
	private UserRepository userRepo ;
	
	public LoginService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public boolean loginCheck(String id, String pw) {
		
		return userCheck(id, pw, userRepo.findById(id));
	}
	
	public String addUser(User user) {
		Optional<User> user_1 = userRepo.findById(user.getId());
		if (validate(user_1.get().getId()) == true ) {
			userRepo.save(user);
			return "redirect:/login";
		} else {
			return "redirect:/signup";
		}
	}
	
	public User userSet(User user) {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		df.format(date);
		
		user.setAuth("USER");
		user.setJoin_date(date);
		
		return user;
	}

	
	
	public boolean validate(String id) throws IllegalStateException {
		if (id == null ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean userCheck(String id, String pw, Optional<User> user) {
		
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
	

}
