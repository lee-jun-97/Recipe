package com.recipe.repository;

import java.util.List;

import com.recipe.domain.Detail;

public interface CustomRepository {
	
	List<Detail> findDetail(String title, String menu);

}
