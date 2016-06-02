package br.com.brq.financialhealth.entities;

import java.util.Date;

public class DespesaVariavel {
	
	private Integer idDespesaFixa;
	private String nome;
	private Double valor;
	private Date dataDespesaFixa;
	private Usuario usuario;
	
	public DespesaVariavel() {
		// TODO Auto-generated constructor stub
	}

	public DespesaVariavel(Integer idDespesaFixa, String nome, Double valor, Date dataDespesaFixa) {
		this.idDespesaFixa = idDespesaFixa;
		this.nome = nome;
		this.valor = valor;
		this.dataDespesaFixa = dataDespesaFixa;
	}

	public DespesaVariavel(Integer idDespesaFixa, String nome, Double valor, Date dataDespesaFixa, Usuario usuario) {
		this.idDespesaFixa = idDespesaFixa;
		this.nome = nome;
		this.valor = valor;
		this.dataDespesaFixa = dataDespesaFixa;
		this.usuario = usuario;
	}

	public Integer getIdDespesaFixa() {
		return idDespesaFixa;
	}

	public void setIdDespesaFixa(Integer idDespesaFixa) {
		this.idDespesaFixa = idDespesaFixa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataDespesaFixa() {
		return dataDespesaFixa;
	}

	public void setDataDespesaFixa(Date dataDespesaFixa) {
		this.dataDespesaFixa = dataDespesaFixa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DespesaVariavel [idDespesaFixa=" + idDespesaFixa + ", nome=" + nome + ", valor=" + valor
				+ ", dataDespesaFixa=" + dataDespesaFixa + ", usuario=" + usuario + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj instanceof DespesaVariavel){
			DespesaVariavel dv = (DespesaVariavel) obj;
			return dv.getIdDespesaFixa().equals(idDespesaFixa);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return idDespesaFixa.hashCode();
	}
	
}
