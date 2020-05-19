<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách người dùng</title>

<s:set var="danhSach_5" value="false" />
<s:set var="them_5" value="false" />
<s:set var="sua_5" value="false" />
<s:set var="xoa_5" value="false" />
<s:set var="baoCao_5" value="false" />

<s:if test='#session.containsKey("danhSach_5")'>
	<s:set var="danhSach_5" value='#session["danhSach_5"]' />
</s:if>
<s:if test='#session.containsKey("them_5")'>
	<s:set var="them_5" value='#session["them_5"]' />
</s:if>
<s:if test='#session.containsKey("sua_5")'>
	<s:set var="sua_5" value='#session["sua_5"]' />
</s:if>
<s:if test='#session.containsKey("xoa_5")'>
	<s:set var="xoa_5" value='#session["xoa_5"]' />
</s:if>


<!-- Khai báo sử dụng JQuery-->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<!-- Khai báo sử dụng JQuery UI -->
<script type="text/javascript" src="js/jquery-ui.js"></script>
<!--  Khai báo sử dụng CSS của JQuery UI -->
<link rel="stylesheet" type="text/css" href="js/jquery-ui.css">

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#txtTaiKhoan").on("keyup", function() {
			var taiKhoan = $("#txtTaiKhoan").val();
			if (taiKhoan.length < 1) {
				$(
				"#warning1")
				.html(
						"*Bạn cần nhập tài khoản");
			} else {
				$("#warning1").html("");
			}
		});
		$("#txtMatKhau").on("keyup", function() {
			var matKhau = $("#txtMatKhau").val();
			if (matKhau.length < 1) {
				$(
				"#warning2")
				.html(
						"*Bạn cần nhập mật khẩu");
			} else {
				$("#warning2").html("");
			}
		});
		$("#txtHoTen").on("keyup", function() {
			var hoTen = $("#txtHoTen").val();
			if (hoTen.length < 1) {
				$(
				"#warning3")
				.html(
						"*Bạn cần nhập họ tên");
			} else {
				$("#warning3").html("");
			}
		});
		$("#txtDienThoai").on("keyup", function() {
			var dienThoai = $("#txtDienThoai").val();
			if (dienThoai.length < 1) {
				$(
				"#warning4")
				.html(
						"*Bạn cần nhập số điện thoại");
			} else {
				$("#warning4").html("");
			}
		});
		$("#txtEmail").on("keyup", function() {
			var email = $("#txtEmail").val();
			if (email.length < 1) {
				$(
				"#warning5")
				.html(
						"*Bạn cần nhập email");
			} else {
				$("#warning5").html("");
			}
		});
		
		// goi form them moi
		$("#btnThemMoi").click(function() {
			$("#formNguoiDung").attr("title", "Thêm mới Người Dùng");
			var today = new Date();
			var date = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();

			// xoa thong tin cu (neu co)
			$("#txtTaiKhoan").val("");
			$("#txtMatKhau").val("");
			$("#txtHoTen").val("");
			$("#txtDienThoai").val("");
			$("#txtEmail").val("");
			$("#txtNgayTao").val(date);
			$("#txtNgayCapNhat").val(date);
			$("#cboVaiTro").val("");

			// hien thi giao dien them moi thong tin
			$("#formNguoiDung").dialog({
				width : 500,
				modal : true,
				buttons : {
					// button them moi
					"Thêm mới" : function() {
						// xu ly thong tin gui len server             
						var taiKhoan = $("#txtTaiKhoan").val();
						var matKhau = $("#txtMatKhau").val();
						var hoTen = $("#txtHoTen").val();
						var dienThoai = $("#txtDienThoai").val();
						var email = $("#txtEmail").val();
						var ngayTao = $("#txtNgayTao").val();
						var ngayCapNhat = $("#txtNgayCapNhat").val();
						var vaitro_id = $("#cboVaiTro").val();					
						var trangThai = $("#chbTrangThai").is(":checked");
						

						if (taiKhoan==null || taiKhoan==""){
							$(
							"#warning1")
							.html(
									"*Bạn cần nhập tài khoản");
					return false;
						}
					        if(matKhau==null || matKhau==""){
					        	$(
								"#warning2")
								.html(
										"*Bạn cần nhập mật khẩu");
						return false;
					        }
							if(hoTen==null || hoTen==""){
								$(
								"#warning3")
								.html(
										"*Bạn cần nhập họ tên");
						return false;
							}
							if(dienThoai==null || dienThoai==""){
								$(
								"#warning4")
								.html(
										"*Bạn cần nhập số điện thoại");
						return false;
							}
							if(email==null || email==""){
								$(
								"#warning5")
								.html(
										"*Bạn cần nhập email");
						return false;
							}
							if(ngayTao==null || ngayTao=="")
				    {
				        return false;
				    }
					    else{
						
						
						$.ajax({
							type : "POST", //Kiểu đưa dữ liệu
							url : "themnguoidung.action", //Hàm sự kiện    
							dataType: 'json',
							data : { //Danh sách các thông tin cần gửi lên theo kiểu json
								taiKhoan : taiKhoan,
								matKhau : matKhau,
								hoTen : hoTen,
								dienThoai : dienThoai,
								email : email,
								ngayTao : ngayTao,
								ngayCapNhat : ngayCapNhat,
								vaitro_id : vaitro_id,
								trangThai : trangThai
							},
							success : function(result) {
								alert(result.kq);
								
								//Reload lại trang
								window.location.reload();
							}
						});
					    }
					},

					// button dong
					"Đóng" : function() {
						$(this).dialog("close");
					}
				}
			});
		}); // ket thuc them moi
	});

	function thongTinChiTietNguoiDung(id) {
		$.ajax({
			type : "GET",
			url : "laythongtinchitietnguoidung.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.jsonNguoiDung);
				var DateT = new Date(d.ngayTao);
				var dateT = DateT.getDate()+'/'+(DateT.getMonth()+1)+'/'+DateT.getFullYear();
				var DateCN = new Date();
				var dateCN = DateCN.getDate()+'/'+(DateCN.getMonth()+1)+'/'+DateCN.getFullYear();
				// hien thi giao dien
				$("#txtId").val(d.id);
				$("#txtTaiKhoan").val(d.taiKhoan);
				$("#txtMatKhau").val(d.matKhau);
				$("#txtHoTen").val(d.hoTen);
				$("#txtDienThoai").val(d.dienThoai);
				$("#txtEmail").val(d.email);
				$("#txtNgayTao").val(dateT);
				$("#txtNgayCapNhat").val(dateCN);
				$("#cboVaiTro").val(d.vaiTroId);
				$("#chbTrangThai").attr('checked', d.trangThai);
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet chuc nang can sua
		thongTinChiTietNguoiDung(id);

		// hien thi popup va xu ly cap nhat
		$("#formNguoiDung").attr("title", "Sửa thông tin người dùng");
		$("#formNguoiDung").dialog({
			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {
					// gui thong tin len server          	
					var id = $("#txtId").val();
					var taiKhoan = $("#txtTaiKhoan").val();
					var matKhau = $("#txtMatKhau").val();				
					var hoTen = $("#txtHoTen").val();
					var dienThoai = $("#txtDienThoai").val();
					var email = $("#txtEmail").val();
					var ngayTao = $("#txtNgayTao").val();
					var ngayCapNhat = $("#txtNgayCapNhat").val();
					var vaitro_id = $("#cboVaiTro").val();
					var trangThai = $("#chbTrangThai").is(":checked");
					
					
					if (taiKhoan==null || taiKhoan==""){
						$(
						"#warning1")
						.html(
								"*Bạn cần nhập tài khoản");
				return false;
					}
				        if(matKhau==null || matKhau==""){
				        	$(
							"#warning2")
							.html(
									"*Bạn cần nhập mật khẩu");
					return false;
				        }
						if(hoTen==null || hoTen==""){
							$(
							"#warning3")
							.html(
									"*Bạn cần nhập họ tên");
					return false;
						}
						if(dienThoai==null || dienThoai==""){
							$(
							"#warning4")
							.html(
									"*Bạn cần nhập số điện thoại");
					return false;
						}
						if(email==null || email==""){
							$(
							"#warning5")
							.html(
									"*Bạn cần nhập email");
					return false;
						}
						if(ngayTao==null || ngayTao=="")
			    {
			        return false;
			    }
			    else{
					
					$.ajax({
						type : "POST",
						url : "capnhatnguoidung.action",
						dataType: 'json',
						data : {
							id : id,
							taiKhoan : taiKhoan,
							matKhau : matKhau,
							hoTen : hoTen,
							dienThoai : dienThoai,
							email : email,
							ngayTao : ngayTao,
							ngayCapNhat : ngayCapNhat,
							vaitro_id : vaitro_id,
							trangThai : trangThai
						},
						success : function(result) {
							alert(result.kq);
							// reload lai trang
							window.location.reload();
						}
					});
			     
			    }
					
				},

				"Đóng" : function() {
					$(this).dialog("close");
				}
			}
		});
	}
	
	function xoaThongTin(id) {

		// hien thi popup va xu ly cap nhat
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({
			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoanguoidung.action",
						data : {
							id : id
						},
						success : function(result) {
							// reload lai trang
							window.location.reload();
						}
					});
				},

				"Hủy bỏ" : function() {
					$(this).dialog("close");
				}
			}
		});
	}
	
	
	function checkall() {
		var check = document.getElementsByClassName('text');
		for (var i = 0; i < check.length; i++) {
			check[i].checked = true;
		}
	}
	function uncheckall() {
		var bocheck = document.getElementsByClassName('text');
		for (var i = 0; i < bocheck.length; i++) {
			bocheck[i].checked = false;
		}
	}
	function duyetCheckBox() {
		var checkBox = $('input[type = "checkbox"]:checked');
		if (checkBox.length > 0) {
			$('#kq').html(checkBox.length + " người dùng được chọn");
			checkBox.each(function() {
				$('#kq').append($(this).val() + "\t");
			});

			$("#thongbaoduyet").attr("title", "Duyệt thông tin");
			$("#thongbaoduyet").dialog({
				width : 400,
				modal : true,
				buttons : {
					"Duyệt" : function() {
						checkBox.each(function() {
							var t = $(this).val();

							$.ajax({
								type : "GET",
								url : "duyetNguoiDung.action",
								data : {
									id : t
								},
								success : function(result) {
									// reload lai trang
									window.location.reload();
								}
							});
						});
					},

					"Hủy bỏ" : function() {
						$(this).dialog("close");
					}
				}
			});

		} else {
			$('#kq').text("Không có người dùng nào được chọn");
		}
	}

	function boDuyetCheckBox() {
		var checkBox = $('input[type = "checkbox"]:checked');
		if (checkBox.length > 0) {
			$('#kq').html(checkBox.length + " người dùng được chọn");
			checkBox.each(function() {
				$('#kq').append($(this).val() + "\t");
			});

			$("#thongbaoboduyet").attr("title", "Bỏ Duyệt thông tin");
			$("#thongbaoboduyet").dialog({
				width : 400,
				modal : true,
				buttons : {
					"Bỏ Duyệt" : function() {
						checkBox.each(function() {
							var t = $(this).val();

							$.ajax({
								type : "GET",
								url : "boDuyetNguoiDung.action",
								data : {
									id : t
								},
								success : function(result) {
									// reload lai trang
									window.location.reload();
								}
							});
						});
					},

					"Hủy bỏ" : function() {
						$(this).dialog("close");
					}
				}
			});

		} else {
			$('#kq').text("Không có người dùng nào được chọn");
		}
	}	
		
