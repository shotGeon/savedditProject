<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int adminbaord_id = Integer.parseInt(request.getParameter("board_id"));
	String boardtitle_id = request.getParameter("boardtitle_id");
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
    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="/ShareProject/js/jquery-3.6.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="/ShareProject/js/jquery.serializejson.min.js"></script>

	<link rel="icon" type="image/png" href="/ShareProject/Real_Final_Pages/images/logoIcon.PNG" sizes="96x93">
	<script type="text/javascript">
		$(function() {
			$.ajax({
				url:'/ShareProject/SelectClAtHomeworkBoard.do',
				type:'get',
				data:{'board_id' : <%=adminbaord_id %>, "boardtitle_id" : "<%=boardtitle_id%>"},
				dataType: 'html',
				success:function(result) {
					$('#boardBox').html(result);
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText );
				}
			})
					
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
		
		$(document).on('click','#update', function(e) {
			e.preventDefault();

			var form = $('#updateFile')[0];
			
			var data = new FormData(form);
			
			$.ajax ({
				url:'/ShareProject/UpdateAt.do',
				type:'post',
				data: data,
		        processData: false, //필수
		        contentType: false, // 필수
		        cache: false,
				dataType:'json',
				success:function(result){
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
					if(result.flag == "성공"){
						location.href="/ShareProject/whole/clBoard/HomeworkBoard.html";
					}
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				}
			})	
		})
		
		$(document).on('click', '#end', function() {
			$('#m').remove();
		})
		
		$(document).on('click', '#back', function() {
			location.href="/ShareProject/whole/clBoard/HomeworkBoard.html";
		})
		
		$(document).on('click', '#reportBtn', function() {
			reportData = $('#reportForm').serializeJSON();
			console.log(reportData)
			$('#reportModal').modal('hide');
			$.ajax({
				url:'/ShareProject/Report.do',
				type:'post',
				data: reportData,
				dataType:'json',
				success:function(result){
					if(result.flag == "성공"){
						alert("신고가 완료되었습니다.")
					}		
				},
				error:function(xhr){
					alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
				}
			})
		})
		
		//답글 클릭한 사람 mem_id 가져오기
		$(document).on('click', '#response', function(){
			$('#ResponseModal').modal('show');
			$.ajax({
				url : '/ShareProject/ResponseMemId.do',
				type : 'get',
				dataType : 'json',
				success : function(res){
					//alert(res.mem_id);
					mem_id=res.mem_id;
					/* var form =$('form[name="resForm"]');
					
					var input = document.createElement('input');
					input.type='hidden';
					input.name='mem_id';
					input.value=mem_id;
					
					form.appendChild(input);  */
					
					html ="<input type='hidden' name='mem_id' value="+mem_id+">";
					
					$('#responseForm').append(html);
				},
				error : function(xhr){
					alert(xhr.status);
				}
			})
		})	
		//답글 등록
		$(document).on('click', '#reinsert', function(){
			responseData =$('#responseForm').serializeJSON();
			$.ajax({
				url :'/ShareProject/InsertAdminreBoard.do',
				type : 'get',
				data : responseData,
				dataType : 'json',
				success : function(res){
					alert(res.flag);
					if(res.flag=="답글등록완료"){
						$('#ResponseModal').modal('hide');
						location.reload();
					}
				},
				error : function(xhr){
					alert("전체질문게시판 답글등록오류:"+xhr.status);
				}
			})
		})
		
	 //답글수정버튼 눌렀을때 답글 본인계정확인
	 $(document).on('click', '.reUpdate', function(){
		 remem_id=$(this).attr('id');
		 rename = $(this).attr('name');
		 recont = $('#'+ rename).text();
		 
		 $('#rerecontent').val(recont);
		 //alert(recont);
		 $('#rerecontent').val(recont);
		 adminre_num=$(this).parents('#inputParent').find('.adminre_num').attr('id');
		 /* console.log(remem_id);
		 console.log(adminre_num);  */
		 $.ajax({
			url : '/ShareProject/UpdateAdminreBoard.do',
			data : {'remem_id' : remem_id},
			dataType : 'json',
			type : 'get',
			success : function(res){
				if(res.flag=="일치"){
					$('#reUpdateModal').modal('show');
				}else{
					alert("본인계정 답글이 아닙니다.");
					location.reload();
				}
			},
			error : function(xhr){
				alert("recontent"+xhr.status)
			}
		 }) 
	 })
	 
	 //답글삭제버튼 눌렸을때 답글 본인계정확인
	 $(document).on('click', '.reDelete', function(){
		 remem_id=$(this).attr('id');
		 adminre_num=$(this).parents('#inputParent').find('.adminre_num').attr('id');
		 /* console.log(remem_id);
		 console.log(adminre_num);  */
		 $.ajax({
			url : '/ShareProject/UpdateAdminreBoard.do',
			data : {'remem_id' : remem_id},
			dataType : 'json',
			type : 'get',
			success : function(res){
				if(res.flag=="일치"){
					$.ajax({
						url : '/ShareProject/DeleteAdminreBoard.do',
						data : {'adminre_num' : adminre_num},
						dataType : 'json',
						type : 'get',
						success : function(res){
							alert(res.flag);
							location.reload();
						},
						error : function(xhr){
							alert("답글삭제:"+xhr.status);
						}
					})
					
				}else{
					alert("본인계정 답글이 아닙니다.");
					location.reload();
				}
			},
			error : function(xhr){
				alert("recontent"+xhr.status)
			}
		 }) 
	 })
	 
	 
	  //답글 수정
	 $(document).on('click', '#remupdate', function(){
		  recontent=$('#rerecontent').val();
		  /* console.log(recontent);
		  console.log(adminre_num); */
		  $.ajax({
			  url : '/ShareProject/UpdateAdminreContent.do',
			  data : {'recontent' : recontent,
				      'adminre_num' : adminre_num},
			  dataType : 'json',
			  type : 'get',
			  success : function(res){
				  alert(res.flag);
				  if(res.flag="수정완료"){
				   $('#reUpdateModal').modal("hide");
				   //location.reload();
				   location.reload();
				  } 
			  },
			  error : function(xhr){
				  alert("reupdate:"+xhr.status);
			  }
		  })
	 })

	$(document).on("click", ".title", function() {
			$(this).next(".content").stop().slideToggle(300);
			$(this).toggleClass('on').siblings().removeClass('on');
		})
			$(document).on('click','#atHWFile', function(e) {
				e.preventDefault();

				var form = $('#uploadHWFile')[0];
				
				var data = new FormData(form);
				
				$.ajax ({
					url:'/ShareProject/UpdateHWFile.do',
					type:'post',
					data: data,
			        processData: false, //필수
			        contentType: false, // 필수
			        cache: false,
					dataType:'json',
					success:function(result){
						location.reload();
					},
					error:function(xhr){
						alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
					}
				})
			})
		
	})
	</script>
    <title>Share Project Class</title>
	<style>
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

