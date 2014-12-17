package controllers;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.ControleRegistro;
import dao.DAO;
import dao.DAOAtividade;
import dao.DAOControleRegistro;

/**
 * Servlet implementation class GerarRegistro
 */
@WebServlet("/GerarRegistro.do")
public class GerarRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAtividade daoa= new DAOAtividade();
	DAOControleRegistro daoControle= new DAOControleRegistro();
	Atividade atividade= new Atividade();
	ControleRegistro controleRegistro= new ControleRegistro();
	String controle= "";
	DAO dao= new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerarRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.open();
		dao.begin();
		int id= Integer.parseInt(request.getParameter("id"));
		controleRegistro= daoControle.find(daoControle.getLast());
		DecimalFormat formDecimal= new DecimalFormat("00");
		DecimalFormat formCentena= new DecimalFormat("000");
			atividade= daoa.find(id);
		controle+=atividade.getTipoAtividade().getSigla();
		controle+="-";
		controle+= atividade.getAreaTematica().getSigla();
		controle+= "-";
		controle += formDecimal.format(atividade.getLocal().getCodigo());
		controle+= "-";
		if(controleRegistro!= null){
			
			
			controle+= controleRegistro.getNumero()+1;
		}else{
			
		}
		System.out.println(controle);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
