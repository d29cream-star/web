package com.kh.board.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dto.AttachmentDto;
import com.kh.board.model.dto.BoardDto;
import com.kh.board.model.vo.BoardResponse;
import com.kh.common.Template;

public class BoardService {

	private BoardDao bd = new BoardDao();
	
	public int insertBoard(BoardDto board, AttachmentDto at) {
		SqlSession session = Template.getSqlSession();
		int result = bd.insertBoard(session, board);
		
		
		if(at != null) {
			at.setRefBno(board.getBoardId());
			result *= bd.insertAttachment(session, at);
		}
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}
		
	public int selectBoardCount() {
		SqlSession session = Template.getSqlSession();
		int listCount = bd.selectBoardCount(session);
		session.close();
		return listCount;
	}
	public List<BoardDto> selectBoardList(Map<String, Integer> pageInfo){
		SqlSession session = Template.getSqlSession();
		List<BoardDto> boards = bd.selectBoardList(session, pageInfo);
		session.close();
		return boards;
	}
	public BoardResponse selectBoard(Long boardId) {
		SqlSession session = Template.getSqlSession();
		//최소 1번 아니면 3번 db 가야함
		//1) 조회수를 증가시켜야함 -> update
		//2) board/ 3) attachment
		BoardResponse br = null;
		int result = bd.increaseCount(session, boardId);
		
		if(result > 0) {
			session.commit();
			BoardDto board = bd.selectBoard(session, boardId);
			AttachmentDto at = bd.selectAttachment(session, boardId);
			
			br = new BoardResponse(board, at);
		
		}
		session.close();
		
		return br;
		
		
	
	}
	
	
}
