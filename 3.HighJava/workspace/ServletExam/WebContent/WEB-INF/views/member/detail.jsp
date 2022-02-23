<%@page import="kr.or.ddit.cmm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberVO mv = (MemberVO) request.getAttribute("mv");
	String memAddr = mv.getMemAddr().replaceAll(System.lineSeparator(), "<br>");
	List<AtchFileVO> atchFlieList = 
			   (List<AtchFileVO>) request.getAttribute("atchFileList");	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID:</td>
			<td><%=mv.getMemId() %></td>
		</tr>
		
		<tr>
			<td>이름:</td>
			<td><%=mv.getMemName() %></td>
		</tr>
		
		<tr>
			<td>전화번호:</td>
			<td><%=mv.getMemTel() %></td>
		</tr>
		
		<tr>
			<td>주소:</td>
			<td><%=memAddr%></td>
		</tr>
		
		<tr>
			<td>첨부파일</td>
			<td>
				<%
					if(atchFlieList != null){
						for(AtchFileVO fileVO : atchFlieList){
				%>
					
					<div>
					<a href="<%=request.getContextPath()%>/filedownload.do?fileId=<%=fileVO.getAtchFileId()%>&filsSn=<%=fileVO.getFileSn()%>"><%=fileVO.getOrignlFileNm() %></a>
					</div>
				
				
				
				<% 							
						}
					}
				%>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<a href="list.do">[목록으로]</a>
				<a href="update.do?memId=<%=mv.getMemId()%>">[회원정보 수정]</a>
				<a href="delete.do?memId=<%=mv.getMemId()%>">[회원정보 삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>