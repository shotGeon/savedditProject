<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BuyerVO bv = (BuyerVO)request.getAttribute("selbuyer");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사 상세 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>buyer_id</td>
			<td><%=bv.getBuyer_id() %></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<a href="list.do">[목록으로]</a>
				<a href="delete.do?buyer_id=<%=bv.getBuyer_id()%>">[회사정보삭제]</a>
				<a href="update.do?buyer_id=<%=bv.getBuyer_id() %>">[회사정보수정]</a>
			</td>
		</tr>
	
	</table>

</body>
</html>