package com.jsp.command;

import com.jsp.dto.ReplyVO;

public class ReplyRemoveCommand {
	
	private String rno;
	private String page;
	private String bno;
	
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	
	
	
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		
		reply.setRno(Integer.parseInt(rno));
		reply.setBno(Integer.parseInt(bno));
		
		return reply;
	}
	
	
	
	
	
	

}
