package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOAreaTematica;
import dao.DAOLinhaDeExtensao;
import dao.DAOLocalRealizacao;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;
import models.AreaTematica;
import models.LinhaDeExtensao;
import models.LocalRealizacao;
import models.TipoAtividade;
import models.Vinculo;

/**
 * Servlet implementation class Apoio
 */
@WebServlet("/Apoio.do")
public class Apoio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOVinculo daoVinculo= new DAOVinculo();
	DAOTipoAtividade daoTipo= new DAOTipoAtividade();
	DAOLinhaDeExtensao daoExtensao= new DAOLinhaDeExtensao();
	DAOLocalRealizacao daoLocal= new DAOLocalRealizacao();
	DAOAreaTematica daoArea= new DAOAreaTematica();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apoio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		String tipo= request.getParameter("tipo");
		DAO.open();
		DAO.begin();
		if(ref.equalsIgnoreCase("novo")){
			if(tipo.equalsIgnoreCase("vinculo")){
				request.getRequestDispatcher("apoio/novo-vinculo.jsp").forward(request, response);
			}else
				if(tipo.equalsIgnoreCase("tipoAtividade")){
					request.getRequestDispatcher("apoio/novo-tipo-atividade.jsp").forward(request, response);
				}else
					if(tipo.equalsIgnoreCase("extensao")){
						request.getRequestDispatcher("apoio/novo-extensao.jsp").forward(request, response);
					}else
						if(tipo.equalsIgnoreCase("local")){
						request.getRequestDispatcher("apoio/novo-local.jsp").forward(request, response);
					}else
						if(tipo.equalsIgnoreCase("areaTematica")){
							request.getRequestDispatcher("apoio/novo-area-tematica.jsp").forward(request, response);
						}
		}else
			if(ref.equalsIgnoreCase("listar")){
				
				if(tipo.equalsIgnoreCase("vinculo")){
					List<Vinculo> lista = new ArrayList<Vinculo>();
					
					lista= daoVinculo.findAll();
					request.setAttribute("tipo", tipo);
					request.setAttribute("lista", lista);
					request.getRequestDispatcher("apoio/listar-vinculo.jsp").forward(request, response);
				}else
					if(tipo.equalsIgnoreCase("tipoAtividade")){
						List<TipoAtividade> lista = new ArrayList<TipoAtividade>();
						lista= daoTipo.findAll();
						request.setAttribute("tipo", tipo);
						request.setAttribute("lista", lista);
						request.getRequestDispatcher("apoio/listar-tipo-atividade.jsp").forward(request, response);
					}else
						if(tipo.equalsIgnoreCase("extensao")){
							List<LinhaDeExtensao> lista = new ArrayList<LinhaDeExtensao>();
							lista= daoExtensao.findAll();
							request.setAttribute("tipo", tipo);
							request.setAttribute("lista", lista);
							request.getRequestDispatcher("apoio/listar-linha-de-extensao.jsp").forward(request, response);
						}else
							if(tipo.equalsIgnoreCase("local")){
								List<LocalRealizacao> lista = new ArrayList<LocalRealizacao>();
								lista= daoLocal.findAll();
								request.setAttribute("tipo", tipo);
								request.setAttribute("lista", lista);
								request.getRequestDispatcher("apoio/listar-local-de-realizacao.jsp").forward(request, response);
							}else
								if(tipo.equalsIgnoreCase("areaTematica")){
									List<AreaTematica> lista = new ArrayList<AreaTematica>();
									lista= daoArea.findAll();
									request.setAttribute("tipo", tipo);
									request.setAttribute("lista", lista);
									request.getRequestDispatcher("apoio/listar-area-tematica.jsp").forward(request, response);
								}
			}
		DAO.close();
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		DAO.begin();
		String ref= request.getParameter("ref");
		String tipo= request.getParameter("tipo");
		
			if(ref.equalsIgnoreCase("add")){
				if(tipo.equalsIgnoreCase("vinculo")){
					Vinculo vinculo = new Vinculo();
					
					String nome= request.getParameter("nome");
					vinculo.setNome(nome);
					daoVinculo.persist(vinculo);
					DAO.flush();
					DAO.commit();
					request.setAttribute("mensagem", "Novo v�nculo adicionado com sucesso!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else 
					if(tipo.equalsIgnoreCase("tipoAtividade")){
						TipoAtividade tipoA= new TipoAtividade();
						String sigla= request.getParameter("sigla");
						String nome= request.getParameter("nome");
						tipoA.setNome(nome);
						tipoA.setSigla(sigla.toUpperCase());
						daoTipo.persist(tipoA);
						DAO.flush();
						DAO.commit();
						request.setAttribute("mensagem", "Novo Tipo de Atividade adicionado com sucesso!");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}else
						if(tipo.equalsIgnoreCase("extensao")){
							LinhaDeExtensao extensao= new LinhaDeExtensao();
							int numero = Integer.parseInt(request.getParameter("numero"));
							String denominacao= request.getParameter("denominacao");
							String definicoes= request.getParameter("definicoes");
							extensao.setNumero(numero);
							extensao.setDenominacao(denominacao);
							extensao.setDefinicoes(definicoes);
							daoExtensao.persist(extensao);
							DAO.flush();
							DAO.commit();
							request.setAttribute("mensagem", "Nova Linha de Extens�o adicionada com sucesso!");
							request.getRequestDispatcher("index.jsp").forward(request, response);
							
						}else
							if(tipo.equalsIgnoreCase("local")){
								int codigo= Integer.parseInt(request.getParameter("codigo"));
								String local= request.getParameter("local");
								LocalRealizacao localRealizacao = new LocalRealizacao();
								localRealizacao.setCodigo(codigo);
								localRealizacao.setLocal(local);
								daoLocal.persist(localRealizacao);
								DAO.flush();
								DAO.commit();
								request.setAttribute("mensagem", "Novo Local de Realiza��o adicionado com sucesso!");
								request.getRequestDispatcher("index.jsp").forward(request, response);
								
							}else
								if(tipo.equalsIgnoreCase("areaTematica")){
									String area= request.getParameter("area");
									String descricao= request.getParameter("descricao");
									String sigla= request.getParameter("sigla").toUpperCase();
									AreaTematica areaTematica= new AreaTematica();
									areaTematica.setArea(area);
									areaTematica.setDescricao(descricao);
									areaTematica.setSigla(sigla);
									daoArea.persist(areaTematica);
									DAO.flush();
									DAO.commit();
									request.setAttribute("mensagem", "Nova �rea Tem�tica adicionada com sucesso!");
									request.getRequestDispatcher("index.jsp").forward(request, response);
								}
				
				
			}else 
				if(ref.equalsIgnoreCase("listar")){
				
				
			}
			DAO.close();
	}

}
