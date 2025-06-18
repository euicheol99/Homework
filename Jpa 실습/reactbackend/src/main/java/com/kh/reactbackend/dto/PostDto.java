package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Comment;
import com.kh.reactbackend.entity.Post;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{

        private String post_title;
        private String stack;
        private String content;
        private String member_id;

        public Post toEntity() {
            return Post.builder()
                    .postTitle(this.post_title)
                    .stack(this.stack)
                    .content(this.content)
                    .createDate(LocalDateTime.now())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long post_id;
        private String stack;
        private String post_title;
        private String member_id;
        private String content;
        private LocalDateTime create_date;
        private List<CommentDto.Response> comments;

        public static Response toSimpleDto(Post post) {
            return Response.builder()
                    .post_id(post.getPostId())
                    .stack(post.getStack())
                    .post_title(post.getPostTitle())
                    .member_id(post.getMember().getMemberId())
                    .create_date(post.getCreateDate())
                    .content(post.getContent())
                    .comments(
                            post.getComments().stream()
                                    .map(CommentDto.Response::toSimpleDto)
                                    .toList() // Java 16+ or use .collect(Collectors.toList()) for older versions
                    )
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @Builder
    @NoArgsConstructor
    public static class Update{
        private String post_title;
        private String stack;
        private String content;

        public static Post toEntity(Post post){
            return Post.builder()
                    .postTitle(post.getPostTitle())
                    .stack(post.getStack())
                    .content(post.getContent())
                    .build();
        }
    }

}
