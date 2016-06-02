package br.com.brq.financialhealth.entities;

import java.util.Date;

public class Investimento {
	
	private Integer idInvestimento;
	private String nome;
	private Double valor;
	private Date dataInvestimento;
	private Usuario usuario;
	
	public Investimento() {
		// TODO Auto-generated constructor stub
	}

	public Investimento(Integer idInvestimento, String nome, Double valor, Date dataInvestimento) {
		super();
		this.idInvestimento = idInvestimento;
		this.nome = nome;
		this.valor = valor;
		this.dataInvestimento = dataInvestimento;
	}

	public Investimento(Integer idInvestimento, String nome, Double valor, Date dataInvestimento, Usuario usuario) {
		super();
		this.idInvestimento = idInvestimento;
		this.nome = nome;
		this.valor = valor;
		this.dataInvestimento = dataInvestimento;
		this.usuario = usuario;
	}

	public Integer getIdInvestimento() {
		return idInvestimento;
	}

	public void setIdInvestimento(Integer idInvestimento) {
		this.idInvestimento = idInvestimento;
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

	public Date getDataInvestimento() {
		return dataInvestimento;
	}

	public void setDataInvestimento(Date dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Investimento [idInvestimento=" + idInvestimento + ", nome=" + nome + ", valor=" + valor
				+ ", dataInvestimento=" + dataInvestimento + ", usuario=" + usuario + "]";
	}
	
	@Override
	public int hashCode() {
		return idInvestimento.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj instanceof Investimento){
			Investimento inv = (Investimento) obj;
			return inv.getIdInvestimento().equals(idInvestimento);
		}
		
		return false;
	}
	
	
}

	