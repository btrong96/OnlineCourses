<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Khai báo trust  -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/styles/metro/notify-metro.css" />
<script type="text/javascript">
	$(document).ready(
			function() {
				//Gọi form thêm mới
				$("#submit").click(
						function() {
							var today = new Date();
							var date = today.getDate() + '/'
									+ (today.getMonth() + 1) + '/'
									+ today.getFullYear();
							$("#txtNgayTao").val(date);
						});
			});

	function validateForm() {
		var hoTen = document.forms["myForm"]["objDangKy.hoTen"].value;
		var taiKhoan = document.forms["myForm"]["objDangKy.taiKhoan"].value;
		var matKhau = document.forms["myForm"]["objDangKy.matKhau"].value;
		var dienThoai = document.forms["myForm"]["objDangKy.dienThoai"].value;
		var email = document.forms["myForm"]["objDangKy.email"].value;

		if (hoTen == "" || hoTen == null) {
			//alert("Bạn cần nhập họ tên");
			return false;
		} else if (taiKhoan == "" || taiKhoan == null) {
			//alert("Bạn cần nhập tài khoản");
			return false;
		} else if (matKhau == "" || matKhau == null) {
			//alert("Bạn cần nhập mật khẩu");
			return false;
		} else if (dienThoai == "" || dienThoai == null) {
			//alert("Bạn cần nhập điện thoại");
			return false;
		} else if (email == "" || email == null) {
			//alert("Bạn cần nhập email");
			return false;
		}else {
			alert("Tài Khoản của bạn cần được phê duyệt");
			return true;
		}
	}
</script>

<head>
<meta charset="UTF-8">
<title>Đăng Ký</title>

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
<body>
	<div class="container-fluid sm">
		<a id="home" href="home.html">Trang Chủ</a>
		<p id="x">&nbsp;/&nbsp;</p>
		<a id="abu" href="dangKy.html">Đăng Ký</a>
	</div>
	<div>
		<div class="container">
			<div class="text-intro">
				<h2 class=" wow bounceInLeft">Đăng Ký Tài Khoản</h2>
				<p class=" wow bounceInRight">Điền thông tin cá nhân để liên hệ
					với chúng tôi</p>

			</div>
			<div class="row">
				<div class="col-lg-9 col-md-9 col-sm-12 col-12">
					<s:form action="dangKyTaiKhoan" method="POST"
						enctype="multipart/form-data" onsubmit="return validateForm()"
						name="myForm" theme="simple">
							
						<form>
							<p class="size wow bounceInRight">Họ Tên*</p>
							<s:textfield id="hoTen" class="form-control wow bounceInRight"
								name="objDangKy.hoTen" value="%{objDangKy.hoTen}"
								placeholder="Your Name..." />
							<span id="warning5"></span>


							<p class="size wow bounceInRight">Tài Khoản*</p>

							<s:textfield id="taiKhoan" class="form-control wow bounceInRight"
								name="objDangKy.taiKhoan" value="%{objDangKy.taiKhoan}"
								placeholder="Your UserName..." />
							<span id="warning4"></span>

                             <s:actionerror />

							<p class="size wow bounceInRight">Mật Khẩu*</p>

							<s:textfield type="password" id="matKhau"
								class="form-control wow bounceInRight" name="objDangKy.matKhau"
								value="%{objDangKy.matKhau}" placeholder="Your PassWord..." />
							<span id="warning3"></span>


							<p class="size wow bounceInRight" data-wow-duration="2s">Điện
								Thoại*</p>

							<s:textfield id="phone" class="form-control wow bounceInRight"
								name="objDangKy.dienThoai" value="%{objDangKy.dienThoai}"
								data-wow-duration="2s" placeholder="Your Phone..." />
							<span id="warning2"></span>


							<p class="size wow bounceInRight" data-wow-duration="3s">Email*</p>

							<s:textfield id="email" class="form-control wow bounceInRight"
								name="objDangKy.email" value="%{objDangKy.email}"
								data-wow-duration="3s" placeholder="Your Email..." />
							<span id="warning1"></span>


							<s:hidden name="objDangKy.ngayTao" id="txtNgayTao"
								readonly="readonly" value="%{objDangKy.ngayTao}"
								cssClass="form-control" />


							<div class="title-footer" align="center">
								<s:submit value="Đăng Ký" cssClass="btn btn-primary" id="submit" />
								&nbsp;
								
							</div>

						</form>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>