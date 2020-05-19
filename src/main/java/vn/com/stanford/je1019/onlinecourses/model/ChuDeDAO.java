package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;

public interface ChuDeDAO extends HanhDong<ChuDe, Integer>{

	List<ChuDe> timKiemChuDeTheoLoai(Integer maLoaiTimKiem);
	List<ChuDe> timKiemChuDeTheoTen(String tenChuDe);       //De check trung
}
