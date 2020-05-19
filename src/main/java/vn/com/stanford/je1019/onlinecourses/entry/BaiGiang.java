package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baigiang")
public class BaiGiang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "thutu")
	private Integer thuTu;
	
	@Column(name = "tenbaigiang")
	private String tenBaiGiang;
	
	@Column(name = "anhdaidien")
	private String anhDaiDien;
	
	@Column(name = "ngayTao")
	private Date ngayTao;
	
	@Column(name = "thoiluong")
	private String thoiLuong;
	
	@Column(name = "ngayCapNhat")
	private Date ngayCapNhat;
	
	@Column(name = "mota")
	private String moTa;
	
	@Column(name = "ngayDang")
	private Date ngayDang;
	
	@Column(name = "daDuyet")
	private Boolean daDuyet;
	
	@Column(name = "giangvien_id")
	private Integer giangVienId;
	
	@Column(name = "khoahoc_id")
	private Integer khoaHocId;
	
	@Column(name = "nameCode")
	private String nameCode;
	
	@Column(name = "mienPhi")
	private Boolean mienPhi;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getThuTu() {
		return thuTu;
	}

	public void setThuTu(Integer thuTu) {
		this.thuTu = thuTu;
	}

	public String getTenBaiGiang() {
		return tenBaiGiang;
	}

	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
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

	public Integer getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(Integer giangVienId) {
		this.giangVienId = giangVienId;
	}

	public Integer getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public String getNameCode() {
		return nameCode;
	}

	public void setNameCode(String nameCode) {
		this.nameCode = nameCode;
	}

	public Boolean getMienPhi() {
		return mienPhi;
	}

	public void setMienPhi(Boolean mienPhi) {
		this.mienPhi = mienPhi;
	}

}
