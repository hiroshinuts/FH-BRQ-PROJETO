package br.com.brq.financialhealth.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
import br.com.brq.financialhealth.util.ConnectionUtil;
import br.com.brq.financialhealth.util.FormatacaoData;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 * 
 *Servlet de Controle -  ControleBuscaPorData
 *
 *Controla as requisoes das paginas que necessitam uma busca de informacoes por data
 * 
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */
@WebServlet("/ControleBuscaPorData")
public class ControleBuscaPorData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleBuscaPorData() {
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
    	
    	if(action != null){
    		
    		if(action.equalsIgnoreCase("buscadata")){
    			try{
    				
    			HttpSession session = request.getSession();
    			Usuario u = (Usuario) session.getAttribute("usuariologado");
    			

    			DAOInvestimento daoInv = new DAOInvestimento();
    			DAODespesaFixa daoDF = new DAODespesaFixa();
    			DAODespesaVariavel daoDV = new DAODespesaVariavel();
    			
    			
    			Date dateIni = FormatacaoData.convertToDate(request.getParameter("dateini"));
    			Date dateFim = FormatacaoData.convertToDate(request.getParameter("datefim"));
    			
    			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
    			
    			session.setAttribute("dateini", fmt.format(dateIni));
    			session.setAttribute("datefim", fmt.format(dateFim));
    			
    			List<Investimento> listaInv = daoInv.findByData(dateIni, dateFim, u.getIdUsuario());
    			List<DespesaFixa> listaDF = daoDF.findByData(dateIni, dateFim, u.getIdUsuario());
    			List<DespesaVariavel> listaDV = daoDV.findByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaInv = daoInv.somaByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaDF = daoDF.somaByData(dateIni, dateFim, u.getIdUsuario());
    			Double somaDV = daoDV.somaByData(dateIni, dateFim, u.getIdUsuario());
    			
    			request.setAttribute("somainva", somaInv);
    			request.setAttribute("somadfa", somaDF);
    			request.setAttribute("somadva", somaDV);
    			request.setAttribute("dadosinv", listaInv);
    			request.setAttribute("dadosdf", listaDF);
    			request.setAttribute("dadosdv", listaDV);
    			
    			request.setAttribute("mensagem", "ConsultaRealizadacomsucesso");
    			}catch(Exception e){
    				e.printStackTrace();
    			}finally{
    				request.getRequestDispatcher("/logado/analise.jsp").forward(request, response);
    			}
    			
    			
    		}
    		else if(action.equalsIgnoreCase("gerarelatorio")){
    			
    			try{
    				    				
    				InputStream arquivo = getServletContext().getResourceAsStream("/reports/relatorio.jasper");
    				
    				HttpSession session = request.getSession();
    				Usuario u = (Usuario) session.getAttribute("usuariologado");
    				
    				
    				String dateIni = (String) session.getAttribute("dateini");
    				String dateFim = (String) session.getAttribute("datefim");
    				
    				
    				Map<String,Object> parametros = new HashMap<String, Object>();
    				parametros.put("dataIni", dateIni);
    				parametros.put("dataFim", dateFim);
    				parametros.put("idUsuario", u.getIdUsuario().toString());
    				
    				byte[]pdf = JasperRunManager.runReportToPdf(arquivo, parametros, ConnectionUtil.getConnection());
    				
    				ServletOutputStream out = response.getOutputStream();
    				out.write(pdf);
    				out.flush();
    				out.close();
    				
    			}catch(Exception e){
    				e.printStackTrace();
    				e.getMessage();
    			}
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
