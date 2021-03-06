package models;

import java.util.ArrayList;
import java.util.List;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Coordenador extends Participante implements ParticipanteInterface<Coordenador> {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String setor;
	
	private Long telAuxiliar;
	
	private String tipo;

	
	@OneToMany(mappedBy="coordenador", cascade= CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Atividade> atividades;

	public Coordenador() {
		super();
		this.atividades= new ArrayList<Atividade>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	

	public Long getTelAuxiliar() {
		return telAuxiliar;
	}

	public void setTelAuxiliar(Long telAuxiliar) {
		this.telAuxiliar = telAuxiliar;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	@Override
	public String toString() {
		return "Coordenador [id=" + id + ", setor=" + setor + ","
				+ " telAuxiliar=" + telAuxiliar + ", tipo="
				+ tipo + "]";
	}
	
}
