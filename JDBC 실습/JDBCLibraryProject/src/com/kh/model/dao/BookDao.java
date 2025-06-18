package com.kh.model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.RentArray;

public class BookDao {

	public int checkRentList(int memberNum, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(*) FROM RENTARRAY WHERE MEMBERNO = ?";
		ResultSet rset = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNum);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
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
		return result;
	}

	public ArrayList<Book> selectBookList(Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM BOOK";

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Book b = new Book();

				b.setBookNumber(rset.getInt("BOOKNUMBER"));
				b.setBookName(rset.getString("BOOKNAME"));
				b.setBookAuthor(rset.getString("BOOKAUTHOR"));

				list.add(b);
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

	public ArrayList<RentArray> selectRentList(Connection conn) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM RENTARRAY";
		ArrayList<RentArray> list = new ArrayList<RentArray>();

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				RentArray ra = new RentArray();

				ra.setBookNumber(rset.getInt("BOOKNUMBER"));
				ra.setMemberNumber(rset.getInt("MEMBERNO"));
				ra.setBookAuthor(rset.getString("BOOKAUTHOR"));
				ra.setBookName(rset.getString("BOOKNAME"));

				list.add(ra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int rentBook(String id, String bookName, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RENTARRAY (BOOKNUMBER, MEMBERNO, BOOKNAME, BOOKAUTHOR) "
				+ "SELECT b.BOOKNUMBER, m.MEMBERNO, b.BOOKNAME, b.BOOKAUTHOR " + "FROM MEMBER m "
				+ "JOIN BOOK b ON b.BOOKNAME = ? " + "WHERE m.MEMBERID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<RentArray> showRentList(String id, Connection conn) {
		ArrayList<RentArray> list = new ArrayList<RentArray>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM RENTARRAY JOIN MEMBER USING(MEMBERNO) WHERE MEMBERID = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				RentArray ra = new RentArray();
				ra.setBookAuthor(rset.getString("BOOKAUTHOR"));
				ra.setBookName(rset.getString("BOOKNAME"));
				ra.setBookNumber(rset.getInt("BOOKNUMBER"));
				ra.setMemberNumber(rset.getInt("MEMBERNO"));

				list.add(ra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int retrunBook(int booknum, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM RENTARRAY WHERE BOOKNUMBER = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, booknum);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Book> searchBook(String search, Connection conn) {
		ResultSet rset = null;
		ArrayList<Book> list = new ArrayList<Book>();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM BOOK WHERE BOOKNAME LIKE ? OR BOOKAUTHOR LIKE ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Book b = new Book();
				b.setBookNumber(rset.getInt("BOOKNUMBER"));
				b.setBookAuthor(rset.getString("BOOKAUTHOR"));
				b.setBookName(rset.getString("BOOKNAME"));

				list.add(b);
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
}
