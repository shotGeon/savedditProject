<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("allList");
%>

[

<%
	for(int i=0; i<list.size(); i++){
		BoardVO bv = list.get(i);
		if(i>0) out.print(",");
%>		
	
	{
			
		"subject" : "<%=bv.getSubject() %>",
		"writer" : "<%=bv.getWriter() %>",
		"mail" : "<%=bv.getMail() %>",
		"password" : "<%=bv.getPassword() %>",
		"content" : "<%=bv.getContent() %>",
		"hit" : "<%=bv.getHit() %>",
		"wip" : "<%=bv.getWip() %>",
		"wdate" : "<%=bv.getWdate() %>"
	
	}		
	
		
<%		
	}
%>

]