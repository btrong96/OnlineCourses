<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách chức năng</title>

<s:set var="danhSach_14" value="false" />
<s:set var="them_14" value="false" />
<s:set var="sua_14" value="false" />
<s:set var="xoa_14" value="false" />
<s:set var="baoCao_14" value="false" />

<s:if test='#session.containsKey("danhSach_14")'>
	<s:set var="danhSach_14" value='#session["danhSach_14"]' />
</s:if>




<script type="text/javascript">
	$(document).ready(function() {

		//Gọi form thêm mới
		$("#btnThemMoi").click(function() {
			//alert("Hello");
			$("#formchucnang").attr("title", "Thêm mới thông tin chức năng");
			//Xoá thông tin cũ đi nếu có
			$("#txtIdChucNang").val("");
			$("#txtTenChucNang").val("");
			$("#txtMoTa").val("");
	
			$("#txtIdChucNang").focus();

			//Hiển thị giao diện cập nhật sửa thông tin
			$("#formchucnang").dialog({

				width : 500,
				modal : true,
				buttons : {
					"Cập nhật" : function() {

						//Xử lý để đưa thông tin lên server
						//		var ma = $("#txtIdGiangVien").val();
						var tenchucnang = $("#txtTenChucNang").val();
						var mota = $("#txtMoTa").val();
				

						$.ajax({
							type : "POST",//Kiểu đưa dữ liệu
							url : "themchucnang.action",//Hàm sự kiện
							data : {//Danh sách các thông tin cần gửi lên theo kiểu json																
								//       		id : ma,
								tenChucNang : tenchucnang,
								moTa : mota,
							
							},
							success : function(result) {

								//Đưa ra thông báo
								//alert(result.kq);

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
		}); //end them moi

	});

	/*
	 * Hàm sửa thông tin chủ đề theo mã
	 */
	function suaThongTin(idChucNang) {
		//Lấy thông tin chi tiết của chủ đề cần sửa
		thongTinChiTietChucNang(idChucNang);

		//Hiển thị popup và xử lý cập nhật
		$("#formchucnang").attr("title", "Sửa thông tin chức năng");

		$("#formchucnang").dialog({

			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {

					//Xử lý để đưa thông tin lên server
					var ma = $("#txtIdChucNang").val();
					var tenchucnang = $("#txtTenChucNang").val();
					var mota = $("#txtMoTa").val();
	
					$.ajax({
						type : "POST",
						url : "capnhatchucnang.action",
						data : {
							id : ma,
							tenChucNang : tenchucnang,
							moTa : mota,
							
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
	function thongTinChiTietChucNang(idChucNang) {
		$.ajax({
			type : "GET",
			url : "laythongtinchitietchucnang.action",
			data : {
				id : idChucNang
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.jsonChucNang);

				//alert(d.tenChuDe);
				//Hiển thị lên giao diện
				$("#txtIdChucNang").val(d.id);
				$("#txtTenChucNang").val(d.tenChucNang);
				$("#txtMoTa").val(d.moTa);
				
			}
		});
	}

	/**
	 * Xóa thông tin chủ đề
	 */
	function xoaThongTin(idChucNang) {

		//Hiển thị popup và xử lý cập nhật
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({

			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoachucnang.action",
						data : {
							id : idChucNang
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
				<i class="fa fa-th-list"></i> Danh sách chức năng
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Chức năng</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_14 == true">
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
									<th style="width: 15%;">Tên chức năng</th>
									<th>Mô Tả</th>									
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_14 == true">
								<tbody>
									<s:iterator var="cn" value="lstChucNang">
										<tr>											
											<td><s:property value="tenChucNang" /></td>
											<td><s:property value="moTa" /></td>							
											<td><s:if test=" #sua_14 == true">
													<a href="#" onclick="suaThongTin('${cn.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp;<s:if test=" #xoa_14 == true">
													<a onclick="xoaThongTin('${cn.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới chức năng -->
						<fieldset id="formchucnang" style="display: none;"
							title="Nhập thông tin chức năng">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdChucNang" style="width: 90%;" /></td>
								</tr>
								<tr>
									<td>Tên Chức Năng</td>
									<td><input type="text" id="txtTenChucNang"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Mô Tả</td>
									<td><input type="text" id="txtMoTa"
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