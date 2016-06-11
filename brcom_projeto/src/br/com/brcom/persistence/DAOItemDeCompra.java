package br.com.brcom.persistence;

import java.util.List;

import br.com.brcom.entities.ItemDeCompra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistencegenerics.DAOGenerics;

public class DAOItemDeCompra extends DAOGenerics<ItemDeCompra, Integer>{

	public DAOItemDeCompra() {
		super(ItemDeCompra.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void insert(ItemDeCompra obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void update(ItemDeCompra obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void delete(ItemDeCompra obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemDeCompra> findAll() throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Produto.FIND_ALL);
		List<ItemDeCompra> lista = query.list();
		session.close();
		
		return lista;
	}
	
	
	@Override
	public ItemDeCompra findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		ItemDeCompra p = (ItemDeCompra) session.get(ItemDeCompra.class, id);
		session.close();

		return p;
	}
	
	public List<ItemDeCompra> findByUser(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(ItemDeCompra.FIND_BY_USER);
		query.setInteger("p1", id);
		List<ItemDeCompra> lista = query.list();
		session.close();
		
		return lista;
		
	}
	
	
	
	
	
	

}
