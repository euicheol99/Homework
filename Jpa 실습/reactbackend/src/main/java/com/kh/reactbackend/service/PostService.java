package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.PostDto;
import com.kh.reactbackend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Post createPost(PostDto.Create create);
    List<PostDto.Response> getPostList();
    PostDto.Response getPost(Long id);
    void deletePost(Long id);
    Post updatePost(Long id, PostDto.Update updateDto);
}
