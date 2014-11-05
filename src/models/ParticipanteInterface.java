package models;

import java.util.List;

public interface ParticipanteInterface<T> {
	public void addAtividade(Atividade atividade);
	public void removeAtividade(Atividade atividade);
	public int getId();
	public void setId(int id);
	public String getNome();
	public void setNome(String nome);
	public String getEmail();
	public void setEmail(String email);
	public boolean isVoluntario();
	public void setVoluntario(boolean voluntario);
	public String toString();
	public List<Atividade> getAtividades();
	public void setAtividades(List<Atividade> atividades);
	public Long getTelPrimario();
	public void setTelPrimario(Long telefonePrimario);

}
