package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.ChuDe;

@Component
public class ChuDeImpl implements ChuDeDAO {

	/**
	 * Ham lay danh sach tat ca chu de tu database
	 * 
	 * @return danh sach tat ca chu de
	 * 
	 */
	@Override
	public List<ChuDe> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<ChuDe> lstChuDe = session.createQuery("from ChuDe", ChuDe.class).getResultList();
		tx.commit();

		return lstChuDe;
	}

	/**
	 * Ham tim thong tin chu de trong database theo id
	 * 
	 * @param id cua chu de can tim
	 * @return chu de tim duoc
	 * 
	 */
	@Override
	public ChuDe layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		ChuDe objChuDe = session.get(ChuDe.class, id);
		tx.commit();

		return objChuDe;
	}

	/**
	 * Ham them moi chu de vao database
	 * 
	 * @param doi tuong chu de can them
	 * 
	 */
	@Override
	public boolean themMoi(ChuDe objChuDe) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien them moi
		session.save(objChuDe);
		tx.commit();

		return true;
	}

	/**
	 * Ham cap nhat thong tin chu de vao database
	 * 
	 * @param doi tuong chu de can cap nhat thong tin
	 * 
	 */
	@Override
	public boolean capNhat(ChuDe objChuDe) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Thuc hien cap nhat
		session.update(objChuDe);
		tx.commit();

		return true;
	}

	/**
	 * Ham xoa mot chu de trong database
	 * 
	 * @param id cua chu de can xoa
	 * 
	 */
	@Override
	public boolean xoa(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay thong tin doi tuong can xoa
		ChuDe objChuDe = session.get(ChuDe.class, id);

		// Xoa doi tuong
		session.delete(objChuDe);
		tx.commit();

		return true;
	}

	@Override
	public List<ChuDe> timKiemChuDeTheoLoai(Integer maLoaiTimKiem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from ChuDe where 1=1 ";

		if (maLoaiTimKiem != null) {
			strSQL += " and loaiId = " + maLoaiTimKiem ;
		}
		
		TypedQuery<ChuDe> query = session.createQuery(strSQL, ChuDe.class);
		List<ChuDe> lst = query.getResultList();
		tx.commit();
		return lst;
	}

	@Override
	public List<ChuDe> timKiemChuDeTheoTen(String tenChuDe) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from ChuDe where 1=1 ";

		if (!tenChuDe.isEmpty()) {
			strSQL += " and tenChuDe = '" + tenChuDe + "'";
		}
		
		
		TypedQuery<ChuDe> query = session.createQuery(strSQL, ChuDe.class);
	
		List<ChuDe> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

}
