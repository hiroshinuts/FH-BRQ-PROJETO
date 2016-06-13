package br.com.brq.financialhealth.services;

/**
 * Classe de servi�o - Estimativa.class
 * 
 * Classe que contem o algoritmo para saber estimativa de Investimento, seguindo o sistema
 * 
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */
public class Estimativa {
	
	/**
	 * 
	 * Metodo que calcula quanto o usuario tera de investimento at� os 65 anos
	 * 
	 * @param idade
	 * @param valor18_29 - recebe um Double, que � o valor q o usuario imagina ganhar entre 18 e 29 anos
	 * @param valor30_39 - recebe um Double, que � o valor que o usuario imagina ganhar entre 30 e 39 anos
	 * @param valor40_49 - recebe um Double, que � o valor que o usuario imagina ganhar entre 40 e 49 anos
	 * @param valor50_65 - recebe um Double, que � o valor que o usuario imagina ganhar entre os 50 e 65 anos
	 * @return - retorna o valor apos os calculos
	 */
	public Double lancaFuturo(Integer idade, Double valor18_29, Double valor30_39, Double valor40_49, Double valor50_65){
		
		Double totalInvestimento = 0.0;
		
		if(idade <= 29){
			//calculo para at� 29
			int multiplicaIdade = 30 - idade;
			CalculoPorIdade c29 = new CalculoPorIdade();
			double parcela = c29.saberInvestimento(idade, valor18_29);
			double montante = parcela * 1.005;
			
			//1 ano depositando e pegando juros
			for(int i=0; i <= 12 ; i++){
			   montante = (montante * 1.005 )  + parcela;
			}
			// multiplica pelos anos aguardados
			double total29 = montante * multiplicaIdade;//total
			
			//////////////////////////////////////////////////////////////////////////////
			
			//calculo para at� 39
			int multiplicaIdade1 = 9;
			CalculoPorIdade c39 = new CalculoPorIdade();
			double parcela1 = c39.saberInvestimento(31, valor30_39);
			double montante1 = parcela1* 1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante1 = (montante1 * 1.005 )  + parcela1;
				}
			//multiplica pelos anos
			double total39 = montante1 * multiplicaIdade1;
			
			////////////////////////////////////////////////////////////////////////////////
			
			//calculo para at� 49
			int multiplicaIdade2 = 10;
			CalculoPorIdade c49 = new CalculoPorIdade();
			double parcela2 = c49.saberInvestimento(41, valor40_49);
			double montante2 = parcela2* 1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante2 = (montante2 * 1.005 )  + parcela2;
				}
			//multiplica pelos anos
			
			double total49 = montante2 * multiplicaIdade2;//
			
			////////////////////////////////////////////////////////////////////////////////
			
			//calculo at� 65 aposentadoria
			int multiplicaIdade3 = 16;
			CalculoPorIdade c65 = new CalculoPorIdade();
			double parcela3 = c65.saberInvestimento(51, valor50_65);
			double montante3 = parcela3*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante3 = (montante3 * 1.005 )  + parcela3;
				}
			//multiplica pelos anos
			
			double total65 = montante3 * multiplicaIdade3;
			
			totalInvestimento = total29 + total39 + total49 + total65;
			
			/////////////////////////////////////////////////////////////////////////////
			
		}else if(idade >= 30 && idade <= 39){	
			
			//30 a 39
			int multiplicaIdade = 39 - idade;
			CalculoPorIdade c39 = new CalculoPorIdade();
			double parcela = c39.saberInvestimento(idade, valor30_39);
			double montante1 = parcela*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante1 = (montante1 * 1.005 )  + parcela;
				}
			
			double total39 = montante1 * multiplicaIdade;//total
			
		//////////////////////////////////////////////////////////////////////	
			
			//calculo para at� 49
			int multiplicaIdade2 = 10;
			CalculoPorIdade c49 = new CalculoPorIdade();
			double parcela2 = c49.saberInvestimento(41, valor40_49);
			double montante2 = parcela2*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante2 = (montante2 * 1.005 )  + parcela2;
				}
			
			double total49 = montante2 * multiplicaIdade2;//
			
			
		////////////////////////////////////////////////////////////////////////
			
			//calculo at� 65 aposentadoria
			int multiplicaIdade3 = 16;
			CalculoPorIdade c65 = new CalculoPorIdade();
			double parcela3 = c65.saberInvestimento(51, valor50_65);
			double montante3 = parcela3*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante3 = (montante3 * 1.005 )  + parcela3;
				}
			
			double total65 = montante3 * multiplicaIdade3;
			
			totalInvestimento = total39 + total49 + total65;
			
		////////////////////////////////////////////////////////////////////////	

		}else if(idade >= 40 && idade <= 49){
			
			//calculo 40 a 49
			int multiplicaIdade = 49 - idade;
			CalculoPorIdade c49 = new CalculoPorIdade();
			double parcela = c49.saberInvestimento(idade, valor30_39);
			double montante2 = parcela*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante2 = (montante2 * 1.005 )  + parcela;
				}
			
			double total49 = montante2 * multiplicaIdade;//total
		
		//////////////////////////////////////////////////////////////////////////////////
			
			//calculo at� 65 aposentadoria
			int multiplicaIdade3 = 16;
			CalculoPorIdade c65 = new CalculoPorIdade();
			double parcela3 = c65.saberInvestimento(51, valor50_65);
			double montante3 = parcela3*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante3 = (montante3 * 1.005 )  + parcela3;
				}
			
			double total65 = montante3 * multiplicaIdade3;
			
			totalInvestimento = total49 + total65;
			
	///////////////////////////////////////////////////////////////////////////////////		
		}else if(idade >= 50 && idade <=65){
			
			//idade 50 a aposentadoria
			int multiplicaIdade = 65 - idade;
			CalculoPorIdade c65 = new CalculoPorIdade();
			double parcela = c65.saberInvestimento(idade, valor30_39);
			double montante3 = parcela*1.005;
			
			for(int i=0; i <= 12 ; i++){
				   montante3 = (montante3 * 1.005 )  + parcela;
				}
			
			double total65 = montante3 * multiplicaIdade;//anos
			
			totalInvestimento = total65;
		}
		
		return totalInvestimento;
	}
	
	public static void main(String[] args) {
		
		Estimativa e = new Estimativa();
		Double aui = (Double) e.lancaFuturo(18, 1500.0, 3000.0, 4500.0, 6000.0);
		
		System.out.println(aui);
		
		
	}
	
}
