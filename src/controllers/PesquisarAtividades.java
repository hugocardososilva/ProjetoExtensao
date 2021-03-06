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
import dao.DAOAreaTematica;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import dao.DAOLinhaDeExtensao;
import dao.DAOLocalRealizacao;
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
	DAOLocalRealizacao daol= new DAOLocalRealizacao();
	DAOAreaTematica daoArea= new DAOAreaTematica();
	DAOLinhaDeExtensao daoLinha= new DAOLinhaDeExtensao();
	DAO dao= new DAO();
       
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
		dao.open();
		dao.begin();
		if(ref.equalsIgnoreCase("pesquisar")){
			request.setAttribute("listaTipo", daot.findAll());
			request.setAttribute("listaVinculo", daov.findAll());
			request.setAttribute("listaCoordenador", daoc.findAll());
			request.setAttribute("listaLocal", daol.findAll());
			request.setAttribute("listaArea", daoArea.findAll());
			request.setAttribute("listaLinha", daoLinha.findAll());
			
			request.getRequestDispatcher("atividade/pesquisar.jsp").forward(request, response);
		}
		dao.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.open();
		dao.begin();
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
				String inicio= request.getParameter("inicio");
				String fim= request.getParameter("fim");
				lista= daoa.findByTipo(inicio, fim,Integer.parseInt(tipo));
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
					}else 
						if(ref.equalsIgnoreCase("local")){
							String local = request.getParameter("localAtividade");
							String inicio = request.getParameter("inicio");
							String fim= request.getParameter("fim");
							lista=daoa.findByLocal(inicio, fim, Integer.parseInt(local));
							request.setAttribute("lista", lista);
							request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
						}else 
							if(ref.equalsIgnoreCase("area")){
								String area = request.getParameter("areaAtividade");
								String inicio = request.getParameter("inicio");
								String fim= request.getParameter("fim");
								lista=daoa.findByAreaTematica(inicio, fim, Integer.parseInt(area));
								request.setAttribute("lista", lista);
								request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
							}else 
								if(ref.equalsIgnoreCase("linha")){
									String linha = request.getParameter("linhaAtividade");
									String inicio = request.getParameter("inicio");
									String fim= request.getParameter("fim");
									lista=daoa.findByLinhaDeExtensao(inicio, fim, Integer.parseInt(linha));
									request.setAttribute("lista", lista);
									request.getRequestDispatcher("pesquisar/listar-atividades.jsp").forward(request, response);
								}
		dao.close();
	}

}
