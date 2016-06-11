package br.com.brq.financialhealth.persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.DespesaVariavel;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

public class DAODespesaVariavel extends DAOGeneric<DespesaVariavel, Integer>{

	public DAODespesaVariavel() {
		super(DespesaVariavel.class);
	}
	
public List<DespesaVariavel> findByNome(String nome) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(DespesaVariavel.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		
		@SuppressWarnings("unchecked")
		List<DespesaVariavel> lista = query.list();
		
		session.close();
		return lista;
		
	}
	
	public List<DespesaVariavel> findByData(Date dateIni, Date dateFim, Integer idUsuario ) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(DespesaVariavel.FINDBY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		@SuppressWarnings("unchecked")
		List<DespesaVariavel> lista = query.list();
		
		return lista;
		
	}
	
	public Double somaByData(Date dateIni, Date dateFim, Integer idUsuario) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery(DespesaVariavel.SOMABY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		query.setInteger("usuario", idUsuario);
		
		Double somatorio = (Double) query.uniqueResult();
		
		return somatorio;
	}
	
	@Override
	public void delete(DespesaVariavel obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		session.close();
	
	}
	
	@Override
	public DespesaVariavel findById(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		DespesaVariavel dv = (DespesaVariavel) session.get(DespesaVariavel.class, id);
		return dv;
	}
	
	
	
public static void main(String[] args) {
		
		DAODespesaVariavel dao = new DAODespesaVariavel();
		try {
			Calendar c = new GregorianCalendar(1220, 2, 1);
			Calendar c2 = new GregorianCalendar(4000, 2, 1);
			
			for(DespesaVariavel d : dao.findByData(c.getTime(), c2.getTime(), 1)){
				System.out.println(d.getNome());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
