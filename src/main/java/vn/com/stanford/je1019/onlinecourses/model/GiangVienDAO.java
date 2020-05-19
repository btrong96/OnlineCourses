package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;

public interface GiangVienDAO extends HanhDong<GiangVien, Integer> {
	//Viết các hàm chỉ trong lớp GiangVien cần thực hiện 
		List<GiangVien> timKiemGiangVien(String tenGiangVien);
		
}
