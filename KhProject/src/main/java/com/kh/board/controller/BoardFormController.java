package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.dto.MemberDto;

@WebServlet("/board-form.do")

public class BoardFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("loginMember");
		
	if(member != null) {
		request.getRequestDispatcher("/WEB-INF/views/board/board_form.jsp").forward(request, response);
	}else {
		request.setAttribute("msg", "게시글 작성은 로그인 이후 가능합니다.");
		request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
