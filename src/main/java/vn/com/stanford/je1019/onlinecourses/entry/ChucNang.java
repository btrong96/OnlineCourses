package vn.com.stanford.je1019.onlinecourses.entry;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chucnang")
public class ChucNang implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894298358834832871L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tenChucNang;

	private String moTa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTenChucNang() {
		return tenChucNang;
	}

	public void setTenChucNang(String tenChucNang) {
		this.tenChucNang = tenChucNang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}
