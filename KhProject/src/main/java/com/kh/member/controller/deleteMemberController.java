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


@WebServlet("/delete-member.do")
public class deleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public deleteMemberController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String memberPwd = request.getParameter("memberPwd");
		System.out.println(memberPwd); //앞단에서 넘어온 key값과 getParameter의 인자값이 일치하지 않으면 null
		
		String memberId = ((MemberDto)session.getAttribute("loginMember")).getMemberId();
		MemberDto member = new MemberDto();
		member.setMemberId(memberId);
		member.setMemberPwd(memberPwd);
		
		int result = new MemberService().deleteMember(member);
		
		if(result > 0) {
			session.removeAttribute("loginMember"); //하나만 날리는 것
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("msg", "비밀번호를 확인하세요");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
