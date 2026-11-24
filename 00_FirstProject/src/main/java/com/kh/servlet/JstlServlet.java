package com.kh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstl.do")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public JstlServlet() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setAttribute("redFruit", "apple");
			request.setAttribute("yellowFruit", "banana");
			List<Person> persons = List.of(new Person("홍길동", "한양"),
										   new Person("고길동", "마포"),
										   new Person("둘리", "마포"));
			request.setAttribute("list", persons);

			request.getRequestDispatcher("/WEB-INF/views/jstl.jsp").forward(request, response);
		
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
