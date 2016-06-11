package br.com.brcom.persistence;



import java.util.List;

import br.com.brcom.entities.Cliente;
import br.com.brcom.entities.Compra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistencegenerics.DAOGenerics;

public class DAOCliente extends DAOGenerics<Cliente, Integer> {

	public DAOCliente() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(Cliente obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void update(Cliente obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void delete(Cliente obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public Cliente findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		Cliente c = (Cliente) session.get(Cliente.class, id);
		session.close();

		return c;
	}
	
	
	public Cliente findByLoginSenha(String login, String senha) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Cliente.FIND_LOGIN);
		
		query.setString("p1", login);
		query.setString("p2", senha);
		
		Cliente c = (Cliente) query.uniqueResult();
		System.out.println(login+"  "+senha);
		session.close();

		return c;
	}
	
	public List<Cliente> findCompras() throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Cliente.FIND_PURCHASE);
		
		List<Cliente> lista = query.list();
		session.close();
		
		return lista;
	}
	
	
	public static void main(String[] args) {
		DAOCliente d = new DAOCliente();
		try {
			
			System.out.println(d.findCompras());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
