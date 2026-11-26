package com.kh.board.model.dto;

import java.sql.Date;

public class AttachmentDto {

	private long fileNo;
	private long refBno;
	private String originName;
	private String changeName;
	private String filePath;
	private int boardType;
	private int fileLevel;
	private Date createDate;
	private String status;
	
	public AttachmentDto() {
		super();
	}

	public AttachmentDto(long fileNo, long refBno, String originName, String changeName, String filePath, int boardType,
			int fileLevel, Date createDate, String status) {
		super();
		this.fileNo = fileNo;
		this.refBno = refBno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.boardType = boardType;
		this.fileLevel = fileLevel;
		this.createDate = createDate;
		this.status = status;
	}

	public long getFileNo() {
		return fileNo;
	}

	public void setFileNo(long fileNo) {
		this.fileNo = fileNo;
	}

	public long getRefBno() {
		return refBno;
	}

	public void setRefBno(long refBno) {
		this.refBno = refBno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
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
		return "AttachmentDto [fileNo=" + fileNo + ", refBno=" + refBno + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", boardType=" + boardType + ", fileLevel=" + fileLevel
				+ ", createDate=" + createDate + ", status=" + status + "]";
	}

}
