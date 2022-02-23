<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("수정성공");
	
	location.href="detail.do?nno=${notice.nno}&from=modify";
</script>