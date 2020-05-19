<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>

<link rel="stylesheet" href="theme/css/animate.css">
<link rel="stylesheet" type="text/css" href="theme/css/bootstrap.css">
<link rel="stylesheet" href="theme/css/trangChu.css">


<s:set var="danhSachLoai" value="false" />
<s:if test='#session.containsKey("danhSachLoai")'>
	<s:set var="danhSachLoai" value='#session["danhSachLoai"]' />
</s:if>

</head>
<body>
<div class="container-fluid bn">
		<div class="jumbotron">
			<h1 class="display-4 wow bounceInDown" data-wow-duration="1s">TRUNG TÂM&nbsp;</h1>
			<h1 id="cpn" class="wow bounceInDown" data-wow-duration="2s">T&TGroups</h1>
			<p class="lead wow bounceInDown" data-wow-duration="3s">Lựa chọn học tập tại T&TGroups là cơ hội 
			để bạn tiếp cận và làm việc với đội ngũ giảng viên, chuyên gia nhiều năm kinh nghiệm trong môi 
			trường làm việc thực tế cũng như trong công tác giảng dạy, chúng tôi sẽ cùng bạn tiến thêm những bước lớn 
			trong quá trình hoàn thiện bản thân.</p>
			<a class="btn btn-primary btn-lg wow bounceInDown" href="#"
				role="button" data-wow-duration="4s">Xem thêm</a>
		</div>
		<img class="wow bounceInDown" src="theme/images/img3.png" alt=""
			data-wow-duration="5s">
	</div>
	
	<div class="container">
	
	<s:if test=" #danhSachLoai == true">
	<div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h3 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Loại Khóa Học</h3>		
	</div>
	</s:if>
	
		<div class="row">
		<s:iterator value="lstLoai">
			<div class="col-xl-3 col-lg-3 col-md-6 wow bounceInRight">				
				<div class="icon">
					<span><i class="fa fa-laptop" aria-hidden="true"></i></span>
				</div>							
				<a href='<s:url action="layChuDeTheoLoai?ma=%{id}"/>'><h5><s:property value="tenLoai" /></h5></a>
				<p><s:property value="moTa" /></p>													  							
			</div>			
      </s:iterator>			
		</div>
	</div>
	
	<div class="container-fluid abu">
		<div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<div class="nd">
						<h4 class="wow shake">Thông tin về Trung Tâm</h4>
						<img class="wow bounceInLeft" src="theme/images/6.jpg" alt="">
						<p class="wow flipInX">Lựa chọn học tập tại T&T là cơ hội để bạn tiếp cận và làm
						 việc với đội ngũ giảng viên, chuyên gia nhiều năm kinh nghiệm trong môi trường làm việc thực tế 
						 cũng như trong công tác giảng dạy, chúng tôi sẽ cùng bạn tiến thêm những bước lớn trong quá trình
						  hoàn thiện bản thân.</p>
					</div>
				</div>
				<div class="col-lg-6 col-md-12">
					<div class="nd">
						<h4 class=" wow shake">Chính sách đãi ngộ đặc biệt dành cho học viên</h4>
						<p class="wow flipInX" data-wow-duration="1s">Nhằm mục đích tạo điều kiện thuận lợi nhất 
						về mọi mặt để thúc đẩy quá trình học và làm việc, T&T luôn có những chính sách, ưu đãi hấp 
						dẫn dành cho học viên tham gia học tập tại T&T.</p>
						<p class="wow flipInX" data-wow-duration="1.5s">Giảm 20 - 60% học phí khóa học đối với 
						các bạn mong muốn học nhưng chưa có đủ điều kiện về tài chính. Phương thức áp dụng: học viên
					  tham gia vào các dự án, công việc mà công ty đưa ra. Tùy vào năng lực công ty sẽ đưa ra mức giảm học phí.</p>
						<p class=" wow flipInX" data-wow-duration="2s">Được giảng viên, chuyên gia cung cấp đầy đủ các thông tin
						 liên quan như số điện thoại, email, yahoo, skype,… giúp học viên có thể trao đổi với chuyên gia khi cần hỗ trợ.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div id="tit" class="row">
			<h4>Đội Ngũ Giảng Viên</h4>
		</div>
		<div class="row">		
		<s:iterator value="lstGiangVien">						
		<div class="col-md-3 filter creative">
				<div class="thumbnail">										
					<img class="wow bounceInRight" data-wow-duration="2s"
						src='images/<s:property value="anhDaiDien" />'   width="600" height="250"  alt="Lights">						
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
					
						<a href="#" target="#">  <h5> <s:property value="tenGiangVien" /> </h5>  </a>
						<p><s:property value="chuyenMon" /></p>						
						<a href="#" target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>										
				</div>
			</div>
							
		<!--  	<div class="card-group">									
				<div class="card col-md-12">
					<img class="card-img-top wow bounceInDown img-fluid"
						src="theme/images/3.jpg" alt="Card image cap" data-wow-duration="1s">
					<div class="card-body">
						<h5 class="card-title wow shake"><s:property value="tenGiangVien" /></h5>
						<p class="card-text wow flipInX" data-wow-duration="2s"><s:property value="chuyenMon" /></p>
					</div>
				</div>				
			</div> -->
									
			</s:iterator>
		</div>
	</div>
	
	<div class="container-fluid bn2">
		<div class="container nd2">
			<div class="row">
				<h3 class=" wow shake">Đối Tác Của Chúng Tôi</h3>
			</div>
			<div class="row">
				<p class="wow bounceInRight">Dưới đây là danh sách một số khách hàng đã hợp tác 
				với T&T và một vài dự án tiêu biểu mà chúng tôi đã thực hiện.Dưới đây là danh sách một số 
				khách hàng đã hợp tác với T&T và một vài dự án tiêu biểu mà chúng tôi đã thực hiện.</p>
			</div>
			<div class="row">
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner1.png"
						alt="" data-wow-duration="1s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner2.png"
						alt="" data-wow-duration="2s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner3.png"
						alt="" data-wow-duration="3s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner4.png"
						alt="" data-wow-duration="4s">
				</div>
				<div class="col-md-2 col-sm-2 col-lg-2 col-2 col-xl-2 logo">
					<img class="wow bounceInDown img-fluid" src="theme/images/partner5.png"
						alt="" data-wow-duration="5s">
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row ftid">
			<div class="col-lg-1 col-md-1 icon2 wow bounceInRight">
				<span><i class="fa fa-phone-square" aria-hidden="true"></i></span>
			</div>
			<div class="col-lg-8 col-md-8 ndftid">
				<h4 class=" wow bounceInLeft" data-wow-duration="1s">Thông tin liên hệ và giải đáp các thắc mắc</h4>
				<p class=" wow bounceInLeft" data-wow-duration="2s">Chúng tôi luôn nỗ lực hết mình mang đến Chất lượng 
				đào tạo và Dịch vụ tốt nhất cho bạn. Liên hệ ngay với chúng tôi theo Hotline: 09361213123 - 0963131211.
			 Địa chỉ: Tầng 2 số 20 ngõ 678 Đường Láng (Hoặc cuối ngõ 100 Nguyễn Chí Thanh), Đống Đa, Hà Nội</p>
			</div>
		</div>
	</div>
</body>
</html>