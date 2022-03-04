package com.recipe.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.vo.DetailVO;
import com.recipe.vo.UserVO;

@Repository
@Transactional
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	EntityManager em ;

	@Override
	public List<DetailVO> findByTitle(String title) {
		
		
		List<DetailVO> detail = em.createQuery("SELECT post.title, food_ingredient.menu, food_ingredient.ingredient, food_ingredient.amount, recipe.recipe "
				+ "FROM post, food_ingredient, recipe "
				+ "WHERE post.title = :title and A.menu = B.menu and B.menu = C.menu", DetailVO.class)
		.setParameter(title, title)
		.getResultList();
		
		return detail;
	}

	@Override
	public List<UserVO> findById(String id, String pw) {
		
		List<UserVO> user = em.createQuery("SELECT A FROM UserVO A WHERE A.id=:id", UserVO.class)
		.setParameter("id", id)
		.getResultList();
		
		return user;
	}

}
