package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);
    List<Comment> getComments(Long id);
}
