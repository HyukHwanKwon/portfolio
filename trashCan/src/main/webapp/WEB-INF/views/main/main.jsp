<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main/main.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main/loginForm.css"/>">
	<link rel="stylesheet" href="<c:url value="https://fonts.googleapis.com/css?family=Baloo&display=swap"/>">
	<link rel="stylesheet" href="<c:url value="//cdn.rawgit.com/hiun/NanumSquare/master/nanumsquare.css"/>">
</head>
<body>
	<c:choose>
		<c:when test="${admin != null}">
			<c:if test="${msg == 'loginOk'}">
				<script type="text/javascript">
					window.location.href="<c:url value='/main/statisticsDayMain.do'/>"	
				</script>
			</c:if>
			<c:if test="${msg == 'cleanerListFail'}">
				<script type="text/javascript">
					window.location.href="<c:url value='/main/statisticsDayMain.do'/>"	
				</script>
			</c:if>
			<c:if test="${msg == 'cleanerDeleteOk'}">
				<script type="text/javascript">
					alert("삭제 성공")
					window.location.href="<c:url value='/main/statisticsDayMain.do'/>"	
				</script>
			</c:if>
			<c:if test="${msg == 'cleanerLicenseFail'}">
				<script type="text/javascript">
					window.location.href="<c:url value='/main/statisticsDayMain.do'/>"	
				</script>
			</c:if>
			<c:if test="${msg == 'cleanerInsertOk'}">
				<script type="text/javascript">
					alert("삭제 성공")
					window.location.href="<c:url value='/main/statisticsDayMain.do'/>"	
				</script>
			</c:if>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				window.location.href = "<c:url value='/'/>"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>