package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhatky")
public class NhatKy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nguoidung_id")
	private Integer nguoiDungId;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "chucnang")
	private String chucNang;
	
	@Column(name = "ngay")
	private Date ngay;
	
	@Column(name = "hoatdong")
	private String hoatDong;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChucNang() {
		return chucNang;
	}

	public void setChucNang(String chucNang) {
		this.chucNang = chucNang;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public String getHoatDong() {
		return hoatDong;
	}

	public void setHoatDong(String hoatDong) {
		this.hoatDong = hoatDong;
	}

}
