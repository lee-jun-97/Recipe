package com.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.repository.CustomRepository;
import com.recipe.repository.UserRepository;
import com.recipe.vo.UserVO;

@Service
public class LoginService {
	
//	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	UserRepository userRepo ;
	
	@Autowired
	CustomRepository customRepo ;
	
	BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder(); 
	
	public void adduser(UserVO userVO) {
		
		
		userVO.setPw(pwEncoder.encode(userVO.getPw()));
		
		userRepo.save(userVO);
		
	}
	
	public boolean logincheck(String id, String pw) {
		
		List<UserVO> user = customRepo.findById(id, pw);
		
		boolean idCheck ;
		boolean pwCheck ;
		
		boolean check;
		
		if(id.equals(user.get(0).getId())) {
			idCheck = true;
		} else {
			idCheck = false;
		}
		
		pwCheck = pwEncoder.matches(pw, user.get(0).getPw());
		
		if(idCheck == true && pwCheck == true) {
			check = true;
		} else {
			check = false;
		}
		
		return check;
	}
	

}
