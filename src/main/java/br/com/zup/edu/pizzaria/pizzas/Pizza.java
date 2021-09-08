package br.com.zup.edu.pizzaria.pizzas;

import br.com.zup.edu.pizzaria.ingredientes.Ingrediente;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pizza {

    private final static BigDecimal PRECO_MASSA = new BigDecimal("15.0");
    private final static BigDecimal PRECO_MAO_DE_OBRA = new BigDecimal("5.0");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sabor;

    private BigDecimal preco;

    @ManyToMany
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public Pizza(String sabor, List<Ingrediente> ingredientes) {
        this.sabor = sabor;
        this.ingredientes = ingredientes;
        calcularPreco();
    }

    /**
     * @deprecated apenas para uso do hibernate
     */
    @Deprecated
    public Pizza() {
    }

    private void calcularPreco() {
        this.preco.add(PRECO_MASSA);
        this.preco.add(PRECO_MAO_DE_OBRA);
        this.ingredientes.stream()
                .map(Ingrediente::getPreco)
                .forEach(preco::add);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
