<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BuyerVO vo = (BuyerVO) request.getAttribute("SelDetail");

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