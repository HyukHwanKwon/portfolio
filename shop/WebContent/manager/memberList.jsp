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
	<table border="1">
		<tr>
			<td><h1>회원목록</h1></td>
		</tr>
		<c:forEach var="memberList" items="${memberList}">
		
			<tr>
				<td colspan="2">${memberList.memberId}</td>
				<td colspan="2">${memberList.memberPassword}</td>
				<td colspan="2">${memberList.memberName}</td>
				<td colspan="2">${memberList.memberPhone}</td>
				<td colspan="2">${memberListmemberEmail}</td>
				<td><a href="managerDelete.ma?id=${memberList.memberId}">강제탈퇴</a></td>
			</tr>

		</c:forEach>


	</table>
</body>
</html>