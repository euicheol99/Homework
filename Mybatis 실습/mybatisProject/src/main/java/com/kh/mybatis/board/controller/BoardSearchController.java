package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.common.PageInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); // writer | title | content
		String keyword = request.getParameter("keyword"); //사용자가 입력한 키워드값

		int cuurentPage = Integer.parseInt(request.getParameter("cpage"));
		
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("condition", condition);
		
		BoardService bService = new BoardServiceImpl();
		
		int listCount = bService.selectSearchCount(map);
		PageInfo pi = new PageInfo(listCount, cuurentPage, 10, 5);
		
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("keyword", keyword);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
