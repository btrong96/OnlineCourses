package vn.com.stanford.je1019.onlinecourses.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.KhachHang;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.KhachHangDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class KhachHangAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6419179690384689626L;

	// Khai báo đối tượng bean cần dùng trong spring
	KhachHangDAO khachHangDao;
	
	
	private List<KhachHang> lstKhachHang;
	private Integer id;
	private String tenKhachHang;
	private String diaChi;
	private String dienThoai;
	private String cMND;
	private Date ngayCap;
	private String noiCap;
	private String maSoThue;
	private Date ngayTao;
	private Date ngayCapNhat;
	private String moTa;
	private Integer nguoiDungId;
	
	private String tuKhoa ="";

	private String khachHang;
	private String kq = "";
	
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
	
	private String tenKhachHang_Old;
	private String diaChi_Old;
	private String dienThoai_Old;
	private String cMND_Old;
	private String maSoThue_Old;
	private String moTa_Old;
	private String taiKhoan;
	private String taiKhoan_Old;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getcMND() {
		return cMND;
	}

	public void setcMND(String cMND) {
		this.cMND = cMND;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}

	public String getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(String khachHang) {
		this.khachHang = khachHang;
	}

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}	
	
	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
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

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
	}

	public String getTenKhachHang_Old() {
		return tenKhachHang_Old;
	}

	public void setTenKhachHang_Old(String tenKhachHang_Old) {
		this.tenKhachHang_Old = tenKhachHang_Old;
	}

	public String getDiaChi_Old() {
		return diaChi_Old;
	}

	public void setDiaChi_Old(String diaChi_Old) {
		this.diaChi_Old = diaChi_Old;
	}

	public String getDienThoai_Old() {
		return dienThoai_Old;
	}

	public void setDienThoai_Old(String dienThoai_Old) {
		this.dienThoai_Old = dienThoai_Old;
	}

	public String getcMND_Old() {
		return cMND_Old;
	}

	public void setcMND_Old(String cMND_Old) {
		this.cMND_Old = cMND_Old;
	}

	public String getMaSoThue_Old() {
		return maSoThue_Old;
	}

	public void setMaSoThue_Old(String maSoThue_Old) {
		this.maSoThue_Old = maSoThue_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getTaiKhoan_Old() {
		return taiKhoan_Old;
	}

	public void setTaiKhoan_Old(String taiKhoan_Old) {
		this.taiKhoan_Old = taiKhoan_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lstNguoiDung = nguoiDungDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Khach Hang");
		objNhatKy.setHoatDong(StrHoatDong);		
		nhatKyDao.themMoi(objNhatKy);
	}

	/**
	 * Hàm thực hiện thêm khách hàng dạng ajax
	 * 
	 * @return
	 */
	public String themKhachHang() {
		KhachHang objKhachHang = new KhachHang();
	
		objKhachHang.setTenKhachHang(tenKhachHang);
		objKhachHang.setDiaChi(diaChi);
		objKhachHang.setDienThoai(dienThoai);
		objKhachHang.setcMND(cMND);
		objKhachHang.setNgayCap(ngayCap);
		objKhachHang.setNoiCap(noiCap);
		objKhachHang.setMaSoThue(maSoThue);
		objKhachHang.setNgayTao(ngayTao);
		objKhachHang.setNgayCapNhat(ngayCapNhat);
		objKhachHang.setMoTa(moTa);
		objKhachHang.setNguoiDungId(nguoiDungId);

		khachHangDao.themMoi(objKhachHang);
		setKq("ok");
		
		
		/**
		 *   Nhat Ky
		 */		
		
        NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		taiKhoan = objNguoiDung.getTaiKhoan();
		
		StrHoatDong = "Them doi tuong Khach Hang: " + " (Ten Khach Hang: " + tenKhachHang + "), ( Dia Chi: " + diaChi +"), (Dien Thoai:"
				+ dienThoai + "), (CMND: " + cMND + "), (Ma So Thue: " + maSoThue + "), (Mo Ta: " + moTa 
				+ "), (Ten Tai Khoan:" + taiKhoan;		
		comm(StrHoatDong);
			
		return SUCCESS;
	}

	/**
	 * Hàm thực hiện cập nhật khách hàng dạng ajax
	 * @return
	 */
	public String capNhatKhachHang()
	{
		KhachHang objKhachHang = new KhachHang();
		objKhachHang.setId(id);
		objKhachHang.setTenKhachHang(tenKhachHang);
		objKhachHang.setDiaChi(diaChi);
		objKhachHang.setDienThoai(dienThoai);
		objKhachHang.setcMND(cMND);
		objKhachHang.setNgayCap(ngayCap);
		objKhachHang.setNoiCap(noiCap);
		objKhachHang.setMaSoThue(maSoThue);
		objKhachHang.setNgayTao(ngayTao);
		objKhachHang.setNgayCapNhat(ngayCapNhat);
		objKhachHang.setMoTa(moTa);
		objKhachHang.setNguoiDungId(nguoiDungId);
		
		khachHangDao.capNhat(objKhachHang);		
		setKq("ok");
		
		
		/**
		 *   Nhat Ky
		 */		
		
		tenKhachHang_Old = (String) session.get("tenKhachHang_Cu");
		diaChi_Old = (String) session.get("diaChi_Cu");
		dienThoai_Old = (String) session.get("dienThoai_Cu");
		cMND_Old = (String) session.get("cMND_Cu");
		maSoThue_Old = (String) session.get("maSoThue_Cu");
		moTa_Old = (String) session.get("moTa_Cu");
		taiKhoan_Old = (String) session.get("taiKhoan_Cu");
		
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		taiKhoan = objNguoiDung.getTaiKhoan();
		
		StrHoatDong = "Cap nhat doi tuong Khach Hang: " + " (Ten Khach Hang: " + tenKhachHang_Old + "), ( Dia Chi: " + diaChi_Old +"), (Dien Thoai:"
				+ dienThoai_Old + "), (CMND: " + cMND_Old + "), (Ma So Thue: " + maSoThue_Old + "), (Mo Ta: " + moTa_Old 
				+ "), (Ten Tai Khoan:" + taiKhoan_Old		
				+ " => CAP NHAT THANH " + " (Ten Khach Hang: " + tenKhachHang + "), ( Dia Chi: " + diaChi +"), (Dien Thoai:"
				+ dienThoai + "), (CMND: " + cMND + "), (Ma So Thue: " + maSoThue + "), (Mo Ta: " + moTa 
				+ "), (Ten Tai Khoan:" + taiKhoan;		
		comm(StrHoatDong);
		
		return SUCCESS;
	}
	
	
	/**
	 * Hàm lấy thông tin chi tiết khách hàng bằng jquery ajax
	 * @return
	 */
	public String layChiTietKhachHang()
	{
		KhachHang objKhachHang = khachHangDao.layChiTietTheoId(id);
		
		KhachHang simpleObjKhachHang = new KhachHang();
		simpleObjKhachHang.setId(objKhachHang.getId());
		simpleObjKhachHang.setTenKhachHang(objKhachHang.getTenKhachHang());
		simpleObjKhachHang.setDiaChi(objKhachHang.getDiaChi());
		simpleObjKhachHang.setDienThoai(objKhachHang.getDienThoai());
		simpleObjKhachHang.setcMND(objKhachHang.getcMND());
		simpleObjKhachHang.setNgayCap(objKhachHang.getNgayCap());
		simpleObjKhachHang.setNoiCap(objKhachHang.getNoiCap());
		simpleObjKhachHang.setMaSoThue(objKhachHang.getMaSoThue());
		simpleObjKhachHang.setNgayTao(objKhachHang.getNgayTao());
		simpleObjKhachHang.setNgayCapNhat(objKhachHang.getNgayCapNhat());
		simpleObjKhachHang.setMoTa(objKhachHang.getMoTa());
		simpleObjKhachHang.setNguoiDungId(objKhachHang.getNguoiDungId());
		
		String json = new Gson().toJson(simpleObjKhachHang);	
		setKhachHang(json);
		
		/**
		 *   Nhat Ky
		 */
		tenKhachHang_Old = objKhachHang.getTenKhachHang();
		session.put("tenKhachHang_Cu", tenKhachHang_Old);
		diaChi_Old = objKhachHang.getDiaChi();
		session.put("diaChi_Cu", diaChi_Old);
		dienThoai_Old = objKhachHang.getDienThoai();
		session.put("dienThoai_Cu", dienThoai_Old);
		cMND_Old = objKhachHang.getcMND();
		session.put("cMND_Cu", cMND_Old);
		maSoThue_Old = objKhachHang.getMaSoThue();
		session.put("maSoThue_Cu", maSoThue_Old);
		moTa_Old = objKhachHang.getMoTa();
		session.put("moTa_Cu", moTa_Old);
		
		nguoiDungId = objKhachHang.getNguoiDungId();
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		taiKhoan_Old = objNguoiDung.getTaiKhoan();
		session.put("taiKhoan_Cu", taiKhoan_Old);	
		
		return SUCCESS;
	}

	/**
	 * Hàm thực hiện xoá thông tin khách hàng dạng ajax
	 * @return
	 */
	public String xoaKhachHang()
	{		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
        KhachHang objKhachHang = khachHangDao.layChiTietTheoId(id);
        tenKhachHang = objKhachHang.getTenKhachHang();
        diaChi = objKhachHang.getDiaChi();
        dienThoai = objKhachHang.getDienThoai();
        cMND = objKhachHang.getcMND();
        maSoThue = objKhachHang.getMaSoThue();
        moTa  = objKhachHang.getMoTa();
        nguoiDungId = objKhachHang.getNguoiDungId();
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		taiKhoan = objNguoiDung.getTaiKhoan();
		
		StrHoatDong = "Xoa doi tuong Khach Hang: " + " (Ten Khach Hang: " + tenKhachHang + "), ( Dia Chi: " + diaChi +"), (Dien Thoai:"
				+ dienThoai + "), (CMND: " + cMND + "), (Ma So Thue: " + maSoThue + "), (Mo Ta: " + moTa 
				+ "), (Ten Tai Khoan:" + taiKhoan +")";		
		comm(StrHoatDong);		
		
		boolean kq = khachHangDao.xoa(id);
		if(kq)
		{
			setKq("ok");
		}
		
		return SUCCESS;
	}
	
	

	public String timKiemKhachHang()
	{
		lstNguoiDung = nguoiDungDao.layDanhSach();	
		lstKhachHang = khachHangDao.timKiemKhachHang(tuKhoa);
		
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
