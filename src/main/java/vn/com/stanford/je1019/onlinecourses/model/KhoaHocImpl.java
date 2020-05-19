package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.KhoaHoc;

@Component
public class KhoaHocImpl implements KhoaHocDAO {

	@Override
	public List<KhoaHoc> layDanhSach() {
		// Káº¿t ná»‘i Ä‘áº¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<KhoaHoc> query = session.createQuery("from KhoaHoc", KhoaHoc.class);

		// Láº¥y danh sÃ¡ch
		List<KhoaHoc> lst = query.getResultList();
		tx.commit();

		// Tráº£ vá»� káº¿t quáº£
		return lst;
	}

	@Override
	public KhoaHoc layChiTietTheoId(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		KhoaHoc objKhoaHoc = session.get(KhoaHoc.class, id);
		tx.commit();

		return objKhoaHoc;
	}

	@Override
	public boolean themMoi(KhoaHoc obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(KhoaHoc obj) {
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
		KhoaHoc objKhoaHoc = session.get(KhoaHoc.class, id);

		session.delete(objKhoaHoc);
		tx.commit();

		return true;
	}

	@Override
	public List<KhoaHoc> timKiemKhoaHoc(String tuKhoa, Integer maChuDeTimKiem, Integer maCapDoTimKiem, Integer maGiangVienTimKiem) {
		// Káº¿t ná»‘i Ä‘áº¿n db qua hibernate
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();

				// Khá»Ÿi 1 phiÃªn giao dá»‹ch trong hibernate
				Transaction tx = session.beginTransaction();

				String strSQL = " from KhoaHoc where 1=1 ";

				if (!tuKhoa.isEmpty()) {
					strSQL += " and tenKhoaHoc like '%" + tuKhoa + "%'";
				}
				
					strSQL += " and chuDeId = " + maChuDeTimKiem;
					strSQL += " and capDoId = " + maCapDoTimKiem;
					strSQL += " and giangVienId = " + maGiangVienTimKiem;
				
				TypedQuery<KhoaHoc> query = session.createQuery(strSQL, KhoaHoc.class);
				// Láº¥y danh sÃ¡ch
				List<KhoaHoc> lst = query.getResultList();

				tx.commit();
				// Tráº£ vá»� káº¿t quáº£
				return lst;
	}

	@Override
	public List<KhoaHoc> timKiemKhoaHocTheoChuDe_CapDo(Integer maChuDeTimKiem,Integer maCapDoTimKiem, Boolean daDuyet) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from KhoaHoc where 1=1 ";

		if (maChuDeTimKiem != null) {
			strSQL += " and chuDeId = " + maChuDeTimKiem ;
		}
		if (maCapDoTimKiem != null) {
			strSQL += " and capDoId = " + maCapDoTimKiem ;
		}
		strSQL += " and daDuyet = " + daDuyet ;
		
		TypedQuery<KhoaHoc> query = session.createQuery(strSQL, KhoaHoc.class);
		List<KhoaHoc> lst = query.getResultList();
		tx.commit();
		return lst;
	}

	@Override
	public List<KhoaHoc> timKiemKhoaHocDaDuyet(Boolean daDuyet) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from KhoaHoc where 1=1 ";
		
		strSQL += " and daDuyet = " + daDuyet ;
		
		TypedQuery<KhoaHoc> query = session.createQuery(strSQL, KhoaHoc.class);
		List<KhoaHoc> lst = query.getResultList();
		tx.commit();
		return lst;
	}

	@Override
	public List<KhoaHoc> timKiemKhoaHocTheoTen(String tenKhoaHoc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from KhoaHoc where 1=1 ";

		if (!tenKhoaHoc.isEmpty()) {
			strSQL += " and tenKhoaHoc = '" + tenKhoaHoc + "'";
		}
		
		
		TypedQuery<KhoaHoc> query = session.createQuery(strSQL, KhoaHoc.class);
	
		List<KhoaHoc> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

	@Override
	public List<KhoaHoc> timKiemKhoaHocMienPhi(Boolean mienPhi) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from KhoaHoc where 1=1 ";
		
		strSQL += " and mienPhi = " + mienPhi ;
		
		TypedQuery<KhoaHoc> query = session.createQuery(strSQL, KhoaHoc.class);
		List<KhoaHoc> lst = query.getResultList();
		tx.commit();
		return lst;
	}

}
