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
import models.Docente;
import models.Externos;
import models.FactoryEquipeTematica;
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
			
			
				
			if(ref.equalsIgnoreCase("inserir")){
				
				int idAtividade= Integer.parseInt(request.getParameter("id"));
				Atividade atividade = new Atividade();
				atividade= daoa.find(idAtividade);
				
				int idParticipante= Integer.parseInt(request.getParameter("idParticipante"));
				String tipo = request.getParameter("tipo");
				
					if(tipo.equalsIgnoreCase("docente")){
						Docente docente= daodoc.find(idParticipante);
							if(!atividade.getDocentes().contains(docente)){
							atividade.addDocente(docente);							
							docente.addAtividade(atividade);
							daoa.merge(atividade);
							daodoc.merge(docente);
							}else{
								request.setAttribute("mensagem", "Esse participante já está vinculado ao projeto");
							}
							
					}else
						if(tipo.equalsIgnoreCase("bolsista")){
							Bolsista bolsista= daobol.find(idParticipante);
								if(!atividade.getBolsistas().contains(bolsista)){
								atividade.addBolsista(bolsista);
								bolsista.addAtividade(atividade);
								daoa.merge(atividade);
								daobol.merge(bolsista);
								}else{
									request.setAttribute("mensagem", "Esse participante já está vinculado ao projeto");
								}
						}else
							if(tipo.equalsIgnoreCase("tecnico")){
								Tecnico tec= daotec.find(idParticipante);
									if(atividade.getTecnicos().contains(tec)){
									atividade.addTecnico(tec);
									tec.addAtividade(atividade);
									daoa.merge(atividade);
									daotec.merge(tec);
									}else{
										request.setAttribute("mensagem", "Esse participante já está vinculado ao projeto");
									}
			
							}else
								if(tipo.equalsIgnoreCase("externo")){
									Externos externos= daoext.find(idParticipante);
										if(atividade.getExternos().contains(externos)){
											atividade.addExternos(externos);
											externos.addAtividade(atividade);
											daoa.merge(atividade);
											daoext.merge(externos);
										}else{
											request.setAttribute("mensagem", "Esse participante já está vinculado ao projeto");
										}
								}
					DAO.commit();
					DAO.close();
					request.setAttribute("atividade", atividade);
					
					request.getRequestDispatcher("atividade.jsp").forward(request, response);
			}
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
				ParticipanteInterface equipe= FactoryEquipeTematica.getEquipeTematica(tipo);
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
				
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade.jsp").forward(request, response);
				
			}else
				if(ref.equalsIgnoreCase("pesquisar")){
					
					String campo= request.getParameter("campo");
					int idAtividade= Integer.parseInt(request.getParameter("id"));
					String pesquisa = request.getParameter("pesquisa");
					String tipo= request.getParameter("tipo");
					
						if(tipo.equalsIgnoreCase("docente")){
							DAODocente dao= new DAODocente();
							List<Docente> lista = new ArrayList<Docente>();
								if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
								if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
								request.setAttribute("lista", lista);
							
						}else
							if(tipo.equalsIgnoreCase("bolsista")){
								DAOBolsista dao= new DAOBolsista();
								List<Bolsista> lista = new ArrayList<Bolsista>();
									if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
									if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
									request.setAttribute("lista", lista);
								
							}else
								if(tipo.equalsIgnoreCase("tecnico")){
									DAOTecnico dao= new DAOTecnico();
									List<Tecnico> lista = new ArrayList<Tecnico>();
										if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
										if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);	
										request.setAttribute("lista", lista);
								}else
									if(tipo.equalsIgnoreCase("externo")){
										DAOExterno dao= new DAOExterno();
										List<Externos> lista = new ArrayList<Externos>();
											if(campo.equalsIgnoreCase("nome")) lista= dao.findByNome(pesquisa);
											if(campo.equalsIgnoreCase("email")) lista= dao.findByEmail(pesquisa);
											request.setAttribute("lista", lista);
									}
						request.setAttribute("id", idAtividade);
						request.setAttribute("tipo", tipo);
						request.getRequestDispatcher("selecionar-participante.jsp").forward(request, response);
						
							
						}
							
								
							
			
		DAO.close();
		
	}

}
