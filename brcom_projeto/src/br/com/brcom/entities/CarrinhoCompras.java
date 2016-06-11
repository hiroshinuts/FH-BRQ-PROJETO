package br.com.brcom.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class CarrinhoCompras {
	
	

	private Integer idCarrinho;
	private Cliente cliente;
	private List<Produto> listaProdutos;
	
	public CarrinhoCompras() {
		// TODO Auto-generated constructor stub
	}


	public CarrinhoCompras(Integer idCarrinho, Cliente cliente, List<Produto> listaProdutos) {
		super();
		this.idCarrinho = idCarrinho;
		this.cliente = cliente;
		this.listaProdutos = listaProdutos;
	}



	public Integer getIdCarrinho() {
		return idCarrinho;
	}



	public void setIdCarrinho(Integer idCarrinho) {
		this.idCarrinho = idCarrinho;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}


	@Override
	public String toString() {
		System.out.print("\nCarrinho");
		for(Produto p : listaProdutos){
			System.out.print(p);
		}
		return "idCarrinho=" + idCarrinho;
	}
	
	
	

}
