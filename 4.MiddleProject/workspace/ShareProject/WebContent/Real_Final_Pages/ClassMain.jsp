<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.or.ddit.clboard.vo.ClBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ClBoardVO> clFreeList = (List<ClBoardVO>)request.getAttribute("clFreeList");
    List<ClBoardVO> clQnaList = (List<ClBoardVO>)request.getAttribute("clQnaList");
 	List<ClBoardVO> clNotiList = (List<ClBoardVO>)request.getAttribute("clNotiList");
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
    <link rel="stylesheet" href="/ShareProject/Real_Final_Pages/css/FinalClassStyle.css">
    <!--↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑ ↑-->
	
	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
		<script src="ShareProject/js/jquery-3.6.0.min.js"></script>
<style>
.target { width: 150px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; }
label{
	display: inline-block; 
}
.mini{
	text-decoration: none;
	color: black;
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
    <title>Share Project Class</title>
</head>

<body>
    <div id="page-wrap">
        <aside id="leftMenu">
            <div id="logoImg">
                <a href="/ShareProject/ClassMainPage">
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
                        <a class="infOption" href="#"><i class="far fa-comments"></i>&nbsp;채팅</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="infOption" href="/ShareProject/Real_Final_Pages/Final_LoginPage.html"><i class="fas fa-sign-out-alt"></i>&nbsp;로그아웃</a>
                    </div>
                </div>
            </div>

            <div id="classBtn">
                <a href="/ShareProject/MainPage.do"><input type="button" class="clButton" value="클래스 나가기"></a>
            </div>
            <ul id="ulBox">
                <li class="menuList"><a class="aMenuList" href="/ShareProject/TtList.do"><i class="far fa-calendar-alt"></i>&nbsp;&nbsp;시간표</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/clBoard/ClNoticeBoard.html"><i class="mIcons fas fa-exclamation-circle"></i>&nbsp;&nbsp;공지사항</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/ClTreeView.do"><i class="mIcons fas fa-paperclip"></i>&nbsp;&nbsp;자료공유</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/clBoard/HomeworkBoard.html"><i class="mIcons far fa-file-alt"></i>&nbsp;&nbsp;과제게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/clBoard/ClQnABoard.html"><i class="mIcons fas fa-question-circle"></i>&nbsp;&nbsp;질문게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/clBoard/ClFreeBoard.html"><i class="mIcons fas fa-users"></i>&nbsp;&nbsp;자유게시판</a></li>
                <li class="menuList"><a class="aMenuList" href="/ShareProject/whole/clBoard/ClLunchBoard.html"><i class="mIcons fas fa-utensils"></i>&nbsp;&nbsp;점심게시판</a></li>
            </ul>
            <div id="copyBox">
                <p id="copyright">Copyright 2021 Share Project<br>
                Design: 공밀레</p>
            </div>
        </aside>

        <aside id="rightMain">
            <div id="boardBox">
                <div id="clCenterBox">
                    <div id="topLine">
                      <div class="topbox tbx1">
                        <div class="quickTitle">
                          <h3>공지사항&nbsp;&nbsp;<a class="mini" href="/ShareProject/whole/clBoard/ClNoticeBoard.html">✚</a></h3> 
                        </div>
                       
                        <ul id="quickCont1">
                          <%
                          	if(clNotiList.size() > 0){
                          		for(ClBoardVO vo : clNotiList){
                          			%>
                          			<li>
                          			<label class="target"><%=vo.getclBoard_title() %></label>
                          			<label class="date"><%=vo.getclBoard_date() %></label>
                          			</li>
                          			<%
                          		}
                          	}
                          %>
                        </ul>
                      </div>
            
                      <div class="topbox tbx2">
                        <img class="tbx2_img cssImg" src="/ShareProject/Real_Final_Pages/images/cat.jpg" alt="cat">
                      </div>
            
                      <div class="topbox tbx3">
                        <div class="quickTitle">
                          <h3>질문게시판&nbsp;&nbsp;<a class="mini" href="/ShareProject/whole/clBoard/ClQnABoard.html">✚</a></h3>
                        </div>
                        
                        <ul id="quickCont1">
                         <%
                          	if(clQnaList.size() > 0){
                          		for(ClBoardVO vo : clQnaList){
                          			%>
                          			<li>
                          			<label class="target"><%=vo.getclBoard_title() %></label>
                          			<label class="date"><%=vo.getclBoard_date() %></label>
                          			</li>
                          			<%
                          		}
                          	}
                          %>
                        </ul>
                      </div>
                    </div>
            
                    <div id="bottomLine">
                      <div class="bottomBox bbx1">
                        <img class="bbx1_img cssImg" src="/ShareProject/Real_Final_Pages/images/computer2.jpg" alt="study">
                      </div>
            
                      <div class="bottomBox bbx2">
                        <div class="quickTitle">
                          <h3>자유게시판&nbsp;&nbsp;<a class="mini" href="/ShareProject/whole/clBoard/ClFreeBoard.html">✚</a></h3>
                        </div>

                        <ul id="quickCont1">
                          <%
                          	if(clFreeList.size() > 0){
                          		for(ClBoardVO vo : clFreeList){
                          			%>
                          			<li>
                          			<label class="target"><%=vo.getclBoard_title() %></label>
                          			<label class="date"><%=vo.getclBoard_date() %></label>
                          			</li>
                          			<%
                          		}
                          	}
                          %>
                        </ul>
                      </div>
            
                      <div class="bottomBox bbx3">
                        <img class="bbx3_img cssImg" src="/ShareProject/Real_Final_Pages/images/postit.jpg" alt="postit">
                      </div>
                    </div>
                  </div>
            </div>
        </aside>
    </div>
</body>
</html>