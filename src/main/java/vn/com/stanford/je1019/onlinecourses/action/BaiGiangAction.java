package vn.com.stanford.je1019.onlinecourses.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.BaiGiang;
import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.GiangVienDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class BaiGiangAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 131334433403853817L;

	@Autowired
	BaiGiangDAO baiGiangDao;

	@Autowired
	GiangVienDAO giangVienDao;

	@Autowired
	KhoaHocDAO khoaHocDao;

	private List<BaiGiang> lstBaiGiang;
	private List<GiangVien> lstGiangVien;
	private List<KhoaHoc> lstKhoaHoc;
	private Integer id;
	private Integer thuTu;
	private String tenBaiGiang;
	private String anhDaiDien;
	private Date ngayTao;
	private String thoiLuong;
	private Date ngayCapNhat;
	private String moTa;
	private Date ngayDang;
	private Boolean daDuyet;
	private Integer giangVienId;
	private Integer khoaHocId;

	private String baiGiang;
	private String tuKhoa;
	private String moTaTimKiem;

	private BaiGiang objBaiGiang;
	private Integer ma;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private String baiGiangId;
	private Integer maKhoaHocTimKiem;

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

	private Integer thuTu_Old;
	private String tenBaiGiang_Old;
	private String moTa_Old;
	private String tenGiangVien;
	private String tenKhoaHoc;
	private String tenGiangVien_Old;
	private String tenKhoaHoc_Old;

	/**
	 * Check Trung
	 * 
	 */
	private Integer idTruyenVao;
	private Integer idDaTonTai;

	public String getBaiGiang() {
		return baiGiang;
	}

	public void setBaiGiang(String baiGiang) {
		this.baiGiang = baiGiang;
	}

	public BaiGiangDAO getBaiGiangDao() {
		return baiGiangDao;
	}

	public void setBaiGiangDao(BaiGiangDAO baiGiangDao) {
		this.baiGiangDao = baiGiangDao;
	}

	public List<BaiGiang> getLstBaiGiang() {
		return lstBaiGiang;
	}

	public void setLstBaiGiang(List<BaiGiang> lstBaiGiang) {
		this.lstBaiGiang = lstBaiGiang;
	}

	public Integer getThuTu() {
		return thuTu;
	}

	public void setThuTu(Integer thuTu) {
		this.thuTu = thuTu;
	}

	public String getTenBaiGiang() {
		return tenBaiGiang;
	}

	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
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

	public Date getNgayDang() {
		return ngayDang;
	}

	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}

	public Boolean getDaDuyet() {
		return daDuyet;
	}

	public void setDaDuyet(Boolean daDuyet) {
		this.daDuyet = daDuyet;
	}

	public Integer getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(Integer giangVienId) {
		this.giangVienId = giangVienId;
	}

	public Integer getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public List<GiangVien> getLstGiangVien() {
		return lstGiangVien;
	}

	public void setLstGiangVien(List<GiangVien> lstGiangVien) {
		this.lstGiangVien = lstGiangVien;
	}

	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	public GiangVienDAO getGiangVienDao() {
		return giangVienDao;
	}

	public void setGiangVienDao(GiangVienDAO giangVienDao) {
		this.giangVienDao = giangVienDao;
	}

	public KhoaHocDAO getKhoaHocDao() {
		return khoaHocDao;
	}

	public void setKhoaHocDao(KhoaHocDAO khoaHocDao) {
		this.khoaHocDao = khoaHocDao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getMoTaTimKiem() {
		return moTaTimKiem;
	}

	public void setMoTaTimKiem(String moTaTimKiem) {
		this.moTaTimKiem = moTaTimKiem;
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

	public Integer getThuTu_Old() {
		return thuTu_Old;
	}

	public void setThuTu_Old(Integer thuTu_Old) {
		this.thuTu_Old = thuTu_Old;
	}

	public String getTenBaiGiang_Old() {
		return tenBaiGiang_Old;
	}

	public void setTenBaiGiang_Old(String tenBaiGiang_Old) {
		this.tenBaiGiang_Old = tenBaiGiang_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getTenGiangVien_Old() {
		return tenGiangVien_Old;
	}

	public void setTenGiangVien_Old(String tenGiangVien_Old) {
		this.tenGiangVien_Old = tenGiangVien_Old;
	}

	public String getTenKhoaHoc_Old() {
		return tenKhoaHoc_Old;
	}

	public void setTenKhoaHoc_Old(String tenKhoaHoc_Old) {
		this.tenKhoaHoc_Old = tenKhoaHoc_Old;
	}

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
	}

	public BaiGiang getObjBaiGiang() {
		return objBaiGiang;
	}

	public void setObjBaiGiang(BaiGiang objBaiGiang) {
		this.objBaiGiang = objBaiGiang;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
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

	public String getBaiGiangId() {
		return baiGiangId;
	}

	public void setBaiGiangId(String baiGiangId) {
		this.baiGiangId = baiGiangId;
	}

	public Integer getMaKhoaHocTimKiem() {
		return maKhoaHocTimKiem;
	}

	public void setMaKhoaHocTimKiem(Integer maKhoaHocTimKiem) {
		this.maKhoaHocTimKiem = maKhoaHocTimKiem;
	}

	public Integer getIdTruyenVao() {
		return idTruyenVao;
	}

	public void setIdTruyenVao(Integer idTruyenVao) {
		this.idTruyenVao = idTruyenVao;
	}

	public Integer getIdDaTonTai() {
		return idDaTonTai;
	}

	public void setIdDaTonTai(Integer idDaTonTai) {
		this.idDaTonTai = idDaTonTai;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lstBaiGiang = baiGiangDao.layDanhSach();
		lstGiangVien = giangVienDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Bai Giang");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	/**
	 * 
	 * @return
	 */
	public String chiTietBaiGiang() {

		lstGiangVien = giangVienDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();

		if (ma != null) {
			objBaiGiang = baiGiangDao.layChiTietTheoId(ma);

			/**
			 * Nhat Ky
			 */
			giangVienId = objBaiGiang.getGiangVienId();
			GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
			tenGiangVien_Old = objGiangVien.getTenGiangVien();
			session.put("tenGiangVien_Cu", tenGiangVien_Old);

			khoaHocId = objBaiGiang.getKhoaHocId();
			KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
			tenKhoaHoc_Old = objKhoaHoc.getTenKhoaHoc();
			session.put("tenKhoaHoc_Cu", tenKhoaHoc_Old);

			thuTu_Old = objBaiGiang.getThuTu();
			session.put("thuTu_Cu", thuTu_Old);
			tenBaiGiang_Old = objBaiGiang.getTenBaiGiang();
			session.put("tenBaiGiang_Cu", tenBaiGiang_Old);
			moTa_Old = objBaiGiang.getMoTa();
			session.put("moTa_Cu", moTa_Old);
		}
		return SUCCESS;
	}

	/**
	 * Xá»­ lÃ½ thÃªm má»›i vÃ  cáº­p nháº­t sÃ¡ch
	 * 
	 * @return
	 */
	public String themMoiHoacCapNhat() {
		if (objBaiGiang != null) {
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
				objBaiGiang.setAnhDaiDien(fileUploadFileName);
			}

			// Kiá»ƒm tra TH sá»­a
			boolean kq = false;
			if (!StringUtils.isEmpty(baiGiangId)) {

				/**
				 * TH Sua
				 */
				idTruyenVao = Integer.parseInt(baiGiangId);
				tenBaiGiang = objBaiGiang.getTenBaiGiang();
				lstBaiGiang = baiGiangDao.timKiemBaiGiangTheoTen(tenBaiGiang);

				if (lstBaiGiang == null || lstBaiGiang.isEmpty()) { // check trung ten. TH ko trung ten
					objBaiGiang.setId(Integer.parseInt(baiGiangId));

					kq = baiGiangDao.capNhat(objBaiGiang);

					/**
					 * Nhat Ky
					 */

					thuTu_Old = (Integer) session.get("thuTu_Cu");
					tenBaiGiang_Old = (String) session.get("tenBaiGiang_Cu");
					moTa_Old = (String) session.get("moTa_Cu");
					tenGiangVien_Old = (String) session.get("tenGiangVien_Cu");
					tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");

					thuTu = objBaiGiang.getThuTu();
					tenBaiGiang = objBaiGiang.getTenBaiGiang();
					moTa = objBaiGiang.getMoTa();
					giangVienId = objBaiGiang.getGiangVienId();
					GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
					tenGiangVien = objGiangVien.getTenGiangVien();

					khoaHocId = objBaiGiang.getKhoaHocId();
					KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
					tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();

					StrHoatDong = "Cap nhat doi tuong Khoa Hoc: " + " (Thu Tu: " + thuTu_Old + "), ( Ten Bai Giang: "
							+ tenBaiGiang_Old + "), (Mo Ta:" + moTa_Old + "), (Ten Giang Vien: " + tenGiangVien_Old
							+ "), (Ten Khoa Hoc: " + tenKhoaHoc_Old + ")"

							+ "=> CAP NHAT THANH " + " (Thu Tu: " + thuTu + "), ( Ten Bai Giang: " + tenBaiGiang
							+ "), (Mo Ta:" + moTa + "), (Ten Giang Vien: " + tenGiangVien + "), (Ten Khoa Hoc: "
							+ tenKhoaHoc + ")";
					comm(StrHoatDong);
				} else {                                    // check trung ten. TH trung ten

					for (BaiGiang dtt : lstBaiGiang) {
						idDaTonTai = dtt.getId();
					}

					if (idTruyenVao == idDaTonTai) { // Trung ten nhung idDaTonTai == id muon sua
						objBaiGiang.setId(Integer.parseInt(baiGiangId));

						kq = baiGiangDao.capNhat(objBaiGiang);

						/**
						 * Nhat Ky
						 */

						thuTu_Old = (Integer) session.get("thuTu_Cu");
						tenBaiGiang_Old = (String) session.get("tenBaiGiang_Cu");
						moTa_Old = (String) session.get("moTa_Cu");
						tenGiangVien_Old = (String) session.get("tenGiangVien_Cu");
						tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");

						thuTu = objBaiGiang.getThuTu();
						tenBaiGiang = objBaiGiang.getTenBaiGiang();
						moTa = objBaiGiang.getMoTa();
						giangVienId = objBaiGiang.getGiangVienId();
						GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
						tenGiangVien = objGiangVien.getTenGiangVien();

						khoaHocId = objBaiGiang.getKhoaHocId();
						KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
						tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();

						StrHoatDong = "Cap nhat doi tuong Khoa Hoc: " + " (Thu Tu: " + thuTu_Old
								+ "), ( Ten Bai Giang: " + tenBaiGiang_Old + "), (Mo Ta:" + moTa_Old
								+ "), (Ten Giang Vien: " + tenGiangVien_Old + "), (Ten Khoa Hoc: " + tenKhoaHoc_Old
								+ ")"

								+ "=> CAP NHAT THANH " + " (Thu Tu: " + thuTu + "), ( Ten Bai Giang: " + tenBaiGiang
								+ "), (Mo Ta:" + moTa + "), (Ten Giang Vien: " + tenGiangVien + "), (Ten Khoa Hoc: "
								+ tenKhoaHoc + ")";
						comm(StrHoatDong);
					} else if (idTruyenVao != idDaTonTai) { // Trung ten va idDaTonTai != id muon sua
						lstGiangVien = giangVienDao.layDanhSach();
						lstKhoaHoc = khoaHocDao.layDanhSach();
					}
				}

			} else {

				/**
				 * TH Them
				 */
				tenBaiGiang = objBaiGiang.getTenBaiGiang();
				lstBaiGiang = baiGiangDao.timKiemBaiGiangTheoTen(tenBaiGiang);
				if (lstBaiGiang == null || lstBaiGiang.isEmpty()) { // check trung ten. TH ko trung ten

					kq = baiGiangDao.themMoi(objBaiGiang);

					/**
					 * Nhat Ky
					 */
					thuTu = objBaiGiang.getThuTu();
					tenBaiGiang = objBaiGiang.getTenBaiGiang();
					moTa = objBaiGiang.getMoTa();
					giangVienId = objBaiGiang.getGiangVienId();
					GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
					tenGiangVien = objGiangVien.getTenGiangVien();

					khoaHocId = objBaiGiang.getKhoaHocId();
					KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
					tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();

					StrHoatDong = "Them doi tuong Bai Giang: " + " (Thu Tu: " + thuTu + "), ( Ten Bai Giang: "
							+ tenBaiGiang + "), (Mo Ta:" + moTa + "), (Ten Giang Vien: " + tenGiangVien
							+ "), (Ten Khoa Hoc: " + tenKhoaHoc + ")";
					comm(StrHoatDong);
				} else {                                        // TH Trung ten
					lstGiangVien = giangVienDao.layDanhSach();
					lstKhoaHoc = khoaHocDao.layDanhSach();
				}

			}

			if (kq) {
				return SUCCESS;
			}
		}
		addActionError("Ten bai giang bi trung ");
		return INPUT;
	}

	/**
	 * @return
	 */
	public String xoaThongTinBaiGiang() {

		/**
		 * Nhat Ky truoc. Xoa obj sau
		 */

		BaiGiang objBaiGiang = baiGiangDao.layChiTietTheoId(ma);
		thuTu = objBaiGiang.getThuTu();
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
		moTa = objBaiGiang.getMoTa();

		giangVienId = objBaiGiang.getGiangVienId();
		GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
		tenGiangVien = objGiangVien.getTenGiangVien();

		khoaHocId = objBaiGiang.getKhoaHocId();
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(khoaHocId);
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();

		StrHoatDong = "Xoa doi tuong Bai Giang: " + " (Thu Tu: " + thuTu + "), ( Ten Bai Giang: " + tenBaiGiang
				+ "), (Mo Ta:" + moTa + "), (Ten Giang Vien: " + tenGiangVien + "), (Ten Khoa Hoc: " + tenKhoaHoc + ")";
		comm(StrHoatDong);

		baiGiangDao.xoa(ma);
		return SUCCESS;
	}

	public String timKiemBaiGiang() {

		lstGiangVien = giangVienDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();

		lstBaiGiang = baiGiangDao.timKiemBaiGiang(tuKhoa, tuKhoa, maKhoaHocTimKiem);
		System.out.println("MAKHOAHOCTIMKIEM: "+ maKhoaHocTimKiem);

		return SUCCESS;
	}

	/**
	 * Duyet hang loat
	 */
	public String duyetBaiGiang() {

		objBaiGiang = baiGiangDao.layChiTietTheoId(id);

		objBaiGiang.setDaDuyet(true);
		baiGiangDao.capNhat(objBaiGiang);

		return SUCCESS;
	}

	/**
	 * Bo Duyet hang loat
	 */
	public String boDuyetBaiGiang() {

		objBaiGiang = baiGiangDao.layChiTietTheoId(id);

		objBaiGiang.setDaDuyet(false);
		baiGiangDao.capNhat(objBaiGiang);

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
