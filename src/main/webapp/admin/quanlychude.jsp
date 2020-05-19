<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách chủ đề</title>

<!-- set up nho de false -->
<s:set var="danhSach_2" value="false" />                        
<s:set var="them_2" value="false" />
<s:set var="sua_2" value="false" />
<s:set var="xoa_2" value="false" />
<s:set var="baoCao_2" value="false" />

<s:if test='#session.containsKey("danhSach_2")'>
	<s:set var="danhSach_2" value='#session["danhSach_2"]' />
</s:if>
<s:if test='#session.containsKey("them_2")'>
	<s:set var="them_2" value='#session["them_2"]' />
</s:if>
<s:if test='#session.containsKey("sua_2")'>
	<s:set var="sua_2" value='#session["sua_2"]' />
</s:if>
<s:if test='#session.containsKey("xoa_2")'>
	<s:set var="xoa_2" value='#session["xoa_2"]' />
</s:if>

</head>
<body>
	<div class="app-title">
		<div>
			<h1>
				<i class="fa fa-th-list"></i> Danh sách chủ đề
			</h1>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">Trung tâm đào tạo online</li>
			<li class="breadcrumb-item active"><a href="#">Chủ đề</a></li>
		</ul>
	</div>
	<div class="row" style="text-align: right; padding-bottom: 5px;">
		<s:if test=" #them_2 == true">
			<div class="col-md-12">
				<span class="btn btn-primary"><a id="btnThemMoi" href='<s:url action="chiTietChuDe.action"/>'
					class="btn btn-primary">Thêm mới</a></span>
			</div>
		</s:if>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<s:form>
	
						<table class="table table-hover table-bordered" id="sampleTable">
							<thead>
								<tr>
									<th style="width: 10%;">Tên chủ đề</th>
									<th>Ảnh đại diện</th>
									<th>Mô tả</th>
									<th>Phân loại</th>
									<th style="width: 50px;"></th>
								</tr>
							</thead>
							<s:if test=" #danhSach_2 == true">
								<tbody>
									<s:iterator var="cd" value="lstChuDe">
										<tr>
											<td><s:property value="tenChuDe" /></td>
											<td><img src="images/<s:property value='anhDaiDien' />"
												width="80" height="80" /></td>
											<td><s:property value="moTa" /></td>
											<td><s:property value="tenLoai" /></td>
											<td><s:if test=" #sua_2 == true">
													<a href='<s:url action="chiTietChuDe?ma=%{id}"/>'><i
														class="fa fa-pencil-square-o"></i></a>
												</s:if> &nbsp; <s:if test=" #xoa_2 == true">
													<a href='<s:url action="xoaChuDe?ma=%{id}"/>' 
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