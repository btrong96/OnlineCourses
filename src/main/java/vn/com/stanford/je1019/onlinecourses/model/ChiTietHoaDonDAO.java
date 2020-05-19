package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.ChiTietHoaDon;

public interface ChiTietHoaDonDAO extends HanhDong<ChiTietHoaDon, Integer> {
	List<ChiTietHoaDon> layChiTietTheoHoaDon_Id(Integer id);
}
