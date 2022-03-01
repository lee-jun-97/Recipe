package com.recipe.repository;

import java.util.List;

import com.recipe.vo.DetailVO;

public interface CustomRepository {
	
	List<DetailVO> findByTitle(String title);
	
}
