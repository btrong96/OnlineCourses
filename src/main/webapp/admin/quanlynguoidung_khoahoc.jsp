<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách người dùng-khóa học</title>


<s:set var="danhSach_15" value="false" />
<s:set var="them_15" value="false" />
<s:set var="sua_15" value="false" />
<s:set var="xoa_15" value="false" />
<s:set var="baoCao_15" value="false" />


<s:if test='#session.containsKey("danhSach_15")'>
	<s:set var="danhSach_15" value='#session["danhSach_15"]' />
</s:if>
<s:if test='#session.containsKey("them_15")'>
	<s:set var="them_15" value='#session["them_15"]' />
</s:if>
<s:if test='#session.containsKey("sua_15")'>
	<s:set var="sua_15" value='#session["sua_15"]' />
</s:if>
<s:if test='#session.containsKey("xoa_15")'>
	<s:set var="xoa_15" value='#session["xoa_15"]' />
</s:if>

<script type="text/javascript">
	$(document).ready(function() {
		// goi form them moi
		$("#btnThemMoi").click(function() {
			$("#formNguoiDung_KhoaHoc").attr("title", "Thêm mới người dùng - khóa học");
			
			var today = new Date();
			var date = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();
			
			// xoa thong tin cu (neu co)     		$("#txtTenLoai").focus();
			
			    $("#txtNgayCap").val(date);
			
			
			// hien thi giao dien them moi thong tin
			$("#formNguoiDung_KhoaHoc").dialog({
				width : 500,
				modal : true,
				buttons : {
					// button them moi
					"Thêm mới" : function() {
						// xu ly thong tin gui len server
						var nguoidung_id = $("#cboNguoiDung").val();
						var khoahoc_id = $("#cboKhoaHoc").val();
						var ngaycap = $("#txtNgayCap").val();

						$.ajax({
							type : "POST", //Kiểu đưa dữ liệu
							url : "themNguoiDung_KhoaHoc.action", //Hàm sự kiện                    
							data : { //Danh sách các thông tin cần gửi lên theo kiểu json
								nguoiDungId : nguoidung_id,
								khoaHocId : khoahoc_id,
								ngayCap : ngaycap
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

	function thongTinChiTietNguoiDung_KhoaHoc(id) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietNguoiDung_KhoaHoc.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.nguoiDung_KhoaHoc);
				
				var DateT = new Date(d.ngayCap);
				var dateT = DateT.getDate()+'/'+(DateT.getMonth()+1)+'/'+DateT.getFullYear();
				
				// hien thi giao dien
				$("#txtId").val(d.id);
				$("#cboNguoiDung").val(d.nguoiDungId);
				$("#cboKhoaHoc").val(d.khoaHocId);
				$("#txtNgayCap").val(dateT);		
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet loai can sua
		thongTinChiTietNguoiDung_KhoaHoc(id);

		// hien thi popup va xu ly cap nhat
		$("#formNguoiDung_KhoaHoc").attr("title", "Sửa thông tin người dùng - khóa học");
		$("#formNguoiDung_KhoaHoc").dialog({
			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {
					// gui thong tin len server
					var id = $("#txtId").val();					
					var nguoidung_id = $("#cboNguoiDung").val();
					var khoahoc_id = $("#cboKhoaHoc").val();
					var ngaycap = $("#txtNgayCap").val();
			
					$.ajax({
						type : "POST",
						url : "capNhatNguoiDung_KhoaHoc.action",
						data : {
							id : id,
							nguoiDungId : nguoidung_id,
							khoaHocId : khoahoc_id,
							ngayCap : ngaycap
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
						url : "xoaNguoiDung_KhoaHoc.action",
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
				<i class="fa fa-th-list"></i> Danh sách người dùng- khóa học
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Người dùng- khóa học</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_15 == true">
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
					<s:form action="timKiemNguoiDung_KhoaHoc" method="GET" theme="simple">
					<fieldset>
                       <legend>Nhập thông tin tìm kiếm Người dùng- Khóa học</legend>
							<table class="table table-striped">
								<tr>
								    <td>Tên người dùng:</td>
									<td><s:select list="lstNguoiDung"
											name="maNguoiDungTimKiem" value="%{maNguoiDungTimKiem}"
											headerKey="" headerValue="--Chọn người dùng--" listKey="id"
											listValue="hoTen" class="form-control" /></td>
											
						            <td>Tên khóa học:</td>
									<td><s:select list="lstKhoaHoc" name="maKhoaHocTimKiem"
											value="%{maKhoaHocTimKiem}" headerKey=""
											headerValue="--Chọn khóa học--" listKey="id"
											listValue="tenKhoaHoc" class="form-control" /></td>
																				
									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>

						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 30%;">Tên người dùng</th>
									<th>Tên khóa học</th>
									<th>Ngày cấp</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_15 == true">
								<tbody>
									<s:iterator var="ndkh" value="lstNguoiDung_KhoaHoc">
										<tr>
										    <td><s:property value="tenNguoiDung" /></td>
											<td><s:property value="tenKhoaHoc" /></td>
											<td><s:property value="ngayCap" /></td>
											<td><s:if test=" #sua_15 == true">
													<a href="#" onclick="suaThongTin('${ndkh.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_15 == true">
													<a onclick="xoaThongTin('${ndkh.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

						<!-- form them moi -->
						<fieldset id="formNguoiDung_KhoaHoc" style="display: none;"
							title="Nhập thông tin">
							<table>
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>													
								<tr>
									<td>Tên người dùng:</td>
									<td><s:select list="lstNguoiDung" headerKey=""
											headerValue="--Chọn người dùng--" id="cboNguoiDung" listKey="id"
											listValue="hoTen" /></td>
								</tr>
								<tr>
									<td>Tên khóa học:</td>
									<td><s:select list="lstKhoaHoc" headerKey=""
											headerValue="--Chọn khóa học--" id="cboKhoaHoc" listKey="id"
											listValue="tenKhoaHoc" /></td>
								</tr>							
								<tr>
									<td>Ngày cấp:</td>
									<td><input type="text" id="txtNgayCap" readonly="readonly" style="width: 100%;" /></td>
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