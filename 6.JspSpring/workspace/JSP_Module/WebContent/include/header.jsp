<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="kim's system"/></title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/main.css"/>

<decorator:head />
</head>
<body>
	<c:set var="cmsg" value="c:set메시지입니다." scope="page"/>
	<div style="max-width: 1280px; height: 100%; margin:0 auto;">
	
	<div id="header">
		<h1>header 입니다.</h1>
	</div>