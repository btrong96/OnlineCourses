<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách phân quyền</title>

<s:set var="danhSach_10" value="false" />
<s:set var="them_10" value="false" />
<s:set var="sua_10" value="false" />
<s:set var="xoa_10" value="false" />
<s:set var="baoCao_10" value="false" />


<s:if test='#session.containsKey("danhSach_10")'>
	<s:set var="danhSach_10" value='#session["danhSach_10"]' />
</s:if>
<s:if test='#session.containsKey("them_10")'>
	<s:set var="them_10" value='#session["them_10"]' />
</s:if>
<s:if test='#session.containsKey("sua_10")'>
	<s:set var="sua_10" value='#session["sua_10"]' />
</s:if>
<s:if test='#session.containsKey("xoa_10")'>
	<s:set var="xoa_10" value='#session["xoa_10"]' />
</s:if>

<script type="text/javascript">
	$(document).ready(function() {

		//Gọi form thêm mới
		$("#btnThemMoi").click(function() {
			//alert("Hello");
			$("#formphanquyen").attr("title", "Thêm mới thông tin phân quyền");
			//Xoá thông tin cũ đi nếu có
			$("#txtIdPhanQuyen").val("");
			$("#cboVaiTro").val("");
			$("#cboChucNang").val("");

			$("#txtIdPhanQuyen").focus();

			//Hiển thị giao diện cập nhật sửa thông tin
			$("#formphanquyen").dialog({

				width : 500,
				modal : true,
				buttons : {
					"Cập nhật" : function() {

						//Xử lý để đưa thông tin lên server

						var vaitro = $("#cboVaiTro").val();
						var chucnang = $("#cboChucNang").val();
						var danhsach = $("#chbDanhSach").is(":checked");
						var them = $("#chbThem").is(":checked");
						var sua = $("#chbSua").is(":checked");
						var xoa = $("#chbXoa").is(":checked");
						var baocao = $("#chbBaoCao").is(":checked");

						$.ajax({
							type : "POST",//Kiểu đưa dữ liệu
							url : "themPhanQuyen.action",//Hàm sự kiện
							data : {//Danh sách các thông tin cần gửi lên theo kiểu json																

								vaitro_id : vaitro,
								chucnang_id : chucnang,
								danhSach : danhsach,
								them : them,
								sua : sua,
								xoa : xoa,
								baoCao : baocao

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
	function suaThongTin(idPhanQuyen) {
		//Lấy thông tin chi tiết của chủ đề cần sửa
		thongTinChiTietPhanQuyen(idPhanQuyen);

		//Hiển thị popup và xử lý cập nhật
		$("#formphanquyen").attr("title", "Sửa thông tin phân quyền");

		$("#formphanquyen").dialog({

			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {

					//Xử lý để đưa thông tin lên server
					var ma = $("#txtIdPhanQuyen").val();
					var vaitro = $("#cboVaiTro").val();
					var chucnang = $("#cboChucNang").val();
					var danhsach = $("#chbDanhSach").is(":checked");
					var them = $("#chbThem").is(":checked");
					var sua = $("#chbSua").is(":checked");
					var xoa = $("#chbXoa").is(":checked");
					var baocao = $("#chbBaoCao").is(":checked");

					$.ajax({
						type : "POST",
						url : "capNhatPhanQuyen.action",
						data : {
							id : ma,
							vaitro_id : vaitro,
							chucnang_id : chucnang,
							danhSach : danhsach,
							them : them,
							sua : sua,
							xoa : xoa,
							baoCao : baocao
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
	function thongTinChiTietPhanQuyen(idPhanQuyen) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietPhanQuyen.action",
			data : {
				id : idPhanQuyen
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.phanQuyen);

				//alert(d.tenChuDe);
				//Hiển thị lên giao diện
				$("#txtIdPhanQuyen").val(d.id);
				$("#cboVaiTro").val(d.vaitro_id);
				$("#cboChucNang").val(d.chucnang_id);
				$("#chbDanhSach").attr('checked', d.danhSach);
				$("#chbThem").attr('checked', d.them);
				$("#chbSua").attr('checked', d.sua);
				$("#chbXoa").attr('checked', d.xoa);
				$("#chbBaoCao").attr('checked', d.baoCao);

			}
		});
	}

	/**
	 * Xóa thông tin chủ đề
	 */
	function xoaThongTin(idPhanQuyen) {

		//Hiển thị popup và xử lý cập nhật
		$("#thongbaoxoa").attr("title", "Xóa thông tin");
		$("#thongbaoxoa").dialog({

			width : 400,
			modal : true,
			buttons : {
				"Xóa" : function() {
					$.ajax({
						type : "GET",
						url : "xoaPhanQuyen.action",
						data : {
							id : idPhanQuyen
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
				<i class="fa fa-th-list"></i> Danh sách phân quyền
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Phân quyền</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_10 == true">
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
					<s:form action="timKiemPhanQuyen" method="GET" theme="simple">					
					<fieldset>
							<legend>Chọn thông tin phân quyền</legend>
							<table class="table table-striped">
								<tr>									
									<td>Vai trò:</td>
									<td><s:select list="lstVaiTro" name="maVaiTroTimKiem"
											value="%{maVaiTroTimKiem}" headerKey=""
											headerValue="--Chọn vai trò--" listKey="id"
											listValue="tenVaiTro" class="form-control" /></td>
									<td>Chức năng:</td>
									<td><s:select list="lstChucNang" name="maChucNangTimKiem"
											value="%{maChucNangTimKiem}" headerKey=""
											headerValue="--Chọn chức năng--" listKey="id"
											listValue="tenChucNang" class="form-control" /></td>									
									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>										
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 15%;">Vai trò</th>
									<th>Chức năng</th>
									<th>Xem danh sách</th>
									<th>Thêm</th>
									<th>Sửa</th>
									<th>Xóa</th>
									<th>Báo cáo</th>
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_10 == true">
								<tbody>								
									<s:iterator var="pq" value="lstPhanQuyen">
									<tr>									
										<td><s:property value="vaitro_id" /></td> 
								<!--        <td><s:property value="tenVaiTro" /></td>  -->
								<!--        <s:if test=" #vaiTro == 1">
								            <td><s:property value="tenVaiTro_1" /></td>										            					          
							          </s:if>
							           <s:if test=" #vaiTro == 2">
								            <td><s:property value="tenVaiTro_2" /></td>
							          </s:if>
							           <s:if test=" #vaiTro == 3">
								            <td><s:property value="tenVaiTro_3" /></td>
							          </s:if>  -->
											<td><s:property value="chucnang_id" /></td>
											<td><s:property value="danhSach" /></td>
											<td><s:property value="them" /></td>
											<td><s:property value="sua" /></td>
											<td><s:property value="xoa" /></td>
											<td><s:property value="baoCao" /></td>
											<td><s:if test=" #sua_10 == true">
													<a href="#" onclick="suaThongTin('${pq.id}')"><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp;<s:if test=" #xoa_10 == true">
													<a onclick="xoaThongTin('${pq.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

						<!-- Form thêm mới phân quyền  -->
						<fieldset id="formphanquyen" style="display: none;"
							title="Nhập thông tin phân quyền">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdPhanQuyen" style="width: 90%;" /></td>
								</tr>						
								
								<tr>
									<td>Vai trò</td>
									<td><s:select list="lstVaiTro" headerKey=""
											headerValue="--Chọn vai trò--" id="cboVaiTro"
											listKey="id" listValue="tenVaiTro" /></td>
								</tr>
								
								<tr>
									<td>Chức năng</td>
									<td><s:select list="lstChucNang" headerKey=""
											headerValue="--Chọn chắc năng--" id="cboChucNang"
											listKey="id" listValue="tenChucNang" /></td>
								</tr>
							
								<tr>
									<td>Xem danh sách</td>
									<td><input type="checkbox" id="chbDanhSach" value="true" /></td>
								</tr>
								<tr>
									<td>Thêm</td>
									<td><input type="checkbox" id="chbThem" value="true" /></td>
								</tr>
								<tr>
									<td>Sửa</td>
									<td><input type="checkbox" id="chbSua" value="true" /></td>
								</tr>
								<tr>
									<td>Xóa</td>
									<td><input type="checkbox" id="chbXoa" value="true" /></td>
								</tr>
								<tr>
									<td>Báo cáo</td>
									<td><input type="checkbox" id="chbBaoCao" value="true" /></td>
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