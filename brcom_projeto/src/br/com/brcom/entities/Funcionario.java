package br.com.brcom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario")
@NamedQueries(
		
		{
			
			@NamedQuery(name= Funcionario.FIND_ALL, 
			query="select f from Funcionario as f "),
			
			@NamedQuery(name= Funcionario.FIND_LOGIN, 
			query="select f from Funcionario as f where f.email = :p1 and f.senha = :p2")
			
		}
		
		)
public class Funcionario extends Usuario{
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  	      
	@Column(name = "idfuncionario")  
	private Integer idFuncionario;	
	
	@Column(name = "cargo", length = 50, nullable = false)
	private String cargo;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer idFuncionario, String nome, String email, String senha, String logradouro, String cidade,
			String estado, String cargo) {
		super(nome, email, senha, logradouro, cidade, estado);
		this.idFuncionario = idFuncionario;
		this.cargo = cargo;
	}
	

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "idFuncionario = "+idFuncionario+super.toString()+" Funcionario [cargo=" + cargo + "]";
	}
	
	
	public static final String FIND_ALL="funcionario.findall";
	

	public static final String FIND_LOGIN="funcionario.findlogin";
}
