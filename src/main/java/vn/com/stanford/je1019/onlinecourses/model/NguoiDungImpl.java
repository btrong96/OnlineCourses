package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.NguoiDung;

@Component
public class NguoiDungImpl implements NguoiDungDAO {

	/**
	 * HÃ m láº¥y danh sÃ¡ch táº¥t cáº£ ngÆ°á»�i dÃ¹ng tá»« db
	 * 
	 * @return danh sÃ¡ch ngÆ°á»�i dÃ¹ng
	 */
	@Override
	public List<NguoiDung> layDanhSach() {
		// Káº¿t ná»‘i database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// Táº¡o 1 phiÃªn giao dá»‹ch trong Hibernate
		Transaction tx = session.beginTransaction();
		// Láº¥y danh sÃ¡ch
		List<NguoiDung> lstNguoiDung = session.createQuery("from NguoiDung", NguoiDung.class).getResultList();
		tx.commit();

		return lstNguoiDung;
	}

	/**
	 * HÃ m láº¥y thÃ´ng tin chi tiáº¿t theo id
	 * 
	 * @param id cá»§a Ä‘á»‘i tÆ°á»£ng cáº§n láº¥y thÃ´ng tin
	 * 
	 * @return Ä‘á»‘i tÆ°á»£ng cáº§n láº¥y thÃ´ng tin
	 */
	@Override
	public NguoiDung layChiTietTheoId(Integer id) {
		// Káº¿t ná»‘i database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Láº¥y Ä‘á»‘i tÆ°á»£ng cáº§n tÃ¬m
		NguoiDung objNguoiDung = session.get(NguoiDung.class, id);
		tx.commit();
		return objNguoiDung;
	}

	/**
	 * HÃ m thÃªm má»›i ngÆ°á»�i dÃ¹ng
	 * 
	 * @param Ä‘á»‘i tÆ°á»£ng thÃªm má»›i
	 */

	@Override
	public boolean themMoi(NguoiDung objNguoiDung) {
		// Káº¿t ná»‘i database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thá»±c hiá»‡n thÃªm má»›i
		session.save(objNguoiDung);
		tx.commit();
		return true;
	}

	/**
	 * HÃ m cáº­p nháº­t thÃ´ng tin cá»§a ngÆ°á»�i dÃ¹ng
	 * 
	 * @param Ä‘á»‘i tÆ°á»£ng cáº§n cáº­p nháº­t thÃ´ng tin
	 */
	@Override
	public boolean capNhat(NguoiDung objNguoiDung) {
		// Káº¿t ná»‘i Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thá»±c hiá»‡n cáº­p nháº­t
		session.update(objNguoiDung);
		tx.commit();
		return true;
	}

	/**
	 * 
	 * HÃ m xÃ³a má»™t ngÆ°á»�i dÃ¹ng
	 * 
	 * @param id cá»§a ngÆ°á»�i dÃ¹ng cáº§n xÃ³a
	 */
	@Override
	public boolean xoa(Integer id) {
		// Káº¿t ná»‘i database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Láº¥y thÃ´ng tin chá»©c nÄƒng cáº§n xÃ³a
		NguoiDung objNguoiDung = session.get(NguoiDung.class, id);

		// XÃ³a chá»©c nÄƒng
		session.delete(objNguoiDung);
		tx.commit();
		return true;
	}

	@Override
	public List<NguoiDung> timKiemAD(Integer vaiTroId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from NguoiDung where";

		if (vaiTroId != null) {
			strSQL += " vaiTroId = " + vaiTroId;
		}

		TypedQuery<NguoiDung> query = session.createQuery(strSQL, NguoiDung.class);

		List<NguoiDung> lst = query.getResultList();

		tx.commit();

		return lst;
	}

	@Override
	public List<NguoiDung> timKiemNguoiDungLogin(String taiKhoan, String matKhau) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = " from NguoiDung where 1=1 ";
//		if (!taiKhoan.isEmpty()) {
			strSQL += " and taiKhoan = '" + taiKhoan + "'";
//		}
		strSQL += " and matKhau = '" + matKhau + "'";

		TypedQuery<NguoiDung> query = session.createQuery(strSQL, NguoiDung.class);
		List<NguoiDung> lst = query.getResultList();

		tx.commit();

		return lst;
	}

	@Override
	public List<NguoiDung> timKiemNguoiDungTheoTen(String taiKhoan) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from NguoiDung where 1=1 ";

		if (!taiKhoan.isEmpty()) {
			strSQL += " and taiKhoan = '" + taiKhoan + "'";
		}
		
		
		TypedQuery<NguoiDung> query = session.createQuery(strSQL, NguoiDung.class);
	
		List<NguoiDung> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

}
