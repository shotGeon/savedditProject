<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String selectId = (String)request.getAttribute("selectId");
	if(selectId ==null){
%>		
	{
		"sw" : "사용가능한 아이디입니다."
		
	}		
		
		
<%		
	}else{
%>	
		
	{
		"sw" : "사용불가능한 아이디입니다."
		
	}	
		
		
<% 		
	}
%>

