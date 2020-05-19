package vn.com.stanford.je1019.onlinecourses.entry;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "tenkhoahoc")
	private String tenKhoaHoc;

	@Column(name = "anhdaidien")
	private String anhDaiDien;

	@Column(name = "ngayxuatban")
	private Date ngayXuatBan;

	@Column(name = "ngayCapNhat")
	private Date ngayCapNhat;

	@Column(name = "ngayDang")
	private Date ngayDang;

	@Column(name = "daDuyet")
	private Boolean daDuyet;

	@Column(name = "mienphi")
	private Boolean mienPhi;

	@Column(name = "hocphi")
	private Double hocPhi;

	@Column(name = "moTa")
	private String moTa;
	
	@Column(name = "chude_id")
	private Integer chuDeId;

	@Column(name = "capdo_id")
	private Integer capDoId;

	@Column(name = "giangvien_id")
	private Integer giangVienId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public Date getNgayXuatBan() {
		return ngayXuatBan;
	}

	public void setNgayXuatBan(Date ngayXuatBan) {
		this.ngayXuatBan = ngayXuatBan;
	}

	public Date getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
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

	public Boolean getMienPhi() {
		return mienPhi;
	}

	public void setMienPhi(Boolean mienPhi) {
		this.mienPhi = mienPhi;
	}

	public Double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(Double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	public Integer getChuDeId() {
		return chuDeId;
	}

	public void setChuDeId(Integer chuDeId) {
		this.chuDeId = chuDeId;
	}

	public Integer getCapDoId() {
		return capDoId;
	}

	public void setCapDoId(Integer capDoId) {
		this.capDoId = capDoId;
	}

	public Integer getGiangVienId() {
		return giangVienId;
	}

	public void setGiangVienId(Integer giangVienId) {
		this.giangVienId = giangVienId;
	}

}
