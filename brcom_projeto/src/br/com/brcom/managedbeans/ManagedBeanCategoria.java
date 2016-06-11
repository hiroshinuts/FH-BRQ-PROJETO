package br.com.brcom.managedbeans;

import java.util.ArrayList;
import java.util.List;

import br.com.brcom.entities.types.Categoria;


public class ManagedBeanCategoria {
	
	private List<String> listagemCategorias;

	
	public List<String> getListagemCategorias() {
		listagemCategorias = new ArrayList<String>();
		
		for(Categoria c : Categoria.values()){
			listagemCategorias.add(c.name());
		}
		
		return listagemCategorias;
	}

}
