package com.recipe.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.recipe.domain.User;

public class UserRepositoryTest {
	
	private EntityManager em ;
	
	UserRepository userRepo = new JpaUserRepository(em);
	
	@Test
	void save() {
		
		User user = new User();
		
		user.setId(null);
		
	}

}
