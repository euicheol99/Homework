package com.kh.controller;

import com.kh.model.vo.Book;
import com.kh.service.RootMemberService;

public class RootMemberController {
	
	RootMemberService rs = new RootMemberService();
	
	public boolean checkRootMember(String id,String password) {
		if(rs.checkRootMember(id,password)) {
			System.out.println("관리자 계정 로그인 성공!");
			return true;
		} else { 
			System.out.println("관리자 계정 로그인 실패");
			return false;}
		
	}
	
	public void insertBook(String bookName,String bookAuthor) {
		Book b = new Book(bookName,bookAuthor);
		if(rs.insertBook(b) > 0) {
			System.out.println("책이 정상적으로 추가되었습니다.");
		} else {
			System.out.println("책이 추가되지 않았습니다.");
		}
	}
	
	public void deleteBook(String bookName) {
		if(rs.deleteBook(bookName) > 0) {
			System.out.println("책이 정상적으로 삭제되었습니다.");
		} else {
			System.out.println("책이 삭제되지 않았습니다.");
		}
	}
}
