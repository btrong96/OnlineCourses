package vn.com.stanford.je1019.onlinecourses.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.NhatKyDAO;

public class NhatKyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7328408456738180983L;

	@Autowired
	NhatKyDAO nhatKyDao;
	@Autowired
	NguoiDungDAO nguoiDungDao;

	private List<NhatKy> lstNhatKy;
	private List<NguoiDung> lstNguoiDung;
	private Integer id;
	private Integer maNguoiDungTimKiem;
	private String ngayNhatKy;

	private Date ngayTimKiem;
	

	public NhatKyDAO getNhatKyDao() {
		return nhatKyDao;
	}

	public void setNhatKyDao(NhatKyDAO nhatKyDao) {
		this.nhatKyDao = nhatKyDao;
	}

	public List<NhatKy> getLstNhatKy() {
		return lstNhatKy;
	}

	public void setLstNhatKy(List<NhatKy> lstNhatKy) {
		this.lstNhatKy = lstNhatKy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getMaNguoiDungTimKiem() {
		return maNguoiDungTimKiem;
	}

	public void setMaNguoiDungTimKiem(Integer maNguoiDungTimKiem) {
		this.maNguoiDungTimKiem = maNguoiDungTimKiem;
	}

	public String getNgayNhatKy() {
		return ngayNhatKy;
	}

	public void setNgayNhatKy(String ngayNhatKy) {
		this.ngayNhatKy = ngayNhatKy;
	}

	public Date getNgayTimKiem() {
		return ngayTimKiem;
	}

	public void setNgayTimKiem(Date ngayTimKiem) {
		this.ngayTimKiem = ngayTimKiem;
	}

	@Override
	public String execute() throws Exception {
		lstNguoiDung = nguoiDungDao.layDanhSach();
		lstNhatKy = nhatKyDao.layDanhSach();
		return SUCCESS;
	}

	public String xoaNhatKy() {
		nhatKyDao.xoa(id);
		return SUCCESS;
	}

	public String timKiemNhatKy() throws ParseException {

		lstNguoiDung = nguoiDungDao.layDanhSach();
		
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsedate = format.parse(ngayNhatKy);
			java.sql.Date ngay_Sql = new java.sql.Date(parsedate.getTime());
			ngayTimKiem = ngay_Sql;			
			
		} catch (Exception e) {
			System.out.println("LOI LOI");
		}
		
		lstNhatKy = nhatKyDao.timKiemNhatKy(ngayTimKiem, maNguoiDungTimKiem);

		return SUCCESS;
	}	
	
}
