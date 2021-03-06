 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int adminbaord_id = Integer.parseInt(request.getParameter("board_id"));
	String boardtitle_id = request.getParameter("boardtitle_id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="/ShareProject/js/jquery-3.6.0.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/ShareProject/js/jquery.serializejson.min.js"></script>

<style>
img{
 	width : 200px;
 	height: 200px;
}
</style>
<title>Insert title here</title>

<script type="text/javascript">
	$(function() {
		$.ajax({
			url:'/ShareProject/SelectAtBoard.do',
			type:'get',
			data:{'board_id' : <%=adminbaord_id %>, "boardtitle_id" : "<%=boardtitle_id%>"},
			dataType: 'html',
			success:function(result) {
				
				$('#view').html(result);
			},
			error:function(xhr){
			}
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
						if("<%=boardtitle_id%>" =="BR11"){
							 location.href="/ShareProject/whole/board/MarketBoard.html";
						}else if("<%=boardtitle_id%>" == "BR02"){
							location.href="/ShareProject/whole/board/FreeBoard.html";
						}else if("<%=boardtitle_id%>" == "BR10"){
							// 질문
							location.href="/ShareProject/whole/board/WHQnABoard.html";
						}else if("<%=boardtitle_id%>" == "BR12"){
							// 보강
							location.href="/ShareProject/whole/board/MakeUPBoard.html";
						}// 삭제 후 돌릴 게시판 아이디랑 경로 html로 넣으시면 됩니당
						
					}
						
				},
				error:function(xhr){
				}
			})	
		})
		
		$(document).on('click', '#end', function() {
			$('#m').remove();
		})
		
		$(document).on('click', '#back', function() {
			if("<%=boardtitle_id%>" =="BR11"){
				 location.href="/ShareProject/whole/board/MarketBoard.html";
			}else if("<%=boardtitle_id%>" == "BR02"){
				location.href="/ShareProject/whole/board/FreeBoard.html";
			}else if("<%=boardtitle_id%>" == "BR10"){
				location.href="/ShareProject/whole/board/WHQnABoard.html";
			}else if("<%=boardtitle_id%>" == "BR12"){
				// 보강
				location.href="/ShareProject/whole/board/MakeUPBoard.html";
			}// 뒤로버튼 클릭 후 돌아갈 게시판 아이디랑 경로 html로 넣으시면 됩니당
		})
		
		$(document).on('click', '#reportBtn', function() {
			reportData = $('#reportForm').serialize();
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
				}
			})
		})
		
		//답글 클릭한 사람 mem_id 가져오기
		$(document).on('click', '#response', function(){
			//alert("눌림");
			//$('#ResponseModal').modal('show');
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
				}
			})
		})	
		//답글 등록
		$(document).on('click', '#reinsert', function(){
			
			responseData =$('#responseForm').serialize();
			$.ajax({
				url :'/ShareProject/InsertAdminreBoard.do',
				type : 'get',
				data : responseData,
				dataType : 'json',
				success : function(res){
					if(res.flag=="답글등록완료"){
						//$('#ResponseModal').modal('hide');
						location.reload();
					}
				},
				error : function(xhr){
				}
			})
		})
		
	 //답글수정버튼 눌렀을때 답글 본인계정확인
	 $(document).on('click', '.reUpdate', function(){
		rename=$(this).attr('name');
		recont=$('#'+rename).text();
		 //alert(recont);
		$('#reUpdateModal .replyBox').val(recont);
		 
		 remem_id=$(this).attr('id');
		 adminre_num=$(this).parents('#inputParent').find('.adminre_num').attr('id');
	
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
			}
		 }) 
	 })
	 
	 //답글삭제버튼 눌렸을때 답글 본인계정확인
	 $(document).on('click', '.reDelete', function(){
		 //alert("버튼눌림");
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
							location.reload();
						},
						error : function(xhr){
						}
					})
					
				}else{
					alert("본인계정 답글이 아닙니다.");
					location.reload();
				}
			},
			error : function(xhr){
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
					  if(res.flag="수정완료"){
				   $('#reUpdateModal').modal("hide");
				   //location.reload();
				   location.reload();
				  } 
			  },
			  error : function(xhr){
			  }
		  })
	 })
	 
	 
	 
		
	})
</script>
</head>

<body>
	<div id="view"></div>
</body>
</html>