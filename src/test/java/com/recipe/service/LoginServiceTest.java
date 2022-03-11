package com.recipe.service;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.domain.User;
import com.recipe.repository.JpaUserRepository;
import com.recipe.repository.UserRepository;

@Transactional
public class LoginServiceTest {
	
	EntityManager em ;
	
	UserRepository userRepo = new JpaUserRepository(em);
	
	LoginService loginService = new LoginService(userRepo);
	
	@Test
	void adduser() {
		
		// given
		User user = new User();
		user.setName("test");
		user.setNickname("test");
		user.setId("test1");
		user.setPw("test");
		user.setAuth("USER");
		user.setJoin_date(new Date());
		
		// when
		loginService.adduser(user);
		
		// then -> IllegalStateException이 나야함.
		
	}

}
