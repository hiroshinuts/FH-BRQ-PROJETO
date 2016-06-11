package br.com.brq.financialhealth.services;


//erro
public class CalculoPorIdade {
	
	
	class GuardaValores{
		public Integer idade;
		public Double investimento;
		public Double despesaFixa;
		public Double despesaVariavel;
		public Object object[];
	}

		
	public Object[] calculaTotal(int idade, Double salario){

		GuardaValores gv = new GuardaValores();
		gv.object =new Object[3];
		
		if(idade >65){
			
			gv.investimento = salario * 0.1;
			gv.despesaFixa = salario * 0.9;
			gv.despesaVariavel = 0.0;
			
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
			gv.despesaVariavel = 0.0;
			
		}
		
		
		gv.object[0] = gv.investimento;
		gv.object[1] = gv.despesaFixa;
		gv.object[2] = gv.despesaVariavel;
		
		return gv.object;
		
	}
	
	public Double saberInvestimento(int idade, Double salario){
		
		GuardaValores gv = new GuardaValores();
		Double investimento;
		
			if(idade >65){
			
			gv.investimento = salario * 0.1;
			
		}else if(idade >=50 && idade <= 65){
			
			gv.investimento = salario * 0.1;
			
		}else if(idade >=40 && idade <= 49){
			
			gv.investimento = salario * 0.2;
			
		}else if(idade >= 30 && idade <= 39){
			
			gv.investimento = salario * 0.3;
			
		}else if(idade >= 18 && idade <= 29 ){
			
			gv.investimento = salario * 0.4;
		}else {
			
			gv.investimento = salario * 1.0;
			
		}
		
		
		
		return gv.investimento;
		
	}


	
	public static void main(String[] args) {

		CalculoPorIdade ci = new CalculoPorIdade();
		Object array[] = ci.calculaTotal(20, 3000.0);
		System.out.println(ci);
		
		for(int i = 0 ; i < array.length; i++){
			System.out.println(array[i]);
		}
	}
	
	}
