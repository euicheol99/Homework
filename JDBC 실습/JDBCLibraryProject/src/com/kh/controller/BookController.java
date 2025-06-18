package com.kh.controller;

import java.sql.Connection;

import com.kh.model.vo.Book;
import com.kh.model.vo.RentArray;
import com.kh.service.BookService;
import com.kh.service.MemberService;

public class BookController {
	BookService bs = new BookService();
	
	public boolean checkRentList(String id) {
		if(bs.checkRentList(id)==2) {
			System.out.println("더이상 책을 대여하실 수 없습니다.");
			return true;
		} return false;
	}
	
	public void rentBook(String id,String bookName) {
		if(!bs.checkBook(bookName)) {
			System.out.println("존재하지 않는 책의 번호입니다.");
			return;
		}
		if(bs.rentListCheck(bookName)) {
			System.out.println("이미 대여중인 책입니다.");
			return;
		}
		if(bs.rentBook(id,bookName) > 0) {
			System.out.println("책 대여 등록이 완료되었습니다.");
			return;
		}
		else {
			System.out.println("책 대여에 실패하였습니다.");
			return;
		}
	}
	
	public void showRentList(String id) {
		for(RentArray ra : bs.showRentList(id)) {
			System.out.println(ra.toString());
		}
	}
	
	public void returnBook(int booknum) {
		if(bs.returnBook(booknum) > 0) {
			System.out.println("반납이 완료되었습니다.");
		} else {
			System.out.println("반납이 완료되지 않았습니다.책 번호를 확인해주세요.");
		}
	}
	
	public void searchBook(String search) {
		for(Book b : bs.searchBook(search)) {
			System.out.println(b.toString());
		}
	}
	
	public void printAll() {
		for(Book b : bs.selectBookList()) {
			System.out.println(b.toString());
		}
		
	}
}
