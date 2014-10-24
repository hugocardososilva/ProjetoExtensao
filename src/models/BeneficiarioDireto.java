package models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity

public class BeneficiarioDireto extends Beneficiario{
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Atividade atividade;
	
	
	public BeneficiarioDireto(){
		super();
	}

	@Override
	public String toString() {
		return "BeneficiarioDireto [getId()=" + getId() + ", getNome()="
				+ getNome() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	
}
