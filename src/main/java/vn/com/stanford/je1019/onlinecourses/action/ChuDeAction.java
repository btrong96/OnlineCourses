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

import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;
import vn.com.stanford.je1019.onlinecourses.entry.Loai;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class ChuDeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5395714655880156623L;

	@Autowired
	LoaiDAO loaiDao;
	@Autowired
	ChuDeDAO chuDeDao;

	private List<Loai> lstLoai;
	private List<ChuDe> lstChuDe;
	private Integer id;
	private String tenChuDe;
	private String moTa;
	private Integer loaiId;
	private String jsonChuDe;

	private Integer ma;
	private ChuDe objChuDe;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private String chuDeId;
	private Loai objLoai;

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

	private String tenChuDe_Old;
	private String moTa_Old;
	private String tenLoai_Old;
	private String tenLoai;

	/**
	 * Check Trung
	 * 
	 */
	private Integer idTruyenVao;
	private Integer idDaTonTai;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getLoaiId() {
		return loaiId;
	}

	public void setLoaiId(Integer loaiId) {
		this.loaiId = loaiId;
	}

	public String getJsonChuDe() {
		return jsonChuDe;
	}

	public void setJsonChuDe(String jsonChuDe) {
		this.jsonChuDe = jsonChuDe;
	}

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

	public String getTenChuDe_Old() {
		return tenChuDe_Old;
	}

	public void setTenChuDe_Old(String tenChuDe_Old) {
		this.tenChuDe_Old = tenChuDe_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public String getTenLoai_Old() {
		return tenLoai_Old;
	}

	public void setTenLoai_Old(String tenLoai_Old) {
		this.tenLoai_Old = tenLoai_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public ChuDe getObjChuDe() {
		return objChuDe;
	}

	public void setObjChuDe(ChuDe objChuDe) {
		this.objChuDe = objChuDe;
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

	public String getChuDeId() {
		return chuDeId;
	}

	public void setChuDeId(String chuDeId) {
		this.chuDeId = chuDeId;
	}

	public Loai getObjLoai() {
		return objLoai;
	}

	public void setObjLoai(Loai objLoai) {
		this.objLoai = objLoai;
	}

	/**
	 * Ham lay danh sach chu de
	 * 
	 */
	@Override
	public String execute() throws Exception {
		lstLoai = loaiDao.layDanhSach();
		lstChuDe = chuDeDao.layDanhSach();

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
		objNhatKy.setChucNang("Quan ly Chu De");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	/**
	 * 
	 * @return
	 */
	public String chiTietChuDe() {

		lstLoai = loaiDao.layDanhSach();

		if (ma != null) {
			objChuDe = chuDeDao.layChiTietTheoId(ma);

			/**
			 * Nhat Ky
			 */

			tenChuDe_Old = objChuDe.getTenChuDe();
			session.put("tenChuDe_Cu", tenChuDe_Old);
			moTa_Old = objChuDe.getMoTa();
			session.put("moTa_Cu", moTa_Old);

			loaiId = objChuDe.getLoaiId();
			objLoai = loaiDao.layChiTietTheoId(loaiId);
			tenLoai_Old = objLoai.getTenLoai();
			session.put("tenLoai_Cu", tenLoai_Old);

		}
		return SUCCESS;
	}

	/**
	 * Xá»­ lÃ½ thÃªm má»›i vÃ  cáº­p nháº­t sÃ¡ch
	 * 
	 * @return
	 */
	public String themMoiHoacCapNhat() {
		if (objChuDe != null) {
			// Xá»­ lÃ½ upload file
			if (fileUploadFileName != null && !fileUploadFileName.isEmpty() && fileUploadFileName.length() > 0) {
				try {
					// Láº¥y Ä‘Æ°á»�ng dáº«n tá»« web.xml
					String filePath = ServletActionContext.getServletContext().getInitParameter("file-upload");
					System.out.println("Image Location:" + filePath);
					// Táº¡o 1 Ä‘á»‘i tÆ°á»£ng file
					File fileToCreate = new File(filePath, fileUploadFileName);
					// Di chuyá»ƒn file
					FileUtils.copyFile(fileUpload, fileToCreate);
				} catch (IOException ex) {
					System.err.println("CÃ³ lá»—i xáº£y ra. Chi tiáº¿t: " + ex);
				}
				// Thá»±c hiá»‡n gÃ¡n áº£nh Ä‘á»ƒ lÆ°u vÃ o db nhÆ° sau
				objChuDe.setAnhDaiDien(fileUploadFileName);
			}

			// Kiá»ƒm tra TH sá»­a
			boolean kq = false;
			if (!StringUtils.isEmpty(chuDeId)) {

				/**
				 * TH Sua
				 */
				idTruyenVao = Integer.parseInt(chuDeId);
				tenChuDe = objChuDe.getTenChuDe();
				lstChuDe = chuDeDao.timKiemChuDeTheoTen(tenChuDe);

				if (lstChuDe == null || lstChuDe.isEmpty()) { // check trung ten. TH ko trung ten
					objChuDe.setId(Integer.parseInt(chuDeId));

					loaiId = objChuDe.getLoaiId(); // Phai Co Dong nay, Ko no NULL
					objLoai = loaiDao.layChiTietTheoId(loaiId);
					tenLoai = objLoai.getTenLoai();
					objChuDe.setTenLoai(tenLoai);

					/**
					 * Nhat Ky
					 */
					moTa = objChuDe.getMoTa();
					tenChuDe = objChuDe.getTenChuDe();
					tenLoai_Old = (String) session.get("tenLoai_Cu");
					tenChuDe_Old = (String) session.get("tenChuDe_Cu");
					moTa_Old = (String) session.get("moTa_Cu");

					StrHoatDong = "Cap nhat doi tuong Chu De: " + " (Ten Chu De: " + tenChuDe_Old + "), ( Mo ta: "
							+ moTa_Old + "), (Loai: " + tenLoai_Old + ") => CAP NHAT THANH " + " (Ten Chu De: "
							+ tenChuDe + "), ( Mo ta: " + moTa + "), (Loai: " + tenLoai + ")";
					comm(StrHoatDong);

					kq = chuDeDao.capNhat(objChuDe);
				
				} else { // check trung ten. TH trung ten

					for (ChuDe cddtt : lstChuDe) {
						idDaTonTai = cddtt.getId();
					}

					if (idTruyenVao == idDaTonTai) { // Trung ten nhung idDaTonTai == id muon sua
						objChuDe.setId(Integer.parseInt(chuDeId));

						loaiId = objChuDe.getLoaiId(); // Phai Co Dong nay, Ko no NULL
						objLoai = loaiDao.layChiTietTheoId(loaiId);
						tenLoai = objLoai.getTenLoai();
						objChuDe.setTenLoai(tenLoai);

						/**
						 * Nhat Ky
						 */
						moTa = objChuDe.getMoTa();
						tenChuDe = objChuDe.getTenChuDe();
						tenLoai_Old = (String) session.get("tenLoai_Cu");
						tenChuDe_Old = (String) session.get("tenChuDe_Cu");
						moTa_Old = (String) session.get("moTa_Cu");

						StrHoatDong = "Cap nhat doi tuong Chu De: " + " (Ten Chu De: " + tenChuDe_Old + "), ( Mo ta: "
								+ moTa_Old + "), (Loai: " + tenLoai_Old + ") => CAP NHAT THANH " + " (Ten Chu De: "
								+ tenChuDe + "), ( Mo ta: " + moTa + "), (Loai: " + tenLoai + ")";
						comm(StrHoatDong);

						kq = chuDeDao.capNhat(objChuDe);
						
					} else if (idTruyenVao != idDaTonTai) { // Trung ten va idDaTonTai != id muon sua
						lstLoai = loaiDao.layDanhSach();
					}
				}

			} else {

				/**
				 * TH Them
				 */
				tenChuDe = objChuDe.getTenChuDe();
				lstChuDe = chuDeDao.timKiemChuDeTheoTen(tenChuDe);
				if (lstChuDe == null || lstChuDe.isEmpty()) { // check trung ten. TH ko trung ten

					loaiId = objChuDe.getLoaiId(); // Phai Co Dong nay, Ko no NULL
					objLoai = loaiDao.layChiTietTheoId(loaiId);
					tenLoai = objLoai.getTenLoai();
					objChuDe.setTenLoai(tenLoai);

					/**
					 * Nhat Ky
					 */

					moTa = objChuDe.getMoTa();
					tenChuDe = objChuDe.getTenChuDe();

					StrHoatDong = "Them doi tuong Chu De: " + " (Ten chu de: " + tenChuDe + "), ( Mo ta: " + moTa
							+ "), " + "(Loai: " + tenLoai + ")";
					comm(StrHoatDong);

					kq = chuDeDao.themMoi(objChuDe);
										
				} else { // TH Trung ten
					
					lstLoai = loaiDao.layDanhSach();                  // BUG O DAY CHU DAU. FONTEND CAN MA BACKEND KO CAP => CHET					
				}
			}

			if (kq) {
				return SUCCESS;
			}
		}
		
		addActionError("Ten chu de bi trung ");
		return INPUT;
	}

	/**
	 * @return
	 */
	public String xoaThongTinChuDe() {

		/**
		 * Nhat Ky truoc. Xoa obj sau
		 */

		ChuDe objChuDe = chuDeDao.layChiTietTheoId(ma);
		tenChuDe = objChuDe.getTenChuDe();
		moTa = objChuDe.getMoTa();
		loaiId = objChuDe.getLoaiId();
		Loai objLoai = loaiDao.layChiTietTheoId(loaiId);
		tenLoai = objLoai.getTenLoai();

		StrHoatDong = "Xoa doi tuong Chu De: " + " (Ten Chu De: " + tenChuDe + "), ( Mo ta: " + moTa + "), (Loai: "
				+ tenLoai + ")";
		comm(StrHoatDong);

		chuDeDao.xoa(ma);
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
