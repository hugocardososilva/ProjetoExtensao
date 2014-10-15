package models;

public class FactoryEquipeTematica {
	public static Participante getEquipeTematica(String tipo ) {
		if(tipo.equalsIgnoreCase("docente")) return new Docente();
		if(tipo.equalsIgnoreCase("tecnico")) return new Tecnico();
		if(tipo.equalsIgnoreCase("bolsista")) return new Bolsista();
		if(tipo.equalsIgnoreCase("externo")) return new Externos();
		else return null;
		
		}

} 
