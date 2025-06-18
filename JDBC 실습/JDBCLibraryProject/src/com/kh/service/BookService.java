package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.BookDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.RentArray;

import static com.kh.common.ProjectTemplate.*;

public class BookService {
	BookDao bd = new BookDao();
	MemberService ms = new MemberService();
	
	public int checkRentList(String id) {
		Connection conn = getConnection();
		int result = bd.checkRentList(this.getMemberNo(id),conn);
		
		close(conn);
		return result;
	}
	
	public int getMemberNo(String id) {
		for(Member m : ms.selectList()) {
			if(m.getMemberId().equals(id)) {
				return m.getMemberNum();
			}
		} return 0;
	}
	
	public boolean checkBook(String bookName) {
		for(Book b : this.selectBookList()) {
			if(b.getBookName().equals(bookName)) {
				return true;
			}
		} return false;
	}
	
	public ArrayList<Book> selectBookList(){
		Connection conn = getConnection();
		ArrayList<Book> list = bd.selectBookList(conn);
		
		close(conn);
		return list;
	}
	
	public boolean rentListCheck(String bookname) {
		for(RentArray ra : this.selectRentList()) {
			if(ra.getBookName().equals(bookname)) {
				return true;
			}
		}
		return false;
	}
	
	
	public ArrayList<RentArray> selectRentList(){
		Connection conn = getConnection();
		ArrayList<RentArray> list = bd.selectRentList(conn);
		
		close(conn);
		return list;
	}
	
	public int rentBook(String id,String bookname) {
		Connection conn = getConnection();
		int result = bd.rentBook(id,bookname,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}
	
	public ArrayList<RentArray> showRentList(String id){
		Connection conn = getConnection();
		ArrayList<RentArray> list = bd.showRentList(id,conn);
		
		close(conn);
		return list;
	}
	
	public int returnBook(int booknum) {
		Connection conn = getConnection();
		int result = bd.retrunBook(booknum,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Book> searchBook(String search) {
		Connection conn = getConnection();
		ArrayList<Book> list = bd.searchBook(search,conn);
		
		close(conn);
		return list;
	}
	
	
}
