<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	int cnt = (int) request.getAttribute("reInsert");
	
	if(cnt>0){
		
		
%>


	{
		"flag" : "답글등록완료"
	
	}
	
	
	
	
	
	
	
<%			
	}else{
%>
	
	{
		"flag" : "답글등록실패"
	
	}
	

<%			
	}
%>