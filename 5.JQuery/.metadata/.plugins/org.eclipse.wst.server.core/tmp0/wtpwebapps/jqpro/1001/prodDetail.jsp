<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ProdVO pv = (ProdVO) request.getAttribute("selbydetail");

%>

{

	"id" : "<%=pv.getProd_id() %>",
	"name" : "<%=pv.getProd_name() %>",
	"lgu" : "<%=pv.getProd_lgu() %>",
	"buyer" : "<%=pv.getProd_buyer() %>",
	"cost" :"<%=pv.getProd_cost() %>",
	"price" : "<%=pv.getProd_price() %>",
	"sale" : "<%=pv.getProd_sale() %>"
	

}