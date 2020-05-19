package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class CapDoAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6934243797794015015L;

	@Autowired
	CapDoDAO capDoDao;
	private List<CapDo> lstCapDo;
	private Integer id;
	private String tenCapDo;
	private String moTa;
	private String capDo;

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

	private String tenCapDo_Old;
	private String moTa_Old;

	/**
	 * Check Trung
	 * 
	 */
	private Integer idDaTonTai;

	public CapDoDAO getCapDoDao() {
		return capDoDao;
	}

	public void setCapDoDao(CapDoDAO capDoDao) {
		this.capDoDao = capDoDao;
	}

	public List<CapDo> getLstCapDo() {
		return lstCapDo;
	}

	public void setLstCapDo(List<CapDo> lstCapDo) {
		this.lstCapDo = lstCapDo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getCapDo() {
		return capDo;
	}

	public void setCapDo(String capDo) {
		this.capDo = capDo;
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

	public String getTenCapDo_Old() {
		return tenCapDo_Old;
	}

	public void setTenCapDo_Old(String tenCapDo_Old) {
		this.tenCapDo_Old = tenCapDo_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * Ham lay danh sach loai
	 * 
	 */
	@Override
	public String execute() throws Exception {
		lstCapDo = capDoDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Cap Do");
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
	 * Ham them moi
	 * 
	 */
	public String themCapDo() {

		lstCapDo = capDoDao.timKiemCapDoTheoTen(tenCapDo);

		if (lstCapDo == null || lstCapDo.isEmpty()) { // check trung ten. TH ko trung ten

			CapDo objCapDo = new CapDo();
			objCapDo.setTenCapDo(tenCapDo);
			objCapDo.setMoTa(moTa);
			capDoDao.themMoi(objCapDo);
			 kq= "Them moi thanh cong";

			/**
			 * Nhat Ky
			 */
			StrHoatDong = "Them doi tuong Cap Do: " + " (Ten Cap Do: " + tenCapDo + "), ( Mo ta: " + moTa + ")";
			comm(StrHoatDong);
		}else {                                              // check trung ten. TH trung ten
			
			
		    kq= "Ten cap do bi trung";
			return SUCCESS;
		}

		return SUCCESS;
	}

	/**
	 * Ham lay thong tin chi tiet loai theo id, ket qua dang json
	 * 
	 */
	public String layThongTinChiTietCapDo() {
		// Lay thong tin theo id
		CapDo objCapDo = capDoDao.layChiTietTheoId(id);
		// Convert ve dang json
		setCapDo(new Gson().toJson(objCapDo));

		/**
		 * Nhat Ky
		 */
		tenCapDo_Old = objCapDo.getTenCapDo();
		session.put("tenCapDo_Cu", tenCapDo_Old);
		moTa_Old = objCapDo.getMoTa();
		session.put("moTa_Cu", moTa_Old);

		return SUCCESS;
	}

	/**
	 * Ham cap nhat thong tin
	 * 
	 */
	public String capNhatCapDo() {

		lstCapDo = capDoDao.timKiemCapDoTheoTen(tenCapDo);

		if (lstCapDo == null || lstCapDo.isEmpty()) { // check trung ten. TH ko trung ten

			CapDo objCapDo = new CapDo();
			objCapDo.setId(id);
			objCapDo.setTenCapDo(tenCapDo);
			objCapDo.setMoTa(moTa);
			capDoDao.capNhat(objCapDo);
			 kq= "Cap nhat thanh cong";
			/**
			 * Nhat Ky
			 */
			tenCapDo_Old = (String) session.get("tenCapDo_Cu");
			moTa_Old = (String) session.get("moTa_Cu");

			StrHoatDong = "Cap nhat doi tuong Cap Do: " + " (Ten loai: " + tenCapDo_Old + "), ( Mo ta: " + moTa_Old
					+ ")" + " => CAP NHAT THANH " + " (Ten loai: " + tenCapDo + "), ( Mo ta: " + moTa + ")";

			comm(StrHoatDong);
		} else { // check trung ten. TH co trung ten
			for (CapDo cddtt : lstCapDo) {
				idDaTonTai = cddtt.getId();
			}

			if (id == idDaTonTai) { // Trung tenloai nhung idDaTonTai == id muon sua
				CapDo objCapDo = new CapDo();
				objCapDo.setId(id);
				objCapDo.setTenCapDo(tenCapDo);
				objCapDo.setMoTa(moTa);
				capDoDao.capNhat(objCapDo);
				 kq= "Cap nhat thanh cong";
				/**
				 * Nhat Ky
				 */
				tenCapDo_Old = (String) session.get("tenCapDo_Cu");
				moTa_Old = (String) session.get("moTa_Cu");

				StrHoatDong = "Cap nhat doi tuong Cap Do: " + " (Ten loai: " + tenCapDo_Old + "), ( Mo ta: " + moTa_Old
						+ ")" + " => CAP NHAT THANH " + " (Ten loai: " + tenCapDo + "), ( Mo ta: " + moTa + ")";

				comm(StrHoatDong);
			}else if (id != idDaTonTai) {                                              // check trung ten. TH trung ten
				
				
			    kq= "Ten cap do bi trung";
				return SUCCESS;
			}
		}
		return SUCCESS;
	}

	/**
	 * Ham xoa
	 * 
	 */
	public String xoaCapDo() {

		/**
		 * Nhat Ky truoc. Xoa obj sau
		 */
		CapDo objCapDo = capDoDao.layChiTietTheoId(id);
		tenCapDo = objCapDo.getTenCapDo();
		moTa = objCapDo.getMoTa();

		StrHoatDong = "Xoa doi tuong Cap Do: " + " (Ten loai: " + tenCapDo + "), ( Mo ta: " + moTa + ")";
		comm(StrHoatDong);

		// Thuc hien xoa
		capDoDao.xoa(id);

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
