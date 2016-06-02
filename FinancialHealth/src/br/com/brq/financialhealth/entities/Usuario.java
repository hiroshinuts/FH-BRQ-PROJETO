package br.com.brq.financialhealth.entities;

import java.util.Date;

public class Usuario {
	
	private Integer idUsuario;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private Investimento investimento;
	private DespesaFixa despesaFixa;
	private DespesaVariavel despesaVariavel;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nome, String email, String cpf, Date dataNascimento) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Usuario(Integer idUsuario, String nome, String email, String cpf, Date dataNascimento,
			Investimento investimento, DespesaFixa despesaFixa, DespesaVariavel despesaVariavel) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.investimento = investimento;
		this.despesaFixa = despesaFixa;
		this.despesaVariavel = despesaVariavel;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Investimento getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento investimento) {
		this.investimento = investimento;
	}

	public DespesaFixa getDespesaFixa() {
		return despesaFixa;
	}

	public void setDespesaFixa(DespesaFixa despesaFixa) {
		this.despesaFixa = despesaFixa;
	}

	public DespesaVariavel getDespesaVariavel() {
		return despesaVariavel;
	}

	public void setDespesaVariavel(DespesaVariavel despesaVariavel) {
		this.despesaVariavel = despesaVariavel;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf
				+ ", dataNascimento=" + dataNascimento + ", investimento=" + investimento + ", despesaFixa="
				+ despesaFixa + ", despesaVariavel=" + despesaVariavel + "]";
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Usuario){
			Usuario user = (Usuario) obj;
			return user.getIdUsuario().equals(idUsuario);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return idUsuario.hashCode();
	}
	
}
