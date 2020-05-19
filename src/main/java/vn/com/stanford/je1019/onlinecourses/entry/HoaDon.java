package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hoadon")
public class HoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "ngaymua")
	private Date ngayMua;

	@Column(name = "ghichu")
	private String ghiChu;

	@Column(name = "daThanhToan")
	private Float daThanhToan;

//	@Column(name = "khachhang_id")
//	private Integer khachHangId;

	// quan he m-1 voi bang Khach Hang, JoinColumn tro toi cot khachhang_id cua bang KhachHang
	@ManyToOne
	@JoinColumn(name = "khachhang_id")
	private KhachHang khachHang;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public Float getDaThanhToan() {
		return daThanhToan;
	}

	public void setDaThanhToan(Float daThanhToan) {
		this.daThanhToan = daThanhToan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

//	public Integer getKhachHangId() {
//		return khachHangId;
//	}
//
//	public void setKhachHangId(Integer khachHangId) {
//		this.khachHangId = khachHangId;
//	}
	
}
