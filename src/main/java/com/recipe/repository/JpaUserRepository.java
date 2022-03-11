package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.recipe.domain.User;

@Repository
public class JpaUserRepository implements UserRepository {
	
	private EntityManager em ;
	
	public JpaUserRepository(EntityManager em) {
		this.em = em ;
	}

	@Override
	public User save(User vo) {
		em.persist(vo);
		return vo;
	}

	@Override
	public Optional<User> findById(String id) {
		return Optional.ofNullable(em.find(User.class, id));
	}

}
