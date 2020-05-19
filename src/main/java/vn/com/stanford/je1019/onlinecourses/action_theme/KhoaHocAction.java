package vn.com.stanford.je1019.onlinecourses.action_theme;

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
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDung_KhoaHocDAO;

public class KhoaHocAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2498454064936133345L;
	@Autowired
	LoaiDAO loaiDao;
	@Autowired
	ChuDeDAO chuDeDao;
	@Autowired
	CapDoDAO capDoDao;
	@Autowired
	KhoaHocDAO khoaHocDao;
	@Autowired
	BaiGiangDAO baiGiangDao;

	private List<Loai> lstLoai;
	private List<ChuDe> lstChuDe;
	private List<CapDo> lstCapDo;
	private List<KhoaHoc> lstKhoaHoc;
	private List<KhoaHoc> lstKhoaHocMienPhi;
	private Map<String, Object> session;
	private String all;
	private List<BaiGiang> lstBGtheoKHmienPhi;
	private List<BaiGiang> lstBGtheoKHcoPhi;
	private Integer ma;
	private String tenKhoaHoc;

	/**
	 * Lay khoa hoc da dang ky cua nguoi dung (khoa hoc Nguoi dung da Mua)
	 */
	@Autowired
	NguoiDungDAO nguoiDungDao;

	@Autowired
	NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao;

	private List<NguoiDung> lstNguoiDung;
	private List<NguoiDung_KhoaHoc> lstNguoiDungKhoaHoc;
	private List<BaiGiang> lstBGtheoKHcoPhiCoDANGKY;
	private String taiKhoanUser;
	private String matKhauUser;
	private Integer nguoiDungId;
	private Integer maKhoaHocDangKy;
	private String daDangKy;
	private String chuaDangKy;

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

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<BaiGiang> getLstBGtheoKHmienPhi() {
		return lstBGtheoKHmienPhi;
	}

	public void setLstBGtheoKHmienPhi(List<BaiGiang> lstBGtheoKHmienPhi) {
		this.lstBGtheoKHmienPhi = lstBGtheoKHmienPhi;
	}

	public List<BaiGiang> getLstBGtheoKHcoPhi() {
		return lstBGtheoKHcoPhi;
	}

	public void setLstBGtheoKHcoPhi(List<BaiGiang> lstBGtheoKHcoPhi) {
		this.lstBGtheoKHcoPhi = lstBGtheoKHcoPhi;
	}

	public BaiGiangDAO getBaiGiangDao() {
		return baiGiangDao;
	}

	public void setBaiGiangDao(BaiGiangDAO baiGiangDao) {
		this.baiGiangDao = baiGiangDao;
	}

	public Integer getMa() {
		return ma;
	}

	public void setMa(Integer ma) {
		this.ma = ma;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

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

	public NguoiDung_KhoaHocDAO getNguoiDungKhoaHocDao() {
		return nguoiDungKhoaHocDao;
	}

	public void setNguoiDungKhoaHocDao(NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao) {
		this.nguoiDungKhoaHocDao = nguoiDungKhoaHocDao;
	}

	public List<NguoiDung_KhoaHoc> getLstNguoiDungKhoaHoc() {
		return lstNguoiDungKhoaHoc;
	}

	public void setLstNguoiDungKhoaHoc(List<NguoiDung_KhoaHoc> lstNguoiDungKhoaHoc) {
		this.lstNguoiDungKhoaHoc = lstNguoiDungKhoaHoc;
	}

	public Integer getMaKhoaHocDangKy() {
		return maKhoaHocDangKy;
	}

	public void setMaKhoaHocDangKy(Integer maKhoaHocDangKy) {
		this.maKhoaHocDangKy = maKhoaHocDangKy;
	}

	public List<BaiGiang> getLstBGtheoKHcoPhiCoDANGKY() {
		return lstBGtheoKHcoPhiCoDANGKY;
	}

	public void setLstBGtheoKHcoPhiCoDANGKY(List<BaiGiang> lstBGtheoKHcoPhiCoDANGKY) {
		this.lstBGtheoKHcoPhiCoDANGKY = lstBGtheoKHcoPhiCoDANGKY;
	}

	public String getDaDangKy() {
		return daDangKy;
	}

	public void setDaDangKy(String daDangKy) {
		this.daDangKy = daDangKy;
	}

	public String getChuaDangKy() {
		return chuaDangKy;
	}

	public void setChuaDangKy(String chuaDangKy) {
		this.chuaDangKy = chuaDangKy;
	}

	public List<KhoaHoc> getLstKhoaHocMienPhi() {
		return lstKhoaHocMienPhi;
	}

	public void setLstKhoaHocMienPhi(List<KhoaHoc> lstKhoaHocMienPhi) {
		this.lstKhoaHocMienPhi = lstKhoaHocMienPhi;
	}

	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);

		all = "all";
		session.put("khoaHoc", all);

		return SUCCESS;
	}

	public String layBaiGiangTheoKhoaHoc() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);

		/**
		 * Mien Phi
		 */
		lstBGtheoKHmienPhi = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(ma, true, true);

		/**
		 * Co Phi
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

		System.out.println("ChecK lay nguoiDungId : " + nguoiDungId);

		try {

			/**
			 * Chua Dang Nhap He Thong
			 */
			if (nguoiDungId == null) {
				System.out.println("ChecK nhung ma Khoa Hoc Chua DK (Chua Dang Nhap) : " + ma);
				lstBGtheoKHcoPhi = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(ma, true, false);
				chuaDangKy = "chuaDangKy";
				session.put("chuaDangKy", chuaDangKy);
			}

			if (nguoiDungId != null) { // Phai Co Cai Check nay
				lstNguoiDungKhoaHoc = nguoiDungKhoaHocDao.timKiemNguoiDung_KhoaHocTheoNguoiDungId(nguoiDungId);
			}

			/**
			 * Da Dang Nhap He Thong. Nhung chua mua khoaHoc nao, nen nguoiDungId ko co
			 * trong table NguoiDung_KhoaHoc
			 * 
			 * Hay lstNguoiDungKhoaHoc empty
			 */

			if (lstNguoiDungKhoaHoc == null || lstNguoiDungKhoaHoc.isEmpty()) {
				System.out.println("ChecK da dang nhap nhung chua mua khoa hoc nao : " + ma);
				lstBGtheoKHcoPhi = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(ma, true, false);
				chuaDangKy = "chuaDangKy";
				session.put("chuaDangKy", chuaDangKy);
			}

			/**
			 * Da Dang Nhap He Thong. Co DK it nhat 1 Khoa, hay lstNguoiDungKhoaHoc not
			 * empty
			 */
			try {

				/**
				 * Da Dang Nhap He Thong. Nhung Khoa Co Phi Da Dang Ky
				 */

				for (NguoiDung_KhoaHoc ndkh : lstNguoiDungKhoaHoc) {
					maKhoaHocDangKy = ndkh.getKhoaHocId(); // (Co the nhieu doi tuong objNguoiDungKhoaHoc do 1 nguoi
															// dk nhieu khoa hoc)

					System.out.println("ChecK nhung maKhoaHocDangKy Lan 1 : " + maKhoaHocDangKy);

					if (maKhoaHocDangKy == ma) {
						lstBGtheoKHcoPhiCoDANGKY = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(maKhoaHocDangKy, true, false);
						daDangKy = "daDangKy";
						session.put("daDangKy", daDangKy);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {

				/**
				 * Da Dang Nhap He Thong. Nhung Khoa Co Phi Chua Dang Ky
				 */
				for (NguoiDung_KhoaHoc ndkh : lstNguoiDungKhoaHoc) {
					maKhoaHocDangKy = ndkh.getKhoaHocId(); // (Co the nhieu doi tuong objNguoiDungKhoaHoc do 1 nguoi
															// dk nhieu khoa hoc)

					System.out.println("ChecK nhung maKhoaHocDangKy Lan 2: " + maKhoaHocDangKy);

					for (NguoiDung_KhoaHoc ndk : lstNguoiDungKhoaHoc) {
						maKhoaHocDangKy = ndk.getKhoaHocId(); // Loai bo nhung khoaHoc ma NguoiDung da Dk 
																
						System.out.println("ChecK nhung maKhoaHocDangKy Lan 3: " + maKhoaHocDangKy);

						if (maKhoaHocDangKy == ma) {
							break;
						}
					}

					if (maKhoaHocDangKy != ma) {
						System.out.println("ChecK nhung ma Khoa Hoc Chua DK : " + ma);
						lstBGtheoKHcoPhi = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(ma, true, false);
						chuaDangKy = "chuaDangKy";
						session.put("chuaDangKy", chuaDangKy);
					}

				}

			}
		} catch (Exception e) {
			System.out.println("Loi Game");

		}

		KhoaHoc objKhoaHoc = khoaHocDao.layChiTietTheoId(ma); // chet cho nay khi dat authorizationinterceptor moi la
		tenKhoaHoc = objKhoaHoc.getTenKhoaHoc();

		return SUCCESS;
	}
	
	
	
	public String khoahocmienphi() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);
		
		
		lstKhoaHocMienPhi = khoaHocDao.timKiemKhoaHocMienPhi(true);
		
		return SUCCESS;
	}

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; // CHU Y CHO NAY

	}
}
