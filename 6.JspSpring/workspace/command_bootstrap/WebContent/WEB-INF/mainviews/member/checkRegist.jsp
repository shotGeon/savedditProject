<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result gt 0 }">
		<script>
			alert("회원등록이 성공적으로 완료되었습니다.");
			location.href="detail?id=${member.id}";
		</script>
	</c:when>
	
	<c:otherwise>
		<script>
			location.href="/error/500.jsp";
		</script>
	</c:otherwise>
</c:choose>