package br.com.brcom.managedbeans;

import java.util.List;

import br.com.brcom.entities.Produto;
import br.com.brcom.persistence.DAOProduto;

public class ManagedBeanCliente {
	
	private List<Produto> listagemProduto;

	public List<Produto> getListagemProduto() {
		
		DAOProduto d = new DAOProduto();
		
		try {
			listagemProduto = d.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listagemProduto;
	}

}
