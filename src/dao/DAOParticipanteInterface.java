package dao;

import java.util.List;

public interface DAOParticipanteInterface<T> extends DAOInterface<T>{
	public List<T> findByNome(String nome);
	public List<T> findByEmail(String email);
	public T find(Object id);
	public List<T> findAll();


}
