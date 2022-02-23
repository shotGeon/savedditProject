<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 table{
    border :1px solid hotpink;
  	margin : 50px;
 }
 td{
  	width :150px;
  	height :50px;
  	text-align:center;
 }
 #info{
   height :150px;
 }
</style>
</head>
<body>
 JSP: 클라이언트에서 전송시 데이터를 전달받는다
 <%

	request.setCharacterEncoding("UTF-8");
	
	String sid = request.getParameter("id");
	String sname = request.getParameter("name");
	String saddr = request.getParameter("addr");
	String sgend = request.getParameter("gender");
	String sarea = request.getParameter("area");
	//sarea 속에는 엔터기호(\r,\n)를 포함하고 잇다.
	//엔터기호를 <br>태그로 변경한다.
	
	sarea=sarea.replaceAll("\r", "").replaceAll("\n", "<br>");
	
	String[] sfood = request.getParameterValues("food");
	
	String str=" ";
	if(sfood !=null){
	for(int i=0; i<sfood.length; i++){
		
		str+=sfood[i] +"&nbsp;&nbsp;";
	}	
	}else{
		str="선택된 음식이 없습니다.";
	}
 %>
<table border="1">
	<tr>
	  <td>아이디</td>
	  <td><%=sid %></td>
	</tr>
	<tr>
	  <td>이름</td>
	  <td><%=sname %></td>
	</tr>
	<tr>
	  <td>주소</td>
	  <td><%=saddr %></td>
	</tr>
	<tr>
	  <td>성별</td>
	  <td><%=sgend %></td>
	</tr>
	<tr>
	  <td>음식</td>
	  <td><%=str %></td>
	</tr>
	<tr>
	  <td id="info" colspan="2"><%=sarea %></td>
	</tr>
</table>
</body>
</html>