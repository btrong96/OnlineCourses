<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng tags của struts -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới thông tin bài giảng</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//Hiển thị ngày tạo và ngày cập nhật
						var today = new Date();
						var date = today.getDate() + '/'
								+ (today.getMonth() + 1) + '/'
								+ today.getFullYear();
						$("#txtNgayTao").val(date);
						$("#txtNgayCapNhat").val(date);
						//Gọi form thêm mới
						$("#btnThemMoi").click(function() {
							$("#txtNgayDang").val(date);
							$("#chbDaDuyet").is(":checked");
						});

						//Gọi form sửa
						$("#suaThongTin").click(
								function() {

									var today = new Date();
									var dateCapNhat = today.getDate() + '/'
											+ (today.getMonth() + 1) + '/'
											+ today.getFullYear();
									var dateDang = today.getDate() + '/'
											+ (today.getMonth() + 1) + '/'
											+ today.getFullYear();
									$("#txtNgayCapNhat").val(dateCapNhat);
									$("#txtNgayDang").val(dateDang);
								});

						//Kiểm tra báo valid
						$("#themMoi")
								.on(
										"click",
										function() {
											var thuTu = document.forms["myForm"]["objBaiGiang.thuTu"].value;
											var tenBaiGiang = document.forms["myForm"]["objBaiGiang.tenBaiGiang"].value;
											var thoiLuong = document.forms["myForm"]["objBaiGiang.thoiLuong"].value;
											var nameCode = document.forms["myForm"]["objBaiGiang.nameCode"].value;
											var moTa = document.forms["myForm"]["objBaiGiang.moTa"].value;
											var ngayDang = document.forms["myForm"]["objBaiGiang.ngayDang"].value;
											if (thuTu == "" || thuTu == null) {
												$("#warning1")
														.html(
																" *Bạn cần nhập thứ tự");
											}
											if (tenBaiGiang == ""
													|| tenBaiGiang == null) {
												$("#warning2")
														.html(
																" *Bạn cần nhập tên bài giảng");
											}
											if (thoiLuong == ""
													|| thoiLuong == null) {
												$("#warning3")
														.html(
																" *Bạn cần nhập thời lượng");
											}
											if (moTa == "" || moTa == null) {
												$("#warning4").html(
														" *Bạn cần nhập mô tả");
											}
											if (nameCode == ""
													|| nameCode == null) {
												$("#warning5")
														.html(
																" *Bạn cần nhập code video");

											}

											if (ngayDang == ""
													|| ngayDang == null) {
												$("#warning6")
														.html(
																" *Bạn cần chọn ngày đăng");

											}

										});

						$("#txtThuTu").on("keyup", function() {
							var thuTu = $("#txtThuTu").val();
							if (thuTu.length < 1) {
								$("#warning1").html(" *Bạn cần nhập thứ tự");
							} else {
								$("#warning1").html("");
							}
						});

						$("#txtTenBaiGiang")
								.on(
										"keyup",
										function() {
											var tenBaiGiang = $(
													"#txtTenBaiGiang").val();
											if (tenBaiGiang.length < 1) {
												$("#warning2")
														.html(
																" *Bạn cần nhập tên bài giảng");
											} else {
												$("#warning2").html("");
											}
										});

						$("#txtThoiLuong").on(
								"keyup",
								function() {
									var thoiLuong = $("#txtThoiLuong").val();
									if (thoiLuong.length < 1) {
										$("#warning3").html(
												" *Bạn cần nhập thời lượng");
									} else {
										$("#warning3").html("");
									}
								});

						$("#txtMoTa").on("keyup", function() {
							var moTa = $("#txtMoTa").val();
							if (moTa.length < 1) {
								$("#warning4").html(" *Bạn cần nhập mô tả");
							} else {
								$("#warning4").html("");
							}
						});

						$("#txtCodeName").on("click", function() {

							$("#warning5").html("");
						});
						$("#txtNgayDang").on("click", function() {
							$("#warning6").html("");
						});

					});

	function validateForm() {
		var thuTu = document.forms["myForm"]["objBaiGiang.thuTu"].value;
		var tenBaiGiang = document.forms["myForm"]["objBaiGiang.tenBaiGiang"].value;
		var ngayTao = document.forms["myForm"]["objBaiGiang.ngayTao"].value;
		var thoiLuong = document.forms["myForm"]["objBaiGiang.thoiLuong"].value;
		var moTa = document.forms["myForm"]["objBaiGiang.moTa"].value;
		var ngayDang = document.forms["myForm"]["objBaiGiang.ngayDang"].value;

		if (thuTu == "" || thuTu == null || tenBaiGiang == ""
				|| tenBaiGiang == null || ngayTao == "" || ngayTao == null
				|| thoiLuong == "" || thoiLuong == null || moTa == ""
				|| moTa == null || ngayDang == "" || ngayDang == null) {
			return false;
		}
	}
	$(function() {
		$("#txtNgayDang").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>

</head>
<body>

	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i>Nhập thông tin bài giảng
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Khóa học trực tuyến</li>
			<li class="breadcrumb-item active"><a href="#">Bài giảng</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<s:form action="themMoiBaiGiang" method="POST"
					enctype="multipart/form-data" onsubmit="return validateForm()"
					name="myForm" theme="simple">
					<div class="tile-body">

						<div class="form-group">
							<label class="control-label">Thứ tự</label>
							<s:textfield id="txtThuTu" name="objBaiGiang.thuTu"
								value="%{objBaiGiang.thuTu}" cssStyle="width:98%;"
								cssClass="form-control" />
							<span id="warning1" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label class="control-label">Tên bài giảng</label>
							<s:textfield id="txtTenBaiGiang" name="objBaiGiang.tenBaiGiang"
								value="%{objBaiGiang.tenBaiGiang}" cssStyle="width:98%;"
								cssClass="form-control" />
							<s:hidden name="baiGiangId" value="%{objBaiGiang.id}"
								cssClass="form-control" />
							<span id="warning2" style="color: red;"></span>
						</div>
						<s:actionerror />

						<div class="form-group">
							<label class="control-label">Mô tả</label>
							<s:textarea id="txtMoTa" name="objBaiGiang.moTa"
								value="%{objBaiGiang.moTa}" rows="5" cssStyle="width:98%;"
								cssClass="form-control" />
							<span id="warning4" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label class="control-label">Chọn ảnh</label>
							<s:file name="fileUpload" label="Chọn 1 file cần upload"
								size="40" />
							<s:property value="fileUploadFileName" />
							<s:property value="fileUploadContentType" />
							<br> <img alt="Bài giảng trực tuyến"
								src="images/<s:property value="objBaiGiang.anhDaiDien" />"
								width="150" height="150">
							<s:hidden name="objBaiGiang.anhDaiDien"
								value="%{objBaiGiang.anhDaiDien}" cssClass="" />
						</div>
						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Name Code Video</label>
								<s:textfield id="txtCodeName" name="objBaiGiang.nameCode"
									value="%{objBaiGiang.nameCode}" cssStyle="width:98%;"
									cssClass="form-control" />
								<span id="warning5" style="color: red;"></span>
							</div>

							<div class="col-md-6">
								<label class="control-label">Thời lượng</label>
								<s:textfield id="txtThoiLuong" name="objBaiGiang.thoiLuong"
									value="%{objBaiGiang.thoiLuong}" cssStyle="width:98%;"
									cssClass="form-control" />
								<span id="warning3" style="color: red;"></span>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Giảng viên</label>
								<s:select cssClass="form-control" list="lstGiangVien"
									name="objBaiGiang.giangVienId"
									value="%{objBaiGiang.giangVienId}" listKey="id"
									listValue="tenGiangVien">
								</s:select>
							</div>
							<div class="col-md-6">
								<label class="control-label">Khóa học</label>
								<s:select cssClass="form-control" list="lstKhoaHoc"
									name="objBaiGiang.khoaHocId" value="%{objBaiGiang.khoaHocId}"
									listKey="id" listValue="tenKhoaHoc">
								</s:select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Ngày tạo</label>

								<s:textfield name="objBaiGiang.ngayTao" class="date"
									id="txtNgayTao" value="%{objBaiGiang.ngayTao}"
									cssClass="form-control" />
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">Ngày cập nhật</label>
									<s:textfield name="objBaiGiang.ngayCapNhat" id="txtNgayCapNhat"
										readonly="readonly" value="%{objBaiGiang.ngayCapNhat}"
										cssClass="form-control" />
								</div>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Ngày đăng</label>

								<s:textfield name="objBaiGiang.ngayDang" id="txtNgayDang"
									readonly="readonly" value="%{objBaiGiang.ngayDang}"
									cssClass="form-control" />
								<span id="warning6" style="color: red;"></span>
							</div>
							<div class="col-md-3">
								<label class="control-label">Đã duyệt</label>
								<s:checkbox name="objBaiGiang.daDuyet" id="chbDaDuyet"
									value="%{objBaiGiang.daDuyet}" cssClass="form-control" />
							</div>
							<div class="col-md-3">

								<label class="control-label">Miễn phí </label>
								<s:checkbox name="objBaiGiang.mienPhi" id="chbMienPhi"
									value="%{objBaiGiang.mienPhi}" cssClass="form-control" />

							</div>
						</div>
					</div>
					<div class="title-footer">
						<s:submit id="themMoi" value="Cập nhật" cssClass="btn btn-primary" />
						&nbsp; <a href='<s:url action="qlkhoahoc.action"/>'>Trở lại</a>

					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>