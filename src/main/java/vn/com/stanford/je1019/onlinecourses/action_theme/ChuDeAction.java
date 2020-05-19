package vn.com.stanford.je1019.onlinecourses.action_theme;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
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

public class ChuDeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1533038159408725449L;
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
	
	private List<KhoaHoc> lstKhoaHocTimKiemTheoChuDe;
	private Integer ma;
	private String khoaHocTheoChuDe;
	
			
	private Map<String, Object> session;
	private  String all;
	private String tenChuDe;
	
	
	
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

	public List<KhoaHoc> getLstKhoaHocTimKiemTheoChuDe() {
		return lstKhoaHocTimKiemTheoChuDe;
	}
	public void setLstKhoaHocTimKiemTheoChuDe(List<KhoaHoc> lstKhoaHocTimKiemTheoChuDe) {
		this.lstKhoaHocTimKiemTheoChuDe = lstKhoaHocTimKiemTheoChuDe;
	}
	public String getAll() {
		return all;
	}
	public void setAll(String all) {
		this.all = all;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	public String getKhoaHocTheoChuDe() {
		return khoaHocTheoChuDe;
	}
	public void setKhoaHocTheoChuDe(String khoaHocTheoChuDe) {
		this.khoaHocTheoChuDe = khoaHocTheoChuDe;
	}
	public Integer getMa() {
		return ma;
	}
	public void setMa(Integer ma) {
		this.ma = ma;
	}
	public String getTenChuDe() {
		return tenChuDe;
	}
	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}
	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
			
		all = "all";
		session.put("chuDeKhoaHoc", all);
						
		return SUCCESS;
	}
	
	
	public String layKhoaHocTheoChuDe() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();		
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		
		
        lstKhoaHocTimKiemTheoChuDe = khoaHocDao.timKiemKhoaHocTheoChuDe_CapDo(ma, null, true);
        
        khoaHocTheoChuDe = "khoaHocTheoChuDe";
		session.put("khoaHoc", khoaHocTheoChuDe);
        
		ChuDe objChuDe = chuDeDao.layChiTietTheoId(ma);
		tenChuDe = objChuDe.getTenChuDe();
			
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;    // CHU Y CHO NAY
		
	}
}
