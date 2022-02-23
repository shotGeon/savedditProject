<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String group = request.getParameter("group");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--※필수※ 아이콘, 스타일-->
    <script src="https://kit.fontawesome.com/b69eadd32e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalStyle.css">
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalMainStyle.css">
    <!--↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑-->
	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	
<title>Insert title here</title>

<style>
* {
	margin: 0px;
	padding: 0px;
}
.insertH2 {
	text-align: center;
	margin: 10px;
}

#Writing {
	width: 650px;
	height: 620px;
	border: 1px solid darkgray;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin : 75px 230px;
}
textarea {
	padding: 10px;
	margin-bottom: 5px;
}
.topHr {
	border : 1px solid orange;
	margin-top : 2%;
}
.bottomHr {
	border : 1px solid orange;
	margin-bottom : 2%;
}
#newPostBox {
	width : 90%;
}
.newInputBox {
	width : 100%;
}
</style>

<script type="text/javascript">
	$(function() {
		group = "<%=group%>"
		$('#submit').on('click', function(e) {
			e.preventDefault();
		    
			var form = $('#fileForm')[0];
			
			var data = new FormData(form);
			
			$.ajax ({
				url:'/ShareProject/InsertAtBoard.do',
				type: "post",
	            data: data,
	            processData: false, //필수
	            contentType: false, // 필수
	            cache: false,
				success : function(result){
					console.log("SUCCESS : ", data);
					location.href="./AtSelectBoard.jsp?board_id=" + result.adminboard_id + "&boardtitle_id=" + group;
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				}, 
				dataType:'json'
			})	
		
		})
		
		$(document).on('click', '#cancel', function() {
			history.back();
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
			<div id="Writing">
				<h2 class="insertH2">글쓰기</h2>
				<form id="fileForm" accept-charset="UTF-8" enctype="multipart/form-data" method="post">
					<div id="newPostBox">
						<input class="newInputBox" type="hidden" name="board_title_id" value="<%=group%>">
						<input class="newInputBox" type="text" name="board_title" placeholder="제목을 입력해 주세요" /><br>
						<textarea class="newInputBox" cols="54" rows="18" style="resize: none;"	name="board_content" placeholder="내용을 입력해주세요"></textarea>
						<br> 
					</div>
						<input id="bfile" type="file" name="atchFile" multiple>
				</form>
				<br>
				<div>
					<input type="button" id="submit" value="등록"> 
					<input type="button" id="cancel" value="취소">
				</div>
			</div>
			<hr class="bottomHr">
		</div>
		</aside>
	</div>
</body>
</html>