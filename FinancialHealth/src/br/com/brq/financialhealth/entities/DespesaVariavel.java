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

@Entity
@Table(name = "despesavariavel")
//@NamedQueries(
//		{
//			@NamedQuery(name = DespesaVariavel.FINDBY_NOME,
//					query = "select desv from DespesaVariavel as desv where desv.nome like :p1 AND"
//							+ " id=:idusuario order by desv.nome"),
//			@NamedQuery(name = DespesaVariavel.FINDBY_DATA,
//					query = "select du from DespesaVariavel as du where datadespesafixa between :d1 and :d2 AND id=usuario order by datadespesavariavel")
//		}
//		)
public class DespesaVariavel {
	
	public static final String FINDBY_NOME = "despesavariavel.findbynome";
	public static final String FINDBY_DATA = "despesavariavel.findbydata";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddespesafixa")
	private Integer idDespesaFixa;
	
	@Column(name = "nome", length=50, nullable = false)
	private String nome;
	
	@Column(name = "valor", length=50, nullable = false)
	private Double valor;
	
	@Column(name = "datadespesafixa", nullable = false)
	private Date dataDespesaFixa;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", nullable = false)
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