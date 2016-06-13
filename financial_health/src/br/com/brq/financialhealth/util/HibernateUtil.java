package br.com.brq.financialhealth.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * Classe utilitaria - HibernateUtil.class
 * 
 * Possui a finalidade de ler o arquivo de configuralçao do config.xml e produzir
 * Conexoes com a base de dados.
 * 
 * 
 * @author Hiro
 * @version 1.0
 * @since Treinamento BRQ/SP
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory; //conexão..

	static {
		try {
			sessionFactory = new AnnotationConfiguration()
					.configure("br/com/brq/financialhealth/config/mysql_hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
