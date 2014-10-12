package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.DAOAtividade;
import dao.DAOAtividadeAntiga;
import models.Atividade;
import models.AtividadeAntiga;

/**
 * Servlet implementation class CadastrarAtividade
 */
@WebServlet("/CadastrarAtividade.do")
public class CadastrarAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Atividade atividade = new Atividade();
	private DAOAtividade daoAtividade= new DAOAtividade();
	private DAOAtividadeAntiga daoAntiga= new DAOAtividadeAntiga();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarAtividade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		abrindo conexao
		DAO.open();
		DAO.begin();
		
		
		String tipo= request.getParameter("Tipo de atividade");
		String vinculo;
		String titulo = request.getParameter("tituloDaAtividade");
		String fonteDeRecursos= request.getParameter("fonteDeRecursos");
		String objetivo= request.getParameter("objetivo");
		String especificarAtividade= request.getParameter("especificarAtividade");
		String linhaDeExtensao = request.getParameter("especifiqueALinhaDeExtensão");
		String dataInicio= request.getParameter("dataInicio");
		String dataTermino= request.getParameter("dataTermino");
		String localRealizacao= request.getParameter("localDeLocalizacao");
		String valor= request.getParameter("valor");
		
		
			if(request.getParameter("vinculoDaAtividade").equals("Outros")){
				vinculo= request.getParameter("outroVinculoDeAtividade");
			}else{
				vinculo= request.getParameter("vinculoDaAtividade");
				
			}
		
			
		
//		Atividade antiga?
		if(especificarAtividade.equals("antiga")){
				especificarAtividade= request.getParameter("atividadeAntiga");
				AtividadeAntiga atividadeAntiga= new AtividadeAntiga();
				DateFormat format= new SimpleDateFormat("yyyy");
				try {
					atividadeAntiga.setAno(format.parse(especificarAtividade));
					atividadeAntiga.setAtividade(atividade);
					daoAntiga.persist(atividadeAntiga);
					
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
				
			}
		
//		persistindo parametros
			
		atividade.setLocal(localRealizacao);
		atividade.setTipoAtividade(tipo);
		atividade.setTitulo(titulo);
		atividade.setVinculo(vinculo);
		atividade.setValor(Double.parseDouble(valor));
		atividade.setFonteDeRecurso(fonteDeRecursos);
		atividade.setObjetivo(objetivo);
		atividade.setLinhaDeExtensao(linhaDeExtensao);
		
		
//		convertendo datas
		DateFormat data= new SimpleDateFormat("dd/MM/yyyy");
		try {
			atividade.setDataInicio(data.parse(dataInicio));
			atividade.setDataTermino(data.parse(dataTermino));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		daoAtividade.persist(atividade);
		
		DAO.commit();
		
//		pega a ultima atividade adicionada
		List<Atividade> lista= new ArrayList<Atividade>();
		lista= daoAtividade.findAll();
		
		
		request.setAttribute("atividade", lista.get(lista.size()-1));
		request.setAttribute("mensagem", "Atividade cadastrada com sucesso!");
		DAO.close();
		
		
		request.getRequestDispatcher("atividade.jsp").forward(request, response);
	}

}
