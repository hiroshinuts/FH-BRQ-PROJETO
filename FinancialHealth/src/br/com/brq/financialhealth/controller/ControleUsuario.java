package br.com.brq.financialhealth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.DAOUsuario;
import br.com.brq.financialhealth.util.Criptografia;
import br.com.brq.financialhealth.util.FormatacaoData;

@WebServlet("/ControleUsuario")
public class ControleUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleUsuario() {
        super();
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String action = request.getParameter("action");
    	
    	if("cadastrarUsuario".equalsIgnoreCase(action)){
    		
    		try{
    			Usuario user = new Usuario();
    			user.setNome(request.getParameter("nome"));
    			user.setEmail(request.getParameter("email"));
    			user.setCpf(request.getParameter("cpf"));
    			user.setDataNascimento(FormatacaoData.convertToDate(request.getParameter("datanascimento")));
    			user.setRendimentoMensalLiquido(Double.parseDouble(request.getParameter("rendimentomensalliquido")));
    			user.setSenha(Criptografia.encriptarSenha(request.getParameter("senha")));
    			
    			DAOUsuario u = new DAOUsuario();
    			u.saveOrUpdate(user);
    			
    			request.setAttribute("mensagem", "Usuario " + user.getNome() + " gravado com sucesso!");
    			
    			
    		}catch(Exception e){
    			
    			request.setAttribute("mensagem", e.getMessage());
    			
    		}finally{
    			request.getRequestDispatcher("indexlogado.jsp").forward(request, response);
    		}
    
    
    	}
    	//else if
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
}