package vn.com.stanford.je1019.onlinecourses.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung_KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDung_KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class NguoiDung_KhoaHocAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9795860519731834L;

	@Autowired 
	NguoiDung_KhoaHocDAO nguoiDung_KhoaHocDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	private List<NguoiDung_KhoaHoc>  lstNguoiDung_KhoaHoc;
	private List<KhoaHoc> lstKhoaHoc;
	private Integer id;
	private Integer khoaHocId;
	private Date ngayCap;
	private String tenNguoiDung;
	private String tenKhoaHoc;
	private String nguoiDung_KhoaHoc;
	private Integer maNguoiDungTimKiem;
	private Integer maKhoaHocTimKiem;
	
	/**
	 *   Nhat Ky
	 */
	@Autowired
	NguoiDungDAO nguoiDungDao;
	@Autowired
	NhatKyDAO nhatKyDao;
	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
	private String taiKhoanUser;
	private String matKhauUser;
	private List<NguoiDung> lstNguoiDung;
	private Integer nguoiDungId;	
	private Map<String, Object> session;	
	private String StrHoatDong;
	
	private String tenNguoiDung_Old;
	private String tenKhoaHoc_Old;
	
	
	public NguoiDung_KhoaHocDAO getNguoiDung_KhoaHocDao() {
		return nguoiDung_KhoaHocDao;
	}
	
	public void setNguoiDung_KhoaHocDao(NguoiDung_KhoaHocDAO nguoiDung_KhoaHocDao) {
		this.nguoiDung_KhoaHocDao = nguoiDung_KhoaHocDao;
	}

	public List<NguoiDung_KhoaHoc> getLstNguoiDung_KhoaHoc() {
		return lstNguoiDung_KhoaHoc;
	}

	public void setLstNguoiDung_KhoaHoc(List<NguoiDung_KhoaHoc> lstNguoiDung_KhoaHoc) {
		this.lstNguoiDung_KhoaHoc = lstNguoiDung_KhoaHoc;
	}

	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

	public NhatKyDAO getNhatKyDao() {
		return nhatKyDao;
	}

	public void setNhatKyDao(NhatKyDAO nhatKyDao) {
		this.nhatKyDao = nhatKyDao;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public String getTaiKhoanUser() {
		return taiKhoanUser;
	}

	public void setTaiKhoanUser(String taiKhoanUser) {
		this.taiKhoanUser = taiKhoanUser;
	}

	public String getMatKhauUser() {
		return matKhauUser;
	}

	public void setMatKhauUser(String matKhauUser) {
		this.matKhauUser = matKhauUser;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
	}

	public Integer getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public KhoaHocDAO getKhoaHocDao() {
		return khoaHocDao;
	}

	public void setKhoaHocDao(KhoaHocDAO khoaHocDao) {
		this.khoaHocDao = khoaHocDao;
	}

	public Integer getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNguoiDung_KhoaHoc() {
		return nguoiDung_KhoaHoc;
	}

	public void setNguoiDung_KhoaHoc(String nguoiDung_KhoaHoc) {
		this.nguoiDung_KhoaHoc = nguoiDung_KhoaHoc;
	}

	public String getTenNguoiDung_Old() {
		return tenNguoiDung_Old;
	}

	public void setTenNguoiDung_Old(String tenNguoiDung_Old) {
		this.tenNguoiDung_Old = tenNguoiDung_Old;
	}

	public String getTenKhoaHoc_Old() {
		return tenKhoaHoc_Old;
	}

	public void setTenKhoaHoc_Old(String tenKhoaHoc_Old) {
		this.tenKhoaHoc_Old = tenKhoaHoc_Old;
	}

	public Integer getMaNguoiDungTimKiem() {
		return maNguoiDungTimKiem;
	}

	public void setMaNguoiDungTimKiem(Integer maNguoiDungTimKiem) {
		this.maNguoiDungTimKiem = maNguoiDungTimKiem;
	}

	public Integer getMaKhoaHocTimKiem() {
		return maKhoaHocTimKiem;
	}

	public void setMaKhoaHocTimKiem(Integer maKhoaHocTimKiem) {
		this.maKhoaHocTimKiem = maKhoaHocTimKiem;
	}

	@Override
	public String execute() throws Exception {
		lstNguoiDung = nguoiDungDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
		lstNguoiDung_KhoaHoc = nguoiDung_KhoaHocDao.layDanhSach();
		return SUCCESS;
	}

	
	/**
	 * Nhat Ky (Common Method)
	 */
	public void comm(String StrHoatDong) {

		NhatKy objNhatKy = new NhatKy();
		try {
			taiKhoanUser = (String) session.get("username");
			matKhauUser = (String) session.get("password");
			lstNguoiDung = nguoiDungDao.timKiemNguoiDungLogin(taiKhoanUser, matKhauUser);
			for (NguoiDung nd : lstNguoiDung) {
				nguoiDungId = nd.getId();
			}

			objNhatKy.setUserName(taiKhoanUser);
			objNhatKy.setNguoiDungId(nguoiDungId);

		} catch (Exception e) {
			// TODO: handle exception
		}

		objNhatKy.setNgay(sqlDate);
		objNhatKy.setChucNang("Quan ly NguoiDung- KhoaHoc");
		objNhatKy.setHoatDong(StrHoatDong);		
		nhatKyDao.themMoi(objNhatKy);
	}
	
	/**
	 * Ham them moi
	 * 
	 */
	public String themNguoiDung_KhoaHoc() {
		
		NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = new NguoiDung_KhoaHoc();
		
		objNguoiDung_KhoaHoc.setNguoiDungId(nguoiDungId);
		objNguoiDung_KhoaHoc.setKhoaHocId(khoaHocId);
		objNguoiDung_KhoaHoc.setNgayCap(ngayCap);
		
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		objNguoiDung_KhoaHoc.setTenNguoiDung(tenNguoiDung);
		
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		objNguoiDung_KhoaHoc.setTenKhoaHoc(tenKhoaHoc);
		
		nguoiDung_KhoaHocDao.themMoi(objNguoiDung_KhoaHoc);
				
					
		/**
		 *   Nhat Ky
		 */				
		StrHoatDong = "Them doi tuong NguoiDung_KhoaHoc: " + " (Ten Nguoi Dung: " + tenNguoiDung + "), ( Ten Khoa Hoc: " + tenKhoaHoc +
				"), (Ngay Cap:" + ngayCap +")" ;		
		comm(StrHoatDong);
						
		return SUCCESS;
	}
	
	
	/**
	 * Ham lay thong tin chi tiet 
	 * 
	 */
	public String layThongTinChiTietNguoiDung_KhoaHoc() {
		// Lay thong tin theo id
		NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = nguoiDung_KhoaHocDao.layChiTietTheoId(id);
		// Convert ve dang json
	     setNguoiDung_KhoaHoc(new Gson().toJson(objNguoiDung_KhoaHoc));
		
		
		/**
		 *   Nhat Ky
		 */
	     nguoiDungId = objNguoiDung_KhoaHoc.getNguoiDungId();
	     NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
	     tenNguoiDung_Old = objNguoiDung.getHoTen();
	     session.put("tenNguoiDung_Cu", tenNguoiDung_Old);
	     
	     khoaHocId = objNguoiDung_KhoaHoc.getKhoaHocId();
	     KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
	     tenKhoaHoc_Old = objKhoaHoc.getTenKhoaHoc();
	     session.put("tenKhoaHoc_Cu", tenKhoaHoc_Old);
	     
		return SUCCESS;
	}
	
	/**
	 * Ham cap nhat thong tin
	 * 
	 */
	public String capNhatNguoiDung_KhoaHoc() {
		
	NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = new NguoiDung_KhoaHoc();
		
	    objNguoiDung_KhoaHoc.setId(id);
		objNguoiDung_KhoaHoc.setNguoiDungId(nguoiDungId);
		objNguoiDung_KhoaHoc.setKhoaHocId(khoaHocId);
		objNguoiDung_KhoaHoc.setNgayCap(ngayCap);
		
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		objNguoiDung_KhoaHoc.setTenNguoiDung(tenNguoiDung);
		
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		objNguoiDung_KhoaHoc.setTenKhoaHoc(tenKhoaHoc);
		
		nguoiDung_KhoaHocDao.capNhat(objNguoiDung_KhoaHoc);

				
		/**
		 *   Nhat Ky
		 */
		tenNguoiDung_Old = (String) session.get("tenNguoiDung_Cu");
		tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");	
		
		StrHoatDong = "Cap nhat doi tuong NguoiDung_KhoaHoc: " + " (Ten Nguoi Dung: " + tenNguoiDung_Old + "), ( Ten Khoa Hoc: " + tenKhoaHoc_Old +")" 
				+ " => CAP NHAT THANH " + " (Ten Nguoi Dung: " + tenNguoiDung + "), ( Ten Khoa Hoc: " + tenKhoaHoc +")";
				
		comm(StrHoatDong);
						
		return SUCCESS;
	}
	
	
	/**
	 * Ham xoa
	 * 
	 */
	public String xoaNguoiDung_KhoaHoc() {
		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = nguoiDung_KhoaHocDao.layChiTietTheoId(id);
		
		nguoiDungId = objNguoiDung_KhoaHoc.getNguoiDungId();
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		
		khoaHocId = objNguoiDung_KhoaHoc.getKhoaHocId();
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		
		StrHoatDong = "Xoa doi tuong NguoiDung_KhoaHoc: " + " (Ten Nguoi Dung: " + tenNguoiDung + "), ( Ten Khoa Hoc: " + tenKhoaHoc +")" ;		
		comm(StrHoatDong);
		
		// Thuc hien xoa
		nguoiDung_KhoaHocDao.xoa(id);
		
		return SUCCESS;
	}
	
	
	public String timKiemNguoiDung_KhoaHoc() {
		
		lstNguoiDung = nguoiDungDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
		lstNguoiDung_KhoaHoc = nguoiDung_KhoaHocDao.timKiemNguoiDung_KhoaHoc(maNguoiDungTimKiem, maKhoaHocTimKiem);
			
		
		return SUCCESS;
	}
	
	/**
	 *   Nhat Ky
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
