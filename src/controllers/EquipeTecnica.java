package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOAtividade;
import models.Atividade;
import models.FactoryEquipeTematica;

/**
 * Servlet implementation class EquipeTematica
 */
@WebServlet("/EquipeTematica.do")
public class EquipeTecnica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAtividade daoAtividade= new DAOAtividade();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipeTecnica() {
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
			
			if(ref.equalsIgnoreCase("novo")){
				String tipo = request.getParameter("especificacao");
				Atividade atividade= daoAtividade.find(Integer.parseInt(id));
				models.Participante equipe= FactoryEquipeTematica.getEquipeTematica(tipo);
				System.out.println(equipe.getClass());
				System.out.println(atividade.toString());
			}
		DAO.close();
	}

}
