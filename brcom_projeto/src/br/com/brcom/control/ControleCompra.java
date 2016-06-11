package br.com.brcom.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.brcom.entities.CarrinhoCompras;
import br.com.brcom.entities.Cliente;
import br.com.brcom.entities.Compra;
import br.com.brcom.entities.ItemDeCompra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistence.DAOCompra;
import br.com.brcom.persistence.DAOItemDeCompra;
import br.com.brcom.persistence.DAOProduto;

@WebServlet("/ControleCompra")
public class ControleCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleCompra() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		
		
		
		if("comprar".equalsIgnoreCase(action)){
			
			try {
				
				HttpSession session = request.getSession();
				
			
				// caso usuario esteja logado
				if(session.getAttribute("usuariologado")!=null){
					
					// caso usuario esteja logado e carrinho com alguma coisa
					if(session.getAttribute("carrinho")!= null){					
						
						//pega o carrinho
						CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");
						
						List<ItemDeCompra> listaDeItems = new ArrayList<ItemDeCompra>();
						
						//seta os produtos nos items de compras
						for(Produto p : carrinho.getListaProdutos()){
							ItemDeCompra itemDeCompra = new ItemDeCompra();
							itemDeCompra.setProduto(p);
							listaDeItems.add(itemDeCompra);
							System.out.println(itemDeCompra.getProduto().toString());
						}
						
						
						// pega os dados do cliente
						Cliente cliente = (Cliente) session.getAttribute("usuariologado");
						Compra compra = new Compra();
						compra.setCliente(cliente);
						compra.setValorCompra((Double) session.getAttribute("precoTotalCompra"));
						DAOCompra daoCompra = new DAOCompra();
						daoCompra.insert(compra);
						DAOItemDeCompra daoItemDeCompra = new DAOItemDeCompra();
						
						// relaciona a compra com os items de compra e os insere no db
						for(ItemDeCompra i : listaDeItems){
							i.setCompra(compra);
							daoItemDeCompra.insert(i);
						}
						
						// sobe a lista de compras na sessão
						List<Compra> listagemDeCompra = daoCompra.findPurchases(cliente.getIdCliente());
						
						
						
						
						session.setAttribute("usuariologado", cliente);
						//session.setAttribute("comprasrealizadas", itensComprados);
						session.setAttribute("listagemCompra", listagemDeCompra);
						
						
						request.getRequestDispatcher("/brcom_projeto/arearestrita/cliente/dadoscliente.jsp").forward(request, response);
						
						// caso usuario esteja logado e carrinho vazio
					} else{
						
						
						
						Integer id = Integer.parseInt(request.getParameter("id"));
						DAOProduto d = new DAOProduto();			
						Produto p;
						p = d.findById(id);
						
						List<Produto> listaProdutos = new ArrayList<Produto>();		
						CarrinhoCompras carrinho = new CarrinhoCompras();
						
						listaProdutos.add(p);
						carrinho.setListaProdutos(listaProdutos);
						
						
						
						session.setAttribute("carrinho", listaProdutos);
						request.getRequestDispatcher("arearestrita/cliente/validarcompra.jsp").forward(request, response);
						
					}
					
				} else{
					// caso o usuario nao estiver logado, poe o item no carrinho e o envia para a tela de cadastro
						
					Integer id = Integer.parseInt(request.getParameter("id"));
					
					DAOProduto d = new DAOProduto();			
					Produto p = d.findById(id);
					
					CarrinhoCompras carrinho = new CarrinhoCompras();
					
					carrinho.setListaProdutos(new ArrayList<Produto>());
					carrinho.getListaProdutos().add(p);
					
					
					session.setAttribute("carrinho", carrinho);
					request.getRequestDispatcher("telas/cliente/cadastrocliente.jsp").forward(request, response);
					
					
				}
				
				
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
			
			
		} else if ("validarcompra".equalsIgnoreCase(action)){
			

			HttpSession session = request.getSession();
			
			if(session.getAttribute("carrinho") != null){
				System.out.println("não nulo");
				request.getRequestDispatcher("arearestrita/cliente/validarcompra.jsp").forward(request, response);
				
				
			} else {
				System.out.println("nulo");
				request.setAttribute("mensagem", "Carrinho de compras vazio!");
				request.getRequestDispatcher("arearestrita/cliente/carrinho.jsp").forward(request, response);
				
			}
			
			
		}
		
		
		
	}
	
}
