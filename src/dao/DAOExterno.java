package dao;

import java.util.List;

import javax.persistence.Query;

import models.Docente;
import models.Externos;

public class DAOExterno extends DAO<Externos> implements DAOParticipanteInterface<Externos>{
	@SuppressWarnings("unchecked")
	public List<Externos> findByNome(String nome){
		String prepared= "%";
		prepared+= nome;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Externos D where D.nome like :nome");
		q.setParameter("nome",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Externos> findByEmail(String email){
		String prepared= "%";
		prepared+= email;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Externos D where D.email like :email");
			q.setParameter("email",prepared);
		return q.getResultList();
	}
}
