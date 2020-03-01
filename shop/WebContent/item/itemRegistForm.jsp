<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="itemRegist.item" method="post" enctype="multipart/form-data">
		<p>상품 번호:<input type="text" name="itemNum" id="itemNum"></p>
		<p>상품 이름:<input type="text" name="itemName" id="itemName"></p>
		<p>상품 가격:<input type="text" name="itemPrice" id="itemPrice"></p>
		<p>상품 내용:<input type="text" name="itemContent" id="itemContent"></p>
		<p>상품 이미지<input type="file" name="itemImage" id="itemImage"></p>
		
		<input type="submit" value="상품등록">
	</form>
</body>
</html>