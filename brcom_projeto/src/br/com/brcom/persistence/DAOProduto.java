package br.com.brcom.persistence;


import java.util.List;

import br.com.brcom.entities.Funcionario;
import br.com.brcom.entities.Produto;
import br.com.brcom.entities.types.Categoria;
import br.com.brcom.persistencegenerics.DAOGenerics;

public class DAOProduto  extends DAOGenerics<Produto, Integer>{

	public DAOProduto() {
		super(Produto.class);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void insert(Produto obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void update(Produto obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
	}
	
	
	@Override
	public void delete(Produto obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> findAll() throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Produto.FIND_ALL);
		List<Produto> lista = query.list();
		session.close();
		
		return lista;
	}
	
	
	@Override
	public Produto findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		Produto p = (Produto) session.get(Produto.class, id);
		session.close();

		return p;
	}
	
	
	public List<Produto> findAllEletronics(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Produto.FIND_ALL);
		List<Produto> lista = query.list();
		session.close();
		
		return lista;
	}
	
	
		@SuppressWarnings("unchecked")
		public List<Produto> findSpecifiedCategory(String categoria) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Produto.FIND_SPEC);
		
		query.setParameter("p1", categoria);
		
		List<Produto> lista = query.list();
		session.close();
		
		return lista;
	}
		
		
		public List<Produto> findByCompra(Integer idProdutoCompra, Integer idProduto){
			session = HibernateUtil.getSessionFactory().openSession();
			
			query = session.getNamedQuery(Produto.FIND_BY_PURCHASE);
			
			query.setParameter("p1", idProdutoCompra);
			query.setParameter("p2", idProduto);
			
			List<Produto> lista = query.list();
			session.close();
			
			return lista;
		}
	
	
	
	

}
