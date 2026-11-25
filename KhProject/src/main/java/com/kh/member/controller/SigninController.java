package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

@WebServlet("/sign-in.do")
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SigninController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd"); 
		//System.out.println(memberId);
		//System.out.println(memberPwd);

		MemberDto member = new MemberDto();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		//System.out.println(member);
		MemberDto loginMember = new MemberService().login(member);
				
		if(loginMember != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			//request.setAttribute("loginMember", loginMember);
			response.sendRedirect("/Kh");
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("msg", "로그인에 실패하셨습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
