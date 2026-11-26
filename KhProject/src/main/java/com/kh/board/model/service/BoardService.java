package com.kh.board.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.AttachmentDto;
import com.kh.board.model.dto.BoardDto;
import com.kh.common.Template;

public class BoardService {

	private BoardDao bd = new BoardDao();
	
	public int insertBoard(BoardDto board, AttachmentDto at) {
		SqlSession session = Template.getSqlSession();
		int result = bd.insertBoard(session, board);
					 bd.insertBoard()
		if(result > 0 ) {
			session.commit();
		}session.close(); 
		return result;
	}
}
