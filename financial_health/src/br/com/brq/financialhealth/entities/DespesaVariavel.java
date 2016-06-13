 package br.com.brq.financialhealth.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Classe de entidade: Despesa Variavel.
 * 
 * Classe utilizada para gerenciar todos as despesasa variaveis da aplicação. Está entidade fornece uma FK para a
 * classe Usuario.class
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */

@Entity
@Table(name = "despesavariavel")
@NamedQueries(
		{
			@NamedQuery(name = DespesaVariavel.FINDBY_NOME,
					query = "select desv from DespesaVariavel as desv where desv.nome like :p1 AND "
							+ "id=usuario order by desv.nome"),
			@NamedQuery(name = DespesaVariavel.FINDBY_DATA,
					query = "select dv from DespesaVariavel as dv inner join dv.usuario as u where dv.dataDespesaVariavel between :d1 and :d2 and u.id=:usuario"),

			@NamedQuery(name = DespesaVariavel.SOMABY_DATA,
					query = "select sum(ddv.valor) from DespesaVariavel as ddv inner join ddv.usuario as u where ddv.dataDespesaVariavel between :d1 and :d2 and u.id=:usuario")
		
		}
		)
public class DespesaVariavel {
	
	public static final String FINDBY_NOME = "despesavariavel.findbynome";
	public static final String FINDBY_DATA = "despesavariavel.findbydata";
	public static final String SOMABY_DATA = "despesavariavel.somabydata";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddespesavariavel")
	private Integer idDespesaVariavel;
	
	@Column(name = "nome", length=50, nullable = false)
	private String nome;
	
	@Column(name = "valor", length=50, nullable = false)
	private Double valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datadespesavariavel", nullable = false)
	private Date dataDespesaVariavel;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;
	
	public DespesaVariavel() {
	}

	public DespesaVariavel(Integer idDespesaVariavel, String nome, Double valor, Date dataDespesaVariavel) {
		this.idDespesaVariavel = idDespesaVariavel;
		this.nome = nome;
		this.valor = valor;
		this.dataDespesaVariavel = dataDespesaVariavel;
	}

	public DespesaVariavel(Integer idDespesaVariavel, String nome, Double valor, Date dataDespesaVariavel, Usuario usuario) {
		this.idDespesaVariavel = idDespesaVariavel;
		this.nome = nome;
		this.valor = valor;
		this.dataDespesaVariavel = dataDespesaVariavel;
		this.usuario = usuario;
	}

	public Integer getIdDespesaVariavel() {
		return idDespesaVariavel;
	}

	public void setIdDespesaVariavel(Integer idDespesaVariavel) {
		this.idDespesaVariavel = idDespesaVariavel;
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

	public Date getDataDespesaVariavel() {
		return dataDespesaVariavel;
	}

	public void setDataDespesaVariavel(Date dataDespesaVariavel) {
		this.dataDespesaVariavel = dataDespesaVariavel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "DespesaVariavel [idDespesaVariavel=" + idDespesaVariavel + ", nome=" + nome + ", valor=" + valor
				+ ", dataDespesaVariavel=" + dataDespesaVariavel + ", usuario=" + usuario + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	
		if(obj instanceof DespesaVariavel){
			DespesaVariavel dv = (DespesaVariavel) obj;
			return dv.getIdDespesaVariavel().equals(idDespesaVariavel);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return idDespesaVariavel.hashCode();
	}
	
}
