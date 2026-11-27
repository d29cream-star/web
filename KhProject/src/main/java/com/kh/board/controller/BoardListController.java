package com.kh.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.service.BoardService;

@WebServlet("/boardlist.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public BoardListController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new BoardService().selectBoardCount();
		currentPage = Integer.parseInt(request.getParameter("page"));
		pageLimit=5;
		boardLimit=5;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		startPage = (currentPage-1) /pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;			
		if(endPage>maxPage){
			endPage = maxPage;
			}
		
		int offset = (currentPage - 1) * boardLimit;
		
		Map<String, Integer> pageInfo = Map.of("listCount", listCount,
											  "currentPage", currentPage,
											  "pageLimit", pageLimit,
											  "boardLimit", boardLimit,
											  "startPage", startPage,
											  "endPage", endPage,
											  "maxPage", maxPage,
											  "offset", offset);
				
		
		List<BoardDto> boards = new BoardService().selectBoardList(pageInfo); //board는 지역변수, scope를 벗어남으로 객체로 담아야한다. 주어진 객체의 메소드를 사용하면 된다.
				System.out.println(boards);
		request.setAttribute("boards", boards);
		request.setAttribute("pageInfo", pageInfo);
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
