<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_id = (String) request.getAttribute("insertId");
	if(mem_id !=null){
%>		
	{
		"flag" : "가입성공"
	
	}
	
		
		
	<%}else{%>
	
	{
		"flag" : "가입실패"
	
	}
	
	
<%		
	}
%>