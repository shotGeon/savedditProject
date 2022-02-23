<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
		<th>주소</th>
		<th>이메일</th>
	</tr>
	
	<c:forEach items="${requestScope.memberList }" var="member">
		<tr>
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.name }</td>
			<td>${member.address }</td>
			<td>${member.phone }</td>
		</tr>
	
	</c:forEach>	
	
</table>