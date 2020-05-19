package vn.com.stanford.je1019.onlinecourses.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.entry.PhanQuyen;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;
import vn.com.stanford.je1019.onlinecourses.model.PhanQuyenDAO;

public class AuthorizationInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4056172065065532954L;

	@Autowired
	NguoiDungDAO nguoiDungDao;
	@Autowired
	PhanQuyenDAO phanQuyenDao;

	private List<NguoiDung> lstNguoiDung;
	private String taiKhoanUser;
	private String matKhauUser;
	private Integer vaiTroId;

	private List<PhanQuyen> lstQuyenHan_1;
	private Boolean danhSach_1;
	private Boolean them_1;
	private Boolean sua_1;
	private Boolean xoa_1;
	private Boolean baoCao_1;

	private List<PhanQuyen> lstQuyenHan_2;
	private Boolean danhSach_2;
	private Boolean them_2;
	private Boolean sua_2;
	private Boolean xoa_2;
	private Boolean baoCao_2;

	private List<PhanQuyen> lstQuyenHan_3;
	private Boolean danhSach_3;
	private Boolean them_3;
	private Boolean sua_3;
	private Boolean xoa_3;
	private Boolean baoCao_3;
	
	private List<PhanQuyen> lstQuyenHan_4;
	private Boolean danhSach_4;
	private Boolean them_4;
	private Boolean sua_4;
	private Boolean xoa_4;
	private Boolean baoCao_4;
	
	private List<PhanQuyen> lstQuyenHan_5;
	private Boolean danhSach_5;
	private Boolean them_5;
	private Boolean sua_5;
	private Boolean xoa_5;
	private Boolean baoCao_5;
	
	private List<PhanQuyen> lstQuyenHan_6;
	private Boolean danhSach_6;
	private Boolean them_6;
	private Boolean sua_6;
	private Boolean xoa_6;
	private Boolean baoCao_6;
	
	private List<PhanQuyen> lstQuyenHan_7;
	private Boolean danhSach_7;
	private Boolean them_7;
	private Boolean sua_7;
	private Boolean xoa_7;
	private Boolean baoCao_7;
	
	private List<PhanQuyen> lstQuyenHan_8;
	private Boolean danhSach_8;
	private Boolean them_8;
	private Boolean sua_8;
	private Boolean xoa_8;
	private Boolean baoCao_8;
	
	private List<PhanQuyen> lstQuyenHan_9;
	private Boolean danhSach_9;
	private Boolean them_9;
	private Boolean sua_9;
	private Boolean xoa_9;
	private Boolean baoCao_9;
	
	private List<PhanQuyen> lstQuyenHan_10;
	private Boolean danhSach_10;
	private Boolean them_10;
	private Boolean sua_10;
	private Boolean xoa_10;
	private Boolean baoCao_10;
	
	private List<PhanQuyen> lstQuyenHan_11;
	private Boolean danhSach_11;
	private Boolean them_11;
	private Boolean sua_11;
	private Boolean xoa_11;
	private Boolean baoCao_11;
	
	private List<PhanQuyen> lstQuyenHan_12;
	private Boolean danhSach_12;
	private Boolean them_12;
	private Boolean sua_12;
	private Boolean xoa_12;
	private Boolean baoCao_12;
	
	private List<PhanQuyen> lstQuyenHan_13;
	private Boolean danhSach_13;
	private Boolean them_13;
	private Boolean sua_13;
	private Boolean xoa_13;
	private Boolean baoCao_13;
	
	private List<PhanQuyen> lstQuyenHan_14;
	private Boolean danhSach_14;
	private Boolean them_14;
	private Boolean sua_14;
	private Boolean xoa_14;
	private Boolean baoCao_14;
	
	private List<PhanQuyen> lstQuyenHan_15;
	private Boolean danhSach_15;
	private Boolean them_15;
	private Boolean sua_15;
	private Boolean xoa_15;
	private Boolean baoCao_15;
	
	private List<PhanQuyen> lstQuyenHan_16;
	private Boolean danhSach_16;
	private Boolean them_16;
	private Boolean sua_16;
	private Boolean xoa_16;
	private Boolean baoCao_16;
	
	private List<PhanQuyen> lstQuyenHan_17;
	private Boolean danhSach_17;
	
	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
	}

	public String getTaiKhoanUser() {
		return taiKhoanUser;
	}

	public void setTaiKhoanUser(String taiKhoanUser) {
		this.taiKhoanUser = taiKhoanUser;
	}

	public String getMatKhauUser() {
		return matKhauUser;
	}

	public void setMatKhauUser(String matKhauUser) {
		this.matKhauUser = matKhauUser;
	}

	public Integer getVaiTroId() {
		return vaiTroId;
	}

	public void setVaiTroId(Integer vaiTroId) {
		this.vaiTroId = vaiTroId;
	}

	public PhanQuyenDAO getPhanQuyenDao() {
		return phanQuyenDao;
	}

	public void setPhanQuyenDao(PhanQuyenDAO phanQuyenDao) {
		this.phanQuyenDao = phanQuyenDao;
	}

	public List<PhanQuyen> getLstQuyenHan_1() {
		return lstQuyenHan_1;
	}

	public void setLstQuyenHan_1(List<PhanQuyen> lstQuyenHan_1) {
		this.lstQuyenHan_1 = lstQuyenHan_1;
	}

	public Boolean getDanhSach_1() {
		return danhSach_1;
	}

	public void setDanhSach_1(Boolean danhSach_1) {
		this.danhSach_1 = danhSach_1;
	}

	public Boolean getThem_1() {
		return them_1;
	}

	public void setThem_1(Boolean them_1) {
		this.them_1 = them_1;
	}

	public Boolean getSua_1() {
		return sua_1;
	}

	public void setSua_1(Boolean sua_1) {
		this.sua_1 = sua_1;
	}

	public Boolean getXoa_1() {
		return xoa_1;
	}

	public void setXoa_1(Boolean xoa_1) {
		this.xoa_1 = xoa_1;
	}

	public Boolean getBaoCao_1() {
		return baoCao_1;
	}

	public void setBaoCao_1(Boolean baoCao_1) {
		this.baoCao_1 = baoCao_1;
	}

	public List<PhanQuyen> getLstQuyenHan_2() {
		return lstQuyenHan_2;
	}

	public void setLstQuyenHan_2(List<PhanQuyen> lstQuyenHan_2) {
		this.lstQuyenHan_2 = lstQuyenHan_2;
	}

	public Boolean getDanhSach_2() {
		return danhSach_2;
	}

	public void setDanhSach_2(Boolean danhSach_2) {
		this.danhSach_2 = danhSach_2;
	}

	public Boolean getThem_2() {
		return them_2;
	}

	public void setThem_2(Boolean them_2) {
		this.them_2 = them_2;
	}

	public Boolean getSua_2() {
		return sua_2;
	}

	public void setSua_2(Boolean sua_2) {
		this.sua_2 = sua_2;
	}

	public Boolean getXoa_2() {
		return xoa_2;
	}

	public void setXoa_2(Boolean xoa_2) {
		this.xoa_2 = xoa_2;
	}

	public Boolean getBaoCao_2() {
		return baoCao_2;
	}

	public void setBaoCao_2(Boolean baoCao_2) {
		this.baoCao_2 = baoCao_2;
	}

	public List<PhanQuyen> getLstQuyenHan_3() {
		return lstQuyenHan_3;
	}

	public void setLstQuyenHan_3(List<PhanQuyen> lstQuyenHan_3) {
		this.lstQuyenHan_3 = lstQuyenHan_3;
	}

	public Boolean getDanhSach_3() {
		return danhSach_3;
	}

	public void setDanhSach_3(Boolean danhSach_3) {
		this.danhSach_3 = danhSach_3;
	}

	public Boolean getThem_3() {
		return them_3;
	}

	public void setThem_3(Boolean them_3) {
		this.them_3 = them_3;
	}

	public Boolean getSua_3() {
		return sua_3;
	}

	public void setSua_3(Boolean sua_3) {
		this.sua_3 = sua_3;
	}

	public Boolean getXoa_3() {
		return xoa_3;
	}

	public void setXoa_3(Boolean xoa_3) {
		this.xoa_3 = xoa_3;
	}

	public Boolean getBaoCao_3() {
		return baoCao_3;
	}

	public void setBaoCao_3(Boolean baoCao_3) {
		this.baoCao_3 = baoCao_3;
	}

	public List<PhanQuyen> getLstQuyenHan_4() {
		return lstQuyenHan_4;
	}

	public void setLstQuyenHan_4(List<PhanQuyen> lstQuyenHan_4) {
		this.lstQuyenHan_4 = lstQuyenHan_4;
	}

	public Boolean getDanhSach_4() {
		return danhSach_4;
	}

	public void setDanhSach_4(Boolean danhSach_4) {
		this.danhSach_4 = danhSach_4;
	}

	public Boolean getThem_4() {
		return them_4;
	}

	public void setThem_4(Boolean them_4) {
		this.them_4 = them_4;
	}

	public Boolean getSua_4() {
		return sua_4;
	}

	public void setSua_4(Boolean sua_4) {
		this.sua_4 = sua_4;
	}

	public Boolean getXoa_4() {
		return xoa_4;
	}

	public void setXoa_4(Boolean xoa_4) {
		this.xoa_4 = xoa_4;
	}

	public Boolean getBaoCao_4() {
		return baoCao_4;
	}

	public void setBaoCao_4(Boolean baoCao_4) {
		this.baoCao_4 = baoCao_4;
	}

	public List<PhanQuyen> getLstQuyenHan_5() {
		return lstQuyenHan_5;
	}

	public void setLstQuyenHan_5(List<PhanQuyen> lstQuyenHan_5) {
		this.lstQuyenHan_5 = lstQuyenHan_5;
	}

	public Boolean getDanhSach_5() {
		return danhSach_5;
	}

	public void setDanhSach_5(Boolean danhSach_5) {
		this.danhSach_5 = danhSach_5;
	}

	public Boolean getThem_5() {
		return them_5;
	}

	public void setThem_5(Boolean them_5) {
		this.them_5 = them_5;
	}

	public Boolean getSua_5() {
		return sua_5;
	}

	public void setSua_5(Boolean sua_5) {
		this.sua_5 = sua_5;
	}

	public Boolean getXoa_5() {
		return xoa_5;
	}

	public void setXoa_5(Boolean xoa_5) {
		this.xoa_5 = xoa_5;
	}

	public Boolean getBaoCao_5() {
		return baoCao_5;
	}

	public void setBaoCao_5(Boolean baoCao_5) {
		this.baoCao_5 = baoCao_5;
	}
	
	public List<PhanQuyen> getLstQuyenHan_6() {
		return lstQuyenHan_6;
	}

	public void setLstQuyenHan_6(List<PhanQuyen> lstQuyenHan_6) {
		this.lstQuyenHan_6 = lstQuyenHan_6;
	}

	public Boolean getDanhSach_6() {
		return danhSach_6;
	}

	public void setDanhSach_6(Boolean danhSach_6) {
		this.danhSach_6 = danhSach_6;
	}

	public Boolean getThem_6() {
		return them_6;
	}

	public void setThem_6(Boolean them_6) {
		this.them_6 = them_6;
	}

	public Boolean getSua_6() {
		return sua_6;
	}

	public void setSua_6(Boolean sua_6) {
		this.sua_6 = sua_6;
	}

	public Boolean getXoa_6() {
		return xoa_6;
	}

	public void setXoa_6(Boolean xoa_6) {
		this.xoa_6 = xoa_6;
	}

	public Boolean getBaoCao_6() {
		return baoCao_6;
	}

	public void setBaoCao_6(Boolean baoCao_6) {
		this.baoCao_6 = baoCao_6;
	}

	public List<PhanQuyen> getLstQuyenHan_7() {
		return lstQuyenHan_7;
	}

	public void setLstQuyenHan_7(List<PhanQuyen> lstQuyenHan_7) {
		this.lstQuyenHan_7 = lstQuyenHan_7;
	}

	public Boolean getDanhSach_7() {
		return danhSach_7;
	}

	public void setDanhSach_7(Boolean danhSach_7) {
		this.danhSach_7 = danhSach_7;
	}

	public Boolean getThem_7() {
		return them_7;
	}

	public void setThem_7(Boolean them_7) {
		this.them_7 = them_7;
	}

	public Boolean getSua_7() {
		return sua_7;
	}

	public void setSua_7(Boolean sua_7) {
		this.sua_7 = sua_7;
	}

	public Boolean getXoa_7() {
		return xoa_7;
	}

	public void setXoa_7(Boolean xoa_7) {
		this.xoa_7 = xoa_7;
	}

	public Boolean getBaoCao_7() {
		return baoCao_7;
	}

	public void setBaoCao_7(Boolean baoCao_7) {
		this.baoCao_7 = baoCao_7;
	}

	public List<PhanQuyen> getLstQuyenHan_8() {
		return lstQuyenHan_8;
	}

	public void setLstQuyenHan_8(List<PhanQuyen> lstQuyenHan_8) {
		this.lstQuyenHan_8 = lstQuyenHan_8;
	}

	public Boolean getDanhSach_8() {
		return danhSach_8;
	}

	public void setDanhSach_8(Boolean danhSach_8) {
		this.danhSach_8 = danhSach_8;
	}

	public Boolean getThem_8() {
		return them_8;
	}

	public void setThem_8(Boolean them_8) {
		this.them_8 = them_8;
	}

	public Boolean getSua_8() {
		return sua_8;
	}

	public void setSua_8(Boolean sua_8) {
		this.sua_8 = sua_8;
	}

	public Boolean getXoa_8() {
		return xoa_8;
	}

	public void setXoa_8(Boolean xoa_8) {
		this.xoa_8 = xoa_8;
	}

	public Boolean getBaoCao_8() {
		return baoCao_8;
	}

	public void setBaoCao_8(Boolean baoCao_8) {
		this.baoCao_8 = baoCao_8;
	}

	public List<PhanQuyen> getLstQuyenHan_9() {
		return lstQuyenHan_9;
	}

	public void setLstQuyenHan_9(List<PhanQuyen> lstQuyenHan_9) {
		this.lstQuyenHan_9 = lstQuyenHan_9;
	}

	public Boolean getDanhSach_9() {
		return danhSach_9;
	}

	public void setDanhSach_9(Boolean danhSach_9) {
		this.danhSach_9 = danhSach_9;
	}

	public Boolean getThem_9() {
		return them_9;
	}

	public void setThem_9(Boolean them_9) {
		this.them_9 = them_9;
	}

	public Boolean getSua_9() {
		return sua_9;
	}

	public void setSua_9(Boolean sua_9) {
		this.sua_9 = sua_9;
	}

	public Boolean getXoa_9() {
		return xoa_9;
	}

	public void setXoa_9(Boolean xoa_9) {
		this.xoa_9 = xoa_9;
	}

	public Boolean getBaoCao_9() {
		return baoCao_9;
	}

	public void setBaoCao_9(Boolean baoCao_9) {
		this.baoCao_9 = baoCao_9;
	}

	public List<PhanQuyen> getLstQuyenHan_10() {
		return lstQuyenHan_10;
	}

	public void setLstQuyenHan_10(List<PhanQuyen> lstQuyenHan_10) {
		this.lstQuyenHan_10 = lstQuyenHan_10;
	}

	public Boolean getDanhSach_10() {
		return danhSach_10;
	}

	public void setDanhSach_10(Boolean danhSach_10) {
		this.danhSach_10 = danhSach_10;
	}

	public Boolean getThem_10() {
		return them_10;
	}

	public void setThem_10(Boolean them_10) {
		this.them_10 = them_10;
	}

	public Boolean getSua_10() {
		return sua_10;
	}

	public void setSua_10(Boolean sua_10) {
		this.sua_10 = sua_10;
	}

	public Boolean getXoa_10() {
		return xoa_10;
	}

	public void setXoa_10(Boolean xoa_10) {
		this.xoa_10 = xoa_10;
	}

	public Boolean getBaoCao_10() {
		return baoCao_10;
	}

	public void setBaoCao_10(Boolean baoCao_10) {
		this.baoCao_10 = baoCao_10;
	}

	public List<PhanQuyen> getLstQuyenHan_11() {
		return lstQuyenHan_11;
	}

	public void setLstQuyenHan_11(List<PhanQuyen> lstQuyenHan_11) {
		this.lstQuyenHan_11 = lstQuyenHan_11;
	}

	public Boolean getDanhSach_11() {
		return danhSach_11;
	}

	public void setDanhSach_11(Boolean danhSach_11) {
		this.danhSach_11 = danhSach_11;
	}

	public Boolean getThem_11() {
		return them_11;
	}

	public void setThem_11(Boolean them_11) {
		this.them_11 = them_11;
	}

	public Boolean getSua_11() {
		return sua_11;
	}

	public void setSua_11(Boolean sua_11) {
		this.sua_11 = sua_11;
	}

	public Boolean getXoa_11() {
		return xoa_11;
	}

	public void setXoa_11(Boolean xoa_11) {
		this.xoa_11 = xoa_11;
	}

	public Boolean getBaoCao_11() {
		return baoCao_11;
	}

	public void setBaoCao_11(Boolean baoCao_11) {
		this.baoCao_11 = baoCao_11;
	}

	public List<PhanQuyen> getLstQuyenHan_12() {
		return lstQuyenHan_12;
	}

	public void setLstQuyenHan_12(List<PhanQuyen> lstQuyenHan_12) {
		this.lstQuyenHan_12 = lstQuyenHan_12;
	}

	public Boolean getDanhSach_12() {
		return danhSach_12;
	}

	public void setDanhSach_12(Boolean danhSach_12) {
		this.danhSach_12 = danhSach_12;
	}

	public Boolean getThem_12() {
		return them_12;
	}

	public void setThem_12(Boolean them_12) {
		this.them_12 = them_12;
	}

	public Boolean getSua_12() {
		return sua_12;
	}

	public void setSua_12(Boolean sua_12) {
		this.sua_12 = sua_12;
	}

	public Boolean getXoa_12() {
		return xoa_12;
	}

	public void setXoa_12(Boolean xoa_12) {
		this.xoa_12 = xoa_12;
	}

	public Boolean getBaoCao_12() {
		return baoCao_12;
	}

	public void setBaoCao_12(Boolean baoCao_12) {
		this.baoCao_12 = baoCao_12;
	}

	public List<PhanQuyen> getLstQuyenHan_13() {
		return lstQuyenHan_13;
	}

	public void setLstQuyenHan_13(List<PhanQuyen> lstQuyenHan_13) {
		this.lstQuyenHan_13 = lstQuyenHan_13;
	}

	public Boolean getDanhSach_13() {
		return danhSach_13;
	}

	public void setDanhSach_13(Boolean danhSach_13) {
		this.danhSach_13 = danhSach_13;
	}

	public Boolean getThem_13() {
		return them_13;
	}

	public void setThem_13(Boolean them_13) {
		this.them_13 = them_13;
	}

	public Boolean getSua_13() {
		return sua_13;
	}

	public void setSua_13(Boolean sua_13) {
		this.sua_13 = sua_13;
	}

	public Boolean getXoa_13() {
		return xoa_13;
	}

	public void setXoa_13(Boolean xoa_13) {
		this.xoa_13 = xoa_13;
	}

	public Boolean getBaoCao_13() {
		return baoCao_13;
	}

	public void setBaoCao_13(Boolean baoCao_13) {
		this.baoCao_13 = baoCao_13;
	}

	public List<PhanQuyen> getLstQuyenHan_14() {
		return lstQuyenHan_14;
	}

	public void setLstQuyenHan_14(List<PhanQuyen> lstQuyenHan_14) {
		this.lstQuyenHan_14 = lstQuyenHan_14;
	}

	public Boolean getDanhSach_14() {
		return danhSach_14;
	}

	public void setDanhSach_14(Boolean danhSach_14) {
		this.danhSach_14 = danhSach_14;
	}

	public Boolean getThem_14() {
		return them_14;
	}

	public void setThem_14(Boolean them_14) {
		this.them_14 = them_14;
	}

	public Boolean getSua_14() {
		return sua_14;
	}

	public void setSua_14(Boolean sua_14) {
		this.sua_14 = sua_14;
	}

	public Boolean getXoa_14() {
		return xoa_14;
	}

	public void setXoa_14(Boolean xoa_14) {
		this.xoa_14 = xoa_14;
	}

	public Boolean getBaoCao_14() {
		return baoCao_14;
	}

	public void setBaoCao_14(Boolean baoCao_14) {
		this.baoCao_14 = baoCao_14;
	}

	public List<PhanQuyen> getLstQuyenHan_15() {
		return lstQuyenHan_15;
	}

	public void setLstQuyenHan_15(List<PhanQuyen> lstQuyenHan_15) {
		this.lstQuyenHan_15 = lstQuyenHan_15;
	}

	public Boolean getDanhSach_15() {
		return danhSach_15;
	}

	public void setDanhSach_15(Boolean danhSach_15) {
		this.danhSach_15 = danhSach_15;
	}

	public Boolean getThem_15() {
		return them_15;
	}

	public void setThem_15(Boolean them_15) {
		this.them_15 = them_15;
	}

	public Boolean getSua_15() {
		return sua_15;
	}

	public void setSua_15(Boolean sua_15) {
		this.sua_15 = sua_15;
	}

	public Boolean getXoa_15() {
		return xoa_15;
	}

	public void setXoa_15(Boolean xoa_15) {
		this.xoa_15 = xoa_15;
	}

	public Boolean getBaoCao_15() {
		return baoCao_15;
	}

	public void setBaoCao_15(Boolean baoCao_15) {
		this.baoCao_15 = baoCao_15;
	}

	public List<PhanQuyen> getLstQuyenHan_16() {
		return lstQuyenHan_16;
	}

	public void setLstQuyenHan_16(List<PhanQuyen> lstQuyenHan_16) {
		this.lstQuyenHan_16 = lstQuyenHan_16;
	}

	public Boolean getDanhSach_16() {
		return danhSach_16;
	}

	public void setDanhSach_16(Boolean danhSach_16) {
		this.danhSach_16 = danhSach_16;
	}

	public Boolean getThem_16() {
		return them_16;
	}

	public void setThem_16(Boolean them_16) {
		this.them_16 = them_16;
	}

	public Boolean getSua_16() {
		return sua_16;
	}

	public void setSua_16(Boolean sua_16) {
		this.sua_16 = sua_16;
	}

	public Boolean getXoa_16() {
		return xoa_16;
	}

	public void setXoa_16(Boolean xoa_16) {
		this.xoa_16 = xoa_16;
	}

	public Boolean getBaoCao_16() {
		return baoCao_16;
	}

	public void setBaoCao_16(Boolean baoCao_16) {
		this.baoCao_16 = baoCao_16;
	}

	public List<PhanQuyen> getLstQuyenHan_17() {
		return lstQuyenHan_17;
	}

	public void setLstQuyenHan_17(List<PhanQuyen> lstQuyenHan_17) {
		this.lstQuyenHan_17 = lstQuyenHan_17;
	}

	public Boolean getDanhSach_17() {
		return danhSach_17;
	}

	public void setDanhSach_17(Boolean danhSach_17) {
		this.danhSach_17 = danhSach_17;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub

		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);

		StringBuffer url = request.getRequestURL();

		String queryString = request.getQueryString();

		String fullUrl = url + (queryString == null ? "" : ("?" + queryString));

		System.out.println("Url: " + url);
		System.out.println("Full: " + fullUrl);
		
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		
		if (session != null && !session.isEmpty()) {
			taiKhoanUser = (String) session.get("username");
			matKhauUser = (String) session.get("password");
			lstNguoiDung = nguoiDungDao.timKiemNguoiDungLogin(taiKhoanUser, matKhauUser);
			for (NguoiDung nd : lstNguoiDung) {
				vaiTroId = nd.getVaiTroId();
			}

			//Co doan Code nay thi khi logout ra login. Them action tren url la "ql..." no ko bi bug
			if(taiKhoanUser ==null) {         // Phai la "taiKhoanUser"																								
				HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
				response.sendRedirect("login");
				return "login";
			}
			
			if (vaiTroId == 1) {
//					for(i=1; i <= n; i++) {
				/**
				 * Quan Ly Loai
				 */
				lstQuyenHan_1 = phanQuyenDao.lstQuyenHan(1, 1);
				for (PhanQuyen qh_1 : lstQuyenHan_1) {

//					session.put("chucNang", 1);
//					System.out.println("ID CHUC NANG:" + session.get("chucNang"));

					danhSach_1 = qh_1.getDanhSach();
					session.put("danhSach_1", danhSach_1);

					them_1 = qh_1.getThem();
					session.put("them_1", them_1);
					sua_1 = qh_1.getSua();
					session.put("sua_1", sua_1);
					xoa_1 = qh_1.getXoa();
					session.put("xoa_1", xoa_1);
					baoCao_1 = qh_1.getBaoCao();
					session.put("baoCao_1", baoCao_1);
				}

				/**
				 * Quan Ly Chu De
				 */
				lstQuyenHan_2 = phanQuyenDao.lstQuyenHan(1, 2);
				for (PhanQuyen qh : lstQuyenHan_2) {

					danhSach_2 = qh.getDanhSach();
					session.put("danhSach_2", danhSach_2);

					them_2 = qh.getThem();
					session.put("them_2", them_2);

					sua_2 = qh.getSua();
					session.put("sua_2", sua_2);

					xoa_2 = qh.getXoa();
					session.put("xoa_2", xoa_2);

					baoCao_2 = qh.getBaoCao();
					session.put("baoCao_2", baoCao_2);
				}

				/**
				 * Quan Ly Khoa Hoc
				 */
				lstQuyenHan_3 = phanQuyenDao.lstQuyenHan(1, 3);
				for (PhanQuyen qh : lstQuyenHan_3) {

					danhSach_3 = qh.getDanhSach();
					session.put("danhSach_3", danhSach_3);

					them_3 = qh.getThem();
					session.put("them_3", them_3);

					sua_3 = qh.getSua();
					session.put("sua_3", sua_3);

					xoa_3 = qh.getXoa();
					session.put("xoa_3", xoa_3);

					baoCao_3 = qh.getBaoCao();
					session.put("baoCao_3", baoCao_3);
				}

				/**
				 * Quan Ly Bai Giang
				 */
				lstQuyenHan_4 = phanQuyenDao.lstQuyenHan(1, 4);
				for (PhanQuyen qh : lstQuyenHan_4) {

					danhSach_4 = qh.getDanhSach();
					session.put("danhSach_4", danhSach_4);				

					them_4 = qh.getThem();
					session.put("them_4", them_4);

					sua_4 = qh.getSua();
					session.put("sua_4", sua_4);

					xoa_4 = qh.getXoa();
					session.put("xoa_4", xoa_4);

					baoCao_4 = qh.getBaoCao();
					session.put("baoCao_4", baoCao_4);
				}
				
				/**
				 * Quan Ly Nguoi Dung
				 */
				lstQuyenHan_5 = phanQuyenDao.lstQuyenHan(1, 5);
				for (PhanQuyen qh : lstQuyenHan_5) {

					danhSach_5 = qh.getDanhSach();
					session.put("danhSach_5", danhSach_5);				

					them_5 = qh.getThem();
					session.put("them_5", them_5);

					sua_5 = qh.getSua();
					session.put("sua_5", sua_5);

					xoa_5 = qh.getXoa();
					session.put("xoa_5", xoa_5);

					baoCao_5 = qh.getBaoCao();
					session.put("baoCao_5", baoCao_5);
				}
				
				/**
				 * Quan Ly Giang Vien
				 */
				lstQuyenHan_6 = phanQuyenDao.lstQuyenHan(1, 6);
				for (PhanQuyen qh : lstQuyenHan_6) {

					danhSach_6 = qh.getDanhSach();
					session.put("danhSach_6", danhSach_6);				

					them_6 = qh.getThem();
					session.put("them_6", them_6);

					sua_6 = qh.getSua();
					session.put("sua_6", sua_6);

					xoa_6 = qh.getXoa();
					session.put("xoa_6", xoa_6);

					baoCao_6 = qh.getBaoCao();
					session.put("baoCao_6", baoCao_6);
				}
				
				/**
				 * Quan Ly Khach Hang
				 */
				lstQuyenHan_7 = phanQuyenDao.lstQuyenHan(1, 7);
				for (PhanQuyen qh : lstQuyenHan_7) {

					danhSach_7 = qh.getDanhSach();
					session.put("danhSach_7", danhSach_7);				

					them_7 = qh.getThem();
					session.put("them_7", them_7);

					sua_7 = qh.getSua();
					session.put("sua_7", sua_7);

					xoa_7 = qh.getXoa();
					session.put("xoa_7", xoa_7);

					baoCao_7 = qh.getBaoCao();
					session.put("baoCao_7", baoCao_7);
				}
				
				/**
				 * Quan Ly Cap Do   (chua co trang jsp)
				 */
				lstQuyenHan_8 = phanQuyenDao.lstQuyenHan(1, 8);
				for (PhanQuyen qh : lstQuyenHan_8) {

					danhSach_8 = qh.getDanhSach();
					session.put("danhSach_8", danhSach_8);				

					them_8 = qh.getThem();
					session.put("them_8", them_8);

					sua_8 = qh.getSua();
					session.put("sua_8", sua_8);

					xoa_8 = qh.getXoa();
					session.put("xoa_8", xoa_8);

					baoCao_8 = qh.getBaoCao();
					session.put("baoCao_8", baoCao_8);
				}
				
				/**
				 * Quan Ly Vai Tro
				 */
				lstQuyenHan_9 = phanQuyenDao.lstQuyenHan(1, 9);
				for (PhanQuyen qh : lstQuyenHan_9) {

					danhSach_9 = qh.getDanhSach();
					session.put("danhSach_9", danhSach_9);				

					them_9 = qh.getThem();
					session.put("them_9", them_9);

					sua_9 = qh.getSua();
					session.put("sua_9", sua_9);

					xoa_9 = qh.getXoa();
					session.put("xoa_9", xoa_9);

					baoCao_9 = qh.getBaoCao();
					session.put("baoCao_9", baoCao_9);
				}
				
				/**
				 * Quan Ly Phan Quyen
				 */
				lstQuyenHan_10 = phanQuyenDao.lstQuyenHan(1, 10);
				for (PhanQuyen qh : lstQuyenHan_10) {

					danhSach_10 = qh.getDanhSach();
					session.put("danhSach_10", danhSach_10);				

					them_10 = qh.getThem();
					session.put("them_10", them_10);

					sua_10 = qh.getSua();
					session.put("sua_10", sua_10);

					xoa_10 = qh.getXoa();
					session.put("xoa_10", xoa_10);

					baoCao_10 = qh.getBaoCao();
					session.put("baoCao_10", baoCao_10);
				}
				
				/**
				 * Quan Ly Hoa Don
				 */
				lstQuyenHan_11 = phanQuyenDao.lstQuyenHan(1, 11);
				for (PhanQuyen qh : lstQuyenHan_11) {

					danhSach_11 = qh.getDanhSach();
					session.put("danhSach_11", danhSach_11);				

					them_11 = qh.getThem();
					session.put("them_11", them_11);

					sua_11 = qh.getSua();
					session.put("sua_11", sua_11);

					xoa_11 = qh.getXoa();
					session.put("xoa_11", xoa_11);

					baoCao_11 = qh.getBaoCao();
					session.put("baoCao_11", baoCao_11);
				}
				
				/**
				 * Quan Ly Nhan Xet (chua co trang jsp)
				 */
				lstQuyenHan_12 = phanQuyenDao.lstQuyenHan(1, 12);
				for (PhanQuyen qh : lstQuyenHan_12) {

					danhSach_12 = qh.getDanhSach();
					session.put("danhSach_12", danhSach_12);				

					them_12 = qh.getThem();
					session.put("them_12", them_12);

					sua_12 = qh.getSua();
					session.put("sua_12", sua_12);

					xoa_12 = qh.getXoa();
					session.put("xoa_12", xoa_12);

					baoCao_12 = qh.getBaoCao();
					session.put("baoCao_12", baoCao_12);
				}		
				
				/**
				 * Quan Ly Nhat Ky
				 */
				lstQuyenHan_13 = phanQuyenDao.lstQuyenHan(1, 13);
				for (PhanQuyen qh : lstQuyenHan_13) {

					danhSach_13 = qh.getDanhSach();
					session.put("danhSach_13", danhSach_13);				

					them_13 = qh.getThem();
					session.put("them_13", them_13);

					sua_13 = qh.getSua();
					session.put("sua_13", sua_13);

					xoa_13 = qh.getXoa();
					session.put("xoa_13", xoa_13);

					baoCao_13 = qh.getBaoCao();
					session.put("baoCao_13", baoCao_13);
				}
				
				/**
				 * Quan Ly Chuc Nang
				 */
				lstQuyenHan_14 = phanQuyenDao.lstQuyenHan(1, 14);
				for (PhanQuyen qh : lstQuyenHan_14) {

					danhSach_14 = qh.getDanhSach();
					session.put("danhSach_14", danhSach_14);				

					them_14 = qh.getThem();
					session.put("them_14", them_14);

					sua_14 = qh.getSua();
					session.put("sua_14", sua_14);

					xoa_14 = qh.getXoa();
					session.put("xoa_14", xoa_14);

					baoCao_14 = qh.getBaoCao();
					session.put("baoCao_14", baoCao_14);
				}
				
				/**
				 * Quan Ly NguoiDung_KhoaHoc
				 */
				lstQuyenHan_15 = phanQuyenDao.lstQuyenHan(1, 15);
				for (PhanQuyen qh : lstQuyenHan_15) {

					danhSach_15 = qh.getDanhSach();
					session.put("danhSach_15", danhSach_15);				

					them_15 = qh.getThem();
					session.put("them_15", them_15);

					sua_15 = qh.getSua();
					session.put("sua_15", sua_15);

					xoa_15 = qh.getXoa();
					session.put("xoa_15", xoa_15);

					baoCao_15 = qh.getBaoCao();
					session.put("baoCao_15", baoCao_15);
				}
				
				
				/**
				 * Quan Ly chiTietHoaDon
				 */
				lstQuyenHan_16 = phanQuyenDao.lstQuyenHan(1, 16);
				for (PhanQuyen qh : lstQuyenHan_16) {

					danhSach_16 = qh.getDanhSach();
					session.put("danhSach_16", danhSach_16);				

					them_16 = qh.getThem();
					session.put("them_16", them_16);

					sua_16 = qh.getSua();
					session.put("sua_16", sua_16);

					xoa_16 = qh.getXoa();
					session.put("xoa_16", xoa_16);

					baoCao_16 = qh.getBaoCao();
					session.put("baoCao_16", baoCao_16);
				}
				
				/**
				 * XEM BAI GIANG THEO KHOA HOC
				 */
				lstQuyenHan_17 = phanQuyenDao.lstQuyenHan(1, 17);
				for (PhanQuyen qh : lstQuyenHan_17) {
					danhSach_17 = qh.getDanhSach();
					session.put("danhSach_17", danhSach_17);								
				}
				
				return invocation.invoke();
			}
			
			
			/**
			 * VAI TRO ID = 2
			 */
			
			if (vaiTroId == 2) {
//				for(i=1; i <= n; i++) {

			/**
			 * Quan Ly Loai
			 */
			lstQuyenHan_1 = phanQuyenDao.lstQuyenHan(2, 1);
			for (PhanQuyen qh_1 : lstQuyenHan_1) {

				danhSach_1 = qh_1.getDanhSach();
				session.put("danhSach_1", danhSach_1);

				them_1 = qh_1.getThem();
				session.put("them_1", them_1);
				sua_1 = qh_1.getSua();
				session.put("sua_1", sua_1);
				xoa_1 = qh_1.getXoa();
				session.put("xoa_1", xoa_1);
				baoCao_1 = qh_1.getBaoCao();
				session.put("baoCao_1", baoCao_1);
			}

			/**
			 * Quan Ly Chu De
			 */
			lstQuyenHan_2 = phanQuyenDao.lstQuyenHan(2, 2);
			for (PhanQuyen qh : lstQuyenHan_2) {

				danhSach_2 = qh.getDanhSach();
				session.put("danhSach_2", danhSach_2);

				them_2 = qh.getThem();
				session.put("them_2", them_2);

				sua_2 = qh.getSua();
				session.put("sua_2", sua_2);

				xoa_2 = qh.getXoa();
				session.put("xoa_2", xoa_2);

				baoCao_2 = qh.getBaoCao();
				session.put("baoCao_2", baoCao_2);
			}

			/**
			 * Quan Ly Khoa Hoc
			 */
			lstQuyenHan_3 = phanQuyenDao.lstQuyenHan(2, 3);
			for (PhanQuyen qh : lstQuyenHan_3) {

				danhSach_3 = qh.getDanhSach();
				session.put("danhSach_3", danhSach_3);

				them_3 = qh.getThem();
				session.put("them_3", them_3);

				sua_3 = qh.getSua();
				session.put("sua_3", sua_3);

				xoa_3 = qh.getXoa();
				session.put("xoa_3", xoa_3);

				baoCao_3 = qh.getBaoCao();
				session.put("baoCao_3", baoCao_3);
			}

			/**
			 * Quan Ly Bai Giang
			 */
			lstQuyenHan_4 = phanQuyenDao.lstQuyenHan(2, 4);
			for (PhanQuyen qh : lstQuyenHan_4) {

				danhSach_4 = qh.getDanhSach();
				session.put("danhSach_4", danhSach_4);				

				them_4 = qh.getThem();
				session.put("them_4", them_4);

				sua_4 = qh.getSua();
				session.put("sua_4", sua_4);

				xoa_4 = qh.getXoa();
				session.put("xoa_4", xoa_4);

				baoCao_4 = qh.getBaoCao();
				session.put("baoCao_4", baoCao_4);
			}
			
			/**
			 * Quan Ly Nguoi Dung
			 */
			lstQuyenHan_5 = phanQuyenDao.lstQuyenHan(2, 5);
			for (PhanQuyen qh : lstQuyenHan_5) {

				danhSach_5 = qh.getDanhSach();
				session.put("danhSach_5", danhSach_5);				

				them_5 = qh.getThem();
				session.put("them_5", them_5);

				sua_5 = qh.getSua();
				session.put("sua_5", sua_5);

				xoa_5 = qh.getXoa();
				session.put("xoa_5", xoa_5);

				baoCao_5 = qh.getBaoCao();
				session.put("baoCao_5", baoCao_5);
			}
			
			/**
			 * Quan Ly Giang Vien
			 */
			lstQuyenHan_6 = phanQuyenDao.lstQuyenHan(2, 6);
			for (PhanQuyen qh : lstQuyenHan_6) {

				danhSach_6 = qh.getDanhSach();
				session.put("danhSach_6", danhSach_6);				

				them_6 = qh.getThem();
				session.put("them_6", them_6);

				sua_6 = qh.getSua();
				session.put("sua_6", sua_6);

				xoa_6 = qh.getXoa();
				session.put("xoa_6", xoa_6);

				baoCao_6 = qh.getBaoCao();
				session.put("baoCao_6", baoCao_6);
			}
			
			/**
			 * Quan Ly Khach Hang
			 */
			lstQuyenHan_7 = phanQuyenDao.lstQuyenHan(2, 7);
			for (PhanQuyen qh : lstQuyenHan_7) {

				danhSach_7 = qh.getDanhSach();
				session.put("danhSach_7", danhSach_7);				

				them_7 = qh.getThem();
				session.put("them_7", them_7);

				sua_7 = qh.getSua();
				session.put("sua_7", sua_7);

				xoa_7 = qh.getXoa();
				session.put("xoa_7", xoa_7);

				baoCao_7 = qh.getBaoCao();
				session.put("baoCao_7", baoCao_7);
			}
			
			/**
			 * Quan Ly Cap Do   (chua co trang jsp)
			 */
			lstQuyenHan_8 = phanQuyenDao.lstQuyenHan(2, 8);
			for (PhanQuyen qh : lstQuyenHan_8) {

				danhSach_8 = qh.getDanhSach();
				session.put("danhSach_8", danhSach_8);				

				them_8 = qh.getThem();
				session.put("them_8", them_8);

				sua_8 = qh.getSua();
				session.put("sua_8", sua_8);

				xoa_8 = qh.getXoa();
				session.put("xoa_8", xoa_8);

				baoCao_8 = qh.getBaoCao();
				session.put("baoCao_8", baoCao_8);
			}
			
			/**
			 * Quan Ly Vai Tro
			 */
			lstQuyenHan_9 = phanQuyenDao.lstQuyenHan(2, 9);
			for (PhanQuyen qh : lstQuyenHan_9) {

				danhSach_9 = qh.getDanhSach();
				session.put("danhSach_9", danhSach_9);				

				them_9 = qh.getThem();
				session.put("them_9", them_9);

				sua_9 = qh.getSua();
				session.put("sua_9", sua_9);

				xoa_9 = qh.getXoa();
				session.put("xoa_9", xoa_9);

				baoCao_9 = qh.getBaoCao();
				session.put("baoCao_9", baoCao_9);
			}
			
			/**
			 * Quan Ly Phan Quyen
			 */
			lstQuyenHan_10 = phanQuyenDao.lstQuyenHan(2, 10);
			for (PhanQuyen qh : lstQuyenHan_10) {

				danhSach_10 = qh.getDanhSach();
				session.put("danhSach_10", danhSach_10);				

				them_10 = qh.getThem();
				session.put("them_10", them_10);

				sua_10 = qh.getSua();
				session.put("sua_10", sua_10);

				xoa_10 = qh.getXoa();
				session.put("xoa_10", xoa_10);

				baoCao_10 = qh.getBaoCao();
				session.put("baoCao_10", baoCao_10);
			}
			
			/**
			 * Quan Ly Hoa Don
			 */
			lstQuyenHan_11 = phanQuyenDao.lstQuyenHan(2, 11);
			for (PhanQuyen qh : lstQuyenHan_11) {

				danhSach_11 = qh.getDanhSach();
				session.put("danhSach_11", danhSach_11);				

				them_11 = qh.getThem();
				session.put("them_11", them_11);

				sua_11 = qh.getSua();
				session.put("sua_11", sua_11);

				xoa_11 = qh.getXoa();
				session.put("xoa_11", xoa_11);

				baoCao_11 = qh.getBaoCao();
				session.put("baoCao_11", baoCao_11);
			}
			
			/**
			 * Quan Ly Nhan Xet (chua co trang jsp)
			 */
			lstQuyenHan_12 = phanQuyenDao.lstQuyenHan(2, 12);
			for (PhanQuyen qh : lstQuyenHan_12) {

				danhSach_12 = qh.getDanhSach();
				session.put("danhSach_12", danhSach_12);				

				them_12 = qh.getThem();
				session.put("them_12", them_12);

				sua_12 = qh.getSua();
				session.put("sua_12", sua_12);

				xoa_12 = qh.getXoa();
				session.put("xoa_12", xoa_12);

				baoCao_12 = qh.getBaoCao();
				session.put("baoCao_12", baoCao_12);
			}		
					
			/**
			 * Quan Ly Nhat Ky
			 */
			lstQuyenHan_13 = phanQuyenDao.lstQuyenHan(2, 13);
			for (PhanQuyen qh : lstQuyenHan_13) {

				danhSach_13 = qh.getDanhSach();
				session.put("danhSach_13", danhSach_13);				

				them_13 = qh.getThem();
				session.put("them_13", them_13);

				sua_13 = qh.getSua();
				session.put("sua_13", sua_13);

				xoa_13 = qh.getXoa();
				session.put("xoa_13", xoa_13);

				baoCao_13 = qh.getBaoCao();
				session.put("baoCao_13", baoCao_13);
			}
			
			/**
			 * Quan Ly Chuc Nang
			 */
			lstQuyenHan_14 = phanQuyenDao.lstQuyenHan(2, 14);
			for (PhanQuyen qh : lstQuyenHan_14) {

				danhSach_14 = qh.getDanhSach();
				session.put("danhSach_14", danhSach_14);				

				them_14 = qh.getThem();
				session.put("them_14", them_14);

				sua_14 = qh.getSua();
				session.put("sua_14", sua_14);

				xoa_14 = qh.getXoa();
				session.put("xoa_14", xoa_14);

				baoCao_14 = qh.getBaoCao();
				session.put("baoCao_14", baoCao_14);
			}
			
			/**
			 * Quan Ly NguoiDung_KhoaHoc
			 */
			lstQuyenHan_15 = phanQuyenDao.lstQuyenHan(2, 15);
			for (PhanQuyen qh : lstQuyenHan_15) {

				danhSach_15 = qh.getDanhSach();
				session.put("danhSach_15", danhSach_15);				

				them_15 = qh.getThem();
				session.put("them_15", them_15);

				sua_15 = qh.getSua();
				session.put("sua_15", sua_15);

				xoa_15 = qh.getXoa();
				session.put("xoa_15", xoa_15);

				baoCao_15 = qh.getBaoCao();
				session.put("baoCao_15", baoCao_15);
			}
						
			/**
			 * Quan Ly chiTietHoaDon
			 */
			lstQuyenHan_16 = phanQuyenDao.lstQuyenHan(2, 16);
			for (PhanQuyen qh : lstQuyenHan_16) {

				danhSach_16 = qh.getDanhSach();
				session.put("danhSach_16", danhSach_16);				

				them_16 = qh.getThem();
				session.put("them_16", them_16);

				sua_16 = qh.getSua();
				session.put("sua_16", sua_16);

				xoa_16 = qh.getXoa();
				session.put("xoa_16", xoa_16);

				baoCao_16 = qh.getBaoCao();
				session.put("baoCao_16", baoCao_16);
			}
			
			/**
			 * XEM BAI GIANG THEO KHOA HOC
			 */
			lstQuyenHan_17 = phanQuyenDao.lstQuyenHan(2, 17);
			for (PhanQuyen qh : lstQuyenHan_17) {
				danhSach_17 = qh.getDanhSach();
				session.put("danhSach_17", danhSach_17);								
			}
			
			return invocation.invoke();
		}
			
			/**
			 * VAI TRO ID = 3
			 */
			
			if (vaiTroId == 3) {
//				for(i=1; i <= n; i++) {

			/**
			 * Quan Ly Loai
			 */
			lstQuyenHan_1 = phanQuyenDao.lstQuyenHan(3, 1);
			for (PhanQuyen qh_1 : lstQuyenHan_1) {
			
				danhSach_1 = qh_1.getDanhSach();
				session.put("danhSach_1", danhSach_1);
				
				them_1 = qh_1.getThem();
				session.put("them_1", them_1);
				sua_1 = qh_1.getSua();
				session.put("sua_1", sua_1);
				xoa_1 = qh_1.getXoa();
				session.put("xoa_1", xoa_1);
				baoCao_1 = qh_1.getBaoCao();
				session.put("baoCao_1", baoCao_1);
			}

			/**
			 * Quan Ly Chu De
			 */
			lstQuyenHan_2 = phanQuyenDao.lstQuyenHan(3, 2);
			for (PhanQuyen qh : lstQuyenHan_2) {

				danhSach_2 = qh.getDanhSach();
				session.put("danhSach_2", danhSach_2);

				them_2 = qh.getThem();
				session.put("them_2", them_2);

				sua_2 = qh.getSua();
				session.put("sua_2", sua_2);

				xoa_2 = qh.getXoa();
				session.put("xoa_2", xoa_2);

				baoCao_2 = qh.getBaoCao();
				session.put("baoCao_2", baoCao_2);
			}

			/**
			 * Quan Ly Khoa Hoc
			 */
			lstQuyenHan_3 = phanQuyenDao.lstQuyenHan(3, 3);
			for (PhanQuyen qh : lstQuyenHan_3) {

				danhSach_3 = qh.getDanhSach();
				session.put("danhSach_3", danhSach_3);

				them_3 = qh.getThem();
				session.put("them_3", them_3);

				sua_3 = qh.getSua();
				session.put("sua_3", sua_3);

				xoa_3 = qh.getXoa();
				session.put("xoa_3", xoa_3);

				baoCao_3 = qh.getBaoCao();
				session.put("baoCao_3", baoCao_3);
			}

			/**
			 * Quan Ly Bai Giang
			 */
			lstQuyenHan_4 = phanQuyenDao.lstQuyenHan(3, 4);
			for (PhanQuyen qh : lstQuyenHan_4) {

				danhSach_4 = qh.getDanhSach();
				session.put("danhSach_4", danhSach_4);				

				them_4 = qh.getThem();
				session.put("them_4", them_4);

				sua_4 = qh.getSua();
				session.put("sua_4", sua_4);

				xoa_4 = qh.getXoa();
				session.put("xoa_4", xoa_4);

				baoCao_4 = qh.getBaoCao();
				session.put("baoCao_4", baoCao_4);
			}
			
			/**
			 * Quan Ly Nguoi Dung
			 */
			lstQuyenHan_5 = phanQuyenDao.lstQuyenHan(3, 5);
			for (PhanQuyen qh : lstQuyenHan_5) {

				danhSach_5 = qh.getDanhSach();
				session.put("danhSach_5", danhSach_5);				

				them_5 = qh.getThem();
				session.put("them_5", them_5);

				sua_5 = qh.getSua();
				session.put("sua_5", sua_5);

				xoa_5 = qh.getXoa();
				session.put("xoa_5", xoa_5);

				baoCao_5 = qh.getBaoCao();
				session.put("baoCao_5", baoCao_5);
			}
			
			/**
			 * Quan Ly Giang Vien
			 */
			lstQuyenHan_6 = phanQuyenDao.lstQuyenHan(3, 6);
			for (PhanQuyen qh : lstQuyenHan_6) {

				danhSach_6 = qh.getDanhSach();
				session.put("danhSach_6", danhSach_6);				

				them_6 = qh.getThem();
				session.put("them_6", them_6);

				sua_6 = qh.getSua();
				session.put("sua_6", sua_6);

				xoa_6 = qh.getXoa();
				session.put("xoa_6", xoa_6);

				baoCao_6 = qh.getBaoCao();
				session.put("baoCao_6", baoCao_6);
			}
			
			/**
			 * Quan Ly Khach Hang
			 */
			lstQuyenHan_7 = phanQuyenDao.lstQuyenHan(3, 7);
			for (PhanQuyen qh : lstQuyenHan_7) {

				danhSach_7 = qh.getDanhSach();
				session.put("danhSach_7", danhSach_7);				

				them_7 = qh.getThem();
				session.put("them_7", them_7);

				sua_7 = qh.getSua();
				session.put("sua_7", sua_7);

				xoa_7 = qh.getXoa();
				session.put("xoa_7", xoa_7);

				baoCao_7 = qh.getBaoCao();
				session.put("baoCao_7", baoCao_7);
			}
			
			/**
			 * Quan Ly Cap Do   (chua co trang jsp)
			 */
			lstQuyenHan_8 = phanQuyenDao.lstQuyenHan(3, 8);
			for (PhanQuyen qh : lstQuyenHan_8) {

				danhSach_8 = qh.getDanhSach();
				session.put("danhSach_8", danhSach_8);				

				them_8 = qh.getThem();
				session.put("them_8", them_8);

				sua_8 = qh.getSua();
				session.put("sua_8", sua_8);

				xoa_8 = qh.getXoa();
				session.put("xoa_8", xoa_8);

				baoCao_8 = qh.getBaoCao();
				session.put("baoCao_8", baoCao_8);
			}
			
			/**
			 * Quan Ly Vai Tro
			 */
			lstQuyenHan_9 = phanQuyenDao.lstQuyenHan(3, 9);
			for (PhanQuyen qh : lstQuyenHan_9) {

				danhSach_9 = qh.getDanhSach();
				session.put("danhSach_9", danhSach_9);				

				them_9 = qh.getThem();
				session.put("them_9", them_9);

				sua_9 = qh.getSua();
				session.put("sua_9", sua_9);

				xoa_9 = qh.getXoa();
				session.put("xoa_9", xoa_9);

				baoCao_9 = qh.getBaoCao();
				session.put("baoCao_9", baoCao_9);
			}
			
			/**
			 * Quan Ly Phan Quyen
			 */
			lstQuyenHan_10 = phanQuyenDao.lstQuyenHan(3, 10);
			for (PhanQuyen qh : lstQuyenHan_10) {

				danhSach_10 = qh.getDanhSach();
				session.put("danhSach_10", danhSach_10);				

				them_10 = qh.getThem();
				session.put("them_10", them_10);

				sua_10 = qh.getSua();
				session.put("sua_10", sua_10);

				xoa_10 = qh.getXoa();
				session.put("xoa_10", xoa_10);

				baoCao_10 = qh.getBaoCao();
				session.put("baoCao_10", baoCao_10);
			}
			
			/**
			 * Quan Ly Hoa Don
			 */
			lstQuyenHan_11 = phanQuyenDao.lstQuyenHan(3, 11);
			for (PhanQuyen qh : lstQuyenHan_11) {

				danhSach_11 = qh.getDanhSach();
				session.put("danhSach_11", danhSach_11);				

				them_11 = qh.getThem();
				session.put("them_11", them_11);

				sua_11 = qh.getSua();
				session.put("sua_11", sua_11);

				xoa_11 = qh.getXoa();
				session.put("xoa_11", xoa_11);

				baoCao_11 = qh.getBaoCao();
				session.put("baoCao_11", baoCao_11);
			}
			
			/**
			 * Quan Ly Nhan Xet (chua co trang jsp)
			 */
			lstQuyenHan_12 = phanQuyenDao.lstQuyenHan(3, 12);
			for (PhanQuyen qh : lstQuyenHan_12) {

				danhSach_12 = qh.getDanhSach();
				session.put("danhSach_12", danhSach_12);				

				them_12 = qh.getThem();
				session.put("them_12", them_12);

				sua_12 = qh.getSua();
				session.put("sua_12", sua_12);

				xoa_12 = qh.getXoa();
				session.put("xoa_12", xoa_12);

				baoCao_12 = qh.getBaoCao();
				session.put("baoCao_12", baoCao_12);
			}
			
			/**
			 * Quan Ly Nhat Ky
			 */
			lstQuyenHan_13 = phanQuyenDao.lstQuyenHan(3, 13);
			for (PhanQuyen qh : lstQuyenHan_13) {

				danhSach_13 = qh.getDanhSach();
				session.put("danhSach_13", danhSach_13);				

				them_13 = qh.getThem();
				session.put("them_13", them_13);

				sua_13 = qh.getSua();
				session.put("sua_13", sua_13);

				xoa_13 = qh.getXoa();
				session.put("xoa_13", xoa_13);

				baoCao_13 = qh.getBaoCao();
				session.put("baoCao_13", baoCao_13);
			}
			
			/**
			 * Quan Ly Chuc Nang
			 */
			lstQuyenHan_14 = phanQuyenDao.lstQuyenHan(3, 14);
			for (PhanQuyen qh : lstQuyenHan_14) {

				danhSach_14 = qh.getDanhSach();
				session.put("danhSach_14", danhSach_14);				

				them_14 = qh.getThem();
				session.put("them_14", them_14);

				sua_14 = qh.getSua();
				session.put("sua_14", sua_14);

				xoa_14 = qh.getXoa();
				session.put("xoa_14", xoa_14);

				baoCao_14 = qh.getBaoCao();
				session.put("baoCao_14", baoCao_14);
			}
			
			/**
			 * Quan Ly NguoiDung_KhoaHoc
			 */
			lstQuyenHan_15 = phanQuyenDao.lstQuyenHan(3, 15);
			for (PhanQuyen qh : lstQuyenHan_15) {

				danhSach_15 = qh.getDanhSach();
				session.put("danhSach_15", danhSach_15);				

				them_15 = qh.getThem();
				session.put("them_15", them_15);

				sua_15 = qh.getSua();
				session.put("sua_15", sua_15);

				xoa_15 = qh.getXoa();
				session.put("xoa_15", xoa_15);

				baoCao_15 = qh.getBaoCao();
				session.put("baoCao_15", baoCao_15);
			}
			
			/**
			 * Quan Ly chiTietHoaDon
			 */
			lstQuyenHan_16 = phanQuyenDao.lstQuyenHan(3, 16);
			for (PhanQuyen qh : lstQuyenHan_16) {

				danhSach_16 = qh.getDanhSach();
				session.put("danhSach_16", danhSach_16);				

				them_16 = qh.getThem();
				session.put("them_16", them_16);

				sua_16 = qh.getSua();
				session.put("sua_16", sua_16);

				xoa_16 = qh.getXoa();
				session.put("xoa_16", xoa_16);

				baoCao_16 = qh.getBaoCao();
				session.put("baoCao_16", baoCao_16);
			}
			/**
			 * XEM BAI GIANG THEO KHOA HOC
			 */
			lstQuyenHan_17 = phanQuyenDao.lstQuyenHan(3, 17);
			for (PhanQuyen qh : lstQuyenHan_17) {
				danhSach_17 = qh.getDanhSach();
				session.put("danhSach_17", danhSach_17);								
			}
			
			return invocation.invoke();
		}			
//			return invocation.invoke();
					
		} else {
			HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
			response.sendRedirect("login");
			return "login";
		}
		HttpServletResponse response = (HttpServletResponse) context.get(StrutsStatics.HTTP_RESPONSE);
		response.sendRedirect("login");
		return "login";
	}			
}
