package models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity

public class BeneficiarioIndireto extends Beneficiario {
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Atividade atividade;
	
	public BeneficiarioIndireto(){
		super();
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public String toString() {
		return "BeneficiarioIndireto [getId()=" + getId() + ", getNome()="
				+ getNome() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}


	 	
}
