<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.ibatis.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SqlMapClient client = SqlMapClientFactory.getInstance();

BuyerVO vo = (BuyerVO)client.queryForObject
            ("buyer.selectDetail", request.getParameter("id"));
%>

{
	"id" : "<%=vo.getBuyer_id()%>",
	"name" : "<%=vo.getBuyer_name()%>",
	"lgu" : "<%=vo.getBuyer_lgu() %>",
	"bank" : "<%=vo.getBuyer_bank()%>",
	"bankno" : "<%=vo.getBuyer_bankno()%>",
	"bankname" : "<%=vo.getBuyer_bankname() %>",
	"zip" : "<%=vo.getBuyer_zip() %>",
	"add1" : "<%=vo.getBuyer_add1() %>",
	"add2" : "<%=vo.getBuyer_add2() %>"

}
