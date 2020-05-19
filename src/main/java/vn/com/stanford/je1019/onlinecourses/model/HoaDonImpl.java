package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.HoaDon;

@Component
public class HoaDonImpl implements HoaDonDAO {

	@Override
	public List<HoaDon> layDanhSach() {
		// Káº¿t ná»‘i Ä‘áº¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<HoaDon> query = session.createQuery("from HoaDon", HoaDon.class);

		// Láº¥y danh sÃ¡ch
		List<HoaDon> lst = query.getResultList();
		tx.commit();

		// Tráº£ vá»� káº¿t quáº£
		return lst;
	}

	@Override
	public HoaDon layChiTietTheoId(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		HoaDon objHoaDon = session.get(HoaDon.class, id);
		tx.commit();

		return objHoaDon;
	}

	@Override
	public boolean themMoi(HoaDon obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(HoaDon obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.update(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean xoa(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();
		HoaDon objHoaDon = session.get(HoaDon.class, id);

		session.delete(objHoaDon);
		tx.commit();

		return true;
	}

}
