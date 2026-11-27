package com.kh.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dto.AttachmentDto;
import com.kh.board.model.dto.BoardDto;

public class BoardDao {

	public int insertBoard(SqlSession session, BoardDto board) {
		return session.insert("boardMapper.insertBoard", board);
	}
	public int insertAttachment(SqlSession session, AttachmentDto at) {
		return session.delete("boardMapper.insertAttachment", at);
	}
	public int selectBoardCount(SqlSession session) {
		return session.selectOne("boardMapper.selectBoardCount");
	}
	public List<BoardDto> selectBoardList(SqlSession session, Map<String, Integer> pageInfo){
		return session.selectList("boardMapper.selectBoardList", pageInfo);
	}
	public int increaseCount(SqlSession session, Long boardId) {
		return session.update("boardMapper.increaseCount", boardId);
	}
	public BoardDto selectBoard(SqlSession session, Long boardId) {
		return session.selectOne("boardMapper.selectBoard", boardId);
	}
	public AttachmentDto selectAttachment(SqlSession session, Long boardId) {
		return session.selectOne("boardMapper.selectAttachment", boardId);
	}
}
