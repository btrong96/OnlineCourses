package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.PhanQuyen;

public interface PhanQuyenDAO extends HanhDong<PhanQuyen, Integer> {
    List<PhanQuyen> lstQuyenHan(Integer vaiTro, Integer chucNang);
   
}
