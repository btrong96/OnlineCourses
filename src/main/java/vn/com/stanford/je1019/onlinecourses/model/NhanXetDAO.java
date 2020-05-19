package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.NhanXet;

public interface NhanXetDAO extends HanhDong<NhanXet, Integer> {
   public List<NhanXet> timKiemNhanXet(Integer baiGiangTimKiem, Integer nguoiDungTimKiem);
}
