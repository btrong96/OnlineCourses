package vn.com.stanford.je1019.onlinecourses.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.BaiGiang;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhanXet;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhanXetDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class NhanXetAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7086490487590746276L;

	@Autowired
	NhanXetDAO nhanXetDao;
	@Autowired
	BaiGiangDAO baiGiangDao;
	
	private List<NhanXet> lstNhanXet;
	private List<BaiGiang> lstBaiGiang;
	private Integer id;	
    private String noiDung;
    private Date thoiGianTao;
    private Date thoiGianCapNhat;
    private Integer baiGiangId;
    private Integer nguoiDungId;
    private String tenBaiGiang;
    private String tenNguoiDung;
    private String nhanXet;
	
    private Integer maBaiGiangTimKiem;	
    private Integer maNguoiDungTimKiem;	
    
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
	private Map<String, Object> session;	
	private String StrHoatDong;
	
	private String tenBaiGiang_Old;
	private String tenNguoiDung_Old;
	private String noiDung_Old;
		
	public NhanXetDAO getNhanXetDao() {
		return nhanXetDao;
	}

	public void setNhanXetDao(NhanXetDAO nhanXetDao) {
		this.nhanXetDao = nhanXetDao;
	}

	public List<NhanXet> getLstNhanXet() {
		return lstNhanXet;
	}

	public void setLstNhanXet(List<NhanXet> lstNhanXet) {
		this.lstNhanXet = lstNhanXet;
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

	public BaiGiangDAO getBaiGiangDao() {
		return baiGiangDao;
	}

	public void setBaiGiangDao(BaiGiangDAO baiGiangDao) {
		this.baiGiangDao = baiGiangDao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}

	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}

	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public Integer getBaiGiangId() {
		return baiGiangId;
	}

	public void setBaiGiangId(Integer baiGiangId) {
		this.baiGiangId = baiGiangId;
	}

	public String getTenBaiGiang() {
		return tenBaiGiang;
	}

	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public List<BaiGiang> getLstBaiGiang() {
		return lstBaiGiang;
	}

	public void setLstBaiGiang(List<BaiGiang> lstBaiGiang) {
		this.lstBaiGiang = lstBaiGiang;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public String getTenBaiGiang_Old() {
		return tenBaiGiang_Old;
	}

	public void setTenBaiGiang_Old(String tenBaiGiang_Old) {
		this.tenBaiGiang_Old = tenBaiGiang_Old;
	}

	public String getTenNguoiDung_Old() {
		return tenNguoiDung_Old;
	}

	public void setTenNguoiDung_Old(String tenNguoiDung_Old) {
		this.tenNguoiDung_Old = tenNguoiDung_Old;
	}

	public String getNoiDung_Old() {
		return noiDung_Old;
	}

	public void setNoiDung_Old(String noiDung_Old) {
		this.noiDung_Old = noiDung_Old;
	}

	public Integer getMaBaiGiangTimKiem() {
		return maBaiGiangTimKiem;
	}

	public void setMaBaiGiangTimKiem(Integer maBaiGiangTimKiem) {
		this.maBaiGiangTimKiem = maBaiGiangTimKiem;
	}

	public Integer getMaNguoiDungTimKiem() {
		return maNguoiDungTimKiem;
	}

	public void setMaNguoiDungTimKiem(Integer maNguoiDungTimKiem) {
		this.maNguoiDungTimKiem = maNguoiDungTimKiem;
	}

	/**
	 * Ham lay danh sach 
	 * 
	 */
	@Override
	public String execute() throws Exception {
	
		lstNhanXet = nhanXetDao.layDanhSach();
		lstBaiGiang = baiGiangDao.layDanhSach();
		lstNguoiDung = nguoiDungDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Nhan Xet");
		objNhatKy.setHoatDong(StrHoatDong);		
		nhatKyDao.themMoi(objNhatKy);
	}
	
	/**
	 * Ham them moi
	 * 
	 */
	public String themNhanXet() {
			
		NhanXet objNhanXet = new NhanXet();
			
		objNhanXet.setBaiGiangId(baiGiangId);
		objNhanXet.setNguoiDungId(nguoiDungId);
		objNhanXet.setThoiGianTao(thoiGianTao);
		objNhanXet.setThoiGianCapNhat(thoiGianCapNhat);
		objNhanXet.setNoiDung(noiDung);
		
		BaiGiang objBaiGiang = baiGiangDao.layChiTietTheoId(baiGiangId);
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
		objNhanXet.setTenBaiGiang(tenBaiGiang);
		
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		objNhanXet.setTenNguoiDung(tenNguoiDung);
		
		nhanXetDao.themMoi(objNhanXet);
					
		/**
		 *   Nhat Ky
		 */				
		StrHoatDong = "Them doi tuong Nhan Xet: " + " (Ten Bai Giang: " + tenBaiGiang + "), ( Ten Nguoi Dung: " + tenNguoiDung 
				+"), (Noi Dung: " + noiDung + ")";		
		comm(StrHoatDong);
						
		return SUCCESS;
	}
	
	
	/**
	 * Ham lay thong tin chi tiet
	 * 
	 */
	public String layThongTinChiTietNhanXet() {
		// Lay thong tin theo id
		
		NhanXet objNhanXet = nhanXetDao.layChiTietTheoId(id);

		// Convert ve dang json
	     setNhanXet(new Gson().toJson(objNhanXet));
		
		/**
		 *   Nhat Ky
		 */
	     
	     baiGiangId = objNhanXet.getBaiGiangId();
	     BaiGiang objBaiGiang = baiGiangDao.layChiTietTheoId(baiGiangId);
	     tenBaiGiang_Old = objBaiGiang.getTenBaiGiang();
	     session.put("tenBaiGiang_Cu", tenBaiGiang_Old);
	     
	     nguoiDungId = objNhanXet.getNguoiDungId();
	     NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
	     tenNguoiDung_Old = objNguoiDung.getHoTen();
	     session.put("tenNguoiDung_Cu", tenNguoiDung_Old);
	     
	     noiDung_Old = objNhanXet.getNoiDung();
	     session.put("noiDung_Cu", noiDung_Old);
		 
		return SUCCESS;
	}
	
	/**
	 * Ham cap nhat thong tin
	 * 
	 */
	public String capNhatNhanXet() {
		
		NhanXet objNhanXet =  new NhanXet();
		
		objNhanXet.setId(id);
		objNhanXet.setBaiGiangId(baiGiangId);
		objNhanXet.setNguoiDungId(nguoiDungId);
		objNhanXet.setThoiGianTao(thoiGianTao);
		objNhanXet.setThoiGianCapNhat(thoiGianCapNhat);
		objNhanXet.setNoiDung(noiDung);
		
		BaiGiang objBaiGiang = baiGiangDao.layChiTietTheoId(baiGiangId);
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
		objNhanXet.setTenBaiGiang(tenBaiGiang);
		
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		objNhanXet.setTenNguoiDung(tenNguoiDung);
		
		nhanXetDao.capNhat(objNhanXet);
		
		/**
		 *   Nhat Ky
		 */
		tenBaiGiang_Old =(String) session.get("tenBaiGiang_Cu");
		tenNguoiDung_Old =(String) session.get("tenNguoiDung_Cu");
		noiDung_Old = (String) session.get("noiDung_Cu");

		StrHoatDong = "Cap nhat doi tuong Nhan Xet: " +  " (Ten Bai Giang: " + tenBaiGiang_Old + "), ( Ten Nguoi Dung: " + tenNguoiDung_Old 
				+"), (Noi Dung: " + noiDung_Old + ")"		
				+ " => CAP NHAT THANH " + " (Ten Bai Giang: " + tenBaiGiang + "), ( Ten Nguoi Dung: " + tenNguoiDung 
				+"), (Noi Dung: " + noiDung + ")";		
				
		comm(StrHoatDong);
						
		return SUCCESS;
	}
	
	
	/**
	 * Ham xoa
	 * 
	 */
	public String xoaNhanXet() {
		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		NhanXet objNhanXet = nhanXetDao.layChiTietTheoId(id);
		
		baiGiangId = objNhanXet.getBaiGiangId();
		BaiGiang objBaiGiang = baiGiangDao.layChiTietTheoId(baiGiangId);
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
		
		nguoiDungId = objNhanXet.getNguoiDungId();
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getHoTen();
		
		noiDung = objNhanXet.getNoiDung();

		
		StrHoatDong = "Xoa doi tuong Nhan Xet: " + " (Ten Bai Giang: " + tenBaiGiang + "), ( Ten Nguoi Dung: " + tenNguoiDung 
				+"), (Noi Dung: " + noiDung + ")";		
		comm(StrHoatDong);
		
		// Thuc hien xoa
		  nhanXetDao.xoa(id);
		
		return SUCCESS;
	}
	
	public String timKiemNhanXet() {
		
		lstBaiGiang = baiGiangDao.layDanhSach();
		lstNguoiDung = nguoiDungDao.layDanhSach();
		lstNhanXet = nhanXetDao.timKiemNhanXet(maBaiGiangTimKiem, maNguoiDungTimKiem);
		
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
