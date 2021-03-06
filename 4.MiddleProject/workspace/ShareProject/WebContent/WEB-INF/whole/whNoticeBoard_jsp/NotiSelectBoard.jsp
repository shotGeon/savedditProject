<%@page import="kr.or.ddit.board.vo.NoticeVO"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	NoticeVO nv = (NoticeVO) request.getAttribute("nv");
	String mem_id = (String) request.getAttribute("mem_id");
	String boardtitle_id = (String)request.getAttribute("board_title_id");
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--※필수※ 아이콘, 스타일-->
    <script src="https://kit.fontawesome.com/b69eadd32e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalStyle.css">
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalMainStyle.css">
    <!--↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑-->
	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	
    <title>Share Project</title>

<style>
.clButton {
	color : black;
}
#stuInfoBox h2 {
	margin-top : 0px;
    margin-bottom : 15px;
    color : black;
    font-weight: bold;
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
	border : 1px solid orange;
	margin-top : 2%;
}
.bottomHr {
	border : 1px solid orange;
	margin-top: 5%;
}
.buttonBox {
	width : 11%;
	display: flex;
	flex-direction: row;
	justify-content: space-around;
}
.updateInputBox {
	width : 90%;
	margin-left : 5%;
	margin-bottom : 1%;
	padding : 2%;
}
.reportInputBox {
	width : 90%;
	margin-left : 5%;
	padding : 2%;
}
</style>

<script>
	$(function() {
		
		$(document).on('click', '#back', function() {
			if("<%=boardtitle_id%>" == "BR01"){
				//반 질문게시판
				 location.href="/ShareProject/whole/whNoticeBoard_jsp/NotiListBoard.jsp";
			}
		})
		// 관리자 마이페이지 => 관리자페이지
			$('#mypage').on('click', function(){
		$.ajax({
			url: '/ShareProject/Admin.do',
			type: 'get',
			dataType: 'json',
			success: function(res){
				if(res.flag=="admin"){
					location.href="/ShareProject/whole/admin/admin_html/AdminPage.html";
				}
			},
			error: function(xhr){
			}
		})
	})
		

	$('#update').on('click', function() {
		adminboard_id = $('#adminboard_id').val();
		notice_title = $('#notice_title').val();
		notice_content = $('#notice_content').val();

		$.ajax({
			url : '/ShareProject/NoticeUpdateBoard.do',
			type : 'get',
			data : {
				'adminboard_id' : adminboard_id,
				'notice_title' : notice_title,
				'notice_content' : notice_content
			},
			dataType : 'json',
			success : function(res) {
				if (res.flag == "수정성공") {
					$('#UpdateModal').modal('hide');
					location.reload();
				}

			},
			error : function(xhr) {
			}
		})

	})

	$('#delete').on('click', function() {
		adminboard_id = $('#adminboard_id').val();

		$.ajax({
			url : '/ShareProject/NoticeDeleteBoard.do',
			type : 'get',
			data : {
				'adminboard_id' : adminboard_id
			},
			dataType : 'json',
			success : function(res) {
				location.href = "/ShareProject/whole/board/NoticBoard.html";
			},
			error : function(xhr) {
			}
		})
	})	
	
	})
</script>


</head>

