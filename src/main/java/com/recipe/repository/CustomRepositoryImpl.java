package com.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recipe.vo.DetailVO;
import com.recipe.vo.IngredientVO;
import com.recipe.vo.PostVO;
import com.recipe.vo.RecipeVO;
import com.recipe.vo.UserVO;

@Repository
@Transactional
public class CustomRepositoryImpl implements CustomRepository {
	
	@Autowired
	EntityManager em ;

	@Override
	public List<DetailVO> findByTitle(String title) {
		
		
		List<PostVO> detail_1 = em.createQuery("SELECT A FROM PostVO A WHERE A.title = :title", PostVO.class)
		.setParameter("title", title)
		.getResultList();
		
		
		List<IngredientVO> detail_2 = em.createQuery("SELECT A FROM IngredientVO A WHERE A.menu = :menu", IngredientVO.class)
				.setParameter("menu", detail_1.get(0).getMenu())
				.getResultList();
		
		
		List<RecipeVO> detail_3 = em.createQuery("SELECT A FROM RecipeVO A WHERE A.menu = :menu", RecipeVO.class)
				.setParameter("menu", detail_1.get(0).getMenu())
				.getResultList();
		
		
		DetailVO detailVO = new DetailVO();
		
		detailVO.setTitle(title);
		detailVO.setMenu(detail_1.get(0).getMenu());
		detailVO.setIngredient(detail_2.get(0).getIngredient());
		detailVO.setAmount(detail_2.get(0).getAmount());
		detailVO.setRecipe(detail_3.get(0).getRecipe());
		
		List<DetailVO> detail = new ArrayList<>();
		
		detail.add(detailVO);
		
		return detail;
	}

	@Override
	public List<UserVO> findById(String id) {
		
		List<UserVO> user = em.createQuery("SELECT A FROM UserVO A WHERE A.id=:id", UserVO.class)
		.setParameter("id", id)
		.getResultList();
		
		return user;
	}

}
