	package br.com.brcom.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemdecompra")
@NamedQueries(
		
		{
			
			@NamedQuery(name= ItemDeCompra.FIND_BY_USER, 
			query="select ic from ItemDeCompra as ic where idcompra = :p1 "),
			
			@NamedQuery(name= ItemDeCompra.FIND_ALL, 
			query="select ic from ItemDeCompra as ic")
			
		}
		
		)
public class ItemDeCompra {
	
	public static final String FIND_BY_USER="itemdecompra.findrespectiveuser";
	public static final String FIND_ALL="itemdecompra.findall";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "primarykey")
	private Integer primaryKey;
	
	@ManyToOne
	@JoinColumn(name = "idcompra", nullable = false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "idproduto", nullable = false) 
	private Produto produto;
	
	public ItemDeCompra() {
		// TODO Auto-generated constructor stub
	}



	public ItemDeCompra(Integer primaryKey, Compra compra, Produto produto) {
		this.primaryKey = primaryKey;
		this.compra = compra;
		this.produto = produto;
	}

	public Integer getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	

	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	@Override
	public String toString() {
		return "ItemDeCompra [primaryKey=" + primaryKey + ", compra=" + compra + ", produto=" + produto + "]";
	}

	
	
	
	

}



