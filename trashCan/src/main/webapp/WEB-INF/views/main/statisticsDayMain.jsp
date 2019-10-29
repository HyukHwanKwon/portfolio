<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<link rel="stylesheet" href="<c:url value="https://fonts.googleapis.com/css?family=Stylish&display=swap"/>">
	
	<!-- Custom styles for this template -->
	<link href="<c:url value='/resources/assets/css/style.css'/>" rel="stylesheet">
	<link href="<c:url value='/resources/assets/css/style-responsive.css'/>" rel="stylesheet">
	
	<script src="<c:url value='/resources/assets/js/chart-master/Chart.js'/>"></script>
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
					<div class="col-lg-9 main-chart">
						<div class="border-head">
							<h1>YESTERDAY STATISTICS</h>
						</div>
						<div class="row mt" style="margin-top: 100px;">
							<!--CUSTOM CHART START -->
							<div class="custom-bar-chart">
								<ul class="y-axis">
									<li><span>100%</span></li>
									<li><span>80%</span></li>
									<li><span>60%</span></li>
									<li><span>40%</span></li>
									<li><span>20%</span></li>
									<li><span>00%</span></li>
								</ul>
								<c:set var="dayMax" value="${dayMax.max}" />
								<c:forEach var="dayView" items="${dayView}" varStatus="status">	
								<fmt:parseNumber var="statisticsPercent" value="${dayView.statisticsUseNum / dayMax * 100}" integerOnly="true"/>
									<div class="bar">
										<div class="title"><strong>${dayView.placeName}</strong></div>
										<div class="value tooltips" data-toggle="tooltip" data-placement="top">${statisticsPercent}%</div>
										<div class="tooltip fade top in" role="tooltip" style="top: -50px; left: 5px; display: block;">
											<div class="tooltip-arrow"></div>
											<div class="tooltip-inner">${dayView.statisticsUseNum}회</div>
										</div>
									</div>
								</c:forEach>
							</div>			
							<!--custom chart end-->
						</div>
						<!-- /row -->
					</div>
					<!-- /col-lg-9 END SECTION MIDDLE -->
					<!-- **********************************************************************************************************************************************************
	      			RIGHT SIDEBAR CONTENT
	      			*********************************************************************************************************************************************************** -->
					<div class="col-lg-3 ds">
						<!-- USERS ONLINE SECTION -->
						<h3>ADMIN LIST</h3>
						<!-- First Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="<c:url value='/resources/assets/img/friends/fr-05.jpg'/>" width="35px" height="35px" align="">
							</div>
							<div class="details">
								<p>
									<br/><a href="#"><strong>Hong Jun Ki</strong></a><br/>
								</p>
								<p>
									<a href="#">＊Team Leader＊</a>
								</p>
							</div>
						</div>
						<!-- Second Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="<c:url value='/resources/assets/img/friends/fr-02.jpg'/>" width="35px" height="35px" align="">
							</div>
							<div class="details">
								<p>
									<br/><a href="#"><strong>Choi Han Bin</strong></a><br/>
								</p>
								<p>
									<a href="#">＊Team members＊</a>
								</p>
							</div>
						</div>
						<!-- Third Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="<c:url value='/resources/assets/img/friends/fr-11.jpg'/>" width="35px" height="35px" align="">
							</div>
							<div class="details">
								<p>
									<br/><a href="#"><strong>Kim Seung Min</strong></a><br/>
								</p>
								<p>
									<a href="#">＊Team members＊</a>
								</p>
							</div>
						</div>
						<!-- Fourth Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="<c:url value='/resources/assets/img/friends/fr-06.jpg'/>" width="35px" height="35px" align="">
							</div>
							<div class="details">
								<p>
									<br/><a href="#"><strong>Choi Ho Jin</strong></a><br/>
								</p>
								<p>
									<a href="#">＊Team members＊</a>
								</p>
							</div>
						</div>
						<!-- Fifth Member -->
						<div class="desc">
							<div class="thumb">
								<img class="img-circle" src="<c:url value='/resources/assets/img/friends/fr-01.jpg'/>" width="35px" height="35px" align="">
							</div>
							<div class="details">
								<p>
									<br/><a href="#"><strong>Kwon Hyuk Hwan</strong></a><br/>
								</p>
								<p>
									<a href="#">＊Team members＊</a>
								</p>
							</div>
						</div>
					</div>
					<!-- /col-lg-3 -->
				</section>
			</section>
			<!--main content end-->
		</section>
		
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
	
	<!--js end-->
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				window.location.href="<c:url value='/'/>"	
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>
