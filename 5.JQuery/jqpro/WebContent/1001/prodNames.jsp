<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//서블릿에서 수행한 결과값 가져오기

List<ProdVO> list = (List<ProdVO>) request.getAttribute("selbylgu");

if(list != null &&list.size()>0){
%>
{
	"flag" : "ok",
	"datas" :

 [
<%
 for(int i=0; i<list.size(); i++){
	ProdVO pv =list.get(i);
	
	if(i>0) out.print(","); 
%>

	{
		"nm" : "<%=pv.getProd_name() %>",
		"id" : "<%=pv.getProd_id() %>"
	
	}


<%
   }
%>
  ]
}

<% }else{ %>
	
	{
		"flag" : "no"
		
	}


	
<%

}

%>	
	











