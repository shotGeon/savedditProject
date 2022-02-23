<%@page import="kr.or.ddit.member.controller.IdCheck"%>
<%@page import="kr.or.ddit.member.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

MemVO mv = (MemVO) request.getAttribute("check");
int count =(int)request.getAttribute("count");
if(mv != null){
	
%>	
	{
		"flag"	: "로그인 성공"
	
	}
	
	
<% 
   }else{
     
%>	   
	
	{
	
		"flag" : "로그인 실패",
		"count" : "<%=count %>"
	}   
	   
	   
	   
<%	   
   }
%>