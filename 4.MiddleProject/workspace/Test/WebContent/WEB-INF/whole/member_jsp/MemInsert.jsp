<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${requestScope.result gt 0 }">
		<script>
			alert("등록성공");
			location.href="/Test/whole/index.html";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("등록실패");
			location.href="/Test/whole/index.html";
		</script>
	</c:otherwise>

</c:choose>
