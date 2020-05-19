package vn.com.stanford.je1019.onlinecourses.action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;
import vn.com.stanford.je1019.onlinecourses.model.NguoiDungDAO;

public class DangNhapAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1716273712018103487L;

	@Autowired
	NguoiDungDAO nguoiDungDao;

	private List<NguoiDung> lstNguoiDung;

	private String username;
	private String password;
	private String taiKhoanAdmin;
	private String matKhauAdmin;
	private Boolean trangThaiTaiKhoan;

	public NguoiDungDAO getNguoiDungDao() {
		return nguoiDungDao;
	}

	public void setNguoiDungDao(NguoiDungDAO nguoiDungDao) {
		this.nguoiDungDao = nguoiDungDao;
	}

	public String getTaiKhoanAdmin() {
		return taiKhoanAdmin;
	}

	public void setTaiKhoanAdmin(String taiKhoanAdmin) {
		this.taiKhoanAdmin = taiKhoanAdmin;
	}

	public String getMatKhauAdmin() {
		return matKhauAdmin;
	}

	public void setMatKhauAdmin(String matKhauAdmin) {
		this.matKhauAdmin = matKhauAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<NguoiDung> getLstNguoiDung() {
		return lstNguoiDung;
	}

	public void setLstNguoiDung(List<NguoiDung> lstNguoiDung) {
		this.lstNguoiDung = lstNguoiDung;
	}

	public Boolean getTrangThaiTaiKhoan() {
		return trangThaiTaiKhoan;
	}

	public void setTrangThaiTaiKhoan(Boolean trangThaiTaiKhoan) {
		this.trangThaiTaiKhoan = trangThaiTaiKhoan;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public static String md5(String str) {
		String result = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
			BigInteger bigInteger = new BigInteger(1, digest.digest());
			result = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String doLogin() {
		// TODO Auto-generated method stub

		Map<String, Object> session = ActionContext.getContext().getSession();

		lstNguoiDung = nguoiDungDao.layDanhSach();
		for (NguoiDung objNguoiDung : lstNguoiDung) {
			taiKhoanAdmin = objNguoiDung.getTaiKhoan();
			matKhauAdmin = objNguoiDung.getMatKhau();
			trangThaiTaiKhoan = objNguoiDung.getTrangThai();

			System.out.println("ten tai khoan: " + username);
			System.out.println("Mat khau: " + password);

			if ((taiKhoanAdmin).equals(username) && (matKhauAdmin).equals(md5(password)) && (trangThaiTaiKhoan==true)) {
				session.put("username", username);
				session.put("password", md5(password));
				return SUCCESS;
			} else {
			}

		}
		addActionError("Ban can nhap thong tin chinh xac. Hoac Tai Khoan chua duoc phe duyet ");
		session.clear();

		return ERROR;
	}

	public String logout() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("username");
		session.remove("password");
		return SUCCESS;
	}

}
