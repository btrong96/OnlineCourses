package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.KhachHang;

public interface KhachHangDAO extends HanhDong<KhachHang, Integer>{
	List<KhachHang> timKiemKhachHang(String tenKhachHang);
}
