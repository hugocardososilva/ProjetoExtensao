package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Atividade;
import models.BeneficiarioDireto;
import models.BeneficiarioIndireto;
import dao.DAO;
import dao.DAOAtividade;
import dao.DAOBeneficiarioDireto;
import dao.DAOBeneficiarioIndireto;

/**
 * Servlet implementation class Beneficiarios
 */
@WebServlet("/Beneficiarios.do")
public class Beneficiarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAtividade daoa= new DAOAtividade();
	DAOBeneficiarioDireto daoDireto= new DAOBeneficiarioDireto();
	DAOBeneficiarioIndireto daoIndireto= new DAOBeneficiarioIndireto();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beneficiarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		String id=request.getParameter("id");
		String tipo = request.getParameter("especificacao");
		DAO.open();
		DAO.begin();
//		
			if(ref.equalsIgnoreCase("novo")){
//				Atividade atividade = daoa.find(id);
				request.setAttribute("id", id);
				request.setAttribute("especificacao", tipo);
				request.getRequestDispatcher("beneficiario/inserir-beneficiario.jsp").forward(request, response);
				
			
			}else
				if(ref.equalsIgnoreCase("remover")){
					System.out.println(id);
				int idBeneficiario= Integer.parseInt(request.getParameter("idBeneficiario"));
					Atividade atividade = daoa.find(Integer.parseInt(id));
					if(tipo.equalsIgnoreCase("direto")){
						BeneficiarioDireto direto = daoDireto.find(idBeneficiario);
						atividade.removeBeneficiarioDireto(direto);
						daoa.merge(atividade);
						daoDireto.remove(direto);
						
					}else{
						BeneficiarioIndireto indireto = daoIndireto.find(idBeneficiario);
						atividade.removeBeneficiarioIndireto(indireto);
						daoa.merge(atividade);
						daoIndireto.remove(indireto);
					}
					DAO.commit();
					request.setAttribute("atividade", atividade);
					request.setAttribute("mensagem", "Beneficiário removido com sucesso!");
					request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
				}
			DAO.close();	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeneficiarioDireto direto= new BeneficiarioDireto();
		BeneficiarioIndireto indireto= new BeneficiarioIndireto();
		String ref= request.getParameter("ref");
		int id=Integer.parseInt(request.getParameter("id"));
		String especificacao = request.getParameter("especificacao");
		
		
		Atividade atividade= new Atividade();
		DAO.open();
		DAO.begin();
		
		
		if(ref.equalsIgnoreCase("salvar")){
			String nome= request.getParameter("nome");
			atividade= daoa.find(id);
				if(especificacao.equalsIgnoreCase("direto")){
					direto.setNome(nome);
					direto.setAtividade(atividade);
					atividade.addBeneficiarioDireto(direto);
					daoa.merge(atividade);
					daoDireto.persist(direto);
					
//					
					DAO.flush();
					DAO.commit();


				}else
					if(especificacao.equalsIgnoreCase("indireto")){
						indireto.setNome(nome);
						indireto.setAtividade(atividade);
						
						daoIndireto.persist(indireto);
						DAO.flush();
						atividade.addBeneficiarioIndireto(indireto);
						daoa.merge(atividade);
					}
				
			DAO.commit();
			request.setAttribute("atividade", atividade);
			request.setAttribute("mensagem", "Beneficiário adicionado com sucesso!");
			request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
		}	
		DAO.close();
	}

}
