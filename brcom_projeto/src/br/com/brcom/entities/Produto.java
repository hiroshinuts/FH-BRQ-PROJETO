package br.com.brcom.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.brcom.entities.types.Categoria;

@Entity
@Table(name = "produto")
@NamedQueries(
		
		{
			
			@NamedQuery(name= Produto.FIND_ALL, 
			query="select p from Produto as p "),
			
			@NamedQuery(name= Produto.FIND_SPEC, 
			query="select p from Produto as p where categoriaproduto = :p1"),
			
			//@NamedQuery(name= Produto.FIND_BY_PURCHASE, 
			//query="select p from Produto as p inner join p.itemDeCompra as c where p.idProduto = c.idProduto")
			
		}
		
		)
public class Produto {
	
	public static final String FIND_ALL="produto.findall";
	public static final String FIND_SPEC="produto.findspec";
	public static final String FIND_BY_PURCHASE="produto.findbypurchase";

	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  	      
	@Column(name = "idproduto")
	private Integer idProduto;
	
	@Column(name = "nomeproduto", length = 50, nullable = false)
	private String nomeProduto;
	
	@Column(name="fotoproduto", length = 50, nullable = false)
	private String foto;
	
	@Column(name = "descricaoproduto", nullable = false)
	private String descricaoProduto;
	
	@Column(name = "precoproduto", nullable = false)
	private Double precoProduto;
	
	@Column(name = "quantidadeproduto", nullable = false)
	private Integer quantidadeProduto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "categoriaproduto", nullable = false)
	private Categoria categoria;
	
	@OneToMany(mappedBy="produto")
	private List<ItemDeCompra> itemDeCompra;
	

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	

	public Produto(Integer idProduto, String nomeProduto, String foto, String descricaoProduto, Double precoProduto,
			Integer quantidadeProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.foto = foto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
		this.quantidadeProduto = quantidadeProduto;
	}



	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<ItemDeCompra> getItemDeCompra() {
		return itemDeCompra;
	}



	public void setItemDeCompra(List<ItemDeCompra> itemDeCompra) {
		this.itemDeCompra = itemDeCompra;
	}
	
	



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", descricaoProduto="
				+ descricaoProduto + ", precoProduto=" + precoProduto + ", quantidadeProduto=" + quantidadeProduto;
	}
	
	

}
