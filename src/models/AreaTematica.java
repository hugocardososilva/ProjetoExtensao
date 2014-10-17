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
public class AreaTematica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String area;
	private String descricao;
	
	@OneToMany(mappedBy="areaTematica", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Atividade> atividades;

	public AreaTematica() {
		super();
		this.atividades= new ArrayList<Atividade>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return "AreaTematica [id=" + id + ", area=" + area + ", descricao="
				+ descricao + "]";
	}


}
