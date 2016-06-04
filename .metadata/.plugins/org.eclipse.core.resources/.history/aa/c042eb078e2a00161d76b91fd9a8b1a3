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
@Table(name = "despesafixa")
@NamedQueries(
		{@NamedQuery(name = DespesaFixa.FINDBY_NOME,
				query = "select desf from DespesaFixa as desf where inv.nome like :p1 AND"
						+ " id=:idusuario order by desf.nome"),
		@NamedQuery(name = DespesaFixa.FINDBY_DATA,
				query = "select * from DespesaFixa where datadespesafixa between :d1 and :d2 order by despesafixa")
			
		}
)
public class DespesaFixa {
	
	public static final String FINDBY_NOME = "investimento.findbynome";
	public static final String FINDBY_DATA = "investimento.findbydata";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iddespesa")
	private Integer idDespesaFixa;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "valor", length = 50, nullable = false)
	private Double valor;
	
	@Column(name= "datadespesafixa", nullable = false)
	private Date dataDespesaFixa;
	
	@JoinColumn(name = "idusuario", nullable = false)
	@ManyToOne
	private Usuario usuario;
	
	public DespesaFixa() {
		// TODO Auto-generated constructor stub
	}

	public DespesaFixa(Integer idDespesaFixa, String nome, Double valor, Date dataDespesaFixa) {
		super();
		this.idDespesaFixa = idDespesaFixa;
		this.nome = nome;
		this.valor = valor;
		this.dataDespesaFixa = dataDespesaFixa;
	}

	public DespesaFixa(Integer idDespesaFixa, String nome, Double valor, Date dataDespesaFixa, Usuario usuario) {
		super();
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
		return "DespesaFixa [idDespesaFixa=" + idDespesaFixa + ", nome=" + nome + ", valor=" + valor
				+ ", dataDespesaFixa=" + dataDespesaFixa + ", usuario=" + usuario + "]";
	}
	
	@Override
	public int hashCode() {
		return idDespesaFixa.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof DespesaFixa){
			DespesaFixa df = (DespesaFixa) obj;
			return df.getIdDespesaFixa().equals(idDespesaFixa);
		}
		
		return false;
	}
}
