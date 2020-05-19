package vn.com.stanford.je1019.onlinecourses.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.NhatKy;

@Component
public class NhatKyImpl implements NhatKyDAO {

	@Override
	public List<NhatKy> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<NhatKy> lstNhatKy = session.createQuery("from NhatKy", NhatKy.class).getResultList();
		tx.commit();

		return lstNhatKy;
	}

	@Override
	public NhatKy layChiTietTheoId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themMoi(NhatKy obj) {
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
	public boolean capNhat(NhatKy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoa(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay thong tin doi tuong can xoa
		NhatKy obj = session.get(NhatKy.class, id);

		// Xoa doi tuong
		session.delete(obj);
		tx.commit();

		return true;
	}

	@Override
	public List<NhatKy> timKiemNhatKy(Date ngayNhatKy, Integer maNguoiDungTimKiem) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from NhatKy where 1=1 ";

		if(ngayNhatKy != null) {
			strSQL += " and ngay = '" + ngayNhatKy +"'";                        // Trc bi bug cho nay
		}
		if (maNguoiDungTimKiem != null) {
			strSQL += " and nguoiDungId =" + maNguoiDungTimKiem;
		}
		   		
		TypedQuery<NhatKy> query = session.createQuery(strSQL, NhatKy.class);	
		List<NhatKy> lst = query.getResultList();
		tx.commit();
	
		return lst;
	}

}
