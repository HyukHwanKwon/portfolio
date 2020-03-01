<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품리스트</h1>
	
	<c:forEach items="${itemList}" var="itemList" varStatus="status">	
		<table border="1">
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>상품가격</th>
				<th>상품내용</th>
				<th>상품이미지</th>
				<th>상품수정</th>
				
			</tr>
			
			
			 <tr>
				 <form action="itemModifyUpdate.item" method="post" enctype="multipart/form-data">
					<td><input type="text" name="num" id="num" value="${itemList.itemNum}"></td>
					<td><input type="text" name="name" id="name" value="${itemList.itemName}"></td>
					<td><input type="text" name="price" id="price" value="${itemList.itemPrice}"></td>
					<td><input type="text" name="content" id="content" value="${itemList.itemContent}"></td>
					<td><input type="file" name="image" id="image" value="${itemList.itemImage}"></td>
					<td><input type="submit" value="수정"></td>
				 </form>	
			 </tr>	
			 			 
		</table>
	</c:forEach>
	
	
</body>
</html>