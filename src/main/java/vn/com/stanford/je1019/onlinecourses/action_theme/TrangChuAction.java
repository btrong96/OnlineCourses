package vn.com.stanford.je1019.onlinecourses.action_theme;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;
import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;
import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.Loai;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.GiangVienDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;

public class TrangChuAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8441730584065276184L;
	
	@Autowired
	LoaiDAO loaiDao;
	@Autowired
	ChuDeDAO chuDeDao;
	@Autowired 
	CapDoDAO capDoDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	@Autowired
	GiangVienDAO giangVienDao;
	
	private List<Loai> lstLoai;
	private List<ChuDe> lstChuDe;
	private List<CapDo> lstCapDo;
	private List<KhoaHoc> lstKhoaHoc;
	private List<GiangVien> lstGiangVien;
	private List<ChuDe> lstChuDeTimKiemTheoLoai;
	
	private String chuDeTheoLoai;
	private String tenLoai;
	private Integer ma;
	private Map<String, Object> session;

	
	public LoaiDAO getLoaiDao() {
		return loaiDao;
	}

	public void setLoaiDao(LoaiDAO loaiDao) {
		this.loaiDao = loaiDao;
	}

	public List<Loai> getLstLoai() {
		return lstLoai;
	}

	public void setLstLoai(List<Loai> lstLoai) {
		this.lstLoai = lstLoai;
	}

	public ChuDeDAO getChuDeDao() {
		return chuDeDao;
	}

	public void setChuDeDao(ChuDeDAO chuDeDao) {
		this.chuDeDao = chuDeDao;
	}

	public List<ChuDe> getLstChuDe() {
		return lstChuDe;
	}

	public void setLstChuDe(List<ChuDe> lstChuDe) {
		this.lstChuDe = lstChuDe;
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

	public GiangVienDAO getGiangVienDao() {
		return giangVienDao;
	}

	public void setGiangVienDao(GiangVienDAO giangVienDao) {
		this.giangVienDao = giangVienDao;
	}

	public List<GiangVien> getLstGiangVien() {
		return lstGiangVien;
	}

	public void setLstGiangVien(List<GiangVien> lstGiangVien) {
		this.lstGiangVien = lstGiangVien;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<ChuDe> getLstChuDeTimKiemTheoLoai() {
		return lstChuDeTimKiemTheoLoai;
	}

	public void setLstChuDeTimKiemTheoLoai(List<ChuDe> lstChuDeTimKiemTheoLoai) {
		this.lstChuDeTimKiemTheoLoai = lstChuDeTimKiemTheoLoai;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public String getChuDeTheoLoai() {
		return chuDeTheoLoai;
	}

	public void setChuDeTheoLoai(String chuDeTheoLoai) {
		this.chuDeTheoLoai = chuDeTheoLoai;
	}
	
	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		lstGiangVien = giangVienDao.layDanhSach();
		
		session.put("danhSachLoai", false);
		
		return SUCCESS;
	}
	
	public String danhSachLoai() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		lstGiangVien = giangVienDao.layDanhSach();
		

		try {
			session.put("danhSachLoai", true);
		} catch (Exception e) {
			System.out.println("Loi Me No Roi");
		}
				
		return SUCCESS;
	}
	
	public String layChuDeTheoLoai() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		lstGiangVien = giangVienDao.layDanhSach();
		
        lstChuDeTimKiemTheoLoai = chuDeDao.timKiemChuDeTheoLoai(ma); 
        Loai objLoai = loaiDao.layChiTietTheoId(ma);
        tenLoai = objLoai.getTenLoai();
		
        chuDeTheoLoai = "chuDeTheoLoai";
        session.put("chuDeKhoaHoc", chuDeTheoLoai);
				
		return SUCCESS;
	}

}
