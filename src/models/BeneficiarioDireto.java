package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("DIRETO")
public class BeneficiarioDireto extends Beneficiario{
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
	
	
}
