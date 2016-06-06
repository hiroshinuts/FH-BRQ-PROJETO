package br.com.brq.financialhealth.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.Investimento;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.HibernateUtil;

public class DAOInvestimento extends DAOGeneric<Investimento, Integer>{

	public DAOInvestimento() {
		super(Investimento.class);
	}
	
	public List<Investimento> findByNome(String nome) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Investimento.FINDBY_NOME);
		query.setString("p1", "%" + nome + "%");
		
		@SuppressWarnings("unchecked")
		List<Investimento> lista = query.list();
		
		session.close();
		return lista;
		
	}
	
	public List<Investimento> findByData(Date dateIni, Date dateFim ) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Investimento.FINDBY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);
		
		@SuppressWarnings("unchecked")
		List<Investimento> lista = query.list();
		
		return lista;
		
	}

	
	
}
