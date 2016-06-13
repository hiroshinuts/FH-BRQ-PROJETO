package br.com.brq.financialhealth.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Classe de utilidade - Criptografia.class
 * 
 * Classe utilizada para criptografia de senha, para ser armazenada no Banco de dados. Criptografia MD5
 * 
 * 
 * @author Hiro
 * @version 1.0
 * @since Treinamento BRQ/SP
 */

public class Criptografia {
	
	/**
	 * Metodo para incriptar a senha do cadastro
	 * 
	 * @param senha
	 * @return
	 * @throws Exception
	 */
	public static String encriptarSenha(String senha) throws Exception{
		
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		return new BigInteger(1, m.digest()).toString(16);
		
		
	}

}
