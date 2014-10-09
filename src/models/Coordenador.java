package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class Coordenador {
	private int id;
	private String nome;
	private String setor;
	private Long telPrimario;
	private Long telAuxiliar;
	private boolean voluntario;
	private String tipo;
	
	@OneToMany(mappedBy="coordenador", cascade= CascadeType.ALL)
	private List<Atividade> atividades;
	

}
