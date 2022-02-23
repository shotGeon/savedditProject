package com.jsp.command;

import com.jsp.dto.ReplyVO;

public class ReplyCommand {
	
	private String bno;
	
	private String replyer;
	
	private String replytext;

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public String getReplytext() {
		return replytext;
	}

	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		
		reply.setBno(Integer.parseInt(bno));
		reply.setReplyer(replyer);
		reply.setReplytext(replytext);
		
		return reply;
	}
	
	
}
