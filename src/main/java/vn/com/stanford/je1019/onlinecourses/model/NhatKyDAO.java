package vn.com.stanford.je1019.onlinecourses.model;

import java.sql.Date;
import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;

public interface NhatKyDAO extends HanhDong<NhatKy, Integer> {
	List<NhatKy> timKiemNhatKy(Date ngayNhatKy, Integer maNguoiDungTimKiem);
}
