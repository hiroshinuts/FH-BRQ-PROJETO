package br.com.brcom.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.brcom.entities.Cliente;
import br.com.brcom.entities.Compra;
import br.com.brcom.entities.ItemDeCompra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistencegenerics.DAOGenerics;

public class DAOCompra extends DAOGenerics<Compra, Integer>{

	public DAOCompra() {
		super(Compra.class);
	}
	
	@Override
	public void insert(Compra obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void update(Compra obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void delete(Compra obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public Compra findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		Compra c = (Compra) session.get(Compra.class, id);
		session.close();

		return c;
	}
	
	
	@Override
	public List<Compra> findAll() throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Compra.FIND_ALL);
		
		List<Compra> lista = query.list();
		
		session.close();
		
		return lista;
	}
	
	
	public List<Compra> findPurchases(Integer id) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Compra.FIND_PURCHASE);
		
		query.setInteger("p1", id);

		List<Compra> lista = query.list();		
		
		session.close();

		return lista;
	}
	
	
	// retorna todos os itens de compra de um cliente segundo o id dele
	public static void main(String[] args) {
		
		DAOCompra d = new DAOCompra();
		
		List<Compra> a = new ArrayList<Compra>();
		
		try {
			
			a =  d.findPurchases(1);
			for(Object c : a){
				
				ItemDeCompra idc = (ItemDeCompra) c;
				System.out.println(idc);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
