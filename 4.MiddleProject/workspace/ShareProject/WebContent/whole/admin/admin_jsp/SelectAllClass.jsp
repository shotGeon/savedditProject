<%@page import="kr.or.ddit.board.vo.PagingVO"%>
<%@page import="kr.or.ddit.adminClass.vo.AdminClassVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="/ShareProject/js/jquery-3.6.0.js"></script>
  <script src="/ShareProject/js/jquery.serializejson.min.js"></script>
  
<%
	List<AdminClassVO> classlist = (List<AdminClassVO>) request.getAttribute("classList");
	PagingVO pv = (PagingVO) request.getAttribute("pv");
%>
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
#insertClassModal label {
	width: 60px;
}
</style>
<h2 id="boardH2"> 반 관리</h2>
<hr id="boardHr">
<table border="1">
	<tr class="tr1">
		<th class="thTitle">
			<input id="insertclass" type="button" value="반 등록">
			<input id="deleteclass" type="button" value="반 삭제">
		</th>
		<th class="thTitle">반 아이디</th>
		<th class="thTitle">반 이름</th>
		<th class="thTitle">입학일</th>
		<th class="thTitle">수료일</th>
	</tr>
	<%
		for(int i = 0; i < classlist.size(); i++){
			AdminClassVO vo = classlist.get(i);
	%>
	
	<tr class="tr2">
		<td class="tdView"><input class="class_chk" type="checkbox" name="class_chk" value="<%=vo.getClass_id() %>"></td>
		<td class='classid tdView'><%= vo.getClass_id() %></td>
		<td class='classname tdDate'><%= vo.getClass_name() %></td>
		<td class="tdName"><%=vo.getClass_start()%></td>
		<td class="tdName"><%=vo.getClass_end()%></td>
	</tr>
<%
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
			<input onclick="history.go(-1);" type="button" value="뒤로가기">
		</td>
	</tr>
</table>
<html>
<head>
<script>
$(function(){
	$('#insertclass').on('click', function(){
		$('#insertClassModal').modal('show');
	})
	
	$(document).on('click', '#binsert', function(){
		datas = $('#insertClassModal form').serialize();
		$.ajax({
			url: '/ShareProject/InsertClass.do',
			data: datas,
			type: 'post',
			dataType: 'json',
			success:function(res){
				$('#insertClassModal .fin').val("");
				$('#insertClassModal').modal('hide');
				location.href="/ShareProject/whole/admin/admin_html/adminClass.html";
			},
			error: function(xhr){
			}
		})
	})
})

</script>
</head>
<body>
<!-- Modal -->
<div id="insertClassModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">반 등록</h4>
      </div>
      <div class="modal-body">
         <h3>반 등록</h3>
           <form action="/ShareProject/InsertClass.do" method="post">
         	  <br>
         	  <label>반 아이디</label>
         	  <input class="fin clsid" type="text" name="class_id" ><br>

         	  <label>반 이름</label>
         	  <input class="fin clsname" type="text" name="class_name"><br>

         	  <label>입학일</label>
         	  <input class="fin classstart" type="date"  name="class_start"><br>

         	  <label>수료일</label>
         	  <input class="fin classend" type="date" name="class_end"><br>

         	  <button type="button" id="binsert" class="btn btn-success">등록</button>
           </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>



</body>
</html>