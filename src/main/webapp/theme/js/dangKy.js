$(document)
		.ready(
				function() {
					// kiem tra
					$("#submit")
							.on(
									"click",
									function() {
										var hoTen = document.forms["myForm"]["objDangKy.hoTen"].value;
										var taiKhoan = document.forms["myForm"]["objDangKy.taiKhoan"].value;
										var matKhau = document.forms["myForm"]["objDangKy.matKhau"].value;
										var dienThoai = document.forms["myForm"]["objDangKy.dienThoai"].value;
										var email = document.forms["myForm"]["objDangKy.email"].value;
										if (hoTen == "") {
											$("#warning5").html(
													"*Bạn cần nhập họ tên!");
										}
										if (taiKhoan == "") {
											$("#warning4").html(
													"*Bạn cần nhập tài khoản!");
										}
										if (matKhau == "") {
											$("#warning3").html(
													"*Bạn cần nhập mật khẩu!");
										}
										if (dienThoai == "") {
											$("#warning2")
													.html(
															"*Bạn cần nhập số điện thoại!");
										}
										if (email == "") {
											$("#warning1")
													.html(
															"*Bạn cần nhập thông tin email!");
										}
									});

					$("#hoTen").on("keyup", function() {
						var hoTen = $("#hoTen").val();
						if (hoTen.length < 1) {
							$("#warning5").html(" *Bạn cần nhập họ tên!");
						} else {
							$("#warning5").html("");
						}
					});
					$("#taiKhoan").on("keyup", function() {
						var taiKhoan = $("#taiKhoan").val();
						if (taiKhoan.length < 1) {
							$("#warning4").html(" *Bạn cần nhập tài khoản!");
						} else {
							$("#warning4").html("");
						}
					});
					$("#matKhau").on("keyup", function() {
						var matKhau = $("#matKhau").val();
						if (matKhau.length < 1) {
							$("#warning3").html(" *Bạn cần nhập mật khẩu!");
						} else {
							$("#warning3").html("");
						}
					});
					$("#dienThoai").on(
							"keyup",
							function() {
								var dienThoai = $("#dienThoai").val();
								if (dienThoai.length < 1) {
									$("#warning2").html(
											" *Bạn cần nhập số điện thoại!");
								} else {
									$("#warning2").html("");
								}
							});
					$("#email").on(
							"keyup",
							function() {
								var email = $("#email").val();
								if (email.length < 1) {
									$("#warning1").html(
											" *Bạn cần nhập thông tin email!");
								} else {
									$("#warning1").html("");
								}
							});

					// dinh dang email
					$("#email")
							.on(
									"keyup",
									function() {
										var email = $("#email").val();
										var regular = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
										if (!regular.test(email)) {
											$("#warning1")
													.html(
															"*chưa đúng định dạnh email(vd: abc@gmail.com)");
										} else {
											$("#warning1").html("");
										}
									});
					// dinh dang phone
					$("#phone")
							.on(
									"keyup",
									function() {
										var phone = $("#phone").val();
										var regex = /^[0-9]+$/;
										if (!phone.match(regex)
												|| phone.length > 11
												|| phone.length < 10) {
											$("#warning2")
													.html(
															"*chưa đúng định dạnh phonenumber(vd: 123456..)");
										} else {
											$("#warning2").html("");
										}
									});
				});