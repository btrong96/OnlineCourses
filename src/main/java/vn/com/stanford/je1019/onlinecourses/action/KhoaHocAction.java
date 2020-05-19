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

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;
import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;
import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.GiangVienDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class KhoaHocAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8848095840501575911L;
	
	@Autowired
	KhoaHocDAO khoaHocDao;

	@Autowired
	ChuDeDAO chuDeDao;

	@Autowired
	CapDoDAO capDoDao;

	@Autowired
	GiangVienDAO giangVienDao;

	private List<KhoaHoc> lstKhoaHoc;
	private List<ChuDe> lstChuDe;
	private List<CapDo> lstCapDo;
	private List<GiangVien> lstGiangVien;


	private String tuKhoa;
	private Integer maChuDeTimKiem;
	private Integer maCapDoTimKiem;
	private Integer maGiangVienTimKiem;

	private KhoaHoc objKhoaHoc;
	private Integer ma;
	private File fileUpload;
	private String fileUploadFileName;
	private String fileUploadContentType;
	private String khoaHocId;
	private Integer id;

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
	
	private String tenKhoaHoc;
	private Date ngayXuatBan;
	private Date ngayCapNhat;
	private Date ngayDang;
	private Boolean daDuyet;
	private Boolean mienPhi;
	private Double hocPhi;
	private String moTa;
	private Integer chuDeId;
	private String tenChuDe;
	private Integer capDoId;
	private String tenCapDo;
	private Integer giangVienId;
	private String tenGiangVien;
	
	private String tenKhoaHoc_Old;
	private Date ngayXuatBan_Old;
	private Date ngayCapNhat_Old;
	private Date ngayDang_Old;
	private Boolean daDuyet_Old;
	private Boolean mienPhi_Old;
	private Double hocPhi_Old;
	private String moTa_Old;
	private Integer chuDeId_Old;
	private String tenChuDe_Old;
	private Integer capDoId_Old;
	private String tenCapDo_Old;
	private Integer giangVienId_Old;
	private String tenGiangVien_Old;
	
	/**
	 *  Check Trung
	 * 
	 */
    private Integer idTruyenVao;
    private Integer idDaTonTai;
    
	// XEM CHI TIET KHOA HOC
    private String khoaHoc;
    
	public String getKhoaHoc() {
		return khoaHoc;
	}

	public void setKhoaHoc(String khoaHoc) {
		this.khoaHoc = khoaHoc;
	}

	public Integer getIdDaTonTai() {
		return idDaTonTai;
	}

	public void setIdDaTonTai(Integer idDaTonTai) {
		this.idDaTonTai = idDaTonTai;
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

	public ChuDeDAO getChuDeDao() {
		return chuDeDao;
	}

	public void setChuDeDao(ChuDeDAO chuDeDao) {
		this.chuDeDao = chuDeDao;
	}

	public KhoaHoc getObjKhoaHoc() {
		return objKhoaHoc;
	}

	public void setObjKhoaHoc(KhoaHoc objKhoaHoc) {
		this.objKhoaHoc = objKhoaHoc;
	}

	public List<ChuDe> getLstChuDe() {
		return lstChuDe;
	}

	public void setLstChuDe(List<ChuDe> lstChuDe) {
		this.lstChuDe = lstChuDe;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public Integer getMaChuDeTimKiem() {
		return maChuDeTimKiem;
	}

	public void setMaChuDeTimKiem(Integer maChuDeTimKiem) {
		this.maChuDeTimKiem = maChuDeTimKiem;
	}

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

	public Integer getMaCapDoTimKiem() {
		return maCapDoTimKiem;
	}

	public void setMaCapDoTimKiem(Integer maCapDoTimKiem) {
		this.maCapDoTimKiem = maCapDoTimKiem;
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

	public Integer getMaGiangVienTimKiem() {
		return maGiangVienTimKiem;
	}

	public void setMaGiangVienTimKiem(Integer maGiangVienTimKiem) {
		this.maGiangVienTimKiem = maGiangVienTimKiem;
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

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public String getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(String khoaHocId) {
		this.khoaHocId = khoaHocId;
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

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public Date getNgayXuatBan() {
		return ngayXuatBan;
	}

	public void setNgayXuatBan(Date ngayXuatBan) {
		this.ngayXuatBan = ngayXuatBan;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
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

	public Boolean getMienPhi() {
		return mienPhi;
	}

	public void setMienPhi(Boolean mienPhi) {
		this.mienPhi = mienPhi;
	}

	public Double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(Double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getChuDeId() {
		return chuDeId;
	}

	public void setChuDeId(Integer chuDeId) {
		this.chuDeId = chuDeId;
	}

	public Integer getCapDoId() {
		return capDoId;
	}

	public void setCapDoId(Integer capDoId) {
		this.capDoId = capDoId;
	}

	public Integer getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(Integer giangVienId) {
		this.giangVienId = giangVienId;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public String getTenCapDo() {
		return tenCapDo;
	}

	public void setTenCapDo(String tenCapDo) {
		this.tenCapDo = tenCapDo;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getTenKhoaHoc_Old() {
		return tenKhoaHoc_Old;
	}

	public void setTenKhoaHoc_Old(String tenKhoaHoc_Old) {
		this.tenKhoaHoc_Old = tenKhoaHoc_Old;
	}

	public Date getNgayXuatBan_Old() {
		return ngayXuatBan_Old;
	}

	public void setNgayXuatBan_Old(Date ngayXuatBan_Old) {
		this.ngayXuatBan_Old = ngayXuatBan_Old;
	}

	public Date getNgayCapNhat_Old() {
		return ngayCapNhat_Old;
	}

	public void setNgayCapNhat_Old(Date ngayCapNhat_Old) {
		this.ngayCapNhat_Old = ngayCapNhat_Old;
	}

	public Date getNgayDang_Old() {
		return ngayDang_Old;
	}

	public void setNgayDang_Old(Date ngayDang_Old) {
		this.ngayDang_Old = ngayDang_Old;
	}

	public Boolean getDaDuyet_Old() {
		return daDuyet_Old;
	}

	public void setDaDuyet_Old(Boolean daDuyet_Old) {
		this.daDuyet_Old = daDuyet_Old;
	}

	public Boolean getMienPhi_Old() {
		return mienPhi_Old;
	}

	public void setMienPhi_Old(Boolean mienPhi_Old) {
		this.mienPhi_Old = mienPhi_Old;
	}

	public Double getHocPhi_Old() {
		return hocPhi_Old;
	}

	public void setHocPhi_Old(Double hocPhi_Old) {
		this.hocPhi_Old = hocPhi_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public Integer getChuDeId_Old() {
		return chuDeId_Old;
	}

	public void setChuDeId_Old(Integer chuDeId_Old) {
		this.chuDeId_Old = chuDeId_Old;
	}

	public String getTenChuDe_Old() {
		return tenChuDe_Old;
	}

	public void setTenChuDe_Old(String tenChuDe_Old) {
		this.tenChuDe_Old = tenChuDe_Old;
	}

	public Integer getCapDoId_Old() {
		return capDoId_Old;
	}

	public void setCapDoId_Old(Integer capDoId_Old) {
		this.capDoId_Old = capDoId_Old;
	}

	public String getTenCapDo_Old() {
		return tenCapDo_Old;
	}

	public void setTenCapDo_Old(String tenCapDo_Old) {
		this.tenCapDo_Old = tenCapDo_Old;
	}

	public Integer getGiangVienId_Old() {
		return giangVienId_Old;
	}

	public void setGiangVienId_Old(Integer giangVienId_Old) {
		this.giangVienId_Old = giangVienId_Old;
	}

	public String getTenGiangVien_Old() {
		return tenGiangVien_Old;
	}

	public void setTenGiangVien_Old(String tenGiangVien_Old) {
		this.tenGiangVien_Old = tenGiangVien_Old;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		lstChuDe = chuDeDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly khoa hoc");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	
	
	/**	 
	 * 
	 * @return
	 */
	public String chiTietKhoaHoc() {
	
		lstChuDe = chuDeDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstGiangVien = giangVienDao.layDanhSach();

		if(ma!=null)
		{
			objKhoaHoc = khoaHocDao.layChiTietTheoId(ma);		
			
			/**
			 *   Nhat Ky
			 */		
			tenKhoaHoc_Old = objKhoaHoc.getTenKhoaHoc();
			session.put("tenKhoaHoc_Cu", tenKhoaHoc_Old);			
			ngayXuatBan_Old = objKhoaHoc.getNgayXuatBan();
			session.put("ngayXuatBan_Cu", ngayXuatBan_Old);
			ngayCapNhat_Old = objKhoaHoc.getNgayCapNhat();
			session.put("ngayCapNhat_Cu", ngayCapNhat_Old);
			ngayDang_Old = objKhoaHoc.getNgayDang();
			session.put("ngayDang_Cu", ngayDang_Old);
			daDuyet_Old = objKhoaHoc.getDaDuyet();
			session.put("daDuyet_Cu", daDuyet_Old);
			mienPhi_Old = objKhoaHoc.getMienPhi();
			session.put("mienPhi_Cu", mienPhi_Old);
			hocPhi_Old = objKhoaHoc.getHocPhi();
			session.put("hocPhi_Cu", hocPhi_Old);
			moTa_Old = objKhoaHoc.getMoTa();
			session.put("moTa_Cu", moTa_Old);
			
			chuDeId_Old = objKhoaHoc.getChuDeId();
			ChuDe objChuDe = chuDeDao.layChiTietTheoId(chuDeId_Old);
			tenChuDe_Old = objChuDe.getTenChuDe();
			session.put("tenChuDe_Cu", tenChuDe_Old);
			
			capDoId_Old = objKhoaHoc.getCapDoId();	
			CapDo objCapDo = capDoDao.layChiTietTheoId(capDoId_Old);
			tenCapDo_Old = objCapDo.getTenCapDo();
			session.put("tenCapDo_Cu", tenCapDo_Old);
			
			giangVienId_Old = objKhoaHoc.getGiangVienId();
			GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId_Old);
			tenGiangVien_Old = objGiangVien.getTenGiangVien();
			session.put("tenGiangVien_Cu", tenGiangVien_Old);
			
		}	
		return SUCCESS;
	}

	/**
	 * Xá»­ lÃ½ thÃªm má»›i vÃ  cáº­p nháº­t sÃ¡ch
	 * @return
	 */
	public String themMoiHoacCapNhat() {
		if (objKhoaHoc != null) {
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
				objKhoaHoc.setAnhDaiDien(fileUploadFileName);				
			}

			// Kiá»ƒm tra TH sá»­a
			boolean kq = false;
			if (!StringUtils.isEmpty(khoaHocId)) {
				
				/**
				 * TH Sua
				 */
								
				idTruyenVao = Integer.parseInt(khoaHocId);				
				tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
				lstKhoaHoc = khoaHocDao.timKiemKhoaHocTheoTen(tenKhoaHoc);
				
				if(lstKhoaHoc == null || lstKhoaHoc.isEmpty()) {          //  check trung ten. TH ko trung ten
					objKhoaHoc.setId(Integer.parseInt(khoaHocId));
					kq = khoaHocDao.capNhat(objKhoaHoc);	
					

					/**
					 *   Nhat Ky
					 */
					tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");
					ngayXuatBan_Old = (Date) session.get("ngayXuatBan_Cu");
					ngayCapNhat_Old = (Date) session.get("ngayCapNhat_Cu");
					ngayDang_Old = (Date) session.get("ngayDang_Cu");
					daDuyet_Old = (Boolean) session.get("daDuyet_Cu");
					mienPhi_Old = (Boolean) session.get("mienPhi_Cu");
					hocPhi_Old = (Double) session.get("hocPhi_Cu");
					moTa_Old = (String) session.get("moTa_Cu");
					tenChuDe_Old = (String) session.get("tenChuDe_Cu");
					tenCapDo_Old = (String) session.get("tenCapDo_Cu"); 
					tenGiangVien_Old = (String) session.get("tenGiangVien_Cu");
					
					tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
					ngayXuatBan = objKhoaHoc.getNgayXuatBan();
					ngayCapNhat = objKhoaHoc.getNgayCapNhat();
					ngayDang = objKhoaHoc.getNgayDang();
					daDuyet = objKhoaHoc.getDaDuyet();
					mienPhi = objKhoaHoc.getMienPhi();
					hocPhi = objKhoaHoc.getHocPhi();
					moTa = objKhoaHoc.getMoTa();
					
					chuDeId = objKhoaHoc.getChuDeId();
					ChuDe objChuDe = chuDeDao.layChiTietTheoId(chuDeId);
					tenChuDe = objChuDe.getTenChuDe();
					capDoId = objKhoaHoc.getCapDoId();
					CapDo objCapDo = capDoDao.layChiTietTheoId(capDoId);
					tenCapDo = objCapDo.getTenCapDo();
					giangVienId = objKhoaHoc.getGiangVienId();
					GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
					tenGiangVien = objGiangVien.getTenGiangVien();
					

					StrHoatDong = "Cap nhat doi tuong Khoa Hoc: " + " (Ten Khoa Hoc: " + tenKhoaHoc_Old + "), ( Ngay Xuat Ban: "
							+ ngayXuatBan_Old + "), ( Ngay Cap Nhat: "	+ ngayCapNhat_Old + "), (Ngay Dang: " + ngayDang_Old 
							+ "), (Da Duyet: " + daDuyet_Old +"), (Mien Phi: " + mienPhi_Old 
							+ "), (Hoc Phi: " + hocPhi_Old +"), (Mo Ta: " + moTa_Old + "), (Chu De: " + tenChuDe_Old 
							+ "), (Cap Do: " + tenCapDo_Old + "), (Giang Vien: " + tenGiangVien_Old +")"
							
							+ "=> CAP NHAT THANH " + " (Ten Khoa Hoc: " + tenKhoaHoc + "), ( Ngay Xuat Ban: "
							+ ngayXuatBan +"), (Ngay Cap Nhat: "+ ngayCapNhat + "), (Ngay Dang: " + ngayDang + "), (Da Duyet: " + daDuyet 
				    		+"), (Mien Phi: " + mienPhi + "), (Hoc Phi: " + hocPhi +"), (Mo Ta: " + moTa + "), (Chu De: " + tenChuDe 
							+ "), (Cap Do: " + tenCapDo + "), (Giang Vien: " + tenGiangVien +")";
					comm(StrHoatDong);
					
				} else {
					
					for(KhoaHoc khdtt: lstKhoaHoc) {
						idDaTonTai = khdtt.getId();
					}
					
					if(idTruyenVao == idDaTonTai) {                 // Trung tenloai nhung idDaTonTai == id muon sua
						objKhoaHoc.setId(Integer.parseInt(khoaHocId));
						kq = khoaHocDao.capNhat(objKhoaHoc);	
						

						/**
						 *   Nhat Ky
						 */
						tenKhoaHoc_Old = (String) session.get("tenKhoaHoc_Cu");
						ngayXuatBan_Old = (Date) session.get("ngayXuatBan_Cu");
						ngayCapNhat_Old = (Date) session.get("ngayCapNhat_Cu");
						ngayDang_Old = (Date) session.get("ngayDang_Cu");
						daDuyet_Old = (Boolean) session.get("daDuyet_Cu");
						mienPhi_Old = (Boolean) session.get("mienPhi_Cu");
						hocPhi_Old = (Double) session.get("hocPhi_Cu");
						moTa_Old = (String) session.get("moTa_Cu");
						tenChuDe_Old = (String) session.get("tenChuDe_Cu");
						tenCapDo_Old = (String) session.get("tenCapDo_Cu"); 
						tenGiangVien_Old = (String) session.get("tenGiangVien_Cu");
						
						tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
						ngayXuatBan = objKhoaHoc.getNgayXuatBan();
						ngayCapNhat = objKhoaHoc.getNgayCapNhat();
						ngayDang = objKhoaHoc.getNgayDang();
						daDuyet = objKhoaHoc.getDaDuyet();
						mienPhi = objKhoaHoc.getMienPhi();
						hocPhi = objKhoaHoc.getHocPhi();
						moTa = objKhoaHoc.getMoTa();
						
						chuDeId = objKhoaHoc.getChuDeId();
						ChuDe objChuDe = chuDeDao.layChiTietTheoId(chuDeId);
						tenChuDe = objChuDe.getTenChuDe();
						capDoId = objKhoaHoc.getCapDoId();
						CapDo objCapDo = capDoDao.layChiTietTheoId(capDoId);
						tenCapDo = objCapDo.getTenCapDo();
						giangVienId = objKhoaHoc.getGiangVienId();
						GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
						tenGiangVien = objGiangVien.getTenGiangVien();
						

						StrHoatDong = "Cap nhat doi tuong Khoa Hoc: " + " (Ten Khoa Hoc: " + tenKhoaHoc_Old + "), ( Ngay Xuat Ban: "
								+ ngayXuatBan_Old + "), ( Ngay Cap Nhat: "	+ ngayCapNhat_Old + "), (Ngay Dang: " + ngayDang_Old 
								+ "), (Da Duyet: " + daDuyet_Old +"), (Mien Phi: " + mienPhi_Old 
								+ "), (Hoc Phi: " + hocPhi_Old +"), (Mo Ta: " + moTa_Old + "), (Chu De: " + tenChuDe_Old 
								+ "), (Cap Do: " + tenCapDo_Old + "), (Giang Vien: " + tenGiangVien_Old +")"
								
								+ "=> CAP NHAT THANH " + " (Ten Khoa Hoc: " + tenKhoaHoc + "), ( Ngay Xuat Ban: "
								+ ngayXuatBan +"), (Ngay Cap Nhat: "+ ngayCapNhat + "), (Ngay Dang: " + ngayDang + "), (Da Duyet: " + daDuyet 
					    		+"), (Mien Phi: " + mienPhi + "), (Hoc Phi: " + hocPhi +"), (Mo Ta: " + moTa + "), (Chu De: " + tenChuDe 
								+ "), (Cap Do: " + tenCapDo + "), (Giang Vien: " + tenGiangVien +")";
						comm(StrHoatDong);
					} else if(idTruyenVao != idDaTonTai) {             // Trung tenloai va idDaTonTai != id muon sua
						lstChuDe = chuDeDao.layDanhSach();
						lstCapDo = capDoDao.layDanhSach();
						lstGiangVien = giangVienDao.layDanhSach();
					}					
				}
				
				
				
			} else {
				
				/**
				 * TH Them
				 */
				
				tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
				lstKhoaHoc = khoaHocDao.timKiemKhoaHocTheoTen(tenKhoaHoc);
				
				if(lstKhoaHoc == null || lstKhoaHoc.isEmpty()) {  //  check trung ten
				
				kq = khoaHocDao.themMoi(objKhoaHoc);	
				
				/**
				 *   Nhat Ky
				 */
				tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
				ngayXuatBan = objKhoaHoc.getNgayXuatBan();
				ngayDang = objKhoaHoc.getNgayDang();
				daDuyet = objKhoaHoc.getDaDuyet();
				mienPhi = objKhoaHoc.getMienPhi();
				hocPhi = objKhoaHoc.getHocPhi();
				moTa = objKhoaHoc.getMoTa();
				
				chuDeId = objKhoaHoc.getChuDeId();
				ChuDe objChuDe = chuDeDao.layChiTietTheoId(chuDeId);
				tenChuDe = objChuDe.getTenChuDe();
				capDoId = objKhoaHoc.getCapDoId();
				CapDo objCapDo = capDoDao.layChiTietTheoId(capDoId);
				tenCapDo = objCapDo.getTenCapDo();
				giangVienId = objKhoaHoc.getGiangVienId();
				GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
				tenGiangVien = objGiangVien.getTenGiangVien();
				
				
				StrHoatDong = "Them doi tuong Khoa Hoc: " + " (Ten Khoa Hoc: " + tenKhoaHoc + "), ( Ngay Xuat Ban: "
						+ ngayXuatBan + "), (Ngay Dang: " + ngayDang + "), (Da Duyet: " + daDuyet +"), (Mien Phi: " + mienPhi 
						+ "), (Hoc Phi: " + hocPhi +"), (Mo Ta: " + moTa + "), (Chu De: " + tenChuDe 
						+ "), (Cap Do: " + tenCapDo + "), (Giang Vien: " + tenGiangVien +")";
				comm(StrHoatDong);
				}
				else {
					lstChuDe = chuDeDao.layDanhSach();
					lstCapDo = capDoDao.layDanhSach();
					lstGiangVien = giangVienDao.layDanhSach();
				}
			}

			if (kq) {
				return SUCCESS;
			}
		}
		
		addActionError("Ten khoa hoc bi trung ");
		return INPUT;
	}

	/**
	 * @return
	 */
	public String xoaThongTinKhoaHoc()
	{
		/**
		 *   Nhat Ky
		 */
		objKhoaHoc = khoaHocDao.layChiTietTheoId(ma);
		
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();
		ngayXuatBan = objKhoaHoc.getNgayXuatBan();
		ngayCapNhat= objKhoaHoc.getNgayCapNhat();
		ngayDang = objKhoaHoc.getNgayDang();
		daDuyet = objKhoaHoc.getDaDuyet();
		mienPhi = objKhoaHoc.getMienPhi();
		hocPhi = objKhoaHoc.getHocPhi();
		moTa = objKhoaHoc.getMoTa();
		
		chuDeId = objKhoaHoc.getChuDeId();
		ChuDe objChuDe = chuDeDao.layChiTietTheoId(chuDeId);
		tenChuDe = objChuDe.getTenChuDe();
		capDoId = objKhoaHoc.getCapDoId();
		CapDo objCapDo = capDoDao.layChiTietTheoId(capDoId);
		tenCapDo = objCapDo.getTenCapDo();
		giangVienId = objKhoaHoc.getGiangVienId();
		GiangVien objGiangVien = giangVienDao.layChiTietTheoId(giangVienId);
		tenGiangVien = objGiangVien.getTenGiangVien();
		
		StrHoatDong = "Xoa doi tuong Khoa Hoc: " + " (Ten Khoa Hoc: " + tenKhoaHoc + "), ( Ngay Xuat Ban: "
				+ ngayXuatBan+"), (Ngay Cap Nhat: "+ ngayCapNhat  + "), (Ngay Dang: " + ngayDang + "), (Da Duyet: " + daDuyet 
				+"), (Mien Phi: " + mienPhi + "), (Hoc Phi: " + hocPhi +"), (Mo Ta: " + moTa + "), (Chu De: " + tenChuDe 
				+ "), (Cap Do: " + tenCapDo + "), (Giang Vien: " + tenGiangVien +")";
		comm(StrHoatDong);
		
		khoaHocDao.xoa(ma);
		return SUCCESS;	
	}
	

	public String timKiemKhoaHoc() {
		lstChuDe = chuDeDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstGiangVien = giangVienDao.layDanhSach();

		lstKhoaHoc = khoaHocDao.timKiemKhoaHoc(tuKhoa, maChuDeTimKiem, maCapDoTimKiem, maGiangVienTimKiem);

		return SUCCESS;
	}

	
	/**
	 *   Duyet hang loat
	 */
	public String duyetKhoaHoc() {
		
		objKhoaHoc = khoaHocDao.layChiTietTheoId(id);
		
		objKhoaHoc.setDaDuyet(true);
		khoaHocDao.capNhat(objKhoaHoc);
		
		return SUCCESS;
	}
	
	/**
	 *  Bo Duyet hang loat
	 */
	public String boDuyetKhoaHoc() {
		
		objKhoaHoc = khoaHocDao.layChiTietTheoId(id);
		
		objKhoaHoc.setDaDuyet(false);
		khoaHocDao.capNhat(objKhoaHoc);
		
		return SUCCESS;
	}
	

	/**
	 *  Show thong tin khoa hoc
	 * @return
	 */
	public String layChiTietThongTinKhoaHoc() {
		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(id);
			
		String json = new Gson().toJson(objKhoaHoc);

		setKhoaHoc(json);

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
