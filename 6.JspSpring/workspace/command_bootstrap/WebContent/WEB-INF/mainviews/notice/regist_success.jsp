<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("공지사항 등록성공");
	window.opener.location.href="<%=request.getContextPath()%>/notice/list.do";
	window.close();
</script>