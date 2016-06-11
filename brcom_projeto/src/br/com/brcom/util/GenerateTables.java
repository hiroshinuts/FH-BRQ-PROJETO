package br.com.brcom.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateTables {
	
	
	public static void main(String[] args) {
		
		// classe para estudo
		
		Configuration cfg = new AnnotationConfiguration();		
		cfg.configure("br/com/brcom/config/mysql_hibernate.cfg.xml"); // le o config do hibernate
		
		// cria as tabelas do hibernate
		SchemaExport s = new SchemaExport(cfg);
		s.create(true, true);
		
	}
	
}


//<property name="hibernate.show_sql">true</property>
//<property name="hibernate.format_sql">true</property>

//drop database if exists brcomdb;
//create database brcomdb;
//use brcomdb;