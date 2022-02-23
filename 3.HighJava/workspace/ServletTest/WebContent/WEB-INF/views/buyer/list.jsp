<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BuyerVO> list = (List<BuyerVO>) request.getAttribute("buyerList");
	
	String msg = request.getParameter("msg")==null?
			"" : request.getParameter("msg");

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>buyer_id</th>
			<th>buyer_name</th>
			<th>buyer_bank</th>
			<th>buyer_add1</th>
			<th>buyer_add2</th>
		</tr>
	<%
		int listSize=list.size();
		if(listSize>0){
		for(int i=0; i<list.size(); i++){
		
	%>
		<tr>
			<td><%=list.get(i).getBuyer_id() %></td>
			<td><a href="detail.do?buyer_id=<%=list.get(i).getBuyer_id() %>">
			<%=list.get(i).getBuyer_id() %></a></td>
			<td><%=list.get(i).getBuyer_name() %></td>
			<td><%=list.get(i).getBuyer_bank() %></td>
			<td><%=list.get(i).getBuyer_add1() %></td>
			<td><%=list.get(i).getBuyer_add2() %></td>
		</tr>
	
	<%
		}
		
			}else{
				
			
	%>
		<script>alert("정상적으로 못가져옴")</script>
	
	
	
	<%
			}	
	%>
		<tr align="center">
			<td colspan="4"><a href="insert.do">[회사등록]</a></td>
		</tr>
	
	</table>
	
	<%
		if(msg.equals("성공")){
			
	%>
		<script>alert("삽입 성공!!")</script>
	
	
	<%
		}
	%>		
		
	

</body>
</html>