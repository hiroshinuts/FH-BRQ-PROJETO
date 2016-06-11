package br.com.brcom.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.brcom.entities.CarrinhoCompras;
import br.com.brcom.entities.Cliente;
import br.com.brcom.entities.Compra;
import br.com.brcom.entities.ItemDeCompra;
import br.com.brcom.entities.Produto;
import br.com.brcom.entities.types.Categoria;
import br.com.brcom.persistence.DAOCompra;
import br.com.brcom.persistence.DAOItemDeCompra;
import br.com.brcom.persistence.DAOProduto;
import br.com.brcom.util.Pasta;

@WebServlet("/ControleProduto")
@MultipartConfig()
public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControleProduto() {
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
				
		if("cadastrar".equalsIgnoreCase(action)){
			
			try {
				
				Produto p = new Produto();
				
				p.setNomeProduto(request.getParameter("nome"));
				p.setDescricaoProduto(request.getParameter("descricao"));
				p.setPrecoProduto(Double.parseDouble(request.getParameter("preco")));
				p.setQuantidadeProduto(Integer.parseInt(request.getParameter("quantidade")));
				p.setCategoria(Categoria.valueOf(request.getParameter("categoria")));
				
				UUID guid = UUID.randomUUID();
				p.setFoto(guid.toString()+".jpg");
				
				DAOProduto d = new DAOProduto();
				d.insert(p);
				
				Part foto = request.getPart("foto");
				
				String pasta = Pasta.CAMINHO;
				
				FileOutputStream stream = new FileOutputStream(pasta + "/" + p.getFoto());
				InputStream input = foto.getInputStream();
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0){
					stream.write(buffer);
				}
				stream.close();
				
				request.setAttribute("mensagem", "produto "+p.getNomeProduto()+ " cadastrado");
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {
				
				request.getRequestDispatcher("arearestrita/funcionario/index.jsp").forward(request, response);
								
			}
			
			
					
		} else if ("excluir".equalsIgnoreCase(action)){
			
			try{
				
				Integer idProduto = Integer.parseInt(request.getParameter("id"));
				
				DAOProduto d = new DAOProduto();
				Produto p = d.findById(idProduto);
				
				d.delete(p);
				
				request.setAttribute("mensagem", "Produto "+p.getNomeProduto()+" deletado com sucesso");
				
			} catch (Exception e){
				
				request.setAttribute("mensagem", e.getMessage());
				
			} finally {
				
				request.getRequestDispatcher("arearestrita/funcionario/index.jsp").forward(request, response);
				
			}
			
			
		} else if ("visualizar".equalsIgnoreCase(action)){
			
			Integer idProduto = Integer.parseInt(request.getParameter("id"));
			
			DAOProduto d = new DAOProduto();
			
			try {
				
				Produto p = d.findById(idProduto);
				request.setAttribute("produto", p);
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensagem", e.getMessage());
			} finally {
				
				request.getRequestDispatcher("telas/visualisarproduto.jsp").forward(request, response);
				
			}
			
			
		} else if("comprardocarrinho".equalsIgnoreCase(action)){
			
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
						System.out.println(cliente);
						
						Compra compra = new Compra();
						compra.setCliente(cliente);
						
						DAOCompra daoCompra = new DAOCompra();
						daoCompra.insert(compra);
												
						System.out.println(compra);
						
						DAOItemDeCompra daoItemDeCompra = new DAOItemDeCompra();
						
						// relaciona a compra com os items de compra e os insere no db
						for(ItemDeCompra i : listaDeItems){
							i.setCompra(compra);
							daoItemDeCompra.insert(i);
						}
						
						
						for(ItemDeCompra i : listaDeItems){
							System.out.println(i);
						}
						
										
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
						
					}
					
				} else{
					// caso o usuario nao estiver logado, poe o item no carrinho e o envia para a tela de cadastro
					
					
					
					Integer id = Integer.parseInt(request.getParameter("id"));
					DAOProduto d = new DAOProduto();			
					Produto p = d.findById(id);
					
					CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");
					
					carrinho.getListaProdutos().add(p);
					
					request.getRequestDispatcher("brcom_projeto/telas/cliente/cadastrocliente.jsp").forward(request, response);
					
				}
				
				
				
				
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally{
				
			}	
			
			
			
			// Adiciona produtos ao carrinho. -- está ok
		} else if("adicionaraocarrinho".equalsIgnoreCase(action)){
			
			HttpSession session = request.getSession();
			
			//se o carrinho não está nulo, add o produto nele
			if(session.getAttribute("carrinho")!= null){
				
				try {
					
					Integer id = Integer.parseInt(request.getParameter("id"));
					DAOProduto d = new DAOProduto();
					Produto p;
					p = d.findById(id);
					
					Produto aux = (Produto) session.getAttribute("produto");
					
					if(aux.getQuantidadeProduto()<=0 || p.getQuantidadeProduto()<=0){
						

						request.setAttribute("mensagem", "Estoque vazio!");
					
						
					} else {
						
						
						
						
						p.setQuantidadeProduto(aux.getQuantidadeProduto()-1);
						Double precoTotalCompra = p.getPrecoProduto()+(Double) session.getAttribute("precoTotalCompra");
						
						System.out.println("outras vez "+p.getQuantidadeProduto());
						
						CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");
						
						carrinho.getListaProdutos().add(p);
						
						session.setAttribute("produto", p);
						request.setAttribute("mensagem", "Produto adicionado ao carrinho");
						session.setAttribute("carrinho", carrinho);
						session.setAttribute("precoTotalCompra", precoTotalCompra);
						
					}
					
					
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				} finally{
					
					request.getRequestDispatcher("telas/visualisarproduto.jsp").forward(request, response);
					
				}
				
			
			  // se o carrinho não alguma coisa,cria um novo e adiciona mais coisas
			} else {
				
				try {
					
					Integer id = Integer.parseInt(request.getParameter("id"));
					DAOProduto d = new DAOProduto();			
					Produto p;
					p = d.findById(id);
					
					List<Produto> listaProdutos = new ArrayList<Produto>();
					listaProdutos.add(p);
					
					
					Double precoTotalCompra = p.getPrecoProduto();
					
					p.setQuantidadeProduto(p.getQuantidadeProduto()-1);
					
					CarrinhoCompras carrinho = new CarrinhoCompras();
					carrinho.setListaProdutos(listaProdutos);										
					
					request.setAttribute("mensagem", "Produto adicionado ao carrinho");
					session.setAttribute("produto", p);
					session.setAttribute("carrinho", carrinho);
					session.setAttribute("precoTotalCompra", precoTotalCompra);
					
					System.out.println("1 vez "+p.getQuantidadeProduto());
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					
					request.getRequestDispatcher("telas/visualisarproduto.jsp").forward(request, response);
					
				}
				
			}
			
			
		} else if("adicionaraocarrinhodeslogado".equalsIgnoreCase(action)){
			
			
			
			
			
		} else if("excluirdocarrinho".equalsIgnoreCase(action)){
			
			HttpSession session = request.getSession();
			CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("carrinho");
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			carrinho.getListaProdutos().remove(id);
			
			session.setAttribute("carrinho", carrinho);
					
			request.getRequestDispatcher("/brcom_projeto/arearestrita/cliente/carrinho.jsp").forward(request, response);
			
			
		} else if("atualizar".equalsIgnoreCase(action)){
			
			PrintWriter out = response.getWriter();
			Integer id = Integer.parseInt(request.getParameter("id"));			
			DAOProduto d = new DAOProduto();
			
			try {
				
				Produto p = d.findById(id);
				p.setNomeProduto(request.getParameter("nome"));
				p.setDescricaoProduto(request.getParameter("descricao"));
				p.setQuantidadeProduto(Integer.parseInt(request.getParameter("quantidade")));
				p.setPrecoProduto(Double.parseDouble(request.getParameter("preco")));
				
				Part foto = request.getPart("foto");
				if(foto != null){
					
					UUID guid = UUID.randomUUID();
					p.setFoto(guid.toString()+".jpg");
					
					String pasta = Pasta.CAMINHO;
					
					FileOutputStream stream = new FileOutputStream(pasta + "/" + p.getFoto());
					InputStream input = foto.getInputStream();
					byte[] buffer = new byte[1024];
					while(input.read(buffer) > 0){
						stream.write(buffer);
					}
					stream.close();
					
				} 
				
				d.update(p);
				
				request.getRequestDispatcher("arearestrita/funcionario/index.jsp").forward(request, response);
				
				
			} catch (Exception e) {
				out.println("Erro ao atualizar");
				e.printStackTrace();
			}
			
			
		} else if("editar".equalsIgnoreCase(action)){
			
			
			
			
			try {
				
				Integer id = Integer.parseInt(request.getParameter("id"));
				DAOProduto d = new DAOProduto();
				Produto p = d.findById(id);
				
				request.setAttribute("produto", p);
				
				request.getRequestDispatcher("arearestrita/funcionario/editarproduto.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensagem", e);
				
			} 
			
			
			
			
		}
		
	}

}
