package com.recipe.repository;

import java.util.List;

import com.recipe.vo.DetailVO;
import com.recipe.vo.UserVO;

public interface CustomRepository {
	
	List<DetailVO> findByTitle(String title);
	
	List<UserVO> findById(String id);
	
}
