<%@page import="kr.or.ddit.member.vo.MemberVO"%>
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
List<MemberVO> list = client.queryForList("member.selectAllMember");

//CRUD처리후 응답데이터를 생성 -html, xml, json, text -현재는 불가
%>

[
	
	<%
	for(int i=0; i<list.size(); i++){
		MemberVO vo = list.get(i);
		//out은 내장객체이기때문에 선언하지 않고 사용할 수 있다.
		//jsp내장객체 알아보자
		if(i>0) out.print(",");
	%>	
		{
		  "id" : "<%=vo.getMem_id()%>",
		  "name" : "<%=vo.getMem_name()%>",
		  "hp" : "<%=vo.getMem_hp()%>",
		  "mail" : "<%=vo.getMem_mail()%>", 
		  "add1" : "<%=vo.getMem_add1()%>",
		  "add2" : "<%=vo.getMem_add2()%>",
		  "zip" : "<%=vo.getMem_zip()%>",
		  "bir" : "<%=vo.getMem_bir()%>"
		}
		
	<%
	}	
	%>

]

