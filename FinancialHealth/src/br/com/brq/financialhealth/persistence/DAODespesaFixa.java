package br.com.brq.financialhealth.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;import java.util.GregorianCalendar;
import java.util.List;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.DespesaVariavel;
import br.com.brq.financialhealth.persistence.generics.DAOGeneric;
import br.com.brq.financialhealth.util.FormatacaoData;
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
		query.setDate("dfx1", dateIni);
		query.setDate("dfx2", dateFim);

		@SuppressWarnings("unchecked")
		List<DespesaFixa> lista = query.list();

		return lista;

	}
	
	public static void main(String[] args) {
		
		DAODespesaFixa dao = new DAODespesaFixa();
		try {
			dao.findByData(FormatacaoData.convertToDate("01/10/1900"), FormatacaoData.convertToDate("02/10/4000"));
			SimpleDateFormat sdf = new SimpleDateFormat();
			//dao.findByData(sdf.parse("02/01/1900"), sdf.parse("01/01/2050"));
			
			//dao.findByData(sdf.format("02/01/1900", "02/01/1900"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dao);
		
	}

}
