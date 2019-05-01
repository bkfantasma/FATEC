package sw;

import static spark.Spark.get;
import com.google.gson.Gson;

import java.util.List;

public class Controller {
	
	private Model model;	
	
	public Controller(Model model) {
		this.model = model;
	}


	public void buscarPersonagemNome() {
		get("/StarWars/Personagem/nome/:personagem", (req, res) -> {

			List<Personagem> personagensEncontrados = model.buscarPersonagemNome(req.params(":personagem"));
			return new Gson().toJson(personagensEncontrados);

		});
	}
	public void buscarPersonagemPlaneta() {
		get("/StarWars/Personagem/Planeta/:nome", (req, res) -> {

			List<Personagem> personagensEncontrados = model.buscarPersonagemPlaneta(req.params(":nome"));
			return new Gson().toJson(personagensEncontrados);

		});
	}


	public void buscarPersonagemLadoForca() {
		get("/StarWars/Personagem/ladoForca/:nome", (req, res) -> {

			List<Personagem> personagensEncontrados = model.buscarPersonagemLadoForca(req.params(":nome"));
			return new Gson().toJson(personagensEncontrados);

		});
	}

	public void buscarPersonagemTudo() {
		get("/StarWars/Personagem/:nome/:ladoForca/:planeta", (req, res) -> {

			List<Personagem> personagensEncontrados = model.buscarPersonagemTudo(req.params(":nome"), req.params(":ladoForca"), req.params(":planeta"));
			return new Gson().toJson(personagensEncontrados);

		});
	}

	public void buscarTodosPersonagens() {
		get("/StarWars/todosPersonagens", (req, res) ->
				new Gson().toJson(model.buscarTodosPersonagens())
		);
	}

	public void adicionarPersonagem() {
		get("/add/StarWars/Personagem/:nome/:ladoForca/:planeta/:especie", (req, res) -> {

			model.adicionarPersonagem(req.params(":nome"), req.params(":ladoForca"), req.params(":planeta"), req.params(":especie"));
			return new Gson().toJson(0);

		});
	}

	public void excluirPersonagem() {
		get("/delete/StarWars/:nome/:ladoForca/:planeta", (req, res) -> {

			model.excluirPersonagem(req.params(":nome"), req.params(":ladoForca"), req.params(":planeta"));
			return new Gson().toJson(0);

		});
	}
}
