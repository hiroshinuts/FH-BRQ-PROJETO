package br.com.brcom.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.brcom.entities.Cliente;
import br.com.brcom.entities.Compra;
import br.com.brcom.entities.ItemDeCompra;
import br.com.brcom.entities.Produto;
import br.com.brcom.persistence.DAOCliente;
import br.com.brcom.persistence.DAOCompra;
import br.com.brcom.persistence.DAOItemDeCompra;
import br.com.brcom.persistence.DAOProduto;
import br.com.brcom.util.MD5;

@WebServlet("/ControleCliente")
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		

		if ("cadastrar".equalsIgnoreCase(action)) {
			Cliente c = new Cliente();
			DAOCliente d = new DAOCliente();
			String destino = "index.jsp";
			String senha = request.getParameter("senha");
			String senhaConfirm = request.getParameter("confirmarsenha");

			try {

				if (senha.equals(senhaConfirm)) {

					c.setNome(request.getParameter("nome"));
					c.setEmail(request.getParameter("email"));
					c.setSenha(MD5.encryptPassword(request.getParameter("senha")));
					d.insert(c);

					Cliente cliente = d.findByLoginSenha(c.getEmail(), MD5.encryptPassword(c.getSenha()));
					
					System.out.println(c);
					
					// cadastra e já loga direto....
					HttpSession session = request.getSession();
					session.setAttribute("usuariologado", cliente);

				} else {
					
					destino = "telas/cliente/cadastrocliente.jsp";
					request.setAttribute("mensagem", "As senhas estão diferentes");

				}

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				request.getRequestDispatcher(destino).forward(request, response);

			}

		} else if ("login".equalsIgnoreCase(action)){
			
			PrintWriter out = response.getWriter();
				try {
					
					
					Cliente c = new Cliente();
					DAOCliente d = new DAOCliente();
					DAOCompra daoCompra = new DAOCompra();
					String senha = MD5.encryptPassword(request.getParameter("senha"));
					String email = request.getParameter("email");
					
					c = d.findByLoginSenha(email, senha);
					
					System.out.println(c);
					
					if(c!= null){
						//out.println("Pessoa logado com sucesso");
						HttpSession session = request.getSession();	
						List<Compra> listagemDeCompra = daoCompra.findPurchases(c.getIdCliente());
							
						session.setAttribute("usuariologado", c);
						session.setAttribute("listagemCompra", listagemDeCompra);
						
						System.out.println(listagemDeCompra);
						
					} else {
						throw new Exception("Email ou senha estão incorretos");
					}				
					
					
				} catch (Exception e) {
					
					out.println(e.getMessage());
					e.printStackTrace();
					
				}
				
			
		} else if ("logout".equalsIgnoreCase(action)){
			
			// remover o user logado da session
			HttpSession session = request.getSession();
			session.removeAttribute("funcionariologado");
			session.invalidate();
			
			// redirecionar para a index --- esse tipo de redirect só redireciona e não manda mensagem....
			response.sendRedirect("index.jsp");
			
		}

	}

}
