package vn.com.stanford.je1019.onlinecourses.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phanquyen")
public class PhanQuyen  {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "danhSach")
	private Boolean danhSach;
	
	@Column(name = "them")
	private Boolean them;
	
	@Column(name = "sua")
	private Boolean sua;
	
	@Column(name = "xoa")
	private Boolean xoa;
	
	@Column(name = "baoCao")
	private Boolean baoCao;
	
	@Column(name = "chucnang_id")
	private Integer chucnang_id;
	
	@Column(name = "vaitro_id")
	private Integer vaitro_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDanhSach() {
		return danhSach;
	}

	public void setDanhSach(Boolean danhSach) {
		this.danhSach = danhSach;
	}

	public Boolean getThem() {
		return them;
	}

	public void setThem(Boolean them) {
		this.them = them;
	}

	public Boolean getSua() {
		return sua;
	}

	public void setSua(Boolean sua) {
		this.sua = sua;
	}

	public Boolean getXoa() {
		return xoa;
	}

	public void setXoa(Boolean xoa) {
		this.xoa = xoa;
	}

	public Boolean getBaoCao() {
		return baoCao;
	}

	public void setBaoCao(Boolean baoCao) {
		this.baoCao = baoCao;
	}

	public Integer getChucnang_id() {
		return chucnang_id;
	}

	public void setChucnang_id(Integer chucnang_id) {
		this.chucnang_id = chucnang_id;
	}

	public Integer getVaitro_id() {
		return vaitro_id;
	}

	public void setVaitro_id(Integer vaitro_id) {
		this.vaitro_id = vaitro_id;
	}
	

}
