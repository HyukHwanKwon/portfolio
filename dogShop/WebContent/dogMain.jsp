<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<c:if test="${id != null}">
		<c:set var="id" value="${id}">
		</c:set>
	</c:if>
	<c:choose>
		<c:when test="${id != null}">
			<a href="#">${id}님 반갑습니다.</a><br/>
		</c:when>
		<c:otherwise>
			<a href="memberLoginForm.jsp">로그인</a><br/>
		</c:otherwise>
	</c:choose>
	<a href="dogList.dog">강아지 상품 목록</a>
</body>
</html>