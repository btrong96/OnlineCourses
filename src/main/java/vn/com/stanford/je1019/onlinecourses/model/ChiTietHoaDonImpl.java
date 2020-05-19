package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.ChiTietHoaDon;

@Component
public class ChiTietHoaDonImpl implements ChiTietHoaDonDAO {

	@Override
	public List<ChiTietHoaDon> layDanhSach() {
		// KÃ¡ÂºÂ¿t nÃ¡Â»â€˜i Ã„â€˜Ã¡ÂºÂ¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// KhÃ¡Â»Å¸i tÃ¡ÂºÂ¡o 1 phiÃƒÂªn giao dÃ¡Â»â€¹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<ChiTietHoaDon> query = session.createQuery("from ChiTietHoaDon", ChiTietHoaDon.class);

		// LÃ¡ÂºÂ¥y danh sÃƒÂ¡ch
		List<ChiTietHoaDon> lst = query.getResultList();
		tx.commit();

		// TrÃ¡ÂºÂ£ vÃ¡Â»ï¿½ kÃ¡ÂºÂ¿t quÃ¡ÂºÂ£
		return lst;
	}

	@Override
	public ChiTietHoaDon layChiTietTheoId(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		ChiTietHoaDon objChiTietHoaDon = (ChiTietHoaDon) session.get(ChiTietHoaDon.class, id.intValue());
		tx.commit();

		return objChiTietHoaDon;
	}

	@Override
	public boolean themMoi(ChiTietHoaDon obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(ChiTietHoaDon obj) {
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
		ChiTietHoaDon objChiTietHoaDon = session.get(ChiTietHoaDon.class, id);

		session.delete(objChiTietHoaDon);
		tx.commit();

		return true;
	}

	@Override
	public List<ChiTietHoaDon> layChiTietTheoHoaDon_Id(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate trong hibernate
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from ChiTietHoaDon where ";	
		strSQL += " hoaDonId =" + id ;
		
		TypedQuery<ChiTietHoaDon> query = session.createQuery(strSQL, ChiTietHoaDon.class);
		
		//láº¥y danh sÃ¡ch
		List<ChiTietHoaDon> lst = query.getResultList();
		tx.commit();

		//tráº£ vá»� danh sÃ¡ch
		return lst;
	}

}
