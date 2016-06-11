package br.com.brcom.managedbeans;

import java.util.List;

import br.com.brcom.entities.Produto;
import br.com.brcom.entities.types.Categoria;
import br.com.brcom.persistence.DAOProduto;

public class ManagedBeanProdutoLivro {
	
	// lista os produtos cadastrados funcionario
	
		private List<Produto> listagemProduto;

		public List<Produto> getListagemProduto() {
			
			DAOProduto d = new DAOProduto();
			
			try {
				listagemProduto = d.findSpecifiedCategory(String.valueOf(Categoria.Livro));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return listagemProduto;
		}

}
