package br.com.brq.financialhealth.persistence;

import java.util.Date;
import java.util.List;

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

}
