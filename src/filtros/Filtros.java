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

import models.AreaTematica;
import models.LinhaDeExtensao;
import models.LocalRealizacao;
import models.TipoAtividade;
import models.Vinculo;
import dao.DAO;
import dao.DAOAreaTematica;
import dao.DAOLinhaDeExtensao;
import dao.DAOLocalRealizacao;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;

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
			List<Vinculo> vinculo= new ArrayList<Vinculo>();
			List<AreaTematica> areaTematica= new ArrayList<AreaTematica>();
			List<LinhaDeExtensao> linhaExtensao= new ArrayList<LinhaDeExtensao>();
			List<LocalRealizacao> localRealizacao= new ArrayList<LocalRealizacao>();
			
			DAOTipoAtividade daot= new DAOTipoAtividade();
			DAOVinculo daov= new DAOVinculo();
			DAOAreaTematica daoArea= new DAOAreaTematica();
			DAOLinhaDeExtensao daoLinha= new DAOLinhaDeExtensao();
			DAOLocalRealizacao daoLocal= new DAOLocalRealizacao();
			
			
				listaTipo=daot.findAll();
				vinculo=daov.findAll();
				areaTematica= daoArea.findAll();
				linhaExtensao= daoLinha.findAll();
				localRealizacao= daoLocal.findAll();
				
			
		DAO.close();
		
			request.setAttribute("listaTipo", listaTipo);
			request.setAttribute("vinculo", vinculo);
			request.setAttribute("areaTematica", areaTematica);
			request.setAttribute("linhaExtensao", linhaExtensao);
			request.setAttribute("localRealizacao", localRealizacao);
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
