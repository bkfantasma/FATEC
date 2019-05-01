package sw;

public class Personagem {
	private String nome;
	private String ladoForca;
	private String especie;
    private Planeta planeta;
	
	public Personagem (String ladoForca, String nome, String especie, Planeta planeta) {
		this.ladoForca = ladoForca;
		this.nome = nome;
		this.especie = especie;
		this.planeta = planeta; 
	}
	
 
	public Planeta getPlaneta() {
		return planeta;
	}
	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLadoForca() {
		return ladoForca;
	}
	public void setLadoForca(String ladoForca) {
		this.ladoForca = ladoForca;
	}
}

	

