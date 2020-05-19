package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.ChiTietHoaDon;
import vn.com.stanford.je1019.onlinecourses.entry.HoaDon;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.ChiTietHoaDonDAO;
import vn.com.stanford.je1019.onlinecourses.model.HoaDonDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class ChiTietHoaDonAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282049668068559134L;

	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	@Autowired
	HoaDonDAO hoaDonDao;
	private List<ChiTietHoaDon> lstChiTietHoaDon;
	private List<HoaDon> lstHoaDon;
	private List<KhoaHoc> lstKhoaHoc;
	private Integer id;
	private Integer soLuong;
	private Double thanhToan;
	private String moTa;
	private Integer hoaDonId;
	private Integer khoaHocId;				
	private String tenKhoaHoc;
	private String  chiTietHoaDon;
	
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
	
	private Integer soLuong_Old;
	private Double thanhToan_Old;
	private String moTa_Old;
	private Integer hoaDonId_Old;				
	private String tenKhoaHoc_Old;
	
	public ChiTietHoaDonDAO getChiTietHoaDonDao() {
		return chiTietHoaDonDao;
	}
	
	public void setChiTietHoaDonDao(ChiTietHoaDonDAO chiTietHoaDonDao) {
		this.chiTietHoaDonDao = chiTietHoaDonDao;
	}

	public List<ChiTietHoaDon> getLstChiTietHoaDon() {
		return lstChiTietHoaDon;
	}

	public void setLstChiTietHoaDon(List<ChiTietHoaDon> lstChiTietHoaDon) {
		this.lstChiTietHoaDon = lstChiTietHoaDon;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(Double thanhToan) {
		this.thanhToan = thanhToan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getHoaDonId() {
		return hoaDonId;
	}

	public void setHoaDonId(Integer hoaDonId) {
		this.hoaDonId = hoaDonId;
	}

	public Integer getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
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

	public List<HoaDon> getLstHoaDon() {
		return lstHoaDon;
	}

	public void setLstHoaDon(List<HoaDon> lstHoaDon) {
		this.lstHoaDon = lstHoaDon;
	}

	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	public HoaDonDAO getHoaDonDao() {
		return hoaDonDao;
	}

	public void setHoaDonDao(HoaDonDAO hoaDonDao) {
		this.hoaDonDao = hoaDonDao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(String chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	public Integer getSoLuong_Old() {
		return soLuong_Old;
	}

	public void setSoLuong_Old(Integer soLuong_Old) {
		this.soLuong_Old = soLuong_Old;
	}

	public Double getThanhToan_Old() {
		return thanhToan_Old;
	}

	public void setThanhToan_Old(Double thanhToan_Old) {
		this.thanhToan_Old = thanhToan_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public Integer getHoaDonId_Old() {
		return hoaDonId_Old;
	}

	public void setHoaDonId_Old(Integer hoaDonId_Old) {
		this.hoaDonId_Old = hoaDonId_Old;
	}

	public String getTenKhoaHoc_Old() {
		return tenKhoaHoc_Old;
	}

	public void setTenKhoaHoc_Old(String tenKhoaHoc_Old) {
		this.tenKhoaHoc_Old = tenKhoaHoc_Old;
	}

	/**
	 * Ham lay danh sach 
	 * 
	 */
	@Override
	public String execute() throws Exception {
		
		lstHoaDon = hoaDonDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
		lstChiTietHoaDon = chiTietHoaDonDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Chi Tiet Hoa Don");
		objNhatKy.setHoatDong(StrHoatDong);		
		nhatKyDao.themMoi(objNhatKy);
	}
		
	/**
	 * Ham them moi
	 * 
	 */
	public String themChiTietHoaDon() {
				
		ChiTietHoaDon objChiTietHoaDon = new ChiTietHoaDon();
		
		objChiTietHoaDon.setSoLuong(soLuong);
		objChiTietHoaDon.setThanhToan(thanhToan);
		objChiTietHoaDon.setMoTa(moTa);
		objChiTietHoaDon.setHoaDonId(hoaDonId);
		objChiTietHoaDon.setKhoaHocId(khoaHocId);
		
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		objChiTietHoaDon.setTenKhoaHoc(tenKhoaHoc);
		
	    chiTietHoaDonDao.themMoi(objChiTietHoaDon);
					
		/**
		 *   Nhat Ky
		 */				
		StrHoatDong = "Them doi tuong Chi Tiet Hoa Don: " + " (So Luong: " + soLuong + "), ( Thanh Toan: " + thanhToan 
				+ "),( Mo Ta:" + moTa +	"), (Id Hoa Don: " + hoaDonId + "), (Ten Khoa Hoc: " + tenKhoaHoc + ")";		
		comm(StrHoatDong);
						
		return SUCCESS;
	}

	/**
	 * Ham lay thong tin chi tiet loai theo id, ket qua dang json
	 * 
	 */
	public String layThongTinChiTietChiTietHoaDon() {
		// Lay thong tin theo id
		ChiTietHoaDon objChiTietHoaDon = chiTietHoaDonDao.layChiTietTheoId(id);
		
		setChiTietHoaDon(new Gson().toJson(objChiTietHoaDon));
		
		/**
		 *   Nhat Ky
		 */
		soLuong_Old = objChiTietHoaDon.getSoLuong();
		session.put("soLuong_Cu", soLuong_Old);		
		thanhToan_Old = objChiTietHoaDon.getThanhToan();
		session.put("thanhToan_Cu", thanhToan_Old);
		moTa_Old = objChiTietHoaDon.getMoTa();
		session.put("moTa_Cu", moTa_Old);
		hoaDonId_Old = objChiTietHoaDon.getHoaDonId();
		session.put("hoaDonId_Cu", hoaDonId_Old);
		tenKhoaHoc_Old = objChiTietHoaDon.getTenKhoaHoc();
		session.put("tenKhoaHoc_Cu", tenKhoaHoc_Old);
		 
		return SUCCESS;
	}
	
	/**
	 * Ham cap nhat thong tin
	 * 
	 */
	public String capNhatChiTietHoaDon() {
		
        ChiTietHoaDon objChiTietHoaDon = new ChiTietHoaDon();
        objChiTietHoaDon.setId(id);
        
		objChiTietHoaDon.setSoLuong(soLuong);
		objChiTietHoaDon.setThanhToan(thanhToan);
		objChiTietHoaDon.setMoTa(moTa);
		objChiTietHoaDon.setHoaDonId(hoaDonId);
		objChiTietHoaDon.setKhoaHocId(khoaHocId);
		
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		objChiTietHoaDon.setTenKhoaHoc(tenKhoaHoc);
		chiTietHoaDonDao.capNhat(objChiTietHoaDon);
		
		/**
		 *   Nhat Ky
		 */
		
		soLuong_Old = (Integer) session.get("soLuong_Cu");
		thanhToan_Old = (Double) session.get("thanhToan_Cu");
		moTa_Old = (String) session.get("moTa_Cu");
		hoaDonId_Old = (Integer) session.get("hoaDonId_Cu");
		tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");
				
		
		StrHoatDong = "Cap nhat doi tuong Chi Tiet Hoa Don: "  + " (So Luong: " + soLuong_Old + "), ( Thanh Toan: " + thanhToan_Old 
				+ "),( Mo Ta:" + moTa_Old +	"), (Id Hoa Don: " + hoaDonId_Old + "), (Ten Khoa Hoc: " + tenKhoaHoc_Old + ")"		
				+ " => CAP NHAT THANH "  + " (So Luong: " + soLuong + "), ( Thanh Toan: " + thanhToan 
				+ "),( Mo Ta:" + moTa +	"), (Id Hoa Don: " + hoaDonId + "), (Ten Khoa Hoc: " + tenKhoaHoc + ")";	
				
		comm(StrHoatDong);
						
		return SUCCESS;
	}
	
	/**
	 * Ham xoa
	 * 
	 */
	public String xoaChiTietHoaDon() {
		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		ChiTietHoaDon objChiTietHoaDon = chiTietHoaDonDao.layChiTietTheoId(id);
		
		soLuong = objChiTietHoaDon.getSoLuong();
		thanhToan = objChiTietHoaDon.getThanhToan();
		moTa = objChiTietHoaDon.getMoTa();
		hoaDonId = objChiTietHoaDon.getHoaDonId();
		tenKhoaHoc = objChiTietHoaDon.getTenKhoaHoc();
				
		StrHoatDong = "Xoa doi tuong Chi Tiet Hoa Don: " + " (So Luong: " + soLuong + "), ( Thanh Toan: " + thanhToan 
				+ "),( Mo Ta:" + moTa +	"), (Id Hoa Don: " + hoaDonId + "), (Ten Khoa Hoc: " + tenKhoaHoc + ")";		
		comm(StrHoatDong);
		
		// Thuc hien xoa
		chiTietHoaDonDao.xoa(id);
		 
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
