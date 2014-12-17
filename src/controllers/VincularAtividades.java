package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import dao.DAO;
import dao.DAOAtividade;

/**
 * Servlet implementation class VincularAtividade
 */
@WebServlet("/VincularAtividades.do")
public class VincularAtividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAOAtividade daoa= new DAOAtividade();
    DAO dao= new DAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VincularAtividades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.open();
		dao.begin();
			String ref = request.getParameter("ref");
			String id= request.getParameter("id");
				
				if(ref.equalsIgnoreCase("novo")){
					Atividade atividade = daoa.find(Integer.parseInt(id));
					request.setAttribute("atividade", atividade);
					request.getRequestDispatcher("atividade/pesquisar-atividade.jsp").forward(request, response);
					
				}else
					if(ref.equalsIgnoreCase("inserir")){
						String idAtividadeVincular= request.getParameter("idAtividadeVincular");
						Atividade atividade= daoa.find(Integer.parseInt(id));
						Atividade atividadeVincular= daoa.find(Integer.parseInt(idAtividadeVincular));
						atividade.addAtividade(atividadeVincular);
						daoa.merge(atividade);
						dao.commit();
						request.setAttribute("atividade", atividade);
						request.setAttribute("mensagem", "Atividade vinculada com sucesso!");
						request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
					}
		dao.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
