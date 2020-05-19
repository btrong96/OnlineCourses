<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Khai báo trust. Mình Tự thêm -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Start Header -->
	
	
	<div class="row p-0">
		<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
			<h1>
				<a class="navbar-brand" href='<s:url action="trangchu"/>'><font
					color="#1BBD36;">Trung tâm đào tạo T&T </font><span id="ahihi">GROUPS</span></a>
			</h1>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
			
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link active-link"
						href='<s:url action="trangchu"/>'>Trang Chủ</a></li>
						
					<li class="nav-item"><a class="nav-link" href='<s:url action="aboutUs"/>'>Giới thiệu</a></li>	

                    <li class="nav-item"><div class="dropdown">
							<a class="nav-link" href='<s:url action="khoahoc"/>'>Khóa Học</a>
							<div class="dropdown-content">
								<s:iterator value="lstKhoaHoc">
									<a href='<s:url action="layBaiGiangTheoKhoaHoc?ma=%{id}"/>'><s:property
											value="tenKhoaHoc" /></a>
								</s:iterator>
							</div>
						</div></li>
						
				    <li class="nav-item"><div class="dropdown">
							<button class="dropbtn">Tìm kiếm khóa học</button>
							<div class="dropdown-content">	
																				
							  <a href='<s:url action="loai"/>'>Loại</a>
						      <a href='<s:url action="chude"/>'>Chủ đề </a>  						      					       						   
						      <a href='<s:url action="khoahocmienphi"/>'>Khóa học miễn phí</a> 	
						       						       														
							</div>
						</div></li>		
						
				<li class="nav-item"><a class="nav-link" href='<s:url action="aboutUs"/>'>Tin đào tạo</a></li>		
		
				<li class="nav-item"><a class="nav-link" href='<s:url action="aboutUs"/>'>Liên
							Hệ</a></li>					
					
				</ul>
				
				
				  <!--Doan Code Tuyet Voi  -->		
	            <s:set var="username" value="false" />
                <s:if test='#session.containsKey("username")'>
	            <s:set var="username" value="true" />
                </s:if>	   <!--logout la ko vao dc bai giang nua.  -->
				
				
				<s:if test=" #username == false">	
				<ul class="navbar-nav ml-auto">
			    <li class="nav-item"><a class="nav-link" href='<s:url action="dangky"/>'> Đăng
							Ký </a></li>
					<li class="nav-item"><a class="nav-link" href='<s:url action="login"/>'> Đăng
							Nhập </a></li>
			    </ul>
				</s:if>	
				
				<s:if test=" #username == true">
				<ul class="navbar-nav ml-auto">	
				<li class="nav-item"><button class="dropbtn nav-link"> Xin chào, ${session.username} </button></li>
				<li class="nav-item"><a class="nav-link" href='<s:url action="logout"/>'> Đăng Xuất</a></li>								
				</ul>		
				</s:if>	
				
			</div>
		</nav>
	</div>
	<!-- End Header -->
</body>
</html>