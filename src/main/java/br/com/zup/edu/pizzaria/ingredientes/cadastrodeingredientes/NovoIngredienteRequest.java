package br.com.zup.edu.pizzaria.ingredientes.cadastrodeingredientes;

import br.com.zup.edu.pizzaria.ingredientes.Ingrediente;
import br.com.zup.edu.pizzaria.shared.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

class NovoIngredienteRequest {

    @JsonProperty
    @NotBlank
    @UniqueValue(domainAtribute = "nome",domainClass = Ingrediente.class)
    private String nome;

    @JsonProperty
    @NotNull
    @Positive
    private BigDecimal preco;

    @JsonProperty
    @Positive
    private int quantidade; // tudo é grama

    public NovoIngredienteRequest(String nome,
                                  BigDecimal preco,
                                  int quantidade) {

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;

    }

    public Ingrediente paraIngrediente() {

        return new Ingrediente(nome, quantidade, preco);
    }


}
