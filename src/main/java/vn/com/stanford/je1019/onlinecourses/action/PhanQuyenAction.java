package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.ChucNang;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.entry.PhanQuyen;
import vn.com.stanford.je1019.onlinecourses.entry.VaiTro;
import vn.com.stanford.je1019.onlinecourses.model.ChucNangDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;
import vn.com.stanford.je1019.onlinecourses.model.PhanQuyenDAO;
import vn.com.stanford.je1019.onlinecourses.model.VaiTroDAO;

public class PhanQuyenAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8964984531238459229L;

	@Autowired
	PhanQuyenDAO phanQuyenDao;
	@Autowired
	VaiTroDAO vaiTroDao;
	@Autowired
	ChucNangDAO chucNangDao;

	private List<PhanQuyen> lstPhanQuyen;
	private List<VaiTro> lstVaiTro;
	private List<ChucNang> lstChucNang;

	private Integer id;
	private boolean danhSach;
	private boolean them;
	private boolean sua;
	private boolean xoa;
	private boolean baoCao;
	private Integer chucnang_id;
	private Integer vaitro_id;
	private Integer maVaiTroTimKiem;
	private Integer maChucNangTimKiem;

	private String tenVaiTro_1;
	private String tenVaiTro_2;
	private String tenVaiTro_3;

	private String phanQuyen;

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

	private String tenVaiTro;
	private String tenChucNang;
	private String tenVaiTro_Old;
	private String tenChucNang_Old;
	private boolean danhSach_Old;
	private boolean them_Old;
	private boolean sua_Old;
	private boolean xoa_Old;
	private boolean baoCao_Old;

	public PhanQuyenDAO getPhanQuyenDao() {
		return phanQuyenDao;
	}

	public void setPhanQuyenDao(PhanQuyenDAO phanQuyenDao) {
		this.phanQuyenDao = phanQuyenDao;
	}

	public List<PhanQuyen> getLstPhanQuyen() {
		return lstPhanQuyen;
	}

	public void setLstPhanQuyen(List<PhanQuyen> lstPhanQuyen) {
		this.lstPhanQuyen = lstPhanQuyen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isDanhSach() {
		return danhSach;
	}

	public void setDanhSach(boolean danhSach) {
		this.danhSach = danhSach;
	}

	public boolean isThem() {
		return them;
	}

	public void setThem(boolean them) {
		this.them = them;
	}

	public boolean isSua() {
		return sua;
	}

	public void setSua(boolean sua) {
		this.sua = sua;
	}

	public boolean isXoa() {
		return xoa;
	}

	public void setXoa(boolean xoa) {
		this.xoa = xoa;
	}

	public boolean isBaoCao() {
		return baoCao;
	}

	public void setBaoCao(boolean baoCao) {
		this.baoCao = baoCao;
	}

	public Integer getChucnang_id() {
		return chucnang_id;
	}

	public void setChucnang_id(Integer chucnang_id) {
		this.chucnang_id = chucnang_id;
	}

	public Integer getVaitro_id() {
		return vaitro_id;
	}

	public void setVaitro_id(Integer vaitro_id) {
		this.vaitro_id = vaitro_id;
	}

	public String getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public VaiTroDAO getVaiTroDao() {
		return vaiTroDao;
	}

	public void setVaiTroDao(VaiTroDAO vaiTroDao) {
		this.vaiTroDao = vaiTroDao;
	}

	public String getTenVaiTro_1() {
		return tenVaiTro_1;
	}

	public void setTenVaiTro_1(String tenVaiTro_1) {
		this.tenVaiTro_1 = tenVaiTro_1;
	}

	public String getTenVaiTro_2() {
		return tenVaiTro_2;
	}

	public void setTenVaiTro_2(String tenVaiTro_2) {
		this.tenVaiTro_2 = tenVaiTro_2;
	}

	public String getTenVaiTro_3() {
		return tenVaiTro_3;
	}

	public void setTenVaiTro_3(String tenVaiTro_3) {
		this.tenVaiTro_3 = tenVaiTro_3;
	}

	public ChucNangDAO getChucNangDao() {
		return chucNangDao;
	}

	public void setChucNangDao(ChucNangDAO chucNangDao) {
		this.chucNangDao = chucNangDao;
	}

	public List<VaiTro> getLstVaiTro() {
		return lstVaiTro;
	}

	public void setLstVaiTro(List<VaiTro> lstVaiTro) {
		this.lstVaiTro = lstVaiTro;
	}

	public List<ChucNang> getLstChucNang() {
		return lstChucNang;
	}

	public void setLstChucNang(List<ChucNang> lstChucNang) {
		this.lstChucNang = lstChucNang;
	}

	public Integer getMaVaiTroTimKiem() {
		return maVaiTroTimKiem;
	}

	public void setMaVaiTroTimKiem(Integer maVaiTroTimKiem) {
		this.maVaiTroTimKiem = maVaiTroTimKiem;
	}

	public Integer getMaChucNangTimKiem() {
		return maChucNangTimKiem;
	}

	public void setMaChucNangTimKiem(Integer maChucNangTimKiem) {
		this.maChucNangTimKiem = maChucNangTimKiem;
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

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public String getTenChucNang() {
		return tenChucNang;
	}

	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}

	public String getTenVaiTro_Old() {
		return tenVaiTro_Old;
	}

	public void setTenVaiTro_Old(String tenVaiTro_Old) {
		this.tenVaiTro_Old = tenVaiTro_Old;
	}

	public String getTenChucNang_Old() {
		return tenChucNang_Old;
	}

	public void setTenChucNang_Old(String tenChucNang_Old) {
		this.tenChucNang_Old = tenChucNang_Old;
	}

	public boolean isDanhSach_Old() {
		return danhSach_Old;
	}

	public void setDanhSach_Old(boolean danhSach_Old) {
		this.danhSach_Old = danhSach_Old;
	}

	public boolean isThem_Old() {
		return them_Old;
	}

	public void setThem_Old(boolean them_Old) {
		this.them_Old = them_Old;
	}

	public boolean isSua_Old() {
		return sua_Old;
	}

	public void setSua_Old(boolean sua_Old) {
		this.sua_Old = sua_Old;
	}

	public boolean isXoa_Old() {
		return xoa_Old;
	}

	public void setXoa_Old(boolean xoa_Old) {
		this.xoa_Old = xoa_Old;
	}

	public boolean isBaoCao_Old() {
		return baoCao_Old;
	}

	public void setBaoCao_Old(boolean baoCao_Old) {
		this.baoCao_Old = baoCao_Old;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		lstPhanQuyen = phanQuyenDao.layDanhSach();
		lstVaiTro = vaiTroDao.layDanhSach();
		lstChucNang = chucNangDao.layDanhSach();

//		Map<String, Object> session = ActionContext.getContext().getSession();
//		
//		for(PhanQuyen pq: lstPhanQuyen) {
//			vaitro_id = pq.getVaitro_id();
//		
//			
//				if(vaitro_id==1) {							
//				VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
//				tenVaiTro_1 = objVaiTro.getTenVaiTro();
//				System.out.println("TEN VAI TRO: " + tenVaiTro_1);	
//				
//				session.put("admin", 1);
//				continue;
//				}
//					
//				if(vaitro_id==2) {							
//					VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
//					tenVaiTro_2 = objVaiTro.getTenVaiTro();
//					System.out.println("TEN VAI TRO: " + tenVaiTro_2);	
//					session.put("hocVien", 2);
//					continue;
//					}
//					
//				if(vaitro_id==3) {							
//				VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
//				tenVaiTro_3 = objVaiTro.getTenVaiTro();
//				System.out.println("TEN VAI TRO: " + tenVaiTro_3);	
//				session.put("hocVien", 3);
//				continue;
//				}
//			
//		}

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
		objNhatKy.setChucNang("Quan ly Phan Quyen");
		objNhatKy.setHoatDong(StrHoatDong);
		nhatKyDao.themMoi(objNhatKy);
	}

	public String themPhanQuyen() {
		PhanQuyen objPhanQuyen = new PhanQuyen();
		objPhanQuyen.setVaitro_id(vaitro_id);
		objPhanQuyen.setChucnang_id(chucnang_id);
		objPhanQuyen.setDanhSach(danhSach);
		objPhanQuyen.setThem(them);
		objPhanQuyen.setSua(sua);
		objPhanQuyen.setXoa(xoa);
		objPhanQuyen.setBaoCao(baoCao);

		phanQuyenDao.themMoi(objPhanQuyen);

		/**
		 * Nhat Ky
		 */
		
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
		tenVaiTro = objVaiTro.getTenVaiTro();
		ChucNang objChucNang = chucNangDao.layChiTietTheoId(chucnang_id);
		tenChucNang = objChucNang.getTenChucNang();
		
		StrHoatDong = "Them doi tuong Phan Quyen: " + " (Ten Vai Tro: " + tenVaiTro + "), ( Ten Chuc Nang: " + tenChucNang 
			+"), (Danh Sach: " 	+ danhSach + "), (Them: " + them + "), (Sua: " + sua + "), (Xoa: " + xoa + "), (Bao Cao: " + baoCao +")";
		comm(StrHoatDong);
		
		return SUCCESS;
	}

	public String layThongTinChiTietPhanQuyen() {
		PhanQuyen objPhanQuyen = phanQuyenDao.layChiTietTheoId(id);

		String json = new Gson().toJson(objPhanQuyen);
		System.out.println("jsonGiangVien" + json);
		setPhanQuyen(json);
		
		/**
		 * Nhat Ky
		 */
		vaitro_id = objPhanQuyen.getVaitro_id();
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
		tenVaiTro_Old = objVaiTro.getTenVaiTro();
		session.put("tenVaiTro_Cu", tenVaiTro_Old);
		
		chucnang_id =objPhanQuyen.getChucnang_id();
		ChucNang objChucNang = chucNangDao.layChiTietTheoId(chucnang_id);
		tenChucNang_Old = objChucNang.getTenChucNang();
		session.put("tenChucNang_Cu", tenChucNang_Old);
		
		danhSach_Old = objPhanQuyen.getDanhSach();
		session.put("danhSach_Cu", danhSach_Old);
		them_Old = objPhanQuyen.getThem();
		session.put("them_Cu", them_Old);
		sua_Old = objPhanQuyen.getSua();
		session.put("sua_Cu", sua_Old);
		xoa_Old = objPhanQuyen.getXoa();
		session.put("xoa_Cu", xoa_Old);
		baoCao_Old = objPhanQuyen.getBaoCao();
		session.put("baoCao_Cu", baoCao_Old);
		
		return SUCCESS;
	}

	public String capNhatPhanQuyen() {
		PhanQuyen objPhanQuyen = new PhanQuyen();
		objPhanQuyen.setId(id);
		objPhanQuyen.setVaitro_id(vaitro_id);
		objPhanQuyen.setChucnang_id(chucnang_id);
		objPhanQuyen.setDanhSach(danhSach);
		objPhanQuyen.setThem(them);
		objPhanQuyen.setSua(sua);
		objPhanQuyen.setXoa(xoa);
		objPhanQuyen.setBaoCao(baoCao);

		phanQuyenDao.capNhat(objPhanQuyen);
		
		/**
		 *   Nhat Ky
		 */
		
		tenVaiTro_Old = (String) session.get("tenVaiTro_Cu");
		tenChucNang_Old = (String) session.get("tenChucNang_Cu");
		danhSach_Old = (boolean) session.get("danhSach_Cu");
		them_Old = (boolean) session.get("them_Cu");
		sua_Old = (boolean) session.get("sua_Cu");
		xoa_Old = (boolean) session.get("xoa_Cu");
		baoCao_Old = (boolean) session.get("baoCao_Cu");
		
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);		
		tenVaiTro = objVaiTro.getTenVaiTro();
		ChucNang objChucNang = chucNangDao.layChiTietTheoId(chucnang_id);
		tenChucNang = objChucNang.getTenChucNang();
		
		StrHoatDong = "Cap nhat doi tuong Phan Quyen: " +  " (Ten Vai Tro: " + tenVaiTro_Old + "), ( Ten Chuc Nang: " + tenChucNang_Old 
				+"), (Danh Sach: " 	+ danhSach_Old  + "), (Them: " + them_Old + "), (Sua: " + sua_Old + "), (Xoa: " + xoa_Old + "), (Bao Cao: " + baoCao_Old +")"
				+ " => CAP NHAT THANH " + " (Ten Vai Tro: " + tenVaiTro + "), ( Ten Chuc Nang: " + tenChucNang 
				+"), (Danh Sach: " 	+ danhSach + "), (Them: " + them + "), (Sua: " + sua + "), (Xoa: " + xoa + "), (Bao Cao: " + baoCao +")";
				
		comm(StrHoatDong);
		
		return SUCCESS;
	}

	public String xoaPhanQuyen() {
		
		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		
		PhanQuyen objPhanQuyen = phanQuyenDao.layChiTietTheoId(id);
		
		vaitro_id = objPhanQuyen.getVaitro_id();
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(vaitro_id);
		tenVaiTro = objVaiTro.getTenVaiTro();
		
		chucnang_id = objPhanQuyen.getChucnang_id();
		ChucNang objChucNang = chucNangDao.layChiTietTheoId(chucnang_id);
		tenChucNang = objChucNang.getTenChucNang();
		
		danhSach = objPhanQuyen.getDanhSach();
		them = objPhanQuyen.getThem();
		sua = objPhanQuyen.getSua();
		xoa = objPhanQuyen.getXoa();
		baoCao = objPhanQuyen.getBaoCao();
		
		StrHoatDong = "Xoa doi tuong Phan Quyen: " + " (Ten Vai Tro: " + tenVaiTro + "), ( Ten Chuc Nang: " + tenChucNang 
				+"), (Danh Sach: " 	+ danhSach + "), (Them: " + them + "), (Sua: " + sua + "), (Xoa: " + xoa + "), (Bao Cao: " + baoCao +")";
			
		comm(StrHoatDong);

		
		
		phanQuyenDao.xoa(id);
		return SUCCESS;
	}

	public String timKiemPhanQuyen() {

		lstVaiTro = vaiTroDao.layDanhSach();
		lstChucNang = chucNangDao.layDanhSach();

		lstPhanQuyen = phanQuyenDao.lstQuyenHan(maVaiTroTimKiem, maChucNangTimKiem);
		for (PhanQuyen pq : lstPhanQuyen) {
			maVaiTroTimKiem = pq.getVaitro_id();
			them = pq.getThem();
			System.out.println("TEST TIM KIEM PQ: " + maVaiTroTimKiem + them);
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
