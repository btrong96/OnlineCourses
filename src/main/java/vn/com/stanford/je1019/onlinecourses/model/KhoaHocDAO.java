package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;

public interface KhoaHocDAO extends HanhDong<KhoaHoc, Integer>{
	List<KhoaHoc> timKiemKhoaHoc(String tuKhoa, Integer maChuDeTimKiem, Integer maCapDoTimKiem, Integer maGiangVienTimKiem);
	List<KhoaHoc> timKiemKhoaHocTheoChuDe_CapDo(Integer maChuDeTimKiem,Integer maCapDoTimKiem, Boolean daDuyet);
	List<KhoaHoc> timKiemKhoaHocDaDuyet( Boolean daDuyet);
	
	List<KhoaHoc> timKiemKhoaHocTheoTen(String tenKhoaHoc);       //De check trung
	List<KhoaHoc> timKiemKhoaHocMienPhi(Boolean mienPhi);
	
}
