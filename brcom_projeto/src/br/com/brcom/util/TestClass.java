package br.com.brcom.util;

import br.com.brcom.entities.Funcionario;
import br.com.brcom.persistence.DAOFuncionario;

public class TestClass {

	public static void main(String[] args) {

		Funcionario f = new Funcionario();
		
		
		try {
			
			f.setNome("Anderson");
			f.setSenha(MD5.encryptPassword("123"));
			f.setEmail("anderson.badari@gmail.com");
			f.setCargo("Gerente de produtos");
			f.setLogradouro("Rua Boa Vista, 123");
			f.setCidade("São Paulo");
			f.setEstado("SP");
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		DAOFuncionario d = new DAOFuncionario();
		
		

		try {
			d.insert(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(f);

	}

}
