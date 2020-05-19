package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;
import vn.com.stanford.je1019.onlinecourses.entry.BaiGiang;

public interface BaiGiangDAO extends HanhDong<BaiGiang, Integer> {
	List<BaiGiang> timKiemBaiGiang(String tuKhoa, String moTaTimKiem,Integer maKhoaHocTimKiem);
	List<BaiGiang> timKiemBaiGiangTheoKhoaHoc(Integer maKhoaHocTimKiem, Boolean daDuyet, Boolean mienPhi);
	List<BaiGiang> timKiemBaiGiangDaDuyet(Boolean daDuyet, Boolean mienPhi);
	
	List<BaiGiang> timKiemBaiGiangTheoTen(String tenBaiGiang);       //De check trung
}
