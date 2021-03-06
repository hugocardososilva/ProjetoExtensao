package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class AtividadeAntiga {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	@Temporal(TemporalType.DATE)
	private Date ano;
	@OneToOne(cascade= CascadeType.PERSIST, fetch= FetchType.EAGER)
	private Atividade atividade;
	
		public AtividadeAntiga() {
			super();
		}

		
		
		public int getId() {
			return id;
		}

		

		public Atividade getAtividade() {
			return atividade;
		}



		public void setAtividade(Atividade atividade) {
			this.atividade = atividade;
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
			return "AtividadeAntiga [id=" + id + ", ano=" + ano
					+"]";
		}




		
	
	

}
