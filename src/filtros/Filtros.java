package filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import models.TipoAtividade;
import dao.DAO;
import dao.DAOTipoAtividade;

/**
 * Servlet Filter implementation class Filtros
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		urlPatterns = { 
				"/Filtros", 
				"/cadastrar-atividade.jsp"
		})
public class Filtros implements Filter {

    /**
     * Default constructor. 
     */
    public Filtros() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		DAO.open();
		DAO.begin();
		List<TipoAtividade> listaTipo= new ArrayList<TipoAtividade>();
		DAOTipoAtividade daot= new DAOTipoAtividade();
		listaTipo=daot.findAll();
		DAO.close();
		request.setAttribute("listaTipo", listaTipo);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
