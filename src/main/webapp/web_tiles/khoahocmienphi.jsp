<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
          <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khóa học miễn phí</title>


</head>
<body>
<div class="container-fluid sm">
		<a id="home" href="#">Trang Chủ</a>
		<p id="x">&nbsp;/&nbsp;</p>
		<a id="abu" href="#">Khóa Học</a>
	</div>
	<div class="container main">
		<div class="row">
			<div id="intro" class="col-lg-12 wow lightSpeedIn">Các khóa học lập trình được biên soạn
			 theo chương trình tài liệu chuẩn quốc tế và kiến thức, kinh nghiệm dự án thực tế của chuyên gia 
			 mang thương hiệu T&T. Khi tham gia khóa học tại công ty chúng tôi bạn sẽ được cung cấp 
			 đầy đủ từ slide bài giảng, video bài giảng của chuyên gia cho bạn chủ động ôn luyện, sourcecode demo 
			 chi tiết, bài tập và các tài liệu liên quan khác.</div>
		</div>
	</div>
	
	<div class="container space-top-bot">	
		<div class="row">		
			<div class="col-md-12">
				<s:iterator value="lstCapDo">					
				<button type="button" 
					class="btn btn-default filter-button wow rotateInDownLeft"
					data-wow-duration="1s" data-filter="all">  <a class="nav-link" href='<s:url action="layKhoaHocTheoCapDo?ma=%{id}"/>'> <s:property value="tenCapDo" /> </a> </button>										
			</s:iterator>
			</div>			
		</div>		
	</div>
	
	
	<div class="container cachbot">	
	<div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h1 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Khóa Học Miễn Phí</h1>		
    </div>
	
		<div class="row">
			<s:iterator value="lstKhoaHocMienPhi">			
			
			<div class="col-md-3 filter creative">
				<div class="thumbnail">										
					<img class="wow bounceInRight" data-wow-duration="2s"
						src="images/<s:property value='anhDaiDien' />"   width="600" height="250"  alt="Lights">						
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
					
						<a href='<s:url action="layBaiGiangTheoKhoaHoc?ma=%{id}"/>' target="#">  <h5>  <s:property value="tenKhoaHoc" /> </h5>  </a>
						<p><s:property value="moTa" /></p>
						<a href='<s:url action="layBaiGiangTheoKhoaHoc?ma=%{id}"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>
					</div>										
				</div>
			</div>
			</s:iterator>
		
		</div>
	</div>
		 	
</body>
</html>