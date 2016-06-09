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
    			
    			
    			HttpSession session = request.getSession();
    			Usuario u = (Usuario) session.getAttribute("usuariologado");
    			
    			df.setUsuario(u);
    			
    			DAODespesaFixa daoDv = new DAODespesaFixa();
        		daoDv.saveOrUpdate(df);
        		
        		request.setAttribute("mensagem", "Despesa gravada com sucesso!");
        		
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
    	else if(action.equalsIgnoreCase("excluir")){
    		
    		try {
    		
    			HttpSession session = request.getSession();
    			Usuario u = (Usuario) session.getAttribute("usuariologado");
    			
    			DespesaFixa df = new DespesaFixa();
    			//df.setIdDespesaFixa(Integer.parseInt(request.getParameter("id")));
    			//Integer id = Integer.parseInt(u.setIdUsuario(request.getParameter("id"))) ;
    			
    			DAODespesaFixa daoDF = new DAODespesaFixa();
    			daoDF.delete(df);
    			}
    			catch(Exception e){
    				e.printStackTrace();
    			}
    			
    			
    			
			finally{
				request.getRequestDispatcher("/financial_heal/logado/analise.jsp");
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
