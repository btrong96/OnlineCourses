package vn.com.stanford.je1019.onlinecourses.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.VaiTro;
import vn.com.stanford.je1019.onlinecourses.model.VaiTroDAO;

public class VaiTroAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6223440350371189614L;

	@Autowired
	VaiTroDAO vaiTroDao;

	private List<VaiTro> lstVaiTro;
	private Integer id;
	private String tenVaiTro;
	private String moTa;
	private String jsonVaiTro;

	public VaiTroDAO getVaiTroDao() {
		return vaiTroDao;
	}

	public void setVaiTroDao(VaiTroDAO vaiTroDao) {
		this.vaiTroDao = vaiTroDao;
	}

	public List<VaiTro> getLstVaiTro() {
		return lstVaiTro;
	}

	public void setLstVaiTro(List<VaiTro> lstVaiTro) {
		this.lstVaiTro = lstVaiTro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenVaiTro() {
		return tenVaiTro;
	}

	public void setTenVaiTro(String tenVaiTro) {
		this.tenVaiTro = tenVaiTro;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getJsonVaiTro() {
		return jsonVaiTro;
	}

	public void setJsonVaiTro(String jsonVaiTro) {
		this.jsonVaiTro = jsonVaiTro;
	}

	/**
	 * 
	 * Hàm lấy danh sách chức năng
	 */
	@Override
	public String execute() throws Exception {
		lstVaiTro = vaiTroDao.layDanhSach();
		return SUCCESS;
	}

	/**
	 * 
	 * Hàm thêm mới chức năng
	 */
	public String themVaiTro() {
		VaiTro objVaiTro = new VaiTro();
		objVaiTro.setTenVaiTro(tenVaiTro);
		objVaiTro.setMoTa(moTa);

		vaiTroDao.themMoi(objVaiTro);
		return SUCCESS;
	}

	/**
	 * 
	 * Hàm cập nhật thông tin
	 */
	public String capNhatVaiTro() {
		VaiTro objVaiTro = new VaiTro();
		objVaiTro.setId(id);
		objVaiTro.setTenVaiTro(tenVaiTro);
		objVaiTro.setMoTa(moTa);

		vaiTroDao.capNhat(objVaiTro);
		System.out.println(objVaiTro);

		return SUCCESS;
	}

	/**
	 * 
	 * Hàm lấy thông tin chi tiết theo id kết quả trả về dạng json
	 */
	public String layThongTinChiTietVaiTro() {
		// Lấy thông tin theo id
		VaiTro objVaiTro = vaiTroDao.layChiTietTheoId(id);

		// Bỏ thông tin thừa
		VaiTro simpleObjVaiTro = new VaiTro();
		simpleObjVaiTro.setId(objVaiTro.getId());
		simpleObjVaiTro.setTenVaiTro(objVaiTro.getTenVaiTro());
		simpleObjVaiTro.setMoTa(objVaiTro.getMoTa());

		// Chuyển sang dạng json
		setJsonVaiTro(new Gson().toJson(simpleObjVaiTro));

		return SUCCESS;
	}

	/**
	 * 
	 * Hàm xóa chức năng
	 * 
	 */
	public String xoaVaiTro() {
		// Xóa
		vaiTroDao.xoa(id);
		return SUCCESS;
	}
}
