package dao;

import java.util.List;

import javax.persistence.Query;

import models.Docente;
import models.Tecnico;

public class DAOTecnico extends DAO<Tecnico> implements DAOParticipanteInterface<Tecnico>{

	@SuppressWarnings("unchecked")
	public List<Tecnico> findByNome(String nome){
		String prepared= "%";
		prepared+= nome;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Tecnico D where D.nome like :nome");
		q.setParameter("nome",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Tecnico> findByEmail(String email){
		String prepared= "%";
		prepared+= email;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Tecnico D where D.email like :email");
			q.setParameter("email",prepared);
		return q.getResultList();
	}
}
