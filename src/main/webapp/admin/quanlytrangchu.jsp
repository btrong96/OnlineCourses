<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">


<s:set var="danhSach_1" value="false" />    <!-- Loai -->
<s:set var="danhSach_2" value="false" />    <!-- ChuDe -->
<s:set var="danhSach_8" value="false" />    <!-- CapDo -->
<s:set var="danhSach_3" value="false" />    <!-- KhoaHoc -->
<s:set var="danhSach_4" value="false" />    <!-- BaiGiang -->
<s:set var="danhSach_7" value="false" />    <!-- KhachHang -->
<s:set var="danhSach_5" value="false" />    <!-- NguoiDung -->
<s:set var="danhSach_15" value="false" />   <!-- NguoiDung_KhoaHoc -->
<s:set var="danhSach_6" value="false" />    <!-- GiangVien -->
<s:set var="danhSach_11" value="false" />   <!-- HoaDon -->
<s:set var="danhSach_16" value="false" />   <!-- ChiTietHoaDon -->
<s:set var="danhSach_12" value="false" />   <!-- NhanXet -->
<s:set var="danhSach_9" value="false" />    <!-- VaiTro -->
<s:set var="danhSach_14" value="false" />   <!-- ChucNang -->
<s:set var="danhSach_10" value="false" />   <!-- PhanQuyen -->
<s:set var="danhSach_13" value="false" />   <!-- NhatKy -->

<s:if test='#session.containsKey("danhSach_1")'>
	<s:set var="danhSach_1" value='#session["danhSach_1"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_2")'>
	<s:set var="danhSach_2" value='#session["danhSach_2"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_8")'>
	<s:set var="danhSach_8" value='#session["danhSach_8"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_3")'>
	<s:set var="danhSach_3" value='#session["danhSach_3"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_4")'>
	<s:set var="danhSach_4" value='#session["danhSach_4"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_7")'>
	<s:set var="danhSach_7" value='#session["danhSach_7"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_5")'>
	<s:set var="danhSach_5" value='#session["danhSach_5"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_15")'>
	<s:set var="danhSach_15" value='#session["danhSach_15"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_6")'>
	<s:set var="danhSach_6" value='#session["danhSach_6"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_11")'>
	<s:set var="danhSach_11" value='#session["danhSach_11"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_16")'>
	<s:set var="danhSach_16" value='#session["danhSach_16"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_12")'>
	<s:set var="danhSach_12" value='#session["danhSach_12"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_9")'>
	<s:set var="danhSach_9" value='#session["danhSach_9"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_14")'>
	<s:set var="danhSach_14" value='#session["danhSach_14"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_10")'>
	<s:set var="danhSach_10" value='#session["danhSach_10"]' />
</s:if>
<s:if test='#session.containsKey("danhSach_13")'>
	<s:set var="danhSach_13" value='#session["danhSach_13"]' />
</s:if>



<meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
   <title>Trang Chủ Quản Lý</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="app sidebar-mini rtl">
    <!-- Navbar-->
   <header class="app-header">
	<a class="app-header__logo" href='<s:url action="qltrangchu"/>'>HOME</a> <!-- Sidebar toggle button-->
	<a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
		aria-label="Hide Sidebar"></a> <!-- Navbar Right Menu-->
	<ul class="app-nav">
	
	<!-- Phan Search ko su dung -->
	<!--	<li class="app-search"><input class="app-search__input"
			type="search" placeholder="Search">
			<button class="app-search__button">
				<i class="fa fa-search"></i>
			</button></li>    	-->
			
			
			<li><a class="btn btn-primary" href="#"><i
						></i><h3> Xin chào, ${session.username} </h3></a></li>
			
			
		<!--Notification Menu-->
		<li class="dropdown"><a class="app-nav__item" href="#"
			data-toggle="dropdown" aria-label="Show notifications"><i
				class="fa fa-bell-o fa-lg"></i></a>
			<ul class="app-notification dropdown-menu dropdown-menu-right">
				<li class="app-notification__title">You have 4 new
					notifications.</li>
				<div class="app-notification__content">
					<li><a class="app-notification__item" href="javascript:;"><span
							class="app-notification__icon"><span
								class="fa-stack fa-lg"><i
									class="fa fa-circle fa-stack-2x text-primary"></i><i
									class="fa fa-envelope fa-stack-1x fa-inverse"></i></span></span>
							<div>
								<p class="app-notification__message">Lisa sent you a mail</p>
								<p class="app-notification__meta">2 min ago</p>
							</div></a></li>
					<li><a class="app-notification__item" href="javascript:;"><span
							class="app-notification__icon"><span
								class="fa-stack fa-lg"><i
									class="fa fa-circle fa-stack-2x text-danger"></i><i
									class="fa fa-hdd-o fa-stack-1x fa-inverse"></i></span></span>
							<div>
								<p class="app-notification__message">Mail server not working</p>
								<p class="app-notification__meta">5 min ago</p>
							</div></a></li>
					<li><a class="app-notification__item" href="javascript:;"><span
							class="app-notification__icon"><span
								class="fa-stack fa-lg"><i
									class="fa fa-circle fa-stack-2x text-success"></i><i
									class="fa fa-money fa-stack-1x fa-inverse"></i></span></span>
							<div>
								<p class="app-notification__message">Transaction complete</p>
								<p class="app-notification__meta">2 days ago</p>
							</div></a></li>
					<div class="app-notification__content">
						<li><a class="app-notification__item" href="javascript:;"><span
								class="app-notification__icon"><span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x text-primary"></i><i
										class="fa fa-envelope fa-stack-1x fa-inverse"></i></span></span>
								<div>
									<p class="app-notification__message">Lisa sent you a mail</p>
									<p class="app-notification__meta">2 min ago</p>
								</div></a></li>
						<li><a class="app-notification__item" href="javascript:;"><span
								class="app-notification__icon"><span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x text-danger"></i><i
										class="fa fa-hdd-o fa-stack-1x fa-inverse"></i></span></span>
								<div>
									<p class="app-notification__message">Mail server not
										working</p>
									<p class="app-notification__meta">5 min ago</p>
								</div></a></li>
						<li><a class="app-notification__item" href="javascript:;"><span
								class="app-notification__icon"><span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x text-success"></i><i
										class="fa fa-money fa-stack-1x fa-inverse"></i></span></span>
								<div>
									<p class="app-notification__message">Transaction complete</p>
									<p class="app-notification__meta">2 days ago</p>
								</div></a></li>
					</div>
				</div>
				<li class="app-notification__footer"><a href="#">See all
						notifications.</a></li>
			</ul></li>
		<!-- User Menu-->
		<li class="dropdown"><a class="app-nav__item" href="#"
			data-toggle="dropdown" aria-label="Open Profile Menu"><i
				class="fa fa-user fa-lg"></i></a>
			<ul class="dropdown-menu settings-menu dropdown-menu-right">
				<li><a class="dropdown-item" href="page-user.html"><i
						class="fa fa-cog fa-lg"></i> Settings</a></li>
				<li><a class="dropdown-item" href="page-user.html"><i
						class="fa fa-user fa-lg"></i> Profile</a></li>
				<li><a class="dropdown-item" href='<s:url action="logout"/>'><i
						class="fa fa-sign-out fa-lg"></i> Logout</a></li>
			</ul></li>
	</ul>
	</header>
    
    
    
    <!-- Sidebar menu-->
 <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
      <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
        <div>
          <p class="app-sidebar__user-name">Stanford Pro</p>
          <p class="app-sidebar__user-designation">Frontend Developer</p>
        </div>
      </div>
      <ul class="app-menu">
                                                   <!--   app-menu__icon fa fa-dashboard -->
        <li><a class="app-menu__item" href='<s:url action="qltrangchu"/>'><i class="fa fa-home fa-lg"></i><span class="app-menu__label"> Trang chủ</span></a></li>
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">Khóa Học Trực Tuyến</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
          
          <s:if test=" #danhSach_1 == true">
            <li><a class="treeview-item" href='<s:url action="qlloai"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Loại</a></li>
   <!--     <li><a class="treeview-item" href='<s:url action="qlchude"/>' target="_blank" rel="noopener"><i class="icon fa fa-circle-o"></i> Quản Lý Chủ Đề</a></li>   -->
          </s:if>
          
          <s:if test=" #danhSach_2 == true">
            <li><a class="treeview-item" href='<s:url action="qlchude"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Chủ Đề</a></li>
          </s:if>  
          
           <s:if test=" #danhSach_8 == true">
            <li><a class="treeview-item" href='<s:url action="qlcapdo"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Cấp Độ</a></li>
           </s:if> 
             
           <s:if test=" #danhSach_3 == true">  
            <li><a class="treeview-item" href='<s:url action="qlkhoahoc"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Khóa Học</a></li>
           </s:if> 
           
           <s:if test=" #danhSach_4 == true">
            <li><a class="treeview-item" href='<s:url action="qlbaigiang"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Bài Giảng</a></li>
           </s:if> 
            
          </ul>
        </li>       
             
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="fa fa-user fa-lg"></i><span class="app-menu__label">.Nhân Viên-Khách Hàng</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
           <s:if test=" #danhSach_7 == true">
            <li><a class="treeview-item" href='<s:url action="qlkhachhang"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Khách Hàng</a></li>
            </s:if>
            
           <s:if test=" #danhSach_5 == true">
            <li><a class="treeview-item" href='<s:url action="qlnguoidung"/>'><i class="icon fa fa-circle-o"></i>Quản Lý Người Dùng</a></li>
           </s:if>
           
            <s:if test=" #danhSach_15 == true">
            <li><a class="treeview-item" href='<s:url action="qlnguoidung_khoahoc"/>'><i class="icon fa fa-circle-o"></i>Người Dùng-Khóa Học</a></li>
            </s:if>
            
             <s:if test=" #danhSach_6 == true">
            <li><a class="treeview-item" href='<s:url action="qlgiangvien"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Giảng Viên</a></li>           
             </s:if>
          </ul>
        </li> 
        
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-book"></i><span class="app-menu__label">Quản Lý Hóa Đơn</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
           <s:if test=" #danhSach_11 == true">
            <li><a class="treeview-item" href='<s:url action="qlhoadon"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Hóa Đơn</a></li>     
           </s:if>
            <s:if test=" #danhSach_16 == true">
            <li><a class="treeview-item" href='<s:url action="qlchitiethoadon"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Chi Tiết Hóa Đơn</a></li>              
           </s:if>
          </ul>
        </li>        
        
        <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-edit"></i><span class="app-menu__label">Nhận Xét Của Học Viên</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">         
           <s:if test=" #danhSach_12 == true">
            <li><a class="treeview-item" href='<s:url action="qlnhanxet"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Nhận Xét</a></li>           
           </s:if>
          </ul>
        </li>
        <li class="treeview is-expanded"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-university"></i><span class="app-menu__label">Quản Lý Hệ Thống</span><i class="treeview-indicator fa fa-angle-right"></i></a>
          <ul class="treeview-menu">
          <s:if test=" #danhSach_9 == true">
            <li><a class="treeview-item" href='<s:url action="qlvaitro"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Vai Trò</a></li>
           </s:if>
           
           <s:if test=" #danhSach_14 == true">
            <li><a class="treeview-item" href='<s:url action="qlchucnang"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Chức Năng</a></li>
            </s:if>
            
            <s:if test=" #danhSach_10 == true">
            <li><a class="treeview-item" href='<s:url action="qlphanquyen"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Phân Quyền</a></li>
           </s:if>
           
           <s:if test=" #danhSach_13 == true">
            <li><a class="treeview-item active" href='<s:url action="qlnhatky"/>'><i class="icon fa fa-circle-o"></i> Quản Lý Nhật Ký</a></li>
           </s:if>
          </ul>
        </li>        
      </ul>
    </aside>
    
    
    
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-archive"></i>  Trang Chủ Quản Lý</h1>
         
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">Trung tâm đào tạo online</li>
          <li class="breadcrumb-item"><a href="#">TrangChu</a></li>
        </ul>
      </div>
            
     <s:if test=" #danhSach_10 == true"> 
     
      <div class="row">
        <div class="col-md-3">
          <div class="widget-small primary coloured-icon"><i class="icon fa fa-files-o fa-3x"></i>
            <div class="info">        
         <a href='<s:url action="qlloai"/>' > <h4>Quản Lý Loại</h4> </a>              
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-list fa-3x"></i>
            <div class="info">
            <a href='<s:url action="qlchude"/>' > <h4>quản lý Chủ Đề</h4> </a>           
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small warning coloured-icon"><i class="icon fa fa-object-group fa-3x"></i>
            <div class="info">
             <a href='<s:url action="qlkhoahoc"/>' > <h4>quản lý khóa học</h4></a>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small danger coloured-icon"><i class="icon fa fa-file-video-o fa-3x"></i>
            <div class="info">
             <a href='<s:url action="qlbaigiang"/>' > <h4>quản lý bài giảng</h4></a>             
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <div class="widget-small primary coloured-icon"><i class="icon fa fa-users fa-3x"></i>
            <div class="info">
           <a href='<s:url action="qlnguoidung"/>'> <h4>quản lý người dùng</h4> </a>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-user-circle-o fa-3x"></i>
            <div class="info">
            <a href='<s:url action="qlgiangvien"/>'>  <h4>quản lý giảng viên</h4></a>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small warning coloured-icon"><i class="icon fa fa-commenting-o fa-3x"></i>
            <div class="info">
              <a href='<s:url action="qlnhanxet"/>'> <h4>quản lý nhận xét</h4></a>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="widget-small danger coloured-icon"><i class="icon fa fa-fort-awesome fa-3x"></i>
            <div class="info">
             <a href='<s:url action="qlphanquyen"/>'> <h4>quản lý phân quyền</h4></a>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Chat</h3>
            <div class="messanger">
              <div class="messages">
                <div class="message"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/tonypeterson/48.jpg">
                  <p class="info">Hello there!<br>Good Morning</p>
                </div>
                <div class="message me"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg">
                  <p class="info">Hi<br>Good Morning</p>
                </div>
                <div class="message"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/tonypeterson/48.jpg">
                  <p class="info">How are you?</p>
                </div>
                <div class="message me"><img src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg">
                  <p class="info">I'm Fine.</p>
                </div>
              </div>
              <div class="sender">
                <input type="text" placeholder="Send Message">
                <button class="btn btn-primary" type="button"><i class="fa fa-lg fa-fw fa-paper-plane"></i></button>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="tile">
            <h3 class="tile-title">Vector Map</h3>
            <div class="tile-body">
              <div id="demo-map" style="height: 400px"></div>
            </div>
          </div>
        </div>
      </div>
      
      </s:if>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <script type="text/javascript" src="js/plugins/jquery.vmap.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.vmap.world.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.vmap.sampledata.js"></script>
    <script type="text/javascript">
      $(document).ready(function(){
      
      	var map = $('#demo-map');
      	map.vectorMap({
      		map: 'world_en',
      		backgroundColor: '#fff',
      		color: '#333',
      		hoverOpacity: 0.7,
      		selectedColor: '#666666',
      		enableZoom: true,
      		showTooltip: true,
      		scaleColors: ['#C8EEFF', '#006491'],
      		values: sample_data,
      		normalizeFunction: 'polynomial'
      	});
      });
    </script>
    <!-- Google analytics script-->
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>
  </body>
</html>