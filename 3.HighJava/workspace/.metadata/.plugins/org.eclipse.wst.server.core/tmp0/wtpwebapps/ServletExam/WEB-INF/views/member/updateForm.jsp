<%@page import="kr.or.ddit.cmm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
	MemberVO mv = (MemberVO) request.getAttribute("mv");
	
	List<AtchFileVO> atchFlieList = 
	(List<AtchFileVO>) request.getAttribute("atchFileList");	

%>

<title>회원 정보 변경</title>
</head>
<body>
<form action="update.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="memId" value="<%=mv.getMemId()%>">
	<input type="hidden" name="atchFileId" value="<%=mv.getAtchFileId()%>">
	<table>
		<tr>
			<td>ID :</td>
			<td><%=mv.getMemId()%></td>
		</tr>
		
		<tr>
			<td>이름 :</td>
			<td><input type="text" name="memName" value="<%=mv.getMemName()%>"></td>
		</tr>
		
		<tr>
			<td>전화번호 :</td>
			<td><input type="text" name="memTel" value="<%=mv.getMemTel()%>"></td>
		</tr>
		
		<tr>
			<td>주소 :</td>
			<td><textarea rows="3" cols="15" name="memAddr"><%=mv.getMemAddr() %></textarea></td>
		</tr>
		
		<tr>
			<td>기존 첨부파일:</td>
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
			<td>새로운 첨부파일:</td>
			<td><input type="file" name="atchFile" multiple></td>
		</tr>
	</table>
	
	<input type="submit" value="회원정보 수정">
</form>	
</body>
</html>