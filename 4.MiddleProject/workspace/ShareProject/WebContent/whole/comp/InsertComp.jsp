<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    
	<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	<script src="/ShareProject/js/jquery.serializejson.min.js"></script>
    	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	
    <title>Share Project</title>
    <style type="text/css">
    #boardBox{
    	display: flex;
    	justify-content:center;
    	flex-direction: column;
    }
    #txt{
    	display: flex;
    	justify-content:center;
    }
    #btnbox{
    	display: flex;
    	justify-content:center;
    }
    #name{
    	width: 500px;
    }
    #info{
    	width: 500px;
    }
    #req{
    	width: 500px;
    }
    .topHr {
		width : 100%;
		border : 1px solid orange;
		margin-bottom : 7%;
	}
	.bottomHr {
		width : 100%;
		border : 1px solid orange;
		margin-top : 7%;
	}
    </style>
    <script type="text/javascript">
	$(function() {
		
		$('#submit').on('click', function(e) {
			e.preventDefault();
			
			var form = $('#compForm')[0];
			
			var data = new FormData(form);
			
				
			$.ajax ({
				url:'/ShareProject/InsertComp.do',
				type:'post',
				data: data,
	            processData: false, //필수
	            contentType: false, // 필수
	            cache: false,
				success:function(result){
					if(result.flag == "성공")
						location.href="./AtSelectComp.jsp?board_id=" + result.adminboard_id;
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				},
				dataType:'json'
			})
		})
			// 어드민 마이페이지 => 관리자페이지
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
			
		
		
		$(document).on('click', '#cancel', function() {
			history.back();
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
			<hr class="topHr">
			<div id="txt">
			
				<form id="compForm" enctype="multipart/form-data" method="post">
					<h2>회사 등록</h2><br>
					<input id="name" type="text" name="comp_name" placeholder="등록할 회사의 이름을 입력해주세요" />
					<br><br>
					<textarea id="info" cols="70" rows="10" style="resize: none;"	name="comp_info" placeholder="등록할 회사의 정보를 입력해주세요"></textarea>
					<br><br>
					<textarea id="req" cols="70" rows="10" style="resize: none;"	name="comp_req" placeholder="등록할 회사의 자격조건을 입력해주세요"></textarea>
					<br><br>
					<input type="file" name="file">
					<br><br>
				</form>
			</div>
			<div id="btnbox">
				<input type="button" id="submit" value="등록">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="cancel" value="취소">
			</div>
			<hr class="bottomHr">		
		</div>
		
		</aside>
	</div>
</body>
</html>