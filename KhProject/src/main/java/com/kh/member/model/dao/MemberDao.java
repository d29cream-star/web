package com.kh.member.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.dto.MemberDto;

public class MemberDao {

	public int insertMember(SqlSession session, MemberDto member) {
		return session.insert("memberMapper.insertMember", member);
		
	}
	public MemberDto login(SqlSession session, MemberDto member) {
		return session.selectOne("memberMapper.login", member);
	}
	public int updateMember(SqlSession session, Map<String, String> map) {
		return session.update("memberMapper.updateMember", map);
	}
	public int deleteMember(SqlSession session, MemberDto member) {
		return session.update("memberMapper.deleteMember", member);
	}
}
