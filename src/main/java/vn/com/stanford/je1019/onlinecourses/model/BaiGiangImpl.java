package vn.com.stanford.je1019.onlinecourses.model;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import vn.com.stanford.je1019.onlinecourses.entry.BaiGiang;

@Component
public class BaiGiangImpl implements BaiGiangDAO {

	@Override
	public List<BaiGiang> layDanhSach() {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay danh sach
		List<BaiGiang> lstBaiGiang = session.createQuery("from BaiGiang", BaiGiang.class).getResultList();
		tx.commit();

		return lstBaiGiang;
	}

	@Override
	public BaiGiang layChiTietTheoId(Integer id) {
		// Ket noi Database qua Hibernate
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		// Khoi tao 1 phien giao dich trong Hibernate
		Transaction tx = session.beginTransaction();

		// Lay doi tuong can tim
		BaiGiang objBaiGiang = session.get(BaiGiang.class, id);
		tx.commit();

		return objBaiGiang;
	}

	@Override
	public boolean themMoi(BaiGiang obj) {
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
	public boolean capNhat(BaiGiang obj) {
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
		BaiGiang objBaiGiang = session.get(BaiGiang.class, id);

		// Xoa doi tuong
		session.delete(objBaiGiang);
		tx.commit();

		return true;
	}

	@Override
	public List<BaiGiang> timKiemBaiGiang(String tuKhoa, String moTaTimKiem, Integer maKhoaHocTimKiem) {
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from BaiGiang where 1=1 ";

		if (!tuKhoa.isEmpty()) {
			strSQL += " and tenBaiGiang like '%" + tuKhoa + "%'";
		}
		
			strSQL += " and moTa like '%" + moTaTimKiem + "%'";
			strSQL += " and khoaHocId = " + maKhoaHocTimKiem ;
		
		TypedQuery<BaiGiang> query = session.createQuery(strSQL, BaiGiang.class);
	
		List<BaiGiang> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

	@Override
	public List<BaiGiang> timKiemBaiGiangTheoKhoaHoc(Integer maKhoaHocTimKiem, Boolean daDuyet, Boolean mienPhi) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from BaiGiang where 1=1 ";

		if (maKhoaHocTimKiem != null) {
			strSQL += " and khoaHocId = " + maKhoaHocTimKiem ;
		}
		    strSQL += " and daDuyet = " + daDuyet ;
		    
		    strSQL += " and mienPhi = " + mienPhi ;
		
		TypedQuery<BaiGiang> query = session.createQuery(strSQL, BaiGiang.class);
		List<BaiGiang> lst = query.getResultList();
		tx.commit();
		return lst;
	}

	@Override
	public List<BaiGiang> timKiemBaiGiangDaDuyet(Boolean daDuyet, Boolean mienPhi) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		String strSQL = " from BaiGiang where 1=1 ";
		 strSQL += " and daDuyet = " + daDuyet ;
		 strSQL += " and mienPhi = " + mienPhi ;

		 TypedQuery<BaiGiang> query = session.createQuery(strSQL, BaiGiang.class);
			List<BaiGiang> lst = query.getResultList();
			tx.commit();
			return lst;
	}

	@Override
	public List<BaiGiang> timKiemBaiGiangTheoTen(String tenBaiGiang) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		String strSQL = " from BaiGiang where 1=1 ";

		if (!tenBaiGiang.isEmpty()) {
			strSQL += " and tenBaiGiang = '" + tenBaiGiang + "'";
		}
		
		
		TypedQuery<BaiGiang> query = session.createQuery(strSQL, BaiGiang.class);
	
		List<BaiGiang> lst = query.getResultList();

		tx.commit();
	
		return lst;
	}

}
