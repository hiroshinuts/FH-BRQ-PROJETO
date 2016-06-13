package br.com.brq.financialhealth.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe Filter: FilterCache.
 * 
 * Classe utilizada limpeza de cache da aplicação, da qual evita que as informações fiquem a disposição por
 * tempo maior que necessario.
 * 
 *@author Hiro
 *@version 1.0
 *@since Treinamento BRQ/SP
 */

@WebFilter(urlPatterns = {"/logado/*","/ControleUsuario","/ControleDespesaFixa","/ControleDespesaVariavel",
		"/ControleInvestimento"})
public class FilterCache implements Filter {

    public FilterCache() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setHeader("Last-Modified", new Date().toString());
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		resp.setHeader("Pragma", "no-cache");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
