package br.com.zup.edu.pizzaria.pizzas.cadastropizza;

import br.com.zup.edu.pizzaria.ingredientes.Ingrediente;
import br.com.zup.edu.pizzaria.ingredientes.IngredienteRepository;
import br.com.zup.edu.pizzaria.pizzas.Pizza;
import br.com.zup.edu.pizzaria.shared.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class NovaPizzaRequest {

    @NotBlank
    @UniqueValue(domainAtribute = "sabor",domainClass = Pizza.class)
    private String sabor;

    @NotNull
    @Size(min = 1)
    private List<Long> ingredientes;


    @JsonCreator(mode = PROPERTIES)
    public NovaPizzaRequest(String sabor,
                            List<Long> ingredientes) {
        this.sabor = sabor;
        this.ingredientes = ingredientes;
    }

    public Pizza paraPizza(IngredienteRepository repository) {

        List<Ingrediente> ingredientes = repository.findAllById(this.ingredientes);

        return new Pizza(sabor, ingredientes);
    }
}
