<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng tags của struts -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$("#themMoi")
								.on(
										"click",
										function() {
											var tenGiangVien = document.forms["myForm"]["objGiangVien.tenGiangVien"].value;
											var chucDanh = document.forms["myForm"]["objGiangVien.chucDanh"].value;
											var chuyenMon = document.forms["myForm"]["objGiangVien.chuyenMon"].value;
											if (tenGiangVien == ""
													|| tenGiangVien == null) {
												$("#warning1")
														.html(
																"*Bạn cần nhập tên giảng viên");
											}
											if (chucDanh == ""
													|| chucDanh == null) {
												$("#warning2")
														.html(
																"*Bạn cần nhập chức danh");
											}
											if (chuyenMon == ""
													|| chuyenMon == null) {
												$("#warning3")
														.html(
																"*Bạn cần nhập chuyên môn");
											}
										});

						$("#txtTenGiangVien").on(
								"keyup",
								function() {
									var tenGiangVien = $("#txtTenGiangVien").val();
									if (tenGiangVien.length < 1) {
										$("#warning1").html(
												" *Bạn cần nhập tên giảng viên");
									} else {
										$("#warning1").html("");
									}
								});
						$("#txtChucDanh").on("keyup", function() {
							var chucDanh = $("#txtChucDanh").val();
							if (chucDanh.length < 1) {
								$("#warning2").html(" *Bạn cần nhập chức danh");
							} else {
								$("#warning2").html("");
							}
						});
						
						$("#txtChuyenMon").on("keyup", function() {
							var chuyenMon = $("#txtChuyenMon").val();
							if (chuyenMon.length < 1) {
								$("#warning3").html(" *Bạn cần nhập chuyên môn");
							} else {
								$("#warning3").html("");
							}
						});

					});

	function validateForm() {

		var tenGiangVien = document.forms["myForm"]["objGiangVien.tenGiangVien"].value;
		var chucDanh = document.forms["myForm"]["objGiangVien.chucDanh"].value;
		var chuyenMon = document.forms["myForm"]["objGiangVien.chuyenMon"].value;

		if (tenGiangVien == "" || tenGiangVien == null) {
			return false;
		} else if (chucDanh == "" || chucDanh == null) {
			return false;
		} else if (chuyenMon == "" || chuyenMon == null) {
			return false;
		} else {
			alert("Cập nhật giảng viên thành công!");
		}
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới thông tin giảng viên</title>
</head>
<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i>Nhập thông tin giảng viên
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Giảng viên giảng dạy</li>
			<li class="breadcrumb-item active"><a href="#">Giảng viên</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<s:form action="themMoiGiangVien" method="POST"
					enctype="multipart/form-data" onsubmit="return validateForm()"
					name="myForm" theme="simple">
					<div class="tile-body">
						<div class="form-group">
							<label class="control-label">Tên giảng viên</label>
							<s:textfield id="txtTenGiangVien" name="objGiangVien.tenGiangVien"
								value="%{objGiangVien.tenGiangVien}" cssStyle="width:98%;" />
							<s:hidden name="giangVienId" value="%{objGiangVien.id}"
								cssClass="form-control" />
							<span id="warning1" style="color: red;"></span>
						</div>

						<div class="form-group">
							<label class="control-label">Ảnh đại diện</label>
							<s:file name="fileUpload" label="Chọn 1 file cần upload"
								size="40" />
							<s:property value="fileUploadFileName" />
							<s:property value="fileUploadContentType" />
							<br> <img alt="Khóa học trực tuyến"
								src="images/<s:property value="objGiangVien.anhDaiDien" />"
								width="150" height="150">
							<s:hidden name="objGiangVien.anhDaiDien"
								value="%{objGiangVien.anhDaiDien}" cssClass="" />
						</div>
						<div class="form-group">
							<label class="control-label">Chức danh</label>
							<s:textfield id="txtChucDanh" name="objGiangVien.chucDanh"
								value="%{objGiangVien.chucDanh}" cssClass="form-control" />
							<span id="warning2" style="color: red;"></span>
						</div>
						<div class="form-group">
							<label class="control-label">Chuyên môn</label>
							<s:textfield id="txtChuyenMon" name="objGiangVien.chuyenMon"
								value="%{objGiangVien.chuyenMon}" cssClass="form-control" />
							<span id="warning3" style="color: red;"></span>
						</div>
					</div>
					<div class="title-footer">
						<s:submit id="themMoi" value="Cập nhật" cssClass="btn btn-primary" />
						&nbsp; <a href='<s:url action="qlgiangvien.action"/>'>Trở lại</a>
						<s:actionerror />
					</div>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>