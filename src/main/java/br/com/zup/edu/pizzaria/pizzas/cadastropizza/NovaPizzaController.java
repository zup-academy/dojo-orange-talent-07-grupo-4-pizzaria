package br.com.zup.edu.pizzaria.pizzas.cadastropizza;

import br.com.zup.edu.pizzaria.ingredientes.IngredienteRepository;
import br.com.zup.edu.pizzaria.pizzas.Pizza;
import br.com.zup.edu.pizzaria.pizzas.PizzaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/pizzas")
public class NovaPizzaController {

    private final IngredienteRepository ingredienteRepository;
    private final PizzaRepository pizzaRepository;

    public NovaPizzaController(IngredienteRepository ingredienteRepository,
                               PizzaRepository pizzaRepository){
        this.ingredienteRepository = ingredienteRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @PostMapping
    ResponseEntity<?> cadastra(@RequestBody @Valid NovaPizzaRequest request) {

        Pizza pizza = request.paraPizza(ingredienteRepository);

        Pizza salvo = pizzaRepository.save(pizza);

        URI location = UriComponentsBuilder.fromUriString("/api/pizzas/{id}")
                .build(salvo.getId());

        return ResponseEntity.created(location).build();

    }
}
