<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("list");
	
%>
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<table border="1">
		<tr>
			<th>prod_id</th>	
			<th>prod_name</th>	
			<th>prod_lgu</th>	
			<th>prod_buyer</th>	
			<th>prod_cost</th>	
			<th>prod_price</th>	
			<th>prod_sale</th>	
			<th>prod_outline</th>	
			<th>prod_img</th>	
			<th>prod_totalstock</th>	
			<th>prod_properstock</th>	
		</tr>
<%	
	if(list.size()>0){
		for(int i=0; i<list.size(); i++){
			ProdVO pv = list.get(i);
%>
	<tr>
		<td><%=pv.getProd_id() %></td>
		<td><%=pv.getProd_name() %></td>
		<td><%=pv.getProd_lgu() %></td>
		<td><%=pv.getProd_buyer() %></td>
		<td><%=pv.getProd_cost() %></td>
		<td><%=pv.getProd_price() %></td>
		<td><%=pv.getProd_sale() %></td>
		<td><%=pv.getProd_outline() %></td>
		<td><%=pv.getProd_img() %></td>
		<td><%=pv.getProd_totalstock() %></td>
		<td><%=pv.getProd_properstock() %></td>
	</tr>

<%		
		}
%>
	
		
<%
	}else{
%>		
	<tr>
		<td colspan="11">상품없음</td>
	</tr>
			
<%	
	}

%>

	</table>
	<input type="button" id="prodInsert" value="등록">		
	</html>