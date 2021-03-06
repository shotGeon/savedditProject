<%@page import="kr.or.ddit.member.vo.MsgVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MsgVO mv = (MsgVO) request.getAttribute("msgVO");
%>

<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="/ShareProject/js/jquery-3.6.0.js"></script>
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
$(function(){
	$('#delete').on('click', function(){
		$.ajax({
			url : '/ShareProject/DeleteSelectMsg.do',
			type : 'get',
			data : {"msg_num" : <%=mv.getMsg_num()%>},
			dataType : 'json',
			success : function(res){
				location.href="/ShareProject/whole/member/message.html";
			},
			error : function(xhr){
				alert(xhr.status);
			}
		})
	})
	
	$('#response').on('click', function(){
		$('#msgModal').modal('show');
	})
	// 관리자 마이페이지 =>관리자페이지
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
	
	
	$('#back').on('click', function(){
		location.href='/ShareProject/whole/member/message.html';
	})
})
</script>

</head>
<body>

	<%-- <div>
		<input id="delete" type ="button" value="삭제">
		<input id="response" type="button" value="답장">
		<br><br>
		
		보낸사람:<%=mv.getMsg_to() %>
		<br>
		받은시간:<%=mv.getMsg_date() %>
		<br>
		내용<br>
		<%=mv.getMsg_content() %>
	</div> --%>
	
	<%-- <table id="boardTable" border="1">
					<tr class="tr1">
						<td class="td1">보낸사람</td>
						<td><%=mv.getMsg_to() %></td>
					</tr>
					
					<tr class="tr2">
						<td colspan="2">받은시간:<%=mv.getMsg_date() %>&#09;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					
					<tr class="tr3">
						<td class="td1">내용</td>
						<td class="td2"><%=mv.getMsg_content() %></td>
					</tr>
					
					<tr>
						<td colspan="3"><input type="button" id="back" value="뒤로">
						<input id="delete" type ="button" value="삭제">
						<input id="response" type="button" value="답장"></td>
					</tr>
				</table> --%>
	
				<!-- <center><div class="buttonBox">
						
							<input id="delete" type ="button" value="삭제">
							<input id="response" type="button" value="답장">
							
				</div></center> -->
		
		
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
                <a href="/ShareProject/Real_Main_Pages/Final_Class_MainPage.html"><input type="button" class="clButton" value="클래스 입장하기"></a>
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
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/ComBoard.html"><i class="mIcons far fa-building"></i>&nbsp;&nbsp;회사정보</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/board/SuggestBoard.html"><i class="mIcons fas fa-wrench"></i>&nbsp;&nbsp;건의사항</a></li>
            </ul>
            <div id="copyBox">
                <p id="copyright">Copyright 2021 Share Project<br>
                Design: 공밀레</p>
            </div>
        </aside>

        <aside id="rightMain">
            <div id="boardBox">
            <table id="boardTable" border="1">
					<tr class="tr1">
						<td class="td1">보낸사람</td>
						<td><%=mv.getMsg_to() %></td>
					</tr>
					
					<tr class="tr2">
						<td colspan="2">받은시간:<%=mv.getMsg_date()%>&#09;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
					
					<tr class="tr3">
						<td class="td1">내용</td>
						<td class="td2"><%=mv.getMsg_content() %></td>
					</tr>
					
					<tr>
						<td colspan="3"><input type="button" id="back" value="뒤로">
						<input id="delete" type ="button" value="삭제">
						<input id="response" type="button" value="답장"></td>
					</tr>
				</table>
            </div>
        </aside>
    </div>		
				
				
				
				
	
	<div id="msgModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
    
        <h3>쪽지보내기</h3>
        <form action="/ShareProject/MsgResponse.do" method="post">
        	
        	<input type="hidden" class="msg_from" name="msg_from" value="<%=mv.getMsg_to()%>">
        	<input type="submit" class="msend" value="보내기">
        	<br>
        	<textarea name="msg_content" rows="5" cols="50"></textarea>
        	
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
