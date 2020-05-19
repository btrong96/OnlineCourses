package vn.com.stanford.je1019.onlinecourses.action_theme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.BaiGiang;
import vn.com.stanford.je1019.onlinecourses.entry.CapDo;
import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;
import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.Loai;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung_KhoaHoc;
import vn.com.stanford.je1019.onlinecourses.entry.NhanXet;
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDung_KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhanXetDAO;

public class BaiGiangDetailAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 679790319052894928L;
	@Autowired
	BaiGiangDAO baiGiangDao;
	@Autowired
	LoaiDAO loaiDao;
	@Autowired
	ChuDeDAO chuDeDao;
	@Autowired
	CapDoDAO capDoDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	@Autowired
	NguoiDungDAO nguoiDungDao;

	@Autowired
	NhanXetDAO nhanXetDao;

	private List<Loai> lstLoai;
	private List<ChuDe> lstChuDe;
	private List<CapDo> lstCapDo;
	private List<KhoaHoc> lstKhoaHoc;
	private List<BaiGiang> lstBaiGiang;
	private List<NguoiDung> lstNguoiDung;
	private List<NhanXet> lstNhanXet;
	private Map<String, Object> session;
	private Integer ma;
	private BaiGiang objBaiGiang;
	private String nameCode;
	private Integer idBaiGiang;
	private String tenBaiGiang;
	private String moTa;

	/**
	 * Show nhung bai giang mien phi, Va nhung bai giang co phi co dk
	 */

	@Autowired
	NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao;

	private List<BaiGiang> lstBaiGiangMienPhi;
	private List<NguoiDung_KhoaHoc> lstNguoiDungKhoaHoc;
	private String taiKhoanUser;
	private String matKhauUser;
	private Integer nguoiDungId;
	private Integer maKhoaHocDangKy;
	private Integer maKH;
	private Integer khoaHocId;
	private List<BaiGiang> lstBGtheoKHcoPhiCoDANGKY;

	ArrayList<BaiGiang> lstBGtheoKHcoPhiCoDANGKYFULL = new ArrayList<BaiGiang>(); // Phai la arrayList Moi Add dc

	public BaiGiangDAO getBaiGiangDao() {
		return baiGiangDao;
	}

	public void setBaiGiangDao(BaiGiangDAO baiGiangDao) {
		this.baiGiangDao = baiGiangDao;
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

	public CapDoDAO getCapDoDao() {
		return capDoDao;
	}

	public void setCapDoDao(CapDoDAO capDoDao) {
		this.capDoDao = capDoDao;
	}

	public KhoaHocDAO getKhoaHocDao() {
		return khoaHocDao;
	}

	public void setKhoaHocDao(KhoaHocDAO khoaHocDao) {
		this.khoaHocDao = khoaHocDao;
	}

	public NguoiDung_KhoaHocDAO getNguoiDungKhoaHocDao() {
		return nguoiDungKhoaHocDao;
	}

	public void setNguoiDungKhoaHocDao(NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao) {
		this.nguoiDungKhoaHocDao = nguoiDungKhoaHocDao;
	}

	public List<BaiGiang> getLstBaiGiangMienPhi() {
		return lstBaiGiangMienPhi;
	}

	public void setLstBaiGiangMienPhi(List<BaiGiang> lstBaiGiangMienPhi) {
		this.lstBaiGiangMienPhi = lstBaiGiangMienPhi;
	}

	public List<NguoiDung_KhoaHoc> getLstNguoiDungKhoaHoc() {
		return lstNguoiDungKhoaHoc;
	}

	public void setLstNguoiDungKhoaHoc(List<NguoiDung_KhoaHoc> lstNguoiDungKhoaHoc) {
		this.lstNguoiDungKhoaHoc = lstNguoiDungKhoaHoc;
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

	public Integer getMaKhoaHocDangKy() {
		return maKhoaHocDangKy;
	}

	public void setMaKhoaHocDangKy(Integer maKhoaHocDangKy) {
		this.maKhoaHocDangKy = maKhoaHocDangKy;
	}

	public Integer getMaKH() {
		return maKH;
	}

	public void setMaKH(Integer maKH) {
		this.maKH = maKH;
	}

	public List<BaiGiang> getLstBGtheoKHcoPhiCoDANGKY() {
		return lstBGtheoKHcoPhiCoDANGKY;
	}

	public void setLstBGtheoKHcoPhiCoDANGKY(List<BaiGiang> lstBGtheoKHcoPhiCoDANGKY) {
		this.lstBGtheoKHcoPhiCoDANGKY = lstBGtheoKHcoPhiCoDANGKY;
	}

	public ArrayList<BaiGiang> getLstBGtheoKHcoPhiCoDANGKYFULL() {
		return lstBGtheoKHcoPhiCoDANGKYFULL;
	}

	public void setLstBGtheoKHcoPhiCoDANGKYFULL(ArrayList<BaiGiang> lstBGtheoKHcoPhiCoDANGKYFULL) {
		this.lstBGtheoKHcoPhiCoDANGKYFULL = lstBGtheoKHcoPhiCoDANGKYFULL;
	}

	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

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

	public List<CapDo> getLstCapDo() {
		return lstCapDo;
	}

	public void setLstCapDo(List<CapDo> lstCapDo) {
		this.lstCapDo = lstCapDo;
	}

	public List<KhoaHoc> getLstKhoaHoc() {
		return lstKhoaHoc;
	}

	public void setLstKhoaHoc(List<KhoaHoc> lstKhoaHoc) {
		this.lstKhoaHoc = lstKhoaHoc;
	}

	public List<BaiGiang> getLstBaiGiang() {
		return lstBaiGiang;
	}

	public void setLstBaiGiang(List<BaiGiang> lstBaiGiang) {
		this.lstBaiGiang = lstBaiGiang;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
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

	public BaiGiang getObjBaiGiang() {
		return objBaiGiang;
	}

	public void setObjBaiGiang(BaiGiang objBaiGiang) {
		this.objBaiGiang = objBaiGiang;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public Integer getIdBaiGiang() {
		return idBaiGiang;
	}

	public void setIdBaiGiang(Integer idBaiGiang) {
		this.idBaiGiang = idBaiGiang;
	}

	public List<NhanXet> getLstNhanXet() {
		return lstNhanXet;
	}

	public void setLstNhanXet(List<NhanXet> lstNhanXet) {
		this.lstNhanXet = lstNhanXet;
	}

	public NhanXetDAO getNhanXetDao() {
		return nhanXetDao;
	}

	public void setNhanXetDao(NhanXetDAO nhanXetDao) {
		this.nhanXetDao = nhanXetDao;
	}

	public String getTenBaiGiang() {
		return tenBaiGiang;
	}

	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();

		/**
		 * Bai giang dang phat
		 */
		objBaiGiang = baiGiangDao.layChiTietTheoId(ma);
		nameCode = objBaiGiang.getNameCode();
		idBaiGiang = objBaiGiang.getId(); // Lay Id bai giang de nhanXet co idBaiGiang
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
		moTa = objBaiGiang.getMoTa();

		lstNhanXet = nhanXetDao.timKiemNhanXet(idBaiGiang, null);

		/**
		 * Show full Bai giang thuoc cung Khoa Hoc voi Bai giang dang phat ( 2 Truong
		 * Hop: Mien Phi & Co Phi )
		 * 
		 */

		/**
		 * Truong Hop 1: Mien Phi
		 */
		khoaHocId = objBaiGiang.getKhoaHocId();
		lstBaiGiangMienPhi = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(khoaHocId, true, true);

		/**
		 * Truong Hop 2: Co Phi & Da Mua
		 */
		// Lay nguoiDungId
		if (session != null && !session.isEmpty()) {
			taiKhoanUser = (String) session.get("username");
			matKhauUser = (String) session.get("password");
			lstNguoiDung = nguoiDungDao.timKiemNguoiDungLogin(taiKhoanUser, matKhauUser);
			for (NguoiDung nd : lstNguoiDung) {
				nguoiDungId = nd.getId();
			}
		}

		if (nguoiDungId != null) { // Phai Co Cai Check nay
			lstNguoiDungKhoaHoc = nguoiDungKhoaHocDao.timKiemNguoiDung_KhoaHocTheoNguoiDungId(nguoiDungId);
		}

		try {

			/**
			 * Da Dang Nhap He Thong. Nhung BaiGiang Thuoc cung KhoaHoc voi Bai Giang dang
			 * phat Co Phi & Da Dang Ky
			 */

			for (NguoiDung_KhoaHoc ndkh : lstNguoiDungKhoaHoc) {
				maKhoaHocDangKy = ndkh.getKhoaHocId(); // (Co the nhieu doi tuong objNguoiDungKhoaHoc do 1 nguoi
														// dk nhieu khoa hoc)

				System.out.println("ChecK nhung maKhoaHocDangKy Lan 1 : " + maKhoaHocDangKy);

				if (maKhoaHocDangKy == khoaHocId) {
					lstBGtheoKHcoPhiCoDANGKY = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(khoaHocId, true, false);
				}
			}
		} catch (Exception e) {
			System.out.println("Chua lay dc danh sach NguoiDung_KhoaHoc");
		}

//		/**
//		 * Show DS bai giang mien phi
//		 */
//		lstBaiGiangMienPhi = baiGiangDao.timKiemBaiGiangDaDuyet(true, true);
//
//		/**
//		 * Show DS bai giang co phi Da DK (full)
//		 */
//		// Lay nguoiDungId
//		if (session != null && !session.isEmpty()) {
//			taiKhoanUser = (String) session.get("username");
//			matKhauUser = (String) session.get("password");
//			lstNguoiDung = nguoiDungDao.timKiemNguoiDungLogin(taiKhoanUser, matKhauUser);
//			for (NguoiDung nd : lstNguoiDung) {
//				nguoiDungId = nd.getId();
//			}
//		}
//
//		if (nguoiDungId != null) { // Phai Co Cai Check nay
//			lstNguoiDungKhoaHoc = nguoiDungKhoaHocDao.timKiemNguoiDung_KhoaHocTheoNguoiDungId(nguoiDungId);
//		}
//		try {
//
//			/**
//			 * Da Dang Nhap He Thong. Nhung Khoa Co Phi Da Dang Ky
//			 */
//
//			for (NguoiDung_KhoaHoc ndkh : lstNguoiDungKhoaHoc) {
//				maKhoaHocDangKy = ndkh.getKhoaHocId(); // (Co the nhieu doi tuong objNguoiDungKhoaHoc do 1 nguoi
//														// dk nhieu khoa hoc)
//
//				System.out.println("ChecK nhung maKhoaHocDangKy Lan 1 : " + maKhoaHocDangKy);
//
//				for (KhoaHoc kh : lstKhoaHoc) {
//					maKH = kh.getId();
//
//					if (maKhoaHocDangKy == maKH) {
//						lstBGtheoKHcoPhiCoDANGKY = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(maKhoaHocDangKy, true, false);
//
//						for (BaiGiang bgDDK : lstBGtheoKHcoPhiCoDANGKY) {
//							lstBGtheoKHcoPhiCoDANGKYFULL.add(bgDDK);
//
//							System.out.println("Vao dc den day Nua Co 1111: " + maKH);
//						}
//
//						break;
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			System.out.println("Chua lay dc danh sach NguoiDung_KhoaHoc");
//		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
