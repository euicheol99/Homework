package com.kh.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.RootMemberDao;
import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.RootMember;

import static com.kh.common.ProjectTemplate.*;

public class RootMemberService {
	RootMemberDao rd = new RootMemberDao();
	
	public boolean checkRootMember(String id,String password) {
		Connection conn = getConnection();
		for(RootMember rm : this.selectList()) {
			if(rm.getRootManagerId().equals(id) && rm.getRootManagerPassword().equals(password)) {
				return true;
			} 
		} return false;
	}
	
	public ArrayList<RootMember> selectList() {
		Connection conn = getConnection();
		ArrayList<RootMember> list = rd.selectList(conn);
		
		close(conn);
		return list;
	}
	
	public int insertBook(Book b) {
		Connection conn = getConnection();
		int result = rd.insertBook(b,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteBook(String bookName) {
		Connection conn = getConnection();
		int result = rd.deleteBook(bookName,conn);
		
		if(result > 0 ) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
