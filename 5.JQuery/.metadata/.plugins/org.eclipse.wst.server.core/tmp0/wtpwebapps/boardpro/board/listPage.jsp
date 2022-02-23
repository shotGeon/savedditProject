<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("pageList");

	int spage = (int) request.getAttribute("spage");
	int epage = (int) request.getAttribute("epage");
	int tpage = (int) request.getAttribute("tpage");
	int curpage = (int) request.getAttribute("curpage");

%>
{
	
	"tpage" : "<%=tpage %>",
	"spage" : "<%=spage %>",
	"epage" : "<%=epage %>",
	"curpage" : "<%=curpage %>",
	"datas" :
	
	
[
<% 

	for(int i=0; i<list.size(); i++){
		BoardVO vo = list.get(i);
		if(i>0) out.print(",");
%>		
	
	{
		"num"     : "<%=vo.getNum() %>",
		"writer"  : "<%=vo.getWriter() %>",
		"subject" : "<%=vo.getSubject() %>",
		"mail"    : "<%=vo.getMail() %>",
		"hit"     : "<%=vo.getHit() %>",
		"wdate"   : "<%=vo.getWdate() %>",
		"content" : "<%=vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>"
	
	
	
	}
	
		
		
		
		
<%		
	}

%>
]

}