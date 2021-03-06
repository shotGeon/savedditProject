<%@page import="kr.or.ddit.at.vo.AtVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.comp.vo.CompVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	CompVO vo = (CompVO)request.getAttribute("cv");

	List<AtVO> list = (List<AtVO>)request.getAttribute("fileList");
	
	String mem_id = (String) request.getAttribute("mem_id");

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
	<script type="text/javascript">
	$(function(){
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

#atchTable {
	width : 700px;
	height: 500px;
	text-align: center;
	border: 2px solid gray;
}
#boardBox {
	display : flex;
	justify-content: center;
	align-items: center;
}

.col{
	width: 150px;
}

#cname{
	font-size: 1.5em;
	font-weight: bold;
}

#img{
	height: 300px;
}

.modalTxt{
	height: auto;
}
</style>
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
				<table id="atchTable" border="1">
								
					<tr>
						<td colspan="2" id="cname"><%=vo.getComp_name()%></td>
						
					</tr>
					
					<%
						if (list.size() > 0) {
					%>
					<tr>
						<%
							for (AtVO fileVO : list) {
								System.out.println(fileVO.getFile_extsn());
								if (fileVO.getFile_extsn().equals("png") || fileVO.getFile_extsn().equals("jpg")) {
						%>
						<td colspan="2" id="img">
							<img src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=fileVO.getAtch_file_id()%>&fileSn=<%=fileVO.getFile_sn()%>">
						</td>
						<%
							} else {
						%>
						<td >
							<a href="<%=request.getContextPath()%>/filedownload.do?fileId=<%=fileVO.getAtch_file_id()%>&fileSn=<%=fileVO.getFile_sn()%>"><%=fileVO.getOrignl_file_nm()%></a>
						</td>
						</tr>
						<%
							}
						%>
						
						<%
							}
						}else{
						%>
							<td colspan="2">첨부파일이 없습니다.</td></tr>
						<%
						}
						%>
					
					
					<tr>
						<td class="col">정보</td>
						<td><%=vo.getComp_info()%></td>
					</tr>
					
					<tr>
						<td class="col">자격요건</td>
						<td><%=vo.getComp_req()%></td>
					</tr>

					
					

					<tr>
						<td colspan="2">
							<input type="button" id="back" value="뒤로">
							<%
								if (mem_id.equals("admin")) {
							%> 
							<input type="button" data-toggle="modal" data-target="#UpdateModal" value="수정"> 
							<input type="button" id="delete" value="삭제">
							<%
								}
							%>	
						</td>
					</tr>
					
				</table>

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
								<form id="updateFile" action="insert.do" method="post"
									enctype="multipart/form-data">
									<label class="modalIn"><input type="text" name="comp_name" value="<%=vo.getComp_name()%>"> </label>
									<input type="hidden" name="adminboard_id" value="<%=vo.getAdminboard_id()%>"> 
									<div class="modalTxt">
										<textarea cols="70" rows="10" style="resize: none;" name="comp_info"><%=vo.getComp_info()%></textarea>
									</div>
									<div class="modalTxt">
										<textarea cols="70" rows="10" style="resize: none;" name="comp_req"><%=vo.getComp_req()%></textarea>
									</div>
									<label class="modalIn"><input type="file" name="atchFile"> </label>
									<input type="submit" id="update" class="btn btn-default" data-dismiss="modal" value="수정" />
								</form>
							</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-default"
									data-dismiss="modal" id="cancel">취소</button>
							</div>
						</div>
					</div>
				</div>

				
		</aside>
	</div>
</body>
</html>