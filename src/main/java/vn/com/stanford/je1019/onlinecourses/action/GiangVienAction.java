package vn.com.stanford.je1019.onlinecourses.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.GiangVienDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class GiangVienAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -191781296595581292L;
	// Khai bÃ¡o Ä‘á»‘i tÆ°á»£ng bean cáº§n dÃ¹ng trong spring
	GiangVienDAO giangVienDao;

	private List<GiangVien> lstGiangVien;
	private Integer id;
	private String tenGiangVien;
	private String anhDaiDien;
	private String chucDanh;
	private String chuyenMon;

	private String giangVien;
	private String tuKhoa = "";
	private String tuKhoaChuyenMon = "";

	private String kq = "";
	
	private Integer ma;
	private GiangVien objGiangVien;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private String giangVienId;

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

	private String tenGiangVien_Old;
	private String chucDanh_Old;
	private String chuyenMon_Old;

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getChucDanh() {
		return chucDanh;
	}

	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public String getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getTuKhoaChuyenMon() {
		return tuKhoaChuyenMon;
	}

	public void setTuKhoaChuyenMon(String tuKhoaChuyenMon) {
		this.tuKhoaChuyenMon = tuKhoaChuyenMon;
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

	public String getTenGiangVien_Old() {
		return tenGiangVien_Old;
	}

	public void setTenGiangVien_Old(String tenGiangVien_Old) {
		this.tenGiangVien_Old = tenGiangVien_Old;
	}

	public String getChucDanh_Old() {
		return chucDanh_Old;
	}

	public void setChucDanh_Old(String chucDanh_Old) {
		this.chucDanh_Old = chucDanh_Old;
	}

	public String getChuyenMon_Old() {
		return chuyenMon_Old;
	}

	public void setChuyenMon_Old(String chuyenMon_Old) {
		this.chuyenMon_Old = chuyenMon_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public GiangVien getObjGiangVien() {
		return objGiangVien;
	}

	public void setObjGiangVien(GiangVien objGiangVien) {
		this.objGiangVien = objGiangVien;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(String giangVienId) {
		this.giangVienId = giangVienId;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lstGiangVien = giangVienDao.layDanhSach();

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
		objNhatKy.setChucNang("Quan ly Giang Vien");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	
	/**	 
	 * 
	 * @return
	 */
	public String chiTietGiangVien() {
			
		if(ma!=null)
		{
			objGiangVien = giangVienDao.layChiTietTheoId(ma);		
			
			
			/**
			 *   Nhat Ky
			 */
			tenGiangVien_Old = objGiangVien.getTenGiangVien();
			session.put("tenGiangVien_Cu", tenGiangVien_Old);
			chucDanh_Old = objGiangVien.getChucDanh();
			session.put("chucDanh_Cu", chucDanh_Old);
			chuyenMon_Old = objGiangVien.getChuyenMon();
			session.put("chuyenMon_Cu", chuyenMon_Old);
		}	
		return SUCCESS;
	}
	
	/**
	 * Xá»­ lÃ½ thÃªm má»›i vÃ  cáº­p nháº­t sÃ¡ch
	 * @return
	 */
	public String themMoiHoacCapNhat() {
		if (objGiangVien != null) {
			// Xá»­ lÃ½ upload file
			if (fileUploadFileName != null && !fileUploadFileName.isEmpty()
					&& fileUploadFileName.length() > 0) {
				try {
					// Láº¥y Ä‘Æ°á»�ng dáº«n tá»« web.xml
					String filePath = ServletActionContext.getServletContext()
							.getInitParameter("file-upload");
					System.out.println("Image Location:" + filePath);
					// Táº¡o 1 Ä‘á»‘i tÆ°á»£ng file
					File fileToCreate = new File(filePath, fileUploadFileName);
					// Di chuyá»ƒn file
					FileUtils.copyFile(fileUpload, fileToCreate);
				} catch (IOException ex) {
					System.err.println("CÃ³ lá»—i xáº£y ra. Chi tiáº¿t: " + ex);
				}
				// Thá»±c hiá»‡n gÃ¡n áº£nh Ä‘á»ƒ lÆ°u vÃ o db nhÆ° sau
				objGiangVien.setAnhDaiDien(fileUploadFileName);				
			}

			// Kiá»ƒm tra TH sá»­a
			boolean kq = false;
			if (!StringUtils.isEmpty(giangVienId)) {
				
				objGiangVien.setId(Integer.parseInt(giangVienId));
				
				kq = giangVienDao.capNhat(objGiangVien);	
				
				/**
				 *   Nhat Ky
				 */
				tenGiangVien_Old = (String) session.get("tenGiangVien_Cu");
				chucDanh_Old = (String) session.get("chucDanh_Cu");
				chuyenMon_Old = (String) session.get("chuyenMon_Cu");
				tenGiangVien = objGiangVien.getTenGiangVien();
				chucDanh = objGiangVien.getChucDanh();
				chuyenMon = objGiangVien.getChuyenMon();
		
				StrHoatDong = "Cap nhat doi tuong Giang Vien: " + " (Ten Giang Vien: " + tenGiangVien_Old + "), ( Chuc Dang: " + chucDanh_Old
						+ "), (Chuyen Mon: " + chuyenMon_Old + ")" + " => CAP NHAT THANH " + " (Ten Giang Vien: " + tenGiangVien
						+ "), ( Chuc Dang: " + chucDanh + "), (Chuyen Mon: " + chuyenMon + ")";
				comm(StrHoatDong);
				return SUCCESS;
				
				
			} else {
				kq = giangVienDao.themMoi(objGiangVien);		
				
				/**
				 *   Nhat Ky
				 */
				
				tenGiangVien = objGiangVien.getTenGiangVien();
				chucDanh = objGiangVien.getChucDanh();
				chuyenMon = objGiangVien.getChuyenMon();
				
				StrHoatDong = "Them doi tuong Giang Vien: " + " (Ten Giang Vien: " + tenGiangVien + "), ( Chuc Dang: "
						+ chucDanh + "), (Chuyen Mon: " + chuyenMon + ")";
				comm(StrHoatDong);
			}

			if (kq) {
				return SUCCESS;
			}
		}
		return INPUT;
	}
	
	/**
	 * @return
	 */
	public String xoaThongTinGiangVien()
	{			
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		GiangVien objGiangVien = giangVienDao.layChiTietTheoId(ma);
		tenGiangVien = objGiangVien.getTenGiangVien();
		chucDanh = objGiangVien.getChucDanh();
		chuyenMon = objGiangVien.getChuyenMon();
		
		StrHoatDong = "Xoa doi tuong Giang Vien: " + " (Ten Giang Vien: " + tenGiangVien + "), ( Chuc Dang: "
				+ chucDanh + "), (Chuyen Mon: " + chuyenMon + ")";
		comm(StrHoatDong);
		
		
		giangVienDao.xoa(ma);
		return SUCCESS;	
	}

	public String timKiemGiangVien() {

		lstGiangVien = giangVienDao.timKiemGiangVien(tuKhoa);
		for (GiangVien gv : lstGiangVien) {
			System.out.println("Ho  ten:" + gv.getTenGiangVien());
		}
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
