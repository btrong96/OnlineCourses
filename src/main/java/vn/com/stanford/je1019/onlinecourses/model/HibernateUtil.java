package vn.com.stanford.je1019.onlinecourses.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public HibernateUtil() {
		
	}
	
	private static SessionFactory sessionFactory;
	
	/**
	 *  Ham quan ly ket noi den db trong Hibernate
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		//Configuration cfg = new Configuration();
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		return cfg.buildSessionFactory();
	}
	
	/**
	 * HÃ m tráº£ vá»� Ä‘á»‘i tÆ°á»£ng quáº£n lÃ½ káº¿t ná»‘i lÃ m viá»‡c vá»›i db trong Hibernate
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		
		return sessionFactory;
	}
}
