package br.com.brq.financialhealth.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

public class DAODespesaFixa extends DAOGeneric<DespesaFixa, Integer> {

	public DAODespesaFixa() {
		super(DespesaFixa.class);
	}
	
	
	public List<DespesaFixa> findByNome(String nome) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(DespesaFixa.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");

		@SuppressWarnings("unchecked")
		List<DespesaFixa> lista = query.list();

		session.close();
		return lista;

	}

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
	

	
	public Double somaByData(Date dateIni, Date dateFim, Integer idUsuario) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery(DespesaFixa.SOMABY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		Double somatorio = (Double) query.uniqueResult();
		
		return somatorio;
	}
	
	@Override
	public void delete(DespesaFixa obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();
	
	}
	
	@Override
	public DespesaFixa findById(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		DespesaFixa df = (DespesaFixa) session.get(DespesaFixa.class, id);
		session.close();
		return df;
	
	}
	
	
	public static void main(String[] args) {
		
		DAODespesaFixa dao = new DAODespesaFixa();
		try {
			Calendar c = new GregorianCalendar(1220, 2, 1);
			Calendar c2 = new GregorianCalendar(4000, 2, 1);
			
			//for(DespesaFixa d : dao.findByData(c.getTime(), c2.getTime(), 1)){
				//System.out.println(d.getNome());
			//}
			
			Double resultado = dao.somaByData(c.getTime(), c2.getTime(), 3);
			System.out.println(resultado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
