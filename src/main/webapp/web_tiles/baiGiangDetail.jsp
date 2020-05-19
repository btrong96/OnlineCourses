<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết bài giảng</title>
<style type="text/css">
body {
	margin-top: 75px;
}

.comment {
	width: 80%;
	height: auto;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#btnThemMoi").click(
						function() {

							var today = new Date();
							var date = today.getDate() + '/'
									+ (today.getMonth() + 1) + '/'
									+ today.getFullYear();
							$("#txtThoiGianTao").val(date);

							var baiGiangId = $("#txtIdBaiGiang").val();
							var noiDung = $("#txtNoiDung").val();
							var thoiGianTao = $("#txtThoiGianTao").val();

							$.ajax({
								type : "POST",
								url : "themNhanXetTiles.action",
								data : {

									baiGiangId : baiGiangId,
									noiDung : noiDung,
									thoiGianTao : thoiGianTao
								},
								dataType : 'json',
								success : function(result) {
									// reload lai trang
									window.location.reload();

								},
								error : function(e) {
									console.log("ERROR: ", e);
								}
							});
						});
			});
	function thongTinChiTietNhanXet(id) {
		$.ajax({
			type : "GET",
			url : "layThongTinChiTietNhanXet.action",
			data : {
				id : id
			},
			dataType : 'json',
			// contentType: 'application/json',
			// async: true,
			success : function(data) {
				var d = $.parseJSON(data.nhanXet);

				var DateT = new Date(d.thoiGianTao);
				var dateT = DateT.getDate() + '/' + (DateT.getMonth() + 1)
						+ '/' + DateT.getFullYear();
				var DateCN = new Date();
				var dateCN = DateCN.getDate() + '/' + (DateCN.getMonth() + 1)
						+ '/' + DateCN.getFullYear();

				// hien thi giao dien
				$("#txtId").val(d.id);
				$("#cboBaiGiang").val(d.baiGiangId);
				$("#cboNguoiDung").val(d.nguoiDungId);
				$("#txtThoiGianTao").val(dateT);
				$("#txtThoiGianCapNhat").val(dateCN);
				$("#txtNoiDung").val(d.noiDung);
			}
		});
	}

	function suaThongTin(id) {
		// lay thong tin chi tiet loai can sua
		thongTinChiTietNhanXet(id);

		// hien thi popup va xu ly cap nhat
		$("#formNhanXet").attr("title", "Sửa thông tin nhận xét");
		$("#formNhanXet").dialog({
			width : 500,
			modal : true,
			buttons : {
				"Cập nhật" : function() {
					// gui thong tin len server

					var id = $("#txtId").val();
					var baigiang_id = $("#cboBaiGiang").val();
					var nguoidung_id = $("#cboNguoiDung").val();
					var thoigiantao = $("#txtThoiGianTao").val();
					var thoigiancapnhat = $("#txtThoiGianCapNhat").val();
					var noidung = $("#txtNoiDung").val();

					$.ajax({
						type : "POST",
						url : "capNhatNhanXet.action",
						data : {
							id : id,
							baiGiangId : baigiang_id,
							nguoiDungId : nguoidung_id,
							thoiGianTao : thoigiantao,
							thoiGianCapNhat : thoigiancapnhat,
							noiDung : noidung
						},
						success : function(result) {
							// reload lai trang
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
						url : "xoaNhanXet.action",
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
	<div class="container-fluid">
		<h1>TRUNG TÂM T&TGroups</h1>
		<p>Lựa chọn học tập tại T&TGroups là cơ hội để bạn tiếp cận và làm
			việc với đội ngũ giảng viên, chuyên gia nhiều năm kinh nghiệm trong
			môi trường làm việc thực tế.</p>
		<p>Cũng như trong công tác giảng dạy, chúng tôi sẽ cùng bạn tiến
			thêm những bước lớn trong quá trình hoàn thiện bản thân..</p>
		<div class="row clip">
			<div class="col-sm-7">
				<div class="cliptrai">
					<iframe height="440px" width="100%"
						src="https://www.youtube.com/embed/<s:property value="nameCode"/>"
						frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
					<h3>
						[Bài giảng]
						<s:property value="tenBaiGiang" />
					</h3>
					<p>
						<s:property value="moTa" />
					</p>

					<div class="comment">
						<div>
							<p>${session.username}</p>
						</div>
						<div class="row">
							<div class="col-md-11">
								<form action="" id="formNhanXet">
									<input type="text" id="txtNoiDung" class="comment"
										name="comment" style="width: 80%;" placeholder="Bình luận....">
									<input type="hidden" id="txtThoiGianTao">

									<!-- Gan idBaiGiang -> de khi them comment co idBaiGiang de luu xuong DB -->
									<input type="hidden" id="txtIdBaiGiang"
										name="<s:property value="idBaiGiang"/>"
										value="<s:property value="idBaiGiang"/>">

								</form>
							</div>

							<div class="col-md-1">
								<input type="submit" id="btnThemMoi" value="Bình Luận"
									class="btn btn-default filter-button wow rotateInDownLeft" />
							</div>

						</div>
					</div>

					<div class="well well-lg" style="height: 555px; overflow-y: auto; margin-top: 5px">

						<s:iterator value="lstNhanXet">
							<h5 class="media-heading text-uppercase reviews">
								<s:property value="tenNguoiDung" />
							</h5>
							<ul class="media-date text-uppercase reviews list-inline">
								<li class="dd"><s:property value="thoiGianTao" /></li>
							</ul>
							<p class="media-comment">
								<s:property value="noiDung" />
							</p>
						</s:iterator>

					</div>
				</div>
			</div>
			
						
			<div class="col-sm-5" style="height: 1300px; overflow-y: auto;">
			
			<!--Bai Giang Mien Phi Cung Khoa Hoc Vs Bai Giang Dang Phat -->
				<div class="row">
					<s:iterator value="lstBaiGiangMienPhi">
						<div class="col-sm-8">
							<iframe width="100%" height="auto"
								src="https://www.youtube.com/embed/<s:property value="nameCode"/>"
								frameborder="0" allow="autoplay; encrypted-media"
								allowfullscreen></iframe>
						</div>
						<div class="col-sm-4">

							<a href='<s:url action="thongTinChiTietBaiGiang?ma=%{id}"/>'
								target="#"><p>
									[Bài giảng]
									<s:property value="tenBaiGiang" />
								</p></a>

						</div>
					</s:iterator>
				</div>
				
				<!--Bai Giang Co Phi Cung Khoa Hoc Vs Bai Giang Dang Phat -->
				<div class="row">
					<s:iterator value="lstBGtheoKHcoPhiCoDANGKY">
						<div class="col-sm-8">
							<iframe width="100%" height="auto"
								src="https://www.youtube.com/embed/<s:property value="nameCode"/>"
								frameborder="0" allow="autoplay; encrypted-media"
								allowfullscreen></iframe>
						</div>
						<div class="col-sm-4">

							<a href='<s:url action="thongTinChiTietBaiGiang?ma=%{id}"/>'
								target="#"><p>
									[Bài giảng]
									<s:property value="tenBaiGiang" />
								</p></a>

						</div>
					</s:iterator>
				</div>
				
				
			</div>
			
		</div>
	</div>
</body>
</html>