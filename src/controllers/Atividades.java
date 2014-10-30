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
	DateFormat data= new SimpleDateFormat("yyyy-MM-dd");
       
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
		DAO.open();
		DAO.begin();
		
		String ref= request.getParameter("ref");
		String outroVinculo;
		String titulo = request.getParameter("tituloDaAtividade");
		String fonteDeRecursos= request.getParameter("fonteDeRecursos");
		String objetivo= request.getParameter("objetivo");
		String especificarAtividade= request.getParameter("especificarAtividade");
		
		String dataInicio= request.getParameter("dataInicio");
		String dataTermino= request.getParameter("dataTermino");
		String valor= request.getParameter("valor");
				//		abrindo conexao
		
		
		if(ref.equalsIgnoreCase("novo")){
		
			int areaTematica= Integer.parseInt(request.getParameter("areaTematica"));
			int localRealizacao= Integer.parseInt(request.getParameter("localDeLocalizacao"));
			int linhaDeExtensao = Integer.parseInt(request.getParameter("especifiqueALinhaDeExtensão"));
			int tipo= Integer.parseInt(request.getParameter("Tipo de atividade"));
			LocalRealizacao local=daoLocal.find(localRealizacao);
			TipoAtividade tipoAtividade= daot.find(tipo);
			LinhaDeExtensao linha= daoLinha.find(linhaDeExtensao);
			AreaTematica area= daoArea.find(areaTematica);

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
								
																
							} catch (ParseException e) {
								
								e.printStackTrace();
							}
							
						}
					
			//		persistindo parametros
					
					
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
		
		System.out.println(atividade.toString());
		
		request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
	
	}else
		if(ref.equalsIgnoreCase("pesquisar")){
			String campo = request.getParameter("campo");
			String pesquisa = request.getParameter("pesquisa");
			String id= request.getParameter("id");
			List<Atividade> lista= new ArrayList<Atividade>();
				if(campo.equalsIgnoreCase("titulo")){
					lista= daoAtividade.findByTitulo(pesquisa);
					request.setAttribute("lista", lista);
					
				}else
					if(campo.equalsIgnoreCase("registro")){
						lista= daoAtividade.findByRegistro(pesquisa);
						request.setAttribute("lista", lista);
					}
				request.setAttribute("id", id);
				request.getRequestDispatcher("atividade/listar-atividades.jsp").forward(request, response);
						
		}else
			if(ref.equalsIgnoreCase("editar")){
				int areaTematica= Integer.parseInt(request.getParameter("areaTematica"));
				int localRealizacao= Integer.parseInt(request.getParameter("localDeLocalizacao"));
				int linhaDeExtensao = Integer.parseInt(request.getParameter("especifiqueALinhaDeExtensão"));
				int tipo= Integer.parseInt(request.getParameter("Tipo de atividade"));
				LocalRealizacao local=daoLocal.find(localRealizacao);
				TipoAtividade tipoAtividade= daot.find(tipo);
				LinhaDeExtensao linha= daoLinha.find(linhaDeExtensao);
				AreaTematica area= daoArea.find(areaTematica);

				atividade= daoAtividade.find(Integer.parseInt(request.getParameter("id")));
				if(request.getParameter("vinculoDaAtividade").equals("Outros")){
					outroVinculo= request.getParameter("outroVinculoDeAtividade");
				}else{
					 int vinculo= Integer.parseInt(request.getParameter("vinculoDaAtividade"));
					 Vinculo v= daov.find(vinculo);
					 atividade.setVinculo(v);
				}
				if(especificarAtividade.equals("antiga")){
					String ano= request.getParameter("atividadeAntiga");
					AtividadeAntiga atividadeAntiga= new AtividadeAntiga();
					DateFormat format= new SimpleDateFormat("yyyy");
					try {
						atividadeAntiga.setAno(format.parse(ano));
						atividadeAntiga.setAtividade(atividade);
						atividade.setAtividadeAntiga(atividadeAntiga);
						daoAntiga.persist(atividadeAntiga);
						
														
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					
				}
				
				try {
					atividade.setDataInicio(data.parse(dataInicio));
					atividade.setDataTermino(data.parse(dataTermino));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				atividade.setLocal(local);
				atividade.setTipoAtividade(tipoAtividade);
				atividade.setLinhaDeExtensao(linha);
				atividade.setTitulo(titulo);
				atividade.setAreaTematica(area);
				
				atividade.setValor(Double.parseDouble(valor));
				atividade.setFonteDeRecurso(fonteDeRecursos);
				atividade.setObjetivo(objetivo);
				daoArea.merge(area);
				daoLinha.merge(linha);
				daoLocal.merge(local);
				daot.merge(tipoAtividade);
				daoAtividade.merge(atividade);
				DAO.commit();
				request.setAttribute("mensagem", "atividade editada com sucesso");
				request.setAttribute("atividade", atividade);
				request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
			}
		DAO.close();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref= request.getParameter("ref");
		Atividade atividade= new Atividade();
		DAOAtividade daoa= new DAOAtividade();
		DAO.open();
		DAO.begin();
			if(ref.equalsIgnoreCase("editar")){
				int id = Integer.parseInt(request.getParameter("id"));
				atividade = daoa.find(id);
				List<TipoAtividade> listaTipo= new ArrayList<TipoAtividade>();
				List<Vinculo> vinculo= new ArrayList<Vinculo>();
				List<AreaTematica> areaTematica= new ArrayList<AreaTematica>();
				List<LinhaDeExtensao> linhaExtensao= new ArrayList<LinhaDeExtensao>();
				List<LocalRealizacao> localRealizacao= new ArrayList<LocalRealizacao>();
				
				DAOTipoAtividade daot= new DAOTipoAtividade();
				DAOVinculo daov= new DAOVinculo();
				DAOAreaTematica daoArea= new DAOAreaTematica();
				DAOLinhaDeExtensao daoLinha= new DAOLinhaDeExtensao();
				DAOLocalRealizacao daoLocal= new DAOLocalRealizacao();
				
				
					listaTipo=daot.findAll();
					vinculo=daov.findAll();
					areaTematica= daoArea.findAll();
					linhaExtensao= daoLinha.findAll();
					localRealizacao= daoLocal.findAll();
					
				request.setAttribute("listaTipo", listaTipo);
				request.setAttribute("vinculo", vinculo);
				request.setAttribute("areaTematica", areaTematica);
				request.setAttribute("linhaExtensao", linhaExtensao);
				request.setAttribute("localRealizacao", localRealizacao);
				request.setAttribute("atividade", atividade);
				request.getRequestDispatcher("atividade/editar-atividade.jsp").forward(request, response);
			}
		DAO.close(); 
	}
}
