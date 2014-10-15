package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ControleRegistro {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int numero;
	private Date ano;
	@OneToOne(cascade=CascadeType.ALL)
	private Atividade atividade;
	
	
	public ControleRegistro() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Date getAno() {
		return ano;
	}


	public void setAno(Date ano) {
		this.ano = ano;
	}


	public Atividade getAtividade() {
		return atividade;
	}


	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}


	@Override
	public String toString() {
		return "ControleRegistro [id=" + id + ", numero=" + numero + ", ano="
				+ ano + ", atividade=" + atividade + "]";
	}
	
	 
	

}
