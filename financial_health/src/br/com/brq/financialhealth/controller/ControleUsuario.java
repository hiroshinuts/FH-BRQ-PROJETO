package br.com.brq.financialhealth.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import br.com.brq.financialhealth.services.CalculoPorIdade;
import br.com.brq.financialhealth.services.Idade;
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
    		
    		String senha = request.getParameter("senha");
    		String senhaConfirm = request.getParameter("senhaconfirm");
    		String destino = "login.jsp";
    		Usuario user = new Usuario();
    		DAOUsuario u = new DAOUsuario();
    		
    		try{
    			
    			if(senha.equals(senhaConfirm)){
    			
    			user.setNome(request.getParameter("nome"));
    			user.setEmail(request.getParameter("email"));
    			user.setCpf(request.getParameter("cpf"));
    			user.setDataNascimento(FormatacaoData.convertToDate(request.getParameter("datanascimento")));
    			user.setRendimentoMensalLiquido(Double.parseDouble(request.getParameter("rendimentomensalliquido")));
    			user.setSenha(Criptografia.encriptarSenha(request.getParameter("senha")));
    			
    			u.saveOrUpdate(user);
    			
    			HttpSession session = request.getSession();
				session.setAttribute("usuariologado", u);
    			
    			
    			request.setAttribute("mensagem", "Usuario " + user.getNome() + " gravado com sucesso!");
    			
    			}else{
    				request.setAttribute("mensagem", "Erro: Senhas n�o conferem. Tente novamente");
    				destino = "index.jsp";
    			}
    			
    		}catch(Exception e){
    			
    			e.printStackTrace();
    			
    		}finally{
    			request.getRequestDispatcher(destino).forward(request, response);;
    		}
    
    	}
    	
    	else if ("login".equalsIgnoreCase(action)){
    		try{
    			Usuario u = new Usuario();
    			DAOUsuario d = new DAOUsuario();
    			
    			String senha = Criptografia.encriptarSenha(request.getParameter("senha"));
    			String cpf = request.getParameter("cpf");
    			
    			u = d.findByLoginSenha(cpf, senha);
    			
    			if(u !=null){
    				
    				HttpSession session = request.getSession();
    				session.setAttribute("usuariologado", u);
    				
    				DAOInvestimento daoInv = new DAOInvestimento();
        			DAODespesaFixa daoDF = new DAODespesaFixa();
        			DAODespesaVariavel daoDV = new DAODespesaVariavel();
        			
        			Calendar c =  Calendar.getInstance();
        			
        			int ano = c.get(Calendar.YEAR);
        			int mes = c.get(Calendar.MONTH);
        			int dia = 1;
        			
        			c.set(ano, mes, dia);
        			
        			int numeroDias = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        			
        			Date dateIni = c.getTime();
        			
        			
        			c.add(Calendar.DAY_OF_MONTH, numeroDias-1);
        			
        			Date dateFim = c.getTime();
        			
        			
        			List<Investimento> listaInv = daoInv.findByData(dateIni, dateFim, u.getIdUsuario());
        			List<DespesaFixa> listaDF = daoDF.findByData(dateIni, dateFim, u.getIdUsuario());
        			List<DespesaVariavel> listaDV = daoDV.findByData(dateIni, dateFim, u.getIdUsuario());
        			Double somaInv = daoInv.somaByData(dateIni, dateFim, u.getIdUsuario());
        			Double somaDF = daoDF.somaByData(dateIni, dateFim, u.getIdUsuario());
        			Double somaDV = daoDV.somaByData(dateIni, dateFim, u.getIdUsuario());
        			
        			if (listaInv != null && listaDF != null && listaDV != null){
        				
        			
        			session.setAttribute("dinv", listaInv);
        			session.setAttribute("ddf", listaDF);
        			session.setAttribute("ddv", listaDV);
        			session.setAttribute("somainv", somaInv);
        			session.setAttribute("somadf", somaDF);
        			session.setAttribute("somadv", somaDV);
    				
        			}//fimIF DOS DADOS NULL
        			
        			//METODO PARA GRAFICO IDEAL // 3 informacoes 
        			
        			Idade idd = new Idade(c.getTime());
        			Integer idade = idd.calcIdade(u.getDataNascimento());
        			CalculoPorIdade valorIdeal = new CalculoPorIdade();
        			Object valores[] = valorIdeal.calculaTotal(idade, u.getRendimentoMensalLiquido());
        			
        			List<Double> listaValores = new ArrayList<>();  
        			
        			for(int i=0; i < valores.length; i++){
        				
        				Double valor = (Double) valores[i];
        				listaValores.add(valor);

        			session.setAttribute("valoresGraficoIdeal", listaValores);
        			}
        			
        			// FIM INFORMACOES GRAFICO
        			
    				
    				request.getRequestDispatcher("/logado/indexlogado.jsp").forward(request, response);
    				
    			}else{
    				request.setAttribute("mensagem", "Senha ou usuario incorreto!");
    				request.getRequestDispatcher("login.jsp").forward(request, response);
    			}
    				
    			
    			
    		}catch(Exception e){
    			request.setAttribute("erro", e.getMessage());
    			e.printStackTrace();
    		}
    	}
    	
    		else if ("logout".equalsIgnoreCase(action)){
			
				// remover o user logado da session
				HttpSession session = request.getSession();
				session.removeAttribute("funcionariologado");
				session.invalidate();
				
				// redirecionar para a index --- esse tipo de redirect s� redireciona e n�o manda mensagem....
				response.sendRedirect("index.jsp");
			
		}
    	
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
}
