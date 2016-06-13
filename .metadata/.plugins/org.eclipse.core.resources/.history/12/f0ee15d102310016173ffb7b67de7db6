package br.com.brq.financialhealth.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatacaoData {
	
	public static Date convertToDate(String data)throws Exception{
		
		int ano = Integer.parseInt(data.substring(0,4));
		int mes = Integer.parseInt(data.substring(5,7));
		int dia = Integer.parseInt(data.substring(8,10));
		
		Calendar cal = new GregorianCalendar(ano, mes-1, dia);
		return cal.getTime();
		
		
	}

}
