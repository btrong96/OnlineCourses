<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <!-- Khai báo trust -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin bài giảng</title>

  
<s:set var="daDangKy" value="abc" />
<s:if test='#session.containsKey("daDangKy")'>
	<s:set var="daDangKy" value='#session["daDangKy"]' />
</s:if> 

<s:set var="chuaDangKy" value="abc" />
<s:if test='#session.containsKey("chuaDangKy")'>
	<s:set var="chuaDangKy" value='#session["chuaDangKy"]' />
</s:if>      


</head>
<body>
<div class="container-fluid sm">
		<a id="home" href="home.html">Trang Chủ</a>
		<p id="x">&nbsp;/&nbsp;</p>
		<a id="abu" href="hinhAnh.html">Bài Giảng</a>
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
				<s:iterator value="lstKhoaHoc">					
				<button type="button" 
					class="btn btn-default filter-button wow rotateInDownLeft"
					data-wow-duration="1s" data-filter="all">  <a class="nav-link" href='<s:url action="layBaiGiangTheoKhoaHoc?ma=%{id}"/>'> <s:property value="tenKhoaHoc" /> </a> </button>										
			</s:iterator>
			</div>
		</div>
	</div>
	
	 
	<div class="container cachbot">
	
	<div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h1 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Bài Giảng Theo Khoa Học <s:property value="tenKhoaHoc" /></h1>		
    </div>	
		<div class="row">
		
		
		
    <!--Doan Code Tuyet Voi  -->		
	<s:set var="username" value="false" />
    <s:if test='#session.containsKey("username")'>
	<s:set var="username" value="true" />
    </s:if>	   <!--logout la ko vao dc bai giang nua.  -->		
      
    
    
      <!-- Miễn Phí -->
      <div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h3 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Bài Giảng Miễn Phí</h3>		
      </div>
       	<s:iterator value="lstBGtheoKHmienPhi">			
			
			<div class="col-md-3 filter creative">
				<div class="thumbnail">										
					<img class="wow bounceInRight" data-wow-duration="2s"
						src="images/<s:property value='anhDaiDien' />"   width="600" height="250"  alt="Lights">						
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
					
						<a href="#" target="#">  <h5> <s:property value="thuTu" /> . <s:property value="tenBaiGiang" /> </h5>  </a>
						<p><s:property value="moTa" /></p>
						<p>Thời lượng bài giảng: <s:property value="thoiLuong" /></p>
						
						
						
						<s:if test=" #username == true">				               
						<a href='<s:url action="thongTinChiTietBaiGiang?ma=%{id}"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>			
			            </s:if>	
			            
			            
			            <s:if test=" #username == false">				                
						<a href='<s:url action="login"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>					
			            </s:if>	
							
					</div>										
				</div>
			</div>
		</s:iterator>	
				
				
	  <!-- CÓ PHÍ -->     
      <!-- Có Phí chưa đăng ký -->
       <s:if test=" #chuaDangKy == chuaDangKy">	
       
        <div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h3 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Bài Giảng Có Phí (Chưa Mua)</h3>		
       </div>
       
	    <s:iterator value="lstBGtheoKHcoPhi">	
	    

			<div class="col-md-3 filter creative">	
				<div class="thumbnail">										
					<img class="wow bounceInRight" data-wow-duration="2s"
						src="images/<s:property value='anhDaiDien' />"   width="600" height="250"  alt="Lights">						
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
					
						<a href="#" target="#">  <h5> <s:property value="thuTu" /> . <s:property value="tenBaiGiang" /> </h5>  </a>
						<p><s:property value="moTa" /></p>
						<p>Thời lượng bài giảng: <s:property value="thoiLuong" /></p>
						

						<s:if test=" #username == true">	
						  			               
					<!--	<a href='<s:url action="trangchu"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>	-->		
			            </s:if>	
			                     
			            <s:if test=" #username == false">				                
						<a href='<s:url action="login"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>					
			            </s:if>	
							
					</div>										
				</div>
			</div>
		</s:iterator>	
	 </s:if>	
		
		
		 <!-- Có Phí có đăng ký -->
	<s:if test=" #daDangKy == daDangKy">
		
	 	  <div style="width: 100%; text-align: center; margin-top: 40px; margin-bottom: 30px;" >			
		<h3 id="cpn" class="wow bounceInDown" data-wow-duration="2s">Danh Sách Bài Giảng Có Phí (Đã Mua)</h3>		
      </div>	
		
		<s:iterator value="lstBGtheoKHcoPhiCoDANGKY">	
		
	
			<div class="col-md-3 filter creative">
				<div class="thumbnail">										
					<img class="wow bounceInRight" data-wow-duration="2s"
						src="images/<s:property value='anhDaiDien' />"   width="600" height="250"  alt="Lights">						
					<div class="caption wow bounceInRight" data-wow-duration="2.5s">
					
						<a href="#" target="#">  <h5> <s:property value="thuTu" /> . <s:property value="tenBaiGiang" /> </h5>  </a>
						<p><s:property value="moTa" /></p>
						<p>Thời lượng bài giảng: <s:property value="thoiLuong" /></p>
						

						<s:if test=" #username == true">				               
						<a href='<s:url action="thongTinChiTietBaiGiang?ma=%{id}"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>			
			            </s:if>	
			            			            
			            <s:if test=" #username == false">				                
						<a href='<s:url action="login"/>' target="#"><p>
								<i class="fa fa-eye" aria-hidden="true"></i>&nbsp;View
							</p></a>					
			            </s:if>	
							
					</div>										
				</div>
			</div>
		</s:iterator>	
	</s:if>	
				
		</div>
	</div>		
</body>
</html>