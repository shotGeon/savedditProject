0<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신규 회사 등록</title>
</head>
<body>
	<form action="insert.do" method="post">
		<table border="1">
			<tr>
				<td>Buyer_Id:</td>
				<td><input type="text" name="buyer_id"></td>
			</tr>
			
			<tr>
				<td>Buyer_Name:</td>
				<td><input type="text" name="buyer_name"></td>
			</tr>
			
			<tr>
				<td>Buyer_Lgu:</td>
				<td><input type="text" name="buyer_lgu"></td>
			</tr>
			
			<tr>
				<td>Buyer_Comtel:</td>
				<td><input type="text" name="buyer_comtel"></td>
			</tr>
			
			<tr>
				<td>Buyer_Fax:</td>
				<td><input type="text" name="buyer_fax"></td>
			</tr>
			
			<tr>
				<td>Buyer_Mail:</td>
				<td><input type="text" name="buyer_mail"></td>
			</tr>
			
			<tr>
				<td>Buyer_Bank:</td>
				<td><input type="text" name="buyer_bank"></td>
			</tr>
			
			<tr>
				<td>Buyer_Add1:</td>
				<td><input type="text" name="buyer_add1"></td>
			</tr>
			
			<tr>
				<td>Buyer_Add2:</td>
				<td><input type="text" name="buyer_add2"></td>
			</tr>
		</table>	
		
		<input type="submit" value="회사등록">
	
	</form>

</body>
</html>