package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    void save(Post post);
    List<Post> getPosts();
    void deletePost(Long id);
    Optional <Post> getPost(Long id);
}
