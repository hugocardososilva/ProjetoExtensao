package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class TipoAtividade {
	private int id;
	private String nome;
	
	@OneToMany(mappedBy="tipoAtividade", cascade= CascadeType.ALL)
	private List<Atividade> atividades;

}
