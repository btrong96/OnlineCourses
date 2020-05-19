package vn.com.stanford.je1019.onlinecourses.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.ChiTietHoaDon;
import vn.com.stanford.je1019.onlinecourses.entry.HoaDon;
import vn.com.stanford.je1019.onlinecourses.entry.KhachHang;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.ChiTietHoaDonDAO;
import vn.com.stanford.je1019.onlinecourses.model.HoaDonDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhachHangDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class HoaDonAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6323476299838897106L;

	// Khai báo đối tượng bean cần dùng trong spring
	
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	
	HoaDonDAO hoaDonDao;
	KhachHangDAO khachHangDao;

	private List<HoaDon> lstHoaDon;
	private List<ChiTietHoaDon> lstChiTietHoaDon;
	private List<KhachHang> lstKhachHang;
	private List<KhoaHoc> lstKhoaHoc;
	private Integer id;
	private Date ngayMua;
	private String ghiChu;
	private Float daThanhToan;
	private Integer khachHangId;
	private String hoaDon;

	private Integer ma;
	private Integer hd_id;

	private String kq = "";

	ChiTietHoaDon objChiTietHoaDon = new ChiTietHoaDon();

	/**
	 * Nhat Ky
	 */
	@Autowired
	NguoiDungDAO nguoiDungDao;
	@Autowired
	NhatKyDAO nhatKyDao;
	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	private String taiKhoanUser;
	private String matKhauUser;
	private List<NguoiDung> lstNguoiDung;
	private Integer nguoiDungId;
	private Map<String, Object> session;
	private String StrHoatDong;

	private String ghiChu_Old;
	private Float daThanhToan_Old;
	private String tenKhachHang;
	private String tenKhachHang_Old;

	public HoaDonDAO getHoaDonDao() {
		return hoaDonDao;
	}

	public void setHoaDonDao(HoaDonDAO hoaDonDao) {
		this.hoaDonDao = hoaDonDao;
	}

	public List<HoaDon> getLstHoaDon() {
		return lstHoaDon;
	}

	public void setLstHoaDon(List<HoaDon> lstHoaDon) {
		this.lstHoaDon = lstHoaDon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Float getDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(Float daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public Integer getKhachHangId() {
		return khachHangId;
	}

	public void setKhachHangId(Integer khachHangId) {
		this.khachHangId = khachHangId;
	}

	public String getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(String hoaDon) {
		this.hoaDon = hoaDon;
	}

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public ChiTietHoaDonDAO getChiTietHoaDonDao() {
		return chiTietHoaDonDao;
	}

	public void setChiTietHoaDonDao(ChiTietHoaDonDAO chiTietHoaDonDao) {
		this.chiTietHoaDonDao = chiTietHoaDonDao;
	}

	public KhachHangDAO getKhachHangDao() {
		return khachHangDao;
	}

	public void setKhachHangDao(KhachHangDAO khachHangDao) {
		this.khachHangDao = khachHangDao;
	}

	public List<KhachHang> getLstKhachHang() {
		return lstKhachHang;
	}

	public void setLstKhachHang(List<KhachHang> lstKhachHang) {
		this.lstKhachHang = lstKhachHang;
	}

	public List<ChiTietHoaDon> getLstChiTietHoaDon() {
		return lstChiTietHoaDon;
	}

	public void setLstChiTietHoaDon(List<ChiTietHoaDon> lstChiTietHoaDon) {
		this.lstChiTietHoaDon = lstChiTietHoaDon;
	}

	public ChiTietHoaDon getObjChiTietHoaDon() {
		return objChiTietHoaDon;
	}

	public void setObjChiTietHoaDon(ChiTietHoaDon objChiTietHoaDon) {
		this.objChiTietHoaDon = objChiTietHoaDon;
	}

	public Integer getHd_id() {
		return hd_id;
	}

	public void setHd_id(Integer hd_id) {
		this.hd_id = hd_id;
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

	public String getGhiChu_Old() {
		return ghiChu_Old;
	}

	public void setGhiChu_Old(String ghiChu_Old) {
		this.ghiChu_Old = ghiChu_Old;
	}

	public Float getDaThanhToan_Old() {
		return daThanhToan_Old;
	}

	public void setDaThanhToan_Old(Float daThanhToan_Old) {
		this.daThanhToan_Old = daThanhToan_Old;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getTenKhachHang_Old() {
		return tenKhachHang_Old;
	}

	public void setTenKhachHang_Old(String tenKhachHang_Old) {
		this.tenKhachHang_Old = tenKhachHang_Old;
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
	
	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lstHoaDon = hoaDonDao.layDanhSach();
		lstKhachHang = khachHangDao.layDanhSach();

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
		objNhatKy.setChucNang("Quan ly Hoa Don");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	/**
	 * Hàm thực hiện thêm hóa đơn dạng ajax
	 * 
	 * @return
	 */
	public String themHoaDon() {
		HoaDon objHoaDon = new HoaDon();
		objHoaDon.setNgayMua(ngayMua);
		objHoaDon.setGhiChu(ghiChu);
		objHoaDon.setDaThanhToan(daThanhToan);
		KhachHang objKhachHang = khachHangDao.layChiTietTheoId(khachHangId);
		objHoaDon.setKhachHang(objKhachHang);

		hoaDonDao.themMoi(objHoaDon);
		setKq("ok");

		/**
		 * Nhat Ky
		 */
		tenKhachHang = objKhachHang.getTenKhachHang();

		StrHoatDong = "Them doi tuong Hoa Don: " + " (Ghi Chu: " + ghiChu + "), ( Da Thanh Toan: " + daThanhToan
				+ "), (Ten Khach Hang: " + tenKhachHang + ")";
		comm(StrHoatDong);

		return SUCCESS;
	}

	/**
	 * Hàm thực hiện cập nhật hóa đơn dạng ajax
	 * 
	 * @return
	 */
	public String capNhatHoaDon() {
		HoaDon objHoaDon = new HoaDon();
		objHoaDon.setId(id);
		objHoaDon.setNgayMua(ngayMua);
		objHoaDon.setGhiChu(ghiChu);
		objHoaDon.setDaThanhToan(daThanhToan);
		KhachHang objKhachHang = khachHangDao.layChiTietTheoId(khachHangId);
		objHoaDon.setKhachHang(objKhachHang);

		hoaDonDao.capNhat(objHoaDon);
		setKq("ok");

		/**
		 * Nhat Ky
		 */

		ghiChu_Old = (String) session.get("ghiChu_Cu");
		daThanhToan_Old = (Float) session.get("daThanhToan_Cu");
		tenKhachHang_Old = (String) session.get("tenKhachHang_Cu");

		tenKhachHang = objKhachHang.getTenKhachHang();

		StrHoatDong = "Cap nhat doi tuong Hoa Don: " + " (Ghi Chu: " + ghiChu_Old + "), ( Da Thanh Toan: "
				+ daThanhToan_Old + "), (Ten Khach Hang: " + tenKhachHang_Old + ")" + " => CAP NHAT THANH "
				+ " (Ghi Chu: " + ghiChu + "), ( Da Thanh Toan: " + daThanhToan + "), (Ten Khach Hang: " + tenKhachHang
				+ ")";

		comm(StrHoatDong);

		return SUCCESS;
	}

	/**
	 * Hàm lấy thông tin chi tiết hóa đơn bằng jquery ajax
	 * 
	 * @return
	 */
	public String layChiTietHoaDon() {
		HoaDon objHoaDon = hoaDonDao.layChiTietTheoId(id);
		objHoaDon.getKhachHang().setLstHoaDon(null);
		String json = new Gson().toJson(objHoaDon);

		setHoaDon(json);

		/**
		 * Nhat Ky
		 */
		ghiChu_Old = objHoaDon.getGhiChu();
		session.put("ghiChu_Cu", ghiChu_Old);
		daThanhToan_Old = objHoaDon.getDaThanhToan();
		session.put("daThanhToan_Cu", daThanhToan_Old);

		KhachHang objKhachHang = objHoaDon.getKhachHang();
		tenKhachHang_Old = objKhachHang.getTenKhachHang();
		session.put("tenKhachHang_Cu", tenKhachHang_Old);

		return SUCCESS;
	}

	/**
	 * Hàm thực hiện xoá thông tin hóa đơn dạng ajax
	 * 
	 * @return
	 */
	public String xoaHoaDon() {

		/**
		 * Nhat Ky truoc. Xoa obj sau
		 */

		HoaDon objHoaDon = hoaDonDao.layChiTietTheoId(id);
		ghiChu = objHoaDon.getGhiChu();
		daThanhToan = objHoaDon.getDaThanhToan();
		KhachHang objKhachHang = objHoaDon.getKhachHang();
		tenKhachHang = objKhachHang.getTenKhachHang();

		StrHoatDong = "Xoa doi tuong Hoa Don: " + " (Ghi Chu: " + ghiChu + "), ( Da Thanh Toan: " + daThanhToan
				+ "), (Ten Khach Hang: " + tenKhachHang + ")";
		comm(StrHoatDong);

		boolean kq = hoaDonDao.xoa(id);
		if (kq) {
			setKq("ok");
		}

		return SUCCESS;
	}

	public String chiTietHoaDon() {
		
		lstHoaDon = hoaDonDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
				
		lstChiTietHoaDon = chiTietHoaDonDao.layDanhSach();
		
		
			for (ChiTietHoaDon cthd : lstChiTietHoaDon) {
				hd_id = cthd.getHoaDonId();
				if (hd_id == ma) {
					lstChiTietHoaDon = chiTietHoaDonDao.layChiTietTheoHoaDon_Id(hd_id);
					return SUCCESS;
				}
			}
	
			lstChiTietHoaDon = null;

		return SUCCESS;
	}

	/**
	 * Nhat Ky
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
