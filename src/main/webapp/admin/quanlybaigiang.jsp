<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài giảng</title>

<s:set var="danhSach_4" value="false" />
<s:set var="them_4" value="false" />
<s:set var="sua_4" value="false" />
<s:set var="xoa_4" value="false" />
<s:set var="baoCao_4" value="false" />

<s:if test='#session.containsKey("danhSach_4")'>
	<s:set var="danhSach_4" value='#session["danhSach_4"]' />
</s:if>
<s:if test='#session.containsKey("them_4")'>
	<s:set var="them_4" value='#session["them_4"]' />
</s:if>
<s:if test='#session.containsKey("sua_4")'>
	<s:set var="sua_4" value='#session["sua_4"]' />
</s:if>
<s:if test='#session.containsKey("xoa_4")'>
	<s:set var="xoa_4" value='#session["xoa_4"]' />
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
function duyetCheckBox() {
	var checkBox = $('input[type = "checkbox"]:checked');
	if (checkBox.length > 0) {
		$('#kq').html(checkBox.length + " bài giảng được chọn");
		checkBox.each(function() {
			$('#kq').append($(this).val() + "\t");
		});

		$("#thongbaoduyet").attr("title", "Duyệt thông tin");
		$("#thongbaoduyet").dialog({
			width : 400,
			modal : true,
			buttons : {
				"Duyệt" : function() {
					checkBox.each(function() {
						var t = $(this).val();

						$.ajax({
							type : "GET",
							url : "duyetBaiGiang.action",
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
		$('#kq').text("Không có bài giảng nào được chọn");
	}
}

function boDuyetCheckBox() {
	var checkBox = $('input[type = "checkbox"]:checked');
	if (checkBox.length > 0) {
		$('#kq').html(checkBox.length + " bài giảng được chọn");
		checkBox.each(function() {
			$('#kq').append($(this).val() + "\t");
		});

		$("#thongbaoboduyet").attr("title", "Bỏ Duyệt thông tin");
		$("#thongbaoboduyet").dialog({
			width : 400,
			modal : true,
			buttons : {
				"Bỏ Duyệt" : function() {
					checkBox.each(function() {
						var t = $(this).val();

						$.ajax({
							type : "GET",
							url : "boDuyetBaiGiang.action",
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
		$('#kq').text("Không có bài giảng nào được chọn");
	}
}
</script>

</head>
<body>

	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách bài giảng
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Bài giảng</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_4 == true">
			<div class="col-md-12">
				<span class="btn btn-primary"><a id="btnThemMoi" href='<s:url action="chiTietBaiGiang.action"/>'
					class="btn btn-primary">Thêm mới</a></span>
			</div>
		</s:if>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form action="timKiemBaiGiang" method="GET" theme="simple">
						<fieldset>
							<legend>Nhập thông tin bài giảng</legend>
							<table class="table table-striped">
								<tr>
									<td>Từ khoá:</td>
									<td><s:textfield name="tuKhoa" class="form-control"
											value="%{tuKhoa}" /></td>

									<!--  		<td>Mô tả:</td>
									<td><s:textfield name="moTaTimKiem" class="form-control"
											value="%{moTaTimKiem}" /></td>   -->
											
									 <td>Khóa học:</td>
									<td><s:select list="lstKhoaHoc" name="maKhoaHocTimKiem"
											value="%{maKhoaHocTimKiem}" headerKey=""
											headerValue="--Chọn khóa học--" listKey="id"
											listValue="tenKhoaHoc" class="form-control" /></td>	

									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>
						
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="checkall()">  <a class="nav-link" href="#"> CHECK ALL </a></button>	
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="uncheckall()">  <a class="nav-link" href="#"> UNCHECK ALL </a></button>
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="duyetCheckBox()">  <a class="nav-link" href="#"> DUYỆT NHIỀU </a></button>	
					<button  class="btn btn-default filter-button wow rotateInDownLeft"  onclick="boDuyetCheckBox()">  <a class="nav-link" href="#">BỎ DUYỆT NHIỀU </a></button>	
					<div id="kq"></div>	
						
						
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
								    <th style="width: 2%"></th>
									<th style="width: 2%;">Thứ tự</th>
									<th>Tên bài giảng</th>
									<th>Hình Ảnh</th>
									<th>Ngày tạo</th>
									<th>Thời lượng</th>
									<th>Ngày cập nhật</th>
									<th>Mô tả</th>
									<th>Ngày đăng</th>
									<th>Đã duyệt</th>
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_4 == true">
								<tbody>
									<s:iterator var="bg" value="lstBaiGiang">
										<tr class="checkbox">
										
										    <td><input id="checkBox" type="checkbox" class="text"
												value="${bg.id}"></td>
												
											<td><s:property value="thuTu" /></td>
											<td><s:property value="tenBaiGiang" /></td>
											<td><img src="images/<s:property value='anhDaiDien' />"
												width="80" height="80" /></td>
											<td><s:property value="ngayTao" /></td>
											<td><s:property value="thoiLuong" /></td>
											<td><s:property value="ngayCapNhat" /></td>
											<td><s:property value="moTa" /></td>
											<td><s:property value="ngayDang" /></td>
											<td><s:property value="daDuyet" /></td>
											<td><s:if test=" #sua_4 == true">
													<a href='<s:url action="chiTietBaiGiang?ma=%{id}"/>'> <i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_4 == true">
													<a  href='<s:url action="xoaBaiGiang?ma=%{id}"/>' 
													onclick="return confirm('Bạn có chắc chắn muốn xoá thông tin này ?');"> <i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>	
						
			    <div id="thongbaoduyet" style="display: none;">Bạn có chắc
							muốn duyệt thông tin này ?</div>
							
				<div id="thongbaoboduyet" style="display: none;">Bạn có chắc
							muốn bỏ duyệt thông tin này ?</div>	
																		
					</s:form>
																		
										
				</div>
			</div>
		</div>
	</div>
</body>
</html>