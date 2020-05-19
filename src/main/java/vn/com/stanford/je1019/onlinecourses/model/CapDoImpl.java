package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.CapDo;

@Component
public class CapDoImpl implements CapDoDAO {

	@Override
	public List<CapDo> layDanhSach() {
		// Káº¿t ná»‘i Ä‘áº¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<CapDo> query = session.createQuery("from CapDo", CapDo.class); // Lá»—i á»Ÿ chá»— nÃ y

		// Láº¥y danh sÃ¡ch
		List<CapDo> lst = query.getResultList();
		tx.commit();

		// Tráº£ vá»� káº¿t quáº£
		return lst;
	}

	@Override
	public CapDo layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		CapDo objCapDo = session.get(CapDo.class, id);
		tx.commit();

		return objCapDo;
	}

	@Override
	public boolean themMoi(CapDo obj) {
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
	public boolean capNhat(CapDo obj) {
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
		CapDo objCapDo = session.get(CapDo.class, id);

		// Xoa doi tuong
		session.delete(objCapDo);
		tx.commit();

		return true;
	}

	@Override
	public List<CapDo> timKiemCapDoTheoTen(String tenCapDo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from CapDo where 1=1 ";

		if (!tenCapDo.isEmpty()) {
			strSQL += " and tenCapDo = '" + tenCapDo + "'";
		}
		
		
		TypedQuery<CapDo> query = session.createQuery(strSQL, CapDo.class);
	
		List<CapDo> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

}
