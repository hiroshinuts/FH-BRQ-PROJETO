package br.com.brcom.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	
	private static final SessionFactory sessionFactory;
	
	static {
		
		try {
			sessionFactory = new AnnotationConfiguration()
					.configure("br/com/brcom/config/mysql_hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
		
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
}