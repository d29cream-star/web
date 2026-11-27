package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.BoardResponse;

@WebServlet("/board-detail.do")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long boardId = Long.parseLong(request.getParameter("boardId"));
		
		BoardResponse br = new BoardService().selectBoard(boardId);
		
		if(br != null) {
			request.setAttribute("board", br.board());
			request.setAttribute("at", br.at());
			request.getRequestDispatcher("/WEB-INF/views/board/board_detail.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "게시글 조회 실패");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
