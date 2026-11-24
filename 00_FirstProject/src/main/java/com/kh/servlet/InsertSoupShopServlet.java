package com.kh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/soupShop.do")
public class InsertSoupShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertSoupShopServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("작업");
		
		request.setCharacterEncoding("UTF-8");
		
		String shopName = request.getParameter("shop-name");
		//System.out.println(shopName);
		String address = request.getParameter("address");
		//System.out.println(address);
		
		request.setAttribute("shopName", shopName);
		request.setAttribute("address", address);
		
		List<String> names = List.of("조안나", "둘리", "짱구");
		request.setAttribute("names", names);
				
		request.getRequestDispatcher("/views/post.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("post 메소드 호출");
		doGet(request, response);
	}
}
