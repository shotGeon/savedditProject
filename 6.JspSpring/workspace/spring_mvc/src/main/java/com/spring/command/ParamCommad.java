package com.spring.command;

public class ParamCommad {
	
	String id;
	String pwd;
	int num;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "ParamCommad [id=" + id + ", pwd=" + pwd + ", num=" + num + "]";
	}
	
	
}
