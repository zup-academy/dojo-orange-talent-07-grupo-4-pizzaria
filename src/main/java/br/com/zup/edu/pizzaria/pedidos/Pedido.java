package br.com.zup.edu.pizzaria.pedidos;

import br.com.zup.edu.pizzaria.pizzas.Pizza;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens = new ArrayList<>();

    private BigDecimal total;

    /**
     * @deprecated para uso do hibernate apenas
     */
    @Deprecated
    public Pedido() { }

    public Pedido(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        total = total.add(item.getSubtotal());
    }

    public Long getId() {
        return id;
    }
}
