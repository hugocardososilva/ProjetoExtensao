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
			}else
				if(ref.equalsIgnoreCase("editar")){
					String id = request.getParameter("id");
//					String tipo= request.getParameter("tipo");
						if(tipo.equalsIgnoreCase("vinculo")){
							request.setAttribute("apoio", daoVinculo.find(Integer.parseInt(id)));
							request.getRequestDispatcher("apoio/novo-vinculo.jsp").forward(request, response);
						}else
							if(tipo.equalsIgnoreCase("tipoAtividade")){
								request.setAttribute("apoio", daoTipo.find(Integer.parseInt(id)));
								request.getRequestDispatcher("apoio/novo-tipo-atividade.jsp").forward(request, response);
							}else
								if(tipo.equalsIgnoreCase("local")){
									request.setAttribute("apoio", daoLocal.find(Integer.parseInt(id)));
									request.getRequestDispatcher("apoio/novo-local.jsp").forward(request, response);
								}else
									if(tipo.equalsIgnoreCase("extensao")){
										request.setAttribute("apoio", daoExtensao.find(Integer.parseInt(id)));
										request.getRequestDispatcher("apoio/novo-extensao.jsp").forward(request, response);
								}else
									if(tipo.equalsIgnoreCase("areaTematica")){
										request.setAttribute("apoio", daoArea.find(Integer.parseInt(id)));
										request.getRequestDispatcher("apoio/novo-area-tematica.jsp").forward(request, response);
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
					request.setAttribute("mensagem", "Novo vínculo adicionado com sucesso!");
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
							request.setAttribute("mensagem", "Nova Linha de Extensão adicionada com sucesso!");
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
								request.setAttribute("mensagem", "Novo Local de Realização adicionado com sucesso!");
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
									request.setAttribute("mensagem", "Nova Área Temática adicionada com sucesso!");
									request.getRequestDispatcher("index.jsp").forward(request, response);
								}
				
				
			}else 
				if(ref.equalsIgnoreCase("listar")){
				
				
			}else
				if(ref.equalsIgnoreCase("editar")){
					String id= request.getParameter("id");
					request.setAttribute("tipo", tipo);
					
					if(tipo.equalsIgnoreCase("vinculo")){
						System.out.println("editando vinculo");
						String nome = request.getParameter("nome");
						Vinculo v = daoVinculo.find(Integer.parseInt(id));
						v.setNome(nome);
						daoVinculo.merge(v);
						request.setAttribute("mensagem", "vinculo editado com sucesso!");
						request.setAttribute("lista", daoVinculo.findAll());
						request.getRequestDispatcher("apoio/listar-vinculo.jsp").forward(request, response);
					}else
						if(tipo.equalsIgnoreCase("tipoAtividade")){
							String sigla = request.getParameter("sigla");
							String nome= request.getParameter("nome");
							TipoAtividade t = daoTipo.find(Integer.parseInt(id));
							t.setSigla(sigla);
							t.setNome(nome);
							daoTipo.merge(t);
							request.setAttribute("mensagem", "Tipo de atividade editado com sucesso!");
							request.setAttribute("lista", daoTipo.findAll());
							request.getRequestDispatcher("apoio/listar-tipo-atividade.jsp").forward(request, response);
							
						}else
							if(tipo.equalsIgnoreCase("local")){
								String codigo= request.getParameter("codigo");
								String local= request.getParameter("local");
								LocalRealizacao l = daoLocal.find(Integer.parseInt(id));
								l.setCodigo(Integer.parseInt(codigo));
								l.setLocal(local);
								daoLocal.merge(l);
								request.setAttribute("mensagem", "Local editado com sucesso!");
								request.setAttribute("lista", daoLocal.findAll());
								request.getRequestDispatcher("apoio/listar-local-de-realizacao.jsp").forward(request, response);
								
							}else
								if(tipo.equalsIgnoreCase("extensao")){
									String numero = request.getParameter("numero");
									String denominacao= request.getParameter("denominacao");
									String definicoes= request.getParameter("definicoes");
									LinhaDeExtensao l= daoExtensao.find(Integer.parseInt(id));
									l.setNumero(Integer.parseInt(numero));
									l.setDenominacao(denominacao);
									l.setDefinicoes(definicoes);
									daoExtensao.merge(l);
									request.setAttribute("mensagem", "Linha de Extensão editada com sucesso!");
									request.setAttribute("lista", daoExtensao.findAll());
									request.getRequestDispatcher("apoio/listar-linha-de-extensao.jsp").forward(request, response);
									
							}else
								if(tipo.equalsIgnoreCase("areaTematica")){
									String area= request.getParameter("area");
									String descricao= request.getParameter("descricao");
									String sigla= request.getParameter("sigla");
									AreaTematica a= daoArea.find(Integer.parseInt(id));
									a.setArea(area);
									a.setDescricao(descricao);
									a.setSigla(sigla);
									daoArea.merge(a);
									request.setAttribute("mensagem", "Área Temática editada com sucesso!");
									request.setAttribute("lista", daoArea.findAll());
									request.getRequestDispatcher("apoio/listar-area-tematica.jsp").forward(request, response);
								}
					DAO.commit();
				}
			
			DAO.close();
	}

}
