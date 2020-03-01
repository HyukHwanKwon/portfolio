<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Tasty Burger Restaurants Category Bootstrap Responsive Web Template | Home :: W3layouts</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords"
		content="Tasty Burger Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
		function buy() {
			alert("준비중입니다!!!");
		}
	</script>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/css_slider.css" type="text/css" rel="stylesheet" media="all">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Barlow+Semi+Condensed:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
	<style>
		a {
			color: black;
		}
		p {
			font-family: 'Do Hyeon', sans-serif;
			color: black;
		}
		table {
			width: 1000px;
			height: 100px;
			table-layout: fixed;
			text-align: center;
		}
	</style>
</head>
<body style="font-family: 'Do Hyeon', sans-serif;">
	<c:if test="${id == null}">
			${sessionScope.id.memberId}	
		<form action="memberLogIn.mem" method="post" style="text-align: right">
			<span>아이디:<input type="text" id="id" name="id" style="height: 20px;"></span>
			<span>패스워드:<input type="password" id="password" name="password" style="height: 20px;"></span>
			<input type="submit" value="로그인" style="background-color:transparent; border:0px transparent solid;" onMouseover="this.style.color='#007bff';" onMouseout="this.style.color='black';">
			<a href="join.jsp">회원가입</a>
		</form>
	</c:if>
	<div style="text-align: right">
		<c:if test="${id != null}">
			<span>${id}님환영합니다</span>
			<span><a href="memberLogOut.mem">로그아웃</a></span>
			<c:set value="${id}" var="id"></c:set>
			<a href="memberInfo.mem">내정보</a> 
			<a href="cartList.cart?id=${id}">장바구니</a>
		</c:if>
	</div>
	<!-- header -->
	<header id="home">
		<!-- top-bar -->
		<div class="top-bar py-2 border-bottom">
			<div class="container">
				<div class="row middle-flex">
					<div class="col-xl-7 col-md-5 top-social-agile mb-md-0 mb-1 text-lg-left text-center">
						<div class="row">
							<div class="col-xl-3 col-6 header-top_w3layouts">
								<p class="text-da">
									<span class="fa fa-map-marker mr-2"></span>Gyeonggi Osan
								</p>
							</div>
							<div class="col-xl-3 col-6 header-top_w3layouts">
								<p class="text-da">
									<span class="fa fa-phone mr-2"></span>+01050141180
								</p>
							</div>
							<div class="col-xl-6"></div>
						</div>
					</div>
					<div class="col-xl-5 col-md-7 top-social-agile text-md-right text-center pr-sm-0 mt-md-0 mt-2">
						<div class="row middle-flex">
							<div class="col-lg-5 col-4 top-w3layouts p-md-0 text-right">
							</div>
							<div class="col-lg-7 col-8 social-grid-w3">
								<!-- social icons -->
								<ul class="top-right-info">
									<li>
										<p>Follow Us:</p>
									</li>
									<li class="facebook-w3">
										<a href="#">
											<span class="fa fa-facebook-f"></span>
										</a>
									</li>
									<li class="twitter-w3">
										<a href="#">
											<span class="fa fa-twitter"></span>
										</a>
									</li>
									<li class="google-w3">
										<a href="#">
											<span class="fa fa-google-plus"></span>
										</a>
									</li>
									<li class="dribble-w3">
										<a href="#">
											<span class="fa fa-dribbble"></span>
										</a>
									</li>
								</ul>
								<!-- //social icons -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- //top-bar -->
	<!-- header 2 -->
	<!-- navigation -->
	<div class="main-top py-1">
		<div class="container">
			<div class="nav-content">
				<!-- logo -->
				<h1>
					<a id="logo" class="logo" href="main.jsp">
						<img src="images/logo.png" alt="" class="img-fluid"><span>Tasty</span> Burger
					</a>
				</h1>
				<!-- //logo -->
				<!-- nav -->
				<div class="nav_web-dealingsls">
					<nav>
						<label for="drop" class="toggle">Menu</label>
						<input type="checkbox" id="drop" />
						<ul class="menu">
							<li><a href="main.jsp">Home</a></li>
							<li><a href="itemList.item">메뉴</a></li>
							<li><a href="boardList.bo">리뷰</a></li>
						</ul>
					</nav>
				</div>
				<!-- //nav -->
			</div>
		</div>
	</div>
	<center>
		<h2 style="font-family: 'Do Hyeon', sans-serif;">리뷰</h2>
		<br/>
		<table border="1">
			<c:forEach var="boardList" items="${boardList}">
				<tr>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
				<tr>
					<td><a href="boardDetail.bo?num=${boardList.boardNum}">${boardList.boardId}</a></td>
					<td><a href="boardDetail.bo?num=${boardList.boardNum}">${boardList.boardTitle}</a></td>
					<td><a href="boardDetail.bo?num=${boardList.boardNum}">${boardList.regDate}</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<a href="boardInsertForm.bo">글쓰기</a>
	</center>
	</br>
	</br>
	</br>
	<div class="cpy-right text-center py-3">
		<p style="color: #999;">© 2019 Tasty Burger. All rights reserved | Design by
			<a href="http://w3layouts.com"> W3layouts.</a>
		</p>
	</div>
	<a href="#home" class="move-top text-center">
		<span class="fa fa-level-up" aria-hidden="true"></span>
	</a>
</body>
</html>