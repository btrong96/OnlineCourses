package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;

public interface NguoiDungDAO extends HanhDong<NguoiDung, Integer> {	
	List<NguoiDung> timKiemAD(Integer vaiTroId);
	List<NguoiDung>  timKiemNguoiDungLogin(String taiKhoan, String matKhau);
	
	List<NguoiDung> timKiemNguoiDungTheoTen(String taiKhoan);       //De check trung
}
