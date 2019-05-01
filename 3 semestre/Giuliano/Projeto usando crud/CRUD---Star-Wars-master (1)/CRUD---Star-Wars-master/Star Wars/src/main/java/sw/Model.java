package sw;

import java.util.List;
import java.util.LinkedList;

public class Model {
	private List<Planeta> planetas = new LinkedList<>();
	private List<Personagem> personagens = new LinkedList<>();
	
	
	public void addPersonagem(Personagem personagem) {
		personagens.add(personagem);
	}

	public List<Personagem> buscarPersonagemLadoForca (String ladoForca) {
		List<Personagem> personagensEncontrados = new LinkedList<>();

		for (Personagem personagem : personagens) {
			if (personagem.getLadoForca().toLowerCase().equals(ladoForca.toLowerCase())) {
				personagensEncontrados.add(personagem);
			}
		}
		return personagensEncontrados;
	}

	public List<Personagem> buscarPersonagemPlaneta(String nomePlaneta) {
		List<Personagem> personagensEncontrados = new LinkedList<>();

		for (Personagem personagem : personagens) {
			if (personagem.getPlaneta().getNome().toLowerCase().equals(nomePlaneta.toLowerCase())) {
				personagensEncontrados.add(personagem);
			}
		}
		return personagensEncontrados;
	}
	
	public List<Personagem> buscarPersonagemNome(String nome) {
		List<Personagem> personagensEncontrados = new LinkedList<>();

		for(Personagem personagem:personagens) {
			if(personagem.getNome().toLowerCase().equals(nome.toLowerCase()))
				personagensEncontrados.add(personagem);
		}
		return personagensEncontrados;
	}

	public List<Personagem> buscarPersonagemTudo(String nome, String ladoForca, String planeta) {
		List<Personagem> personagensEncontrados = new LinkedList<>();

		for(Personagem personagem:personagens) {
			if(personagem.getNome().equals(nome) && personagem.getPlaneta().getNome().equals(planeta) && personagem.getLadoForca().equals(ladoForca))
				personagensEncontrados.add(personagem);
		}
		return personagensEncontrados;
	}

	public void adicionarPersonagem(String nome, String ladoForca, String planeta, String especie) {
		Personagem novoPersonagem = new Personagem(ladoForca, nome, especie, new Planeta(planeta, "ahnlfbsdjf"));

		personagens.add(novoPersonagem);
	}

	public List<Personagem> buscarTodosPersonagens() {
		return personagens;
	}

	public void excluirPersonagem(String nome, String ladoForca, String planeta){

		for(int i = 0; i < personagens.size(); i++) {
			if(personagens.get(i).getNome().equals(nome) && personagens.get(i).getPlaneta().getNome().equals(planeta) && personagens.get(i).getLadoForca().equals(ladoForca)) {
				personagens.remove(personagens.get(i));
			}

		}

	}
}
