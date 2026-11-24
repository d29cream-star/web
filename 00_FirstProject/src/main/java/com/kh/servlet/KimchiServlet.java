package com.kh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kimchi.do")
public class KimchiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public KimchiServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("student", new Person("홍길동", "한양"));
		request.setAttribute("num", 10);
		request.setAttribute("str", "문자열");
		request.setAttribute("list", List.of("1","2","3"));
		
		request.getRequestDispatcher("/WEB-INF/views/el.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
