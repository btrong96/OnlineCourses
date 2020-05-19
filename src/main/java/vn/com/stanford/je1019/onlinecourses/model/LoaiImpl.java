package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.Loai;

@Component
public class LoaiImpl implements LoaiDAO {

	/**
	 * Ham lay danh sach tat ca loai tu database
	 * 
	 * @return danh sach loai
	 * 
	 */
	@Override
	public List<Loai> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<Loai> lstLoai = session.createQuery("from Loai", Loai.class).getResultList();
		tx.commit();

		return lstLoai;
	}

	/**
	 * Ham lay thong tin chi tiet theo id
	 * 
	 * @param id cua doi tuong can lay thong tin
	 * @return doi tuong can lay thong tin
	 * 
	 */
	@Override
	public Loai layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		Loai objLoai = session.get(Loai.class, id);
		tx.commit();

		return objLoai;
	}

	/**
	 * Ham them moi Loai
	 * 
	 * @param doi tuong them moi
	 * 
	 */
	@Override
	public boolean themMoi(Loai objLoai) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien them moi
		session.save(objLoai);
		tx.commit();

		return true;
	}

	/**
	 * Ham cap nhat thong tin mot loai
	 * 
	 * @param doi tuong can cap nhat thong tin
	 * 
	 */
	@Override
	public boolean capNhat(Loai objLoai) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien cap nhat
		session.update(objLoai);
		tx.commit();

		return true;
	}

	/**
	 * Ham xoa mot loai trong database
	 * 
	 * @param id cua doi tuong can xoa
	 * 
	 */
	@Override
	public boolean xoa(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay thong tin doi tuong can xoa
		Loai objLoai = session.get(Loai.class, id);

		// Xoa doi tuong
		session.delete(objLoai);
		tx.commit();

		return true;
	}

	@Override
	public List<Loai> timKiemLoaiTheoTen(String tenLoai) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from Loai where 1=1 ";

		if (!tenLoai.isEmpty()) {
			strSQL += " and tenLoai = '" + tenLoai + "'";
		}
		
		
		TypedQuery<Loai> query = session.createQuery(strSQL, Loai.class);
	
		List<Loai> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

}
