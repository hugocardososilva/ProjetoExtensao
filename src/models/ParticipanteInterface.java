package models;

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

}