#atchTable {
	width : 700px;
	height: 500px;
	text-align: center;
}
#boardBox {
	display : flex;
	justify-content: center;
	align-items: center;
}
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

#atchTable {
	width : 70%;
	height : 70%;
	text-align: center;
}
#boardBox {
	display : flex;
	justify-content: center;
	flex-direction : column;
	align-items: center;
	overflow-x : hidden;
}
.replyBox {
	width : 90%;
	margin-left : 5%;
	margin-bottom : 1%;
	padding : 2%;
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
.replyContainer {
	width : 70%;
	height: 30%;
	overflow : scroll;
	overflow-x : hidden;
	border-bottom : 1px solid darkgray;
	border-right : 1px solid darkgray;
	border-left : 1px solid darkgray;
	margin-top : 1px;
}
.replyTable {
	width : 100%;
	text-align: center;
}
.replyTable td {
	height: 30px;
}
.replyTable .td1 {
	height: 30px;
	width : 15%;
}
.replyTable .td2 {
	height: 30px;
	width : 40%;
}
.replyTable .td3 {
	height: 30px;
	width : 12%;
}
.reportInputBox {
	width : 90%;
	margin-left : 5%;
	padding : 2%;
}
#inputTitle {
	width : 90%;
	padding : 2%;
}
.tdColor {
	background-color: lightgray;
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

#atchTable {
	width : 70%;
	height : 70%;
	text-align: center;
}
#boardBox {
	display : flex;
	justify-content: center;
	flex-direction : column;
	align-items: center;
	overflow-x : hidden;
}
.replyBox {
	width : 90%;
	margin-left : 5%;
	margin-bottom : 1%;
	padding : 2%;
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
.replyContainer {
	width : 70%;
	height: 30%;
	overflow : scroll;
	overflow-x : hidden;
	border-bottom : 1px solid darkgray;
	border-right : 1px solid darkgray;
	border-left : 1px solid darkgray;
	margin-top : 1px;
}
.replyTable {
	width : 100%;
	text-align: center;
}
.replyTable td {
	height: 30px;
}
.replyTable .td1 {
	height: 30px;
	width : 15%;
}
.replyTable .td2 {
	height: 30px;
	width : 40%;
}
.replyTable .td3 {
	height: 30px;
	width : 12%;
}
.tdColor {
	background-color: lightgray;
}
#rercontent {
	width : 90%;
}
</style>
</head>

<body>
    <div id="page-wrap">
        <aside id="leftMenu">
            <div id="logoImg">
                <img id="mainlogo" src="/ShareProject/Real_Final_Pages/images/menulogo.PNG" alt="mainlogo">
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
			</div>
        </aside>
    </div>
</body>
</html>