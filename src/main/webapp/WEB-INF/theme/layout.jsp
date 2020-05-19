<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <!-- Khai báo thư viện sử dụng tiles để thiết kế giao diện-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- Khai báo trust. Mình Tự thêm -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khóa Học Trực Tuyến</title>
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
<!-- Khai báo sử dụng header -->
	<tiles:insertAttribute name="header" />
	
<!-- Khai báo sử dụng body -->
	<tiles:insertAttribute name="body" />
	 
<!-- Khai báo sử dụng footer-->
	<tiles:insertAttribute name="footer" />
	
	<div class="back_to_Top">
		<i class="fa fa-arrow-up" aria-hidden="true"></i>
</body>
</html>