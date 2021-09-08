package br.com.zup.edu.pizzaria.ingredientes.cadastrodeingredientes;

import br.com.zup.edu.pizzaria.ingredientes.Ingrediente;
import br.com.zup.edu.pizzaria.ingredientes.IngredienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/ingredientes")
class NovoIngredienteController {

    private final IngredienteRepository repository;

    NovoIngredienteController(IngredienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    ResponseEntity<?> cadastra(@RequestBody @Valid NovoIngredienteRequest request) {

        Ingrediente ingrediente = request.paraIngrediente();

        Ingrediente salvo = repository.save(ingrediente);

        URI location = UriComponentsBuilder.fromUriString("/api/ingredientes/{id}")
                                           .build(salvo.getId());

        return ResponseEntity.created(location).build();

    }

}
