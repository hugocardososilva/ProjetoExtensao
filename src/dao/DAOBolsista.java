package dao;

import java.util.List;

import javax.persistence.Query;
import javax.swing.text.StyledEditorKit.BoldAction;

import models.Bolsista;
import models.Docente;

public class DAOBolsista extends DAO<Bolsista> implements DAOParticipanteInterface<Bolsista> {
	@SuppressWarnings("unchecked")
	public List<Bolsista> findByNome(String nome){
		String prepared= "%";
		prepared+= nome;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Bolsista D where D.nome like :nome");
		q.setParameter("nome",prepared);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Bolsista> findByEmail(String email){
		String prepared= "%";
		prepared+= email;
		prepared+= "%";
		Query q= manager.createQuery("SELECT D from Bolsista D where D.email like :email");
			q.setParameter("email",prepared);
		return q.getResultList();
	}

}
