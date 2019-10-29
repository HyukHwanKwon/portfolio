<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<div class="raspberrypiForm" >
							<div class="form-panel" style="width : 1100px;">
								<h1>라즈베리파이 조회</h1>
								<form name="form_raspberrypi" class="form-horizontal style-form">
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">장소</label>
										<div>
											<select id="place" name="place">
												<option>--선택--</option>
												<c:forEach var="place" items="${place}" varStatus="status">	
													<option value="${place.placeSeq}">${place.placeName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">세부장소</label>
										<div>
											<select name="detail" id="detail">
												<option value="dump">--선택--</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">층</label>
										<div>
											<select name="floor" id="floor">
												<option value="dump">--선택--</option>
											</select>
										</div>
									</div> 
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">남/여</label>
										<div>
											<select name="gender" id="gender">
												<option value="dump">--선택--</option>
											</select>
										</div>
									</div> 		
								</form>
							</div>
							<div class="content-panel" style="margin-top: 80px; display: none;">
								<table class="table table-hover" id="raspberrypiManagementTable">
								</table>
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
	
	<script type="text/javascript" src="<c:url value="/resources/javascript/raspberrypi/raspberrypiManagement.js"/>"></script>
	<!--js end-->
</body>
</html>