package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Comment comment) {em.persist(comment);}

    @Override
    public List<Comment> getComments(Long postId) {
        String query = "select c from Comment c where c.post.postId = :postId order by c.createDate desc";

        return em.createQuery(query, Comment.class)
                .setParameter("postId",postId)
                .getResultList();
    }
}
