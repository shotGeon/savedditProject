<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title></title>

<head></head>

<body>
<div class="col-md-4" style="margin: 250px auto">
<div class="card-info">
              <div class="card-header" style="background-color: #1a4f72;">
                <h3 class="card-title">COVID-19 COMPASS Login</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form class="form-horizontal" action="<%=request.getContextPath()%>/common/login.do" method="post">
                <div class="card-body">
                  <div class="form-group row">
                    <label for="id" class="col-sm-2 col-form-label">I D</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" name="mberId" id="id" placeholder="I D">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" name="mberPwd" id="password" placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                    	<a id="findid" href="#" onclick="OpenWindow('<%=request.getContextPath()%>/common/find_IdForm','아이디 찾기','400','247');">아이디 찾기</a>/
                    	<a id="findpwd" href="#" onclick="OpenWindow('<%=request.getContextPath()%>/common/find_PwdForm','비밀번호 찾기','400','523');">비밀번호 찾기</a>
                    </div>
                  	</div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer" style="padding-left:5%">
                  <button type="submit" class="btn btn-info" style="width:100%; background-color: #1a4f72; border-color: #1a4f72;">로그인</button>
                </div>
                <!-- /.card-footer -->
              </form>
            </div>
</div>
<script>
window.onload = function(){
	$('#id').focus();
}
	if('${message}'){
		alert('${message}');
	}
</script>
</body>