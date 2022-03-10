package com.recipe.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.recipe.domain.Detail;
import com.recipe.domain.Post;

public class JpaPostRepository implements PostRepository {
	
	private EntityManager em ;
	
	// DI 방식 중 생성자 주입 방식
	public JpaPostRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Post save(Post post) {
		// JPA 저장
		em.persist(post);
		return post;
	}

	@Override
	public List<Post> findAll() {
		// JPQL 언어 사용 하여 쿼리실행
		return em.createQuery("select A from Post", Post.class).getResultList();
	}

	@Override
	public Optional<Post> findByTitle(String title) {
		return Optional.ofNullable(em.find(Post.class, title));
	}

	@Override
	public List<Detail> findDetail(String title, String menu) {
		return null;
	}

}
