package dao;

import models.Bolsista;
import models.Docente;
import models.Externos;
import models.Tecnico;

public class FactoryDAOParticipante {
	public static DAO getDAOParticipante(String tipo){
		if(tipo.equalsIgnoreCase("docente")) return new DAODocente();
		if(tipo.equalsIgnoreCase("tecnico")) return new DAOTecnico();
		if(tipo.equalsIgnoreCase("bolsista")) return new DAOBolsista();
		if(tipo.equalsIgnoreCase("externo")) return new DAOExterno();
		if(tipo.equalsIgnoreCase("coordenador")) return new DAOCoordenador();
		else return null;
	}
 
}
