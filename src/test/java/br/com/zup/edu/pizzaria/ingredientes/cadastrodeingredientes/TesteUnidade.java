package br.com.zup.edu.pizzaria.ingredientes.cadastrodeingredientes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class TesteUnidade {

    @Test
    @DisplayName("deveSerPrecoPositivo")

    void deveSerPrecoPositivo(){

        NovoIngredienteRequest request = new NovoIngredienteRequest("óregano", new BigDecimal(0.50), 250);
        assertEquals(new BigDecimal(0.50), request.getPreco());
    }
}
