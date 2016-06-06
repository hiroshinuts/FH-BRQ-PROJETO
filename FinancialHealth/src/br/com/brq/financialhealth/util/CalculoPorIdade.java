package br.com.brq.financialhealth.util;


//erro
public class CalculoPorIdade {
	
	
	class GuardaValores{
		protected int idade;
		protected double investimento;
		protected double despesaFixa;
		protected double despesaVariavel;
		protected Object[] object;
	}

	private double[] object;
		
	double[] calculaTotal(int idade, double salario){

		GuardaValores gv = new GuardaValores();
		
		if(idade >65){
			
			gv.investimento = salario * 0.1;
			gv.despesaFixa = salario * 0.9;
			gv.despesaVariavel = 0;
			
		}else if(idade >=50 && idade <= 65){
			
			gv.investimento = salario * 0.1;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = 0.4;
			
		}else if(idade >=40 && idade <= 49){
			
			gv.investimento = salario * 0.2;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = 0.3;
			
		}else if(idade >= 30 && idade <= 39){
			
			gv.investimento = salario * 0.3;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = 0.2;
			
		}else if(idade >= 18 && idade <= 29 ){
			
			gv.investimento = salario * 0.4;
			gv.despesaFixa = salario * 0.4;
			gv.despesaVariavel = 0.2;
		}else {
			
			gv.investimento = salario * 1.0;
			gv.despesaFixa = salario * 0;
			gv.despesaVariavel = 0;
			
		}
		
		object[0] = gv.investimento;
		object[1] = gv.despesaFixa;
		object[2] = gv.despesaVariavel;
		
		return object;
		
	}
	
	}