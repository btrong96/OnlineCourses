<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách cấp độ</title>

<s:set var="danhSach_8" value="false" />
<s:set var="them_8" value="false" />
<s:set var="sua_8" value="false" />
<s:set var="xoa_8" value="false" />
<s:set var="baoCao_8" value="false" />

<s:if test='#session.containsKey("danhSach_8")'>
	<s:set var="danhSach_8" value='#session["danhSach_8"]' />
</s:if>
<s:if test='#session.containsKey("them_8")'>
	<s:set var="them_8" value='#session["them_8"]' />
</s:if>
<s:if test='#session.containsKey("sua_8")'>
	<s:set var="sua_8" value='#session["sua_8"]' />
</s:if>
<s:if test='#session.containsKey("xoa_8")'>
	<s:set var="xoa_8" value='#session["xoa_8"]' />
</s:if>


<script type="text/javascript">
	$(document).ready(function() {

		//Gọi form thêm mới
		$("#btnThemMoi").click(function() {
			//alert("Hello");
			$("#formcapdo").attr("title", "Thêm mới thông tin cấp độ");
			//Xoá thông tin cũ đi nếu có
			$("#txtIdCapDo").val("");
			$("#txtTenCapDo").val("");
			$("#txtMoTa").val("");
		
			$("#txtIdCapDo").focus();

			//Hiển thị giao diện cập nhật sửa thông tin
			$("#formcapdo").dialog({

				width : 500,
				modal : true,
				buttons : {
					"Cập nhật" : function() {

						//Xử lý để đưa thông tin lên server				
						var tencapdo = $("#txtTenCapDo").val();
						var mota = $("#txtMoTa").val();
		
						$.ajax({
							type : "POST",//Kiểu đưa dữ liệu
							url : "themCapDo.action",//Hàm sự kiện
							dataType: 'json',
							data : {//Danh sách các thông tin cần gửi lên theo kiểu json																
								//       		id : ma,
								tenCapDo : tencapdo,
								moTa : mota,						
							},
							success : function(result) {
								alert(result.kq);

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
	function suaThongTin(idCapDo) {
		//Lấy thông tin chi tiết của chủ đề cần sửa
		thongTinChiTietCapDo(idCapDo);

		//Hiển thị popup và xử lý cập nhật
		$("#formcapdo").attr("title", "Sửa thông tin cấp độ");

		$("#formcapdo").dialog({

			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {

					//Xử lý để đưa thông tin lên server
					var ma = $("#txtIdCapDo").val();
					var tencapdo = $("#txtTenCapDo").val();
					var mota = $("#txtMoTa").val();					

					$.ajax({
						type : "POST",
						url : "capNhatCapDo.action",
						dataType: 'json',
						data : {
							id : ma,
							tenCapDo : tencapdo,
							moTa : mota,
							
						},
						success : function(result) {
							alert(result.kq);

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
	function thongTinChiTietCapDo(idCapDo) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietCapDo.action",
			data : {
				id : idCapDo
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.capDo);

				//alert(d.tenChuDe);
				//Hiển thị lên giao diện
				$("#txtIdCapDo").val(d.id);
				$("#txtTenCapDo").val(d.tenCapDo);
				$("#txtMoTa").val(d.moTa);
				
			}
		});
	}

	/**
	 * Xóa thông tin chủ đề
	 */
	function xoaThongTin(idCapDo) {

		//Hiển thị popup và xử lý cập nhật
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({

			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoaCapDo.action",
						data : {
							id : idCapDo
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
				<i class="fa fa-th-list"></i> Danh sách cấp độ
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Cấp độ</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_8 == true">
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
									<th style="width: 15%;">Tên cấp độ</th>
									<th>Mô tả</th>									
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_8 == true">
								<tbody>
									<s:iterator var="cd" value="lstCapDo">
										<tr>
											<td><s:property value="tenCapDo" /></td>
											<td><s:property value="moTa" /></td>										
											<td><s:if test=" #sua_8 == true">
													<a href="#" onclick="suaThongTin('${cd.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp;<s:if test=" #xoa_8 == true">
													<a onclick="xoaThongTin('${cd.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>
						<!-- Form thêm mới cấp độ  -->
						<fieldset id="formcapdo" style="display: none;"
							title="Nhập thông tin cấp độ">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdCapDo" style="width: 90%;" /></td>
								</tr>
								<tr>
									<td>Tên cấp độ</td>
									<td><input type="text" id="txtTenCapDo"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Mô tả</td>
									<td><textarea id="txtMoTa" style="width: 100%;"></textarea></td>								
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