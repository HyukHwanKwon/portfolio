<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- **********************************************************************************************************************************************************
     	TOP BAR CONTENT & NOTIFICATIONS
     	*********************************************************************************************************************************************************** -->
	<!--header start-->
	<header class="header black-bg">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right"></div>
		</div>
		<!--logo start-->
		<a href="/main/statisticsDayMain.do" class="logo"><b>CHUNGLIM</b></a>
		<!--logo end-->
		<div class="nav notify-row" id="top_menu">
			<!--  notification start -->
			<ul class="nav top-menu">
				<!-- settings start -->
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="index.html#"> 
						<i class="fa fa-tasks"></i><span class="badge bg-theme">${mapCount}</span>
					</a>
					<ul class="dropdown-menu extended tasks-bar">
						<div class="notify-arrow notify-arrow-green"></div>
						<li>
							<p class="green">등록된 정보</p>
						</li>
						<li>
							<a href="<c:url value='/raspberrypi/Management.do'/>">
								<div class="task-info">
									<div class="desc">Raspberrypi</div>
									<div class="percent">${piCount}개</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${piCount}" aria-valuemin="0"
										aria-valuemax="100" style="width: ${piCount}%">
									</div>
								</div>
							</a>
						</li>
						<li>
							<a href="<c:url value='/cleaner/cleanerList.do'/>">
								<div class="task-info">
									<div class="desc">Cleaner</div>
									<div class="percent">${cleanCount}명</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${cleanCount}" aria-valuemin="0"
										aria-valuemax="100" style="width: ${cleanCount}%">
									</div>
								</div>
							 </a>
						</li>
						<li>
							<li><a href="<c:url value='/mapping/mappingList'/>">
								<div class="task-info">
									<div class="desc">Mapping</div>
									<div class="percent">${mapCount}</div>
								</div>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="${mapCount}" aria-valuemin="0" aria-valuemax="100"
										style="width: ${mapCount}%">
									</div>
								</div>
							</a>
						</li>
						<li class="external">
							<a href="<c:url value='/statistics/statisticsLive.do'/>">See Live statistics</a>
						</li>
					</ul>
				</li>
				<!-- settings end -->
			</ul>
			<!--  notification end -->
		</div>
		<div class="top-menu">
			<ul class="nav pull-right top-menu">
				<li><a class="logout" href="<c:url value='/adminLogOut.do'/>">Logout</a></li>
			</ul>
		</div>
	</header>
	<!--header end-->
	<!-- **********************************************************************************************************************************************************
     	MAIN SIDEBAR MENU
     	*********************************************************************************************************************************************************** -->
	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu" id="nav-accordion">
				<p class="centered">
					<a href="#">
						<img src="<c:url value='/resources/assets/img/ui-sam.jpg'/>" class="img-circle" width="60">
					</a>
				</p>
				<c:set var="admin" value="${admin.adminId}"/>
				<h5 class="centered">${admin}</h5>
				<li class="mt">
					<a class="active" href="/main/statisticsDayMain.do"> 
						<i class="li_display"></i><span>Main</span>
					</a>
				</li>
				<li class="sub-menu">
					<a href="javascript:;"> 
						<i class="li_trash"></i><span>Raspberrypi</span>
            	 		</a>
                  	<ul class="sub">
                     	<li><a href="<c:url value='/raspberrypi/RegisterForm.do'/>">Register</a></li>
                     	<li><a href="<c:url value='/raspberrypi/Management.do'/>">Management</a></li>
                  	</ul>
                 	</li>
              		<li class="sub-menu">
              			<a href="javascript:;"> 
              				<i class="li_user"></i><span>Cleaner</span>
              			</a>
	                <ul class="sub">
	                	<li><a href="<c:url value='/cleaner/cleanerLicenseList.do'/>">Approve</a></li>
	                    <li><a href="<c:url value='/cleaner/cleanerList.do'/>">Management</a></li>
	                </ul>
	            </li>
                <li class="sub-menu">
                	<a href="javascript:;"> 
                		<i class="li_key"></i><span>Mapping</span>
               		</a>
                  	<ul class="sub">
                    	<li><a href="<c:url value='/mapping/'/>">Mapping</a></li>
                     	<li><a href="<c:url value='/mapping/mappingList'/>">Management</a></li>
                  	</ul>
                </li>
               	<li class="sub-menu">
               		<a href="javascript:;"> 
               			<i class="li_data"></i><span>Statistics</span>
               		</a>
                  	<ul class="sub">
                    	<li><a href="<c:url value='/statistics/statisticsLive.do'/>">Live</a></li>
                     	<li><a href="<c:url value='/statistics/statisticsDay.do'/>">Daily</a></li>
                     	<li><a href="<c:url value='/statistics/statisticsMonth.do'/>">Monthly</a></li>
                  	</ul>
                </li>
        	</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->
</body>
</html>