</script>
</head>
<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách người dùng
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Người dùng</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<div class="col-md-12">

			<span class="btn btn-primary"><a
				href='<s:url action="qlnguoidung"/>' class="btn btn-primary">DANH
					SÁCH</a></span>
			<s:if test=" #them_5 == true">
				<span class="btn btn-primary"><a id="btnThemMoi" href='#'
					class="btn btn-primary">Thêm mới</a></span>
			</s:if>
		</div>
	</div>



	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form method="GET" theme="simple">

						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="checkall()">
							<a class="nav-link" href="#"> CHECK ALL </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="uncheckall()">
							<a class="nav-link" href="#"> UNCHECK ALL </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="duyetCheckBox()">
							<a class="nav-link" href="#"> DUYỆT NHIỀU </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="boDuyetCheckBox()">
							<a class="nav-link" href="#">BỎ DUYỆT NHIỀU </a>
						</button>
						<div id="kq"></div>

						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 2%"></th>
									<th style="width: 8%;">Tài khoản</th>
									<!--  		<th style="width: 8%;">Mật khẩu</th>      -->
									<th style="width: 8%;">Họ và tên</th>
									<th style="width: 8%;">Điện thoại</th>
									<th style="width: 8%;">Email</th>
									<th style="width: 8%;">Ngày tạo</th>
									<!--		<th style="width: 8%;">Ngày cập nhật</th>   -->
									<th style="width: 8%;">Trạng thái</th>
									<th style="width: 8%;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_5 == true">
								<tbody>
									<s:iterator var="nd" value="lstNguoiDung">
										<tr class="checkbox">
											<td><input id="checkBox" type="checkbox" class="text"
												value="${nd.id}"></td>
											<td><s:property value="taiKhoan" /></td>
											<!-- 			<td><s:property value="matKhau" /></td>       -->
											<td><s:property value="hoTen" /></td>
											<td><s:property value="dienThoai" /></td>
											<td><s:property value="email" /></td>
											<td><s:property value="ngayTao" /></td>
											<!--			<td><s:property value="ngayCapNhat" /></td>    -->
											<td><s:property value="trangThai" /></td>
											<td><s:if test=" #sua_5 == true">
													<a href="#"
														onclick="suaThongTin(<s:property value="id" />)"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_5 == true">
													<a onclick="xoaThongTin(<s:property value="id" />);"
														href='#'><i class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới người dùng -->
						<fieldset id="formNguoiDung" style="display: none;"
							title="Nhập thông tin người dùng">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Tài khoản:</td>
									<td><input type="text" id="txtTaiKhoan"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning1" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Mật khẩu:</td>
									<td><input type="password" id="txtMatKhau"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning2" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Họ và tên:</td>
									<td><input type="text" id="txtHoTen" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning3" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Điện thoại:</td>
									<td><input type="text" id="txtDienThoai"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning4" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><input type="text" id="txtEmail" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning5" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Ngày tạo:</td>
									<td><input type="text" id="txtNgayTao" readonly="readonly"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Ngày cập nhật:</td>
									<td><input type="text" id="txtNgayCapNhat"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning1" style="color: red;"></span></td>
								</tr>

								<tr>
									<td>Vai Trò:</td>
									<td><s:select list="lstVaiTro" headerKey=""
											headerValue="--Chọn vai trò--" id="cboVaiTro" listKey="id"
											listValue="tenVaiTro" /></td>
								</tr>

								<tr>
									<td>Trạng thái:</td>
									<td><input type="checkbox" id="chbTrangThai" value="true" /></td>
								</tr>
							</table>
						</fieldset>
						<div id="thongbaoxoa" style="display: none;">Bạn có chắc
							muốn xóa thông tin này ?</div>

						<div id="thongbaoduyet" style="display: none;">Bạn có chắc
							muốn duyệt thông tin này ?</div>

						<div id="thongbaoboduyet" style="display: none;">Bạn có chắc
							muốn bỏ duyệt thông tin này ?</div>


					</s:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>