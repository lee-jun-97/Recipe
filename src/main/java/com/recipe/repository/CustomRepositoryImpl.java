package com.recipe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recipe.vo.DetailVO;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	EntityManager em ;

	@Override
	public List<DetailVO> getPostDetail(String title) {
		
		
		@SuppressWarnings("unchecked")
		List<DetailVO> detail = em.createQuery("SELECT A.title, B.menu, B.ingredient, B.amount, C.recipe"
				+ "FROM post A, food_ingredient B, recipe C WHERE title = :title ")
		.setParameter(title, title)
		.getResultList();
		
		return detail;
	}

}
