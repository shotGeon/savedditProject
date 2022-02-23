<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:choose>
	<c:when test="${requestScope.check gt 0 }">
		{
			"flag" : "아이디 중복"
		}
	</c:when>
	<c:otherwise>
		{
			"flag" : "사용가능"
		}
	</c:otherwise>	
</c:choose>

