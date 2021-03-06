package br.com.brq.financialhealth.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.Investimento;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

	/**
	 * Classe DAO - DAOInvestimento.class
	 * 
	 * Classe para comunicacao com o banco de dados - com as informa��es de investimentos
	 * 
	 * 
	 *@author Hiro
	 *@version 1.0
	 *@since Treinamento BRQ/SP
	 */
	public class DAOInvestimento extends DAOGeneric<Investimento, Integer>{
	
	/**
	 * Construtor da Classe, 
	 */
	public DAOInvestimento() {
		super(Investimento.class);
	}
	
	/**
	 * 
	 * Metodo que procura um investimento por nome,
	 * retornando uma lista dos valores encontrados
	 * 
	 */
	public List<Investimento> findByNome(String nome) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Investimento.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		
		@SuppressWarnings("unchecked")
		List<Investimento> lista = query.list();
		
		session.close();
		return lista;
		
	}
	
	/**
	 * 
	 * Metodo que procura um investimento por data , de um usuario especifico
	 * 
	 * @param dateIni - parametro em DATE , onde � o inicio da procura
	 * @param dateFim - parametro em DATE , onde � o fim da procura
	 * @param idUsuario - usuario especifico que � procurado os investimentos
	 * @return - retorna uma lista de investimentos em uma determinada data de um usuario especifico
	 * @throws Exception
	 */
	public List<Investimento> findByData(Date dateIni, Date dateFim, Integer idUsuario ) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Investimento.FINDBY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		@SuppressWarnings("unchecked")
		List<Investimento> lista = query.list();
		
		return lista;
		
	}
	
	/**
	 * Metodo que soma os investimentos em um intervalo de datas de um usuario especifico
	 * 
	 * @param dateIni - parametro em DATE que � o inicio da procura
	 * @param dateFim - parametro em DATE que � o fim da procura
	 * @param idUsuario - parametro em INTEGER que corresponde ao ID do usuario
	 * @return - retorma uma lista da soma dos investimentos encontrados no periodo procurado do usuario especifico
	 * @throws Exception
	 */
	public Double somaByData(Date dateIni, Date dateFim, Integer idUsuario) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery(Investimento.SOMABY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		Double somatorio = (Double) query.uniqueResult();
		
		return somatorio;
	}
	
	/**
	 * Sobre escrita de metodo da SuperClasse DAOGeneric passando como parametro um investimento.
	 * 
	 */
	@Override
	public void delete(Investimento obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();
		
		
	}
	
	/**
	 * Sobreescrita de Metodo, onde � procurado um Investimento atraves de um ID do usuario, que � passado em
	 * Integer
	 */
	@Override
	public Investimento findById(Integer id) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		Investimento inv = (Investimento) session.get(Investimento.class, id);
		session.close();
		return inv;
	}
	
	/**
	 * Metodo para editar as informa��es do Investimento, passando o investimento e identificando com um ID
	 * 
	 */
	public void saveOrUpdate(Investimento obj) throws Exception {
		// TODO Auto-generated method stub
		super.saveOrUpdate(obj);
	}
	
}
