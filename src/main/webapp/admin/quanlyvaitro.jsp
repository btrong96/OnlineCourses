<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách vai trò</title>

<!-- set up nho de false -->
<s:set var="danhSach_9" value="false" />
<s:set var="them_9" value="false" />
<s:set var="sua_9" value="false" />
<s:set var="xoa_9" value="false" />
<s:set var="baoCao_9" value="false" />

<s:if test='#session.containsKey("danhSach_9")'>
	<s:set var="danhSach_9" value='#session["danhSach_9"]' />
</s:if>
<s:if test='#session.containsKey("them_9")'>
	<s:set var="them_9" value='#session["them_9"]' />
</s:if>
<s:if test='#session.containsKey("sua_9")'>
	<s:set var="sua_9" value='#session["sua_9"]' />
</s:if>
<s:if test='#session.containsKey("xoa_9")'>
	<s:set var="xoa_9" value='#session["xoa_9"]' />
</s:if>


<script type="text/javascript">
$(document).ready(function() {
	// goi form them moi
	$("#btnThemMoi").click(function() {
		$("#formVaiTro").attr("title", "Thêm mới vai trò");

		// xoa thong tin cu (neu co)
		$("#txtTenVaiTro").val("");
		$("#txtMoTa").val("");
		$("#txtTenVaiTro").focus();

		// hien thi giao dien them moi thong tin
		$("#formVaiTro").dialog({
			width : 500,
			modal : true,
			buttons : {
				// button them moi
				"Thêm mới" : function() {
					// xu ly thong tin gui len server
					var tenVaiTro = $("#txtTenVaiTro").val();
					var moTa = $("#txtMoTa").val();

					$.ajax({
						type : "POST",	//Kiểu đưa dữ liệu
						url : "themvaitro.action",	//Hàm sự kiện                    
						data : {	//Danh sách các thông tin cần gửi lên theo kiểu json
							tenVaiTro : tenVaiTro,
							moTa : moTa
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

function thongTinChiTietVaiTro(id) {
	$.ajax({
		type : "GET",
		url : "laythongtinchitietvaitro.action",
		data : {
			id : id
		},
		dataType : 'json',
		// contentType: 'application/json',
		// async: true,
		success : function(data) {
			var d = $.parseJSON(data.jsonVaiTro);

			// hien thi giao dien
			$("#txtId").val(d.id);
			$("#txtTenVaiTro").val(d.tenVaiTro);
			$("#txtMoTa").val(d.moTa);
		}
	});
}

function suaThongTin(id) {
	// lay thong tin chi tiet chuc nang can sua
	thongTinChiTietVaiTro(id);

	// hien thi popup va xu ly cap nhat
	$("#formVaiTro").attr("title", "Sửa thông tin vai trò");
	$("#formVaiTro").dialog({
		width : 500,
		modal : true,
		buttons : {
			"Cập nhật" : function() {
				// gui thong tin len server
				var id = $("#txtId").val();
				var tenVaiTro = $("#txtTenVaiTro").val();
				var moTa = $("#txtMoTa").val();

				$.ajax({
					type : "POST",
					url : "capnhatvaitro.action",
					data : {
						id : id,
						tenVaiTro : tenVaiTro,
						moTa : moTa
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
					url : "xoavaitro.action",
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
				<i class="fa fa-th-list"></i> Danh sách vai trò
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Vai trò</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_9 == true">
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
									<th style="width: 10%;">Tên vai trò</th>
									<th>Mô tả</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_9 == true">
								<tbody>
									<s:iterator var="vt" value="lstVaiTro">
										<tr>
											<td><s:property value="tenVaiTro" /></td>
											<td><s:property value="moTa" /></td>

											<td><s:if test=" #sua_9 == true">
													<a href="#" onclick="suaThongTin('${vt.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_9 == true">
													<a onclick="xoaThongTin('${vt.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới chủ đề  -->
						<fieldset id="formVaiTro" style="display: none;"
							title="Nhập thông tin">
							<table>
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Tên vai trò:</td>
									<td><input type="text" id="txtTenVaiTro"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Mô tả:</td>
									<td><input type="text" id="txtMoTa" style="width: 100%;" /></td>
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