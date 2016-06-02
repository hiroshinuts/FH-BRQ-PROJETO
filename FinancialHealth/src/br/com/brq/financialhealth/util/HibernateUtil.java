package br.com.brq.financialhealth.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

//classe simples com a finalidade de ler o arquivo de configuração
//config.xml e produzir conexões com a base de dados
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
