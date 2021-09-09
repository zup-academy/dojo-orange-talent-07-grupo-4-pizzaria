package br.com.zup.edu.pizzaria.pizzas.cadastrodepizzas;


import br.com.zup.edu.pizzaria.ingredientes.Ingrediente;
import br.com.zup.edu.pizzaria.pizzas.cadastropizza.NovaPizzaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class NovaPizzaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void deveCadastrarNovaPizza() throws Exception {
        Ingrediente manjericão = new Ingrediente("manjericão", 50, new BigDecimal(5.0));
        Ingrediente muçarela = new Ingrediente("muçarela", 100, new BigDecimal(20.0));
        Ingrediente molhoTomate = new Ingrediente("molhoTomate", 100, new BigDecimal(15.0));

        List<Long> ingredientes = new ArrayList<>();
        ingredientes.add(1L);
        ingredientes.add(2L);
        ingredientes.add(3L);

        NovaPizzaRequest body = new NovaPizzaRequest("margherita", ingredientes);

        MockHttpServletRequestBuilder request = post("/api/pizzas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(body));

        mvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(redirectedUrlPattern("/api/pizzas/{id}"));
    }

}
