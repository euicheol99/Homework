package com.kh.service;



import static com.kh.common.ProjectTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {
	
	private MemberDao md = new MemberDao();
	
	public boolean checkId(String id) {
		for(Member m : this.selectList()) {
			if(m.getMemberId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Member> selectList(){
		Connection conn = getConnection();
		ArrayList<Member> list = md.selectList(conn);
		
		close(conn);
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = md.insertMember(m,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public boolean memberCheck(String id, String password) {
		Connection conn = getConnection();
		for(Member m : this.selectList()) {
			if(m.getMemberId().equals(id) && m.getMemberPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public int updateMember(String id,String newpassword,String newname) {
		
		Connection conn = getConnection();
		int result = md.updateMember(id,newpassword,newname,conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
}
