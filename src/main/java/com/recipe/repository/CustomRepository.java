package com.recipe.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.recipe.vo.DetailVO;

@Repository
public interface CustomRepository {
	
	List<DetailVO> getPostDetail(String title);
}
