package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class AtividadeAntiga {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	@Temporal(TemporalType.DATE)
	private Date ano;
	
		public AtividadeAntiga() {
			super();
		}

		
		
		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public Date getAno() {
			return ano;
		}



		public void setAno(Date ano) {
			this.ano = ano;
		}



		@Override
		public String toString() {
			return "AtividadeAntiga [id=" + id + ", ano=" + ano + "]";
		}
	
	

}
