<%@page import="kr.or.ddit.at.vo.AtVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.clboard.vo.ClBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	ClBoardVO bv = (ClBoardVO) request.getAttribute("bv");
	int id_chk = (int) request.getAttribute("id_chk");
	System.out.println(bv.getBoard_title_id());
	String name = bv.getMem_name().substring(0, 1) + "**";
	String board_title_id = (String)request.getAttribute("board_title_id");
	String boardtitle_id = request.getParameter("boardtitle_id");
%>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="/ShareProject/js/jquery.serializejson.min.js"></script>
  <script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
  
  <link rel="icon" type="image/png" href="/ShareProject/Real_Main_Pages/images/logoIcon.PNG" sizes="96x93">

  <title><%=bv.getBoard_title_name() %></title>
  
<style>
.clButton {
	color : black;
}
#stuInfoBox h2 {
	margin-top : 0px;
    margin-bottom : 15px;
    color : white;
}
#subjectBox {
    display: flex;
    align-items: center;
    width : 230px;
    height: 60px;
    background-color: rgba(255, 255, 255, 0.6);
    font-size: 13px;
    padding: 5px;
    margin-bottom: 10px;
}
p#subject {
	font-size: 13px;
	width : 100%;
	height: 100%;
}
#boardTable {
	width: 60%;
	height: 600px;
	margin-top : 60px;
	margin-bottom: 10px;
	margin-left : 230px;
	font-size: 20px
}
.tr1 {
	height: 70px;
	background-color: lightgray;
	font-weight: bold;
}
.tr2 {
	height: 60px;
	text-align: center;
	font-size: 15px;
}
.tr3 {
	height: 470px;
}
td {
	padding : 10px;
}
.td1 {
	width : 15%;
	text-align: center;
}
.td2 {
	vertical-align: top;
}
.topHr {
	border : 1px solid navy;
	margin-top : 25px;
}
.bottomHr {
	border : 1px solid navy;
	margin-top: 30px;
}
.buttonBox {
	width : 20%;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}
#modalBoxBox {
	width : 90%;
}
.modalInput {
	width : 100%;
}
</style>

<script>
$(function() {
	
	$(document).on('click', '#back', function() {
		if("<%=board_title_id%>" =="BR06"){
			//??? ???????????????
			 location.href="/ShareProject/whole/clBoard/ClQnABoard.html";
		}else if("<%=board_title_id%>" == "BR07"){
			//??? ???????????????
			location.href="/ShareProject/whole/clBoard/ClLunchBoard.html";
		}else if("<%=board_title_id%>" == "BR08"){
			//??? ???????????????
			location.href="/ShareProject/whole/clBoard/ClFreeBoard.html";
		}else if("<%=board_title_id%>" == "BR03"){
			// ????????????
			location.href="/ShareProject/whole/clBoard/ClNoticeBoard.html";
		}
	})
	
	$(document).on('click', '#reportBtn', function() {
			reportData = $('#reportForm').serialize();
			console.log(reportData)
			$('#reportModal').modal('hide');
			$.ajax({
				url:'/ShareProject/Report.do',
				type:'post',
				data: reportData,
				dataType:'json',
				success:function(result){
					if(result.flag == "??????"){
						alert("????????? ?????????????????????.")
					}		
				},
				error:function(xhr){
				}
			})
		})
		
})
</script>

	<hr class="topHr">
	<table id="boardTable" border="1">
		<tr class="tr1">
			<td class="td1">??????</td>
			<td><%=bv.getclBoard_title()%></td>
		</tr>
		
		<tr class="tr2">
			<td colspan="2">
				????????? : <%=name%>&#09;&nbsp;&nbsp;&nbsp;&nbsp;
				????????? : <%=bv.getclBoard_date()%>&#09;&nbsp;&nbsp;&nbsp;&nbsp;
				????????? : <%=bv.getAdminboard_view()%>&#09;&nbsp;&nbsp;&nbsp;&nbsp; 
				????????? : <%=bv.getReply_count()%>
			</td>
		</tr>
		
		<tr class="tr3">
			<td class="td1">??????</td>
			<td class="td2"><%=bv.getclBoard_content()%></td>
		</tr>

	</table>
	<br>

<center><div class="buttonBox">
	<input type="button" id="back" value="??????">
	
	<%
		if (id_chk > 0) {
	%>
	<input type="button" data-toggle="modal" data-target="#UpdateModal" value="??????">
	<input type="button" id="delete" value="??????">
	
	<%
		}
	
		if (board_title_id.equals("BR07")) {
	%>
		<input type="button" id="report" data-toggle="modal" data-target="#reportModal" value="????????????"> 
	<%
		} 
		
		if (board_title_id.equals("BR06") || board_title_id.equals("BR07") || board_title_id.equals("BR08")) {
	%>
		<input type="button" id="response" data-toggle="modal"	data-target="#ResponseModal" value="??????">
		
		<%
		}
		%>
</div></center>

<hr class="bottomHr">

	<!-- Modal ????????????-->
	<div class="modal fade" id="UpdateModal" role="dialog">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4	class="modal-title">??? ??????</h4>
				</div>
				<div class="modal-body">
					<form>
					<div id="modalBoxBox">
						<input type="hidden" name="adminboard_id" value="<%=bv.getAdminboard_id() %>">
						<input class="modalInput" type="text" name="clBoard_title" value="<%=bv.getclBoard_title() %>"/>
						<br>
						<textarea class="modalInput" cols="50" rows="20" style="resize: none;" name="clBoard_content"><%=bv.getclBoard_content() %></textarea>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<input type="button" id="update" class="btn btn-default" value="??????" />
					<button type="button" class="btn btn-default" data-dismiss="modal">??????</button>
				</div>
			</div>
		</div>
	</div>


<!-- Modal ????????????-->
<div class="modal fade" id="reportModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">????????????</h4>
			</div>
			<div class="modal-body">
				<form id="reportForm">
					<div id="modalBoxBox">
						<input type="hidden" name="adminboard_id" value="<%=bv.getAdminboard_id()%>"> 
						<input class="modalInput" type="hidden" name="mem_id" value="<%=bv.getMem_id() %>">
						<br>
						<textarea class="modalInput" cols="30" rows="20" style="resize: none;"	name="report_reason" placeholder="?????? ????????? ??????????????????."></textarea>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<input type="submit" id="reportBtn" class="btn btn-default"	data-dismiss="modal" value="??????"/>
				<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel">??????</button>
			</div>
		</div>
	</div>
</div>