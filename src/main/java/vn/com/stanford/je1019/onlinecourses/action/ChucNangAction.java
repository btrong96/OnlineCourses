package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.ChucNang;
import vn.com.stanford.je1019.onlinecourses.model.ChucNangDAO;

public class ChucNangAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5439370327108326528L;

	@Autowired
	ChucNangDAO chucNangDao;

	private List<ChucNang> lstChucNang;
	private Integer id;
	private String tenChucNang;
	private String moTa;
	private String jsonChucNang;

	public ChucNangDAO getChucNangDao() {
		return chucNangDao;
	}

	public void setChucNangDao(ChucNangDAO chucNangDao) {
		this.chucNangDao = chucNangDao;
	}

	public List<ChucNang> getLstChucNang() {
		return lstChucNang;
	}

	public void setLstChucNang(List<ChucNang> lstChucNang) {
		this.lstChucNang = lstChucNang;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenChucNang() {
		return tenChucNang;
	}

	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getJsonChucNang() {
		return jsonChucNang;
	}

	public void setJsonChucNang(String jsonChucNang) {
		this.jsonChucNang = jsonChucNang;
	}

	/**
	 * 
	 * Hàm lấy danh sách chức năng
	 */
	@Override
	public String execute() throws Exception {
		lstChucNang = chucNangDao.layDanhSach();
		return SUCCESS;
	}

	/**
	 * 
	 * Hàm thêm mới chức năng
	 */
	public String themChucNang() {
		ChucNang objChucNang = new ChucNang();
		objChucNang.setTenChucNang(tenChucNang);
		objChucNang.setMoTa(moTa);

		chucNangDao.themMoi(objChucNang);
		return SUCCESS;
	}

	/**
	 * 
	 * Hàm cập nhật thông tin
	 */
	public String capNhatChucNang() {
		ChucNang objChucNang = new ChucNang();
		objChucNang.setId(id);
		objChucNang.setTenChucNang(tenChucNang);
		objChucNang.setMoTa(moTa);

		chucNangDao.capNhat(objChucNang);
		System.out.println(objChucNang);

		return SUCCESS;
	}

	/**
	 * 
	 * Hàm lấy thông tin chi tiết theo id kết quả trả về dạng json
	 */
	public String layThongTinChiTietChucNang() {
		// Lấy thông tin theo id
		ChucNang objChucNang = chucNangDao.layChiTietTheoId(id);

		// Bỏ thông tin thừa
		ChucNang simpleObjChucNang = new ChucNang();
		simpleObjChucNang.setId(objChucNang.getId());
		simpleObjChucNang.setTenChucNang(objChucNang.getTenChucNang());
		simpleObjChucNang.setMoTa(objChucNang.getMoTa());

		// Chuyển sang dạng json
		setJsonChucNang(new Gson().toJson(simpleObjChucNang));

		return SUCCESS;
	}

	/**
	 * 
	 * Hàm xóa chức năng
	 * 
	 */
	public String xoaChucNang() {
		// Xóa
		chucNangDao.xoa(id);
		return SUCCESS;
	}
}
