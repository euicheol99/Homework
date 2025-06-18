package com.kh.model.dao;

import static com.kh.common.ProjectTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDao {

	public ArrayList<Member> selectList(Connection conn) {
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM MEMBER";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member m = new Member();

				m.setMemberNum(rset.getInt("MEMBERNO"));
				m.setMemberId(rset.getString("MEMBERID"));
				m.setMemberPassword(rset.getString("MEMBERPASSWORD"));
				m.setMemberName(rset.getString("MEMBERNAME"));

				list.add(m);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertMember(Member m, Connection conn) {

		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES(SEQ_MEMBERNO.NEXTVAL,?,?,?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPassword());
			pstmt.setString(3, m.getMemberName());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMember(String id, String newpassword, String newname, Connection conn) {
		int result = 0;
		String sql = "UPDATE MEMBER SET MEMBERPASSWORD = ?,MEMBERNAME = ? WHERE MEMBERID = ?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpassword);
			pstmt.setString(2, newname);
			pstmt.setString(3, id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
