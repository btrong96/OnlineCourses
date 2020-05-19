<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách giảng viên</title>

<s:set var="danhSach_6" value="false" />
<s:set var="them_6" value="false" />
<s:set var="sua_6" value="false" />
<s:set var="xoa_6" value="false" />
<s:set var="baoCao_6" value="false" />

<s:if test='#session.containsKey("danhSach_6")'>
	<s:set var="danhSach_6" value='#session["danhSach_6"]' />
</s:if>
<s:if test='#session.containsKey("them_6")'>
	<s:set var="them_6" value='#session["them_6"]' />
</s:if>
<s:if test='#session.containsKey("sua_6")'>
	<s:set var="sua_6" value='#session["sua_6"]' />
</s:if>
<s:if test='#session.containsKey("xoa_6")'>
	<s:set var="xoa_6" value='#session["xoa_6"]' />
</s:if>

</head>

<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách giảng viên
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Giảng viên</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_6 == true">
			<div class="col-md-12">
				<span class="btn btn-primary"><a id="btnThemMoi" href='<s:url action="chiTietGiangVien.action"/>'
					class="btn btn-primary">Thêm mới</a></span>
			</div>
		</s:if>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form action="timKiemGiangVien" method="GET" theme="simple">
						<fieldset>
							<legend>Nhập thông tin giảng viên</legend>
							<table class="table table-striped">
								<tr>
									<td>Từ khoá:</td>
									<td><s:textfield name="tuKhoa" class="form-control"
											value="%{tuKhoa}" /></td>

									<td><s:submit value="Tìm kiếm" class="btn btn-primary" /></td>
								</tr>
							</table>
						</fieldset>
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>									
									<th>Tên giảng viên</th>
									<th>Ảnh đại diện</th>
									<th>Chức danh</th>
									<th>Chuyên môn</th>
									<th style="width: 30px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_6 == true">
								<tbody>
									<s:iterator var="gv" value="lstGiangVien">
										<tr>										
											<td><s:property value="tenGiangVien" /></td>
											<td><img src="images/<s:property value='anhDaiDien' />"
												width="100" height="100" /></td>
											<td><s:property value="chucDanh" /></td>
											<td><s:property value="chuyenMon" /></td>
											<td><s:if test=" #sua_6 == true">
													<a href='<s:url action="chiTietGiangVien?ma=%{id}"/>' ><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if>&nbsp;<s:if test=" #xoa_6 == true">
													<a href='<s:url action="xoaGiangVien?ma=%{id}"/>' 
												 onclick="return confirm('Bạn có chắc chắn muốn xoá thông tin này ?');"><i
														class="fa fa-trash-o"></i></a>
												</s:if></td>
										</tr>
									</s:iterator>
								</tbody>
							</s:if>
						</table>					
					</s:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>