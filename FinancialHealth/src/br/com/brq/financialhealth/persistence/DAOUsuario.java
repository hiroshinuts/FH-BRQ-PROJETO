package br.com.brq.financialhealth.persistence;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

public class DAOUsuario extends DAOGeneric<Usuario, Integer>{

	public DAOUsuario() {
		super(Usuario.class);
	}
	
	
	public Usuario autenticar(String cpf, String senha) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
			Criteria consulta = session.createCriteria(Usuario.class);
			consulta.createAlias("usuario","u");
			consulta.add(Restrictions.eq("u.cpf", cpf));
			consulta.add(Restrictions.eq("senha", senha));
			
			Usuario resultado = (Usuario) consulta.uniqueResult();
			
			session.close();
			
			return resultado;
		}
		
	}
	
