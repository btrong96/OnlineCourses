<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách loại</title>


<s:set var="chucNang" value="0" />
<s:set var="danhSach_1" value="false" />
<s:set var="them_1" value="false" />
<s:set var="sua_1" value="false" />
<s:set var="xoa_1" value="false" />
<s:set var="baoCao_1" value="false" />

<s:if test='#session.containsKey("chucNang")'>
	<s:set var="chucNang" value='#session["chucNang"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_1")'>
	<s:set var="danhSach_1" value='#session["danhSach_1"]' />
</s:if>
<s:if test='#session.containsKey("them_1")'>
	<s:set var="them_1" value='#session["them_1"]' />
</s:if>
<s:if test='#session.containsKey("sua_1")'>
	<s:set var="sua_1" value='#session["sua_1"]' />
</s:if>
<s:if test='#session.containsKey("xoa_1")'>
	<s:set var="xoa_1" value='#session["xoa_1"]' />
</s:if>

<script type="text/javascript">
	$(document).ready(function() {
		
		
		// goi form them moi
		$("#btnThemMoi").click(function() {
			$("#formLoai").attr("title", "Thêm mới loại");

			// xoa thong tin cu (neu co)
			$("#txtTenLoai").val("");
			$("#txtMoTa").val("");
			$("#txtTenLoai").focus();
			
			$("#txtTenLoai").on("keyup",function(){
				var tenLoai = $("#txtTenLoai").val();
				if(tenLoai.length<1)
				{
					$("#warning1").html(" *Bạn cần nhập tên loại!");
				}
				else{
					$("#warning1").html("");
				}
			});
			$("#txtMoTa").on("keyup",function(){
				var moTa = $("#txtMoTa").val();
				if(moTa.length<1)
				{
					$("#warning2").html(" *Bạn cần nhập mô tả!");
				}
				else{
					$("#warning2").html("");
				}
			});
			// hien thi giao dien them moi thong tin
			$("#formLoai").dialog({
				width : 500,
				modal : true,
				buttons : {
					// button them moi
					"Thêm mới" : function() {
						// xu ly thong tin gui len server
						var ten = $("#txtTenLoai").val();
						var moTa = $("#txtMoTa").val();

						if (ten == null || ten == "") {
							$("#warning1").html("*Bạn cần nhập tên loại");
							return false;
						}
						if (moTa == null || moTa == "") {
							$("#warning2").html("*Bạn cần nhập mô tả");
							return false;
						}

						else {

							$.ajax({
								type : "POST", //Kiểu đưa dữ liệu
								url : "themloai.action", //Hàm sự kiện     
								dataType: 'json',
								data : { //Danh sách các thông tin cần gửi lên theo kiểu json
									tenLoai : ten,
									moTa : moTa
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

	
	
	function thongTinChiTietLoai(id) {
		$.ajax({
			type : "GET",
			url : "laythongtinchitietloai.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.jsonLoai);

				// hien thi giao dien
				$("#txtId").val(d.id);
				$("#txtTenLoai").val(d.tenLoai);
				$("#txtMoTa").val(d.moTa);
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet loai can sua
		thongTinChiTietLoai(id);

		// hien thi popup va xu ly cap nhat
		$("#formLoai").attr("title", "Sửa thông tin loai");
		$("#formLoai").dialog(
				{
					width : 500,
					modal : true,
					buttons : {
						"Cập nhật" : function() {
							// gui thong tin len server
							var id = $("#txtId").val();
							var tenLoai = $("#txtTenLoai").val();
							var moTa = $("#txtMoTa").val();


							if (tenLoai == null || tenLoai == "") {
								$("#warning1").html("*Bạn cần nhập tên loại!");
								return false;
							}
							if (moTa == null || moTa == "") {
								$("#warning2").html("*Bạn cần nhập mô tả!");
								return false;
							} else {

								$.ajax({
									type : "POST",
									url : "capnhatloai.action",
									dataType: 'json',
									data : {
										id : id,
										tenLoai : tenLoai,
										moTa : moTa
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
						url : "xoaloai.action",
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
				<i class="fa fa-th-list"></i> Danh sách loại
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Loại</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_1 == true">
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

                                             
                               <s:actionerror/>                  
                                 

						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 10%;">Tên loại</th>
									<th>Mô tả</th>
									<th style="width: 7%;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_1 == true">
								<tbody>
									<s:iterator var="l" value="lstLoai">
										<tr>
											<td><s:property value="tenLoai" /></td>
											<td><s:property value="moTa" /></td>
											<td><s:if test=" #sua_1 == true">
													<a href="#" onclick="suaThongTin('${l.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_1 == true">
													<a onclick="xoaThongTin('${l.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

						<!-- form them moi -->
						<fieldset id="formLoai" style="display: none;"
							title="Nhập thông tin">
							<table>
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden" id="txtId"
										value="id" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Tên loại *:</td>
									<td><input type="text" id="txtTenLoai"
										style="width: 150%;" /></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning1" style="color:red;"></span></td>
								</tr>
								<tr>
									<td>Mô tả *:</td>
									<td><textarea id="txtMoTa" style="width: 150%;"></textarea></td>
								</tr>
								<tr>
									<td></td>
									<td><span id="warning2" style="color:red;"></span></td>
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