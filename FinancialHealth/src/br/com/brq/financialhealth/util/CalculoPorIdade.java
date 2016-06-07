package br.com.brq.financialhealth.util;


//erro
public class CalculoPorIdade {
	
	
	class GuardaValores{
		public int idade;
		public double investimento;
		public double despesaFixa;
		public double despesaVariavel;
		public Object object[];
	}

		
	Object[] calculaTotal(int idade, double salario){

		GuardaValores gv = new GuardaValores();
		gv.object =new Object[3];
		
		if(idade >65){
			
			gv.investimento = salario * 0.1;
			gv.despesaFixa = salario * 0.9;
			gv.despesaVariavel = 0;
			
		}else if(idade >=50 && idade <= 65){
			
			gv.investimento = salario * 0.1;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = salario * 0.4;
			
		}else if(idade >=40 && idade <= 49){
			
			gv.investimento = salario * 0.2;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = salario * 0.3;
			
		}else if(idade >= 30 && idade <= 39){
			
			gv.investimento = salario * 0.3;
			gv.despesaFixa = salario * 0.5;
			gv.despesaVariavel = salario * 0.2;
			
		}else if(idade >= 18 && idade <= 29 ){
			
			gv.investimento = salario * 0.4;
			gv.despesaFixa = salario * 0.4;
			gv.despesaVariavel = salario * 0.2;
		}else {
			
			gv.investimento = salario * 1.0;
			gv.despesaFixa = salario * 0;
			gv.despesaVariavel = 0;
			
		}
		
		gv.object[0] = gv.investimento;
		gv.object[1] = gv.despesaFixa;
		gv.object[2] = gv.despesaVariavel;
		
		return gv.object;
		
	}
	
	public static void main(String[] args) {

		CalculoPorIdade ci = new CalculoPorIdade();
		Object array[] = ci.calculaTotal(20, 3000);
		System.out.println(ci);
		
		for(int i = 0 ; i < array.length; i++){
			System.out.println(array[i]);
		}
	}
	
	}
