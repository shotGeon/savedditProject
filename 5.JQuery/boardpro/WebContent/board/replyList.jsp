<%@page import="kr.or.ddit.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 
List<ReplyVO> list = (List<ReplyVO>) request.getAttribute("list");
%>

[

<%
	for(int i=0; i<list.size(); i++){
		ReplyVO rv = list.get(i);
		if(i>0) out.print(",");
%>

{
	"renum" : "<%=rv.getRenum() %>",
	"bonum" : "<%=rv.getBonum() %>",
	"name" : "<%=rv.getName() %>",
	"cont" : "<%=rv.getCont().replaceAll("\r", "").replaceAll("\n", "<br>") %>",
	"redate" : "<%=rv.getRedate() %>"

}





<%
	}
%>

]