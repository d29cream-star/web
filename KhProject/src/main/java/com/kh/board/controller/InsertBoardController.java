package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.dto.AttachmentDto;
import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.service.BoardService;
import com.kh.common.MyRenamePolicy;
import com.kh.member.model.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert-board.do")

public class InsertBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)){
			//System.out.println("잘왔니?");
			int maxSize = 10 * 1024 * 1024;
			ServletContext app = request.getServletContext();
			String path = app.getRealPath("resources/board_upfiles");
			//System.out.println(path);
			MultipartRequest multiRequest = 
							new MultipartRequest(request, path, maxSize, "UTF-8", new MyRenamePolicy());
						
			String boardTitle = multiRequest.getParameter("boardTitle");
			String boardContent = multiRequest.getParameter("boardContent");
			String memberId = ((MemberDto)request.getSession().getAttribute("loginMember")).getMemberId();
			
			BoardDto board = new BoardDto();
			
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setMemberId(memberId);
			
			AttachmentDto at = null;
			
			if(multiRequest.getOriginalFileName("upfile") !=null) {
				at = new AttachmentDto();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/board_upfiles");
				at.setFileLevel(2);
				at.setBoardType(1);
			}
			
			int result = new BoardService().insertBoard(board, at);
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() +"/boardlist.do?page=1");
				
				//request.getRequestDispatcher("/WEB-INF/views/board/board_list.jsp").forward(request, response);
			
			}else {
				request.setAttribute("msg", "게시글 작성에 실패했습니다.");
				request.getRequestDispatcher("/WEB-INF/views/common/result.jsp").forward(request, response);
			}
			
			
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
