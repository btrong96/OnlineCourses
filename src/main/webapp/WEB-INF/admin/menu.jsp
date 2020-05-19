<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Khai báo trust. Mình Tự thêm. Khong Khai Bao No Die-->
<%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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

</head>
<body>
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
</body>
</html>