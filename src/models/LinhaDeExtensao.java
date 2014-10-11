package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LinhaDeExtensao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private int numero;
	private String denominacao;
	private String definicoes;
	public LinhaDeExtensao() {
		super();
	}
	
//	@OneToMany(mappedBy="linhaDeExtensao", cascade=CascadeType.ALL)
//	private List<Atividade> atividades;
	
	
	
}
