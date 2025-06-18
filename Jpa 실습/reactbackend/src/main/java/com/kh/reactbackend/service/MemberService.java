package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;

public interface MemberService {
    Member createMember(MemberDto.Create memberDto);
    MemberDto.Response findMember(String memberId);
    MemberDto.Response loginMember(MemberDto.LoginRequest request);
    MemberDto.Response updateMember(MemberDto.updateMember updateMember);
}