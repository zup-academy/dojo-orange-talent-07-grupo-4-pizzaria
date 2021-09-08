package br.com.zup.edu.pizzaria.pedidos;

import br.com.zup.edu.pizzaria.pizzas.Pizza;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @Enumerated
    private TipoDeBorda borda;

    @ManyToOne
    private Pizza pizza;

    private BigDecimal subtotal;

    /**
     * @deprecated para uso do hibernate apenas
     */
    @Deprecated
    public Item() { }

    public Item(Pedido pedido,
                TipoDeBorda borda,
                Pizza pizza) {
        this.pedido = pedido;
        this.borda = borda;
        this.pizza = pizza;
        this.subtotal = pizza.getPreco().add(borda.getPreco());
    }


    public BigDecimal getSubtotal() {
        return subtotal;
    }
}
