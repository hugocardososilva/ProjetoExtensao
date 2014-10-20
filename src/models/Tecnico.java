package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Tecnico extends Participante implements ParticipanteInterface<Tecnico>{
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Atividade> atividades;

	public Tecnico() {
		super();
		this.atividades= new ArrayList<>();
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
