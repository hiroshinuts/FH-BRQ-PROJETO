package br.com.brcom.filters;

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


@WebFilter("/arearestrita/funcionario/*")
public class FilterFuncionario implements Filter {

  
    public FilterFuncionario() {
    }

	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("funcionariologado") != null){
			
			chain.doFilter(request, response);
			
		} else {
			
			resp.sendRedirect("/brcom_projeto/index.jsp");
						
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
