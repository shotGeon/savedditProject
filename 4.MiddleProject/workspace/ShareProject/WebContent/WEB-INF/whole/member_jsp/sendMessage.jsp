<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int cnt = (Integer) request.getAttribute("sendMsg");
	
	if(cnt>0){
%>		
	<script>
		document.location.href='/ShareProject/whole/member/message.html';
	</script>
	
	
	
		
		
<%	
	}else{
		
%>		
	
	<script>
		alert("메시지 보내기 실패");
		document.location.href='/ShareProject/whole/member/message.html';
	</script>
	
	
	
	
	
<%		
		
	}
%>