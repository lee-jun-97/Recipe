package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.vo.PostVO;

public interface PostRepository extends JpaRepository<PostVO, Long>{

}
