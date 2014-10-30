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
import dao.DAOAtividade;
import dao.DAOBolsista;
import dao.DAOCoordenador;
import dao.DAODocente;
import dao.DAOExterno;
import dao.DAOParticipanteInterface;
import dao.DAOTecnico;
import dao.FactoryDAOParticipante;
import models.Atividade;
import models.Bolsista;
import models.Coordenador;
import models.Docente;
import models.Externos;
import models.FactoryParticipante;
import models.ParticipanteInterface;
import models.Tecnico;

/**
 * Servlet implementation class EquipeTematica
 */
@WebServlet("/Participantes.do")
public class Participantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOAtividade daoa= new DAOAtividade();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Participantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		DAOAtividade daoa= new DAOAtividade();
		DAODocente daodoc= new DAODocente();
		DAOExterno daoext= new DAOExterno();
		DAOBolsista daobol= new DAOBolsista();
		DAOTecnico daotec= new DAOTecnico();
		DAO.open();
		DAO.begin();
			
		
			if(ref.equalsIgnoreCase("novo")){
				String especificacao= request.getParameter("especificacao");
				String id= request.getParameter("id");
				request.setAttribute("especificacao", especificacao);
				request.setAttribute("id", id);
				
					
					
					
							request.getRequestDispatcher("participante/pesquisar-participante.jsp").forward(request, response);
				
				
				
				
			}else
				if(ref.equalsIgnoreCase("inserir")){
				
				int idAtividade= Integer.parseInt(request.getParameter("id"));
				Atividade atividade = new Atividade();
				atividade= daoa.find(idAtividade);
				
				int idParticipante= Integer.parseInt(request.getParameter("idParticipante"));
				String tipo = request.getParameter("tipo");
				ParticipanteInterface participante= FactoryParticipante.getEquipeTematica(tipo);
				DAOParticipanteInterface daoParticipante= FactoryDAOParticipante.getDAOParticipante(tipo);
				participante= (ParticipanteInterface) daoParticipante.find(idParticipante);
				
					if(tipo.equalsIgnoreCase("coordenador")){
						atividade.setCoordenador((Coordenador)participante);
						participante.addAtividade(atividade);
						daoParticipante.merge(participante);
						daoa.merge(atividade);
						request.setAttribute("mensagem", "Participante vinculado à atividade com sucesso!");
					}else
							if(!participante.getAtividades().contains(atividade)){
								atividade.addParticipante(participante, tipo);
								participante.addAtividade(atividade);
								daoParticipante.merge(participante);
								daoa.merge(atividade);
								request.setAttribute("mensagem", "Participante vinculado à atividade com sucesso!");
								
							}else{
								request.setAttribute("mensagem", "Esse participante já está vinculado à atividade");
							}	
						
					DAO.commit();
					
					request.setAttribute("atividade", atividade);
					
					request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
				
//					
			}else
				if(ref.equalsIgnoreCase("remover")){
					int idParticipante = Integer.parseInt(request.getParameter("idParticipante"));
					int idAtividade= Integer.parseInt(request.getParameter("id"));
					String especificacao= request.getParameter("especificacao");
					Atividade atividade = daoa.find(idAtividade);
					ParticipanteInterface participante = FactoryParticipante.getEquipeTematica(especificacao);
					DAOParticipanteInterface daoParticipante= FactoryDAOParticipante.getDAOParticipante(especificacao);
					participante= (ParticipanteInterface) daoParticipante.find(idParticipante);
						if(especificacao.equalsIgnoreCase("coordenador")){
							atividade.setCoordenador(null);
							participante.removeAtividade(atividade);
							daoa.merge(atividade);
							daoParticipante.merge(participante);
							
						}else{
							atividade.removeParticipante(participante, especificacao);
							participante.removeAtividade(atividade);
							daoa.merge(atividade);
							
							daoParticipante.merge(participante);
						}
					DAO.commit();
					request.setAttribute("mensagem", "Participante removido da atividade com sucesso!");
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
					
				}
			DAO.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		String id= request.getParameter("id");
		DAOAtividade daoAtividade= new DAOAtividade();
		DAO.open();
		DAO.begin();
		
			
			if(ref.equalsIgnoreCase("novo")){
				String tipo = request.getParameter("tipo");
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				boolean voluntario = Boolean.parseBoolean(request.getParameter("voluntario"));
				Atividade atividade= daoAtividade.find(Integer.parseInt(id));
				DAOParticipanteInterface daoParticipante= FactoryDAOParticipante.getDAOParticipante(tipo);
				ParticipanteInterface equipe= FactoryParticipante.getEquipeTematica(tipo);
				equipe.addAtividade(atividade);
				equipe.setNome(nome);
				equipe.setEmail(email);
				equipe.setVoluntario(voluntario);
				atividade.addParticipante(equipe, tipo);
				daoa.merge(atividade);
//					if(tipo.equalsIgnoreCase("docente")){
//						atividade.addDocente((Docente)equipe);
//						daoa.merge(atividade);
//					}else
//						if(tipo.equalsIgnoreCase("tecnico")){
//							atividade.addTecnico((Tecnico)equipe);
//							daoa.merge(atividade);
//							;
//						}else
//							if(tipo.equalsIgnoreCase("bolsista")){
//								atividade.addBolsista((Bolsista)equipe);
//								daoa.merge(atividade);
//							}else
//								if(tipo.equalsIgnoreCase("externo")){
//									atividade.addExternos((Externos)equipe);
//									daoa.merge(atividade);
//								}
					daoParticipante.persist(equipe);
					DAO.flush();
					DAO.commit();
					request.setAttribute("mensagem", "Participante cadastrado com sucesso");
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
				
			}else
				if(ref.equalsIgnoreCase("pesquisar")){
					
					String campo= request.getParameter("campo");
					int idAtividade= Integer.parseInt(request.getParameter("id"));
					String pesquisa = request.getParameter("pesquisa");
					String tipo= request.getParameter("tipo");
					DAOParticipanteInterface daoParticipante= FactoryDAOParticipante.getDAOParticipante(tipo);
					List<ParticipanteInterface> lista = new ArrayList<ParticipanteInterface>();
					
						if(campo.equalsIgnoreCase("nome")) lista= daoParticipante.findByNome(pesquisa);
						if(campo.equalsIgnoreCase("email")) lista = daoParticipante.findByEmail(pesquisa);
					
					request.setAttribute("lista", lista);
					System.out.println(lista.toString());
					request.setAttribute("id", idAtividade);
					request.setAttribute("tipo", tipo);
					
						if(tipo.equalsIgnoreCase("coordenador")){
							request.getRequestDispatcher("participante/inserir-coordenador.jsp").forward(request, response);
						}else
						
						request.getRequestDispatcher("participante/selecionar-participante.jsp").forward(request, response);
						
					
//						if(tipo.equalsIgnoreCase("docente")){
//							DAODocente dao= new DAODocente();
//							List<Docente> lista = new ArrayList<Docente>();
//								if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
//								if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
//								request.setAttribute("lista", lista);
//							
//						}else
//							if(tipo.equalsIgnoreCase("bolsista")){
//								DAOBolsista dao= new DAOBolsista();
//								List<Bolsista> lista = new ArrayList<Bolsista>();
//									if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
//									if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
//									request.setAttribute("lista", lista);
//								
//							}else
//								if(tipo.equalsIgnoreCase("tecnico")){
//									DAOTecnico dao= new DAOTecnico();
//									List<Tecnico> lista = new ArrayList<Tecnico>();
//										if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
//										if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
//										request.setAttribute("lista", lista);
//								}else
//									if(tipo.equalsIgnoreCase("externo")){
//										DAOExterno dao= new DAOExterno();
//										List<Externos> lista = new ArrayList<Externos>();
//											if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
//											if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);
//											request.setAttribute("lista", lista);
//									}
//						request.setAttribute("id", idAtividade);
//						request.setAttribute("tipo", tipo);
//						request.getRequestDispatcher("selecionar-participante.jsp").forward(request, response);
//						
							
						}
							
								
							
			
		DAO.close();
		
	}

}
