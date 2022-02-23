<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	int k=Integer.parseInt(request.getParameter("k"));
	if(k>3){
		out.println("<h1>k는 3보다 큽니다.</h1>");
	}
%>

<hr/>

<!-- 스코프를 지정해주지않으면 default는 pageContext다. -->
<c:set var="k" value="${param.k }"/>
<c:if test="${k gt 3 }">
	<h1>k는 3보다 큽니다.</h1>
</c:if>

<hr/>

<%
	int y=Integer.parseInt(request.getParameter("y"));
	if(y>3){
		out.println("<h1>y는 3보다 큽니다.</h1>");
	}
%>

<hr/>

<c:set var="y" value="${param.y }"></c:set>
<c:choose>
	<c:when test="${y gt 3 }">
		<h1>y는 3보다 큽니다.</h1>
	</c:when>
	<c:otherwise>
		<h1>y는 3보다 작습니다.</h1>
	</c:otherwise>

</c:choose>