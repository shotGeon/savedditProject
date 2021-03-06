<%@page import="kr.or.ddit.board.vo.NoticeVO"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> freeList = (List<BoardVO>)request.getAttribute("freeList");
	List<NoticeVO> notiList = (List<NoticeVO>)request.getAttribute("notiList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--※필수※ 아이콘, 스타일-->
    <script src="https://kit.fontawesome.com/b69eadd32e.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalStyle.css">
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalMainStyle.css">
    <!--↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑-->
	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	<script src="/ShareProject/js/jquery-3.6.0.min.js"></script>

<style type="text/css">
.target { 
	width: 250px; 
	white-space: nowrap; 
	overflow: hidden; 
	text-overflow: ellipsis; 
}
label{
	display: inline-block; 
	margin-left: 5px;
}
.mini{
	text-decoration: none;
	color: orange;
	margin: 5px;
}
.date{
	margin-left: 20px;
}
.miniBox{
	display: flex;
	justify-content: center;
}
label a{
	text-decoration: none;
	color: black;
}
.linkTitle{
	display: flex;
	justify-content: center;
	font-size: 1.2em;
	margin: 5px;
}
</style>


<script>
$(function(){
	
	
	$('#mypage').on('click', function(){
		$.ajax({
			url: '/ShareProject/Admin.do',
			type: 'get',
			dataType: 'json',
			success: function(res){
				console.log(res.flag);
				if(res.flag=="admin"){
					location.href="/ShareProject/whole/admin/admin_html/AdminPage.html";
				} else {
					location.href="/ShareProject/whole/member/myPage.html";
				}
			},
			error: function(xhr){
			}
		})
	})
	
	
})
	</script>

    <title>Share Project</title>
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
                <img class="centerImg" src="/ShareProject/Real_Final_Pages/images/computer.jpg">
                <div class="quickbox">
                <div class="linkTitle">
                <h3>공지사항 게시판&nbsp;&nbsp;<a class="mini" href="/ShareProject/whole/board/NoticBoard.html">✚</a></h3>
                </div>
                <div class="miniBox">
                <ul>							
                <%
                if(notiList.size() > 0){
                	for(NoticeVO vo : notiList){
                %>
                	<li><label class="target"><a href="/ShareProject/whole/board/NoticeBoardSelect.jsp?board_id=<%=vo.getAdminboard_id() %>&boardtitle_id=BR01"><%=vo.getNotice_title() %></a>&nbsp;&nbsp;&nbsp;&nbsp;</label>
                	    <label class="date"><%=vo.getNotice_date() %>&nbsp;&nbsp;</label></li>
                <%		
                	}
                }
                %>
                </ul>
                </div>
				</div>
                <div class="quickbox">
                <div class="linkTitle">
                <h3>자유 게시판 &nbsp;&nbsp;<a class="mini" href="/ShareProject/whole/board/FreeBoard.html">✚</a></h3>
                </div>
                <div class="miniBox">
                <ul>
                <%
                if(freeList.size() > 0){
                	for(BoardVO vo : freeList){
                %>
                	<li>
                		<label class="target"><a href="/ShareProject/whole/board/AtSelectBoard.jsp?board_id=<%=vo.getAdminboard_id() %>&boardtitle_id=<%=vo.getBoard_title_id()%>"><%=vo.getBoard_title() %></a>&nbsp;&nbsp;&nbsp;&nbsp;</label>
                	    <label class="date"><%=vo.getBoard_date() %>&nbsp;&nbsp;</label>
                    </li>
                <%		
                	}
                }
                %>
                </ul>
                </div>
                </div>
            </div>
        </aside>
    </div>
</body>
</html>