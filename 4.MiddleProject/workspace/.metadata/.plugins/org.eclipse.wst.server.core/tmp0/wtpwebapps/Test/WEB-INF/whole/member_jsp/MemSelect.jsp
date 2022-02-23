<%@page import="member.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/Test/js/jquery-3.6.0.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>
$(function(){
	$(document).on('click','#update', function(){
		dv = $(this).parents('#memBox');
		
		id =$(dv).find('#id').val();
		
		pwd =$(dv).find('#pwd').val();
		
		email =$(dv).find('#email').val();
		
		
		enabled =$(dv).find('#enabled').val();
		
		phone =$(dv).find('#phone').val();
		
		//alert("phone"+phone);
		
		name = $(dv).find('#name').val();
		
		address =$(dv).find('#address').val();
		
		//alert(id);
		
		$('#updateModal .ID').val(id)
		$('#updateModal .PWD').val(pwd)
		$('#updateModal .EMAIL').val(email)
		$('#updateModal .ENABLED').val(enabled)
		$('#updateModal .PHONE').val(phone)
		$('#updateModal .NAME').val(name)
		$('#updateModal .ADDRESS').val(address)
		
		
		$('#updateModal').modal('show');
		
		
	})
	
	$(document).on('click', '#back', function(){
		location.href='/Test/whole/index.html';
	})
	
	
	
	$(document).on('click','#delete', function(){
		ID=$(this).attr('name');
		location.href="/Test/MemDelete.do?ID="+ID;
	})
	
	
})
</script>

<style>

* {
	margin: 10px;
	padding : 0px;
}

#atchTable {
	width : 55%;
	height : 55%;
	text-align: center;
	
	
}

#tr1{
	background: lightblue;
}
.td1{
	font-weight: bold;
}

#back{
	margin-left: 10px;
}

.selBtn{
	width: 100px;
}
#img{
	width: 100px;
	height: 100px;
}
</style>


<div id="memBox">
	<input type="hidden" id="pwd" value="${mv.pwd}">
	<input type="hidden" id="enabled" value="${mv.enabled}">
<table id="atchTable" border="1">
	<tr id="tr1">
		<td class="td1" colspan="2">회원정보 상세조회</td>
	</tr>

	<tr>
		<td class="td1">아이디</td>
		<td>${mv.id}
		<input type="hidden" id="id" value="${mv.id}"></td>
	</tr>
	
	<tr>
		<td class="td1">이름</td>
		<td>${mv.name}
		<input type="hidden" id="name" value="${mv.name}"></td>
	</tr>
	
	<tr>
		<td class="td1">사진</td>
		<td><img id="img" src="Upload/${mv.picture}">
		<input type="hidden" id="picture" value="${mv.picture}"></td>
	</tr>
	
	<tr>
		<td class="td1">이메일</td>
		<td>${mv.email}
		<input type="hidden" id="email" value="${mv.email}"></td>
	</tr>
	
	<tr>
		<td class="td1">전화번호</td>
		<td>${mv.phone}
		<input type="hidden" id="phone" value="${mv.phone}"></td>
	</tr>
	
	<tr>
		<td class="td1">주소</td>
		<td>${mv.address}
		<input type="hidden" id="address" value="${mv.address}"></td>
		
	</tr>
	
	<tr>
		<td class="td1">재직여부</td>
		<td>${requestScope.name}
		<input type="hidden" id="enabled" value="${requestScope.name}"></td>
		
	</tr>
	
	
	
</table>

<input class="selBtn" type="button" value="목록으로" id="back">
<input class="selBtn" type="button" value="삭제" id="delete" name="${mv.id}">
<input class="selBtn" type="button" value="수정" id="update" name="${mv.id}">

<!-- Modal -->
  <div class="modal fade" id="updateModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원수정</h4>
        </div>
        <div class="modal-body">
          <form action="/Test/MemUpdate.do" method="post" enctype="multipart/form-data">
          	<label>아이디</label><input type="text" class="ID" name="ID" readonly><br>
          	<label>패스워드</label><input id="PWD" type="password" class="PWD" name="PWD"><br>
          	<label>이메일</label><input id="EMAIL" type="EMAIL" class="EMAIL" name="EMAIL"><br>
          	<label>사진</label><input type="file" id="PICTURE" name="file"><br>
          	   <span id="jae">재직</span><input type="radio" value="1" id="ENABLED" name="ENABLED">
          	       휴직<input type="radio" value="2" id="ENABLED" name="ENABLED">
          	       퇴사<input type="radio" value="0" id="ENABLED" name="ENABLED"><br>
          	<label>전화번호</label><input id="PHONE" type="text" class="PHONE" name="PHONE"><br>
          	<label>이름</label><input type="text" id="NAME" class="NAME" name="NAME"><br>
          	<label>주소</label><input type="text" class="ADDRESS" name="ADDRESS"><br>
          	
          	<p><input id="mupdate" type="submit" value="수정"></p>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>


</div>