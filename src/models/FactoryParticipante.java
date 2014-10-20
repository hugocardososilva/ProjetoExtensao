package models;

public class FactoryParticipante {
	public static ParticipanteInterface<?> getEquipeTematica(String tipo ) {
		if(tipo.equalsIgnoreCase("docente")) return new Docente();
		if(tipo.equalsIgnoreCase("tecnico")) return new Tecnico();
		if(tipo.equalsIgnoreCase("bolsista")) return new Bolsista();
		if(tipo.equalsIgnoreCase("externo")) return new Externos();
		if(tipo.equalsIgnoreCase("coordenador")) return new Coordenador();
		else return null;
		
		}

} 
