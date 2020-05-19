package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.PhanQuyen;

@Component
public class PhanQuyenImpl implements PhanQuyenDAO {

	@Override
	public List<PhanQuyen> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<PhanQuyen> lstPhanQuyen = session.createQuery("from PhanQuyen", PhanQuyen.class).getResultList();
		tx.commit();

		return lstPhanQuyen;
	}

	@Override
	public PhanQuyen layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		PhanQuyen objPhanQuyen = session.get(PhanQuyen.class, id);
		tx.commit();

		return objPhanQuyen;
	}

	@Override
	public boolean themMoi(PhanQuyen obj) {
		/// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien them moi
		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(PhanQuyen obj) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.update(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean xoa(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay thong tin doi tuong can xoa
		PhanQuyen objPhanQuyen = session.get(PhanQuyen.class, id);

		// Xoa doi tuong
		session.delete(objPhanQuyen);
		tx.commit();

		return true;
	}

	@Override
	public List<PhanQuyen> lstQuyenHan(Integer vaiTro, Integer chucNang) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = " from PhanQuyen where 1=1 ";
		if (vaiTro != null) {
			strSQL += " and vaitro_id = " + vaiTro;
		}
		strSQL += " and chucnang_id = " + chucNang;

		TypedQuery<PhanQuyen> query = session.createQuery(strSQL, PhanQuyen.class);
		List<PhanQuyen> lst = query.getResultList();

		tx.commit();

		return lst;
	}

	
}
