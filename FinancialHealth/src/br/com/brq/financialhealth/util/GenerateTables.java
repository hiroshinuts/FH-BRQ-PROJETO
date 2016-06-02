package br.com.brq.financialhealth.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

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
		}		
	}
	
}
