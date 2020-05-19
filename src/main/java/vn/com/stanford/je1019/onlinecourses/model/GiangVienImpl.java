package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.GiangVien;

@Component
public class GiangVienImpl implements GiangVienDAO {

	@Override
	public List<GiangVien> layDanhSach() {
		//KÃ¡ÂºÂ¿t nÃ¡Â»â€˜i Ã„â€˜Ã¡ÂºÂ¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// KhÃ¡Â»Å¸i tÃ¡ÂºÂ¡o 1 phiÃƒÂªn giao dÃ¡Â»â€¹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<GiangVien> query = session.createQuery("from GiangVien", GiangVien.class);

		//LÃ¡ÂºÂ¥y danh sÃƒÂ¡ch
		List<GiangVien> lst = query.getResultList();
		tx.commit();

		//TrÃ¡ÂºÂ£ vÃ¡Â»ï¿½ kÃ¡ÂºÂ¿t quÃ¡ÂºÂ£
		return lst;
	}

	@Override
	public GiangVien layChiTietTheoId(Integer id) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		GiangVien objGiangVien =(GiangVien) session.get(GiangVien.class, id.intValue());
		tx.commit();
		
		return objGiangVien;
	}

	@Override
	public boolean themMoi(GiangVien obj) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(obj);
		tx.commit();
		
		return true;
	}

	@Override
	public boolean capNhat(GiangVien obj) {
		
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
		GiangVien objGiangVien = session.get(GiangVien.class, id);
		
		session.delete(objGiangVien);
		tx.commit();
		
		return true;
	}

	@Override
	public List<GiangVien> timKiemGiangVien(String tuKhoa) {
		         //Khá»Ÿi táº¡o phiÃªn giao dá»‹ch qua hibernate
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();

				// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate trong hibernate
				Transaction tx = session.beginTransaction();
				
				String strSQL = " from GiangVien where 1=1 ";
				if (!tuKhoa.isEmpty()) {
				strSQL += " and tenGiangVien like '%" + tuKhoa + "%'" ;
				}
				
				TypedQuery<GiangVien> query = session.createQuery(strSQL, GiangVien.class);
				
				//láº¥y danh sÃ¡ch
				List<GiangVien> lst = query.getResultList();
				tx.commit();

				//tráº£ vá»� danh sÃ¡ch
				return lst;
	}

}
