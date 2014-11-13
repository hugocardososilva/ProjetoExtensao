package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DAO;
import dao.DAOUser;
import models.Usuario;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAOUser daoU= new DAOUser();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
			if(ref.equalsIgnoreCase("inicio")){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else
				if(ref.equalsIgnoreCase("novo")){
					request.getRequestDispatcher("user/novo-user.jsp").forward(request, response);
				}else
					if(ref.equalsIgnoreCase("logoff")){
						HttpSession session= request.getSession();
						session.invalidate();
//						request.setAttribute("mensagem", "");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		DAO.open();
		DAO.begin();
		if(ref.equalsIgnoreCase("login")){
			String login= request.getParameter("login");
			try {
				String senha = Usuario.convertPasswordToMD5(request.getParameter("senha"));
			
			HttpSession session= request.getSession();
			Usuario user= new Usuario();
			System.out.println(senha);
			user= daoU.login(login, senha);
			
					
					session.setAttribute("user", user);
					request.setAttribute("mensagem", "Login efetuado com sucesso!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}catch (NullPointerException e) {
				System.out.println(e.toString());
				request.setAttribute("mensagem", "Nome de usuário ou senha inválidos");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else
			if(ref.equalsIgnoreCase("add")){
				
			}
		DAO.close();
	}

}
