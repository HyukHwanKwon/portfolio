<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<c:if test="${msg == 'insertFail'}">
		<script type="text/javascript">
			alert("등록 실패");
			window.location.href="<c:url value='/raspberrypi/RegisterForm.do'/>"	
		</script>
	</c:if>
	<c:if test="${msg == 'insertSuccess'}">
		<script type="text/javascript">
			alert("등록 성공");
			window.location.href="<c:url value='/raspberrypi/RegisterForm.do'/>"	
		</script>
	</c:if>
	<c:if test="${msg == 'updateFail'}">
		<c:set var="raspberrypi" value="${raspberrypi}"></c:set>
		<script type="text/javascript">
			alert("수정 실패");
			window.location.href="<c:url value='/raspberrypi/Management.do'/>"	
		</script>
	</c:if>
	<c:if test="${msg == 'updateSuccess'}">
		<c:set var="raspberrypi" value="${raspberrypi}"></c:set>
		<script type="text/javascript">
			alert("${raspberrypi.raspberrypiIp} 의 라즈베리파이\n상태값을 ${raspberrypi.raspberrypiStatus}으로 수정 성공");
			window.location.href="<c:url value='/raspberrypi/Management.do'/>"	
		</script>
	</c:if>
</body>
</html>