package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.Coordenador;
import models.FactoryParticipante;
import models.ParticipanteInterface;
import dao.DAO;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import dao.DAOParticipanteInterface;
import dao.FactoryDAOParticipante;

/**
 * Servlet implementation class Coordenador
 */
@WebServlet("/Coordenadores.do")
public class Coordenadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String ref;
    DAOAtividade daoAtividade= new DAOAtividade();
    DAOCoordenador daoCoordenador= new DAOCoordenador();
    models.Coordenador coordenador;
    Atividade atividade;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coordenadores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ref= request.getParameter("ref");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		DAO.begin();
		String id= request.getParameter("id");
		ref= request.getParameter("ref");
		
		if(ref.equalsIgnoreCase("novo")){
			coordenador= new models.Coordenador();
			atividade= new Atividade();
			
			
			
			String nome = request.getParameter("nomeCoordenador");
			String tipo = request.getParameter("especificacaoCoordenador");
			String email= request.getParameter("emailCoordenador");
			String voluntario = request.getParameter("voluntario");
			String setor= request.getParameter("setorDeTrabalho");
			String telPrimario= request.getParameter("phonePrimario");
			String telSecundario= request.getParameter("phonePrimario2");
			
			
			
			coordenador.setNome(nome);
			coordenador.setTipo(tipo);
			coordenador.setEmail(email);
			coordenador.setSetor(setor);
			coordenador.setTelPrimario(Long.parseLong(telPrimario));
			coordenador.setTelAuxiliar(Long.parseLong(telSecundario));
			System.out.println(request.getParameter("voluntario"));
				if(voluntario.equalsIgnoreCase("sim")){
					coordenador.setVoluntario(true);
				}else{
					coordenador.setVoluntario(false);
				}
				if(!id.equalsIgnoreCase("")){	
					atividade= daoAtividade.find(Integer.parseInt(id));
					System.out.println(atividade);
					coordenador.addAtividade(atividade);
					atividade.setCoordenador(coordenador);
					daoAtividade.merge(atividade);
				}
			daoCoordenador.persist(coordenador);
			DAO.flush();
			
			
			DAO.commit();
				if(!id.equalsIgnoreCase("")){
					request.setAttribute("mensagem", "Coordenador cadastrado e vinculado à atividade!");
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
				}else{
					request.setAttribute("mensagem", "Coordenador adicionado com sucesso!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
		}else
				if(ref.equalsIgnoreCase("alterar")){
					String tipo = request.getParameter("especificacaoCoordenador");
					String nome = request.getParameter("nomeCoordenador");
					String idParticipante= request.getParameter("idParticipante");
					String email = request.getParameter("emailCoordenador");
					String telefone= request.getParameter("phonePrimario");
					String telAuxiliar= request.getParameter("phonePrimario2");
					String setor= request.getParameter("setorDeTrabalho");
					boolean voluntario = Boolean.parseBoolean(request.getParameter("voluntario"));
					
					DAOCoordenador daoParticipante= new DAOCoordenador();
					Coordenador participante= new Coordenador();
					participante = daoParticipante.find(Integer.parseInt(idParticipante ));
					participante.setNome(nome);
					participante.setEmail(email);
					participante.setTelPrimario(Long.parseLong(telefone));
					participante.setTelAuxiliar(Long.parseLong(telAuxiliar));
					participante.setVoluntario(voluntario);
					participante.setTipo(tipo);
					participante.setSetor(setor);
					
					daoParticipante.merge(participante);
					DAO.commit();
					request.setAttribute("mensagem", "Coordenador editado com sucesso");
					if(!id.equalsIgnoreCase("")){
						Atividade atividade= daoAtividade.find(Integer.parseInt(id));
						request.setAttribute("atividade", atividade);
						
						request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("index.jsp").forward(request, response);
						
					}
						
						
						
				}
		DAO.close();
	}

}
