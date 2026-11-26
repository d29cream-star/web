package com.kh.board.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dto.BoardDto;

public class BoardDao {

	public int insertBoard(SqlSession session, BoardDto board) {
		return session.insert("boardMapper.insertBoard", board);
	}
}
