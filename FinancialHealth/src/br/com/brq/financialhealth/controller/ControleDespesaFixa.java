package br.com.brq.financialhealth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.DAODespesaFixa;
import br.com.brq.financialhealth.persistence.DAOUsuario;
import br.com.brq.financialhealth.util.FormatacaoData;

@WebServlet("/ControleDespesaFixa")
public class ControleDespesaFixa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String action = request.getParameter("action");
    	
    	if("cadastrar".equals(request.getParameter("action"))){
    		
    		try{
    			DespesaFixa df = new DespesaFixa();
    			df.setNome(request.getParameter("nome"));
    			df.setValor(Double.parseDouble(request.getParameter("valor")));
    			df.setDataDespesaFixa(FormatacaoData.convertToDate(request.getParameter("datadespesafixa")));
    			
    			DAOUsuario daoUsuario = new DAOUsuario();
    			
    			HttpSession session = request.getSession();
    			Usuario u = (Usuario) session.getAttribute("usuariologado");
    			
    			df.setUsuario(u);
    			
    			DAODespesaFixa daoDv = new DAODespesaFixa();
        		daoDv.saveOrUpdate(df);
        		
        		request.setAttribute("mensagem", "Despesa gravada com sucesso!");
    		
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
