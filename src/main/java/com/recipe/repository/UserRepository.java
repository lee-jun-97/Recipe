package com.recipe.repository;

import java.util.Optional;

import com.recipe.domain.User;

public interface UserRepository {
	
	void save(User user);
	Optional<User> findById(String id);
}
