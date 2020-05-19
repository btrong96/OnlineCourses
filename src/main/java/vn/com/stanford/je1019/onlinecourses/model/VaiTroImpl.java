package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.VaiTro;

@Component
public class VaiTroImpl implements VaiTroDAO {

	/**
	 * Hàm lấy danh sách tất cả vai trò từ db
	 * 
	 * @return danh sách vai trò
	 */
	@Override
	public List<VaiTro> layDanhSach() {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// Tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();
		// Lấy danh sách
		List<VaiTro> lstVaiTro = session.createQuery("from VaiTro", VaiTro.class).getResultList();
		tx.commit();

		return lstVaiTro;
	}

	/**
	 * Hàm lấy thông tin chi tiết theo id
	 * 
	 * @param id của đối tượng cần lấy thông tin
	 * 
	 * @return đối tượng cần lấy thông tin
	 */
	@Override
	public VaiTro layChiTietTheoId(Integer id) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lấy đối tượng cần tìm
		VaiTro objVaiTro = session.get(VaiTro.class, id);
		tx.commit();
		return objVaiTro;
	}

	/**
	 * Hàm thêm mới vai trò
	 * 
	 * @param đối tượng thêm mới
	 */

	@Override
	public boolean themMoi(VaiTro objVaiTro) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thực hiện thêm mới
		session.save(objVaiTro);
		tx.commit();
		return true;
	}

	/**
	 * Hàm cập nhật thông tin của vai trò
	 * 
	 * @param đối tượng cần cập nhật thông tin
	 */
	@Override
	public boolean capNhat(VaiTro objVaiTro) {
		// Kết nối Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thực hiện cập nhật
		session.update(objVaiTro);
		tx.commit();
		return true;
	}

	/**
	 * 
	 * Hàm xóa một vai trò
	 * 
	 * @param id của vai trò cần xóa
	 */
	@Override
	public boolean xoa(Integer id) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lấy thông tin vai trò cần xóa
		VaiTro objVaiTro = session.get(VaiTro.class, id);

		// Xóa vai trò
		session.delete(objVaiTro);
		tx.commit();
		return true;
	}
}
