<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int res = (Integer) request.getAttribute("result");
	System.out.println(res);
	if(res > 0){
%>
	{
		"flag" : "성공"
	}
<%
	}else{
%>
	{
		"flag" : "실패"
	}

<%
	}
%>