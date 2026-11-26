package com.kh.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.dto.MemberDto;
import com.kh.member.model.service.MemberService;

@WebServlet("/update-member.do")

public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		//String memberId = ((MemberDto)request.getSession().getAttribute("loginMember")).getMemberId();
		MemberDto member = (MemberDto)request.getSession().getAttribute("loginMember");
		if(member == null) {
			
		}
		String memberId = member.getMemberId();
		
		Map<String, String> map = Map.of("memberId", memberId,
										"email", email,
										"memberName", memberName);
		
		int result = new MemberService().updateMember(map);
		
		if(result > 0) {
			//MemberDto loginInfo = new MemberService().login(member);
			//request.getSession().setAttribute("loginMember", member);
			//request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+ "/mypage.do"); 
		}else {
			request.setAttribute("msg","정보 수정에 실패했습니다. 다시 시도해주세요");
			request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
		}
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
