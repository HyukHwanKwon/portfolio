<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="dogList.css">
</head>
<body>
	<section id="listForm">
		<c:if test="${dogList != null}">
			<h2>강아지 상품목록 <a href="dogRegistForm.dog"><br/>강아지 등록/</a><a href="dogCartList.dog">장바구니</a></h2>
			<table>
				<tr>
				<c:forEach var="dog" items="${dogList}" varStatus="status">
					<td>
						<a href="dogView.dog?id=${dog.id}">
							<img src="images/${dog.image}" id="productImage"/>
						</a>
						이름:${dog.kind} <br/>
						가격:${dog.price}
					</td>
					<c:if test="${((status.index + 1) mod 4) == 0}">
				</tr>
					</c:if>
				</c:forEach>
				</tr>
			</table>
		</c:if>
		<c:if test="${dogList == null}">
			<div class="div_empty">
				<p>강아지가 없습니다. 분양불가</p>
			</div>
		</c:if>
		<c:if test="${todayImageList != null}">
			<div id="todayImageList">
				<h2>오늘 본 강아지 목록</h2>
				<table>
					<tr>
					<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
						<td>
							<img src="images/${todayImage}" id="todayImage"/>
						</td>
						<c:if test="${((status.index + 1) mod 4) == 0}">
					</tr>
					<tr>
						</c:if>
					</c:forEach>
					</tr>
				</table>
			</div>
		</c:if>
	</section>
</body>
</html>