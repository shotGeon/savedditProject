<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${count gt 0 }" >
	<c:set var="id" value="${id }"/>
	<script>
		alert("등록성공");
		location.href="<%=request.getContextPath()%>/member/memberDetail.jsp";
	</script>
</c:if>

<c:if test="${count lt 0 }">
	<script>
		alert("등록실패");
		history.go(-1);
	</script>

</c:if>
