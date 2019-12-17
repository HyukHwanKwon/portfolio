<%@page import="com.sun.org.apache.bcel.internal.generic.Select"%>
<%@page import="beans.*"%>
<%@page import="action.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="dogCartList.css">
	<script>
		function checkAll (theForm) {
	    	if (theForm.remove.length == undefined) {
	        	theForm.remove.checked = theForm.allCheck.checked;
	      	} else {
	      		for (var i = 0; i < theForm.remove.length; i++) {
	            	theForm.remove[i].checked = theForm.allCheck.checked;
	         	}
	      	}
	   	}
	   
	   	function checkQty (qty, kind) {
	    	if (qty != 1) {
	        	location.href="dogCartQtyDown.dog?kind="+ kind;
	      	}
	   	}
	</script>
</head>
<body>
	<c:if test="${startMoney !=null}">
	   <c:set var="startMoney" value="${startMoney}"></c:set>
	</c:if>
	<c:if test="${endMoney !=null}">
	   <c:set var="endMoney" value="${endMoney}"></c:set>
	</c:if>
	<section id="listForm">
		<c:if test="${cartList != null && cartList.size() > 0}">
	   	<h2>장바구니 목록</h2>
		<form method="post">
	    	<table>
	       		<tr id="select">
	          		<td colspan="6">
	          			<select id="startMoney" name="startMoney">
	             			<option> =최하= </option>
	             			<c:choose>
		                		<c:when test="${startMoney == 150000}">
				                   	<option selected="selected">150000</option>
				                   	<option>200000</option>
				                   	<option>300000</option>
				                   	<option>450000</option>
		                		</c:when>
		                		<c:when test="${startMoney == 200000}">
			                   		<option>150000</option>
			                   		<option selected="selected">200000</option>
			                   		<option>300000</option>
			                   		<option>450000</option>
		                		</c:when>
		                		<c:when test="${startMoney == 300000}">
		                   			<option>150000</option>
		                   			<option>200000</option>
		                   			<option selected="selected">300000</option>
		                   			<option>450000</option>
		                		</c:when>
		                		<c:when test="${startMoney == 450000}">
		                   			<option>150000</option>
		                   			<option>200000</option>
		                   			<option>300000</option>
		                   			<option selected="selected">450000</option>
		                		</c:when>
	                			<c:otherwise>
	                   				<option>150000</option>
	                   				<option>200000</option>
	                   				<option>300000</option>
	                   				<option>450000</option>
	                			</c:otherwise>
	             			</c:choose>
	          			</select>
	          			<select id="endMoney" name="endMoney">
	             			<option> =최고= </option>
	             			<c:choose>
	                			<c:when test="${endMoney == 150000}">
	                   				<option selected="selected">150000</option>
	                   				<option>200000</option>
	                   				<option>300000</option>
	                   				<option>450000</option>
	                			</c:when>
	                			<c:when test="${endMoney == 200000}">
	                   				<option>150000</option>
	                   				<option selected="selected">200000</option>
	                   				<option>300000</option>
	                   				<option>450000</option>
	                			</c:when>
	                			<c:when test="${endMoney == 300000}">
	                   				<option>150000</option>
	                   				<option>200000</option>
	                   				<option selected="selected">300000</option>
	                   				<option>450000</option>
	                			</c:when>
	                			<c:when test="${endMoney == 450000}">
	                   				<option>150000</option>
	                   				<option>200000</option>
	                   				<option>300000</option>
	                   				<option selected="selected">450000</option>
	                			</c:when>
	                			<c:otherwise>
	                   				<option>150000</option>
	                   				<option>200000</option>
	                   				<option>300000</option>
	                   				<option>450000</option>
	                			</c:otherwise>
	             			</c:choose>
	          			</select>
	          			<input type="submit" value="검색" formaction="dogCartSearch.dog"/>
	          		</td>
	       		</tr>
	        	<tr class="tr_top">
	           		<td><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td>
	             	<td>번호</td>
	             	<td>상품 이미지</td>
	             	<td>상품명</td>
	             	<td>가격</td>
	             	<td>수량</td>
	         	</tr>
	        	<c:forEach var="cart" items="${cartList}" varStatus="status">
	        	<tr>
	           		<td>
	              		<input type="checkbox" id="remove" name="remove" value="${cart.kind}"/>
	           		</td>
	             	<td> ${status.index + 1}<!-- 번호값계산 --></td>
	             	<td>
	             		<img src="images/${cart.image}" id ="cartImage"/>
	            	</td>
	             	<td> ${cart.kind} </td>
	             	<td> ${cart.price} </td>
	             	<td>
	             		<a href="dogCartQtyUp.dog?kind=${cart.kind}">
	             			<img src="images/up.jpg" id = "upImage" border=0/>
	             		</a> <br/>
	             		${cart.qty} <br/>
			            <a href="javaScript:checkQty('${cart.qty}', '${cart.kind}')">
			            	<img src="images/down.jpg" id="downImage" border=0/>
			            </a>
	            	</td>
	         	</tr>
	        	</c:forEach>
	      		<tr>
	         		<td colspan="5" style="text-align:center;">
	            		총 금액 : ${totalMoney}원
	         		</td>
	     		</tr>
	      		<tr>
	         		<td colspan="5" style="text-align:center;">
	            		<input type="submit" value="삭제" formaction="dogCartRemove.dog"/>
	         		</td>
	      		</tr>
	      	</table>
		</form>
	   	</c:if>
	   	<c:if test="${cartList == null || cartList.size() <= 0}">
	    	<section class="div_empty">
	      		구입한 강아지 정보가 없거나, 검색 조건에 해당되는 강아지가 없습니다.
	      	</section>
	   	</c:if>
	   	<nav id="commandList">
	        <a href="dogList.dog">쇼핑 계속하기</a>
		</nav>
	</section>
</body>
</html> 