<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//서블릿에서 수행한 결과값을 가져온다.

List<LprodVO> list = (List<LprodVO>) request.getAttribute("selAllItem");

%>


[

<%
	for(int i=0; i<list.size(); i++){
		LprodVO vo = list.get(i);
		if(i>0) out.print(",");
%>
	
	{
		"nm" : "<%=vo.getLprod_nm() %>",
		"gu" : "<%=vo.getLprod_gu() %>"
	}


<%
	}
%>


]

