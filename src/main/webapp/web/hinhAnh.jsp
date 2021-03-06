<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hình ảnh khóa học</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="theme/js/bootstrap.js"></script>
<script type="text/javascript" src="theme/js/wow.min.js"></script>
<link rel="stylesheet" href="theme/css/animate.css">
<link rel="stylesheet" type="text/css" href="theme/css/bootstrap.css">
<link rel="stylesheet" href="theme/css/hinhAnh.css">
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
		//gallery
		$(".filter-button").click(function() {
			var value = $(this).attr('data-filter');
			if ($(".filter-button").removeClass("active")) {
				$(this).removeClass("active");
			}
			$(this).addClass("active");

			if (value == "all") {
				//$('.filter').removeClass('hidden');
				$('.filter').show("1000");
			} else {
				$(".filter").not('.' + value).hide("4000");
				$('.filter').filter('.' + value).show("4000");

			}
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
		<a id="abu" href="hinhAnh.html">Hình Ảnh</a>
	</div>
	<div class="container main">
		<div class="row">
			<div id="intro" class="col-lg-12 wow lightSpeedIn">They’re
				treated like heroes and tasked with the duty of saving the human
				race from utter extinction.</div>
		</div>
	</div>
	<div class="container space-top-bot">
		<div class="row">
			<div class="col-md-12">
				<button type="button"
					class="btn btn-default filter-button wow rotateInDownLeft"
					data-wow-duration="1s" data-filter="all">All WORK</button>
				&nbsp;
				<button type="button"
					class="btn btn-default filter-button wow rotateInDownLeft"
					data-wow-duration="2s" data-filter="creative">CREATIVE</button>
				&nbsp;
				<button type="button"
					class="btn btn-default filter-button wow rotateInDownRight"
					data-wow-duration="2s" data-filter="photography">PHOTOGRAPHY</button>
				&nbsp;
				<button type="button"
					class="btn btn-default filter-button wow rotateInDownRight"
					data-wow-duration="1s" data-filter="web">WEB DEVELOPMENT</button>
			</div>
		</div>
	</div>
	<div class="container cachbot">
		<div class="row">
			<div class="col-md-3 filter creative">
				<div class="thumbnail">
					<img class="wow bounceInLeft" data-wow-duration="4s"
						src="theme/images/item1.png" alt="Lights">
					<div class="caption wow bounceInLeft" data-wow-duration="4.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter photography">
				<div class="thumbnail">
					<img class="wow bounceInLeft" data-wow-duration="3s"
						src="theme/images/item2.png" alt="Lights">
					<div class="caption wow bounceInLeft" data-wow-duration="3.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter creative">
				<div class="thumbnail">
					<img class="wow bounceInLeft" data-wow-duration="2s"
						src="theme/images/item3.png" alt="Lights">
					<div class="caption wow bounceInLeft" data-wow-duration="2.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter web">
				<div class="thumbnail">
					<img class="wow bounceInLeft" data-wow-duration="1s"
						src="theme/images/item4.png" alt="Lights">
					<div class="caption wow bounceInLeft" data-wow-duration="1.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter photography">
				<div class="thumbnail">
					<img class="wow bounceInRight" data-wow-duration="1s"
						src="theme/images/item5.png" alt="Lights">
					<div class="caption wow bounceInRight" data-wow-duration="1.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter creative">
				<div class="thumbnail">
					<img class="wow bounceInRight" data-wow-duration="2s"
						src="theme/images/item6.png" alt="Lights">
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter web">
				<div class="thumbnail">
					<img class="wow bounceInRight" data-wow-duration="3s"
						src="theme/images/item7.png" alt="Lights">
					<div class="caption wow bounceInRight" data-wow-duration="3.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
				</div>
			</div>
			<div class="col-md-3 filter photography">
				<div class="thumbnail">
					<img class="wow bounceInRight" data-wow-duration="4s"
						src="theme/images/item8.png" alt="Lights">
					<div class="caption wow bounceInRight" data-wow-duration="4.5s">
						<a href="#" target="#"><h5>Business Theme</h5></a>
						<p>They’re treated like heroes and tasked with the duty of
							saving the human race from utter extinction.</p>
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>
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
</body>
</html>