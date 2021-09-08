package br.com.zup.edu.pizzaria.pedidos.novopedido;

import br.com.zup.edu.pizzaria.pedidos.Item;
import br.com.zup.edu.pizzaria.pedidos.Pedido;
import br.com.zup.edu.pizzaria.pedidos.TipoDeBorda;
import br.com.zup.edu.pizzaria.pizzas.Pizza;
import br.com.zup.edu.pizzaria.pizzas.PizzaRepository;

import java.util.Optional;

public class ItemRequest {

    private Long pizzaId;

    private TipoDeBorda borda;


    public Item paraItem(Pedido pedido, PizzaRepository repository) {

        Optional<Pizza> possivelPizza = repository.findById(pizzaId);

        return new Item(pedido, borda, possivelPizza.get());
    }
}
