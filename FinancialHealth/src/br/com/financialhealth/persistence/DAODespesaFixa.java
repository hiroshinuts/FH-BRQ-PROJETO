package br.com.financialhealth.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.Investimento;
import br.com.brq.financialhealth.util.HibernateUtil;
import br.com.financialhealth.persistence.generics.DAOGeneric;

public class DAODespesaFixa extends DAOGeneric<DespesaFixa, Integer>{

	public DAODespesaFixa(Class<DespesaFixa> tipo) {
		super(DespesaFixa.class);
	}
	
public List<DespesaFixa> findByNome(String nome) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(DespesaFixa.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		
		List<DespesaFixa> lista = query.list();
		
		session.close();
		return lista;
		
	}
	
	public List<DespesaFixa> findByData(Date dateIni, Date dateFim ) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		//query.setDate(dateIni, dateFim);
		
		List<DespesaFixa> lista = query.list();
		
		return lista;
		
	}


}
