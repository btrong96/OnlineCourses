package vn.com.stanford.je1019.onlinecourses.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "SoLuong")
	private Integer soLuong;

	@Column(name = "ThanhToan")
	private Double thanhToan;

	@Column(name = "MoTa")
	private String moTa;

	@Column(name = "hoadon_id")
	private Integer hoaDonId;

	@Column(name = "khoahoc_id")
	private Integer khoaHocId;
	
	@Column(name = "tenKhoaHoc")
	private String tenKhoaHoc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(Double thanhToan) {
		this.thanhToan = thanhToan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getHoaDonId() {
		return hoaDonId;
	}

	public void setHoaDonId(Integer hoaDonId) {
		this.hoaDonId = hoaDonId;
	}

	public Integer getKhoaHocId() {
		return khoaHocId;
	}

	public void setKhoaHocId(Integer khoaHocId) {
		this.khoaHocId = khoaHocId;
	}

	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}

	public void setTenKhoaHoc(String tenKhoaHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
	}

	
}
