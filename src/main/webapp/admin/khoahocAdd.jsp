<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng tags của struts -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới thông tin khóa học</title>

<script type="text/javascript">
	$(document).ready(
			function() {

				var today = new Date();
				var date = today.getDate() + '/' + (today.getMonth() + 1) + '/'
						+ today.getFullYear();
				$("#txtNgayXuatBan").val(date);
				$("#txtNgayCapNhat").val(date);
				//Gọi form thêm mới
				$("#btnThemMoi").click(function() {

					$("#chbDaDuyet").is(":checked");
				});
				
				$("#themMoi")
				.on(
						"click",
						function() {
							var tenKhoaHoc = document.forms["myForm"]["objKhoaHoc.tenKhoaHoc"].value;
							var ngayXuatBan = document.forms["myForm"]["objKhoaHoc.ngayXuatBan"].value;
							var ngayDang = document.forms["myForm"]["objKhoaHoc.ngayDang"].value;
							var ngayCapNhat = document.forms["myForm"]["objKhoaHoc.ngayCapNhat"].value;
							var hocPhi = document.forms["myForm"]["objKhoaHoc.hocPhi"].value;
							var moTa = document.forms["myForm"]["objKhoaHoc.moTa"].value;
							if (tenKhoaHoc == "" || tenKhoaHoc == null) {
								$("#warning1").html(" *Bạn cần nhập tên khóa học");
							}if (moTa == "" || moTa == null) {
								$("#warning2").html(" *Bạn cần nhập mô tả");
							}  if (hocPhi == "" || hocPhi == null) {
								$("#warning3").html(" *Bạn cần nhập học phí");
							}  if (ngayDang == "" || ngayDang == null) {
								$("#warning4").html(" *Bạn cần chọn ngày đăng");
							}  if (ngayXuatBan == "" || ngayXuatBan == null) {
								$("#warning5").html(" *Bạn cần chọn ngày xuất bản");
							}  if (ngayCapNhat == "" || ngayCapNhat == null) {
								$("#warning6").html(" *Bạn cần chọn ngày cập nhật");

							}
							
							
							
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

				$("#txtTenKhoaHoc").on("keyup", function() {
					var tenKhoaHoc = $("#txtTenKhoaHoc").val();
					if (tenKhoaHoc.length < 1) {
						$("#warning1").html(" *Bạn cần nhập tên khóa học");
					} else {
						$("#warning1").html("");
					}
				});
				$("#txtMoTa").on("keyup", function() {
					var moTa = $("#txtMoTa").val();
					if (moTa.length < 1) {
						$("#warning2").html(" *Bạn cần nhập mô tả");
					} else {
						$("#warning2").html("");
					}
				});
				$("#txtHocPhi").on("keyup", function() {
					var hocPhi = $("#txtHocPhi").val();
					if (hocPhi.length < 1) {
						$("#warning3").html(" *Bạn cần nhập học phí");
					} else {
						$("#warning3").html("");
					}
				});
				$("#txtNgayDang").on("keyup", function() {
					var ngayDang = $("#txtNgayDang").val();
					if (ngayDang.length < 1) {
						$("#warning4").html(" *Bạn cần chọn ngày đăng");
					} else {
						$("#warning4").html("");
					}
				});
				$("#txtNgayXuatBan").on("keyup", function() {
					var ngayXuatBan = $("#txtNgayXuatBan").val();
					if (ngayXuatBan.length < 1) {
						$("#warning5").html(" *Bạn cần chọn ngày xuất bản");
					} else {
						$("#warning5").html("");
					}
				});
				$("#txtNgayCapNhat").on("keyup", function() {
					var ngayCapNhat = $("#txtNgayCapNhat").val();
					if (ngayCapNhat.length < 1) {
						$("#warning6").html(" *Bạn cần chọn ngày cập nhật");
					} else {
						$("#warning6").html("");
					}
				});

			});

	//kiem tra
	function validateForm() {
		var tenKhoaHoc = document.forms["myForm"]["objKhoaHoc.tenKhoaHoc"].value;
		var ngayXuatBan = document.forms["myForm"]["objKhoaHoc.ngayXuatBan"].value;
		var ngayDang = document.forms["myForm"]["objKhoaHoc.ngayDang"].value;
		var ngayCapNhat = document.forms["myForm"]["objKhoaHoc.ngayCapNhat"].value;
		var hocPhi = document.forms["myForm"]["objKhoaHoc.hocPhi"].value;
		var moTa = document.forms["myForm"]["objKhoaHoc.moTa"].value;
		if (tenKhoaHoc == "" || tenKhoaHoc == null) {
			return false;
		} else if (moTa == "" || moTa == null) {
			return false;
		} else if (hocPhi == "" || hocPhi == null) {
			return false;
		} else if (ngayDang == "" || ngayDang == null) {
			return false;
		} else if (ngayXuatBan == "" || ngayXuatBan == null) {
			return false;
		} else if (ngayCapNhat == "" || ngayCapNhat == null) {
			return false;
		} 
	}
	$(function() {
		$("#txtNgayDang").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
	$(function() {
		$("#txtNgayCapNhat").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>

</head>
<body>

	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i>Nhập thông tin khóa học
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Khóa học trực tuyến</li>
			<li class="breadcrumb-item active"><a href="#">Khóa học</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<s:form action="themMoiKhoaHoc" method="POST"
					enctype="multipart/form-data" onsubmit="return validateForm()"
					name="myForm" theme="simple">
					<div class="tile-body">

						<div class="form-group">
							<label class="control-label">Tên khóa học *</label>
							<s:textfield id="txtTenKhoaHoc" name="objKhoaHoc.tenKhoaHoc"
								value="%{objKhoaHoc.tenKhoaHoc}" cssStyle="width:98%;" cssClass="form-control" />
							<s:hidden name="khoaHocId" value="%{objKhoaHoc.id}"
								cssClass="form-control" />
							<span id="warning1" style="color: red;"></span>
						</div>

                        <s:actionerror/>

						<div class="form-group">
							<label class="control-label">Mô tả *</label>
							<s:textarea id="txtMoTa" name="objKhoaHoc.moTa"
								value="%{objKhoaHoc.moTa}" rows="5" cssStyle="width:98%;"
								cssClass="form-control" />
							<span id="warning2" style="color: red;"></span>
						</div>

						<div class="form-group">
							<label class="control-label">Chọn ảnh *</label>
							<s:file name="fileUpload" label="Chọn 1 file cần upload"
								size="40" />
							<s:property value="fileUploadFileName" />
							<s:property value="fileUploadContentType" />
							<br> <img alt="Khóa học trực tuyến"
								src="images/<s:property value="objKhoaHoc.anhDaiDien" />"
								width="150" height="150">
							<s:hidden name="objKhoaHoc.anhDaiDien"
								value="%{objKhoaHoc.anhDaiDien}" cssClass="" />
						</div>

						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Chủ đề *</label>
								<s:select cssClass="form-control" list="lstChuDe"
									name="objKhoaHoc.chuDeId" value="%{objKhoaHoc.chuDeId}"
									listKey="id" listValue="tenChuDe">
								</s:select>
							</div>
							<div class="col-md-6">
								<label class="control-label">Cấp độ </label>
								<s:select cssClass="form-control" list="lstCapDo"
									name="objKhoaHoc.capDoId" value="%{objKhoaHoc.capDoId}"
									listKey="id" listValue="tenCapDo">
								</s:select>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6">

								<label class="control-label">Học phí *</label>
								<s:textfield id="txtHocPhi" name="objKhoaHoc.hocPhi"
									value="%{objKhoaHoc.hocPhi}" cssClass="form-control" />
								<span id="warning3" style="color: red;"></span>
							</div>
							<div class="col-md-6">
								<label class="control-label">Ngày đăng *</label>

								<s:textfield name="objKhoaHoc.ngayDang" id="txtNgayDang"
									readonly="readonly" value="%{objKhoaHoc.ngayDang}"
									cssClass="form-control" />
								<span id="warning4" style="color: red;"></span>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6">
								<label class="control-label">Ngày xuất bản *</label>

								<s:textfield name="objKhoaHoc.ngayXuatBan" id="txtNgayXuatBan"
									readonly="readonly" value="%{objKhoaHoc.ngayXuatBan}"
									cssClass="form-control" />
								<span id="warning5" style="color: red;"></span>
							</div>
							<div class="col-md-6">
								<label class="control-label">Ngày cập nhật *</label>
								<s:textfield name="objKhoaHoc.ngayCapNhat" id="txtNgayCapNhat"
									readonly="readonly" value="%{objKhoaHoc.ngayCapNhat}"
									cssClass="form-control" />
								<span id="warning6" style="color: red;"></span>
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-6">

								<label class="control-label">Miễn phí </label>
								<s:checkbox name="objKhoaHoc.mienPhi" id="chbMienPhi"
									value="%{objKhoaHoc.mienPhi}" cssClass="form-control" />

							</div>
							<div class="col-md-6">
								<label class="control-label">Đã duyệt </label>
								<s:checkbox name="objKhoaHoc.daDuyet" id="chbDaDuyet"
									value="%{objKhoaHoc.daDuyet}" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label">Giảng viên </label>
							<s:select cssClass="form-control" list="lstGiangVien"
								name="objKhoaHoc.giangVienId" value="%{objKhoaHoc.giangVienId}"
								listKey="id" listValue="tenGiangVien">
							</s:select>
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