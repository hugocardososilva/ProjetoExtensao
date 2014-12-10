package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.DATE;
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

/**
 * Servlet implementation class Relatorios
 */
@WebServlet("/Relatorios.do")
public class Relatorios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOAtividade daoa= new DAOAtividade();
       
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
		
		Connection conexao;
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
			
		}
		
		
		DAO.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
