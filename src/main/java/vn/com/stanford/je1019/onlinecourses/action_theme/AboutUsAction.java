package vn.com.stanford.je1019.onlinecourses.action_theme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;
import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.Loai;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;

public class AboutUsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5793883419680583008L;

	@Autowired
	LoaiDAO loaiDao;
	@Autowired
	ChuDeDAO chuDeDao;
	@Autowired 
	CapDoDAO capDoDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	
	private List<Loai> lstLoai;
	private List<ChuDe> lstChuDe;
	private List<CapDo> lstCapDo;
	private List<KhoaHoc> lstKhoaHoc;
	
	public LoaiDAO getLoaiDao() {
		return loaiDao;
	}

	public void setLoaiDao(LoaiDAO loaiDao) {
		this.loaiDao = loaiDao;
	}

	public ChuDeDAO getChuDeDao() {
		return chuDeDao;
	}

	public void setChuDeDao(ChuDeDAO chuDeDao) {
		this.chuDeDao = chuDeDao;
	}

	public CapDoDAO getCapDoDao() {
		return capDoDao;
	}

	public void setCapDoDao(CapDoDAO capDoDao) {
		this.capDoDao = capDoDao;
	}

	public KhoaHocDAO getKhoaHocDao() {
		return khoaHocDao;
	}

	public void setKhoaHocDao(KhoaHocDAO khoaHocDao) {
		this.khoaHocDao = khoaHocDao;
	}

	public List<Loai> getLstLoai() {
		return lstLoai;
	}

	public void setLstLoai(List<Loai> lstLoai) {
		this.lstLoai = lstLoai;
	}

	public List<ChuDe> getLstChuDe() {
		return lstChuDe;
	}

	public void setLstChuDe(List<ChuDe> lstChuDe) {
		this.lstChuDe = lstChuDe;
	}

	public List<CapDo> getLstCapDo() {
		return lstCapDo;
	}

	public void setLstCapDo(List<CapDo> lstCapDo) {
		this.lstCapDo = lstCapDo;
	}

	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		return SUCCESS;
	}
}
