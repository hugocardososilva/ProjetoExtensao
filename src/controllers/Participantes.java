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
					
				}else 
					if(ref.equalsIgnoreCase("add")){
						String tipo = request.getParameter("tipo");
						request.setAttribute("tipo", tipo);
							if(tipo.equalsIgnoreCase("coordenador")){
								request.getRequestDispatcher("participante/adicionar-coordenador.jsp").forward(request, response);
							}else{
								request.getRequestDispatcher("participante/adicionar-participante.jsp").forward(request, response);
							}
					}else
						if(ref.equalsIgnoreCase("listar")){
							String tipo= request.getParameter("tipo");
							DAOParticipanteInterface daoP= FactoryDAOParticipante.getDAOParticipante(tipo);
							List<ParticipanteInterface> lista= daoP.findAll();
							request.setAttribute("lista", lista);
							request.setAttribute("tipo", tipo);
								if(tipo.equalsIgnoreCase("coordenador")){
									request.getRequestDispatcher("participante/selecionar-coordenador.jsp").forward(request, response);
								}else{
									request.getRequestDispatcher("participante/selecionar-participante.jsp").forward(request, response);
								}
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
		System.out.println("o id está  "+ id);
			
			if(ref.equalsIgnoreCase("novo")){
				String tipo = request.getParameter("tipo");
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String telefone= request.getParameter("telPrimario");
				boolean voluntario = Boolean.parseBoolean(request.getParameter("voluntario"));
				
				DAOParticipanteInterface daoParticipante= FactoryDAOParticipante.getDAOParticipante(tipo);
				ParticipanteInterface equipe= FactoryParticipante.getEquipeTematica(tipo);
				Atividade atividade= new Atividade();	
					if(!id.equalsIgnoreCase("")){	
						 atividade= daoAtividade.find(Integer.parseInt(id));
						equipe.addAtividade(atividade);
						atividade.addParticipante(equipe, tipo);
						
						
					}
				equipe.setNome(nome);
				equipe.setEmail(email);
				equipe.setTelPrimario(Long.parseLong(telefone));
				equipe.setVoluntario(voluntario);
				
				
					
					daoParticipante.persist(equipe);
					DAO.flush();
					DAO.commit();
					request.setAttribute("mensagem", "Participante cadastrado com sucesso");
							if(!id.equalsIgnoreCase("")){
								
								daoa.merge(atividade);
								request.setAttribute("atividade", atividade);
								request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
							}else{
								request.getRequestDispatcher("index.jsp").forward(request, response);
							}
				
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
							request.getRequestDispatcher("participante/selecionar-coordenador.jsp").forward(request, response);
						}else
						
						request.getRequestDispatcher("participante/selecionar-participante.jsp").forward(request, response);
						
					
						
							
						}
							
								
							
			
		DAO.close();
		
	}

}
