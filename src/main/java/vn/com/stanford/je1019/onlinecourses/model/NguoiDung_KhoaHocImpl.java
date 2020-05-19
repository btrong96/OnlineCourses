package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung_KhoaHoc;

@Component
public class NguoiDung_KhoaHocImpl implements NguoiDung_KhoaHocDAO {

	@Override
	public List<NguoiDung_KhoaHoc> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<NguoiDung_KhoaHoc> lstNguoiDung_KhoaHoc = session
				.createQuery("from NguoiDung_KhoaHoc", NguoiDung_KhoaHoc.class).getResultList();
		tx.commit();

		return lstNguoiDung_KhoaHoc;
	}

	@Override
	public NguoiDung_KhoaHoc layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = session.get(NguoiDung_KhoaHoc.class, id);
		tx.commit();

		return objNguoiDung_KhoaHoc;
	}

	@Override
	public boolean themMoi(NguoiDung_KhoaHoc obj) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien them moi
		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(NguoiDung_KhoaHoc obj) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien cap nhat
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
		NguoiDung_KhoaHoc objNguoiDung_KhoaHoc = session.get(NguoiDung_KhoaHoc.class, id);

		// Xoa doi tuong
		session.delete(objNguoiDung_KhoaHoc);
		tx.commit();

		return true;
	}

	@Override
	public List<NguoiDung_KhoaHoc> timKiemNguoiDung_KhoaHoc(Integer maNguoiDungTimKiem, Integer maKhoaHocTimKiem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = " from NguoiDung_KhoaHoc where 1=1 ";

		if (maNguoiDungTimKiem != null) {
			strSQL += " and nguoiDungId  = " + maNguoiDungTimKiem ;
		}
		if (maKhoaHocTimKiem != null) {
			strSQL += " and khoaHocId  = " + maKhoaHocTimKiem ;
		}
		
		
		TypedQuery<NguoiDung_KhoaHoc> query = session.createQuery(strSQL, NguoiDung_KhoaHoc.class);

		List<NguoiDung_KhoaHoc> lst = query.getResultList();

		tx.commit();
		return lst;
	}

	@Override
	public List<NguoiDung_KhoaHoc> timKiemNguoiDung_KhoaHocTheoNguoiDungId(Integer maNguoiDungTimKiem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = " from NguoiDung_KhoaHoc where 1=1 ";

		if (maNguoiDungTimKiem != null) {
			strSQL += " and nguoiDungId  = " + maNguoiDungTimKiem ;
		}
		
				
		TypedQuery<NguoiDung_KhoaHoc> query = session.createQuery(strSQL, NguoiDung_KhoaHoc.class);

		List<NguoiDung_KhoaHoc> lst = query.getResultList();

		tx.commit();
		return lst;
	}

}
