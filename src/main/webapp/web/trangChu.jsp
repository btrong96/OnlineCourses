<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="theme/js/bootstrap.js"></script>
<script type="text/javascript" src="theme/js/wow.min.js"></script>
<link rel="stylesheet" href="theme/css/animate.css">
<link rel="stylesheet" type="text/css" href="theme/css/bootstrap.css">
<link rel="stylesheet" href="theme/css/trangChu.css">
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
	<div class="container-fluid bn">
		<div class="jumbotron">
			<h1 class="display-4 wow bounceInDown" data-wow-duration="1s">WELLCOME&nbsp;</h1>
			<h1 id="cpn" class="wow bounceInDown" data-wow-duration="2s">TCT-ONLINE</h1>
			<p class="lead wow bounceInDown" data-wow-duration="3s">This is a
				simple hero unit, a simple jumbotron-style component for calling
				extra attention to featured content or information.</p>
			<a class="btn btn-primary btn-lg wow bounceInDown" href="#"
				role="button" data-wow-duration="4s">Learn more</a>
		</div>
		<img class="wow bounceInDown" src="theme/images/img3.png" alt=""
			data-wow-duration="5s">
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xl-3 col-lg-3 col-md-6 wow bounceInLeft">
				<div class="icon">
					<span><i class="fa fa-book" aria-hidden="true"></i></span>
				</div>
				<h5>English</h5>
				<p>Debitis nobis, corrupti tenetur aliquam error doloribus
					praesentium facilis delectus autem temporibus iusto.</p>
			</div>
			<div class="col-xl-3 col-lg-3 col-md-6 wow bounceInDown">
				<div class="icon">
					<span><i class="fa fa-laptop" aria-hidden="true"></i></span>
				</div>
				<h5>IT</h5>
				<p>Debitis nobis, corrupti tenetur aliquam error doloribus
					praesentium facilis delectus autem temporibus iusto.</p>
			</div>
			<div class="col-xl-3 col-lg-3 col-md-6 wow bounceInUp">
				<div class="icon">
					<span><i class="fa fa-heart-o" aria-hidden="true"></i></span>
				</div>
				<h5>GYM & YOGA</h5>
				<p>Debitis nobis, corrupti tenetur aliquam error doloribus
					praesentium facilis delectus autem temporibus iusto.</p>
			</div>
			<div class="col-lg-3 col-md-6 wow bounceInRight">
				<div class="icon">
					<span><i class="fa fa-cloud" aria-hidden="true"></i></span>
				</div>
				<h5>Bla Bla...</h5>
				<p>Debitis nobis, corrupti tenetur aliquam error doloribus
					praesentium facilis delectus autem temporibus iusto.</p>
			</div>
		</div>
	</div>
	<div class="container-fluid abu">
		<div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<div class="nd">
						<h4 class="wow shake">About Us</h4>
						<img class="wow bounceInLeft" src="theme/images/6.jpg" alt="">
						<p class="wow flipInX">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Numquam, eligendi, veritatis libero distinctio
							tenetur nesciunt earum provident corrupti sint debitis soluta sit
							animi. Corporis blanditiis vero nam nesciunt quos in.</p>
					</div>
				</div>
				<div class="col-lg-6 col-md-12">
					<div class="nd">
						<h4 class=" wow shake">Template built with Twitter Bootstrap</h4>
						<p class="wow flipInX" data-wow-duration="1s">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit. Ea autem, facilis
							quasi eos temporibus voluptates corrupti eligendi, aperiam
							eveniet, odio perspiciatis! Aliquam officia, incidunt sint
							voluptatibus cum dolorum! Aspernatur, aliquam.</p>
						<p class="wow flipInX" data-wow-duration="1.5s">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit. Ea autem, facilis
							quasi eos temporibus voluptates corrupti eligendi, aperiam
							eveniet, odio perspiciatis! Aliquam officia, incidunt sint
							voluptatibus cum dolorum! Aspernatur, aliquam.</p>
						<p class=" wow flipInX" data-wow-duration="2s">Lorem ipsum
							dolor sit amet, consectetur adipisicing elit. Ea autem, facilis
							quasi eos temporibus voluptates corrupti eligendi, aperiam
							eveniet, odio perspiciatis! Aliquam officia, incidunt sint
							voluptatibus cum dolorum! Aspernatur, aliquam.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div id="tit" class="row">
			<h4>LATES NEWS</h4>
		</div>
		<div class="row">
			<div class="card-group">
				<div class="card col-md-12">
					<img class="card-img-top wow bounceInDown img-fluid"
						src="theme/images/4.jpg" alt="Card image cap" data-wow-duration="1s">
					<div class="card-body">
						<h5 class="card-title wow shake">Template built with Twitter
							Bootstrap</h5>
						<p class="card-text wow flipInX" data-wow-duration="2s">This
							is a wider card with supporting text below as a natural lead-in
							to additional content. This content is a little bit longer.</p>
					</div>
				</div>
				<div class="card col-md-12">
					<img class="card-img-top wow bounceInDown img-fluid"
						src="theme/images/4.jpg" alt="Card image cap" data-wow-duration="2s">
					<div class="card-body">
						<h5 class="card-title wow shake">Template built with Twitter
							Bootstrap</h5>
						<p class="card-text wow flipInX" data-wow-duration="2s">This
							card has supporting text below as a natural lead-in to additional
							content.</p>
					</div>
				</div>
				<div class="card col-md-12">
					<img class="card-img-top wow bounceInDown img-fluid"
						src="theme/images/4.jpg" alt="Card image cap" data-wow-duration="3s">
					<div class="card-body">
						<h5 class="card-title wow shake">Template built with Twitter
							Bootstrap</h5>
						<p class="card-text wow flipInX" data-wow-duration="2s">This
							is a wider card with supporting text below as a natural lead-in
							to additional content. This card has even longer content than the
							first to show that equal height action.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bn2">
		<div class="container nd2">
			<div class="row">
				<h3 class=" wow shake">Our Partner</h3>
			</div>
			<div class="row">
				<p class="wow bounceInRight">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit. Impedit molestias dolorem reiciendis
					deserunt corrupti voluptatibus, maiores modi, sed asperiores quis
					culpa assumenda eius cupiditate libero ex aliquid reprehenderit
					earum aliquam.</p>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner1.png"
						alt="" data-wow-duration="1s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner2.png"
						alt="" data-wow-duration="2s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner3.png"
						alt="" data-wow-duration="3s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner4.png"
						alt="" data-wow-duration="4s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner5.png"
						alt="" data-wow-duration="5s">
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row ftid">
			<div class="col-lg-1 col-md-1 icon2 wow bounceInRight">
				<span><i class="fa fa-phone-square" aria-hidden="true"></i></span>
			</div>
			<div class="col-lg-8 col-md-8 ndftid">
				<h4 class=" wow bounceInLeft" data-wow-duration="1s">Have a
					question or need a custom quote?</h4>
				<p class=" wow bounceInLeft" data-wow-duration="2s">Lorem ipsum
					dolor sit amet, consectetur adipisicing elit. Impedit dolor
					voluptatibus, quaerat nostrum ipsa excepturi. Delectus iste
					quibusdam, ex, nulla sed, mollitia quis dolorem voluptatem omnis
					eligendi numquam facere eum?</p>
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