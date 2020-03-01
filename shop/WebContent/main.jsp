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
	<!-- //navigation -->
	<!-- //header 2 -->
	<!-- banner -->
	<div class="baneer-w3ls">
		<div class="row no-gutters">
			<div class="col-xl-5 col-lg-6">
				<div class="banner-left-w3">
					<div class="container">
						<div class="banner-info_agile_w3ls">
							<h5>맛있는 햄버거</h5>
							<h3 class="text-da mb-4">핫치킨 <span>그릴버거</span> </h3>
							<p>참깨빵 위에 순쇠고기 패티 두 장, 신선한 피클 양상추, 양파까지 한 입에 </p>
							<a href="#" class="button-w3ls active mt-5" onclick="buy()">구매하기
								<span class="fa fa-caret-right ml-1" aria-hidden="true"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-7 col-lg-6 callbacks_container">
				<!-- banner slider -->
				<div class="csslider infinity" id="slider1">
					<input type="radio" name="slides" checked="checked" id="slides_1" />
					<input type="radio" name="slides" id="slides_2" />
					<input type="radio" name="slides" id="slides_3" />
					<ul class="banner_slide_bg">
						<li>
							<div class="banner-top1"></div>
						</li>
						<li>
							<div class="banner-top2"></div>
						</li>
						<li>
							<div class="banner-top3"></div>
						</li>
					</ul>
					<div class="arrows">
						<label for="slides_1"></label>
						<label for="slides_2"></label>
						<label for="slides_3"></label>
					</div>
					<div class="navigation">
						<div>
							<label for="slides_1"></label>
							<label for="slides_2"></label>
							<label for="slides_3"></label>
						</div>
					</div>
				</div>
				<!-- //banner slider -->
			</div>
		</div>
	</div>
	<!-- //banner -->
	<div class="clearfix"></div>
	<!-- about -->
	<div class="about-bottom">
		<div class="row no-gutters">
			<div class="col-lg-5 col-md-6 about">

			</div>
			<div class="col-lg-7 col-md-6 about-right-w3 text-right py-md-5">
				<div class="right-space py-xl-5 py-lg-3">
					<div class="title-section mb-4">
						<p class="w3ls-title-sub">About Us</p>
						<h3 class="w3ls-title">Welcome to <span>Tasty Burger</span></h3>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<!-- //about -->
	<!-- specials -->
	<section class="blog_w3ls py-5">
		<div class="container pb-xl-5 pb-lg-3">
			<div class="title-section text-center mb-md-5 mb-4">
				<p class="w3ls-title-sub">Tasty</p>
				<h3 class="w3ls-title">Our <span>Special</span></h3>
			</div>
			<div class="row">
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="menu.html">
								<img class="card-img-bottom" src="images/blog1.jpg" alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<h5 class="blog-title card-title m-0"><a href="menu.html">French Burger</a></h5>
							<p class="mt-3">Cras ultricies ligula sed magna dictum porta auris blandita.</p>
						
						</div>
					</div>
				</div>
				<!-- //blog grid -->
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6 mt-md-0 mt-5">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="menu.html">
								<img class="card-img-bottom" src="images/blog2.jpg" alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<h5 class="blog-title card-title m-0"><a href="menu.html">Veg Muffin</a></h5>
							<p class="mt-3">Cras ultricies ligula sed magna dictum porta auris blandita.</p>
							
						</div>
					</div>
				</div>
				<!-- //blog grid -->
				<!-- blog grid -->
				<div class="col-lg-4 col-md-6 mt-lg-0 mt-5">
					<div class="card border-0 med-blog">
						<div class="card-header p-0">
							<a href="menu.html">
								<img class="card-img-bottom" src="images/blog3.jpg" alt="Card image cap">
							</a>
						</div>
						<div class="card-body border border-top-0">
							<h5 class="blog-title card-title m-0"><a href="menu.html">Hashbrown Brioche</a></h5>
							<p class="mt-3">Cras ultricies ligula sed magna dictum porta auris blandita.</p>
							
						</div>
					</div>
				</div>
				<!-- //blog grid -->
			</div>
		</div>
	</section>
	<div class="main-top py-1">
		<div class="container">
			<div class="nav-content">
				<!-- logo -->
				<h3>
					<a id="logo" class="logo" href="main.jsp">
						<img src="images/logo.png" alt="" class="img-fluid"><span>Tasty</span> Burger
					</a>
				</h3>
				<!-- //logo -->
			</div>
		</div>
	</div>
	<!-- copyright -->
	<div class="cpy-right text-center py-3">
		<p>© 2019 Tasty Burger. All rights reserved | Design by
			<a href="http://w3layouts.com"> W3layouts.</a>
		</p>
	</div>
	<!-- //copyright -->
	<!-- move top icon -->
	<a href="#home" class="move-top text-center">
		<span class="fa fa-level-up" aria-hidden="true"></span>
	</a>
	<!-- //move top icon -->

</body>
</html>