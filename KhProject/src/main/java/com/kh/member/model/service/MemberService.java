package com.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	private MemberDao md = new MemberDao();
	
	public int insertMember(MemberDto member) {
		
		SqlSession session = Template.getSqlSession();
		int result = md.insertMember(session, member);
		
		if(result > 0) {
			session.commit();
		}
		session.close();
		return result;		
	}
	public MemberDto login(MemberDto member) {
		SqlSession session = Template.getSqlSession();
		MemberDto loginMember = md.login(session, member);	
		session.close();
		return loginMember;
	
	}
	
}
