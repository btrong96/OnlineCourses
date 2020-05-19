package vn.com.stanford.je1019.onlinecourses.entry;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chude")
public class ChuDe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2516338742375677816L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "tenchude")
	private String tenChuDe;

	@Column(name = "mota")
	private String moTa;

	@Column(name = "Loai_id")
	private Integer loaiId;
	
	@Column(name = "anhdaidien")
	private String anhDaiDien;
	
	@Column(name = "tenloai")
	private String tenLoai;
	
	// quan he m-1 voi bang Loai, JoinColumn tro toi bang loai_id cua bang ChuDe
//	@ManyToOne
//	@JoinColumn(name = "loai_id")
//	private Loai loai;

	// quan he 1-m, mappedBy trá»� tá»›i thuá»™c tÃ­nh chude cua lá»›p KhoaHoc
//	@OneToMany(mappedBy = "chude", cascade = CascadeType.ALL)
//	private Set<KhoaHoc> lstKhoaHoc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenChuDe() {
		return tenChuDe;
	}

	public void setTenChuDe(String tenChuDe) {
		this.tenChuDe = tenChuDe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getLoaiId() {
		return loaiId;
	}

	public void setLoaiId(Integer loaiId) {
		this.loaiId = loaiId;
	}

	public String getAnhDaiDien() {
		return anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		this.anhDaiDien = anhDaiDien;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
		

//	public Loai getLoai() {
//		return loai;
//	}
//
//	public void setLoai(Loai loai) {
//		this.loai = loai;
//	}


}
