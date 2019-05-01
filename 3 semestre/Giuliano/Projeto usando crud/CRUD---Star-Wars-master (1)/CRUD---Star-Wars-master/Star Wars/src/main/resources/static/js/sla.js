function limparCampos() {
    $("#ladoForca").empty();
    $("#planeta").empty();
    $("#nome").empty();
    $("#campo_ladoForca").empty();
}

function atualizaCampos() {

    limparCampos();

    $.getJSON("/StarWars/todosPersonagens", function(listaPersonagens) {

        var nome = [], ladoForca = [], planeta = [];

        var selectLadoForcaCampo = $("#campo_ladoForca");
        var selectLadoForca = $("#ladoForca");
        var selectPlaneta = $("#planeta");
        var selectNome = $("#nome");

        selectLadoForca.append(`
             <option value="">
                 Selecione o Lado da Força
             </option>
        `);

         selectNome.append(`
             <option value="">
                 Selecione o Personagem
             </option>
         `);

          selectPlaneta.append(`
              <option value="">
                  Selecione o planeta
              </option>
          `);

          selectLadoForcaCampo.append(`
            <option value="">
                Selecione
            </option>
        `);


        listaPersonagens.forEach(function(personagem) {

            if (nome.indexOf(personagem.nome) == -1) {
                nome.push(personagem.nome);

                selectNome.append(`
                    <option value="${personagem.nome}">
                        ${personagem.nome}
                    </option>
                `);
             }

            if (ladoForca.indexOf(personagem.ladoForca) == -1) {
                ladoForca.push(personagem.ladoForca);

                 selectLadoForca.append(`
                     <option value="${personagem.ladoForca}">
                         ${personagem.ladoForca}
                     </option>
                 `);

                 selectLadoForcaCampo.append(`
                      <option value="${personagem.ladoForca}">
                          ${personagem.ladoForca}
                      </option>
                  `);
            }

            if (planeta.indexOf(personagem.planeta.nome) == -1) {
                planeta.push(personagem.planeta.nome);

                selectPlaneta.append(`
                    <option value="${personagem.planeta.nome}">
                        ${personagem.planeta.nome}
                    </option>
                `);
            }

          });
    });
}

$(document).ready(function(){

    atualizaCampos();

    $("#salvar").click(function() {
        var ladoForca = $('#campo_ladoForca').val();
        var nome = $('#campo_nome').val();
        var especie = $('#campo_especie').val();
        var planeta = $ ('#campo_planeta').val();
        var planetaRegiao = $ ('#campo_planeta_regiao').val();

        if (ladoForca && nome && planeta) {

            var url = "/add/StarWars/Personagem/" + nome + "/" + ladoForca + "/"  + planeta + "/" + especie;

            $.getJSON(url, function(data) {
                $("#campo_ladoForca").val("Escolha");
                $("#campo_nome").val("");
                $("#campo_especie").val("");
                $("#campo_planeta").val("");
                $("#campo_planeta_regiao").val("");

                atualizaCampos();
                setTimeout(function() { alert("Personagem adicionado!"); }, 1);
            });
        }

    });


    $("#excluir").click(function() {
        var nome = $("#nome option:selected" ).val();
        var ladoForca = $('#ladoForca option:selected').val();
        var planeta = $ ('#planeta option:selected').val();

        var url = "/delete/StarWars/" + nome + "/" + ladoForca + "/" + planeta

        $.getJSON(url, function(data) {
            atualizaCampos();
        });
    });


    $("#busca").click(function() {
        var nome = $("#nome option:selected" ).val();
        var ladoForca = $('#ladoForca option:selected').val();
        var planeta = $ ('#planeta option:selected').val();

        $("#dadosPersonagem").empty();

        var url = '';

        if (!ladoForca && nome && !planeta) {
            url = "/StarWars/Personagem/nome/" + nome;
        } else if (ladoForca && !nome && !planeta) {
            url = "/StarWars/Personagem/ladoForca/" + ladoForca;
        } else if (!ladoForca && !nome && planeta) {
            url = "/StarWars/Personagem/Planeta/" + planeta;
        } else if (ladoForca && nome && planeta) {
            url = "/StarWars/Personagem/" + nome + '/' + ladoForca + '/' + planeta;
        } else {
            url = "/StarWars/todosPersonagens";
        }

        $.getJSON(url, function(data) {

            var itens = [];

            data.forEach(function(item){
                itens.push("<tr> <td>"+ item.nome +"</td><td>"+ item.ladoForca + "</td><td>"+ item.especie + "</td><td>" + item.planeta.nome + "</td><td>"+ item.planeta.regiao +"</td></tr> ");
            });

            $("#dadosPersonagem").append(itens);
        });
    });
});