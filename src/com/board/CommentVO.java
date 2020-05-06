package com.board;

public class CommentVO {
	private int cnum;
	private String name;
	private String regdate;
	private String msg;
	private int bnum;
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate == null ? "" : regdate.trim();
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getMsg() {
		return msg == null ? "" : msg.trim();
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	
	
	
	
	
}
