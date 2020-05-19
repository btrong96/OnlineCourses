package vn.com.stanford.je1019.onlinecourses.action_theme;

import java.sql.Date;
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
import vn.com.stanford.je1019.onlinecourses.entry.NhanXet;
import vn.com.stanford.je1019.onlinecourses.model.BaiGiangDAO;
import vn.com.stanford.je1019.onlinecourses.model.CapDoDAO;
import vn.com.stanford.je1019.onlinecourses.model.ChuDeDAO;
import vn.com.stanford.je1019.onlinecourses.model.KhoaHocDAO;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhanXetDAO;

public class NhanXetAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9169442208742197621L;

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

	private String noiDung;
	private Integer nguoiDungId;
	private Integer baiGiangId;
	private Date thoiGianTao;
	private String tenNguoiDung;
	private String tenBaiGiang;
	private NguoiDung objNguoiDung;
	private BaiGiang objBaiGiang;
	
	private String taiKhoanUser;
	private String matKhauUser;

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

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Integer getNguoiDungId() {
		return nguoiDungId;
	}

	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}

	public Integer getBaiGiangId() {
		return baiGiangId;
	}

	public void setBaiGiangId(Integer baiGiangId) {
		this.baiGiangId = baiGiangId;
	}

	
	public NhanXetDAO getNhanXetDao() {
		return nhanXetDao;
	}

	public void setNhanXetDao(NhanXetDAO nhanXetDao) {
		this.nhanXetDao = nhanXetDao;
	}

	public Date getThoiGianTao() {
		return thoiGianTao;
	}

	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
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

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public NguoiDung getObjNguoiDung() {
		return objNguoiDung;
	}

	public void setObjNguoiDung(NguoiDung objNguoiDung) {
		this.objNguoiDung = objNguoiDung;
	}

	public String getTenBaiGiang() {
		return tenBaiGiang;
	}

	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}

	public BaiGiang getObjBaiGiang() {
		return objBaiGiang;
	}

	public void setObjBaiGiang(BaiGiang objBaiGiang) {
		this.objBaiGiang = objBaiGiang;
	}

	public List<NhanXet> getLstNhanXet() {
		return lstNhanXet;
	}

	public void setLstNhanXet(List<NhanXet> lstNhanXet) {
		this.lstNhanXet = lstNhanXet;
	}

	@Override
	public String execute() throws Exception {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
		lstBaiGiang = baiGiangDao.layDanhSach();
		lstNhanXet = nhanXetDao.layDanhSach();

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub     
		
		this.session = session;

	}

	public String themNhanXetTiles() {
		lstChuDe = chuDeDao.layDanhSach();
		lstLoai = loaiDao.layDanhSach();
		lstCapDo = capDoDao.layDanhSach();
		lstKhoaHoc = khoaHocDao.layDanhSach();
//		lstBaiGiang = baiGiangDao.layDanhSach();
		
		
       /**
        * User		
        */
		taiKhoanUser = (String) session.get("username");
		matKhauUser = (String) session.get("password");
		lstNguoiDung = nguoiDungDao.timKiemNguoiDungLogin(taiKhoanUser, matKhauUser);
		
		for (NguoiDung nd : lstNguoiDung) {
			nguoiDungId = nd.getId();
		}
	    objNguoiDung = nguoiDungDao.layChiTietTheoId(nguoiDungId);
		tenNguoiDung = objNguoiDung.getTaiKhoan();
		
		
		/**
		 * baigiang
		 */
		objBaiGiang = baiGiangDao.layChiTietTheoId(baiGiangId);
		tenBaiGiang = objBaiGiang.getTenBaiGiang();
				
		lstNhanXet = nhanXetDao.timKiemNhanXet(baiGiangId, null);
		/**
		 * Them NhanXet
		 */
		NhanXet objNhanXet = new NhanXet();
		objNhanXet.setNoiDung(noiDung);
		objNhanXet.setBaiGiangId(baiGiangId);
		objNhanXet.setTenBaiGiang(tenBaiGiang);
		objNhanXet.setNguoiDungId(nguoiDungId);
		objNhanXet.setTenNguoiDung(tenNguoiDung);
		objNhanXet.setThoiGianTao(thoiGianTao);
		
		System.out.println("ALO: " + nguoiDungId + noiDung + baiGiangId);
		
		nhanXetDao.themMoi(objNhanXet);
		
		return SUCCESS;
	}

}
