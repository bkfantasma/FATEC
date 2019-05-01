package sw;

public class Planeta {
	private String nome;
	private String regiao;
	
	public Planeta (String nome, String regiao) {
		this.nome = nome;
		this.regiao = regiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
}
