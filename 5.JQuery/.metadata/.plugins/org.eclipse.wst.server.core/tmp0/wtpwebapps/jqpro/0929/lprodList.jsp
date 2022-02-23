<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청 전송시 데이터를 받는다 -현재는 없다.

//데이터 처리 -DB의 CRUD처리 
//1. SqlMapClient객체를 얻어오기

SqlMapClient client = SqlMapClientFactory.getInstance();

//2. mapper에 기술된 sql문장을 실행 한다. - namespace이름.id이름
List<LprodVO> list = client.queryForList("lprod.selectAllItem");

//CRUD처리후 응답데이터를 생성 -html, xml, json, text -현재는 불가
%>
[
	<%
	for(int i=0; i<list.size(); i++){
		LprodVO vo = list.get(i);
		
		if(i>0) out.print(",");
	
	%>
		{
			"id" : "<%=vo.getLprod_id()%>",
			"gu" : "<%=vo.getLprod_gu()%>",
			"nm" : "<%=vo.getLprod_nm()%>"
		
		}
		
	
	<%
	}
	%>

]