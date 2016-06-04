package br.com.financialhealth.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.DespesaVariavel;
import br.com.brq.financialhealth.util.HibernateUtil;
import br.com.financialhealth.persistence.generics.DAOGeneric;

public class DAODespesaVariavel extends DAOGeneric<DespesaVariavel, Integer>{

	public DAODespesaVariavel(Class<DespesaVariavel> tipo) {
		super(DespesaVariavel.class);
	}
	
public List<DespesaVariavel> findByNome(String nome) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(DespesaVariavel.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		
		List<DespesaVariavel> lista = query.list();
		
		session.close();
		return lista;
		
	}
	
	public List<DespesaVariavel> findByData(Date dateIni, Date dateFim ) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		//query.setDate(dateIni, dateFim);
		
		List<DespesaVariavel> lista = query.list();
		
		return lista;
		
	}

}
