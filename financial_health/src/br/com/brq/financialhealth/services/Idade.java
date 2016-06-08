package br.com.brq.financialhealth.services;

import java.util.Calendar;
import java.util.Date;

public class Idade {

	public Idade(Date data) {  
	        System.out.println(calcIdade(data));  
	    }  
	      
	    public int calcIdade(Date dataNasc){  
	        Date hoje = new Date();  
	        Calendar cal = Calendar.getInstance();  
	          
	        cal.setTime(hoje);  
	        int day1 = cal.get(Calendar.DAY_OF_YEAR);  
	        int ano1 = cal.get(Calendar.YEAR);  
	          
	        cal.setTime(dataNasc);  
	        int day2 = cal.get(Calendar.DAY_OF_YEAR);  
	        int ano2 = cal.get(Calendar.YEAR);  
	          
	        int nAno = ano1 - ano2;  
	          
	        if(day1 < day2)  
	            nAno--; //Ainda não completou aniversario esse ano.  
	              
	        return nAno;
	    }
	    
	    public static void main(String[] args) {
	    	 Calendar c = Calendar.getInstance();    
	         c.set(1997, 11, 02);   
	         new Idade(c.getTime());
		}
	
}
