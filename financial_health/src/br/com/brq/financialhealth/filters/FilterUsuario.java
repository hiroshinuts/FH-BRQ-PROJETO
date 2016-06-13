package br.com.brq.financialhealth.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe Filter: FilterUsuario.
 * 
 *Classe utilizada para controlar acesso das areas restritas da aplicação, das quais, quem pode navegar são
 *apenas usuarios devidamente logados 
 *
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */

@WebFilter("/logado/*")
public class FilterUsuario implements Filter {

    public FilterUsuario() {
    }
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuariologado")!= null){
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("index.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
