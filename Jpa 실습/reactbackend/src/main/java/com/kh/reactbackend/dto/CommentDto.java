package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{

        private String content;
        private Long post_id;
        private String member_id;


        public Comment toEntity(){
            return Comment.builder()
                    .content(this.content)
                    .createDate(LocalDateTime.now())
                    .build();
        }

    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static  class Response{
        private String content;
        private String member_id;
        private LocalDateTime create_date;

        public static Response toSimpleDto(Comment comment){
            return Response.builder()
                    .content(comment.getContent())
                    .member_id(comment.getMember().getMemberId())
                    .create_date(comment.getCreateDate())
                    .build();
        }
    }
}
