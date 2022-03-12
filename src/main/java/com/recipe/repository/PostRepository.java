package com.recipe.repository;

import java.util.List;
import java.util.Optional;

import com.recipe.domain.Post;

public interface PostRepository {
	
	Post save(Post post);
	List<Post> findAll();
	Optional<Post> findByTitle(String title);
}
