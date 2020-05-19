<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng tags của struts -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm mới thông tin chủ đề</title>

<script type="text/javascript">
	$(document).ready(function() {

		$("#themMoi").on("click", function() {
			var tenChuDe = document.forms["myForm"]["objChuDe.tenChuDe"].value;
			var moTa = document.forms["myForm"]["objChuDe.moTa"].value;
			if (tenChuDe == "" || tenChuDe == null) {
				$("#warning1").html("*Bạn cần nhập tên chủ đề");
			}
			if (moTa == "" || moTa == null) {
				$("#warning2").html("*Bạn cần nhập mô tả");
			}
		});

		$("#txtTenChuDe").on("keyup", function() {
			var tenChuDe = $("#txtTenChuDe").val();
			if (tenChuDe.length < 1) {
				$("#warning1").html(" *Bạn cần nhập tên chủ đề");
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

	});

	function validateForm() {
		var tenChuDe = document.forms["myForm"]["objChuDe.tenChuDe"].value;
		var moTa = document.forms["myForm"]["objChuDe.moTa"].value;

		if (tenChuDe == "" || tenChuDe == null) {
			return false;
		} else if (moTa == "" || moTa == null) {
			return false;
		}
	
	}
</script>

</head>
<body>

	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i>Nhập thông tin chủ đề
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Chủ đề khóa học trực tuyến</li>
			<li class="breadcrumb-item active"><a href="#">Chủ đề</a></li>
		</ul>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<s:form action="themMoiChuDe" method="POST"
					enctype="multipart/form-data" onsubmit="return validateForm()"
					name="myForm" theme="simple">
													
					<div class="tile-body">
						<div class="form-group">
							<label class="control-label">Tên chủ đề</label>
							<s:textfield id="txtTenChuDe" name="objChuDe.tenChuDe"
								value="%{objChuDe.tenChuDe}" cssStyle="width:98%;" />
							<s:hidden name="chuDeId" value="%{objChuDe.id}"
								cssClass="form-control" />
							<span id="warning1" style="color: red;"></span>
						</div>

                       <s:actionerror/>

						<div class="form-group">
							<label class="control-label">Mô tả</label>
							<s:textarea id="txtMoTa" name="objChuDe.moTa"
								value="%{objChuDe.moTa}" rows="5" cssStyle="width:98%;"
								cssClass="form-control" />
							<span id="warning2" style="color: red;"></span>
						</div>

						<div class="form-group">
							<label class="control-label">Chọn ảnh</label>
							<s:file name="fileUpload" label="Chọn 1 file cần upload"
								size="40" />
							<s:property value="fileUploadFileName" />
							<s:property value="fileUploadContentType" />
							<br> <img alt="Chủ đề trực tuyến"
								src="images/<s:property value="objChuDe.anhDaiDien" />"
								width="150" height="150">
							<s:hidden name="objChuDe.anhDaiDien"
								value="%{objChuDe.anhDaiDien}" cssClass="" />
						</div>

						<div class="form-group">
							<label class="control-label">Loại</label>
							<s:select cssClass="form-control" list="lstLoai"
								name="objChuDe.loaiId" value="%{objChuDe.loaiId}" listKey="id"
								listValue="tenLoai">
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