package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Member;
import lombok.*;

public class MemberDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{

        private String member_id;
        private String password;
        private String email;
        private String name;

        public Member toEntity() {
            return Member.builder()
                    .memberId(this.member_id)
                    .password(this.password)
                    .email(this.email)
                    .name(this.name)
                    .build();
        }
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{

        private String member_id;
        private String password;
        private String name;
        private String email;

        public static Response toDto(Member member) {
            return Response.builder()
                    .member_id(member.getMemberId())
                    .password(member.getPassword())
                    .name(member.getName())
                    .email(member.getEmail())
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginRequest{
        private String member_id;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class updateMember{
        private String member_id;
        private String password;
        private String name;
        private String email;
    }
}
