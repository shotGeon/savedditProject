<%@page import="kr.or.ddit.cal.vo.TtVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TtVO> list = (List<TtVO>) request.getAttribute("list");

	HttpSession ss = request.getSession();

	String admin = (String)ss.getAttribute("mem_id");
	
	String mem_group = (String)request.getAttribute("mem_goup");
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
	
    <title>Share Project Class</title>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/ShareProject/js/jquery-3.6.0.min.js"></script>
 <script src="/ShareProject/js/jquery.serializejson.min.js"></script>
<link href='/ShareProject/js/main.min.css' rel='stylesheet'/>
<script src='/ShareProject/js/main.min.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

  body {
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }
  
  #box{
  	height: 800px; 
  	display : flex;
  	justify-content : center;
  }
  
  #calendar {
    width: 80%;
    margin: 15px;
    margin-left: 70px;
  }
  .fc .fc-timegrid-slot {
  	height: 20px;
  	border-bottom: 0;
  }
  
  #writeModal label, #updateModal label{
	width: 100px;
  }

  #calInsert{
  	position: relative;
  	top: 16px;
  	background: RGB(118,130,142);
  	color: white;
  	padding: 3px;
  	height: 32px;
  	border-radius: 5px;
  }
.clButton {
	color : black;
}
#stuInfoBox h2 {
	margin-top : 0px;
    margin-bottom : 15px;
    color : white;
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
	margin-top: 20px;
}
</style>
<script  src="/ShareProject/js/cal.js"></script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev',
        center: 'title',
        right : 'next today'
      },
      contentHeight: 650,
      initialDate: new Date(), // 처음 보여지는 달력 날짜
      navLinks: false, // 날짜 누르면 day로 이동하는 옵션
      nowIndicator: true,
      weekNumbers: true,
      weekNumberCalculation: 'ISO',
      initialView: 'timeGridWeek', 
      editable: false, // 움직이는거 가능
      selectable: true,
      dayMaxEvents: true, // 
      slotMinTime : '09:00:00', // 처음 표시 시간
      slotMaxTime : '21:00:00', // 마지막 표시 시간
      expandRows : true, // 캘린더 크기에 맞출지 안맞출지

	 eventClick: function(info) {
		 <% 
		 if(!mem_group.equals("stu")){
		 %> 
	  // 관리자일 경우에만 모달창 띄우기
	  $('#updateModal').modal();
	  eventData = info.event;
	  
	  startvalue = new Date(eventData.start);
	  startvalue.setHours(startvalue.getHours()+9);
	  startvalue = startvalue.toISOString().slice(0, 16);
	  endvalue = new Date(eventData.end);
	  endvalue.setHours(endvalue.getHours()+9);
	  endvalue = endvalue.toISOString().slice(0, 16);
	  
	  $('#updateModal .tt_id').val(eventData.groupId);
	  $('#updateModal .ttname').val(eventData.title);  
	  $('#updateModal .ttcolor').val(eventData.borderColor);  
	  $('#updateModal .ttstart').val(startvalue);
	  $('#updateModal .ttend').val(endvalue);  
	  <%	 
		 }
		 %>
  },


      events: [
    	  <%
    		for(int i = 0; i < list.size(); i++){
    			TtVO vo = list.get(i);
    			if(i > 0) out.write(",");
    	%>	
    			{	
    				groupId : '<%= vo.getTt_id()%>',
    				title : '<%= vo.getTt_title()%>',
    				start : '<%= vo.getTt_start() %>',
    				end : '<%= vo.getTt_end()%>',
    				color : '<%= vo.getTt_color() %>',
  					display : 'border'// 여기는 BORDER로 하드코딩하기 
					<%
  					if(vo.getTt_overlap().equals("Y")){
					%>
  						 ,overlap : true
					<%
					}
					if(vo.getTt_allday().equals("Y")){
					%>
  						 ,allday : true
					<%
					}
					%> 
    			}
    	<%
    		}
    	%>
    	]
    });
    
    calendar.render();
  });
  
  id = "<%=mem_group%>";
  $(function() {

	  if(id != "stu"){
		 
		  $('#calInsert').show();
	  }
	
	$('#calInsert').on('click', function() {
		
		sval = new Date();
		
		sval = sval.toISOString().substring(0, 16);
			
		$('#writeModal .start').val(sval); 
		
		$('#send').on('click', function() {
			ttdata = $('#ttForm').serialize();
			console.log(ttdata)
			
			ttInsert(ttdata);
		})
	})
	 
	$('#modi').on('click', function() {
		$('.tt').removeAttr('disabled');
		
		$('#updatett').on('click', function() {
			updateData = $('#ttUpForm').serializeJSON();
			console.log(updateData);
			updateTt(updateData);
		})
	})
	
	$('#del').on('click', function() {
		ttId = $('.tt_id').val();
		
		deleteTt(ttId);
	})
	
	//관리자 마이페이지 => 어드민페이지
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
           		<a href="/ShareProject/ClassMainPage.do">
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
            	<div id="box">
					<div id='calendar'></div>
					<div><button type="button" id="calInsert" data-toggle="modal" data-target="#writeModal" style="display : none;">시간표 등록</button></div>
					<!-- style="display : none;" -->
				</div>	
            </div>
        </aside>
    </div>
	
	
	<!-- Modal -->
	<div id="writeModal" class="modal fade" role="dialog">
  		<div class="modal-dialog">
  		

   		 <!-- Modal content-->
    		<div class="modal-content">
     			 <div class="modal-header">
       				 <button type="button" class="close" data-dismiss="modal">&times;</button>
       				 <h4 class="modal-title">시간표 등록</h4>
     			 </div>
     			 <div class="modal-body">
        			<h3></h3>
        			<form id="ttForm">
        				<label>과목이름</label><input type="text" name="tt_title" class="fin"><br>
        				<label>시작날짜</label><input type="datetime-local" name="tt_start" class="fin start"><br>
        				                   <!--   <input type="time" name="itt_start" class="fin"><br> -->
        				<label>종료날짜</label><input type="datetime-local" name="tt_end" class="fin"><br>
        				                    <!--  <input type="time" name="itt_end" class="fin"><br> -->
        				<label>색상</label><input type="color" name="tt_color" class="fin"><br>
        				<label>종일</label><input type="radio" name="tt_allday" value="Y"> Y&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				                  <input type="radio" name="tt_allday" value="N" checked="checked"> N<br>
        				<label>휴일여부</label><input type="radio" name="tt_overlap" value="Y"> Y&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				                     <input type="radio" name="tt_overlap" value="N" checked="checked"> N<br>
        				<button type="button" id="send">전송</button>
        			</form>
      			</div>
     			<div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      			</div>
   			</div>
  		</div>
	</div>
	
	<!-- Modal -->
	<div id="updateModal" class="modal fade" role="dialog">
  		<div class="modal-dialog">
  		

   		 <!-- Modal content-->
    		<div class="modal-content">
     			 <div class="modal-header">
       				 <button type="button" class="close" data-dismiss="modal">&times;</button>
       				 <h4 class="modal-title">시간표</h4>
     			 </div>
     			 <div class="modal-body">
        			<h3></h3>
        			<form id="ttUpForm">
        				<input type="hidden" name="tt_id" class="tt_id tt" disabled><br>
        				<label>과목이름</label><input type="text" name="tt_title" class="ttname tt" disabled><br>
        				<label>시작날짜</label><input type="datetime-local" name="tt_start" class="ttstart tt" disabled><br>
        				                   <!--   <input type="time" name="itt_start" class="fin"><br> -->
        				<label>종료날짜</label><input type="datetime-local" name="tt_end" class="ttend tt" disabled><br>
        				                    <!--  <input type="time" name="itt_end" class="fin"><br> -->
        				<label>색상</label><input type="color" name="tt_color" class="ttcolor tt" disabled><br>
        				<label>종일</label><input type="radio" name="tt_allday" value="Y" class="tt" disabled> Y&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				                  <input type="radio" name="tt_allday" value="N" class="tt" checked="checked" disabled> N<br>
        				<label>휴일여부</label><input type="radio" name="tt_overlap" value="Y" class="tt" disabled> Y&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				                     <input type="radio" name="tt_overlap" value="N" class="tt" checked="checked" disabled> N<br>
        				<button type="submit" id="updatett" class="tt" disabled>전송</button>
        			</form>
        			<br><br>
        			<input type="button" id="modi" value="수정">
        			<input type="button" id="del" value="삭제">
      			</div>
     			<div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      			</div>
   			</div>
  		</div>
	</div>
</body>
</html>