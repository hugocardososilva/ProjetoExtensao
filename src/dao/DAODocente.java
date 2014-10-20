package dao;

import java.util.List;

import javax.persistence.Query;

import models.Docente;

public class DAODocente extends DAO<Docente> implements DAOParticipanteInterface<Docente>{
	
	@SuppressWarnings("unchecked")
	public List<Docente> findByNome(String nome){
		String prepared= "%";
		prepared+= nome;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Docente D where D.nome like :nome");
		q.setParameter("nome",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Docente> findByEmail(String email){
		String prepared= "%";
		prepared+= email;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Docente D where D.email like :email");
			q.setParameter("email",prepared);
		return q.getResultList();
	}

}
