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
	<script type="text/javascript">
		function doSubmit() {
			if (form_raspberrypi.status.value == "") {
				alert("상태값을 입력해주세요");
				form_raspberrypi.status.focus();
				return false;
			} else if (form_raspberrypi.status.value == "0") {
				return true;
			} else if (form_raspberrypi.status.value == "1") {
				return true;
			} else if (form_raspberrypi.status.value != "0" || form_raspberrypi.status.value != "1") {
				alert("0, 1 중에서 입력해주세요");
				form_raspberrypi.status.focus();
				return false;
			}
			
			return true
		}
	</script>
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
								<h1>라즈베리파이 상태값 변경</h1>
								<form name="form_raspberrypi" action="<c:url value='/raspberrypi/update.do'/>" method="post" onsubmit="return doSubmit();">
									<table class="table table-hover">
										<thead>
											<tr>
												<td><strong>라즈베리파이IP</strong></td>
												<td><strong>세부장소</strong></td>
												<td><strong>디테일</strong></td>
												<td><strong>층</strong></td>
												<td><strong>남/여</strong></td>
												<td><strong>상태 값</strong></td>
												<td><strong>0 = 사용x<br>1 = 사용o</strong>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${raspberrypi.raspberrypiIp}</td>
												<td>${raspberrypi.placeName}</td>
												<td>${raspberrypi.detailName}</td>
												<td>${raspberrypi.floorName}</td>
												<td>${raspberrypi.genderName}</td>
												<td><input type="text" name="status" id="status" value="${raspberrypi.raspberrypiStatus}"></td>
												<td><input type="submit" value="변경"> <input type="reset" value="취소" onclick="history.back()"></td>
											</tr>
										</tbody>
									</table>
									<input type="hidden" name="ip" id="ip" value="${raspberrypi.raspberrypiIp}">
								</form>
							</div>
						</div>
					</section>
				</section>
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