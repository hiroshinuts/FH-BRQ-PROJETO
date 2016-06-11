package br.com.brcom.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity  
@Table(name = "cliente")
@NamedQueries(
		
		{
			@NamedQuery(name= Cliente.FIND_LOGIN, 
			query="select c from Cliente as c where c.email = :p1 and c.senha = :p2")
			
		}
		
		)
public class Cliente extends Usuario{
	
	public static final String FIND_LOGIN="cliente.findlogin";
	public static final String FIND_PURCHASE="cliente.findpurchase";

	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  	      
	@Column(name = "idcliente")  
	private Integer idCliente;
	
	@Column(name = "cartaocredcliente")
	private Integer cartaoCredCliente;
	
	// um cliente para varias compras
	@OneToMany(mappedBy = "cliente") 
	private List<Compra> comprasCliente;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}


	public Cliente(Integer idCliente, String nome, String email, String senha, String logradouro, String cidade, String estado, Integer cartaoCredCliente,
			List<Compra> comprasCliente) {
		super(nome, email, senha, logradouro, cidade, estado);
		this.idCliente = idCliente;
		this.cartaoCredCliente = cartaoCredCliente;
		this.comprasCliente = comprasCliente;
	}

	
	

	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	

	public Integer getCartaoCredCliente() {
		return cartaoCredCliente;
	}


	public void setCartaoCredCliente(Integer cartaoCredCliente) {
		this.cartaoCredCliente = cartaoCredCliente;
	}


	public List<Compra> getComprasCliente() {
		return comprasCliente;
	}


	public void setComprasCliente(List<Compra> comprasCliente) {
		this.comprasCliente = comprasCliente;
	}

	@Override
	public String toString() {
		return "IdCliente= "+idCliente+super.toString();
	}
	
	
	

}  