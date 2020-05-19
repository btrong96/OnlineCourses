package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.ChucNang;

@Component
public class ChucNangImpl implements ChucNangDAO {

	/**
	 * Hàm lấy danh sách tất cả chức năng từ db
	 * 
	 * @return danh sách chức năng
	 */
	@Override
	public List<ChucNang> layDanhSach() {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// Tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();
		// Lấy danh sách
		List<ChucNang> lstChucNang = session.createQuery("from ChucNang", ChucNang.class).getResultList();
		tx.commit();

		return lstChucNang;
	}

	/**
	 * Hàm lấy thông tin chi tiết theo id
	 * 
	 * @param id của đối tượng cần lấy thông tin
	 * 
	 * @return đối tượng cần lấy thông tin
	 */
	@Override
	public ChucNang layChiTietTheoId(Integer id) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lấy đối tượng cần tìm
		ChucNang objChucNang = session.get(ChucNang.class, id);
		tx.commit();
		return objChucNang;
	}

	/**
	 * Hàm thêm mới chức năng
	 * 
	 * @param đối tượng thêm mới
	 */

	@Override
	public boolean themMoi(ChucNang objChucNang) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thực hiện thêm mới
		session.save(objChucNang);
		tx.commit();
		return true;
	}

	/**
	 * Hàm cập nhật thông tin của chức năng
	 * 
	 * @param đối tượng cần cập nhật thông tin
	 */
	@Override
	public boolean capNhat(ChucNang objChucNang) {
		// Kết nối Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thực hiện cập nhật
		session.update(objChucNang);
		tx.commit();
		return true;
	}

	/**
	 * 
	 * Hàm xóa một chức năng
	 * 
	 * @param id của chức năng cần xóa
	 */
	@Override
	public boolean xoa(Integer id) {
		// Kết nối database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lấy thông tin chức năng cần xóa
		ChucNang objChucNang = session.get(ChucNang.class, id);

		// Xóa chức năng
		session.delete(objChucNang);
		tx.commit();
		return true;
	}
}
