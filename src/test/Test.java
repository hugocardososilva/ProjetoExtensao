package test;

import dao.DAO;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import models.Atividade;
import models.Coordenador;

public class Test {
	public static void cadastro(){
		DAOAtividade daoa= new DAOAtividade();
		DAOCoordenador daoc= new DAOCoordenador();
		DAO.open();
		DAO.begin();
		Atividade a= new Atividade();
		Coordenador c= new Coordenador();
		daoa.persist(a);
		DAO.flush();
		daoc.persist(c);
		DAO.flush();
		DAO.commit();
		DAO.close();
		
	}

}
