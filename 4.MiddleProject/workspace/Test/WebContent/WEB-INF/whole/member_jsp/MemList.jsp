<%@page import="member.vo.MemVO"%>
<%@page import="Paging.PagingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<style>
* {
	margin: 0px;
	padding : 0px;
}
table {
	margin : 30px 50px 50px 50px;
	border-collapse: collapse;
	text-align: center;
	width : 1000px;
	font-size: 18px;
}

.tr1{
	background: lightblue;
}

.thTitle {
	text-align: center;
}
.tdNum {
	width : 70px;
}
.tdTitle {
	width : 300px;
	text-align: left;
	padding-left : 10px;
}
.tdName {
	width : 100px;
}
.tdDate {
	width : 150px;
}
.tdView {
	width : 100px;
}
.tdCount {
	width : 100px;
}

#searchBar {
	margin-top: 20px;
	position : relative;
	left : 3%;
}

#memInsert, #memChkDelete{
	width: 65px;
}

</style>

<script>
	$(function(){
		if("${requestScope.pagingVO.field}" == "id"){
			$('#sid').prop("selected", true);
		}
		if("${requestScope.pagingVO.field}" == "name"){
			$('#sname').prop("selected", true);
		}
		if("${requestScope.pagingVO.field}" == "email"){
			$('#semail').prop("selected", true);
		}
		if("${requestScope.pagingVO.field}" == "phone"){
			$('#sphone').prop("selected", true);
		}
	})
</script>	
		
<form id="searchBar">
	
	<select name = "f">
	<option id="sname" value="name">이름</option>
	<option id="sid" value="id">아이디</option>
	<option id="semail" value="email">이메일</option>
	<option id="sphone" value="phone">전화번호</option>
	</select>
	<input type="text" name= "q" id ="q" value="${requestScope.pagingVO.query}">
	<input type="button" id="findbutton" value="검색하기">
	<input type="button" id="memInsert" value="등록">
	<input type="button" id="memChkDelete" value="삭제">
</form>  

	<table border="1">
		<tr class="tr1">
			<th class="thTitle"></th>
			<th class="thTitle">이름</th>
			<th class="thTitle">아이디</th>
			<th class="thTitle">전화번호</th>
			<th class="thTitle">이메일</th>
		</tr>
	
	
	<c:set var="list" value="${requestScope.list }"/>
	<c:forEach items="${list}" var="mv">
		<tr class="tr2">
			<td class=mCheck><input class="mem_chk" type="checkbox" name="mem_chk" value="${mv.id}"></td>
			<td class="mName" name="${mv.id}">${mv.name }</td>
			<td class="mId">${mv.id }</td>
			<td class="mPhone">${mv.phone }</td>
			<td class="mEmail">${mv.email }</td>
		
		</tr>
	</c:forEach>	
	
	<!-- 페이징 처리 시작 -->
	<c:if test="${requestScope.pagingVO.totalCount gt 0 }">
		<tr>
				<td colspan="6" align="center">
					<c:forEach var="pNo" begin="${requestScope.pagingVO.firstPageNo}" end="${requestScope.pagingVO.lastPageNo}" step="1">
						<a class="page"
							<c:if test="${pNo eq requestScope.pagingVO.currentPageNo}">
							style=color:orange;
							</c:if>
						>${pNo}</a>
					</c:forEach>
					
				</td>
			</tr>
	
	</c:if>
		<!-- 페이징 처리 끝 -->	
	</table>
	
	
	
	
	
		
		
		
		
		
		
