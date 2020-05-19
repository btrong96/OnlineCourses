package vn.com.stanford.je1019.onlinecourses.entry;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanxet")
public class NhanXet {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "noidung")
    private String noiDung;
	
	@Column(name = "thoiGianTao")
    private Date thoiGianTao;
	
	@Column(name = "thoiGianCapNhat")
    private Date thoiGianCapNhat;
	
	@Column(name = "baigiang_id")
    private Integer baiGiangId;
	
	@Column(name = "nguoidung_id")
    private Integer nguoiDungId;
	
	@Column(name = "tenBaiGiang")
    private String tenBaiGiang;
	
	@Column(name = "tenNguoiDung")
    private String tenNguoiDung;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Date getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(Date thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}
	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public Integer getBaiGiangId() {
		return baiGiangId;
	}
	public void setBaiGiangId(Integer baiGiangId) {
		this.baiGiangId = baiGiangId;
	}
	public Integer getNguoiDungId() {
		return nguoiDungId;
	}
	public void setNguoiDungId(Integer nguoiDungId) {
		this.nguoiDungId = nguoiDungId;
	}
	public String getTenBaiGiang() {
		return tenBaiGiang;
	}
	public void setTenBaiGiang(String tenBaiGiang) {
		this.tenBaiGiang = tenBaiGiang;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
       
}
