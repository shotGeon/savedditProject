<%@page import="org.w3c.dom.NodeList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> nodeList = (List<String>) request.getAttribute("nodeList");
	String folderName = (String) request.getAttribute("folderName");
	
%>    

<!DOCTYPE html>

<html>
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
		
	    <title>Share Project</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="/ShareProject/js/jquery-3.6.0.min.js" type="text/javascript"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="/ShareProject/css/Aimara.css">
		<script src="/ShareProject/js/Aimara.js" type="text/javascript"></script>

<style type="text/css">
#boardBox {
	overflow: scroll;
}

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
	window.onload = function() {

		//Initializing Tree

		//우클릭 동작
		//Tree Context Menu Structure
		var contex_menu = {
			'context1' : {
				elements : [
						{
							text : '파일 컨트롤',
							icon : '/ShareProject/img/blue_key.png',
							action : function(node) {

							},
							submenu : {
								elements : [
										{
											text : '파일 만들기',
											icon : '/ShareProject/img/leaf.png',
											action : function(node) {
												if (node.returnType == 'file')
													return;
												copyNode = node;
												filePath = "";
												while (!(copyNode.getText() == 'tree')) {
													filePath = copyNode
															.getText()
															+ "/" + filePath;
													copyNode = parent(copyNode);
												}
												$
														.ajax({
															url : '/ShareProject/UploadFile.do',
															type : 'get',
															data : {
																"path" : filePath,
																"result" : "",
																"flag" : "create"
															},
															dataType : 'json',
															success : function(
																	result) {
																if (result.flag == "ok") {
																	node
																			.createChildNode(
																					result.fileName,
																					false,
																					'/ShareProject/img/folder.png',
																					null,
																					'context1');
																	tree
																			.expandNode(node);
																} else {
																	alert("파일 만들기에 실패 하셨습니다.");
																}

															},
															error : function(
																	xhr) {
																alert("에러코드 : "
																		+ xhr.status
																		+ "\n에러명 : "
																		+ xhr.statusText)
															}

														})
											}
										},
										{
											text : '이름 수정',
											icon : '/ShareProject/img/leaf.png',
											action : function(node) {
												if (node.getParent().getText() == 'tree')
													return;
												var input = prompt('이름 변경');
												if (input == null
														|| input == "")
													return;
												copyNode = node;
												filePath = "";
												while (!(copyNode.getText() == 'tree')) {
													filePath = copyNode
															.getText()
															+ "/" + filePath;
													copyNode = parent(copyNode);
												}
												$
														.ajax({
															url : '/ShareProject/UploadFile.do',
															type : 'get',
															data : {
																"path" : filePath,
																"result" : input,
																"flag" : "name"
															},
															dataType : 'json',
															success : function(
																	result) {
																if (result.flag == "ok") {
																	node
																			.setText(result.fileName);
																} else {
																	alert("이미 존재하는 이름입니다.");
																}

															},
															error : function(
																	xhr) {
																alert("에러코드 : "
																		+ xhr.status
																		+ "\n에러명 : "
																		+ xhr.statusText)
															}

														})
											}
										},
										{
											text : '파일 삭제',
											icon : '/ShareProject/img/delete.png',
											action : function(node) {
												if (node.getParent().getText() == 'tree')
													return;
												copyNode = node;
												filePath = "";
												while (!(copyNode.getText() == 'tree')) {
													filePath = copyNode
															.getText()
															+ "/" + filePath;
													copyNode = parent(copyNode);
												}
												$
														.ajax({
															url : '/ShareProject/UploadFile.do',
															type : 'get',
															data : {
																"path" : filePath,
																"result" : "",
																"flag" : "delete"
															},
															dataType : 'json',
															success : function(
																	result) {
																node
																		.removeNode();
															},
															error : function(
																	xhr) {
																alert("에러코드 : "
																		+ xhr.status
																		+ "\n에러명 : "
																		+ xhr.statusText)
															}

														})
											}
										},

								]
							}
						},
						{
							text : '다운로드 관리',
							icon : '/ShareProject/img/blue_key.png',
							action : function(node) {

							},
							submenu : {
								elements : [
										{
											text : '파일 다운로드',
											icon : '/ShareProject/img/add1.png',
											action : function(node) {
												if (node.returnType() != 'file')
													return;
												copyNode = node;
												filePath = "";
												while (!(copyNode.getText() == 'tree')) {
													filePath = copyNode
															.getText()
															+ "/" + filePath;
													copyNode = parent(copyNode);
												}
												filePath = filePath
														.slice(0, -1);
												location.href = "/ShareProject/DownloadFile.do?path="
														+ filePath;
											}
										},
										{
											text : '파일 업로드',
											icon : '/ShareProject/img/add1.png',
											action : function(node) {
												if (node.returnType() == 'file')
													return;
												copyNode = node;
												filePath = "";
												while (!(copyNode.getText() == 'tree')) {
													filePath = copyNode
															.getText()
															+ "/" + filePath;
													copyNode = parent(copyNode);
												}
												$('#filePath').val(filePath);
												$('#fileUploadModal').modal(
														'show');
											}
										}, ]
							}
						} ]
			}
		};

		//Creating the tree
		tree = createTree('div_tree', 'white', contex_menu);
<%
					for(int i = 0; i < nodeList.size(); i++){
						out.println(nodeList.get(i));
					}
				%>
				
				//Rendering the tree
				tree.drawTree();


			};
		parent = function(node) {
			return node.getParent();
		}
		$(function(){
			$('#submit').on('click', function(){
				var form = $('#fileForm')[0];

				var data = new FormData(form);
				
				$.ajax ({
					url:'/ShareProject/UploadFile.do',
					type: "post",
		            data: data,
		            processData: false, //필수
		            contentType: false, // 필수
		            cache: false,
					success : function(result){
						console.log("SUCCESS : ", data);
					},
					error:function(xhr){
						alert("에러코드 : " + xhr.status + "에러명 : " + xhr.statusText);
					}, 
					dataType:'json'
				})	
			})
				//관리자 마이페이지 => 관리자페이지
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
                <li class="menuList"><a class="aMenuList" href="#"><i class="mIcons fas fa-paperclip"></i>&nbsp;&nbsp;자료공유</a></li>
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
            <div id="div_tree"></div>
            
            
            </div>
        </aside>
    </div>
		<!-- Modal -->
		<div class="modal fade" id="fileUploadModal" role="dialog">
			<div class="modal-dialog">
			
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					
					<div class="modal-body">
						<form id='fileForm' enctype="multipart/form-data"><br>
							파일 업로드 위치 : <input type="text" id="filePath" name="filePath" readonly> <br>
							파일선택 : <input type="file" name="uploadFile"><br>
						</form>
					</div>
					
					<div class="modal-footer">
						<input type="button" id="submit" class="btn btn-default" data-dismiss="modal" value="전송" />
						<input type="button" class="btn btn-default" data-dismiss="modal" value="취소" />
					</div>
				</div>
			  
			</div>
		</div>
	</body>
</html>
