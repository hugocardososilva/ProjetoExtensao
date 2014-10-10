package models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("INDIRETO")
public class BeneficiarioIndireto extends Beneficiario {
	
	@ManyToOne(cascade=CascadeType.ALL)
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
		return "BeneficiarioIndireto [atividade=" + atividade + "]";
	}
	 	
}
