package br.com.brq.financialhealth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.financialhealth.entities.Investimento;
import br.com.brq.financialhealth.persistence.DAOInvestimento;
import br.com.brq.financialhealth.persistence.DAOUsuario;
import br.com.brq.financialhealth.util.FormatacaoData;

@WebServlet("/ControleInvesimento")
public class ControleInvesimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleInvesimento() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
    	
    	if("cadastrar".equals(action)){
    		
    		try{
    			
    			Investimento inv = new Investimento();
    			inv.setNome(request.getParameter("nome"));
    			inv.setValor(Double.parseDouble(request.getParameter("valor")));
    			inv.setDataInvestimento(FormatacaoData.convertToDate(request.getParameter("datainvestimento")));

    			DAOUsuario daoUsuario = new DAOUsuario();
    			
    			Integer idUsuario = Integer.parseInt(request.getParameter("usuario"));
    			inv.setUsuario(daoUsuario.findById(idUsuario));
    			
    			DAOInvestimento di = new DAOInvestimento();
    			di.saveOrUpdate(inv);
    			
    			request.setAttribute("mensagem", "Investimento gravado com sucesso!");
    			
    			
    		}catch(Exception e){
    			
    			e.printStackTrace();
    			request.setAttribute("mensagem", e.getMessage());
    			
    		}finally{
    			
    			request.getRequestDispatcher("/logado/indexlogado.jsp").forward(request, response);
    		}
    		
    		
    	}
    	
    	//elseif
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

}