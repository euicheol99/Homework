package com.kh.reactbackend.repository;

import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository

public class PostRepositoryImpl implements PostRepository{

    @PersistenceContext
    public EntityManager em;

    @Override
    public void save(Post post) { em.persist(post);}

    @Override
    public List<Post> getPosts() {
        String query = "select p from Post as p order by p.createDate desc" ;


        return em.createQuery(query, Post.class).getResultList();
    }

    @Override
    public void deletePost(Long id) {
        em.remove(em.find(Post.class, id));
    }

    @Override
    public Optional<Post> getPost(Long id) {
        return Optional.ofNullable(em.find(Post.class, id));
    }


}
