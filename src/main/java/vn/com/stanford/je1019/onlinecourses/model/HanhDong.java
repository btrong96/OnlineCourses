package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

public interface HanhDong<T, idT> {

	List<T> layDanhSach();
	
	T layChiTietTheoId(idT id);
	
	boolean themMoi(T obj);
	
	boolean capNhat(T obj);
	
	boolean xoa(idT id);
}
