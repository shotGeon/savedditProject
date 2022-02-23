<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/qrcodejs/1.0.0/qrcode.min.js"></script>
</head>
<body>
	<input type="button" onclick="generateQR()" value="눌러"/>
	
	<div id="qrcode"></div>
	<input type="button" onclick="decode()" value="해독하기">
	<input type="text" id="decodetext"/>
</body>
<script>

	var qrcode = new QRCode(document.getElementById("qrcode"));
	var data="";
	function generateQR(){
	
		data ="http://192.168.43.64/ddit/index.do";
		qrcode.makeCode(data);
		
	}
	
	function decode(){
		//alert(data);
		var devalue = document.getElementById('decodetext');
		devalue.value=data;
	}
</script>
</html>