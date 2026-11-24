package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/a")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyFirstServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Get방식으로 URL요청을 보냄");
		String value = request.getParameter("keyword");
		System.out.println(value);
		
		if("user01".equals(value)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>회원 페이지</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<span>" + value +"</span>님 환영합니다!");
			pw.println("<p>오늘의 날짜 : 2026/11/23 </p>");
			pw.println("</body>");
			pw.println("</html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
