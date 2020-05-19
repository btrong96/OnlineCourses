package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.Loai;
import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.LoaiDAO;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class LoaiAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5998207360223017865L;
		
	@Autowired
	LoaiDAO loaiDao;
	
	private List<Loai> lstLoai;
	private Integer id;
	private String tenLoai;
	private String moTa;
	private String jsonLoai;
	
	
	/**
	 *   Nhat Ky
	 */
	@Autowired
	NguoiDungDAO nguoiDungDao;
	@Autowired
	NhatKyDAO nhatKyDao;
	java.util.Date date = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
	private String taiKhoanUser;
	private String matKhauUser;
	private List<NguoiDung> lstNguoiDung;
	private Integer nguoiDungId;	
	private Map<String, Object> session;	
	private String StrHoatDong;
	
	private String tenLoai_Old; 
	private String moTa_Old;
	
	/**
	 *  Check Trung
	 * 
	 */
    private Integer idDaTonTai;
    

	public Integer getIdDaTonTai() {
		return idDaTonTai;
	}

	public void setIdDaTonTai(Integer idDaTonTai) {
		this.idDaTonTai = idDaTonTai;
	}

	public List<Loai> getLstLoai() {
		return lstLoai;
	}

	public void setLstLoai(List<Loai> lstLoai) {
		this.lstLoai = lstLoai;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getJsonLoai() {
		return jsonLoai;
	}

	public void setJsonLoai(String jsonLoai) {
		this.jsonLoai = jsonLoai;
	}
	public LoaiDAO getLoaiDao() {
		return loaiDao;
	}

	public void setLoaiDao(LoaiDAO loaiDao) {
		this.loaiDao = loaiDao;
	}
	
	public String getTenLoai_Old() {
		return tenLoai_Old;
	}

	public void setTenLoai_Old(String tenLoai_Old) {
		this.tenLoai_Old = tenLoai_Old;
	}

	public String getMoTa_Old() {
		return moTa_Old;
	}

	public void setMoTa_Old(String moTa_Old) {
		this.moTa_Old = moTa_Old;
	}

	public String getStrHoatDong() {
		return StrHoatDong;
	}

	public void setStrHoatDong(String strHoatDong) {
		StrHoatDong = strHoatDong;
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

	public Map<String, Object> getSession() {
		return session;
	}


	/**
	 * Ham lay danh sach loai
	 * 
	 */
	@Override
	public String execute() throws Exception {
		lstLoai = loaiDao.layDanhSach();
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
		objNhatKy.setChucNang("Quan ly Loai");
		objNhatKy.setHoatDong(StrHoatDong);		
		nhatKyDao.themMoi(objNhatKy);
	}
	
	
	/**
	 * Ham them moi
	 * 
	 */
	public String themLoai() {
		
					
		lstLoai = loaiDao.timKiemLoaiTheoTen(tenLoai);

		if(lstLoai == null || lstLoai.isEmpty()) {       // check trung ten. TH ko trung ten
					
			Loai objLoai = new Loai();		
			objLoai.setTenLoai(tenLoai);
			objLoai.setMoTa(moTa);	
			loaiDao.themMoi(objLoai);
			
			kq= "Them moi thanh cong";
						
			/**
			 *   Nhat Ky
			 */				
			StrHoatDong = "Them doi tuong Loai: " + " (Ten loai: " + tenLoai + "), ( Mo ta: " + moTa +")" ;		
			comm(StrHoatDong);
		} 
		else {                                              // check trung ten. TH trung ten
			
			System.out.println("No Vao Day Roi");
			addActionError("Ten Loai Bi Trung ");		
			
		    kq= "Ten loai bi trung";
			return ERROR;
		}
				
		return SUCCESS;
	}


	
	
	
	
private String kq = "";
	
	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	
		
	/**
	 * Ham cap nhat thong tin
	 * 
	 */
	public String capNhatLoai() {
		
		lstLoai = loaiDao.timKiemLoaiTheoTen(tenLoai);

		if(lstLoai == null || lstLoai.isEmpty()) {    // check trung ten. TH ko trung ten
		
		Loai objLoai = new Loai();
		objLoai.setId(id);
		objLoai.setTenLoai(tenLoai);
		objLoai.setMoTa(moTa);
		loaiDao.capNhat(objLoai);
		kq= "Cap nhat thanh cong";
		
		/**
		 *   Nhat Ky
		 */
		tenLoai_Old = (String) session.get("tenLoai_Cu");
		moTa_Old = (String) session.get("moTa_Cu");
		
		StrHoatDong = "Cap nhat doi tuong Loai: " + " (Ten loai: " + tenLoai_Old + "), ( Mo ta: " + moTa_Old +")" 
				+ " => CAP NHAT THANH " + " (Ten loai: " + tenLoai + "), ( Mo ta: " + moTa +")";
				
		comm(StrHoatDong);
		} 
		
		else {                                      // check trung ten. TH co trung ten
			for(Loai ldtt: lstLoai) {
				idDaTonTai = ldtt.getId();
			}
			
			if(id == idDaTonTai) {                  // Trung tenloai nhung idDaTonTai == id muon sua
				Loai objLoai = new Loai();
				objLoai.setId(id);
				objLoai.setTenLoai(tenLoai);
				objLoai.setMoTa(moTa);
				loaiDao.capNhat(objLoai);
				kq= "Cap nhat thanh cong";
				
				/**
				 *   Nhat Ky
				 */
				tenLoai_Old = (String) session.get("tenLoai_Cu");
				moTa_Old = (String) session.get("moTa_Cu");
				
				StrHoatDong = "Cap nhat doi tuong Loai: " + " (Ten loai: " + tenLoai_Old + "), ( Mo ta: " + moTa_Old +")" 
						+ " => CAP NHAT THANH " + " (Ten loai: " + tenLoai + "), ( Mo ta: " + moTa +")";
						
				comm(StrHoatDong);
			} else if(id != idDaTonTai) {             // Trung ten va idDaTonTai != id muon sua
				System.out.println("Da Co Doi tuong Co ten Nhu the Nen ko sua dc ");
				
				 kq= "Ten loai bi trung";
			}
			
		}
						
		return SUCCESS;
	}

	/**
	 * Ham lay thong tin chi tiet loai theo id, ket qua dang json
	 * 
	 */
	public String layThongTinChiTietLoai() {
		// Lay thong tin theo id
		Loai objLoai = loaiDao.layChiTietTheoId(id);

		// Luoc bo bot thong tin khong can thiet
		Loai simpleObjLoai = new Loai();
		simpleObjLoai.setId(objLoai.getId());
		simpleObjLoai.setTenLoai(objLoai.getTenLoai());
		simpleObjLoai.setMoTa(objLoai.getMoTa());

		// Convert ve dang json
		setJsonLoai(new Gson().toJson(simpleObjLoai));
		
		
		/**
		 *   Nhat Ky
		 */
	 	 tenLoai_Old = objLoai.getTenLoai();
	 	 session.put("tenLoai_Cu", tenLoai_Old);
		 moTa_Old = objLoai.getMoTa();
		 session.put("moTa_Cu", moTa_Old);
		 
		return SUCCESS;
	}

	/**
	 * Ham xoa
	 * 
	 */
	public String xoaLoai() {
		
		/**
		 *   Nhat Ky truoc. Xoa obj sau
		 */		
		Loai objLoai = loaiDao.layChiTietTheoId(id);
		tenLoai = objLoai.getTenLoai();
		moTa = objLoai.getMoTa();
		
		StrHoatDong = "Xoa doi tuong Loai: " + " (Ten loai: " + tenLoai + "), ( Mo ta: " + moTa +")" ;		
		comm(StrHoatDong);
		
		// Thuc hien xoa
		  loaiDao.xoa(id);
		
		return SUCCESS;
	}
	
	/**
	 *   Nhat Ky
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;		
	}
}
