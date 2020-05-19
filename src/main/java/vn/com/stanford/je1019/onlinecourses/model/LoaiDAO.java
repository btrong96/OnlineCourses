package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;
import vn.com.stanford.je1019.onlinecourses.entry.Loai;

public interface LoaiDAO extends HanhDong<Loai, Integer>{

	List<Loai> timKiemLoaiTheoTen(String tenLoai);       //De check trung
}
