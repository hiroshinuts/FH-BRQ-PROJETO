package br.com.brq.financialhealth.persistence;

import java.util.Date;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.DespesaVariavel;
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

	public List<DespesaFixa> findByData(Date dateIni, Date dateFim) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(DespesaVariavel.FINDBY_DATA);
		query.setDate("d1", dateIni);
		query.setDate("d2", dateFim);

		@SuppressWarnings("unchecked")
		List<DespesaFixa> lista = query.list();

		return lista;

	}

}
