package com.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Detail;
import com.recipe.domain.Ingredient;
import com.recipe.domain.Post;
import com.recipe.domain.Recipe;

@Repository
public class JpaCustomRepository implements CustomRepository {
	
	EntityManager em ;
	
	public JpaCustomRepository(EntityManager em) {
		this.em = em ;
	}

	@Override
	public List<Detail> findDetail(String title, String menu) {
		List<Post> detail_1 = em.createQuery("SELECT A FROM Post A WHERE A.title = :title", Post.class)
				.setParameter("title", title)
				.getResultList();
		
		
		List<Ingredient> detail_2 = em.createQuery("SELECT A FROM Ingredient A WHERE A.menu = :menu", Ingredient.class)
				.setParameter("menu", detail_1.get(0).getMenu())
				.getResultList();
		
		
		List<Recipe> detail_3 = em.createQuery("SELECT A FROM Recipe A WHERE A.menu = :menu", Recipe.class)
				.setParameter("menu", detail_1.get(0).getMenu())
				.getResultList();
		
		
		Detail detail = new Detail();
		
		detail.setTitle(title);
		detail.setMenu(detail_1.get(0).getMenu());
		detail.setIngredient(detail_2.get(0).getIngredient());
		detail.setAmount(detail_2.get(0).getAmount());
		detail.setRecipe(detail_3.get(0).getRecipe());
		
		List<Detail> detailList = new ArrayList<>();
		
		detailList.add(detail);
		
		return detailList;
	}
	

}
