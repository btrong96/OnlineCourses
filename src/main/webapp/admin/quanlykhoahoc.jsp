<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách khóa học</title>

<s:set var="danhSach_3" value="false" />
<s:set var="them_3" value="false" />
<s:set var="sua_3" value="false" />
<s:set var="xoa_3" value="false" />
<s:set var="baoCao_3" value="false" />

<s:if test='#session.containsKey("danhSach_3")'>
	<s:set var="danhSach_3" value='#session["danhSach_3"]' />
</s:if>
<s:if test='#session.containsKey("them_3")'>
	<s:set var="them_3" value='#session["them_3"]' />
</s:if>
<s:if test='#session.containsKey("sua_3")'>
	<s:set var="sua_3" value='#session["sua_3"]' />
</s:if>
<s:if test='#session.containsKey("xoa_3")'>
	<s:set var="xoa_3" value='#session["xoa_3"]' />
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
			$('#kq').html(checkBox.length + " khóa học được chọn");
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
								url : "duyetKhoaHoc.action",
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
			$('#kq').text("Không có khóa học nào được chọn");
		}
	}

	function boDuyetCheckBox() {
		var checkBox = $('input[type = "checkbox"]:checked');
		if (checkBox.length > 0) {
			$('#kq').html(checkBox.length + " khóa học được chọn");
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
								url : "boDuyetKhoaHoc.action",
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
			$('#kq').text("Không có khóa học nào được chọn");
		}
	}
	
	
	/*
	 * Hàm sửa thông tin khóa học theo mã
	 */
	function xemThongTin(idKhoaHoc) {
		//Lấy thông tin chi tiết của khóa học cần sửa
		thongTinChiTietKhoaHoc(idKhoaHoc);

		//Hiển thị popup và xử lý cập nhật
		$("#formkhoahoc").attr("title", "Xem thông tin khóa học");

		$("#formkhoahoc").dialog({

			width : 600,
			modal : true,
			buttons : {
			
				"Đóng" : function() {
					$(this).dialog("close");
				}
			}
		});
	}

	/*
	 * Hàm hiển thị thông tin chi tiết chủ đề bằng jquery ajax
	 */
	function thongTinChiTietKhoaHoc(idKhoaHoc) {
			
		$.ajax({
			type : "GET",
			url : "layChiTietThongTinKhoaHoc.action",
			data : {
				id : idKhoaHoc
			},
			dataType : 'json',
			contentType : 'application/json',
			async : true,
			success : function(data) {

				var d = $.parseJSON(data.khoaHoc);
				
				var DateXB = new Date(d.ngayXuatBan);
				var dateXuatBan = DateXB.getDate()+'/'+(DateXB.getMonth()+1)+'/'+DateXB.getFullYear();
				var today = new Date();
				var dateCapNhat = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();
				var dateDang = today.getDate()+'/'+(today.getMonth()+1)+'/'+today.getFullYear();
				
				//alert(d.tenChuDe);
				//Hiển thị lên giao diện
				$("#txtIdKhoaHoc").val(d.id);
				$("#txtTenKhoaHoc").val(d.tenKhoaHoc);
//				$("#txtAnhDaiDien").val(d.anhDaiDien);
				$("#txtNgayXuatBan").val(dateXuatBan);
				$("#txtNgayCapNhat").val(dateCapNhat);
				$("#txtNgayDang").val(dateDang);
				$("#chbDaDuyet").attr('checked',d.daDuyet);
				$("#chbMienPhi").attr('checked',d.mienPhi);	
				$("#txtHocPhi").val(d.hocPhi);
				$("#txtMoTa").val(d.moTa);
				$("#cboChuDe").val(d.chuDeId);
				$("#cboCapDo").val(d.capDoId);
				$("#cboGiangVien").val(d.giangVienId);
			}
		});
	}
	
	
</script>

</head>

