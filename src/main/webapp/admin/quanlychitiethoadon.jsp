<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi Tiết Hóa Đơn</title>


<s:set var="danhSach_16" value="false" />
<s:set var="them_16" value="false" />
<s:set var="sua_16" value="false" />
<s:set var="xoa_16" value="false" />
<s:set var="baoCao_16" value="false" />


<s:if test='#session.containsKey("danhSach_16")'>
	<s:set var="danhSach_16" value='#session["danhSach_16"]' />
</s:if>
<s:if test='#session.containsKey("them_16")'>
	<s:set var="them_16" value='#session["them_16"]' />
</s:if>
<s:if test='#session.containsKey("sua_16")'>
	<s:set var="sua_16" value='#session["sua_16"]' />
</s:if>
<s:if test='#session.containsKey("xoa_16")'>
	<s:set var="xoa_16" value='#session["xoa_16"]' />
</s:if>

<script type="text/javascript">
	$(document).ready(function() {
		// goi form them moi
		$("#btnThemMoi").click(function() {
			$("#formChiTietHoaDon").attr("title", "Thêm mới chi tiết hóa đơn");

			// xoa thong tin cu (neu co)
			$("#txtSoLuong").val("");
			$("#txtThanhToan").val("");
			$("#txtMoTa").val("");
			$("#txtSoLuong").focus();

			// hien thi giao dien them moi thong tin
			$("#formChiTietHoaDon").dialog({
				width : 500,
				modal : true,
				buttons : {
					// button them moi
					"Thêm mới" : function() {
						// xu ly thong tin gui len server
						var soluong = $("#txtSoLuong").val();
						var thanhtoan = $("#txtThanhToan").val();
						var mota = $("#txtMoTa").val();
						var hoadon_id = $("#cboHoaDon").val();
						var khoahoc_id = $("#cboKhoaHoc").val();

						$.ajax({
							type : "POST", //Kiểu đưa dữ liệu
							url : "themChiTietHoaDon.action", //Hàm sự kiện                    
							data : { //Danh sách các thông tin cần gửi lên theo kiểu json

								soLuong : soluong,
								thanhToan : thanhtoan,
								moTa : mota,
								hoaDonId : hoadon_id,
								khoaHocId : khoahoc_id
							},
							success : function(result) {
								//Reload lại trang
								window.location.reload();
							}
						});
					},

					// button dong
					"Đóng" : function() {
						$(this).dialog("close");
					}
				}
			});
		}); // ket thuc them moi
	});

	function thongTinChiTietChiTietHoaDon(id) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietChiTietHoaDon.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.chiTietHoaDon);

				// hien thi giao dien
				$("#txtId").val(d.id);				
				$("#txtSoLuong").val(d.soLuong);
			    $("#txtThanhToan").val(d.thanhToan);
		        $("#txtMoTa").val(d.moTa);
			    $("#cboHoaDon").val(d.hoaDonId);
				$("#cboKhoaHoc").val(d.khoaHocId);
		
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet loai can sua
		thongTinChiTietChiTietHoaDon(id);

		// hien thi popup va xu ly cap nhat
		$("#formChiTietHoaDon").attr("title", "Sửa thông tin chi tiết hóa đơn");
		$("#formChiTietHoaDon").dialog({
			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {
					// gui thong tin len server
					var id = $("#txtId").val();
					var soluong = $("#txtSoLuong").val();
					var thanhtoan = $("#txtThanhToan").val();
					var mota = $("#txtMoTa").val();
					var hoadon_id = $("#cboHoaDon").val();
					var khoahoc_id = $("#cboKhoaHoc").val();

					$.ajax({
						type : "POST",
						url : "capNhatChiTietHoaDon.action",
						data : {
							id : id,
							soLuong : soluong,
							thanhToan : thanhtoan,
							moTa : mota,
							hoaDonId : hoadon_id,
							khoaHocId : khoahoc_id
						},
						success : function(result) {
							// reload lai trang
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
						url : "xoaChiTietHoaDon.action",
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
</script>
</head>
<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách chi tiết hóa đơn
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Chi Tiết Hóa
					Đơn</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_16 == true">
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
									<th style="width: 10%;">Số lượng</th>
									<th>Thanh toán</th>
									<th>Mô tả</th>
									<th>Hóa đơn ID</th>
									<th>Tên khóa học</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_16 == true">
							<tbody>

								<s:iterator var="cthd" value="lstChiTietHoaDon">
									<tr>
										<td><s:property value="soLuong" /></td>
										<td><s:property value="thanhToan" /></td>
										<td><s:property value="moTa" /></td>
										<td><s:property value="hoaDonId" /></td>
										<td><s:property value="tenKhoaHoc" /></td>
										<td><s:if test=" #sua_16 == true"><a href="#" onclick="suaThongTin('${cthd.id}')"><i
												class="fa fa-pencil-square-o"></i></a></s:if> &nbsp; <s:if test=" #xoa_16 == true"><a
											onclick="xoaThongTin('${cthd.id}');" href='#'><i
												class="fa fa-trash-o"></i></a></s:if></td>
									</tr>
								</s:iterator>
							</tbody>
							</s:if>
						</table>

						<!-- form them moi -->
						<fieldset id="formChiTietHoaDon" style="display: none;"
							title="Nhập thông tin">
							<table>
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Số Lượng:</td>
									<td><input type="text" id="txtSoLuong"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Thanh Toán:</td>
									<td><input type="text" id="txtThanhToan"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Mô Tả:</td>
									<td><input type="text" id="txtMoTa" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Id Hóa Đơn:</td>
									<td><s:select list="lstHoaDon" headerKey=""
											headerValue="--Chọn Id hóa đơn--" id="cboHoaDon" listKey="id"
											listValue="id" /></td>
								</tr>
								<tr>
									<td>Khóa Học:</td>
									<td><s:select list="lstKhoaHoc" headerKey=""
											headerValue="--Chọn khóa học--" id="cboKhoaHoc" listKey="id"
											listValue="tenKhoaHoc" /></td>
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