<body>
    <div id="page-wrap">
        <aside id="leftMenu">
            <div id="logoImg">
         	    <a href="/ShareProject/MainPage.do">
              	  <img id="mainlogo" src="/ShareProject/Real_Final_Pages/images/menulogo.PNG" alt="mainlogo">
                </a>
            </div>

            <div id="infoBox">
                <div id="stuInfoBox">
                    <h2>공밀레</h2>
                    <div id="subjectBox">
                        <p id="subject">[기업맞춤형] 전자정부 표준 프레임워크 기반 풀-스택 개발자 양성과정(15기)</p>
                    </div>
                    
                    <div id="MMLOption">
                        <a id="mypage" class="infOption" href="/ShareProject/whole/member/myPage.html"><i class="fas fa-house-user"></i>&nbsp;마이페이지</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="infOption" href="/ShareProject/whole/member/message.html"><i class="far fa-envelope"></i>&nbsp;쪽지</a>
                        <br>
                        <a class="infOption" href="/ShareProject/Real_Final_Pages/Final_LoginPage.html"><i class="fas fa-sign-out-alt"></i>&nbsp;로그아웃</a>
                    </div>
                </div>
            </div>

            <div id="classBtn">
                <a href="/ShareProject/ClassMainPage.do"><input type="button" class="clButton" value="클래스 입장하기"></a>
            </div>
           <ul id="ulBox">
                <li class="menuList"><a class="aMenuList" href="/ShareProject/Cal.do"><i class="far fa-calendar-alt"></i>&nbsp;&nbsp;기관일정</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/NoticBoard.html"><i class="mIcons fas fa-exclamation-circle"></i>&nbsp;&nbsp;공지사항</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/TreeView.do"><i class="mIcons fas fa-paperclip"></i>&nbsp;&nbsp;자료공유</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/MakeUPBoard.html"><i class="mIcons far fa-file-alt"></i>&nbsp;&nbsp;보강자료</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/WHQnABoard.html"><i class="mIcons fas fa-question-circle"></i>&nbsp;&nbsp;질문게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/FreeBoard.html"><i class="mIcons fas fa-users"></i>&nbsp;&nbsp;자유게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/MarketBoard.html"><i class="mIcons fas fa-shopping-basket"></i>&nbsp;&nbsp;장터게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/ReviewBoard.html"><i class="mIcons fas fa-user-graduate"></i>&nbsp;&nbsp;수료후기</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/comp/ComBoard.html"><i class="mIcons far fa-building"></i>&nbsp;&nbsp;회사정보</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/SuggestBoard.html"><i class="mIcons fas fa-wrench"></i>&nbsp;&nbsp;건의사항</a></li>
            </ul>
            <div id="copyBox">
                <p id="copyright">Copyright 2021 Share Project<br>
                Design: 공밀레</p>
            </div>
        </aside>

		<aside id="rightMain">
			<div id="boardBox">
			<hr class="topHr">
				<table id="boardTable" border="1">
					<tr class="tr1">
						<td class="td1">제목</td>
						<td><%=nv.getNotice_title()%></td>
					</tr>
					
					<tr class="tr2">
						<td colspan="2">작성자 : 관리자&#09;&nbsp;&nbsp;&nbsp;&nbsp;
										작성일 : <%=nv.getNotice_date()%>&#09;&nbsp;&nbsp;&nbsp;&nbsp;
										조회수 : <%=nv.getAdminboard_view()%>&#09;
						</td>
					</tr>
					
					<tr class="tr3">
						<td class="td1">내용</td>
						<td class="td2"><%=nv.getNotice_content()%></td>
					</tr>
					
				</table>
				
				<center><div class="buttonBox">
						<td><input type="button" id="back" value="뒤로"></td>
						<%
							if (mem_id.equals("admin")) {
						%> 
							<input type="button" data-toggle="modal" data-target="#UpdateModal" value="수정"> 
							<input type="button" id="delete" value="삭제">
						<%
							}
						%>
				</div></center>
				<hr class="bottomHr">

				<!-- Modal -->
				<div class="modal fade" id="UpdateModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">글 수정</h4>
							</div>
							<div class="modal-body">
								<form>
									<input id="adminboard_id" type="hidden" name="adminboard_id" value="<%=nv.getAdminboard_id()%>"> 
									<input class="updateInputBox" id="notice_title" type="text" name="notice_title" value="<%=nv.getNotice_title()%>" /><br>
									<textarea class="updateInputBox" id="notice_content" cols="50" rows="20" style="resize: none;" name="notice_content"><%=nv.getNotice_content()%></textarea>
								</form>
							</div>
							<div class="modal-footer">
								<input type="button" id="update" class="btn btn-default" value="수정"/>
								<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
	</div>
</body>
</html>