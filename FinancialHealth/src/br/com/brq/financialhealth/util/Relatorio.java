package br.com.brq.financialhealth.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.Usuario;

public class Relatorio {
	
	public List<Double> geraRelatorio(){
		
		Usuario u = new Usuario();
		Calendar c = Calendar.getInstance();
		//Date data = c.setTime(u.getDataNascimento());
		
		//int idade = new Idade(data.getTime());
		
		CalculoPorIdade calculoValores = new CalculoPorIdade();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		
		Double salario = u.getRendimentoMensalLiquido();
		
		List<Double> valores = null;
		
		return valores;
	}
	
	public static void main(String[] args) {
		Usuario u = new Usuario();
		Idade idade = new Idade(u.getDataNascimento());
	}

}
