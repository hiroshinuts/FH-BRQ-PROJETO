package br.com.brq.financialhealth.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * Classe utilitaria - GenerateTables.class
 * 
 * Utilizada para criar as tabelas do banco de dados, Estas tabelas devem estar devidamente mapeadas pelo
 * Hibernate
 * 
 * 
 * @author Hiro
 * @version 1.0
 * @since Treinamento BRQ/SP
 */
//classe para gerar as tabelas no banco de dados pelo hibernate..
public class GenerateTables {

	public static void main(String[] args) {
		
		try{			
			//ler o arquivo de configuração do hibernate..
			Configuration cfg = new AnnotationConfiguration();
			cfg.configure("br/com/brq/financialhealth/config/mysql_hibernate.cfg.xml");
			
			//exportar (criar as tabelas)..
			SchemaExport s = new SchemaExport(cfg);
			s.create(true, true); //executando..
		}
		catch(Exception e){
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}		
	}
	
}
