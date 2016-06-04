package br.com.brq.financialhealth.persistence;

import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;

public class DAOUsuario extends DAOGeneric<Usuario, Integer>{

	public DAOUsuario(Class<Usuario> tipo) {
		super(Usuario.class);
		
		
	}

}
