package br.com.brq.financialhealth.persistence;


import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

public class DAOUsuario extends DAOGeneric<Usuario, Integer> {

	public DAOUsuario() {
		super(Usuario.class);
	}

	public Usuario findByLoginSenha(String cpf, String senha) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Usuario.FIND_LOGIN);
		query.setString("p1", cpf);
		query.setString("p2", senha);
		
		Usuario u = (Usuario) query.uniqueResult();
		System.out.println(cpf+" "+senha);
		session.close();
		return u;
	
	}
	@Override
	public void delete(Usuario u) throws Exception {
		super.delete(u);
	}

}
