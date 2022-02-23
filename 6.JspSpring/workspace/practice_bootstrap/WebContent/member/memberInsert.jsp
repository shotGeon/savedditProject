<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title" style="background: #007bff">회원등록</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="/practice_bootstrap/member/memberInsert" method="post" enctype="multipart/form-data">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">아이디</label>
                    <input type="text" id="id" name="id" class="form-control" id="" placeholder="Id">
                    <input type="button" id="idCheck" value="중복확인" disabled="disabled" />
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">비밀번호</label>
                    <input type="password" id="pwd" name="password" class="form-control" id="" placeholder="Password">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">비밀번호확인</label>
                    <input type="password" id="pwdCheck" class="form-control" id="" placeholder="Password">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">이메일</label>
                    <input type="text" id="email" name="email" class="form-control" id="" placeholder="email">
                  </div>
                  
                  <div class="form-group">
                    <label for="">회원사진</label>
                    <input type="file" name="file">
                  </div>
                  
                  <div class="form-group">
                  	<label for="">재직여부</label>
                  	<select name = "enabled">
						<option value="0">퇴사</option>
						<option value="1">재직</option>
						<option value="2">휴직</option>
					</select>
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">입사일</label>
                    <input type="date" name="regdate" class="form-control" id="regdate" placeholder="Password">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">전화번호</label>
                    <input type="text" name="phone" class="form-control" id="phone" placeholder="Phone">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">이름</label>
                    <input type="text" id="name" name="name" class="form-control" id="" placeholder="Name">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">등록자</label>
                    <input type="text" name="register" class="form-control" id="" placeholder="Register">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">주소</label>
                    <input type="text" id="sample6_address" name="address1" class="form-control" placeholder="Address">
                    <input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기"><br>
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">상세주소</label>
                    <input type="text" name="address2" class="form-control" id="exampleInputPassword1" placeholder="Address">
                  </div>
                  
                  <div class="form-group">
                  	<label for="exampleInputPassword1">권한</label>
                  	<select name = "authority">
						<option id="" value="ROLE_USER">ROLE_USER</option>
						<option id="" value="ROLE_ADMIN">ROLE_ADMIN</option>
						<option id="" value="ROLE_MANAGER">ROLE_MANAGER</option>
					</select>
                  </div>
                  
                <!-- /.card-body -->

                <div class="card-footer">
                  <input type="submit" class="btn btn-primary" />
                </div>
              </form>
            </div>
 <script>
	 $(document).on('keyup', '#id', function(){
			idvalue =$(this).val().trim();
			
			//정규식
			idreg=/^[a-z][a-zA-Z0-9]{3,11}$/;
			
			if(!(idreg.test(idvalue))){
				$(this).css('border', '2px solid red');
				$('#idCheck').prop('disabled', true);
			}else{
				$(this).css('border', '2px solid blue');
				$('#idCheck').prop('disabled', false);
			}	
			
		})
		$(document).on('keyup', '#pwd', function(){
			pwdvalue=$(this).val().trim();
			pwdreg =/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
			if(!(pwdreg.test(pwdvalue))){
				$(this).css('border', '2px solid red');
			}else{
				$(this).css('border', '2px solid blue');
			}
		})
		
		$(document).on('keyup', '#pwdCheck', function(){
			pwdvalue=$('#pwd').val().trim();
			pwdchkvalue=$('#pwdCheck').val().trim();
			if(pwdvalue!=pwdchkvalue){
				$(this).css('border', '2px solid red');
			}else{
				$(this).css('border', '2px solid blue');
			}
		})

		$(document).on('keyup','#name', function(){
			namevalue = $(this).val().trim();
			namereg =/^[가-힣]{2,4}$/;
			
			if(namereg.test(namevalue)){
				$(this).css('border', '2px solid blue');
			}else{
				$(this).css('border', '2px solid red');
			}
			
		})
		
		$(document).on('keyup','#email', function(){
		emailvalue = $(this).val().trim();
		emailreg =/^([a-zA-Z0-9]+)@([a-zA-Z0-9]+)(\.[a-z]+){1,2}$/;
		
		if(emailreg.test(emailvalue)){
			$(this).css('border', '2px solid blue');
		}else{
			$(this).css('border', '2px solid red');
		}	
		
		})
	
		$(document).on('keyup','#phone', function(){
			regdate =$('#regdate').val();
			regdateStr= String(regdate);
			if(regdateStr.length<1){
				alert("입사일을 입력하세요");
			}			
			telvalue = $(this).val().trim();
			telreg =/\d{3}\d{4}\d{4}/;
			
			if(telreg.test(telvalue)){
				$(this).css('border', '2px solid blue');
			}else{
				$(this).css('border', '2px solid red');
			}	
			
		})
 
 	
	function sample6_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {

				var addr = ''; // 주소 변수

				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				} else { // 사용자가 지번 주소를 선택했을 경우(J)
					addr = data.jibunAddress;
				}

				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				//document.getElementById('sample6_postcode').value = data.zonecode;
				document.getElementById("sample6_address").value = addr;
				// 커서를 상세주소 필드로 이동한다.
				//document.getElementById("sample6_detailAddress")
				//		.focus();
			}
		}).open();
	}
	 
	 
</script>            
            