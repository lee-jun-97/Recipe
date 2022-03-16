package com.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Detail;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;

@Repository
@Transactional
public class JpaCustomRepository implements CustomRepository {
	
	EntityManager em ;
	
	public JpaCustomRepository(EntityManager em) {
		this.em = em ;
	}

	@Override
	public List<Detail> findDetail(String title) {
		List<Post> detail_menu = em.createQuery("SELECT A FROM Post A WHERE A.title = :title", Post.class)
				.setParameter("title", title)
				.getResultList();
		
		
		List<Ingredient> detail_ing = em.createQuery("SELECT A FROM Ingredient A WHERE A.menu = :menu", Ingredient.class)
				.setParameter("menu", detail_menu.get(0).getMenu())
				.getResultList();
		
		
		List<Recipe> detail_reci = em.createQuery("SELECT A FROM Recipe A WHERE A.menu = :menu", Recipe.class)
				.setParameter("menu", detail_menu.get(0).getMenu())
				.getResultList();
		
		
		Detail detail = new Detail();
		
		detail.setTitle(title);
		detail.setMenu(detail_menu.get(0).getMenu());
		detail.setIngredient(detail_ing.get(0).getIngredient() + " " + detail_ing.get(0).getAmount());
		detail.setRecipe(detail_reci.get(0).getRecipe());
		
		List<Detail> detailList = new ArrayList<>();
		
		detailList.add(detail);
		
		return detailList;
	}
	

}
