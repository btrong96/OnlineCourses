<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách khách hàng</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<s:set var="danhSach_7" value="false" />
<s:set var="them_7" value="false" />
<s:set var="sua_7" value="false" />
<s:set var="xoa_7" value="false" />
<s:set var="baoCao_7" value="false" />

<s:if test='#session.containsKey("danhSach_7")'>
	<s:set var="danhSach_7" value='#session["danhSach_7"]' />
</s:if>
<s:if test='#session.containsKey("them_7")'>
	<s:set var="them_7" value='#session["them_7"]' />
</s:if>
<s:if test='#session.containsKey("sua_7")'>
	<s:set var="sua_7" value='#session["sua_7"]' />
</s:if>
<s:if test='#session.containsKey("xoa_7")'>
	<s:set var="xoa_7" value='#session["xoa_7"]' />
</s:if>


<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#txtTenKhachHang")
								.on(
										"keyup",
										function() {
											var tenKhachHang = $(
													"#txtTenKhachHang").val();
											if (tenKhachHang.length < 1) {
												$("#warning1")
														.html(
																" *Bạn cần nhập tên khách hàng");
											} else {
												$("#warning1").html("");
											}
										});
						$("#txtDiaChi").on("keyup", function() {
							var diaChi = $("#txtDiaChi").val();
							if (diaChi.length < 1) {
								$("#warning2").html(" *Bạn cần nhập địa chỉ");
							} else {
								$("#warning2").html("");
							}
						});
						$("#txtDienThoai").on("keyup", function() {
							var dienThoai = $("#txtDienThoai").val();
							if (dienThoai.length < 1) {
								$("#warning3").html(" *Bạn cần nhập địa chỉ");
							} else {
								$("#warning3").html("");
							}
						});
						$("#txtCMND").on("keyup", function() {
							var cmnd = $("#txtCMND").val();
							if (cmnd.length < 1) {
								$("#warning4").html(" *Bạn cần nhập số CMND");
							} else {
								$("#warning4").html("");
							}
						});
						$("#txtNgayCap").on(
								"click",
								function() {
										$("#warning5").html(
										"");
								});
						$("#txtNoiCap").on("keyup", function() {
							var noiCap = $("#txtNoiCap").val();
							if (noiCap.length < 1) {
								$("#warning6").html(" *Bạn cần nhập nơi cấp");
							} else {
								$("#warning6").html("");
							}
						});
						$("#txtMaSoThue").on(
								"keyup",
								function() {
									var maSoThue = $("#txtMaSoThue").val();
									if (maSoThue.length < 1) {
										$("#warning7").html(
												" *Bạn cần nhập mã số thuế");
									} else {
										$("#warning7").html("");
									}
								});
						$("#txtNgayCapNhat")
								.on(
										"keyup",
										function() {
											var ngayCapNhat = $(
													"#txtNgayCapNhat").val();
											if (ngayCapNhat.length < 1) {
												$("#warning9")
														.html(
																" *Bạn cần chọn ngày cập nhật");
											} else {
												$("#warning9").html("");
											}
										});
						$("#txtMoTa").on("keyup", function() {
							var moTa = $("#txtMoTa").val();
							if (moTa.length < 1) {
								$("#warning10").html(" *Bạn cần nhập mô tả");
							} else {
								$("#warning10").html("");
							}
						});
						//Gọi form thêm mới
						$("#btnThemMoi")
								.click(
										function() {
											//alert("Hello");
											$("#formkhachhang")
													.attr("title",
															"Thêm mới thông tin khách hàng");

											var today = new Date();
											var date = today.getDate() + '/'
													+ (today.getMonth() + 1)
													+ '/' + today.getFullYear();
											//Xoá thông tin cũ đi nếu có
											$("#txtIdKhachHang").val("");
											$("#txtTenKhachHang").val("");
											$("#txtDiaChi").val("");
											$("#txtDienThoai").val("");
											$("#txtCMND").val("");
											$("#txtNgayCap").val("");
											$("#txtNoiCap").val("");
											$("#txtMaSoThue").val("");
											$("#txtNgayTao").val(date);
											$("#txtNgayCapNhat").val(date);
											$("#txtMoTa").val("");
											$("#cboNguoiDung").val("");

											$("#txtIdKhachHang").focus();

											//Hiển thị giao diện cập nhật sửa thông tin
											$("#formkhachhang")
													.dialog(
															{

																width : 500,
																modal : true,
																buttons : {
																	"Cập nhật" : function() {

																		//Xử lý để đưa thông tin lên server
																		//		var ma = $("#txtIdGiangVien").val();

																		var tenkhachhang = $(
																				"#txtTenKhachHang")
																				.val();
																		var diachi = $(
																				"#txtDiaChi")
																				.val();
																		var dienthoai = $(
																				"#txtDienThoai")
																				.val();
																		var cmnd = $(
																				"#txtCMND")
																				.val();
																		var ngaycap = $(
																				"#txtNgayCap")
																				.val();
																		var noicap = $(
																				"#txtNoiCap")
																				.val();
																		var masothue = $(
																				"#txtMaSoThue")
																				.val();
																		var ngaytao = $(
																				"#txtNgayTao")
																				.val();
																		var ngaycapnhat = $(
																				"#txtNgayCapNhat")
																				.val();
																		var mota = $(
																				"#txtMoTa")
																				.val();
																		var nguoidungid = $(
																				"#cboNguoiDung")
																				.val();

																		if (tenkhachhang == null
																				|| tenkhachhang == "") {
																			$(
																					"#warning1")
																					.html(
																							"*Bạn cần nhập tên khách hàng");
																			return false;
																		}
																		if (diachi == null
																				|| diachi == "") {
																			$(
																					"#warning2")
																					.html(
																							"*Bạn cần nhập địa chỉ");
																			return false;
																		}
																		if (dienthoai == null
																				|| dienthoai == "") {
																			$(
																					"#warning3")
																					.html(
																							"*Bạn cần nhập số điện thoại");
																			return false;
																		}
																		if (cmnd == null
																				|| cmnd == "") {
																			$(
																					"#warning4")
																					.html(
																							"*Bạn cần nhập số CMND");
																			return false;
																		}
																		if (ngaycap == null
																				|| ngaycap == "") {
																			$(
																					"#warning5")
																					.html(
																							"*Bạn cần nhập ngày cấp");
																			return false;
																		}
																		if (noicap == null
																				|| noicap == "") {
																			$(
																					"#warning6")
																					.html(
																							"*Bạn cần nhập nơi cấp");
																			return false;
																		}
																		if (masothue == null
																				|| masothue == "") {
																			$(
																					"#warning7")
																					.html(
																							"*Bạn cần nhập mã số thuế");
																			return false;
																		}
																		if (ngaytao == null
																				|| ngaytao == "") {
																			$(
																					"#warning8")
																					.html(
																							"*Bạn cần chọn ngày tạo");
																			return false;
																		}
																		if (mota == null
																				|| mota == "") {
																			$(
																					"#warning9")
																					.html(
																							"*Bạn cần nhập mô tả");
																			return false;
																		} else {

																			$
																					.ajax({
																						type : "POST",//Kiểu đưa dữ liệu
																						url : "themKhachHang.action",//Hàm sự kiện
																						data : {//Danh sách các thông tin cần gửi lên theo kiểu json																
																							//       		id : ma,

																							tenKhachHang : tenkhachhang,
																							diaChi : diachi,
																							dienThoai : dienthoai,
																							cMND : cmnd,
																							ngayCap : ngaycap,
																							noiCap : noicap,
																							maSoThue : masothue,
																							ngayTao : ngaytao,
																							ngayCapNhat : ngaycapnhat,
																							moTa : mota,
																							nguoiDungId : nguoidungid,

																						},
																						success : function(
																								result) {

																							//Đưa ra thông báo
																							//alert(result.kq);

																							//Reload lại trang
																							window.location
																									.reload();
																						}
																					});
																		}

																	},
																	"Đóng" : function() {
																		$(this)
																				.dialog(
																						"close");
																	}
																}
															});
										}); //end them moi

					});

	/*
	 * Hàm sửa thông tin khách hàng theo mã
	 */
	function suaThongTin(idKhachHang) {
		//Lấy thông tin chi tiết của khách hàng cần sửa
		thongTinChiTietKhachHang(idKhachHang);

		//Hiển thị popup và xử lý cập nhật
		$("#formkhachhang").attr("title", "Sửa thông tin khách hàng");

		$("#formkhachhang").dialog({

			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {

					//Xử lý để đưa thông tin lên server

					var id = $("#txtIdKhachHang").val();
					var tenkhachhang = $("#txtTenKhachHang").val();
					var diachi = $("#txtDiaChi").val();
					var dienthoai = $("#txtDienThoai").val();
					var cmnd = $("#txtCMND").val();
					var ngaycap = $("#txtNgayCap").val();
					var noicap = $("#txtNoiCap").val();
					var masothue = $("#txtMaSoThue").val();
					var ngaytao = $("#txtNgayTao").val();
					var ngaycapnhat = $("#txtNgayCapNhat").val();
					var mota = $("#txtMoTa").val();
					var nguoidungid = $("#cboNguoiDung").val();

					if (tenkhachhang == null || tenkhachhang == "") {
						$("#warning1").html("*Bạn cần nhập tên khách hàng");
						return false;
					}
					if (diachi == null || diachi == "") {
						$("#warning2").html("*Bạn cần nhập địa chỉ!");
						return false;
					}
					if (dienthoai == null || dienthoai == "") {
						$("#warning3").html("*Bạn cần nhập số điện thoại");
						return false;
					}
					if (cmnd == null || cmnd == "") {
						$("#warning4").html("*Bạn cần nhập số CMND");
						return false;
					}
					if (ngaycap == null || ngaycap == "") {
						$("#warning5").html("*Bạn cần nhập ngày cấp");
						return false;
					}
					if (noicap == null || noicap == "") {
						$("#warning6").html("*Bạn cần nhập nơi cấp");
						return false;
					}
					if (masothue == null || masothue == "") {
						$("#warning7").html("*Bạn cần nhập mã số thuế");
						return false;
					}
					if (ngaytao == null || ngaytao == "") {
						$("#warning8").html("*Bạn cần chọn ngày tạo");
						return false;
					}
					if (mota == null || mota == "") {
						$("#warning9").html("*Bạn cần nhập mô tả");
						return false;
					} else {

						$.ajax({
							type : "POST",
							url : "capNhatKhachHang.action",
							data : {
								id : id,
								tenKhachHang : tenkhachhang,
								diaChi : diachi,
								dienThoai : dienthoai,
								cMND : cmnd,
								ngayCap : ngaycap,
								noiCap : noicap,
								maSoThue : masothue,
								ngayTao : ngaytao,
								ngayCapNhat : ngaycapnhat,
								moTa : mota,
								nguoiDungId : nguoidungid,
							},
							success : function(result) {

								//Đưa ra thông báo
								//	alert(result.kq);

								//Reload lại trang
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

	/*
	 * Hàm hiển thị thông tin chi tiết chủ đề bằng jquery ajax
	 */
	function thongTinChiTietKhachHang(idKhangHang) {
		$.ajax({
			type : "GET",
			url : "layChiTietKhachHang.action",
			data : {
				id : idKhangHang
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.khachHang);
				var DateNC = new Date(d.ngayCap);
				var dateNgayCap = DateNC.getDate() + '/'
						+ (DateNC.getMonth() + 1) + '/' + DateNC.getFullYear();
				var DateNT = new Date(d.ngayTao);
				var dateNgayTao = DateNT.getDate() + '/'
						+ (DateNT.getMonth() + 1) + '/' + DateNT.getFullYear();
				var today = new Date();
				var dateNgayCapNhat = today.getDate() + '/'
						+ (today.getMonth() + 1) + '/' + today.getFullYear();

				//alert(d.tenChuDe);
				//Hiển thị lên giao diện

				$("#txtIdKhachHang").val(d.id);
				$("#txtTenKhachHang").val(d.tenKhachHang);
				$("#txtDiaChi").val(d.diaChi);
				$("#txtDienThoai").val(d.dienThoai);
				$("#txtCMND").val(d.cMND);
				$("#txtNgayCap").val(dateNgayCap);
				$("#txtNoiCap").val(d.noiCap);
				$("#txtMaSoThue").val(d.maSoThue);
				$("#txtNgayTao").val(dateNgayTao);
				$("#txtNgayCapNhat").val(dateNgayCapNhat);
				$("#txtMoTa").val(d.moTa);
				$("#txtNguoiDungId").val(d.nguoiDungId);

			}
		});
	}

	/**
	 * Xóa thông tin khách hàng
	 */
	function xoaThongTin(idKhachHang) {

		//Hiển thị popup và xử lý cập nhật
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({

			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoaKhachHang.action",
						data : {
							id : idKhachHang
						},
						success : function(result) {

							//Reload lại trang
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
	$(function() {
		$("#txtNgayCap").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</head>

<body>

	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách khách hàng
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Khách hàng</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_7 == true">
			<div class="col-md-12">
				<span class="btn btn-primary"><a id="btnThemMoi" href='#'
					class="btn btn-primary">Thêm mới</a></span>
			</div>
		</s:if>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form action="timKiemKhachHang" method="GET" theme="simple">
						<fieldset>
							<legend>Nhập thông khách hàng</legend>
							<table class="table table-striped">
								<tr>
									<td>Từ khoá:</td>
									<td><s:textfield name="tuKhoa" class="form-control"
											value="%{tuKhoa}" /></td>

									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 15%;">Tên khách hàng</th>
									<th>Địa chỉ</th>
									<th>Điện thoại</th>
									<th>CMND</th>
									<th>Mã số thuế</th>
									<th>Ngày tạo</th>
									<th>Ngày cập nhật</th>
									<th>Mô tả</th>
									<th style="width: 7%;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_7 == true">
								<tbody>
									<s:iterator var="kh" value="lstKhachHang">
										<tr>
											<td><s:property value="tenKhachHang" /></td>
											<td><s:property value="diaChi" /></td>
											<td><s:property value="dienThoai" /></td>
											<td><s:property value="cMND" /></td>
											<td><s:property value="maSoThue" /></td>
											<td><s:property value="ngayTao" /></td>
											<td><s:property value="ngayCapNhat" /></td>
											<td><s:property value="moTa" /></td>
											<td><s:if test=" #sua_7 == true">
													<a href="#" onclick="suaThongTin('${kh.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp; <s:if test=" #xoa_7 == true">
													<a onclick="xoaThongTin('${kh.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới khách hàng  -->
						<fieldset id="formkhachhang" style="display: none;"
							title="Nhập thông tin khách hàng">
							<table style="width: 100%;">

								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdKhachHang" value="id" style="width: 100%;" /></td>
								</tr>

								<tr>
									<td>Tên khách hàng</td>
									<td><input type="text" id="txtTenKhachHang"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning1" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Địa chỉ</td>
									<td><input type="text" id="txtDiaChi" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning2" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Điện thoại</td>
									<td><input type="text" id="txtDienThoai"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning3" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>CMND</td>
									<td><input type="text" id="txtCMND" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning4" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Ngày cấp</td>
									<td><input type="text" id="txtNgayCap"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning5" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Nơi cấp</td>
									<td><input type="text" id="txtNoiCap" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning6" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Mã số thuế</td>
									<td><input type="text" id="txtMaSoThue"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning7" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Ngày tạo</td>
									<td><input type="text" id="txtNgayTao" readonly="readonly"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Ngày cập nhật</td>
									<td><input type="text" id="txtNgayCapNhat"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning9" style="color: red;"></span></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning10" style="color: red;"></span></td>
								</tr>
								<tr>
									<td>Người dùng tài khoản:</td>
									<td><s:select list="lstNguoiDung" headerKey=""
											headerValue="--Chọn người dùng--" id="cboNguoiDung"
											listKey="id" listValue="taiKhoan" /></td>
								</tr>

							</table>
						</fieldset>
						<div id="thongbaoxoa" style="display: none;">Bạn có chắc
							muốn xóa thông tin này ?</div>
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>