<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách khóa học
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Khóa học</a></li>
		</ul>
	</div>

	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<div class="col-md-12">

			<span class="btn btn-primary"><a
				href='<s:url action="qlkhoahoc"/>' class="btn btn-primary">DANH
					SÁCH</a></span>
			<s:if test=" #them_3 == true">
				<span class="btn btn-primary"><a id="btnThemMoi"
					href='<s:url action="chiTietKhoaHoc.action"/>'
					class="btn btn-primary">Thêm mới</a></span>
			</s:if>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form action="timKiemKhoaHoc" method="GET" theme="simple">

						<fieldset>
							<legend>Nhập thông tin khóa học</legend>
							<table class="table table-striped">
								<tr style="background: white;">
									<td>Từ khoá:</td>
									<td><s:textfield name="tuKhoa" class="form-control"
											value="%{tuKhoa}" /></td>

									<td>Chủ đề:</td>
									<td><s:select list="lstChuDe" name="maChuDeTimKiem"
											value="%{maChuDeTimKiem}" headerKey=""
											headerValue="--Chọn chủ đề--" listKey="id"
											listValue="tenChuDe" class="form-control" /></td>
								</tr>
								<tr>
									<td>Cấp độ:</td>
									<td><s:select list="lstCapDo" name="maCapDoTimKiem"
											value="%{maCapDoTimKiem}" headerKey=""
											headerValue="--Chọn cấp độ--" listKey="id"
											listValue="tenCapDo" class="form-control" /></td>
									<td>Giảng viên:</td>
									<td><s:select list="lstGiangVien"
											name="maGiangVienTimKiem" value="%{maGiangVienTimKiem}"
											headerKey="" headerValue="--Chọn giảng viên--" listKey="id"
											listValue="tenGiangVien" class="form-control" /></td>

									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="checkall()">
							<a class="nav-link" href="#"> CHECK ALL </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="uncheckall()">
							<a class="nav-link" href="#"> UNCHECK ALL </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="duyetCheckBox()">
							<a class="nav-link" href="#"> DUYỆT NHIỀU </a>
						</button>
						<button class="btn btn-default filter-button wow rotateInDownLeft"
							onclick="boDuyetCheckBox()">
							<a class="nav-link" href="#">BỎ DUYỆT NHIỀU </a>
						</button>
						<div id="kq"></div>

						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 2%"></th>
									<th style="width: 15%;">Tên khóa học</th>
									<th>Ảnh đại diện</th>
									<th>Ngày xuất bản</th>
									<th>Ngày cập nhật</th>
									<th>Ngày đăng</th>
									<th>Đã duyệt</th>
									<th>Miễn phí</th>
									<th>Học phí</th>
									<th>Mô tả</th>
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_3 == true">
								<tbody>
									<s:iterator var="kh" value="lstKhoaHoc">
										<tr class="checkbox">

											<td><input id="checkBox" type="checkbox" name="a"
												class="text" value="${kh.id}"></td>

											<td><s:property value="tenKhoaHoc" /></td>
											<td><img src="images/<s:property value='anhDaiDien' />"
												width="80" height="80" /></td>
											<td><s:property value="ngayXuatBan" /></td>
											<td><s:property value="ngayCapNhat" /></td>
											<td><s:property value="ngayDang" /></td>
											<td><s:property value="daDuyet" /></td>
											<td><s:property value="mienPhi" /></td>
											<td><s:property value="hocPhi" /></td>
											<td><s:property value="moTa" /></td>
											<td><s:if test=" #sua_3 == true">
													<a href='<s:url action="chiTietKhoaHoc?ma=%{id}"/>'> <i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_3 == true">
													<a href='<s:url action="xoaKhoaHoc?ma=%{id}"/>'
														onclick="return confirm('Bạn có chắc chắn muốn xoá thông tin này ?');">
														<i class="fa fa-trash-o"></i>
													</a>
												</s:if>
													&nbsp;
												<a href="#" onclick="xemThongTin('${kh.id}')"><i
												class="fa fa-eye"></i></a>
												
												</td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>

                          <!-- Form thêm mới khóa học -->
						<fieldset id="formkhoahoc" style="display: none;"
							title="Xem thông tin khóa học">
							<table style="width: 100%;">
								<tr>
									<td style="width: 20%;"></td>
									<td style="width: 80%;"><input type="hidden"
										id="txtIdKhoaHoc" style="width: 90%;" /></td>
								</tr>
								<tr>
									<td>Tên Khóa học</td>
									<td><input type="text" id="txtTenKhoaHoc"
										style="width: 100%;" /></td>
								</tr>
	                       
								<tr>
									<td>Ngày xuất bản</td>
									<td><input type="text" id="txtNgayXuatBan"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Ngày cập nhật</td>
									<td><input type="text" id="txtNgayCapNhat"
										readonly="readonly" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Ngày đăng</td>
									<td><input type="text" id="txtNgayDang" readonly="readonly"
										style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Đã duyệt</td>
									<td><input type="checkbox" id="chbDaDuyet" value="true" /></td>
								</tr>
								<tr>
									<td>Miễn phí</td>
									<td><input type="checkbox" id="chbMienPhi" value="true" /></td>									
								</tr>
								<tr>
									<td>Học phí</td>
									<td><input type="text" id="txtHocPhi" style="width: 100%;" /></td>
								</tr>
								<tr>
									<td>Mô tả</td>
									<td><textarea id="txtMoTa" rows="4" cols="50" style="width: 100%;"> </textarea> </td>									
								</tr>
								<tr>
									<td>Tên chủ đề</td>
									<td><s:select list="lstChuDe" headerKey=""
											headerValue="--Chọn chủ đề--" id="cboChuDe" listKey="id"
											listValue="tenChuDe" /></td>
								</tr>
								<tr>
									<td>Tên cấp độ</td>
									<td><s:select list="lstCapDo" headerKey=""
											headerValue="--Chọn cấp độ--" id="cboCapDo" listKey="id"
											listValue="tenCapDo" /></td>
								</tr>
								<tr>
									<td>Tên Giảng Viên</td>
									<td><s:select list="lstGiangVien" headerKey=""
											headerValue="--Chọn giảng viên--" id="cboGiangVien"
											listKey="id" listValue="tenGiangVien" /></td>
								</tr>

							</table>
						</fieldset>

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