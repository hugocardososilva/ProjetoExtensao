package test;

import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dao.DAOAreaTematica;
import dao.DAOAtividade;
import dao.DAOCoordenador;
import dao.DAOParticipante;
import dao.DAOParticipanteInterface;
import dao.DAOTipoAtividade;
import dao.FactoryDAOParticipante;
import models.AreaTematica;
import models.Atividade;
import models.Bolsista;
import models.Coordenador;
import models.Docente;
import models.Externos;
import models.FactoryEquipeTematica;
import models.Participante;
import models.ParticipanteInterface;
import models.TipoAtividade;

public class Test {
	public static void cadastro(){
		DAOAtividade daoa= new DAOAtividade();
//		DAOCoordenador daoc= new DAOCoordenador();
//		DAOParticipante daop= new DAOParticipante();
//		DAOTipoAtividade daot= new DAOTipoAtividade();
//		List<TipoAtividade> lista = new ArrayList<TipoAtividade>();
//		DAO.open();
//		DAO.begin();
//		Atividade a= new Atividade();
//		Coordenador c= new Coordenador();
//		Docente d= new Docente();
//		AreaTematica area= new AreaTematica();
//		area.setArea("teste");
//		a.setTitulo("teste");
//		a.setAreaTematica(area);
//		area.addAtividade(a);
//		a.setCoordenador(c);
//		c.addAtividade(a);
//		c.setEmail("eu");
////		a.addDocente(d);
//		d.addAtividade(a);
//		d.setEmail("teste");
//		d.setVoluntario(false);
//		Bolsista b= new Bolsista();
//		b.setEmail("fulano");
//		b.addAtividade(a);
//		Participante p = new Externos();
//		p.setEmail("externo");
//		System.out.println(lista=daot.findAll());
//		p.addAtividade(a);
//		daoa.persist(a);
//		a.addBolsista(b);
//		a.addExternos((Externos)p);
//		DAO.flush();
//		
//		daoc.persist(c);
//		DAO.flush();
//		FactoryDAOParticipante.getDAOParticipante("docente").persist(FactoryEquipeTematica.getEquipeTematica("docente"));
//		DAO.flush();
//		daop.persist(b);
//		daop.persist(p);
//		DAO.flush();
//		DAO.commit();
		DAO.open();
		DAO.begin();
		DAOParticipanteInterface dao= FactoryDAOParticipante.getDAOParticipante("docente");
		System.out.println(dao.getClass());
		ParticipanteInterface<?> participante= FactoryEquipeTematica.getEquipeTematica("docente");
		participante.setEmail("funiscreiosson");
		participante.setNome("nomenilson");
		participante.setVoluntario(false);
		dao.persist(participante);
		DAO.commit();
		
//		Atividade atividade= daoa.find(2);
//		System.out.println(atividade.toString());
		DAO.close();
//		System.out.println(a.toString());
		
		
	}

}
