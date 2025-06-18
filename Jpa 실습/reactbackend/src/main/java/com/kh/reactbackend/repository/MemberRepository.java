package com.kh.reactbackend.repository;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findMember(String memberId);
    Optional<Member> loginMember(MemberDto.LoginRequest request);
}
