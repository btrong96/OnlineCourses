<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="theme/js/bootstrap.js"></script>
<script type="text/javascript" src="theme/js/wow.min.js"></script>
<link rel="stylesheet" href="theme/css/animate.css">
<link rel="stylesheet" type="text/css" href="theme/css/bootstrap.css">
<link rel="stylesheet" href="theme/css/aboutUs.css">
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
					<li class="nav-item"><a class="nav-link" href="aboutUs.html">Liên
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
		<a id="abu" href="aboutUs.html">Liên Hệ</a>
	</div>
	<div class="container main">
		<div class="main">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d207443.7928296813!2d139.6012931446453!3d35.66938631109813!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188b857628235d%3A0xcdd8aef709a2b520!2zVG9reW8sIE5o4bqtdCBC4bqjbg!5e0!3m2!1svi!2s!4v1532868053572"
				width="100%" height="450" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
		<h3 class="wow bounceInRight">Thông Tin</h3>
		<hr>
		<div class="row">
			<div class="col-md-6 wow bounceIn">
				<img src="theme/images/4.jpg" class="img">
				<p class="text-under-img">Seventeen-year-old Hajime Nagumo is
					your average, everyday otaku. However, his simple life of pulling
					all-nighters and sleeping in school is suddenly turned upside down
					when he, along with the rest of his class, is summoned to a fantasy
					world!</p>
			</div>
			<div class="col-md-6 wow bounceInUp" data-wow-duration="2s">
				<div class="content">
					<ul>
						<li>
							<div class="icon">
								<i class="fa fa-pencil"></i>
							</div>
							<div class="text-content">
								<h4 class="text-head">Chuyên Gia Giàu Kinh Nghiệm</h4>
								<p>They’re treated like heroes and tasked with the duty of
									saving the human race from utter extinction.</p>
							</div>
						</li>
						<li>
							<div class="icon">
								<i class="fa fa-book"></i>
							</div>
							<div class="text-content">
								<h4 class="text-head">Giáo Trình Luôn Cập Nhật</h4>
								<p>They’re treated like heroes and tasked with the duty of
									saving the human race from utter extinction.</p>
							</div>
						</li>
						<li>
							<div class="icon">
								<i class="fa fa-rocket"></i>
							</div>
							<div class="text-content">
								<h4 class="text-head">Học Đi Đôi Thực Hành</h4>
								<p>They’re treated like heroes and tasked with the duty of
									saving the human race from utter extinction.</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="services">
		<div class="container">
			<div class="row">
				<div class="col-md-6 wow bounceInUp">
					<div class="content">
						<ul>
							<li>
								<div class="icon">
									<i class="fa fa-pencil"></i>
								</div>
								<div class="text-content">
									<h4 class="text-head">Kỹ Năng Thực Tế</h4>
									<p>They’re treated like heroes and tasked with the duty of
										saving the human race from utter extinction.</p>
								</div>
							</li>
							<li>
								<div class="icon">
									<i class="fa fa-book"></i>
								</div>
								<div class="text-content">
									<h4 class="text-head">Chứng Chỉ Đạt Chuẩn Quốc Tế</h4>
									<p>They’re treated like heroes and tasked with the duty of
										saving the human race from utter extinction.</p>
								</div>
							</li>
							<li>
								<div class="icon">
									<i class="fa fa-rocket"></i>
								</div>
								<div class="text-content">
									<h4 class="text-head">Đảm Bảo Việc Làm</h4>
									<p>They’re treated like heroes and tasked with the duty of
										saving the human race from utter extinction.</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="col-md-6 wow bounceIn" data-wow-duration="2s">
					<img src="theme/images/4.jpg" class="img">
					<p class="text-under-img">Seventeen-year-old Hajime Nagumo is
						your average, everyday otaku. However, his simple life of pulling
						all-nighters and sleeping in school is suddenly turned upside down
						when he, along with the rest of his class, is summoned to a
						fantasy world!</p>
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
	<div class="back_to_Top">
		<i class="fa fa-arrow-up" aria-hidden="true"></i>
	</div>
</body>
</html>