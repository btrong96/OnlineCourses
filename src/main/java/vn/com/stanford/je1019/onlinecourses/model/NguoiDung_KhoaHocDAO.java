package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung_KhoaHoc;

public interface NguoiDung_KhoaHocDAO extends HanhDong<NguoiDung_KhoaHoc, Integer> {
    public List<NguoiDung_KhoaHoc>  timKiemNguoiDung_KhoaHoc(Integer maNguoiDungTimKiem , Integer maKhoaHocTimKiem);
    public List<NguoiDung_KhoaHoc>  timKiemNguoiDung_KhoaHocTheoNguoiDungId(Integer maNguoiDungTimKiem);
}
