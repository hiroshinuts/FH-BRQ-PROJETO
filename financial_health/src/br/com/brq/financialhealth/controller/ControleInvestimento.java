package br.com.brq.financialhealth.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.brq.financialhealth.entities.DespesaFixa;
import br.com.brq.financialhealth.entities.DespesaVariavel;
import br.com.brq.financialhealth.entities.Investimento;
import br.com.brq.financialhealth.entities.Usuario;
import br.com.brq.financialhealth.persistence.DAODespesaFixa;
import br.com.brq.financialhealth.persistence.DAODespesaVariavel;
import br.com.brq.financialhealth.persistence.DAOInvestimento;
import br.com.brq.financialhealth.util.FormatacaoData;

/**
 * 
 *Servlet de Controle -  ControleInvestimento
 *
 *Controla as requisoes das paginas que necessitam uma busca de informacoes por data
 * 
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */
@WebServlet("/ControleInvestimento")
public class ControleInvestimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleInvestimento() {
        super();
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
    	
    	if("cadastrar".equals(action)){
    		
    		try{
    			
    			Investimento inv = new Investimento();
    			inv.setNome(request.getParameter("nome"));
    			inv.setValor(Double.parseDouble(request.getParameter("valor")));
    			inv.setDataInvestimento(FormatacaoData.convertToDate(request.getParameter("datainvestimento")));

    			
    			HttpSession session = request.getSession();
    			Usuario u = (Usuario) session.getAttribute("usuariologado");
    			
    			inv.setUsuario(u);
    			
    			DAOInvestimento di = new DAOInvestimento();
    			di.saveOrUpdate(inv);
    			
    			request.setAttribute("mensagem", "Investimento gravado com sucesso!");
    			//
    			Calendar c =  Calendar.getInstance();
    			
    			int ano = c.get(Calendar.YEAR);
    			int mes = c.get(Calendar.MONTH);
    			int dia = 1;
    			
    			c.set(ano, mes, dia);
    			
    			int numeroDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
    			
    			Date dateIni = c.getTime();
    			
    			c.add(Calendar.DAY_OF_MONTH, numeroDias-1);
    			
    			Date dateFim = c.getTime();
    			
    			DAOInvestimento daoInv = new DAOInvestimento();
    			DAODespesaFixa daoDF = new DAODespesaFixa();
    			DAODespesaVariavel daoDV = new DAODespesaVariavel();
    			
    			List<Investimento> listaInv = daoInv.findByData(dateIni, dateFim, u.getIdUsuario());
    			List<DespesaFixa> listaDF = daoDF.findByData(dateIni, dateFim, u.getIdUsuario());
    			List<DespesaVariavel> listaDV = daoDV.findByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaInv = daoInv.somaByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaDF = daoDF.somaByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaDV = daoDV.somaByData(dateIni, dateFim, u.getIdUsuario());
    			
    			session.setAttribute("dinv", listaInv);
    			session.setAttribute("ddf", listaDF);
    			session.setAttribute("ddv", listaDV);
    			session.setAttribute("somainv", somaInv);
    			session.setAttribute("somadf", somaDF);
    			session.setAttribute("somadv", somaDV);
				
				
				
    			
    		}catch(Exception e){
    			
    			e.printStackTrace();
    			request.setAttribute("mensagem", e.getMessage());
    			
    		}finally{
    			
    			request.getRequestDispatcher("/logado/indexlogado.jsp").forward(request, response);
    		}
    		
    		
    	}
    	
    	//elseif
    	else if("excluirinvindex".equalsIgnoreCase(action)){
    		try {
    		HttpSession session = request.getSession();
    		DAOInvestimento daoI = new DAOInvestimento();
    		Integer id = Integer.parseInt(request.getParameter("idinv"));
    		Investimento i = daoI.findById(id);
    		daoI.delete(i);
    		//Recarregar pagina atualizada
    		Calendar c =  Calendar.getInstance();
			
			int ano = c.get(Calendar.YEAR);
			int mes = c.get(Calendar.MONTH);
			int dia = 1;
			
			c.set(ano, mes, dia);
			
			int numeroDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			Date dateIni = c.getTime();
			
			c.add(Calendar.DAY_OF_MONTH, numeroDias-1);
			
			Date dateFim = c.getTime();
			
			DAOInvestimento daoInv = new DAOInvestimento();
			DAODespesaFixa daoDF = new DAODespesaFixa();
			DAODespesaVariavel daoDV = new DAODespesaVariavel();
			Usuario u = (Usuario) session.getAttribute("usuariologado");
			List<Investimento> listaInv = daoInv.findByData(dateIni, dateFim, u.getIdUsuario());
			List<DespesaFixa> listaDF = daoDF.findByData(dateIni, dateFim, u.getIdUsuario());
			List<DespesaVariavel> listaDV = daoDV.findByData(dateIni, dateFim, u.getIdUsuario());
			Double somaInv = daoInv.somaByData(dateIni, dateFim, u.getIdUsuario());
			Double somaDF = daoDF.somaByData(dateIni, dateFim, u.getIdUsuario());
			Double somaDV = daoDV.somaByData(dateIni, dateFim, u.getIdUsuario());
			
			session.setAttribute("dinv", listaInv);
			session.setAttribute("ddf", listaDF);
			session.setAttribute("ddv", listaDV);
			session.setAttribute("somainv", somaInv);
			session.setAttribute("somadf", somaDF);
			session.setAttribute("somadv", somaDV);
    		
    		request.setAttribute("mensagem", "Investimento deletado com sucesso");
    		
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				request.getRequestDispatcher("/logado/indexlogado.jsp").forward(request, response);
			}
    		
    	}
    	//TODO
    	else if(action.equalsIgnoreCase("editarinv")){
    		try{
    			
    		}catch(Exception e){
    			e.printStackTrace();
    			
    		}finally{
    			//Mudar para direcionar para o indexlogado
    			request.getRequestDispatcher("/logado/editinv.jsp").forward(request, response);;
    		}
    		
    	}
    	//TODO
    	else if(action.equalsIgnoreCase("atualizarinv")){
    			try{
    			
    		}catch(Exception e){
    			e.printStackTrace();
    			
    		}finally{
    			
    		}
    	}
    }
    
    /**
     * Metodo que envia as requisicoes para o metodo execute
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}
	
	/**
     * Metodo que envia as requisicoes para o metodo execute
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request,response);
	}

}
