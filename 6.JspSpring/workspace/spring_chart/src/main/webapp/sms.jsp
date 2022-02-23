<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	
	<div class="row">
          <div class="col-sm-6">
            <!-- Select multiple-->
            <div class="form-group">
              <label>Select Multiple</label>
              <select multiple="" class="form-control">
                <option>option 1</option>
                <option>option 2</option>
                <option>option 3</option>
                <option>option 4</option>
                <option>option 5</option>
              </select>
            </div>
          </div>
          <div class="col-sm-6">
            <div class="form-group">
              <label>Select Multiple Disabled</label>
              <select multiple="" class="form-control" disabled="">
                <option>option 1</option>
                <option>option 2</option>
                <option>option 3</option>
                <option>option 4</option>
                <option>option 5</option>
              </select>
            </div>
          </div>
     </div>
	
	<form method="post" id="smsForm">
	    <ul>
	      <li>보낼사람 : <input type="text" name="from"/></li>
	      <li>내용 : <textarea name="text"></textarea></li>
	      <li><input type="button" onclick="sendSMS('sendSms')" value="전송하기" /></li>
	    </ul>
   </form>
  
  <script>
    function sendSMS(pageName){

    	console.log("문자를 전송합니다.");
    	$("#smsForm").attr("action", pageName + ".do");
    	$("#smsForm").submit();
    }
  </script>

</body>
</html>