<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String str ="a,b,c,d";
	StringTokenizer token = new StringTokenizer(str,",");
	while(token.hasMoreTokens()){
		String nextToken = token.nextToken();
		out.println(nextToken+"<br/>");
	}
%>

<hr/>

<c:forTokens items="a,b,c,d" delims="," var="k">
${k}<br/>
</c:forTokens>




