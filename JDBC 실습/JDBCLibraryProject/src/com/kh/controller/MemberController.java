package com.kh.controller;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

public class MemberController {
	private MemberService ms = new MemberService();
	
	public boolean checkId(String id) {
		if(ms.checkId(id)) {
			return true;
		}
		return false;
	}
	
	public boolean memberCheck(String id,String password ) {
		if(ms.memberCheck(id,password)) {
			System.out.println("로그인 성공!");
			return true;
		} else {
			System.out.println("틀린 아이디 혹은 비밀번호입니다.");
			return false;
		}
	}
	
	public void insertMember(String id, String password,String name) {
		Member m = new Member(id,password,name);
		int result = ms.insertMember(m);
		if(result > 0) {
			System.out.println("회원가입 성공!");
		} else {
			System.out.println("회원가입 실패..");
		}
	}
	
	public void updateMember(String id,String newpassword,String newname) {
		int result = ms.updateMember(id,newpassword,newname);
		if(result > 0) {
			System.out.println("회원정보 수정 성공!");
		} else {
			System.out.println("회원정보 수정 실패..");
		}
	}
}
