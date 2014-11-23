package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import dao.DAO;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;

/**
 * Servlet implementation class PesquisarAtividades
 */
@WebServlet("/PesquisarAtividades.do")
public class PesquisarAtividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAtividade daoa= new DAOAtividade();
	DAOTipoAtividade daot= new DAOTipoAtividade();
	DAOVinculo daov= new DAOVinculo();
	DAOCoordenador daoc= new DAOCoordenador();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarAtividades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		DAO.open();
		DAO.begin();
		if(ref.equalsIgnoreCase("pesquisar")){
			request.setAttribute("listaTipo", daot.findAll());
			request.setAttribute("listaVinculo", daov.findAll());
			request.setAttribute("listaCoordenador", daoc.findAll());
			request.getRequestDispatcher("atividade/pesquisar.jsp").forward(request, response);
		}
		DAO.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		DAO.begin();
		List<Atividade> lista = new ArrayList<Atividade>();
		String ref= request.getParameter("ref");
		
		if(ref.equalsIgnoreCase("periodo")){
			System.out.println("por periodo");
			
				String inicio= request.getParameter("inicio");
				String fim= request.getParameter("fim");
				lista = daoa.findByPeriodo(inicio, fim);
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
		}else
			if(ref.equalsIgnoreCase("tipo")){
//				int tipo= Integer.parseInt(request.getParameter("Tipo de atividade"));
				String tipo= request.getParameter("tipoAtividade");
				lista= daoa.findByTipo(Integer.parseInt(tipo));
				request.setAttribute("lista", lista);
				request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
				
			}else
				if(ref.equalsIgnoreCase("vinculo")){
					String vinculo= request.getParameter("vinculoAtividade");
					String inicio= request.getParameter("inicio");
					String fim= request.getParameter("fim");
					lista= daoa.findByVincunlo(inicio, fim,Integer.parseInt(vinculo));
					request.setAttribute("lista", lista);
					request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
				}else 
					if(ref.equalsIgnoreCase("coordenador")){
						String coordenador = request.getParameter("coordenadorAtividade");
						String inicio = request.getParameter("inicio");
						String fim= request.getParameter("fim");
						lista=daoa.findByCoordenador(inicio, fim, Integer.parseInt(coordenador));
						request.setAttribute("lista", lista);
						request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
					}
		DAO.close();
	}

}
