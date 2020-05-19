package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")	
private Integer id;

@Column(name = "tenKhachHang")	
private String tenKhachHang;

@Column(name = "diaChi")	
private String diaChi;

@Column(name = "dienThoai")	
private String dienThoai;

@Column(name = "CMND")	
private String cMND;

@Column(name = "ngayCap")	
private Date ngayCap;

@Column(name = "noiCap")	
private String noiCap;

@Column(name = "maSoThue")	
private String maSoThue;

@Column(name = "ngayTao")	
private Date ngayTao;

@Column(name = "ngayCapNhat")	
private Date ngayCapNhat;

@Column(name = "moTa")	
private String moTa;


@Column(name = "nguoidung_id")	
private Integer nguoiDungId;

//quan he 1-m, mappedBy tro toi thuoc tinh khachHang cua lop HoaDon
	@OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
	private Set<HoaDon> lstHoaDon;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTenKhachHang() {
	return tenKhachHang;
}

public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}

public String getDiaChi() {
	return diaChi;
}

public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}

public String getDienThoai() {
	return dienThoai;
}

public void setDienThoai(String dienThoai) {
	this.dienThoai = dienThoai;
}

public String getcMND() {
	return cMND;
}

public void setcMND(String cMND) {
	this.cMND = cMND;
}

public Date getNgayCap() {
	return ngayCap;
}

public void setNgayCap(Date ngayCap) {
	this.ngayCap = ngayCap;
}

public String getNoiCap() {
	return noiCap;
}

public void setNoiCap(String noiCap) {
	this.noiCap = noiCap;
}

public String getMaSoThue() {
	return maSoThue;
}

public void setMaSoThue(String maSoThue) {
	this.maSoThue = maSoThue;
}

public Date getNgayTao() {
	return ngayTao;
}

public void setNgayTao(Date ngayTao) {
	this.ngayTao = ngayTao;
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

public Integer getNguoiDungId() {
	return nguoiDungId;
}

public void setNguoiDungId(Integer nguoiDungId) {
	this.nguoiDungId = nguoiDungId;
}

public Set<HoaDon> getLstHoaDon() {
	return lstHoaDon;
}

public void setLstHoaDon(Set<HoaDon> lstHoaDon) {
	this.lstHoaDon = lstHoaDon;
}



}
