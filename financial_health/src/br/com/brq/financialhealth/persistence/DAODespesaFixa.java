package br.com.brq.financialhealth.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

/**
 * Classe DAO - DAODespesaFixa.class
 * 
 * Classe para comunicacao com o banco de dados - com as informa��es de Despesa Fixa
 * 
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 *//**
 * 
 * @author Hiro
 *
 */
public class DAODespesaFixa extends DAOGeneric<DespesaFixa, Integer> {

	/**
	 * Construtor de classe
	 */
	public DAODespesaFixa() {
		super(DespesaFixa.class);
	}
	
	/**
	 * Metodo que procura uma Despesa Fixa, atraves de um nome
	 * 	
	 * @param nome
	 * @return - retorna a despesa variavel com o devido nome
	 * @throws Exception
	 */
	public List<DespesaFixa> findByNome(String nome) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(DespesaFixa.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");

		@SuppressWarnings("unchecked")
		List<DespesaFixa> lista = query.list();

		session.close();
		return lista;

	}
	
	/**
	 * Metodo que procura uma Despesa Fixa por data de um usuario especifico
	 * 
	 * @param dateIni - parametro passado em DATE , inicio da procura
	 * @param dateFim - parametro passado em DATE , fim da procura
	 * @param idUsuario - parametro passado em Integer do ID do usuario
	 * @return - retorna uma lista de DespesaFixa, de um determinado usuario , em uma data estipulada
	 * @throws Exception
	 */
	public List<DespesaFixa> findByData(Date dateIni, Date dateFim, Integer idUsuario) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(DespesaFixa.FINDBY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);

		@SuppressWarnings("unchecked")
		List<DespesaFixa> lista = query.list();

		return lista;

	}
	

	/**
	 * Metodo que soma as despesas fixas em um intervalo de datas de um usuario especifico
	 * 
	 * @param dateIni - parametro passado em DATE - inicio da procura para soma
	 * @param dateFim - parametro passado em DATE - fim da procura para a soma
	 * @param idUsuario - parametro passado em Integer - para identificar de qual usuario somar
	 * @return - retorna uma lista com a soma das despesas fixas de um determinado usuario
	 * @throws Exception
	 */
	public Double somaByData(Date dateIni, Date dateFim, Integer idUsuario) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery(DespesaFixa.SOMABY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		Double somatorio = (Double) query.uniqueResult();
		
		return somatorio;
	}
	
	/**
	 * Sobreescrita de metodo do DAOGeneric , passando como objeto uma DespesFixa
	 */
	@Override
	public void delete(DespesaFixa obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();
	
	}
	
	/**
	 * Sobreescrita de metodo do DAOGeneric, passando um Integer que � um id do usuario
	 */
	@Override
	public DespesaFixa findById(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		DespesaFixa df = (DespesaFixa) session.get(DespesaFixa.class, id);
		session.close();
		return df;
	
	}
	
	/**
	 * Metodo para update de informacoes de Despesa Fixa de um determinado usuario
	 * 
	 * @param obj - parametro que indica uma despesa fixa
	 * @param id - id da despesa fixa para o update
	 * @throws Exception
	 */
	public void saveOrUpdate(DespesaFixa obj, Integer id) throws Exception {
		// TODO Auto-generated method stub
		super.saveOrUpdate(obj);
	}
	
	
	public static void main(String[] args) {
		
		DAODespesaFixa dao = new DAODespesaFixa();
		try {
			Calendar c = new GregorianCalendar(1220, 2, 1);
			Calendar c2 = new GregorianCalendar(4000, 2, 1);
			
			
			Double resultado = dao.somaByData(c.getTime(), c2.getTime(), 3);
			System.out.println(resultado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
