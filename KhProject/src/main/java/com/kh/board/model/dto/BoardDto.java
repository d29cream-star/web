package com.kh.board.model.dto;

import java.util.Date;

public class BoardDto {

	private long boardId;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private int count;
	private Date createDate;
	private String status;
	
	public BoardDto() {
		super();
	}
	public BoardDto(long boardId, String memberId, String boardTitle, String boardContent, int count, Date createDate,
			String status) {
		super();
		this.boardId = boardId;
		this.memberId = memberId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
	}
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", memberId=" + memberId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", count=" + count + ", createDate=" + createDate + ", status="
				+ status + "]";
	}
	
}
