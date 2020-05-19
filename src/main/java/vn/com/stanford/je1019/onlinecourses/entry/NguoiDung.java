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
@Table(name = "nguoidung")
public class NguoiDung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7644218037687965856L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String taiKhoan;
	private String matKhau;
	private String hoTen;
	private String dienThoai;
	private String email;
	private Date ngayTao;
	private Date ngayCapNhat;
		
	@Column(name = "vaitro_id")
	private Integer vaiTroId;
	
	private Boolean trangThai;
	
	// quan he m-1 voi bang VaiTro, JoinColumn tro toi bang vaitro_id cua bang
	// NguoiDung
//	@ManyToOne
//	@JoinColumn(name = "vaitro_id")
//	private VaiTro vaiTro;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getVaiTroId() {
		return vaiTroId;
	}

	public void setVaiTroId(Integer vaiTroId) {
		this.vaiTroId = vaiTroId;
	}

	public Boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}

	
}
