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

@WebServlet("/mypage.do")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MypageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto userInfo = (MemberDto)session.getAttribute("loginMember");
		//System.out.println(userInfo);
		
		if(userInfo != null) {
			//DB에 갱신된 최신 정보를 응답하기 위한 코드
			MemberDto loginInfo = new MemberService().login(userInfo);//login 메소드 호출해서 최신 정보로 덮어씀
			session.setAttribute("loginMember", userInfo);
			
			request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
		}else {
		    response.sendRedirect(request.getContextPath());	
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
