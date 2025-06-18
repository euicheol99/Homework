package com.kh.model.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Member;
import com.kh.model.vo.RootMember;
import static com.kh.common.ProjectTemplate.*;

public class RootMemberDao {

	public ArrayList<RootMember> selectList(Connection conn) {
		ResultSet rset = null;
		ArrayList<RootMember> list = new ArrayList<>();

		PreparedStatement pstmt = null;

		String sql = "SELECT * FROM ROOTMEMBER";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				RootMember m = new RootMember();

				m.setRootManagerId(rset.getString("ROOTMEMBERID"));
				m.setRootManagerPassword(rset.getNString("ROOTMEMBERPASSWORD"));

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

	public int insertBook(Book b, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK VALUES(SEQ_BOOKNUMBER.NEXTVAL,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBookName());
			pstmt.setString(2, b.getBookAuthor());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteBook(String bookName,Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM BOOK WHERE BOOKNAME = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,bookName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
