package br.com.brq.financialhealth.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		return  DriverManager.getConnection("jdbc:mysql://localhost:3306/fhprojeto", "root", "brqbrq");
	}

}
