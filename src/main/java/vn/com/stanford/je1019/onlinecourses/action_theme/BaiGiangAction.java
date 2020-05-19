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
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDung_KhoaHocDAO;

public class BaiGiangAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7412436008846854427L;
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
	private List<BaiGiang> lstBaiGiangMienPhi;
	private List<BaiGiang> lstBaiGiangCoPhi;

	private Map<String, Object> session;
	private String all;

	/**
	 * Lay khoa hoc da dang ky cua nguoi dung (khoa hoc Nguoi dung da Mua)
	 */
	@Autowired
	NguoiDungDAO nguoiDungDao;

	@Autowired
	NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao;

	private List<NguoiDung> lstNguoiDung;
	private List<NguoiDung_KhoaHoc> lstNguoiDungKhoaHoc;
	private Boolean mienPhi;
	private Integer maKhoaHocDangKy;
	private List<BaiGiang> lstBGtheoKHcoPhiCoDANGKY;

	ArrayList<BaiGiang> lstBGtheoKHcoPhiCoDANGKYFULL = new ArrayList<BaiGiang>(); // Phai la arrayList Moi Add dc

	private Integer nguoiDungId;
	private String daDangKy;
	private String taiKhoanUser;
	private String matKhauUser;

	private Integer maKH;

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

	public BaiGiangDAO getBaiGiangDao() {
		return baiGiangDao;
	}

	public void setBaiGiangDao(BaiGiangDAO baiGiangDao) {
		this.baiGiangDao = baiGiangDao;
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

	public List<BaiGiang> getLstBaiGiangMienPhi() {
		return lstBaiGiangMienPhi;
	}

	public void setLstBaiGiangMienPhi(List<BaiGiang> lstBaiGiangMienPhi) {
		this.lstBaiGiangMienPhi = lstBaiGiangMienPhi;
	}

	public List<BaiGiang> getLstBaiGiangCoPhi() {
		return lstBaiGiangCoPhi;
	}

	public void setLstBaiGiangCoPhi(List<BaiGiang> lstBaiGiangCoPhi) {
		this.lstBaiGiangCoPhi = lstBaiGiangCoPhi;
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

	public Boolean getMienPhi() {
		return mienPhi;
	}

	public void setMienPhi(Boolean mienPhi) {
		this.mienPhi = mienPhi;
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

	public Integer getMaKH() {
		return maKH;
	}

	public void setMaKH(Integer maKH) {
		this.maKH = maKH;
	}

	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

	public NguoiDung_KhoaHocDAO getNguoiDungKhoaHocDao() {
		return nguoiDungKhoaHocDao;
	}

	public void setNguoiDungKhoaHocDao(NguoiDung_KhoaHocDAO nguoiDungKhoaHocDao) {
		this.nguoiDungKhoaHocDao = nguoiDungKhoaHocDao;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
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

	public Integer getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
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

	public ArrayList<BaiGiang> getLstBGtheoKHcoPhiCoDANGKYFULL() {
		return lstBGtheoKHcoPhiCoDANGKYFULL;
	}

	public void setLstBGtheoKHcoPhiCoDANGKYFULL(ArrayList<BaiGiang> lstBGtheoKHcoPhiCoDANGKYFULL) {
		this.lstBGtheoKHcoPhiCoDANGKYFULL = lstBGtheoKHcoPhiCoDANGKYFULL;
	}

	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.timKiemKhoaHocDaDuyet(true);

		lstBaiGiangMienPhi = baiGiangDao.timKiemBaiGiangDaDuyet(true, true);
		lstBaiGiangCoPhi = baiGiangDao.timKiemBaiGiangDaDuyet(true, false);

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
			 * Da Dang Nhap He Thong. Nhung Khoa Co Phi Da Dang Ky
			 */

			for (NguoiDung_KhoaHoc ndkh : lstNguoiDungKhoaHoc) {
				maKhoaHocDangKy = ndkh.getKhoaHocId(); // (Co the nhieu doi tuong objNguoiDungKhoaHoc do 1 nguoi
														// dk nhieu khoa hoc)

				System.out.println("ChecK nhung maKhoaHocDangKy Lan 1 : " + maKhoaHocDangKy);

				for (KhoaHoc kh : lstKhoaHoc) {
					maKH = kh.getId();

					if (maKhoaHocDangKy == maKH) {
						lstBGtheoKHcoPhiCoDANGKY = baiGiangDao.timKiemBaiGiangTheoKhoaHoc(maKhoaHocDangKy, true, false);

						for (BaiGiang bgDDK : lstBGtheoKHcoPhiCoDANGKY) {
							lstBGtheoKHcoPhiCoDANGKYFULL.add(bgDDK);

							System.out.println("Vao dc den day Nua Co 1111: " + maKH);
						}
						daDangKy = "daDangKy";
						session.put("daDangKy", daDangKy);
						break;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Chua lay dc danh sach NguoiDung_KhoaHoc");
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; // CHU Y CHO NAY

	}
}
