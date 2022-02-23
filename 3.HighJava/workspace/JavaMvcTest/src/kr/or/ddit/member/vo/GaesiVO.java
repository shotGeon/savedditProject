package kr.or.ddit.member.vo;

import java.util.Date;

public class GaesiVO {
	int num;
	String title;
	String writer;
	String content;
	Date day;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "GaesiVO [title=" + title + ", writer=" + writer + ", content=" + content + "]";
	}
	
	
	
}
