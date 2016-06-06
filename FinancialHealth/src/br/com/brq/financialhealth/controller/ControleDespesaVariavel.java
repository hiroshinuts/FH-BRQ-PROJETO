package br.com.brq.financialhealth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.financialhealth.entities.DespesaVariavel;
import br.com.brq.financialhealth.persistence.DAODespesaVariavel;
import br.com.brq.financialhealth.persistence.DAOUsuario;
import br.com.brq.financialhealth.util.FormatacaoData;

@WebServlet("/ControleDespesaVariavel")
public class ControleDespesaVariavel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String action = request.getParameter("action");
    	
    	if("cadastrar".equals(action)){
    	
    		try{
    		DespesaVariavel dv = new DespesaVariavel();
    		dv.setNome(request.getParameter("nome"));
    		dv.setValor(Double.parseDouble(request.getParameter("valor")));
    		dv.setDataDespesaVariavel(FormatacaoData.convertToDate(request.getParameter("datadespesavariavel")));
    		
    		DAOUsuario daoUsuario = new DAOUsuario();
    		Integer idUsuario = Integer.parseInt(request.getParameter("usuario"));
    		dv.setUsuario(daoUsuario.findById(idUsuario));
    		
    		DAODespesaVariavel daoDv = new DAODespesaVariavel();
    		daoDv.saveOrUpdate(dv);
    		
    		request.setAttribute("mensagem", "Despesa gravada com sucesso!");
    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		request.setAttribute("mensagem", e.getMessage());
	    	}finally{
	    		request.getRequestDispatcher("/logado/indexlogado.jsp").forward(request, response);
	    	}
    	}
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

}
