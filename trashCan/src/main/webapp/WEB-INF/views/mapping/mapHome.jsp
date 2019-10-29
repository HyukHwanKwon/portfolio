<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="Dashboard">
	<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/bootstrap.css"/>">
	<!--external css-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/font-awesome/css/font-awesome.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/css/zabuto_calendar.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/js/gritter/css/jquery.gritter.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/lineicons/style.css"/>">
	
	<!-- Custom styles for this template -->
	<link href="<c:url value='/resources/assets/css/style.css'/>" rel="stylesheet">
	<link href="<c:url value='/resources/assets/css/style-responsive.css'/>" rel="stylesheet">
	
	<script src="<c:url value='/resources/assets/js/chart-master/Chart.js'/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-3.3.1.min.js"/>"></script>
</head>
<body>
	<c:choose>
		<c:when test="${admin != null}">
			<section id="container">
				<%@ include file="/WEB-INF/views/include/include-header.jsp"%>
				<!-- **********************************************************************************************************************************************************
		      	MAIN CONTENT
		      	*********************************************************************************************************************************************************** -->
				<!--main content start-->
				<section id="main-content">
					<section class="wrapper">
						<div>
							<div class="content-panel">
								<h1>라즈베리파이</h1>
								<table class="table table-hover">
									<thead>
										<tr>
											<td><input type="checkbox" id="checkAll"></td>
											<td>라즈베리파이IP</td>
											<td>장소</td>
											<td>디테일</td>
											<td>층</td>
											<td>남/여</td>
										</tr>
									<thead>
									<tbody>
										<c:if test="${fn:length(piList) > 0}">
											<c:forEach items="${piList}" var="item">
												<tr>
													<td><input type="checkbox" class="piBox" name="piIP" value="${item.raspberrypiIp}"></td>
													<td>${item.raspberrypiIp}</td>
													<td>${item.placeName}</td>
													<td>${item.detailName}</td>
													<td>${item.floorName}</td>
													<td>${item.genderName}</td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
									<tfoot>
										<c:if test="${page.getTotalCount() > 0}">
											<tr>
												<td>
													<c:if test="${page.prev}">
														<a href="javascript:sendPage(${page.getStartPage()-1});">&laquo;</a>
													</c:if>
												</td>
												<td>	
													<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" var="idx">
														<a href="javascript:sendPage(${idx});">${idx}</a>
													</c:forEach>
												</td>
												<td>	
													<c:if test="${page.next}">
														<a href="javascript:sendPage(${page.getEndPage()});">&raquo;</a>
													</c:if>
												</td>
											</tr>
										</c:if>
									</tfoot>
								</table>
								<h1>유저</h1>
								<table class="table table-hover">
									<thead>
										<tr>
											<td></td>
											<td>아이디</td>
											<td>이름</td>
											<td>연락처</td>
										</tr>
									</thead>
									<tbody>
										<c:if test="${fn:length(cList) > 0}">
											<c:forEach items="${cList}" var="item">
												<tr>
													<td><input type = "radio" name = "cleanID" value = "${item.cleanerId}"></td>
													<td>${item.cleanerId}</td>
													<td>${item.cleanerName}</td>
													<td>${item.cleanerPhone}</td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>
								<input type="button" class="btn btn-success" value="등록" id="submit" onclick="javascript:fnGetdata()" >
							</div>
						</div>
					</section>
				</section>
			<!--main content end-->
			</section>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				window.location.href="<c:url value='/'/>"	
			</script>
		</c:otherwise>
	</c:choose>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value='/resources/assets/js/jquery.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery-1.8.3.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>
	<script class="include" type="text/javascript" src="<c:url value='/resources/assets/js/jquery.dcjqaccordion.2.7.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery.scrollTo.min.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/jquery.nicescroll.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/resources/assets/js/jquery.sparkline.js'/>"></script>

	<!--common script for all pages-->
	<script src="<c:url value='/resources/assets/js/common-scripts.js'/>"></script>

	<!--script for this page-->
	<script src="<c:url value='/resources/assets/js/sparkline-chart.js'/>"></script>
	<script src="<c:url value='/resources/assets/js/zabuto_calendar.js'/>"></script>
	
	<script src="<c:url value='/resources/assets/js/idk.js'/>"></script>
	<script src="<c:url value='/resources/javascript/mapping/mapHome.js'/>"></script>
	<!--js end-->
</body>
</html>