package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.CommentDto;
import com.kh.reactbackend.entity.Comment;
import com.kh.reactbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody CommentDto.Create commentDto){
        Comment comment = commentService.createComment(commentDto);
        return ResponseEntity.ok(comment);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto.Response>> getComments(@RequestParam("post_id")Long id) {
        return ResponseEntity.ok(commentService.getCommentList(id));
    }
}
