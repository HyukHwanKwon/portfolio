<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<script type="text/javascript">
		alert("아이디나 비밀번호를 확인해주세요");
		window.location.href="<c:url value='/'/>"	
	</script>
</body>
</html>