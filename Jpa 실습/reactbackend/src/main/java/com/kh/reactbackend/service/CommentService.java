package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.CommentDto;
import com.kh.reactbackend.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentDto.Create commentDto);
    List<CommentDto.Response> getCommentList(Long id);
}
