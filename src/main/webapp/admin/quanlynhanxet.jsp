<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhận xét</title>


<s:set var="danhSach_12" value="false" />
<s:set var="them_12" value="false" />
<s:set var="sua_12" value="false" />
<s:set var="xoa_12" value="false" />
<s:set var="baoCao_12" value="false" />


<s:if test='#session.containsKey("danhSach_12")'>
	<s:set var="danhSach_12" value='#session["danhSach_12"]' />
</s:if>
<s:if test='#session.containsKey("them_12")'>
	<s:set var="them_12" value='#session["them_12"]' />
</s:if>
<s:if test='#session.containsKey("sua_12")'>
	<s:set var="sua_12" value='#session["sua_12"]' />
</s:if>
<s:if test='#session.containsKey("xoa_12")'>
	<s:set var="xoa_12" value='#session["xoa_12"]' />
</s:if>

<script type="text/javascript">
	$(document).ready(function() {
		// goi form them moi
		$("#btnThemMoi").click(function() {
			$("#formNhanXet").attr("title", "Thêm mới nhận xét");
			var today = new Date();
			var date = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();
			// xoa thong tin cu (neu co)
			
			$("#txtThoiGianTao").val(date);
			$("#txtThoiGianCapNhat").val("");
			$("#txtNoiDung").val("");

			$("#txtTenBaiGiang").focus();

			// hien thi giao dien them moi thong tin
			$("#formNhanXet").dialog({
				width : 500,
				modal : true,
				buttons : {
					// button them moi
					"Thêm mới" : function() {
						// xu ly thong tin gui len server			
						var baigiang_id = $("#cboBaiGiang").val();
						var nguoidung_id = $("#cboNguoiDung").val();
						var thoigiantao = $("#txtThoiGianTao").val();
						var thoigiancapnhat = $("#txtThoiGianCapNhat").val();
						var noidung = $("#txtNoiDung").val();

						$.ajax({
							type : "POST", //Kiểu đưa dữ liệu
							url : "themNhanXet.action", //Hàm sự kiện                    
							data : { //Danh sách các thông tin cần gửi lên theo kiểu json
								
								baiGiangId : baigiang_id,
								nguoiDungId : nguoidung_id,
								thoiGianTao : thoigiantao,
								thoiGianCapNhat : thoigiancapnhat,
								noiDung : noidung
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

	function thongTinChiTietNhanXet(id) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietNhanXet.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.nhanXet);

				var DateT = new Date(d.thoiGianTao);
				var dateT = DateT.getDate()+'/'+(DateT.getMonth()+1)+'/'+DateT.getFullYear();
				var DateCN = new Date();
				var dateCN = DateCN.getDate()+'/'+(DateCN.getMonth()+1)+'/'+DateCN.getFullYear();
				
				// hien thi giao dien
				$("#txtId").val(d.id);
				$("#cboBaiGiang").val(d.baiGiangId);
				$("#cboNguoiDung").val(d.nguoiDungId);
				$("#txtThoiGianTao").val(dateT);
				$("#txtThoiGianCapNhat").val(dateCN);
				$("#txtNoiDung").val(d.noiDung);
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet loai can sua
		thongTinChiTietNhanXet(id);

		// hien thi popup va xu ly cap nhat
		$("#formNhanXet").attr("title", "Sửa thông tin nhận xét");
		$("#formNhanXet").dialog({
			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {
					// gui thong tin len server
					
					var id = $("#txtId").val();
					var baigiang_id = $("#cboBaiGiang").val();
					var nguoidung_id = $("#cboNguoiDung").val();
					var thoigiantao = $("#txtThoiGianTao").val();
					var thoigiancapnhat = $("#txtThoiGianCapNhat").val();
					var noidung = $("#txtNoiDung").val();		

					$.ajax({
						type : "POST",
						url : "capNhatNhanXet.action",
						data : {
							id : id,						
							baiGiangId : baigiang_id,
							nguoiDungId : nguoidung_id,
							thoiGianTao : thoigiantao,
							thoiGianCapNhat : thoigiancapnhat,
							noiDung : noidung						
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
						url : "xoaNhanXet.action",
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
				<i class="fa fa-th-list"></i> Danh sách nhận xét
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Nhận xét</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_12 == true">
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
					<s:form action="timKiemNhanXet" method="GET" theme="simple">
					<fieldset>
							<legend>Nhập thông tin tìm kiếm Nhận xét</legend>
							<table class="table table-striped">
								<tr>
						            <td>Bài giảng:</td>
									<td><s:select list="lstBaiGiang" name="maBaiGiangTimKiem"
											value="%{maBaiGiangTimKiem}" headerKey=""
											headerValue="--Chọn bài giảng--" listKey="id"
											listValue="tenBaiGiang" class="form-control" /></td>
									<td>Người dùng:</td>
									<td><s:select list="lstNguoiDung"
											name="maNguoiDungTimKiem" value="%{maNguoiDungTimKiem}"
											headerKey="" headerValue="--Chọn người dùng--" listKey="id"
											listValue="hoTen" class="form-control" /></td>
											
									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>

						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th>Tên bài giảng</th>
									<th>Tên người dùng</th>
									<th>Thời gian tạo</th>
									<th>Thời gian cập nhật</th>
									<th style="width: 50%;">Nội Dung</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_12 == true">
								<tbody>
									<s:iterator var="nx" value="lstNhanXet">
										<tr>
											<td><s:property value="tenBaiGiang" /></td>
											<td><s:property value="tenNguoiDung" /></td>
											<td><s:property value="thoiGianTao" /></td>
											<td><s:property value="thoiGianCapNhat" /></td>
											<td><s:property value="noiDung" /></td>
											<td><s:if test=" #sua_12 == true">
													<a href="#" onclick="suaThongTin('${nx.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_12 == true">
													<a onclick="xoaThongTin('${nx.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

						<!-- form them moi -->
						<fieldset id="formNhanXet" style="display: none;"
							title="Nhập thông tin">
							<table>
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Tên bài giảng:</td>
									<td><s:select list="lstBaiGiang" headerKey=""
											headerValue="--Chọn bài giảng--" id="cboBaiGiang"
											listKey="id" listValue="tenBaiGiang" /></td>
								</tr>
								<tr>
									<td>Tên người dùng:</td>
									<td><s:select list="lstNguoiDung" headerKey=""
											headerValue="--Chọn người dùng--" id="cboNguoiDung"
											listKey="id" listValue="hoTen" /></td>
								</tr>
								<tr>
									<td>Thời gian tạo:</td>
									<td><input type="text" id="txtThoiGianTao"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Thời gian cập nhật:</td>
									<td><input type="text" id="txtThoiGianCapNhat"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Nội dung:</td>
									<td><input type="text" id="txtNoiDung"
										style="width: 100%;" /></td>
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