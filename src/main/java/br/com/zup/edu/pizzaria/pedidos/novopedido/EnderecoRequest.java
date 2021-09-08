package br.com.zup.edu.pizzaria.pedidos.novopedido;

import br.com.zup.edu.pizzaria.pedidos.Endereco;

public class EnderecoRequest {

    private String rua;
    private String numero;
    private String complemento;
    private String cep;

    /**
     * @deprecated para uso dos frameworks
     */
    @Deprecated
    public EnderecoRequest() { }

    public EnderecoRequest(String rua,
                           String numero,
                           String complemento,
                           String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco paraEndereco() {

        return new Endereco(rua, numero, complemento, cep);
    }
}
