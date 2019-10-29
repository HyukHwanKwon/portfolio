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

   <title>Login</title>

   <!-- Bootstrap core CSS -->
   <link rel="stylesheet" href="<c:url value="/resources/assets/css/bootstrap.css"/>">
   <!--external css-->
   <link rel="stylesheet" href="<c:url value="/resources/assets/font-awesome/css/font-awesome.css" />">
       
   <!-- Custom styles for this template -->
   <link rel="stylesheet" href="<c:url value="/resources/assets/css/style.css" />">
   <link rel="stylesheet" href="<c:url value="/resources/assets/css/style-responsive.css" />">

   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->
 </head>
 <body>
	<c:choose>
		<c:when test="${admin == null}">
		 	<div id="login-page">
		  		<div class="container">
		      		<form class="form-login" action="/adminLogin.do" method="post">
		        		<h2 class="form-login-heading">sign in now</h2>
		        		<div class="login-wrap">
			            	<input type="text" class="form-control" name="adminId" id="adminId" placeholder="User ID" autofocus>
			            	<br>
			            	<input type="password" class="form-control" name="adminPassword" id="adminPassword" placeholder="Password">
			            	<label class="checkbox">
			                	<span class="pull-right"></span>
		            		</label>
		            		<button class="btn btn-theme btn-block" type="submit" ><i class="fa fa-lock"></i>SIGN IN</button>
		            		<hr>
		            		<div class="login-social-link centered">
		            		</div>
		        		</div>
			           	<!-- Modal -->
			          	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              		<div class="modal-dialog">
		                  		<div class="modal-content">
		                      		<div class="modal-header">
		                          		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          		<h4 class="modal-title">Forgot Password ?</h4>
		                      		</div>
		                      		<div class="modal-body">
		                          		<p>Enter your e-mail address below to reset your password.</p>
		                          		<input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		                      		</div>
		                      		<div class="modal-footer">
		                          		<button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          		<button class="btn btn-theme" type="button">Submit</button>
		                      		</div>
		                  		</div>
		              		</div>
		          		</div>
		          		<!-- modal -->
		      		</form>	  	
	  			</div>
	  		</div>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				window.location.href="<c:url value='/main/main.do'/>"	
			</script>
		</c:otherwise>
	</c:choose>
	
	<!-- js placed at the end of the document so the pages load faster -->
    <script src="<c:url value='/resources/assets/js/jquery.js'/>"></script>
    <script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>
    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="<c:url value='/resources/assets/js/jquery.backstretch.min.js'/>"></script>
    <script>
        $.backstretch("resources/assets/img/login-bg.jpg", {speed: 500});
    </script>
 </body>
</html>
