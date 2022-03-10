package com.recipe.repository;

import java.util.Optional;

import com.recipe.domain.User;

public interface UserRepository {
	
	User save(User user);
	Optional<User> findById(String id);
}
