package br.com.brq.financialhealth.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.brq.financialhealth.services.Estimativa;

/**
 * 
 *Servlet de Controle -  ControleEstimativa
 *
 *Controla as requisoes para a pagina de estimativa
 * 
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */
@WebServlet("/ControleEstimativa")
public class ControleEstimativa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleEstimativa() {
        super();
    }
    
    /**
     * Metodo que recebe requisicoes das paginas JSP, que buscam no banco de dados informações por uma data especifica
     * de um usuario especifico logado na sessao
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String action = request.getParameter("action");
    	Integer idade;
    	Double valor1;
    	Double valor2;
    	Double valor3;
    	Double valor4;
    	Double resultado;
    	
    	if("calcular".equalsIgnoreCase(action)){
    		
    		try{
    		Estimativa est = new Estimativa();
    				
    		idade = Integer.parseInt(request.getParameter("idade"));
    		valor1 = Double.parseDouble(request.getParameter("valor18_29"));
    		valor2 = Double.parseDouble(request.getParameter("valor30_39"));
    		valor3 = Double.parseDouble(request.getParameter("valor40_49"));
    		valor4 = Double.parseDouble(request.getParameter("valor50_65"));	

    		resultado = est.lancaFuturo(idade, valor1, valor2, valor3, valor4);
    		
    		request.setAttribute("mensagem", resultado);
			request.getRequestDispatcher("/logado/estimativa.jsp").forward(request, response);
    		
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		
    	}
    	
    }
    
    /**
     * Metodo que envia as requisicoes para o metodo execute
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	 /**
     * Metodo que envia as requisicoes para o metodo execute
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
