package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

@WebServlet("/join.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		MemberDto member = new MemberDto();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		member.setMemberName(memberName);
		member.setEmail(email);
		
		int result = new MemberService().insertMember(member);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath());
			//response.sendRedirect("/Kh");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "회원가입에 실패하셨습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
