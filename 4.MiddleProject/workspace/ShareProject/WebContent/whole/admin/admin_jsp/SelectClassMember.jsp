<%@page import="kr.or.ddit.board.vo.PagingVO"%>
<%@page import="kr.or.ddit.adminClass.vo.AdminClassVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<AdminClassVO> memberlist =(List<AdminClassVO>) request.getAttribute("memberList");
	PagingVO pv = (PagingVO) request.getAttribute("pv");
%>
<meta charset="utf-8">
<title>반 정보 상세 조회</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="/ShareProject/js/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="/ShareProject/js/jquery.serializejson.min.js"></script>
<style>

table {
	margin : 30px 50px 50px 50px;
	border-collapse: collapse;
	text-align: center;
	width : 1000px;
	font-size: 18px;
}
#newPost {
	color : orange;
	font-weight: bold;
	text-decoration: none;
}
#boardH2 {
	margin-top : 25px;
	margin-left: 45px;
	margin-bottom: 10px;
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
#boardHr {
	border : 2px solid orange;
}
#searchBar {
	margin-top: 10px;
	position : relative;
	left : 60%;
}
</style>
    <script>

	$(function() {

		mem_id = '';
		chk = '';

		chkList = function() {
			$("input[name=mem_chk]:checked").each(function() {
				chk += $(this).val() + ",";
			})
		}

		$(document).on('click', '#classdeletemember', function() {
			chkList();
			$.ajax({
				url : '/ShareProject/ClassDeleteMember.do',
				type : 'post',
				data : {
					"chk" : chk
				},
				dataType : 'json',
				success : function(res) {
					location.reload();
					alert("회원삭제 완료");
				},
				error : function(xhr) {
				}

			})
		})

	})
    </script>
<h2 id="boardH2"> 반 정보 상세 조회</h2>
<hr id="boardHr">
<table border="1">
	<%
		for(int i = 0; i < memberlist.size(); i++){
			AdminClassVO vo = memberlist.get(i);
	%>
		<%
			if(vo.getMem_group().equals("pro")){
		%>
	<tr class="tr1">
	<th class="thTitle" colspan="5">담당 교수 : <%=vo.getMem_name() %></th>
	
	</tr>
		<%
			}
		}
	%>
	<tr class="tr1">
		<th class="thTitle">
			<input id="classdeletemember" type="button" value="회원삭제">
		</th>
		<th class="thTitle">반</th>
		<th class="thTitle">구분</th>
		<th class="thTitle">이름</th>
		<th class="thTitle">연락처</th>
	</tr>
	
	<%
		for(int j = 0; j < memberlist.size(); j++){
			AdminClassVO vo2 = memberlist.get(j);
	%>
		<%
			if(vo2.getMem_group().equals("stu")){
		%>	
	
	<tr class="tr2">	
		<td class="tdView"><input class="mem_chk" type="checkbox" name="mem_chk" value="<%=vo2.getMem_id() %>"></td>
		<td class="tdView"><%= vo2.getClass_name() %></td>
		<td class="tdDate"><%= vo2.getMem_group() %></td>
		<td class="memname tdName"><%= vo2.getMem_name() %></td>
		<td class="title tdTitle"><%= vo2.getMem_hp() %></td>
	</tr>
	<%
			}
		}
	%>
	
	<%if(pv.getTotalCount() > 0){ %>
			<tr>
				<td colspan="6" align="center">
				<%if(pv.getFirstPageNo() > pv.getPageSize()){ %>
				<a class="pre" name="<%=pv.getFirstPageNo() - pv.getPageSize() %>">[이전]</a>
				
				<%} %>
				<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
				<a class="page<%if(pNo==pv.getCurrentPageNo()){%>select<%} %>"><%=pNo%></a>
				<%} %>
				
				<%if(pv.getLastPageNo() < pv.getTotalCount()){ %>
				<a class="next" name="<%=pv.getFirstPageNo() + pv.getPageSize() %>">[다음]</a>
				<%} %>
				</td>
			</tr>
			
		<%} %>
		<tr>
			<td colspan="5">
				<input onclick="history.go(-1);" type="button" value="목록으로">
			</td>		
		</tr>
<tr>
	<td colspan="5">	
		<input type="hidden" id="classmember" value=<%= pv.getClass_id() %>>
	</td>
</tr>

</table>

