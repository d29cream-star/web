package com.kh.member.model.dto;

import java.sql.Date;

public class MemberDto {

	private String memberId;
	private String memberPwd;
	private String memberName;
	private String email;
	private Date enrollDate;
	private String status;
	
	public MemberDto() {
		super();
	}
	public MemberDto(String memberId, String memberPwd, String memberName, String email, Date enrollDate,
			String status) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.email = email;
		this.enrollDate = enrollDate;
		this.status = status;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", email=" + email + ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}

}
