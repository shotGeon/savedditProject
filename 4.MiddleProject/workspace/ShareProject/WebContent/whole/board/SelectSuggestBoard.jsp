<%@page import="kr.or.ddit.board.vo.AdminreVO"%>
<%@page import="kr.or.ddit.at.vo.AtVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
<%
	BoardVO bv = (BoardVO) request.getAttribute("bv");
	String mem_id = (String) request.getAttribute("mem_id");
	int adminboard_id = (int)request.getAttribute("board_id");
	int id_chk =(int) request.getAttribute("id_chk");
	String name = bv.getMem_name().substring(0, 1) + "**";
	List<AdminreVO> list = (List<AdminreVO>) request.getAttribute("list");
	String mem_name = (String) request.getAttribute("mem_name");
	
	if(id_chk==0){
%>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	<script src="/ShareProject/js/jquery.serializejson.min.js"></script>

<style>
#modalBoxBox {
	width : 90%;
}
.modalInput {
	width : 100%;
}
</style>

<script>
$(function(){
	alert("본인계정 게시글이 아닙니다.");
	location.href="./SuggestBoard.html";
	//location.href="/WEB-INF/whole/board_jsp/ListBoard.jsp";
	
})
</script>	
	

<%		
	}else{
%>


<hr class="topHr">
<div id="bbbox">
<table id="atchTable" border="1">
	<tr>
		<td class="tdColor td na" colspan="3"><%=bv.getBoard_title() %></td>
	</tr>	
<%
		if(id_chk > 0 && !mem_id.equals("admin")){
%>
		<tr>
		<td colspan="3" class="td">
		<input type="button" data-toggle="modal" data-target="#UpdateModal" value="수정">
		<input type="button" name="<%=bv.getAdminboard_id()%>" id="delete" value="삭제">
		</tr>
<%
		}
%>	
	<tr>
		<td colspan="3" class="td">
		작성자 <%=name %>&nbsp;&nbsp;&nbsp;&nbsp; 
		작성일 <%=bv.getBoard_date() %>&nbsp;&nbsp;&nbsp;&nbsp; 
		조회수 <%=bv.getAdminboard_view() %>&nbsp;&nbsp;&nbsp;&nbsp; 
		댓글수 <%=bv.getReply_count() %>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	
	<tr>
		<td colspan="3"><%=bv.getBoard_content() %></td>
	</tr>
	<tr>
		<td colspan="2" class="td na">답글</td>
<%
		if(mem_id.equals("admin")){
%>
		<td class="re td na">
		<input type="button" data-toggle="modal" data-target="#ResponseModal" value="답글" id="response">
		</td>
<%			
		}
%>
	</tr>
		<%
			if(list.size()>0){
	
			for(int i=0; i<list.size(); i++){
				AdminreVO arv = list.get(i);
		%>
		<tr>
			<td class="writer td"><%=arv.getMem_name()%></td>
			<td id="recont<%=i %>" class="td"><%=arv.getAdminre_content()%></td>
			<td id="inputParent" class="re td">
			<input id="<%=arv.getMem_id()%>" name="recont<%=i %>" type="button" class="reUpdate"value="답글수정"> 
			<input id="<%=arv.getMem_id()%>" type="button" class="reDelete" value="답글삭제"> 
			<input type="hidden" id="<%=arv.getAdminre_num()%>" class="adminre_num">
			</td>
		</tr>		
		<%
				}
			}
		
		%>
	<tr>
		<td colspan="3" class="cc td">
		<input type="button" id="back" value="뒤로" >
		</td>
	</tr>
	
</table>
</div>
<hr class="bottomHr">

	<!-- Modal -->
	<div class="modal fade" id="UpdateModal" role="dialog">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4	class="modal-title">글 수정</h4>
				</div>
				<div class="modal-body">
					<form>
					<div id="modalBoxBox">
						<input class="modalInput" type="hidden" name="adminboard_id" value="<%=bv.getAdminboard_id() %>">
						<input class="modalInput" type="text" name="board_title" value="<%=bv.getBoard_title() %>"/><br>
						<textarea class="modalInput" cols="50" rows="20" style="resize: none;" name="board_content"><%=bv.getBoard_content() %></textarea>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<input type="button" id="mupdate" class="btn btn-default" value="수정" />
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
	
	
		<!-- Modal 답글(관리자)-->
	<div class="modal fade" id="ResponseModal" role="dialog">
		<div class="modal-dialog">
		
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4	class="modal-title">답글</h4>
				</div>
				<div class="modal-body">
					<form>
					<div id="modalBoxBox">
						<input class="modalInput" type="hidden" name="adminboard_id" value="<%=bv.getAdminboard_id() %>">
						<input class="modalInput" type="hidden" name="mem_id" value="<%=mem_id%>">
						<textarea class="modalInput" cols="50" rows="20" style="resize: none;" name="adminre_content"></textarea>
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<input type="button" id="reinsert" class="btn btn-default" value="등록" />
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
<%		
	}
%>
      <!-- Modal 답글수정 -->
				<div class="modal fade" id="reUpdateModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">답글 수정</h4>
							</div>
							<div class="modal-body">
								<form>
								<div id="modalBoxBox">
									<input class="modalInput" type="hidden" name="adminboard_id" value="<%=bv.getAdminboard_id() %>">
									<textarea class="modalInput" id="rerecontent" cols="50" rows="20" style="resize: none;" name="adminre_content"></textarea>
								</div>
								</form>
							</div>
							<div class="modal-footer">
								<input type="button" id="remupdate" class="btn btn-default"
									value="수정" />
								<!-- <input type="button" id="redelete" class="btn btn-default" value="삭제">  -->
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>

