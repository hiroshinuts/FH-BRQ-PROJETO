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
@Table(name = "investimento")
//@NamedQueries(
//		{
//			@NamedQuery(name = Investimento.FINDBY_NOME,
//					query = "select inv from Investimento as inv where inv.nome like :p1 AND"
//							+ " id=idusuario order by inv.nome"),
//			@NamedQuery(name = Investimento.FINDBY_DATA,
//					query = "select du from Investimento as du where datainvestimento between :d1 and :d2 AND id=usuario order by datainvestimento")
//			
//		}
//		)
public class Investimento {
	
	public static final String FINDBY_NOME = "investimento.findbynome";
	public static final String FINDBY_DATA = "investimento.findbydata";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idinvestimento")
	private Integer idInvestimento;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "valor", length = 50, nullable = false)
	private Double valor;
	
	@Column(name = "datainvestimento", nullable = false)
	private Date dataInvestimento;
	
	@ManyToOne
	@JoinColumn(name = "idusuario", nullable = false)
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

	