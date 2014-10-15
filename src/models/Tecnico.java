package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Tecnico extends Participante {
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Atividade> atividades;

	public Tecnico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	public void addAtividade(Atividade atividade){
		this.atividades.add(atividade);
	}
	public void removeAtividade(Atividade atividade){
		this.atividades.remove(atividade);
	}

}
