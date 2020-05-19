package vn.com.stanford.je1019.onlinecourses.action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.entry.VaiTro;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;
import vn.com.stanford.je1019.onlinecourses.model.VaiTroDAO;

public class NguoiDungAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493603121536993752L;

	@Autowired
	NguoiDungDAO nguoiDungDao;
	@Autowired
	VaiTroDAO vaiTroDao;

	private List<NguoiDung> lstNguoiDung;
	private List<VaiTro> lstVaiTro;
	private Integer id;
	private String taiKhoan;
	private String matKhau;
	private String hoTen;
	private String dienThoai;
	private String email;
	private Date ngayTao;
	private Date ngayCapNhat;
	private Integer vaitro_id;
	private String jsonNguoiDung;
	private Boolean trangThai;

	private NguoiDung objNguoiDung;

	/**
	 * Nhat Ky
	 */

	@Autowired
	NhatKyDAO nhatKyDao;
	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	private String taiKhoanUser;
	private String matKhauUser;
	private Integer nguoiDungId;
	private Map<String, Object> session;
	private String StrHoatDong;

	private String taiKhoan_Old;
	private String hoTen_Old;
	private String dienThoai_Old;
	private String email_Old;
	private String tenVaiTro;
	private String tenVaiTro_Old;

	/**
	 * Check Trung
	 * 
	 */
	private Integer idDaTonTai;

	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getJsonNguoiDung() {
		return jsonNguoiDung;
	}

	public void setJsonNguoiDung(String jsonNguoiDung) {
		this.jsonNguoiDung = jsonNguoiDung;
	}

	public Integer getVaitro_id() {
		return vaitro_id;
	}

	public void setVaitro_id(Integer vaitro_id) {
		this.vaitro_id = vaitro_id;
	}

	public VaiTroDAO getVaiTroDao() {
		return vaiTroDao;
	}

	public void setVaiTroDao(VaiTroDAO vaiTroDao) {
		this.vaiTroDao = vaiTroDao;
	}

	public List<VaiTro> getLstVaiTro() {
		return lstVaiTro;
	}

	public void setLstVaiTro(List<VaiTro> lstVaiTro) {
		this.lstVaiTro = lstVaiTro;
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

	public Integer getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}

	public String getTaiKhoan_Old() {
		return taiKhoan_Old;
	}

	public void setTaiKhoan_Old(String taiKhoan_Old) {
		this.taiKhoan_Old = taiKhoan_Old;
	}

	public String getHoTen_Old() {
		return hoTen_Old;
	}

	public void setHoTen_Old(String hoTen_Old) {
		this.hoTen_Old = hoTen_Old;
	}

	public String getDienThoai_Old() {
		return dienThoai_Old;
	}

	public void setDienThoai_Old(String dienThoai_Old) {
		this.dienThoai_Old = dienThoai_Old;
	}

	public String getEmail_Old() {
		return email_Old;
	}

	public void setEmail_Old(String email_Old) {
		this.email_Old = email_Old;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public String getTenVaiTro_Old() {
		return tenVaiTro_Old;
	}

	public void setTenVaiTro_Old(String tenVaiTro_Old) {
		this.tenVaiTro_Old = tenVaiTro_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	public NguoiDung getObjNguoiDung() {
		return objNguoiDung;
	}

	public void setObjNguoiDung(NguoiDung objNguoiDung) {
		this.objNguoiDung = objNguoiDung;
	}

	/**
	 * HÃ m mÃ£ hÃ³a md5
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1, digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * HÃ m láº¥y danh sÃ¡ch ngÆ°á»�i dÃ¹ng
	 */
	public String execute() throws Exception {
		lstNguoiDung = nguoiDungDao.layDanhSach();
		lstVaiTro = vaiTroDao.layDanhSach();

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
		objNhatKy.setChucNang("Quan ly Nguoi Dung");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	
private String kq = "";
	
	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}
	
	
	/**
	 * 
	 * HÃ m thÃªm má»›i ngÆ°á»�i dÃ¹ng
	 */
	public String themNguoiDung() {

		lstNguoiDung = nguoiDungDao.timKiemNguoiDungTheoTen(taiKhoan);

		if (lstNguoiDung == null || lstNguoiDung.isEmpty()) { // check trung ten. TH ko trung ten

			NguoiDung objNguoiDung = new NguoiDung();
			objNguoiDung.setTaiKhoan(taiKhoan);
			objNguoiDung.setMatKhau(md5(matKhau));
			objNguoiDung.setHoTen(hoTen);
			objNguoiDung.setDienThoai(dienThoai);
			objNguoiDung.setEmail(email);
			objNguoiDung.setNgayTao(ngayTao);
			objNguoiDung.setNgayCapNhat(ngayCapNhat);
			objNguoiDung.setVaiTroId(vaitro_id);
			objNguoiDung.setTrangThai(trangThai);

			nguoiDungDao.themMoi(objNguoiDung);
			kq= "Them nguoi dung thanh cong";

			/**
			 * Nhat Ky
			 */

			VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
			tenVaiTro = objVaiTro.getTenVaiTro();

			StrHoatDong = "Them doi tuong Nguoi Dung: " + " (Ten Tai Khoan: " + taiKhoan + "), ( Ho Ten: " + hoTen
					+ "), (Dien Thoai:" + dienThoai + "), (Email: " + email + "), (Ten Vai Tro: " + tenVaiTro + ")";
			comm(StrHoatDong);
		}else {                                              // check trung ten. TH trung ten
									
		    kq= "Ten tai khoan bi trung";
			return SUCCESS;
		}

		return SUCCESS;
	}

	/**
	 * 
	 * HÃ m cáº­p nháº­t thÃ´ng tin
	 */
	public String capNhatNguoiDung() {
		lstNguoiDung = nguoiDungDao.timKiemNguoiDungTheoTen(taiKhoan);

		if (lstNguoiDung == null || lstNguoiDung.isEmpty()) { // check trung ten. TH ko trung ten

			NguoiDung objNguoiDung = new NguoiDung();
			objNguoiDung.setId(id);
			objNguoiDung.setTaiKhoan(taiKhoan);
			objNguoiDung.setMatKhau(matKhau); // Khong nen cap nhat mat khau. KO de md5 thi update ko chuyen sang md5.
												// Neu de md5 thi khi update phai nhap lai "mat khau" => nhu the ko on
			objNguoiDung.setHoTen(hoTen);
			objNguoiDung.setDienThoai(dienThoai);
			objNguoiDung.setEmail(email);
			objNguoiDung.setNgayTao(ngayTao);
			objNguoiDung.setNgayCapNhat(ngayCapNhat);
			objNguoiDung.setVaiTroId(vaitro_id);
			objNguoiDung.setTrangThai(trangThai);

			nguoiDungDao.capNhat(objNguoiDung);
			kq= "Cap nhat nguoi dung thanh cong";

			/**
			 * Nhat Ky
			 */

			taiKhoan_Old = (String) session.get("taiKhoan_Cu");
			hoTen_Old = (String) session.get("hoTen_Cu");
			dienThoai_Old = (String) session.get("dienThoai_Cu");
			email_Old = (String) session.get("email_Cu");
			tenVaiTro_Old = (String) session.get("tenVaiTro_Cu");

			VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
			tenVaiTro = objVaiTro.getTenVaiTro();

			StrHoatDong = "Cap nhat doi tuong Nguoi Dung: " + " (Ten Tai Khoan: " + taiKhoan_Old + "), ( Ho Ten: "
					+ hoTen_Old + "), (Dien Thoai:" + dienThoai_Old + "), (Email: " + email_Old + "), (Ten Vai Tro: "
					+ tenVaiTro_Old + ")" + " => CAP NHAT THANH " + " (Ten Tai Khoan: " + taiKhoan + "), ( Ho Ten: "
					+ hoTen + "), (Dien Thoai:" + dienThoai + "), (Email: " + email + "), (Ten Vai Tro: " + tenVaiTro
					+ ")";
			comm(StrHoatDong);
		} else { // check trung ten. TH co trung ten
			for (NguoiDung nddtt : lstNguoiDung) {
				idDaTonTai = nddtt.getId();
			}

			if (id == idDaTonTai) { // Trung ten nhung idDaTonTai == id muon sua
				NguoiDung objNguoiDung = new NguoiDung();
				objNguoiDung.setId(id);
				objNguoiDung.setTaiKhoan(taiKhoan);
				objNguoiDung.setMatKhau(matKhau); // Khong nen cap nhat mat khau. KO de md5 thi update ko chuyen sang
													// md5.
													// Neu de md5 thi khi update phai nhap lai "mat khau" => nhu the ko
													// on
				objNguoiDung.setHoTen(hoTen);
				objNguoiDung.setDienThoai(dienThoai);
				objNguoiDung.setEmail(email);
				objNguoiDung.setNgayTao(ngayTao);
				objNguoiDung.setNgayCapNhat(ngayCapNhat);
				objNguoiDung.setVaiTroId(vaitro_id);
				objNguoiDung.setTrangThai(trangThai);

				nguoiDungDao.capNhat(objNguoiDung);
				kq= "Cap nhat nguoi dung thanh cong";

				/**
				 * Nhat Ky
				 */

				taiKhoan_Old = (String) session.get("taiKhoan_Cu");
				hoTen_Old = (String) session.get("hoTen_Cu");
				dienThoai_Old = (String) session.get("dienThoai_Cu");
				email_Old = (String) session.get("email_Cu");
				tenVaiTro_Old = (String) session.get("tenVaiTro_Cu");

				VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
				tenVaiTro = objVaiTro.getTenVaiTro();

				StrHoatDong = "Cap nhat doi tuong Nguoi Dung: " + " (Ten Tai Khoan: " + taiKhoan_Old + "), ( Ho Ten: "
						+ hoTen_Old + "), (Dien Thoai:" + dienThoai_Old + "), (Email: " + email_Old
						+ "), (Ten Vai Tro: " + tenVaiTro_Old + ")" + " => CAP NHAT THANH " + " (Ten Tai Khoan: "
						+ taiKhoan + "), ( Ho Ten: " + hoTen + "), (Dien Thoai:" + dienThoai + "), (Email: " + email
						+ "), (Ten Vai Tro: " + tenVaiTro + ")";
				comm(StrHoatDong);

			} else if (id != idDaTonTai) { // Trung ten va idDaTonTai != id muon sua
				System.out.println("Da Co Doi tuong Co ten Nhu the Nen ko sua dc ");
				kq= "Ten tai khoan bi trung";
				return SUCCESS;
			}
		}
		return SUCCESS;
	}

	/**
	 * 
	 * HÃ m láº¥y thÃ´ng tin chi tiáº¿t theo id káº¿t quáº£ tráº£
	 * vá»� dáº¡ng json
	 */
	public String layThongTinChiTietNguoiDung() {
		// Láº¥y thÃ´ng tin theo id
		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(id);
		// objNguoiDung.getVaiTro().setId(null);
		// Chuyá»ƒn sang dáº¡ng json
		setJsonNguoiDung(new Gson().toJson(objNguoiDung));

		/**
		 * Nhat Ky
		 */
		taiKhoan_Old = objNguoiDung.getTaiKhoan();
		session.put("taiKhoan_Cu", taiKhoan_Old);
		hoTen_Old = objNguoiDung.getHoTen();
		session.put("hoTen_Cu", hoTen_Old);
		dienThoai_Old = objNguoiDung.getDienThoai();
		session.put("dienThoai_Cu", dienThoai_Old);
		email_Old = objNguoiDung.getEmail();
		session.put("email_Cu", email_Old);

		vaitro_id = objNguoiDung.getVaiTroId();
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
		tenVaiTro_Old = objVaiTro.getTenVaiTro();
		session.put("tenVaiTro_Cu", tenVaiTro_Old);

		return SUCCESS;
	}

	/**
	 * 
	 * HÃ m xÃ³a chá»©c nÄƒng
	 * 
	 */
	public String xoaNguoiDung() {

		/**
		 * Nhat Ky truoc. Xoa obj sau
		 */

		NguoiDung objNguoiDung = nguoiDungDao.layChiTietTheoId(id);
		taiKhoan = objNguoiDung.getTaiKhoan();
		hoTen = objNguoiDung.getHoTen();
		dienThoai = objNguoiDung.getDienThoai();
		email = objNguoiDung.getEmail();

		vaitro_id = objNguoiDung.getVaiTroId();
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
		tenVaiTro = objVaiTro.getTenVaiTro();

		StrHoatDong = "Xoa doi tuong Nguoi Dung: " + " (Ten Tai Khoan: " + taiKhoan + "), ( Ho Ten: " + hoTen
				+ "), (Dien Thoai:" + dienThoai + "), (Email: " + email + "), (Ten Vai Tro: " + tenVaiTro + ")";
		comm(StrHoatDong);

		// XÃ³a
		nguoiDungDao.xoa(id);
		return SUCCESS;
	}

	/**
	 * Duyet hang loat
	 */
	public String duyetNguoiDung() {

		objNguoiDung = nguoiDungDao.layChiTietTheoId(id);

		objNguoiDung.setTrangThai(true);
		nguoiDungDao.capNhat(objNguoiDung);

		return SUCCESS;
	}

	/**
	 * Bo Duyet hang loat
	 */
	public String boDuyetNguoiDung() {

		objNguoiDung = nguoiDungDao.layChiTietTheoId(id);

		objNguoiDung.setTrangThai(false);
		nguoiDungDao.capNhat(objNguoiDung);

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
