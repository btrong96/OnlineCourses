package vn.com.stanford.je1019.onlinecourses.entry;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai")
public class Loai implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8184208861223370163L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String tenLoai;
	
	private String moTa;
	
	// quan he 1-m, mappedBy tro toi thuoc tinh loai cua lop ChuDe
//	@OneToMany(mappedBy = "loai", cascade = CascadeType.ALL)
//	private Set<ChuDe> lstChuDe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

//	public Set<ChuDe> getLstChuDe() {
//		return lstChuDe;
//	}
//
//	public void setLstChuDe(Set<ChuDe> lstChuDe) {
//		this.lstChuDe = lstChuDe;
//	}
	
}
