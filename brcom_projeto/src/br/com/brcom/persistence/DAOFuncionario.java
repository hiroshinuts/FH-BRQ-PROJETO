package br.com.brcom.persistence;

import java.util.List;

import br.com.brcom.entities.Funcionario;
import br.com.brcom.persistencegenerics.DAOGenerics;
import br.com.brcom.persistence.HibernateUtil;

public class DAOFuncionario extends DAOGenerics<Funcionario, Integer>{

	public DAOFuncionario() {
		super(Funcionario.class);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void insert(Funcionario obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void update(Funcionario obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void delete(Funcionario obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> findAll() throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Funcionario.FIND_ALL);
		List<Funcionario> lista = query.list();
		session.close();
		
		return lista;
	}
	
	
	@Override
	public Funcionario findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario f = (Funcionario) session.get(Funcionario.class, id);
		session.close();

		return f;
	}
	
	
	public Funcionario findByLoginSenha(String login, String senha) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Funcionario.FIND_LOGIN);
		query.setString("p1", login);
		query.setString("p2", senha);
		
		Funcionario f = (Funcionario) query.uniqueResult();
		session.close();

		return f;
	}


}
