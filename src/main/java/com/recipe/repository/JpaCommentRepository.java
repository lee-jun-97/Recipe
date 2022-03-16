package com.recipe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.recipe.domain.Comment;

@Repository
@Transactional
public class JpaCommentRepository implements CommentRepository {

    EntityManager em ;

    public JpaCommentRepository(EntityManager em) {
        this.em = em ;
    }

    @Override
    public void save(Comment comment) {
        em.persist(comment);
    }

    @Override
    public List<Comment> findByTitle(String title) {

        return em.createQuery("select A from Comment A WHERE A.title=:title",Comment.class)
        .setParameter("title", title)
        .getResultList();
    }
    
}
