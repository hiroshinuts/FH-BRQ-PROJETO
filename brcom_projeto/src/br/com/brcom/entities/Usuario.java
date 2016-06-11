package br.com.brcom.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public abstract class Usuario implements Serializable{
	
	

	
	@Column(name = "nome", length = 50, nullable = false)  
	private String nome;
	
	@Column(name = "email", length = 50, unique = true)  
	private String email;
	
	@Column(name = "senha", length = 50, nullable = false)  
	private String senha;
	
	@Column(name = "logradouro")  
	private String logradouro;
	
	@Column(name = "cidade")  
	private String cidade;
	
	@Column(name = "estado")  
	private String estado;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Usuario(String nome, String email, String senha, String logradouro, String cidade,
			String estado) {		
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "nome=" + nome + ", email=" + email + ", senha=" + senha + ", logradouro="
				+ logradouro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	

}


 
