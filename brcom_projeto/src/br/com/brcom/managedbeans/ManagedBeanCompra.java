package br.com.brcom.managedbeans;

import java.util.List;

import br.com.brcom.entities.Compra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistence.DAOCompra;

public class ManagedBeanCompra {
	
	private List<Compra> listagemCompra;
	private List<Produto> itensDaCompra;	
	

	public List<Compra> getListagemCompra() {
		
		DAOCompra daoc = new DAOCompra();
		
		
		try {
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return listagemCompra;
	}



	public List<Produto> getItensDaCompra() {
		return itensDaCompra;
	}



	

}
