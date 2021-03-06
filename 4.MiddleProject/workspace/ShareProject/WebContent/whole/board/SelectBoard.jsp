<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int adminbaord_id = Integer.parseInt(request.getParameter("board_id"));
	String boardtitle_id = request.getParameter("boardtitle_id");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!--※필수※ 아이콘, 스타일-->
    <script src="https://kit.fontawesome.com/b69eadd32e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalStyle.css">
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalMainStyle.css">
    <!--↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑-->
	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="/ShareProject/js/jquery.serializejson.min.js"></script>
	
    <title>Share Project</title>
    
<style>
.clButton {
	color: black;
}

#stuInfoBox h2 {
	margin-top: 0px;
	margin-bottom: 15px;
	color: black;
	font-weight: bold;
}

#subjectBox {
	display: flex;
	align-items: center;
	width: 230px;
	height: 60px;
	background-color: rgba(255, 255, 255, 0.6);
	font-size: 13px;
	padding: 5px;
	margin-bottom: 10px;
}

p#subject {
	font-size: 13px;
	width: 100%;
	height: 100%;
}
</style>

<script type="text/javascript">
	
	$(function(){
		$.ajax({
			url : '/ShareProject/SelectBoard.do',
			type : 'get',
			data : {'adminboard_id' : <%=adminbaord_id %>, "boardtitle_id" : "<%=boardtitle_id%>"},
			dataType: 'html',
			success:function(result) {
				$('#boardBox').html(result);
			},
			error:function(xhr){
				alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText );
			}
		})
				
		
		$(document).on('click','#update', function(){
			fdata = $('form').serializeJSON();
			console.log(fdata);
			$.ajax ({
				url:'/ShareProject/UpdateBoard.do',
				type:'post',
				data:fdata,
				dataType:'json',
				success:function(result){
					if(result.flag == "성공")
						$('#UpdateModal').modal("hide");
						location.reload();
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				}
			})
		})
		
		
		$(document).on('click','#delete', function() {
			$.ajax ({
				url:'/ShareProject/DeleteBoard.do',
				type:'post',
				data:{'adminboard_id' : <%=adminbaord_id %>},
				dataType:'json',
				success:function(result){
					if("<%=boardtitle_id%>" =="BR04"){
						//수료후기
						 location.href="/ShareProject/whole/board/ReviewBoard.html";
					}else if("<%=boardtitle_id%>" == "BR01"){
						// 공지사항
						location.href="/ShareProject/whole/board/NoticBoard.html";
					}else if("<%=boardtitle_id%>" == "BR05"){
						// 회사정보
						location.href="/ShareProject/whole/board/ComBoard.html";
					}else if("<%=boardtitle_id%>" == "BR09"){
						// 건의사항
						location.href="/ShareProject/whole/board/SuggestBoard.html";
					}
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				}
			})
		})
		
		$(document).on('click', '#back', function() {
			if("<%=boardtitle_id%>" =="BR04"){
				//수료후기
				 location.href="/ShareProject/whole/board/ReviewBoard.html";
			}else if("<%=boardtitle_id%>" == "BR01"){
				// 공지사항
				location.href="/ShareProject/whole/board/NoticBoard.html";
			}else if("<%=boardtitle_id%>" == "BR05"){
				// 회사정보
				location.href="/ShareProject/whole/board/ComBoard.html";
			}else if("<%=boardtitle_id%>" == "BR09"){
				// 건의사항
				location.href="/ShareProject/whole/board/SuggestBoard.html";
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
            <div id="boardBox"></div>
        </aside>
    </div>
</body>
</html>