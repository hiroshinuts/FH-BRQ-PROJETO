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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
@NamedQueries(
		
		{
			
			@NamedQuery(name= Compra.FIND_ALL, 
			query="select c from Compra as c "),
			
			@NamedQuery(name= Compra.FIND_PURCHASE, 
			query="select c from Compra as c where c.cliente = :p1")
			
		}
		
		)
public class Compra {
	
	public static final String FIND_ALL="compra.findall";
	public static final String FIND_PURCHASE="compra.findpurchase";
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  	      
	@Column(name = "idcompra")
	private Integer idCompra;

	
	@ManyToOne
	@JoinColumn(name = "idcliente", nullable = false)// foreign key
	private Cliente cliente;
	
	@Column(name="valorcompra")
	private Double valorCompra;
	
	@OneToMany(mappedBy = "compra")	
	private List<ItemDeCompra> itemDeCompra;

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	
	public Compra(Integer idCompra, Cliente cliente, Double valorCompra, List<ItemDeCompra> itemDeCompra) {
		this.idCompra = idCompra;
		this.cliente = cliente;
		this.valorCompra = valorCompra;
		this.itemDeCompra = itemDeCompra;
	}


	public Integer getIdCompra() {
		return idCompra;
	}


	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public Double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}


	public List<ItemDeCompra> getItemDeCompra() {
		return itemDeCompra;
	}


	public void setItemDeCompra(List<ItemDeCompra> itemDeCompra) {
		this.itemDeCompra = itemDeCompra;
	}

	@Override
	public String toString() {
		return "Compra idCompra=" + idCompra+" Cliente id="+cliente.getIdCliente();
	}
	
	
	


}
