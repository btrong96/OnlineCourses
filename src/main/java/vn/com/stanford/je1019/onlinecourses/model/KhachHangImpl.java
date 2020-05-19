package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import vn.com.stanford.je1019.onlinecourses.entry.KhachHang;

public class KhachHangImpl implements KhachHangDAO {

	@Override
	public List<KhachHang> layDanhSach() {
		// Káº¿t ná»‘i Ä‘áº¿n db qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khá»Ÿi táº¡o 1 phiÃªn giao dá»‹ch trong hibernate
		Transaction tx = session.beginTransaction();
		TypedQuery<KhachHang> query = session.createQuery("from KhachHang", KhachHang.class);

		// Láº¥y danh sÃ¡ch
		List<KhachHang> lst = query.getResultList();
		tx.commit();

		// Tráº£ vá»� káº¿t quáº£
		return lst;
	}

	@Override
	public KhachHang layChiTietTheoId(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		KhachHang objKhachHang = (KhachHang) session.get(KhachHang.class, id.intValue());
		tx.commit();

		return objKhachHang;
	}

	@Override
	public boolean themMoi(KhachHang obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		session.save(obj);
		tx.commit();

		return true;
	}

	@Override
	public boolean capNhat(KhachHang obj) {
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
		KhachHang objKhachHang = session.get(KhachHang.class, id);

		session.delete(objKhachHang);
		tx.commit();

		return true;
	}

	@Override
	public List<KhachHang> timKiemKhachHang(String tuKhoa) {
		  //Khởi tạo phiên giao dịch qua hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khởi tạo 1 phiên giao dịch trong hibernate trong hibernate
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from KhachHang where 1=1 ";
		if (!tuKhoa.isEmpty()) {
		strSQL += " and tenKhachHang like '%" + tuKhoa + "%'" ;
		}
		
		TypedQuery<KhachHang> query = session.createQuery(strSQL, KhachHang.class);
		
		//lấy danh sách
		List<KhachHang> lst = query.getResultList();
		tx.commit();

		//trả về danh sách
		return lst;
	}

}
