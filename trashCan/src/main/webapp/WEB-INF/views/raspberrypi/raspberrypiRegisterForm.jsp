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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main/main.css"/>">
	
	<!-- Custom styles for this template -->
	<link href="<c:url value='/resources/assets/css/style.css'/>" rel="stylesheet">
	<link href="<c:url value='/resources/assets/css/style-responsive.css'/>" rel="stylesheet">
	
	<script src="<c:url value='/resources/assets/js/chart-master/Chart.js'/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-3.3.1.min.js"/>"></script>
	<script type="text/javascript">
		function check() {
			  if (form_raspberrypi.raspberrypiIP.value == "") {
			    alert("라즈베리파이 IP를 입력해 주세요.");
			    form_raspberrypi.raspberrypiIP.focus();
			    return false;
			  } else if ($("#place option:selected").text() == "--선택--") {
			    alert("장소를 선택해 주세요.");
			    form_raspberrypi.place.focus();
			    return false;
			  } else if ($("#detail option:selected").text() == "--선택--") {
			  	alert("디테일을 선택해 주세요.");
				form_raspberrypi.detail.focus();
				return false;
			  } else if ($("#floor option:selected").text() == "--선택--") {
				alert("층을 선택해 주세요.");
				form_raspberrypi.floor.focus();
				return false;
			  } else if ($("#gender option:selected").text() == "--선택--") {
			    alert("남/여를 선택해 주세요.");
			    form_raspberrypi.gender.focus();
			    return false;
			  }
			  form_raspberrypi.submit();
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
						<div class="contForm">
							<div class="form-panel" style="width: 1100px;">
								<h1>라즈베리파이 등록</h1>
								<form name="form_raspberrypi" class="form-horizontal style-form" action="<c:url value='/raspberrypi/Insert.do'/>" method="post">
									<div class = "form-group"></div>
									<div class = "form-group">
										<label class="col-sm-2 col-sm-2 control-label">장소</label>
										<div style="margin: 0 auto;">
											<select id="place" name="place" style="text-align: center;">
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
												<option>--선택--</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">층</label>
										<div>
											<select name="floor" id="floor">
												<option>--선택--</option>
												<c:forEach var="floor" items="${floor}" varStatus="status">	
													<option value="${floor.floorSeq}">${floor.floorName}</option>
												</c:forEach>
											</select>
										</div>
									</div> 
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">남/여</label>
										<div>
											<select name="gender" id="gender">	
												<option>--선택--</option>
												<c:forEach var="gender" items="${gender}" varStatus="status">	
													<option value="${gender.genderNum}">${gender.genderName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">IP</label>
										<div>
											<input type="text"  name="raspberrypiIP" placeholder="EX)123.123.123.123">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 col-sm-2 control-label">
											<input type="button" class="btn btn-success" value="등록" onclick="javascript:check()" style="font-size: 20px;">
										</label>
									</div>   		
								</form>
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
	
	<script type="text/javascript">
		$(function() {
			$('#place').change( function(){
				if ($("#place option:selected").text() == "--선택--") {
					$("#detail").find('option').remove();
					$("#detail").append("<option>" + "--선택--" + "</option>");
				} else {
					var fkPlaceSeq = $("#place option:selected").val();
					
					$.ajax({
						url : 'detailList.do',
						data : {fkPlaceSeq:fkPlaceSeq},
					    type : 'post',
					    dataType: 'json',
						success : function(data){
						if (data.length > 0) {
							$("#detail").find('option').remove();
								 
							for (i = 0; i < data.length; i++) {
								$("#detail").append("<option value =" + data[i].detailSeq + ">" + data[i].detailName + "</option>")
							}
						} else {
							$("#detail").find('option').remove();
							$("#detail").append("<option>" + "--선택--" + "</option>");
						}
						console.log(data.length);
					    },error:function(request,status,error){
					    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					   	}
					});
				}
			});
		});
	</script>
	<!--js end-->
</body>
</html>