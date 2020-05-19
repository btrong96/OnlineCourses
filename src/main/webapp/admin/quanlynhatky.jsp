<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Nhật Ký</title>

<s:set var="danhSach_13" value="false" />
<s:set var="xoa_13" value="false" />
<s:set var="baoCao_13" value="false" />

<s:if test='#session.containsKey("danhSach_13")'>
	<s:set var="danhSach_13" value='#session["danhSach_13"]' />
</s:if>
<s:if test='#session.containsKey("xoa_13")'>
	<s:set var="xoa_13" value='#session["xoa_13"]' />
</s:if>


<script type="text/javascript">
	function checkall() {
		var check = document.getElementsByClassName('text');
		for (var i = 0; i < check.length; i++) {
			check[i].checked = true;
		}
	}
	function uncheckall() {
		var bocheck = document.getElementsByClassName('text');
		for (var i = 0; i < bocheck.length; i++) {
			bocheck[i].checked = false;
		}
	}
	function xoaCheckBox() {
		var checkBox = $('input[type = "checkbox"]:checked');
		if (checkBox.length > 0) {
			$('#kq').html(checkBox.length + " nhật ký được chọn");
			checkBox.each(function() {
				$('#kq').append($(this).val() + "\t");
			});

			$("#thongbaoxoa").attr("title", "Xóa thông tin");
			$("#thongbaoxoa").dialog({
				width : 400,
				modal : true,
				buttons : {
					"Xóa" : function() {
						checkBox.each(function() {
							var t = $(this).val();

							$.ajax({
								type : "GET",
								url : "xoaNhatKy.action",
								data : {
									id : t
								},
								success : function(result) {
									// reload lai trang
									window.location.reload();
								}
							});
						});
					},

					"Hủy bỏ" : function() {
						$(this).dialog("close");
					}
				}
			});

		} else {
			$('#kq').text("Không có nhật ký nào được chọn");
		}
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
						url : "xoaNhatKy.action",
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
				<i class="fa fa-th-list"></i> Danh sách Nhật Ký
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Nhật Ký</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<div class="col-md-12">

			<span class="btn btn-primary"><a
				href='<s:url action="qlnhatky"/>' class="btn btn-primary">DANH
					SÁCH</a></span>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form action="timKiemNhatKy" method="GET" theme="simple">
						<fieldset>
							<legend>Nhập thông tin Nhật Ký</legend>
							<table class="table table-striped">
								<tr>
									<td>Ngày:</td>
									<td><s:textfield name="ngayNhatKy" class="form-control"
											value="%{ngayNhatKy}" /></td>

									<td>Tài Khoản:</td>
									<td><s:select list="lstNguoiDung"
											name="maNguoiDungTimKiem" value="%{maNguoiDungTimKiem}"
											headerKey="" headerValue="--Chọn tài khoản--" listKey="id"
											listValue="taiKhoan" class="form-control" /></td>

									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>

					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="checkall()">  <a class="nav-link" href="#"> CHECK ALL </a></button>	
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="uncheckall()">  <a class="nav-link" href="#"> UNCHECK ALL </a></button>
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="xoaCheckBox()">  <a class="nav-link" href="#"> XÓA NHIỀU </a></button>
                    <div id="kq"></div>	


						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 2%"></th>
									<th style="width: 10%;">UserName</th>
									<th>Chức năng</th>
									<th>Ngày</th>
									<th style="width: 500px;">Hoạt động</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_13 == true">
								<tbody>
									<s:iterator var="nk" value="lstNhatKy">
										<tr class="checkbox">
											<td><input id="checkBox" type="checkbox" class="text"
												value="${nk.id}"></td>
											<td><s:property value="userName" /></td>
											<td><s:property value="chucNang" /></td>
											<td><s:property value="ngay" /></td>
											<td><s:property value="hoatDong" /></td>
											<td><s:if test=" #xoa_13 == true">
													<a onclick="xoaThongTin('${nk.id}');" href='#'><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

						<div id="thongbaoxoa" style="display: none;">Bạn có chắc
							muốn xóa thông tin này ?</div>
					</s:form>
										
				</div>
			</div>
		</div>
	</div>
</body>
</html>