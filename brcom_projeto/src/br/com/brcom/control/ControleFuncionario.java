package br.com.brcom.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.brcom.entities.Funcionario;
import br.com.brcom.persistence.DAOFuncionario;
import br.com.brcom.util.MD5;

@WebServlet("/ControleFuncionario")
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControleFuncionario() {
		super();
		// TODO Auto-generated constructor stub
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

		System.out.println(action);
		
		if ("autenticarloginfuncionario".equalsIgnoreCase(action)) {
			
			
			String destino = "telas/funcionario/loginfuncionario.jsp";

			

			try {
				
				DAOFuncionario d = new DAOFuncionario();
				Funcionario f = new Funcionario();
				f.setEmail(request.getParameter("email"));
				f.setSenha(MD5.encryptPassword(request.getParameter("senha")));

				Funcionario funcionario;
				funcionario = d.findByLoginSenha(f.getEmail(), f.getSenha());
				
				

				if (funcionario != null) {

					HttpSession session = request.getSession();					
					session.setAttribute("funcionariologado", funcionario);					
					destino = "arearestrita/funcionario/index.jsp";

				} else {
					
					request.setAttribute("mensagem", "Funcionário não encontrado. Tente novamente");
					
				}

			} catch (Exception e) {
				
				e.printStackTrace();
				request.setAttribute("mensagem", "Ocorreu um erro. Tente novamente");
				
			} finally {
				
				request.getRequestDispatcher(destino).forward(request, response);
				
				
			}
			

		} else if ("logout".equalsIgnoreCase(action)) {
			
						// remover o user logado da session
						HttpSession session = request.getSession();
						session.removeAttribute("funcionariologado");
						session.invalidate();
						
						// redirecionar para a index --- esse tipo de redirect só redireciona e não manda mensagem....
						response.sendRedirect("index.jsp");

		}

	}

}
