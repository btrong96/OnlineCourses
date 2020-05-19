package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nguoidung_khoahoc")
public class NguoiDung_KhoaHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nguoidung_id")
	private Integer nguoiDungId;
	
	@Column(name = "khoahoc_id")
	private Integer khoaHocId;
	
	@Column(name = "ngayCap")
	private Date ngayCap;
	
	@Column(name = "tenNguoiDung")
	private String tenNguoiDung;
	
	@Column(name = "tenKhoaHoc")
	private String tenKhoaHoc;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNguoiDungId() {
		return nguoiDungId;
	}
	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}
	public Integer getKhoaHocId() {
		return khoaHocId;
	}
	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}
	public Date getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}
	
	
}
