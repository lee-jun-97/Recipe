package com.recipe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.vo.DetailVO;

@Repository
@Transactional
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	EntityManager em ;

	@Override
	public List<DetailVO> findByTitle(String title) {
		
		
		List<DetailVO> detail = em.createQuery("SELECT A.title, B.menu, B.ingredient, B.amount, C.recipe"
				+ "FROM post A, food_ingredient B, recipe C WHERE A.title = :title ", DetailVO.class)
		.setParameter(title, title)
		.getResultList();
		
		return detail;
	}

}
