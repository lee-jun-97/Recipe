package com.recipe.repository;

import java.util.List;

import com.recipe.domain.Comment;

public interface CommentRepository {

    void save(Comment comment);
    List<Comment> findByTitle(String title);
    
}
