package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;

public interface CapDoDAO extends HanhDong<CapDo, Integer> {

	List<CapDo> timKiemCapDoTheoTen(String tenCapDo);       //De check trung
}
