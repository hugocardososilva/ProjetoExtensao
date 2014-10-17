package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOAtividade;
import dao.DAOBolsista;
import dao.DAODocente;
import dao.DAOExterno;
import dao.FactoryDAOParticipante;
import models.Atividade;
import models.Bolsista;
import models.Docente;
import models.Externos;
import models.FactoryEquipeTematica;
import models.Tecnico;

/**
 * Servlet implementation class EquipeTematica
 */
@WebServlet("/Participantes.do")
public class Participantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAtividade daoAtividade= new DAOAtividade();
       
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		String id= request.getParameter("id");
		DAO.open();
		DAO.begin();
		DAOAtividade daoa= new DAOAtividade();
		DAODocente daodoc= new DAODocente();
		DAOExterno daoext= new DAOExterno();
		DAOBolsista daobol= new DAOBolsista();
			
			if(ref.equalsIgnoreCase("novo")){
				String tipo = request.getParameter("tipo");
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				boolean voluntario = Boolean.parseBoolean(request.getParameter("voluntario"));
				Atividade atividade= daoAtividade.find(Integer.parseInt(id));
				models.Participante equipe= FactoryEquipeTematica.getEquipeTematica(tipo);
				equipe.addAtividade(atividade);
				equipe.setNome(nome);
				equipe.setEmail(email);
				equipe.setVoluntario(voluntario);
					if(tipo.equalsIgnoreCase("docente")){
						atividade.addDocente((Docente)equipe);
						daoa.merge(atividade);
					}else
						if(tipo.equalsIgnoreCase("tecnico")){
							atividade.addTecnico((Tecnico)equipe);
							daoa.merge(atividade);
							;
						}else
							if(tipo.equalsIgnoreCase("bolsista")){
								atividade.addBolsista((Bolsista)equipe);
								daoa.merge(atividade);
							}else
								if(tipo.equalsIgnoreCase("externo")){
									atividade.addExternos((Externos)equipe);
									daoa.merge(atividade);
								}
					FactoryDAOParticipante.getDAOParticipante(tipo).persist(equipe);
					DAO.flush();
					DAO.commit();
				
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade.jsp").forward(request, response);
				
			}
		DAO.close();
		
	}

}
