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
	<h3>Uploaded File Information</h3>
	<ul>
		<li>title : ${title }</li>
		<li>original file name : ${originalFilename }</li>
		<li>uploaded file name : ${uploadedFilename }</li>
		<li>upload path : ${uploadPath }</li>
	</ul>
</body>
</html>