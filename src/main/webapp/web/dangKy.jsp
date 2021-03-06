<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Ký Khóa Học</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="theme/js/bootstrap.js"></script>
<script type="text/javascript" src="theme/js/wow.min.js"></script>
<script type="text/javascript" src="theme/js/dangKy.js"></script>
<link rel="stylesheet" href="theme/css/animate.css">
<link rel="stylesheet" type="text/css" href="theme/css/bootstrap.css">
<link rel="stylesheet" href="theme/css/dangKy.css">
</head>
<script>
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 500) { // If page is scrolled more than 50px
				$('.back_to_Top').fadeIn(); // Fade in the arrow
			} else {
				$('.back_to_Top').fadeOut(); // Else fade out the arrow
			}
		});
		$('.back_to_Top').click(function() { // When arrow is clicked
			$('body,html').animate({
				scrollTop : 0
			// Scroll to top of body
			}, 500);
		});
		new WOW().init();
	});
</script>
<body>
<!-- Start Header -->
	<div class="row p-0">
		<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
			<h1>
				<a class="navbar-brand" href="trangChu.html"><font
					color="#1BBD36;">TCT</font><span id="ahihi">ONLINE</span></a>
			</h1>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link active-link"
						href="trangChu.html">Trang Chủ</a></li>
					<li class="nav-item"><div class="dropdown">
							<button class="dropbtn">Chủ Đề</button>
							<div class="dropdown-content">
								<a href="#">Chủ đề 1</a> <a href="#">Chủ đề 2</a> <a href="#">Chủ
									đề 3</a> <a href="#">Chủ đề 4</a> <a href="#">Chủ đề 5</a> <a
									href="#">Chủ đề 6</a> <a href="#">Chủ đề 7</a>
							</div>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="service.html">Liên
							Hệ</a></li>
					<li class="nav-item"><a class="nav-link" href="hinhAnh.html">Hình
							Ảnh</a></li>
					<li class="nav-item"><a class="nav-link" href="dangKy.html">Đăng
							Ký</a></li>
					<li class="nav-item"><a class="nav-link" href="dangNhap.html">Đăng
							Nhập</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- End Header -->
	<div class="container-fluid sm">
		<a id="home" href="home.html">Trang Chủ</a>
		<p id="x">&nbsp;/&nbsp;</p>
		<a id="abu" href="dangKy.html">Đăng Ký</a>
	</div>
	<div>
		<div class="container">
			<div class="text-intro">
				<h2 class=" wow bounceInLeft">Contact Us</h2>
				<p class=" wow bounceInRight">Swing by for a cup of coffee, or
					leave us a message</p>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-12">
					<form>
						<p class="size wow bounceInRight">Name*</p>
						<span id="warning"></span> <input id="name"
							class="form-control wow bounceInRight" type="text" name=""
							value="" placeholder="Your Name..." class="input">
						<p class="size wow bounceInRight" data-wow-duration="2s">Email*</p>
						<span id="warning1"></span> <input id="email"
							class="form-control wow bounceInRight" data-wow-duration="2s"
							type="text" name="" value="" placeholder="Your Email..."
							class="input">
						<p class="size wow bounceInRight" data-wow-duration="3s">Phone*</p>
						<span id="warning2"></span> <input id="phone"
							class="form-control wow bounceInRight" data-wow-duration="3s"
							type="Number" name="" value="" placeholder="Your Phone..."
							class="input">
						<p class="size wow bounceInRight" data-wow-duration="4s">Company
							Name*</p>
						<span id="warning3"></span> <input id="namecompany"
							class="form-control wow bounceInRight" data-wow-duration="4s"
							type="text" name="" value="" placeholder="Your Company..."
							class="input">
					</form>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-12">
					<form>
						<p class="size wow bounceInLeft">Subject*</p>
						<span id="warning4"></span> <input id="subject"
							class="form-control wow bounceInLeft" type="text" name=""
							value="" placeholder="Your Subject..." class="input">
						<p class="size wow bounceInLeft" data-wow-duration="2s">Message*</p>
						<span id="warning5"></span>
						<textarea id="message" class="form-control wow bounceInLeft"
							data-wow-duration="2s" name="#" placeholder="Write something.."></textarea>
						<input class=" wow bounceInLeft" data-wow-duration="3s"
							type="button" name="#" value="Submit" id="submit">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--Start Footer-->
	<div class="container-fluid">
		<div class="row p-0 bg-footer">
			<div class="col-lg-7 col-md-7 col-sm-6 col-12 bg-footer">
				<div class="col-lg-12  col-md-12 col-sm-12 col-12 footer">
					<i class="fa fa-facebook col-md-2 col-sm-2 col-2 fb"
						aria-hidden="true"></i> <i
						class="fa fa-twitter col-md-2 col-sm-2 col-2 tt"
						aria-hidden="true"></i> <i
						class="fa fa-google-plus col-md-2 col-sm-2 col-2 gp"
						aria-hidden="true"></i> <i
						class="fa fa-linkedin col-md-2 col-sm-2 col-2 li"
						aria-hidden="true"></i> <i
						class="fa fa-youtube-play col-md-2 col-sm-2 col-2 yt"
						aria-hidden="true"></i>
				</div>
			</div>
			<div class="col-lg-5 col-md-5 col-sm-6 col-12 bg-footer">
				<div class="col-lg-12  col-md-12 col-sm-12 col-12 footer">
					<p class="cop">
						© July 2020 by <span id="tk">TCTGroups</span>.All Right Reaerved.
					</p>
				</div>
			</div>
		</div>
	</div>
	<!--End Footer-->	
	</div>
	<div class="back_to_Top">
		<i class="fa fa-arrow-up" aria-hidden="true"></i>
	</div>
</body>
</html>