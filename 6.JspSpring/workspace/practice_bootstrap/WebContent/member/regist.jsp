<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title" style="background: #007bff">회원등록</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" class="form-horizontal" action="regist" method="post">
              	<input type="hidden" name="picture" />
                <div class="card-body">
                  <div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
                     <div class="mailbox-attachment-info">
							<div class="input-group input-group-sm">
								<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
								<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
								<span class="input-group-append-sm">											
									<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
								</span>
							</div>
					   </div>
                  
                  <div class="form-group">
                    <label for="exampleInputEmail1">아이디</label>
                    <input type="text" id="id" name="id" class="form-control" id="" placeholder="Id">
                    <input type="button" id="idCheck" onclick="idCheck_go()" value="중복확인" />
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
               			<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();return false;" class="btn btn-info">등&nbsp;&nbsp;록</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							
							</div>
                </div>
              </form>
            </div>
      <form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
      	<input id="inputFile" name="pictureFile" type="file" style="display: none" onchange="picture_go();">
      	<input id="oldFile" type="hidden" name="oldPicture" value="">
      	<input type="hidden" name="checkUpload" value="0">
      </form>
 <script>
 function regist_go(){
	
	 var memberData = $('form[role="form"]').serialize();
	 
	  $.ajax({
		 url :'regist',
		 data : memberData,
		 type : 'post',
		 success : function(res){
			 if(res=="INSERT"){
				 alert("등록성공");
				 CloseWindow("list");
				 
			 }else{
				 alert("등록실패");
			 }
		 },
		 error : function(xhr){
			 
		 }
		 
		 
		 
	 })
			 
	 
 }
 
  var checkedID="";
 	function idCheck_go(){
		
 		var input_ID = $('input[name="id"]');
 		
 		if(!input_ID.val()){
 			alert("아이디를 입력하세요");
 			input_ID.focus();
 			return;
 		}else{
 			var reqID= /^[a-z]{1}[a-zA-Z0-9]{3,12}$/;
 			if(!reqID.test($('input[name="id"]').val())){
 				alert("아이디는 첫글자는 영소문자이며, \n 4~13자의 영문자와 숫자로만 입력해야 합니다.");
 				$('input[name="id"]').focus();
 				return;
 			}
 		}
 		
 		
 		$.ajax({
 			url : 'idCheck?id='+input_ID.val().trim(),
 			type : 'get',
 			success : function(res){
 				if(res=="DUPLICATED"){
					alert("중복된 아이디 입니다.");
					$('input[name="id"]').focus();
				}else{
					alert("사용가능한 아이디 입니다.");
					checkedID=input_ID.val().trim();
					$('input[name="id"]').val(input_ID.val().trim());
				}

 			},
 			error : function(xhr){
 				
 			}
 		})
 		
 	}
 
 	var formData="";
 	function picture_go(){
		//j쿼리객체를 자바스크립트 객체로 바꿈
		formData = new FormData($('form[role="imageForm"]')[0]);
		var form = $('form[role="imageForm"]');
		//j쿼리객체를 자바스크립트 객체로 바꿈
		var picture = form.find('[name=pictureFile]')[0];
		
		
		var fileFormat = picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
		alert(fileFormat);
		if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
			alert("이미지는 jpg/jpeg 형식만가능합니다.");
			picture.value="";
			return;
		}
		
		if(picture.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			picture.value="";
			return;
		}
		
		form.find('[name="checkUpload"]').val(0);
		
		document.getElementById('inputFileName').value=picture.files[0].name;
		
		if(picture.files && picture.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('div#pictureView')
					.css({'background-image' : 'url('+e.target.result+')',
						'backgroun-position' : 'center',
						'backgroun-size' : 'cover',
						'backgroun-repeat' : 'no-repeat'
						
						});
			}
			reader.readAsDataURL(picture.files[0]);
		}
		
	}
 	
 	function upload_go(){
 		if(!$('input[name="pictureFile"]').val()){
 			alert("사진을 선택하세요");
 		}
 			if($('input[name="checkUpload"]').val()==1){
			alert("이미 업로드 된 사진입니다.");
			return;
		}
		
		$.ajax({
			url :"picture",
			data : formData,
			type : 'post',
			processData :false,
			contentType :false,
			success : function(data){
				
				$('input[name="checkUpload"]').val(1);
				
				$('input#oldFile').val(data);
				$('form[role=form] input[name="picture"]').val(data);
				alert("사진이 업로드 되었습니다.");
			},
			error  : function(xhr){
				alert("현재 사진 업로드가 불가합니다. \n 관리자에게 연락바랍니다.")
			}
		})
		
 	}
 	
 	
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
            