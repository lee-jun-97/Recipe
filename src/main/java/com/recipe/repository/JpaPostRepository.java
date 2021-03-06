package com.recipe.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Post;

@Repository
@Transactional
public class JpaPostRepository implements PostRepository {
	
	private EntityManager em ;
	
	// DI 방식 중 생성자 주입 방식
	public JpaPostRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void save(Post post) {
		// JPA 저장
		em.persist(post);
	}

	@Override
	public List<Post> findAll() {
		// JPQL 언어 사용 하여 쿼리실행
		return em.createQuery("select A from Post A", Post.class).getResultList();
	}

	@Override
	public Optional<Post> findByTitle(String title) {
		return Optional.ofNullable(em.find(Post.class, title));
	}
}
