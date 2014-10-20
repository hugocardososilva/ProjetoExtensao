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
import dao.DAOAreaTematica;
import dao.DAOAtividade;
import dao.DAOAtividadeAntiga;
import dao.DAOLinhaDeExtensao;
import dao.DAOLocalRealizacao;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;
import models.AreaTematica;
import models.Atividade;
import models.AtividadeAntiga;
import models.LinhaDeExtensao;
import models.LocalRealizacao;
import models.TipoAtividade;
import models.Vinculo;

/**
 * Servlet implementation class CadastrarAtividade
 */
@WebServlet("/Atividades.do")
public class Atividades extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Atividade atividade = new Atividade();
	private DAOAtividade daoAtividade= new DAOAtividade();
	private DAOAtividadeAntiga daoAntiga= new DAOAtividadeAntiga();
	DAOTipoAtividade daot= new DAOTipoAtividade();
	DAOVinculo daov= new DAOVinculo();
	DAOAreaTematica daoArea= new DAOAreaTematica();
	DAOLinhaDeExtensao daoLinha= new DAOLinhaDeExtensao();
	DAOLocalRealizacao daoLocal= new DAOLocalRealizacao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atividades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		
		//		abrindo conexao
		DAO.open();
		DAO.begin();
		
		
		if(ref.equalsIgnoreCase("novo")){
		
			String outroVinculo;
			String titulo = request.getParameter("tituloDaAtividade");
			String fonteDeRecursos= request.getParameter("fonteDeRecursos");
			String objetivo= request.getParameter("objetivo");
			String especificarAtividade= request.getParameter("especificarAtividade");
			
			String dataInicio= request.getParameter("dataInicio");
			String dataTermino= request.getParameter("dataTermino");
			
			String valor= request.getParameter("valor");
		
				int areaTematica= Integer.parseInt(request.getParameter("areaTematica"));
				int localRealizacao= Integer.parseInt(request.getParameter("localDeLocalizacao"));
				int linhaDeExtensao = Integer.parseInt(request.getParameter("especifiqueALinhaDeExtensão"));
				int tipo= Integer.parseInt(request.getParameter("Tipo de atividade"));
				
					if(request.getParameter("vinculoDaAtividade").equals("Outros")){
						outroVinculo= request.getParameter("outroVinculoDeAtividade");
					}else{
						 int vinculo= Integer.parseInt(request.getParameter("vinculoDaAtividade"));
						 Vinculo v= daov.find(vinculo);
						 atividade.setVinculo(v);
						 v.addAtividade(atividade);
						 daov.merge(v);
						
					}
				
			
		
//		Atividade antiga?
					if(especificarAtividade.equals("antiga")){
							String ano= request.getParameter("atividadeAntiga");
							AtividadeAntiga atividadeAntiga= new AtividadeAntiga();
							DateFormat format= new SimpleDateFormat("yyyy");
							try {
								atividadeAntiga.setAno(format.parse(ano));
								atividadeAntiga.setAtividade(atividade);
								atividade.setAtividadeAntiga(atividadeAntiga);
								daoAntiga.persist(atividadeAntiga);
								
								DAO.flush();
								
							} catch (ParseException e) {
								
								e.printStackTrace();
							}
							
						}
					
			//		persistindo parametros
					LocalRealizacao local=daoLocal.find(localRealizacao);
					TipoAtividade tipoAtividade= daot.find(tipo);
					LinhaDeExtensao linha= daoLinha.find(linhaDeExtensao);
					AreaTematica area= daoArea.find(areaTematica);
					
						local.addAtividade(atividade);
						tipoAtividade.addAtividade(atividade);
						linha.addAtividade(atividade);
						area.addAtividade(atividade);
						
					
							atividade.setLocal(local);
							atividade.setTipoAtividade(tipoAtividade);
							atividade.setLinhaDeExtensao(linha);
							atividade.setTitulo(titulo);
							atividade.setAreaTematica(area);
							
							atividade.setValor(Double.parseDouble(valor));
							atividade.setFonteDeRecurso(fonteDeRecursos);
							atividade.setObjetivo(objetivo);
							
				
		
//		convertendo datas
		DateFormat data= new SimpleDateFormat("dd/MM/yyyy");
		try {
			atividade.setDataInicio(data.parse(dataInicio));
			atividade.setDataTermino(data.parse(dataTermino));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		daoArea.merge(area);
		daoLinha.merge(linha);
		daoLocal.merge(local);
		daot.merge(tipoAtividade);
		
		daoAtividade.persist(atividade);
		
		DAO.commit();
		
		Atividade atividade = daoAtividade.find(daoAtividade.getLast());
		request.setAttribute("atividade", atividade);
		request.setAttribute("mensagem", "Atividade cadastrada com sucesso!");
		DAO.close();
		System.out.println(atividade.toString());
		
		request.getRequestDispatcher("atividade.jsp").forward(request, response);
	
	}else
		{
			
		
	}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
	}
}
