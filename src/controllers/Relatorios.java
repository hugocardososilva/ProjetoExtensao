package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.DATE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import dao.DAO;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import dao.DAOTipoAtividade;
import dao.DAOVinculo;

/**
 * Servlet implementation class Relatorios
 */
@WebServlet("/Relatorios.do")
public class Relatorios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOAtividade daoa= new DAOAtividade();
	DAOCoordenador daoc= new DAOCoordenador();
	DAOTipoAtividade daot= new DAOTipoAtividade();
	DAOVinculo daov= new DAOVinculo();
	DateFormat data= new SimpleDateFormat("yyyy-MM-dd");
	Connection conexao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Relatorios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref = request.getParameter("ref");
		
		
		DAO.open();
		DAO.begin();
			if(ref.equalsIgnoreCase("atividade")){
			try{
				conexao= DAO.getConnection();
				String id = request.getParameter("id");
//				JasperCompileManager.compileReportToFile("report-atividade.jrxml");
//				JasperCompileManager.compileReportToFile("report-atividade_subDocente.jrxml");
//				JasperCompileManager.compileReportToFile("report-atividades_vinculadas.jrxml");
				Map<String, Object> parametros = new HashMap<>();
				parametros.put("ID_ATIVIDADE",Integer.parseInt(id));
				String nomeReport = request.getServletContext().getRealPath("/WEB-INF/relatorios/report-atividade.jasper");
				System.out.println(nomeReport);
				
				JasperPrint print = JasperFillManager.fillReport(nomeReport, parametros, conexao);
				JRExporter exporter= new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=Ficha-Atividade"+ System.currentTimeMillis());
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				
				exporter.exportReport();
				request.setAttribute("atividade", daoa.find(Integer.parseInt(id)));
//				request.getRequestDispatcher("atividade/atividade.jsp").forward(request, response);
				conexao.close();

			}catch (Exception e) {
				e.printStackTrace();
			}	
			
		}else 
			if(ref.equalsIgnoreCase("coordenador")){
				request.setAttribute("tipo", daoc.findAll());
				request.getRequestDispatcher("relatorios/relatorio-por-coordenador.jsp").forward(request, response);
			}else 
				if(ref.equalsIgnoreCase("tipo")){
					request.setAttribute("tipo", daot.findAll());
					request.getRequestDispatcher("relatorios/relatorio-por-tipo.jsp").forward(request, response);
				}else 
					if(ref.equalsIgnoreCase("vinculo")){
						request.setAttribute("tipo", daov.findAll());
						request.getRequestDispatcher("relatorios/relatorio-por-vinculo.jsp").forward(request, response);
					}if(ref.equalsIgnoreCase("periodo")){
						
						request.getRequestDispatcher("relatorios/relatorio-por-periodo.jsp").forward(request, response);
					}
		
		
		DAO.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO.open();
		DAO.begin();
		
		String ref = request.getParameter("ref");
		 String dataInicio = request.getParameter("inicio");
		 String dataFim = request.getParameter("fim");
		 if(ref.equalsIgnoreCase("coordenador")){
			 
			 String id = request.getParameter("coordenadorAtividade");
			 try {
				conexao= DAO.getConnection();
				Map<String, Object> parametros = new HashMap<>();
				parametros.put("ID_COORDENADOR", Integer.parseInt(id));
				parametros.put("DATA_INICIO", data.parse(dataInicio));
				parametros.put("DATA_FIM", data.parse(dataFim));
				String nomeReport = request.getServletContext().getRealPath("/WEB-INF/relatorios/relatorio_atividade_por_coordenador.jasper");
				JasperPrint print = JasperFillManager.fillReport(nomeReport, parametros, conexao);
				JRExporter exporter= new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=Relatorio-coordenador"+ System.currentTimeMillis());
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				
				exporter.exportReport();
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else
			 if(ref.equalsIgnoreCase("vinculo")){
			 
			 String id = request.getParameter("vinculoAtividade");
			 try {
				conexao= DAO.getConnection();
				Map<String, Object> parametros = new HashMap<>();
				parametros.put("ID_VINCULO", Integer.parseInt(id));
				parametros.put("DATA_INICIO", data.parse(dataInicio));
				parametros.put("DATA_FIM", data.parse(dataFim));
				String nomeReport = request.getServletContext().getRealPath("/WEB-INF/relatorios/relatorio_por_vinculo.jasper");
				JasperPrint print = JasperFillManager.fillReport(nomeReport, parametros, conexao);
				JRExporter exporter= new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=Relatorio-vinculo"+ System.currentTimeMillis());
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				
				exporter.exportReport();
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else
			 if(ref.equalsIgnoreCase("tipo")){
			 
			 String id = request.getParameter("tipoAtividade");
			 try {
				conexao= DAO.getConnection();
				Map<String, Object> parametros = new HashMap<>();
				parametros.put("ID_TIPO", Integer.parseInt(id));
				parametros.put("DATA_INICIO", data.parse(dataInicio));
				parametros.put("DATA_FIM", data.parse(dataFim));
				String nomeReport = request.getServletContext().getRealPath("/WEB-INF/relatorios/relatorio_por_tipo.jasper");
				JasperPrint print = JasperFillManager.fillReport(nomeReport, parametros, conexao);
				JRExporter exporter= new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=Relatorio-tipo"+ System.currentTimeMillis());
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				
				exporter.exportReport();
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else
			 if(ref.equalsIgnoreCase("periodo")){
			 
			 
			 try {
				conexao= DAO.getConnection();
				Map<String, Object> parametros = new HashMap<>();
				
				parametros.put("DATA_INICIO", data.parse(dataInicio));
				parametros.put("DATA_FIM", data.parse(dataFim));
				String nomeReport = request.getServletContext().getRealPath("/WEB-INF/relatorios/relatorio_atividade_periodo.jasper");
				JasperPrint print = JasperFillManager.fillReport(nomeReport, parametros, conexao);
				JRExporter exporter= new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=Relatorio-periodo"+ System.currentTimeMillis());
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
				
				exporter.exportReport();
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 DAO.close();
	}
	
}
