package com.recipe.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.recipe.domain.User;

@Repository
@Transactional
public class JpaUserRepository implements UserRepository {
	
	private EntityManager em ;
	
	public JpaUserRepository(EntityManager em) {
		this.em = em ;
	}

	@Override
	public void save(User vo) {
		em.persist(vo);
	}

	@Override
	public Optional<User> findById(String id) {
		return Optional.ofNullable(em.find(User.class, id));
	}

}
