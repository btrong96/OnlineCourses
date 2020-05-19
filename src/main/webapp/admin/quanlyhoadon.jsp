<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách hóa đơn</title>

<s:set var="danhSach_11" value="false" />
<s:set var="them_11" value="false" />
<s:set var="sua_11" value="false" />
<s:set var="xoa_11" value="false" />
<s:set var="baoCao_11" value="false" />

<s:if test='#session.containsKey("danhSach_11")'>
	<s:set var="danhSach_11" value='#session["danhSach_11"]' />
</s:if>
<s:if test='#session.containsKey("them_11")'>
	<s:set var="them_11" value='#session["them_11"]' />
</s:if>
<s:if test='#session.containsKey("sua_11")'>
	<s:set var="sua_11" value='#session["sua_11"]' />
</s:if>
<s:if test='#session.containsKey("xoa_11")'>
	<s:set var="xoa_11" value='#session["xoa_11"]' />
</s:if>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						//Gọi form thêm mới
						$("#btnThemMoi")
								.click(
										function() {
											//alert("Hello");
											$("#formhoadon")
													.attr("title",
															"Thêm mới thông tin hóa đơn");

											var today = new Date();
											var date = today.getDate() + '/'
													+ (today.getMonth() + 1)
													+ '/' + today.getFullYear();
											//Xoá thông tin cũ đi nếu có
											$("#txtIdHoaDon").val("");
											$("#txtNgayMua").val(date);
											$("#txtGhiChu").val("");
											$("#txtDaThanhToan").val("");
											$("#cboKhachHang").val("");

											$("#txtIdHoaDon").focus();

											//Hiển thị giao diện cập nhật sửa thông tin
											$("#formhoadon")
													.dialog(
															{

																width : 500,
																modal : true,
																buttons : {
																	"Cập nhật" : function() {

																		//Xử lý để đưa thông tin lên server
																		//		var ma = $("#txtIdGiangVien").val();
																		var ngaymua = $(
																				"#txtNgayMua")
																				.val();
																		var ghichu = $(
																				"#txtGhiChu")
																				.val();
																		var dathanhtoan = $(
																				"#txtDaThanhToan")
																				.val();
																		var khachhangid = $(
																				"#cboKhachHang")
																				.val();

																		$
																				.ajax({
																					type : "POST",//Kiểu đưa dữ liệu
																					url : "themHoaDon.action",//Hàm sự kiện
																					data : {//Danh sách các thông tin cần gửi lên theo kiểu json																
																						//       		id : ma,
																						ngayMua : ngaymua,
																						ghiChu : ghichu,
																						daThanhToan : dathanhtoan,
																						khachHangId : khachhangid
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
	 * Hàm sửa thông tin hóa đơn theo mã
	 */
	function suaThongTin(idHoaDon) {
		//Lấy thông tin chi tiết của hóa đơn cần sửa
		thongTinChiTietHoaDon(idHoaDon);

		//Hiển thị popup và xử lý cập nhật
		$("#formhoadon").attr("title", "Sửa thông tin hóa đơn");

		$("#formhoadon").dialog({

			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {

					//Xử lý để đưa thông tin lên server
					var id = $("#txtIdHoaDon").val();
					var ngaymua = $("#txtNgayMua").val();
					var ghichu = $("#txtGhiChu").val();
					var dathanhtoan = $("#txtDaThanhToan").val();
					var khachhangid = $("#cboKhachHang").val();

					$.ajax({
						type : "POST",
						url : "capNhatHoaDon.action",
						data : {
							id : id,
							ngayMua : ngaymua,
							ghiChu : ghichu,
							daThanhToan : dathanhtoan,
							khachHangId : khachhangid
						},
						success : function(result) {

							//Đưa ra thông báo
							//	alert(result.kq);

							//Reload lại trang
							window.location.reload();
						}
					});

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
	function thongTinChiTietHoaDon(idHoaDon) {
		$.ajax({
			type : "GET",
			url : "layChiTietHoaDon.action",
			data : {
				id : idHoaDon
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.hoaDon);
				var DateNM = new Date(d.ngayMua);
				var dateNgayMua = DateNM.getDate() + '/'
						+ (DateNM.getMonth() + 1) + '/' + DateNM.getFullYear();

				//alert(d.tenChuDe);
				//Hiển thị lên giao diện
				$("#txtIdHoaDon").val(d.id);
				$("#txtNgayMua").val(dateNgayMua);
				$("#txtGhiChu").val(d.ghiChu);
				$("#txtDaThanhToan").val(d.daThanhToan);
				$("#cboKhachHang").val(d.khachHang.id);

			}
		});
	}

	/**
	 * Xóa thông tin chủ đề
	 */
	function xoaThongTin(idHoaDon) {

		//Hiển thị popup và xử lý cập nhật
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({

			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoaHoaDon.action",
						data : {
							id : idHoaDon
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
</script>
</head>

<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách hóa đơn
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Hóa đơn</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_11 == true">
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
					<s:form>
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 15%;">Id</th>
									<th>Ngày mua</th>
									<th>Ghi chú</th>
									<th>Đã thanh toán</th>
									<th>Tên khách hàng</th>
									<th>Chi tiết thông tin hóa đơn</th>
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_11 == true">
								<tbody>
									<s:iterator var="hd" value="lstHoaDon">
										<tr>
											<td><s:property value="id" /></td>
											<td><s:property value="ngayMua" /></td>
											<td><s:property value="ghiChu" /></td>
											<td><s:property value="daThanhToan" /></td>
											<td><s:property value="khachHang.tenKhachHang" /></td>
											<td><a href='<s:url action="chiTietHoaDon?ma=%{id}"/>'>Xem
													chi tiết</a></td>
											<td><s:if test=" #sua_11 == true">
													<a href="#" onclick="suaThongTin('${hd.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp;<s:if test=" #xoa_11 == true">
													<a onclick="xoaThongTin('${hd.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới hóa đơn -->
						<fieldset id="formhoadon" style="display: none;"
							title="Nhập thông tin hóa đơn">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdHoaDon" style="width: 90%;" /></td>
								</tr>
								<tr>
									<td>Ngày mua</td>
									<td><input type="text" id="txtNgayMua"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Ghi chú</td>
									<td><input type="text" id="txtGhiChu" style="width: 100%;" /></td>
								</tr>

								<tr>
									<td>Đã thanh toán</td>
									<td><input type="text" id="txtDaThanhToan"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Khách hàng:</td>
									<td><s:select list="lstKhachHang" headerKey=""
											headerValue="--Chọn khách hàng--" id="cboKhachHang"
											listKey="id" listValue="tenKhachHang" /></td>
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