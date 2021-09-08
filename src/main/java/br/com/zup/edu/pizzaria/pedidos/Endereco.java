package br.com.zup.edu.pizzaria.pedidos;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    /**
     * @deprecated para uso do hibernate apenas
     */
    @Deprecated
    public Endereco() { }

    public Endereco(String rua,
                    String numero,
                    String complemento,
                    String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }
}
