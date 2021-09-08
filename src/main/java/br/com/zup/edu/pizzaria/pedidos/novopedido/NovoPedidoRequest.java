package br.com.zup.edu.pizzaria.pedidos.novopedido;

import br.com.zup.edu.pizzaria.pedidos.Pedido;
import br.com.zup.edu.pizzaria.pizzas.PizzaRepository;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

public class NovoPedidoRequest {

    private EnderecoRequest endereco;

    private List<ItemRequest> itens;

    @JsonCreator(mode = PROPERTIES)
    public NovoPedidoRequest(EnderecoRequest endereco,
                             List<ItemRequest> itens) {
        this.endereco = endereco;
        this.itens = itens;
    }


    public Pedido paraPedido(PizzaRepository repository) {

        Pedido pedido = new Pedido(endereco.paraEndereco());

        itens.stream()
             .map(item -> item.paraItem(pedido, repository))
             .forEach(pedido::adicionarItem);


        return pedido;
    }
}
