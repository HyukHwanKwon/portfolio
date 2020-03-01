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
	
	<c:if test="${id != null}">
		${id}님 환영합니다
		<a href="managerLogOut.ma">로그아웃</a>
		<a href="memberList.ma">회원목록</a>
		<a href="itemRegister.item">상품등록</a>
		<a href="itemList.item">상품수정 및 삭제</a>
		<a href="boardRegister.bo">공지사항 작성</a>
		
	</c:if>
	
	
	
	
</body>
</html>