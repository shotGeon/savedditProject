<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	int sum=0;
	for(int i=1; i<11; i++){
		sum+=i;
	}
	
	out.print(sum);
%>

<hr/>

<c:set var="sum" value="0"></c:set>

<c:forEach var="i" begin="1" end="10" step="1" varStatus="status">

<c:set var="sum" value="${sum + i}"/>
sum : ${sum }, i : ${i }, count : ${status.count }<br/>
</c:forEach>

${sum}

<hr/>

<%
	int[] nums ={1,2,3,4,5,6,7,8,9};
	for(int i : nums){
		out.println(i+"<br/>");
	}
%>

<hr/>

<c:set var="nums" value="<%=nums %>"/>
<c:forEach items="${nums }" var="i">
	${i }<br/>

</c:forEach>


















