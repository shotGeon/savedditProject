<%@page import="com.java.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>회원상세페이지</h1>
	<ul>
		<li><%=((MemberVO)(request.getAttribute("member"))).getId() %>,
			${member.id}
		</li>
		<li><%=((MemberVO)(request.getAttribute("member"))).getPwd() %></li>
	</ul>
</body>
</html>