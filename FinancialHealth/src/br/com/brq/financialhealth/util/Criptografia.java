package br.com.brq.financialhealth.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {
	
	public static String encriptarSenha(String senha) throws Exception{
		
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(),0,senha.length());
		return new BigInteger(1, m.digest()).toString(16);
		
		
	}

}