package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("INDIRETO")
public class BeneficiarioIndireto extends Beneficiario {
	public BeneficiarioIndireto(){
		super();
	}
		
}
