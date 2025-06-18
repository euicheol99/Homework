package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody MemberDto.Create memberDto) {
        Member member = memberService.createMember(memberDto);

        return ResponseEntity.ok(member);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto.Response> getMember(@PathVariable String memberId) {
        return ResponseEntity.ok(memberService.findMember(memberId));
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDto.Response> loginMember(@RequestBody MemberDto.LoginRequest request) {
        return ResponseEntity.ok(memberService.loginMember(request));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberDto.Response> updateMember(@RequestBody MemberDto.updateMember updateMember ) {
        return ResponseEntity.ok(memberService.updateMember(updateMember));
    }

}
