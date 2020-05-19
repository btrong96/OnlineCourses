package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.NhanXet;

@Component
public class NhanXetImpl implements NhanXetDAO {

	@Override
	public List<NhanXet> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<NhanXet> lstNhanXet = session.createQuery("from NhanXet", NhanXet.class).getResultList();
		tx.commit();

		return lstNhanXet;
	}

	@Override
	public NhanXet layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		NhanXet objNhanXet = session.get(NhanXet.class, id);
		tx.commit();

		return objNhanXet;
	}

	@Override
	public boolean themMoi(NhanXet obj) {
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
	public boolean capNhat(NhanXet obj) {
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
		NhanXet objNhanXet = session.get(NhanXet.class, id);

		// Xoa doi tuong
		session.delete(objNhanXet);
		tx.commit();

		return true;
	}

	@Override
	public List<NhanXet> timKiemNhanXet(Integer baiGiangTimKiem, Integer nguoiDungTimKiem) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

		String strSQL = " from NhanXet where 1=1 ";

		if (baiGiangTimKiem != null) {
			strSQL += " and baiGiangId  = " + baiGiangTimKiem ;
		}
		if (nguoiDungTimKiem != null) {
			strSQL += " and nguoiDungId  = " + nguoiDungTimKiem ;
		}
		
		
		TypedQuery<NhanXet> query = session.createQuery(strSQL, NhanXet.class);

		List<NhanXet> lst = query.getResultList();

		tx.commit();
		return lst;
	}

}
